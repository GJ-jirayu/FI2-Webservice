package th.ac.fi2.repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Parameter;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import th.ac.fi2.constant.ServiceConstant;
import th.ac.fi2.domain.FishingVessel;
import th.ac.fi2.domain.ShipMachine;
import th.ac.fi2.domain.ShipOwner;
import th.ac.fi2.model.UpdateFishingVesselMsg;

@Repository("fi2Repository")
@Transactional(transactionManager="transactionManagerOdoo")
public class FI2Repository {
	private static final Logger logger = Logger.getLogger(ServiceConstant.LOG_APPENDER);
	@Autowired
	@PersistenceContext(unitName = "HibernatePersistenceUnitEL")
	private EntityManager entityManager;
	
	@Autowired
	@PersistenceContext(unitName= "HibernatePersistenceUnitOdooEL") //type=PersistenceContextType.EXTENDED
	private EntityManager entityManagerOdoo;
	private EntityTransaction entityManagerOdooTrans = null;

	private Date convertDateStrToDateSql(String dateStr) {
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date date;
		java.sql.Date dateSql = null;
		try {
			date = format.parse(dateStr);
			dateSql = new java.sql.Date(date.getTime());			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dateSql;
	}
	
	//private Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
	//private Date currentQlDate = new java.sql.Date(utilDate.getTime());

	
	/* -----------------------------------------------------------------------------------------------------------------
	 * Fishing Vessel From MD Server
	 * @author Wirun Pengsri (GJ)
	 * -----------------------------------------------------------------------------------------------------------------
	 */
	
	public Boolean getMdExistFishingVesselByShipSerial(String shipSerial){
		
		StringBuffer qryStr = new StringBuffer(
				"select '1' ,ship_serial From ws_reg_ship where ship_serial = :ship_serial"
				);
		Query query = entityManager.createNativeQuery(qryStr.toString());
		query.setParameter("ship_serial", shipSerial);
		List<Object[]> obj = query.getResultList();
		int result_size = obj.size();
		
		Boolean existResult = (result_size > 0 ? true : false); 
		return existResult;
	}
	
	public List<UpdateFishingVesselMsg> updateActiveFishingVessel(String shipSerial) throws DataAccessException{
		Integer updateStatus = null;
		String updateStatusDesc = null;
		try{ 
			Query querySe = entityManagerOdoo.createQuery(
					"select f from FishingVessel f where f.shipSerial = :ship_serial"
					);
			querySe.setParameter("ship_serial", Integer.parseInt(shipSerial));
			List<FishingVessel> obj = querySe.getResultList();
			for (FishingVessel fishingVessel : obj) {
				fishingVessel.setActive(Boolean.FALSE);				
				entityManagerOdoo.merge(fishingVessel);				
				}			
			updateStatus = 1;
			updateStatusDesc = "Updated succesfully";
		}
		catch (Exception e) {
			// TODO: handle exception
			updateStatus = 0;
			updateStatusDesc = "Sorry there was an error updating : "+e.getMessage();
		}
		
		List<UpdateFishingVesselMsg> updateFishingVesselMsgs = new ArrayList<UpdateFishingVesselMsg>();
		String action = "Update";
		String actionDesc = "update from fishing_vessel set active = false where ship_serial="+shipSerial;
		String status = updateStatus.toString();
		String statusDesc = updateStatusDesc;
		UpdateFishingVesselMsg	updateFishingVesselMsg = new UpdateFishingVesselMsg(action, actionDesc, status, statusDesc);
		updateFishingVesselMsgs.add(updateFishingVesselMsg);
		updateFishingVesselMsg.setPaging(null);
		
		return updateFishingVesselMsgs;
	}
	
	//public List<UpdateFishingVesselMsg> updateAllFieldFishingVessel(String shipSerial) throws DataAccessException{
	public String updateAllFieldFishingVessel(String shipSerial){
		String updateStatusDesc = null;
		try{
			StringBuffer sb = new StringBuffer(
					"SELECT \n"
					+"  CASE WHEN (rs.abort_dd IS NOT NULL AND isnumeric(rs.abort_dd) = 1) \n"
					+"    AND (rs.abort_mm IS NOT NULL AND isnumeric(rs.abort_mm) = 1) \n"
					+"    AND (rs.abort_yy IS NOT NULL AND isnumeric(rs.abort_yy) = 1)\n"
					+"    THEN \n"
					+"      CASE WHEN contdateistrue(rs.abort_dd, rs.abort_mm, rs.abort_yy) = 1 \n"
					+"        THEN rs.abort_dd||'-'||rs.abort_mm||'-'||to_char(to_number(rs.abort_yy)-543) \n"
					+"        ELSE NULL \n"
					+"      END \n"
					+"    ELSE NULL \n" 
					+"  END abort_date, \n"
					+"  rs.abort_flag, \n"
					+"  rs.book_allow_no, \n"
					+"  to_char(rs.book_allow_seq), \n"
					+"  rs.book_no, \n"
					+"  to_char(rs.book_seq), \n"
					+"  rs.build_ship_year, \n"
					+"  to_char(to_number(rs.build_ship_year)-543) build_ship_year_bc, \n"
					+"  rs.ship_flag call_name, \n"
					+"  rs.ship_flag call_name_en, \n"
					+"  to_char(rs.cap_cer), \n"
					+"  cer.full_name_th cap_certificate_level, \n"
					+"  rs.cap_ename	cap_ename, \n"
					+"  rs.cap_esurname	cap_esurname, \n"
					+"  rs.cap_name	cap_name, \n"
					+"  rs.cap_surname	cap_surname, \n"
					+"  to_char(rs.lastupdate AT TIME ZONE 'GMT', 'yyyy-MM-dd') create_date, \n"
					+"  CASE WHEN (rs.abort_dd IS NOT NULL AND isnumeric(rs.abort_dd) = 1) \n"
					+"	     AND (rs.abort_mm IS NOT NULL AND isnumeric(rs.abort_mm) = 1) \n"
					+"	     AND (rs.abort_yy IS NOT NULL AND isnumeric(rs.abort_yy) = 1) \n"
					+"		THEN \n"
					+"      CASE WHEN contdateistrue(rs.abort_dd, rs.abort_mm, rs.abort_yy) = 1 \n"
					+"        THEN rs.abort_dd||'-'||rs.abort_mm||'-'||to_char(to_number(rs.abort_yy)-543) \n"
					+"        ELSE NULL \n"
					+"      END \n"
					+"		ELSE NULL \n"
					+"	END date_abort, \n"
					+"  CASE WHEN (rs.per_exp_dd IS NOT NULL AND isnumeric(rs.per_exp_dd) = 1) \n"
					+"	     AND (rs.per_exp_mm IS NOT NULL AND isnumeric(rs.per_exp_mm) = 1) \n"
					+"	     AND (rs.per_exp_yy IS NOT NULL AND isnumeric(rs.per_exp_yy) = 1) \n"
					+"		THEN \n"
					+"      CASE WHEN contdateistrue(rs.per_exp_dd, rs.per_exp_mm, rs.per_exp_yy) = 1 \n"
					+"        THEN rs.per_exp_dd||'-'||rs.per_exp_mm||'-'||to_char(to_number(rs.per_exp_yy)-543) \n"
					+"        ELSE NULL \n"
					+"      END \n"
					+"		ELSE NULL \n"
					+"	END date_expire, \n"
					+"  CASE WHEN (rs.permit_dd IS NOT NULL AND isnumeric(rs.permit_dd) = 1) \n"
					+"	     AND (rs.permit_mm IS NOT NULL AND isnumeric(rs.permit_mm) = 1) \n"
					+"	     AND (rs.permit_yy IS NOT NULL AND isnumeric(rs.permit_yy) = 1) \n"
					+"		THEN  \n"
					+"      CASE WHEN contdateistrue(rs.permit_dd, rs.permit_mm, rs.permit_yy) = 1 \n"
					+"        THEN rs.permit_dd||'-'||rs.permit_mm||'-'||to_char(to_number(rs.permit_yy)-543) \n"
					+"        ELSE NULL \n"
					+"      END \n"
					+"		ELSE NULL \n"
					+"	END date_permit, \n"
					+"  CASE WHEN (rs.reg_dd IS NOT NULL AND isnumeric(rs.reg_dd) = 1) \n"
					+"	     AND (rs.reg_mm IS NOT NULL AND isnumeric(rs.reg_mm) = 1) \n"
					+"	     AND (rs.reg_yy IS NOT NULL AND isnumeric(rs.reg_yy) = 1) \n"
					+"		THEN \n"
					+"     CASE WHEN contdateistrue(rs.reg_dd, rs.reg_mm, rs.reg_yy) = 1 \n"
					+"        THEN rs.reg_dd||'-'||rs.reg_mm||'-'||to_char(to_number(rs.reg_yy)-543) \n"
					+"        ELSE NULL \n"
					+"      END \n"
					+"		ELSE NULL \n"
					+"	END date_reg, \n"
					+"  CASE WHEN (rs.regth_dd IS NOT NULL AND isnumeric(rs.regth_dd) = 1) \n"
					+"	     AND (rs.regth_mm IS NOT NULL AND isnumeric(rs.regth_mm) = 1) \n"
					+"	     AND (rs.regth_yy IS NOT NULL AND isnumeric(rs.regth_yy) = 1) \n"
					+"		THEN \n"
					+"      CASE WHEN contdateistrue(rs.regth_dd, rs.regth_mm, rs.regth_yy) = 1 \n"
					+"        THEN rs.regth_dd||'-'||rs.regth_mm||'-'||to_char(to_number(rs.regth_yy)-543) \n"
					+"        ELSE NULL \n"
					+"      END \n"
					+"		ELSE NULL \n"
					+"	END date_regth, \n"
					+"  CASE WHEN (rs.shipmortgage_dd IS NOT NULL AND isnumeric(rs.shipmortgage_dd) = 1) \n"
					+"	     AND (rs.shipmortgage_mm IS NOT NULL AND isnumeric(rs.shipmortgage_mm) = 1) \n" 
					+"	     AND (rs.shipmortgage_yy IS NOT NULL AND isnumeric(rs.shipmortgage_yy) = 1) \n"
					+"		THEN \n"
					+"      CASE WHEN contdateistrue(rs.shipmortgage_dd, rs.shipmortgage_mm, rs.shipmortgage_yy) = 1 \n"
					+"        THEN rs.shipmortgage_dd||'-'||rs.shipmortgage_mm||'-'||to_char(to_number(rs.shipmortgage_yy)-543) \n"
					+"        ELSE NULL \n"
					+"      END \n"
					+"		ELSE NULL \n"
					+"	END date_shipmortgage, \n"
					+"  CASE WHEN (rs.shipstatus_dd IS NOT NULL AND isnumeric(rs.shipstatus_dd) = 1) \n"
					+"	     AND (rs.shipstatus_mm IS NOT NULL AND isnumeric(rs.shipstatus_mm) = 1) \n"
					+"	     AND (rs.shipstatus_yy IS NOT NULL AND isnumeric(rs.shipstatus_yy) = 1) \n"
					+"		THEN \n"
					+"      CASE WHEN contdateistrue(rs.shipstatus_dd, rs.shipstatus_mm, rs.shipstatus_yy) = 1 \n"
					+"        THEN rs.shipstatus_dd||'-'||rs.shipstatus_mm||'-'||to_char(to_number(rs.shipstatus_yy)-543) \n"
					+"       ELSE NULL \n"
					+"      END \n"
					+"		ELSE NULL \n"
					+"	END date_shipstatus, \n"
					+"  CASE WHEN (rs.tl_dd IS NOT NULL AND isnumeric(rs.tl_dd) = 1) \n"
					+"	     AND (rs.tl_mm IS NOT NULL AND isnumeric(rs.tl_mm) = 1) \n"
					+"	     AND (rs.tl_yy IS NOT NULL AND isnumeric(rs.tl_yy) = 1) \n"
					+"		THEN \n"
					+"      CASE WHEN contdateistrue(rs.tl_dd, rs.tl_mm, rs.tl_yy) = 1 \n"
					+"        THEN rs.tl_dd||'-'||rs.tl_mm||'-'||to_char(to_number(rs.tl_yy)-543) \n"
					+"        ELSE NULL \n"
					+"      END \n"
					+"		ELSE NULL \n"
					+"	END date_tl, \n"
					+"  CASE WHEN (rs.tl_exp_dd IS NOT NULL AND isnumeric(rs.tl_exp_dd) = 1) \n"
					+"	     AND (rs.tl_exp_mm IS NOT NULL AND isnumeric(rs.tl_exp_mm) = 1) \n"
					+"	     AND (rs.tl_exp_yy IS NOT NULL AND isnumeric(rs.tl_exp_yy) = 1) \n"
					+"		THEN \n"
					+"      CASE WHEN contdateistrue(rs.tl_exp_dd, rs.tl_exp_mm, rs.tl_exp_yy) = 1 \n"
					+"        THEN rs.tl_exp_dd||'-'||rs.tl_exp_mm||'-'||to_char(to_number(rs.tl_exp_yy)-543) \n"
					+"        ELSE NULL \n"
					+"      END \n"
					+"		ELSE NULL \n"
					+"	END date_tl_exp, \n"
					+"  CASE WHEN (rs.usestatus_dd IS NOT NULL AND isnumeric(rs.usestatus_dd) = 1) \n"
					+"	     AND (rs.usestatus_mm IS NOT NULL AND isnumeric(rs.usestatus_mm) = 1) \n"
					+"	     AND (rs.usestatus_yy IS NOT NULL AND isnumeric(rs.usestatus_yy) = 1) \n"
					+"		THEN \n"
					+"      CASE WHEN contdateistrue(rs.usestatus_dd, rs.usestatus_mm, rs.usestatus_yy) = 1 \n"
					+"        THEN rs.usestatus_dd||'-'||rs.usestatus_mm||'-'||to_char(to_number(rs.usestatus_yy)-543) \n"
					+"        ELSE NULL \n"
					+"      END \n"
					+"		ELSE NULL \n"
					+"	END date_usestatus, \n"
					+"  to_char(rs.depth)	depth, \n"
					+"  rs.registrar_edit	edit_registrar , \n"
					+"  to_char(rs.egn_cer)	egn_cer , \n"
					+"  egn.full_name_th	egn_certificate_level , \n"
					+"  rs.egn_ename	egn_ename , \n"
					+"  rs.egn_esurname	egn_esurname , \n"
					+"  rs.egn_name	egn_name , \n"
					+"  rs.egn_surname	egn_surname , \n"
					+"  rs.eng_name	eng_name , \n"
					+"  rs.garage	garage , \n"
					+"  rs.head_pic	head_pic , \n"
					+"  to_char(0) id , \n"
					+"  rs.imo_no	imo_no , \n"
					+"  clre.full_name	loc_reg , \n"
					+"  to_char(rs.loc_reg)	loc_reg_fkid , \n"
					+"  cl.full_name	loc_serial , \n"
					+"  to_char(rs.machine_cost)	machine_cost , \n"
					+"  to_char(rs.machine_price_unit)	machine_price_unit , \n"
					+"  rsm.matter_type_name	matter_type , \n"
					+"  rsm.ematter_type_name	matter_type_eng , \n"
					+"  to_char(rs.no_of_deck)	no_of_deck , \n"
					+"  to_char(rs.no_of_feaman)	no_of_feaman , \n"
					+"  to_char(rs.no_of_machine)	no_of_machine , \n"
					+"  to_char(rs.no_of_mast)	no_of_mast , \n"
					+"  to_char(rs.no_of_person)	no_of_person , \n"
					+"  to_char(rs.no_of_screw)	no_of_screw , \n"
					+"  to_char(rs.no_of_tube)	no_of_tube , \n"
					+"  rs.owner_name	owner_name , \n"
					+"  rs.owner_surname	owner_surname , \n"
					+"  to_char(ro.owner_type)	owner_type_fkid , \n"
					+"  rs.registrar	registrar , \n"
					+"  recl.full_name	regth_loc , \n"
					+"  rs.regth_registrar	regth_registrar , \n"
					+"  rs.remark_other	remark , \n"
					+"  rs.remark_print_en	remark_print_en , \n"
					+"  rs.remark_print_th	remark_print_th , \n"
					+"  rs.ship_allow	ship_allow , \n"
					+"  rs.garage	ship_build_loc , \n"
					+"  rs.garage	ship_build_loc_eng , \n"
					+"  rs.ship_code	ship_code , \n"
					+"  to_char(rs.ship_cost)	ship_cost , \n"
					+"  rs.ship_eng_type	ship_eng_type , \n"
					+"  rs.ship_flag	ship_flag , \n" 
					+"  to_char(rs.ship_length)	ship_length , \n"
					+"  to_char(rs.ship_length1)	ship_length1 , \n"
					+"  to_char(rs.ship_price_unit)	ship_price_unit , \n"
					+"  to_char(rs.ship_serial)	ship_serial , \n"
					+"  st.ship_status_name	ship_status , \n"
					+"  rst.ship_type_name	ship_type , \n"
					+"  rs.tail_pic	tail_pic, --characterr , \n"
					+"  to_char(rs.tgross)	tgross , \n"
					+"  rs.tha_name	tha_name , \n"
					+"  rs.tl_no	tl_no , \n"
					+"  to_char(rs.tnet)	tnet , \n"
					+"  to_char(rs.ton)	ton , \n"
					+"  to_char(rs.total_cost)	total_cost , \n"
					+"  to_char(rs.total_price_unit)	total_price_unit , \n"
					+"  to_char(rs.use_bound)	use_bound , \n"
					+"  ru.use_bound_name	use_bound_str , \n"
					+"  to_char(rs.use_depth)	use_depth , \n"
					+"  ut.ship_status_name	use_status , \n"
					+"  to_char(rs.use_status)	use_status_pfk , \n"
					+"  rut.use_type_name	use_type , \n"
					+"  rut.use_type_name_eng	use_type_eng , \n"
					+"  to_char(rs.use_type)	use_type_fkid , \n"
					+"  rs.usebound_desc	usebound_desc , \n"
					+"  rs.usebound_desc_en	usebound_desc_en , \n"
					+"  to_char(rs.width)	width , \n"
					+"  to_char(systimestamp AT TIME ZONE 'GMT', 'yyyy-MM-dd hh24:mi:ss') write_date, \n"
					+"  rs.ship_status ship_status_fkid, \n"
					+"  rs.ship_type ship_type_fkid, \n"
					+"  ro.owner_type_name owner_type \n"
					+"FROM ws_reg_ship rs \n"
					+"LEFT JOIN ws_reg_shiptype rst ON rst.ship_type = rs.ship_type \n"
					+"LEFT JOIN ws_reg_usetype rut ON rut.use_type = rs.use_type \n"
					+"LEFT JOIN ws_reg_shipmade rsm ON rsm.matter_type = rs.matter_type \n"
					+"LEFT JOIN ws_cer_location cl ON cl.loc_serial = rs.loc_serial \n"
					+"LEFT JOIN ws_cer_location recl ON recl.loc_serial = rs.regth_loc \n"
					+"LEFT JOIN ws_cer_location clre ON clre.loc_serial = rs.loc_reg \n"
					+"LEFT JOIN ws_reg_shipstatus st ON st.ship_status = rs.ship_status \n"
					+"LEFT JOIN ws_reg_owner ro ON ro.owner_type = rs.owner_type \n"
					+"LEFT JOIN ws_cer_cerlevel cer ON cer.LEVEL_SEQ = rs.cap_cer \n"
					+"LEFT JOIN ws_cer_cerlevel egn ON egn.LEVEL_SEQ = rs.egn_cer \n"
					+"LEFT JOIN ws_reg_usebound ru on ru.use_bound = rs.use_bound \n"
					+"LEFT JOIN ws_reg_shipstatus ut ON ut.ship_status = rs.use_status \n"
					+"WHERE rs.ship_serial = :ship_serial"
				);

			Query query = entityManager.createNativeQuery(sb.toString());
			query.setParameter("ship_serial", shipSerial);
			FishingVessel fishingVessel = new FishingVessel();
			
			List<Object[]> obj = query.getResultList();			
			for (Object[] results : obj) {
				fishingVessel.setAbortDate(((results[0] != null) ? convertDateStrToDateSql(results[0].toString()) : null));
				fishingVessel.setAbortFlag(((results[1] != null) ? results[1].toString() : null));
				fishingVessel.setBookAllowNo(((results[2] != null) ? (results[2]).toString() : null));
				fishingVessel.setBookAllowSeq(((results[3] != null) ? (results[3]).toString() : null));
				fishingVessel.setBookNo(((results[4] != null) ? (results[4]).toString() : null));
				fishingVessel.setBookSeq(((results[5] != null) ? (results[5]).toString() : null));
				fishingVessel.setBuildShipYear(((results[6] != null) ? (results[6]).toString() : null));
				fishingVessel.setBuildShipYearBc(((results[7] != null) ? (results[7]).toString() : null));
				fishingVessel.setCalName(((results[8] != null) ? (results[8]).toString() : null));
				fishingVessel.setCallNameEn(((results[9] != null) ? (results[9]).toString() : null));
				fishingVessel.setCapCer(((results[10] != null) ? Integer.parseInt(results[10].toString()) : null));
				
				fishingVessel.setCapCertificateLevel(((results[11] != null) ? (results[11]).toString() : null));
				fishingVessel.setCapEname(((results[12] != null) ? (results[12]).toString() : null));
				fishingVessel.setCapEsurname(((results[13] != null) ? (results[13]).toString() : null));
				fishingVessel.setCapName(((results[14] != null) ? (results[14]).toString() : null));
				fishingVessel.setCapSurname(((results[15] != null) ? (results[15]).toString() : null));
				fishingVessel.setCreateDate( ((results[16] != null) ? Date.valueOf((String)results[16]) : null));
				fishingVessel.setDateAbort( ((results[17] != null) ? convertDateStrToDateSql(results[17].toString()) : null));
				fishingVessel.setDateExpire( ((results[18] != null) ? convertDateStrToDateSql(results[18].toString()) : null));
				fishingVessel.setDatePermit( ((results[19] != null) ? convertDateStrToDateSql(results[19].toString()) : null));
				fishingVessel.setDateReg( ((results[20] != null) ? convertDateStrToDateSql(results[20].toString()) : null));

				fishingVessel.setDateRegth( ((results[21] != null) ? convertDateStrToDateSql(results[21].toString()) : null));
				fishingVessel.setDateShipmortgage( ((results[22] != null) ? convertDateStrToDateSql(results[22].toString()) : null));
				fishingVessel.setDateShipstatus( ((results[23] != null) ? convertDateStrToDateSql(results[23].toString()) : null));
				fishingVessel.setDateTl( ((results[24] != null) ? convertDateStrToDateSql(results[24].toString()) : null));
				fishingVessel.setDateTlExp( ((results[25] != null) ? convertDateStrToDateSql(results[25].toString()) : null));
				fishingVessel.setUseStatus(((results[26] != null) ? (results[26]).toString() : null));
				fishingVessel.setDepth(((results[27] != null) ? Double.parseDouble(results[27].toString()) : null));
				fishingVessel.setEditRegistrar(((results[28] != null) ? results[28].toString() : null));
				fishingVessel.setEgnCer(((results[29] != null) ? Integer.parseInt(results[29].toString()) : null));
				fishingVessel.setEgnCertificateLevel(((results[30] != null) ? results[30].toString() : null));

				fishingVessel.setEgnEname(((results[31] != null) ? results[31].toString() : null));
				fishingVessel.setEgnEsurname(((results[32] != null) ? results[32].toString() : null));
				fishingVessel.setEgnName(((results[33] != null) ? results[33].toString() : null));
				fishingVessel.setEgnSurname(((results[34] != null) ? results[34].toString() : null));
				fishingVessel.setEngName(((results[35] != null) ? results[35].toString() : null));
				fishingVessel.setGarage(((results[36] != null) ? results[36].toString() : null));
				fishingVessel.setHeadPic(((results[37] != null) ? results[37].toString() : null));
				//fishingVessel.setId(((results[38] != null) ? Integer.parseInt(results[38].toString()) : null));
				fishingVessel.setImoNo(((results[39] != null) ? results[39].toString() : null));
				fishingVessel.setLocReg(((results[40] != null) ? results[40].toString() : null));

				fishingVessel.setLocRegFkid(((results[41] != null) ? Integer.parseInt(results[41].toString()) : null));
				fishingVessel.setLocSerial(((results[42] != null) ? results[42].toString() : null));
				fishingVessel.setMachineCost(((results[43] != null) ? Double.parseDouble(results[43].toString()) : null));
				fishingVessel.setMachinePriceUnit(((results[44] != null) ? results[44].toString() : null));
				fishingVessel.setMatterType(((results[45] != null) ? results[45].toString() : null));
				fishingVessel.setMatterTypeEng(((results[46] != null) ? results[46].toString() : null));
				fishingVessel.setNoOfDeck(((results[47] != null) ? Integer.parseInt(results[47].toString()) : null));
				fishingVessel.setNoOfFeaman(((results[48] != null) ? Integer.parseInt(results[48].toString()) : null));
				fishingVessel.setNoOfMachine(((results[49] != null) ? Integer.parseInt(results[49].toString()) : null));
				fishingVessel.setNoOfMast(((results[50] != null) ? Integer.parseInt(results[50].toString()) : null));

				fishingVessel.setNoOfPerson(((results[51] != null) ? Integer.parseInt(results[51].toString()) : null));
				fishingVessel.setNoOfScrew(((results[52] != null) ? Integer.parseInt(results[52].toString()) : null));
				fishingVessel.setNoOfTube(((results[53] != null) ? Integer.parseInt(results[53].toString()) : null));
				fishingVessel.setOwnerName(((results[54] != null) ? results[54].toString() : null));
				fishingVessel.setOwnerSurname(((results[55] != null) ? results[55].toString() : null));
				fishingVessel.setOwnerTypeFkid(((results[56] != null) ? Integer.parseInt(results[56].toString()) : null));
				fishingVessel.setRegistrar(((results[57] != null) ? results[57].toString() : null));
				fishingVessel.setRegthLoc(((results[58] != null) ? results[58].toString() : null));
				fishingVessel.setRegthRegistrar(((results[59] != null) ? results[59].toString() : null));
				fishingVessel.setRemark(((results[60] != null) ? results[60].toString() : null));
				
				fishingVessel.setRemarkPrintEn(((results[61] != null) ? results[61].toString() : null));
				fishingVessel.setRemarkPrintTh(((results[62] != null) ? results[62].toString() : null));
				fishingVessel.setShipAllow(((results[63] != null) ? results[63].toString() : null));
				fishingVessel.setShipBuildLoc(((results[64] != null) ? results[64].toString() : null));
				fishingVessel.setShipBuildLocEng(((results[65] != null) ? results[65].toString() : null));
				fishingVessel.setShipCode(((results[66] != null) ? results[66].toString() : null));
				fishingVessel.setShipCost(((results[67] != null) ? Double.parseDouble(results[67].toString()) : null));
				fishingVessel.setShipEngType(((results[68] != null) ? results[68].toString() : null));
				fishingVessel.setShipFlag(((results[69] != null) ? results[69].toString() : null));
				fishingVessel.setShipLength(((results[70] != null) ? Double.parseDouble(results[70].toString()) : null));

				fishingVessel.setShipLength1(((results[71] != null) ? Double.parseDouble(results[71].toString()) : null));
				fishingVessel.setShipPriceUnit(((results[72] != null) ? results[72].toString() : null));
				fishingVessel.setShipSerial(((results[73] != null) ? Integer.parseInt(results[73].toString()) : null));
				fishingVessel.setShipStatus(((results[74] != null) ? results[74].toString() : null));
				fishingVessel.setShipType(((results[75] != null) ? results[75].toString() : null));
				fishingVessel.setTailPic(((results[76] != null) ? results[76].toString() : null));
				fishingVessel.setTgross(((results[77] != null) ? Double.parseDouble(results[77].toString()) : null));
				fishingVessel.setThaName(((results[78] != null) ? results[78].toString() : null));
				fishingVessel.setTlNo(((results[79] != null) ? results[79].toString() : null));
				fishingVessel.setTnet(((results[80] != null) ? Double.parseDouble(results[80].toString()) : null));
				
				fishingVessel.setTon(((results[81] != null) ? Double.parseDouble(results[81].toString()) : null));
				fishingVessel.setTotalCost(((results[82] != null) ? Double.parseDouble(results[82].toString()) : null));
				fishingVessel.setTotalPriceUnit(((results[83] != null) ? results[83].toString() : null));
				fishingVessel.setUseBound(((results[84] != null) ? Integer.parseInt(results[84].toString()) : null));
				fishingVessel.setUseBoundStr(((results[85] != null) ? results[85].toString() : null));
				fishingVessel.setUseDepth(((results[86] != null) ? Double.parseDouble(results[86].toString()) : null));
				fishingVessel.setUseStatus(((results[87] != null) ? results[87].toString() : null));
				fishingVessel.setUseStatusPfk(((results[88] != null) ? Integer.parseInt(results[88].toString()) : null));
				fishingVessel.setUseType(((results[89] != null) ? results[89].toString() : null));
				fishingVessel.setUseTypeEng(((results[90] != null) ? results[90].toString() : null));

				fishingVessel.setUseTypeFkid(((results[91] != null) ? Integer.parseInt(results[91].toString()) : null));
				fishingVessel.setUseboundDesc(((results[92] != null) ? results[92].toString() : null));
				fishingVessel.setUseboundDescEn(((results[93] != null) ? results[93].toString() : null));
				fishingVessel.setWidth(((results[94] != null) ? Double.parseDouble(results[94].toString()) : null));
				fishingVessel.setWriteDate(((results[95] != null) ? Timestamp.valueOf((String) results[95]) : null));
				fishingVessel.setShipStatusFkid(((results[96] != null) ? Integer.parseInt(results[96].toString()) : null));
				fishingVessel.setShipTypeFkid(((results[97] != null) ? Integer.parseInt(results[97].toString()) : null));
				fishingVessel.setOwnerType(((results[98] != null) ? results[98].toString() : null));
				fishingVessel.setActive(Boolean.TRUE);
				
				//logger.info("\n\n"+entityManagerOdoo.merge(fishingVessel)+"\n\n");}
				entityManagerOdoo.merge(fishingVessel);
			}
			
			updateStatusDesc = "SUCCESS";

		}catch (Exception e) {
			updateStatusDesc = e.getMessage();
			e.printStackTrace();
		}
		
		return updateStatusDesc;
	}
	
	
	/*Update Ship Owner*/
	public String updateShipOwner(String shipSerial) throws DataAccessException{
		String msgProcess;
		try {
			StringBuffer sb = new StringBuffer(
					"select \n"
					+"rs.ship_serial ship_serial_id, \n"
					+"rs.seq, \n"
					+"rs.name, \n"
					+"rs.citizen_code citizen_fkid, \n"
					+"nat.citizen_name citizen, \n"
					+"rs.surname, \n"
					+"CASE WHEN rs.title_code != ' ' AND rs.title_code IS NOT NULL \n"
					+"	THEN rs.title_code \n"
					+"	ELSE '0' \n"
					+"END title_fkid, \n"
					+"NULL title, \n"
					+"rs.address, \n"
					+"rs.career, \n"
					+"rs.username, \n"
					+"to_char(rs.lastupdate AT TIME ZONE 'GMT', 'yyyy-MM-dd') lastupdate_datasouce, \n"
					+"rs.id pin, \n"
					+"rs.doc_reffer, \n"
					+"case when rs.transfer_dd is not null and rs.transfer_mm is not null and rs.transfer_yy is not null \n"
					+"	THEN CASE WHEN to_char(to_number(rs.transfer_yy, '9999')-543) LIKE '%-%' \n"
					+"		then to_char(to_date('01-01-0001', 'DD/MM/YYYY'), 'DD/MM/YYYY') \n"
					+"		ELSE TO_char(to_date(rs.transfer_dd||'/'||rs.transfer_mm||'/'||to_char(to_number(rs.transfer_yy, '9999')-543), 'DD/MM/YYYY'), 'DD/MM/YYYY') \n"
					+"		END \n"
					+"	ELSE NULL \n"
					+"END date_transfer, \n"
					+"rs.owner_prov, \n"
					+"rs.owner_amp, \n"
					+"rs.ename, \n"
					+"rs.esurname, \n"
					+"rs.promise_no, \n"
					+"rs.promise_yy, \n"
					+"rs.loc_promise, \n"
					+"rs.owner_seq, \n"
					+"rs.signature_path, \n"
					+"rs.address_en, \n"
					+"rs.remark, \n"
					+"to_char(systimestamp AT TIME ZONE 'GMT', 'yyyy-MM-dd hh24:mi:ss') \n"
				+"from ws_reg_shipowner rs \n"
				+"left join ws_cer_national nat on nat.citizen_code = rs.citizen_code \n"
				+"where rs.ship_serial = :ship_serial "
				//+"and rs.seq = (select max(seq) from ws_reg_shipowner where ship_serial = :ship_serial) "
					);
			Query query = entityManager.createNativeQuery(sb.toString());
			query.setParameter("ship_serial", shipSerial);			
			
			ShipOwner shipOwner = new ShipOwner();
			List<Object[]> obj = query.getResultList();			
			for (Object[] results : obj) {	
				String fishingVesselId = getIdFishingVessel(results[0].toString());
				//logger.info("\n"+fishingVesselId+"\n");
				shipOwner.setShipSerialId(((results[0] != null) ? Integer.parseInt(fishingVesselId) : null));
				shipOwner.setSeq(((results[1] != null) ? Integer.parseInt(results[1].toString()) : null));
				shipOwner.setName(((results[2] != null) ? results[2].toString() : null));
				shipOwner.setCitizenFkid((((results[3] != null) ? Integer.parseInt(results[3].toString()) : null)));
				shipOwner.setCitizen(((results[4] != null) ? results[4].toString() : null));
				shipOwner.setSurname(((results[5] != null) ? results[5].toString() : null));
				
				shipOwner.setTitleFkid(((results[6] != null) ? results[6].toString() : null));
				shipOwner.setTitle(((results[7] != null) ? results[7].toString() : null));
				shipOwner.setAddress(((results[8] != null) ? results[8].toString() : null));
				shipOwner.setCareer(((results[9] != null) ? results[9].toString() : null));
				shipOwner.setUsername(((results[10] != null) ? results[10].toString() : null));
				
				shipOwner.setDateLastupdate(((results[11] != null) ? Date.valueOf( (String) results[11]) : null));
				shipOwner.setPinCharacter(((results[12] != null) ? results[12].toString() : null));
				shipOwner.setDocRefer(((results[13] != null) ? results[13].toString() : null));
				shipOwner.setDateTransfer(((results[14] != null) ? results[14].toString() : null));
				shipOwner.setOwnerProv(((results[15] != null) ? results[15].toString() : null));
				
				shipOwner.setOwnerAmp(((results[16] != null) ? results[16].toString() : null));
				shipOwner.setEname(((results[17] != null) ? results[17].toString() : null));
				shipOwner.setEsurname(((results[18] != null) ? results[18].toString() : null));
				shipOwner.setPromiseNo(((results[19] != null) ? results[19].toString() : null));
				shipOwner.setPromiseYy(((results[20] != null) ? results[20].toString() : null));
				
				shipOwner.setLocPromiss(((results[21] != null) ? results[21].toString() : null));
				shipOwner.setOwnerSeq(((results[22] != null) ? results[22].toString() : null));
				shipOwner.setSignaturePath(((results[23] != null) ? results[23].toString() : null));
				shipOwner.setAddressEn(((results[24] != null) ? results[24].toString() : null));
				shipOwner.setRemark(((results[25] != null) ? results[25].toString() : null));
				shipOwner.setWriteDate(((results[26] != null) ? Timestamp.valueOf((String) results[26]) : null));
				shipOwner.setAction(Boolean.TRUE);
				
				entityManagerOdoo.merge(shipOwner);
			}
			msgProcess = "SUCCESS";
		} catch (Exception e) {
			e.printStackTrace();
			msgProcess = e.getMessage();
		}
		return msgProcess;
	}
	
	
	/*update ship machine*/ 
	public String updateShipMachine(String shipSerial) throws DataAccessException{
		String msgProcess;
		try {
			StringBuffer sb = new StringBuffer(
					"select \n" 
					+"  rs.ship_serial, \n"
					+"  rs.seq, \n"
					+"	rs.username, \n"
					+"	to_char(rs.lastupdate AT TIME ZONE 'GMT', 'yyyy-MM-dd') lastupdate, \n"
					+"	rs.power2, \n"
					+"	to_char(rs.lastupdate AT TIME ZONE 'GMT', 'yyyy-MM-dd hh:mm:ss') create_date, \n"
					+"	rs.machine_no, \n"
					+"	rs.machine_type, \n"
					+"	rs.machine_power1, \n"
					+"	rst.machine_type_name machine_type_str, \n"
					+"	rs.machine_power2, \n"
					+"	rs.no_of_piston, \n"
					+"	rs.machine_cost, \n"
					+"	rm.machine_name machine_brand_str, \n"
					+"	rs.machine_brand, \n"
					+"	rs.power1, \n"
					+"  to_char(systimestamp AT TIME ZONE 'GMT', 'yyyy-MM-dd hh24:mi:ss') \n"
					+"from ws_reg_shipmachine rs \n"
					+"left join ws_reg_machinetype rst on rst.machine_type = rs.machine_type \n"
					+"left join ws_reg_machine rm on rm.machine_brand = rs.machine_brand \n"
					+"where rs.ship_serial = :ship_serial "
					);
			
			Query query = entityManager.createNativeQuery(sb.toString());
			query.setParameter("ship_serial", shipSerial);
			ShipMachine shipMachine = new ShipMachine();
			
			List<Object[]> obj = query.getResultList();			
			for (Object[] results : obj) {
				String fishingVesselId = getIdFishingVessel(results[0].toString());
				shipMachine.setShipSerialId(((results[0] != null) ? Integer.parseInt(fishingVesselId) : null));
				
				shipMachine.setId(checkExistMachineValueBySerialSeq(fishingVesselId, results[1].toString()));
				shipMachine.setSeq(((results[1] != null) ? Integer.parseInt(results[1].toString()) : null));
				shipMachine.setUserName(((results[2] != null) ? results[2].toString() : null));
				shipMachine.setLastupdate(((results[3] != null) ? Date.valueOf( (String) results[3]) : null));
				shipMachine.setPower2(((results[4] != null) ? Double.parseDouble(results[4].toString()) : null));
				shipMachine.setCreateDate(((results[5] != null) ? Timestamp.valueOf( (String) results[5]) : null));
				shipMachine.setMachineNo(((results[6] != null) ? results[6].toString() : null));
				shipMachine.setMachineTypeFkid(((results[7] != null) ? Integer.parseInt(results[7].toString()) : null));
				shipMachine.setMachinePower1(((results[8] != null) ? Double.parseDouble(results[8].toString()) : null));
				shipMachine.setMachineTypeStr(((results[9] != null) ? results[9].toString() : null));
				shipMachine.setMachinePower2(((results[10] != null) ? Double.parseDouble(results[10].toString()) : null));
				shipMachine.setNoOfPiston(((results[11] != null) ? Integer.parseInt(results[11].toString()) : null));
				shipMachine.setMachineCost(((results[12] != null) ? Double.parseDouble(results[12].toString()) : null));
				shipMachine.setMachineBrandStr(((results[13] != null) ? results[13].toString() : null));
				shipMachine.setMachineBrandFkid(((results[14] != null) ? Integer.parseInt(results[14].toString()) : null));
				shipMachine.setPower1(((results[15] != null) ? Double.parseDouble(results[15].toString()) : null));
				//shipMachine.setWriteDate(((results[16] != null) ? Timestamp.valueOf((String) results[16]) : null));
				shipMachine.setWriteDate(new Timestamp(System.currentTimeMillis()));
				shipMachine.setActive(Boolean.TRUE);
				
				//System.out.println("fishingVesselId --> "+shipMachine.getShipSerialId());
				//System.out.println("seq --> "+shipMachine.getSeq());
				//System.out.println("id --> "+shipMachine.getId());
				entityManagerOdoo.merge(shipMachine);
				
			}
			msgProcess = "SUCCESS";
			
		} catch (Exception e) {
			e.printStackTrace();
			msgProcess = e.getMessage();
		}		
		return msgProcess;
	}
	
	
	
	/*Get Id from fishing_vessel*/ 
	private String getIdFishingVessel(String shipSerial) throws DataAccessException{
		try{ 
			Query queryStr = entityManagerOdoo.createNativeQuery(
					"select id from fishing_vessel where ship_serial = :ship_serial"
					);
			queryStr.setParameter("ship_serial", Integer.parseInt(shipSerial));
			String fishingVesselId = queryStr.getSingleResult().toString();	
			return fishingVesselId;
		}
		catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
			return "0";
		}		
	}

	/*Check value existing in ship_owner*/
	private Integer checkExistingValueBySerialSeq(String shipSerialId, String seq) throws DataAccessException {
		try {
			Query queryStr = entityManagerOdoo
					.createNativeQuery("select id from ship_owner where ship_serial_id = :shipSerialId and seq = :seq")
					.setParameter("shipSerialId", Integer.parseInt(shipSerialId))
					.setParameter("seq", Integer.parseInt(seq));
			List<?> resulList = queryStr.getResultList();
			
			if(!resulList.isEmpty()){
				//Integer fishingVesselId = Integer.parseInt(queryStr.getSingleResult().toString());
				return Integer.parseInt(queryStr.getSingleResult().toString());
			}else{				
				return 0;
			}			
			//return fishingVesselId;
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
	
	/*Check value existing in ship_machine*/
	private Integer checkExistMachineValueBySerialSeq(String shipSerialId, String seq) throws DataAccessException {
		try {
			Query queryStr = entityManagerOdoo
					.createNativeQuery("select max(id) from ship_machine where ship_serial_id = :shipSerialId and seq = :seq")
					.setParameter("shipSerialId", Integer.parseInt(shipSerialId))
					.setParameter("seq", Integer.parseInt(seq));
			List<?> resulList = queryStr.getResultList();
			
			if(!resulList.isEmpty()){
				return Integer.parseInt(queryStr.getSingleResult().toString());
			}else{
				return 0;
			}
		} catch (Exception e) {
			//logger.info(e.getMessage());
			//e.printStackTrace();
			return 0;
		}
	}
}