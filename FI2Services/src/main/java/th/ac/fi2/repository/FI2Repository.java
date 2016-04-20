package th.ac.fi2.repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import th.ac.fi2.constant.ServiceConstant;
import th.ac.fi2.model.DOFWarRoomFishingToolM;
import th.ac.fi2.model.FishingLicenseInfo;
import th.ac.fi2.model.FishingVesselInfo;
import th.ac.fi2.model.FishingVesselM;
import th.ac.fi2.model.FishingVesselMD;
import th.ac.fi2.model.ShipOwnerHist;

@Repository("fi2Repository")
@Transactional(readOnly = false)
public class FI2Repository {
	private static final Logger logger = Logger.getLogger(ServiceConstant.LOG_APPENDER);
	@Autowired
	
	@PersistenceContext(unitName = "HibernatePersistenceUnit", type=PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;
	
	@PersistenceContext(unitName = "HibernatePersistenceUnitOdoo", type=PersistenceContextType.TRANSACTION)
	private EntityManager entiryManagerFI2;

	//private Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
	//private Date currentQlDate = new java.sql.Date(utilDate.getTime());
	
	@SuppressWarnings("unchecked")
	public List<FishingVesselM> getFishingVesselByShipCode(String shipCode) {

		StringBuffer sb = new StringBuffer("select tha_name as boatName, ship_code as boatRegNo, \n"
				+ "concat(fishing_vessel.owner_name,' ',owner_surname) as ownerName, \n"
				+ "ship_length1 as boatLong, width as boatWide, depth as deep, \n"
				+ "ship_eng_type as boatTypeEngine, tgross as tonGross, \n"
				+ "no_of_machine as noofMachine, date_permit, date_expire \n" 
				+ "from fishing_vessel \n"
				+ "where ship_code = :ship_code ");

		Query query = entiryManagerFI2.createNativeQuery(sb.toString());
		query.setParameter("ship_code", shipCode);
		
		logger.info("\n -- getFishingVesselByShipCode --> " + sb.toString() + "\n");
		
		List<Object[]> obj = query.getResultList();
		int result_size = obj.size();
		List<FishingVesselM> fishingVesselMs = new ArrayList<FishingVesselM>(result_size);
		if (obj != null && result_size > 0) {
			for (int i = 0; i < result_size; i++) {
				Object[] results = obj.get(i);

				String boatName = ((results[0] != null) ? ((String) results[0]) : (""));
				String boatRegNo = ((results[1] != null) ? ((String) results[1]) : (""));
				String ownerName = ((results[2] != null) ? ((String) results[2]) : (""));
				Double boatLong = ((results[3] != null) ? ((Double) results[3]) : null);
				Double boatWide = ((results[4] != null) ? ((Double) results[4]) : null);
				Double deep = ((results[5] != null) ? ((Double) results[5]) : null);
				String boatTypeEngine = ((results[6] != null) ? ((String) results[6]) : (""));
				Double tonGross = ((results[7] != null) ? ((Double) results[7]) : null);
				Integer noofMachine = ((results[8] != null) ? ((Integer) results[8]) : null);
				Date date_permit = ((results[9] != null) ? ((Date) results[9]) : null);
				Date date_expire = ((results[10] != null) ? ((Date) results[10]) : null);
				FishingVesselM fishingVesselM = new FishingVesselM(boatName, boatRegNo, ownerName, boatLong, boatWide,
						deep, boatTypeEngine, tonGross, noofMachine, date_permit, date_expire);
				
				fishingVesselM.setPaging(null);
				fishingVesselMs.add(fishingVesselM);
			}
		}
		return fishingVesselMs;
	}

	@SuppressWarnings("unchecked")
	public List<DOFWarRoomFishingToolM> getDOFWarRoomFishingToolByFisheryYearAndShipLicense(String fishery_year,
			String number_tool) {
		StringBuffer sb = new StringBuffer(
				"select l.fishery_year as YearReg, l.number_tool as BoatPermit, l.ship_license as BoatRegNo,\n"
						+ "l.fishing_tool_type as FishingType, l.fishing_tool_name as FishingTool,\n"
						+ "v.date_permit, v.date_expire, l.fishing_tool_width, l.fishing_tool_length, \n"
						+ "l.fishing_tool_qty, l.fishing_tool_uom, l.write_date\n"
						+ "from fishery_license l left join fishing_vessel v\n" + "on l.ship_license = v.ship_code\n"
						+ "where fishery_year =:fishery_year\n" + "and l.number_tool =:number_tool" + "");
		logger.info("getFishingVesselByShipCode->" + sb.toString());
		Query query = entiryManagerFI2.createNativeQuery(sb.toString());
		query.setParameter("fishery_year", Integer.valueOf(fishery_year));
		query.setParameter("number_tool", number_tool);
		query.setMaxResults(10);
		List<Object[]> obj = query.getResultList();
		int result_size = obj.size();
		List<DOFWarRoomFishingToolM> dofWarRoomFishingToolList = new ArrayList<DOFWarRoomFishingToolM>(result_size);
		if (obj != null && result_size > 0) {
			for (int i = 0; i < result_size; i++) {
				Object[] results = obj.get(i);
				java.lang.Integer yearReg = ((results[0] != null) ? ((Integer) results[0]) : null);
				String boatPermit = ((results[1] != null) ? ((String) results[1]) : "");
				String boatRegNo = ((results[2] != null) ? ((String) results[2]) : "");
				String fishingType = ((results[3] != null) ? ((String) results[3]) : "");
				String fishingTool = ((results[4] != null) ? ((String) results[4]) : "");
				Date date_permit = ((results[5] != null) ? ((Date) results[5]) : null);
				Date date_expire = ((results[6] != null) ? ((Date) results[6]) : null);
				Double fishing_tool_width = ((results[7] != null) ? ((Double) results[7]) : null);
				Double fishing_tool_length = ((results[8] != null) ? ((Double) results[8]) : null);
				Double fishing_tool_qty = ((results[9] != null) ? ((Double) results[9]) : null);
				String fishing_tool_uom = ((results[10] != null) ? ((String) results[10]) : null);
				Timestamp write_date = ((results[11] != null) ? ((Timestamp) results[11]) : null);

				DOFWarRoomFishingToolM dofWarRoomFishingToolM = new DOFWarRoomFishingToolM(yearReg, boatPermit,
						boatRegNo, fishingType, fishingTool, date_permit, date_expire, fishing_tool_width,
						fishing_tool_length, fishing_tool_qty, fishing_tool_uom, write_date);

				dofWarRoomFishingToolM.setPaging(null);
				dofWarRoomFishingToolList.add(dofWarRoomFishingToolM);
			}
		}
		return dofWarRoomFishingToolList;
	}
	
	
	
	/* -----------------------------------------------------------------------------------------------------------------
	 * Fishing Vessel From MD Server
	 * @author Wirun Pengsri (GJ)
	 * -----------------------------------------------------------------------------------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public List<FishingVesselMD> getFishingVesselMDByShipSerial(String shipSerial) {

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
					+"  to_char(sysdate, 'dd-mm-yyyy') create_date, \n"
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
					+"  cer.full_name_th	egn_certificate_level , \n"
					+"  rs.egn_ename	egn_ename , \n"
					+"  rs.egn_esurname	egn_esurname , \n"
					+"  rs.egn_name	egn_name , \n"
					+"  rs.egn_surname	egn_surname , \n"
					+"  case when length(rs.eng_name) <= 1 then null else rs.eng_name end eng_name , \n"
					+"  rs.garage	garage , \n"
					+"  rs.head_pic	head_pic , \n"
					+"  to_char(0) id , \n"
					+"  case when length(rs.imo_no) <= 1 then null else rs.imo_no end imo_no , \n"
					+"  recl.full_name	loc_reg , \n"
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
					+"  to_char(ro.owner_type)	owner_type , \n"
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
					+"  rs.lastupdate write_date \n"
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

		logger.info("\n getFishingVesselByShipCode-> \n" + sb.toString());
		Query query = entityManager.createNativeQuery(sb.toString());
		query.setParameter("ship_serial", shipSerial);
		List<Object[]> obj = query.getResultList();
		int result_size = obj.size();
		List<FishingVesselMD> fishingVesselMDs = new ArrayList<FishingVesselMD>(result_size);
		java.util.Date date= new java.util.Date();
		if (obj != null && result_size > 0) {
			for (int i = 0; i < result_size; i++) {
				Object[] results = obj.get(i);
				
				String abort_date = ((results[0] != null) ? ((String) results[0]) : (""));
				String abort_flag = ((results[1] != null) ? ((String) results[1]) : ("")); 
				String book_allow_no = ((results[2] != null) ? ((String) results[2]) : ("")); 
				String book_allow_seq = ((results[3] != null) ? ((String) results[3]) : ""); 
				String book_no = ((results[4] != null) ? ((String) results[4]) : (""));
				String book_seq = ((results[5] != null) ? ((String) results[5]) : ""); 
				String build_ship_year = ((results[6] != null) ? ((String) results[6]) : (""));
				String build_ship_year_bc = ((results[7] != null) ? ((String) results[7]) : ""); 
				String call_name = ((results[8] != null) ? ((String) results[8]) : (""));
				String call_name_en = ((results[9] != null) ? ((String) results[9]) : (""));
				String	cap_cer = ((results[10] != null) ? ((String) results[10]) : ""); //
				
				String cap_certificate_level = ((results[11] != null) ? ((String) results[11]) : (""));
				String cap_ename = ((results[12] != null) ? ((String) results[12]) : (""));
				String cap_esurname = ((results[13] != null) ? ((String) results[13]) : (""));
				String cap_name = ((results[14] != null) ? ((String) results[14]) : (""));
				String cap_surname = ((results[15] != null) ? ((String) results[15]) : (""));
				String create_date = ((results[16] != null) ? ((String) results[16]) : (""));
				String date_abort = abort_date = ((results[17] != null) ? ((String) results[17]) : ("")); 
				String date_expire = abort_date = ((results[18] != null) ? ((String) results[18]) : (""));
				String date_permit = abort_date = ((results[19] != null) ? ((String) results[19]) : (""));
				String date_reg = abort_date = ((results[20] != null) ? ((String) results[20]) : (""));
				
				String date_regth = ((results[21] != null) ? ((String) results[21]) : ("")); 
				String date_shipmortgage = ((results[22] != null) ? ((String) results[22]) : (""));
				String date_shipstatus = ((results[23] != null) ? ((String) results[23]) : (""));
				String date_tl = ((results[24] != null) ? ((String) results[24]) : (""));
				String date_tl_exp = ((results[25] != null) ? ((String) results[25]) : (""));
				String date_usestatus = ((results[26] != null) ? ((String) results[26]) : (""));
				String depth = ((results[27] != null) ? ((String) results[27]) : ""); 
				String edit_registrar = ((results[28] != null) ? ((String) results[28]) : (""));
				String egn_cer = ((results[29] != null) ? ((String) results[29]) : ""); 
				String egn_certificate_level = ((results[30] != null) ? ((String) results[30]) : (""));
				
				String egn_ename = ((results[31] != null) ? ((String) results[31]) : (""));
				String egn_esurname = ((results[32] != null) ? ((String) results[32]) : (""));
				String egn_name = ((results[33] != null) ? ((String) results[33]) : (""));
				String egn_surname = ((results[34] != null) ? ((String) results[34]) : (""));
				String eng_name = ((results[35] != null) ? ((String) results[35]) : (""));
				String garage = ((results[36] != null) ? ((String) results[36]) : (""));
				String head_pic = ((results[37] != null) ? ((String) results[37]) : (""));
				String id = ((results[38] != null) ? ((String) results[38]) : ""); 
				String imo_no = ((results[39] != null) ? ((String) results[39]) : (""));
				String loc_reg = ((results[40] != null) ? ((String) results[40]) : (""));
				
				String loc_reg_fkid = ((results[41] != null) ? ((String) results[41]) : ""); 
				String loc_serial = ((results[42] != null) ? ((String) results[42]) : (""));
				String machine_cost = ((results[43] != null) ? ((String) results[43]) : ""); 
				String machine_price_unit = ((results[44] != null) ? ((String) results[44]) : ""); 
				String matter_type = ((results[45] != null) ? ((String) results[45]) : (""));
				String matter_type_eng = ((results[46] != null) ? ((String) results[46]) : (""));
				String no_of_deck = ((results[47] != null) ? ((String) results[47]) : ""); //
				String no_of_feaman = ((results[48] != null) ? ((String) results[48]) : ""); //
				String no_of_machine = ((results[49] != null) ? ((String) results[49]) : ""); //
				String no_of_mast = ((results[50] != null) ? ((String) results[50]) : ""); //
				
				String no_of_person = ((results[51] != null) ? ((String) results[51]) : "");
				String	no_of_screw = ((results[52] != null) ? ((String) results[52]) : "");
				String	no_of_tube = ((results[53] != null) ? ((String) results[53]) : "");
				String owner_name = ((results[54] != null) ? ((String) results[54]) : (""));
				String owner_surname = ((results[55] != null) ? ((String) results[55]) : (""));
				String owner_type = ((results[56] != null) ? ((String) results[56]) : "");
				String registrar = ((results[57] != null) ? ((String) results[57]) : (""));
				String regth_loc = ((results[58] != null) ? ((String) results[58]) : (""));
				String regth_registrar = ((results[59] != null) ? ((String) results[59]) : (""));
				String remark = ((results[60] != null) ? ((String) results[60]) : (""));
				
				String remark_print_en = ((results[61] != null) ? ((String) results[61]) : (""));
				String remark_print_th = ((results[62] != null) ? ((String) results[62]) : (""));
				String ship_allow = ((results[63] != null) ? ((String) results[63]) : (""));
				String ship_build_loc = ((results[64] != null) ? ((String) results[64]) : (""));
				String ship_build_loc_eng = ((results[65] != null) ? ((String) results[65]) : (""));
				String ship_code = ((results[66] != null) ? ((String) results[66]) : (""));
				String ship_cost = ((results[67] != null) ? ((String) results[67]) : "");
				String ship_eng_type = ((results[68] != null) ? ((String) results[68]) : (""));
				String ship_flag = ((results[69] != null) ? ((String) results[69]) : (""));
				String ship_length = ((results[70] != null) ? ((String) results[70]) : "");
				
				String ship_length1 = ((results[71] != null) ? ((String) results[71]) : "");
				String ship_price_unit = ((results[72] != null) ? ((String) results[72]) : "");
				String	ship_serial = ((results[73] != null) ? ((String) results[73]) : "");
				String ship_status = ((results[74] != null) ? ((String) results[74]) : (""));
				String ship_type = ((results[75] != null) ? ((String) results[75]) : (""));
				String tail_pic = ((results[76] != null) ? ((String) results[76]) : (""));
				String tgross = ((results[77] != null) ? ((String) results[77]) : "");
				String tha_name = ((results[78] != null) ? ((String) results[78]) : (""));
				String tl_no = ((results[79] != null) ? ((String) results[79]) : (""));
				String tnet = ((results[80] != null) ? ((String) results[80]) : "");
				
				String ton = ((results[81] != null) ? ((String) results[81]) : "");
				String total_cost = ((results[82] != null) ? ((String) results[82]) : "");
				String total_price_unit = ((results[83] != null) ? ((String) results[83]) : "");
				String use_bound = ((results[84] != null) ? ((String) results[84]) : "");
				String use_bound_str = ((results[85] != null) ? ((String) results[85]) : (""));
				String use_depth = ((results[86] != null) ? ((String) results[86]) : "");
				String use_status = ((results[87] != null) ? ((String) results[87]) : (""));
				String use_status_pfk = ((results[88] != null) ? ((String) results[88]) : "");
				String use_type = ((results[89] != null) ? ((String) results[89]) : (""));
				String use_type_eng = ((results[90] != null) ? ((String) results[90]) : (""));
				
				String	use_type_fkid = ((results[91] != null) ? ((String) results[91]) : "");
				String usebound_desc = ((results[92] != null) ? ((String) results[92]) : (""));
				String usebound_desc_en = ((results[93] != null) ? ((String) results[93]) : (""));
				String width = ((results[94] != null) ? ((String) results[94]) : "");
				Timestamp write_date = ((results[95] != null) ? ((Timestamp) results[95]) : new Timestamp(date.getTime()));
 
				
				FishingVesselMD fishingVesselMD = new FishingVesselMD(
						abort_date, abort_flag, book_allow_no,
						book_allow_seq, book_no, book_seq, build_ship_year, build_ship_year_bc, call_name, call_name_en,
						cap_cer, cap_certificate_level, cap_ename, cap_esurname, cap_name, cap_surname, create_date,
						date_abort, date_expire, date_permit, date_reg, date_regth, date_shipmortgage, date_shipstatus,
						date_tl, date_tl_exp, date_usestatus, depth, edit_registrar, egn_cer, egn_certificate_level,
						egn_ename, egn_esurname, egn_name, egn_surname, eng_name, garage, head_pic, id, imo_no, loc_reg,
						loc_reg_fkid, loc_serial, machine_cost, machine_price_unit, matter_type, matter_type_eng,
						no_of_deck, no_of_feaman, no_of_machine, no_of_mast, no_of_person, no_of_screw, no_of_tube,
						owner_name, owner_surname, owner_type, registrar, regth_loc, regth_registrar, remark,
						remark_print_en, remark_print_th, ship_allow, ship_build_loc, ship_build_loc_eng, ship_code,
						ship_cost, ship_eng_type, ship_flag, ship_length, ship_length1, ship_price_unit, ship_serial,
						ship_status, ship_type, tail_pic, tgross, tha_name, tl_no, tnet, ton, total_cost,
						total_price_unit, use_bound, use_bound_str, use_depth, use_status, use_status_pfk, use_type,
						use_type_eng, use_type_fkid, usebound_desc, usebound_desc_en, width, write_date
						);

				
				fishingVesselMD.setPaging(null);
				fishingVesselMDs.add(fishingVesselMD);
			}
		}
		return fishingVesselMDs;
	}
	
	/* -----------------------------------------------------------------------------------------------------------------
	 * Fishing Vessel From FI2 Server
	 * @author Panicha Sriarj (GJ)
	 * -----------------------------------------------------------------------------------------------------------------
	 */
//	@SuppressWarnings("unchecked")
	public List<FishingLicenseInfo> getFishingLicenseInfoByShipCode(String Ship_Code) {

		StringBuffer sb = new StringBuffer
				("select shipcode, shipnameth, shipnameen, shipexpiredate, \n"
				+ "tgross, shipownername, shipowneraddress, registeryear, \n"
				+ "fishinglicensedateexpire, fishingtype, fishingtool, shippermit, grouptool, districtname, \n"
				+ "provincename, vesselcouple, markingno, fishingarea, fishingperiod \n"
				+ "from vw_fishing_info \n"
				+ "where shipcode = '"+Ship_Code+"' \n");
		Query query = entiryManagerFI2.createNativeQuery(sb.toString());
		//query.setParameter("ship_code", Ship_Code);
		List<Object[]> obj = query.getResultList();
		int result_size = obj.size();
		List<FishingLicenseInfo> fishinglicense = new ArrayList<FishingLicenseInfo>();
		if (obj != null && result_size > 0) {
			for (int i = 0; i < result_size; i++) {
				Object[] results = obj.get(i);

				String ShipCode = ((results[0] != null) ? ((String) results[0]) : (""));
				String ShipNameTH = ((results[1] != null) ? ((String) results[1]) : (""));
				String ShipNameEN = ((results[2] != null) ? ((String) results[2]) : (""));
				String ShipExpireDate = ((results[3] != null) ? (((Date) results[3])).toString() : (""));
				String Tgross = ((results[4] != null) ? (((Double) results[4])).toString() : (""));
				String ShipOwnerName = ((results[5] != null) ? ((String) results[5]) : (""));
				String ShipOwnerAddress = ((results[6] != null) ? ((String) results[6]) : (""));
				String RegisterYear = ((results[7] != null) ? (((Integer) results[7])).toString() : (""));
				//Date FishingLicenseDateReg = ((results[8] != null) ? ((Date) results[8]) : (null));
				String FishingLicenseDateExpire = ((results[8] != null) ? (((Date) results[8])).toString() : (""));
				String FishingType = ((results[9] != null) ? ((String) results[9]) : (""));
				String FishingTool = ((results[10] != null) ? ((String) results[10]) : (""));
				String ShipPermit = ((results[11] != null) ? ((String) results[11]) : (""));
				String GroupTool = ((results[12] != null) ? ((String) results[12]) : (""));
				String DistrictName = ((results[13] != null) ? ((String) results[13]) : (""));
				String ProvinceName = ((results[14] != null) ? ((String) results[14]) : (""));
				String VesselCouple = ((results[15] != null) ? ((String) results[15]) : (""));
				String MarkingNo = ((results[16] != null) ? ((String) results[16]) : (""));
				String FishingArea = ((results[17] != null) ? ((String) results[17]) : (""));
				String FishingPeriod = ((results[18] != null) ? ((String) results[18]) : (""));
				FishingLicenseInfo fishinglicenseInfo = new FishingLicenseInfo(
						ShipCode, ShipNameTH, ShipNameEN, ShipExpireDate, Tgross, ShipOwnerName, 
						ShipOwnerAddress, RegisterYear,FishingLicenseDateExpire,FishingType, FishingTool, ShipPermit, GroupTool, DistrictName, ProvinceName, 
						VesselCouple, MarkingNo, FishingArea, FishingPeriod);
				fishinglicenseInfo.setPaging(null);
				fishinglicense.add(fishinglicenseInfo);
			}
		}
		return fishinglicense;
	}
	
	/* -----------------------------------------------------------------------------------------------------------------
	 * Fishing Vessel From FI2 Server
	 * @author Panicha Sriarj (GJ)
	 * -----------------------------------------------------------------------------------------------------------------
	 */
//	@SuppressWarnings("unchecked")
	public List<FishingVesselInfo> getFishingVesselInfoByShipCode(String Ship_Code) {

		StringBuffer sb = new StringBuffer
				("select b.ship_code AS shipcode,b.tha_name AS shipnameth,b.eng_name AS shipnameen,b.use_type AS usetype,b.use_bound_str AS mdtype, \n"
				+ "c.name AS ownername,c.address AS owneraddress,b.cap_fullname AS captanname,b.egn_fullname AS engineername, \n"
				+ "b.width,b.ship_length AS lenght,b.depth,b.tgross,b.tnet, b.date_permit AS datepermit,b.date_expire AS dateexpire,b.abort_flag AS abortflag, \n"
				+ "b.loc_reg AS locationregister,v.box_id as VMXBoxID,v.brand as VMSBrand,v.Status as VMSStatus,v.Model as VMSModel \n"
				+ "FROM fishing_vessel b \n"
				+ "inner join owner_max a on a.ship_serial_id = b.id \n"
				+ "inner  join   ship_owner c on a.id = c.id \n"
				+ "left join fi2_vms v on v.id=b.vms_ID \n"
				+ "where b.ship_code = :ship_code \n");
		logger.info("\n getFishingVesselInfoByShipCode-> \n" + sb.toString());
		Query query = entiryManagerFI2.createNativeQuery(sb.toString());
		query.setParameter("ship_code", Ship_Code);
		List<Object[]> obj = query.getResultList();
		int result_size = obj.size();
		List<FishingVesselInfo> fishingvessel = new ArrayList<FishingVesselInfo>();
		if (obj != null && result_size > 0) {
			for (int i = 0; i < result_size; i++) {
				Object[] results = obj.get(i);

				String ShipCode = ((results[0] != null) ? ((String) results[0]) : (""));
				String ShipNameTH = ((results[1] != null) ? ((String) results[1]) : (""));
				String ShipNameEN = ((results[2] != null) ? ((String) results[2]) : (""));
				String UseType = ((results[3] != null) ? ((String) results[3]) : (""));
				String MDType = ((results[4] != null) ? ((String) results[4]) : (""));
				String ShipOwnerName = ((results[5] != null) ? ((String) results[5]) : (""));
				String ShipOwnerAddress = ((results[6] != null) ? ((String) results[6]) : (""));
				String CaptanName = ((results[7] != null) ? ((String) results[7]) : (""));
				String EngineerName = ((results[8] != null) ? ((String) results[8]) : (""));
				String Width = ((results[9] != null) ? (((Double) results[9])).toString() : (""));
				String Lenght = ((results[10] != null) ? (((Double) results[10])).toString() : (""));
				String Depth = ((results[11] != null) ? (((Double) results[11])).toString() : (""));
				String Tgross = ((results[12] != null) ? (((Double) results[12])).toString() : (""));
				String Tgnet = ((results[13] != null) ? (((Double) results[13])).toString() : (""));
				String DatePermit = ((results[14] != null) ? (((Date) results[14])).toString() : (""));
				String DateExpire = ((results[15] != null) ? (((Date) results[15])).toString() : (""));
				String AbortFlag = ((results[16] != null) ? ((String) results[16]) : (""));
				String LocationRegister = ((results[17] != null) ? ((String) results[17]) : (""));
				String VMSBoxID = ((results[18] != null) ? ((String) results[18]) : (""));
				String VMSBrand = ((results[19] != null) ? ((String) results[19]) : (""));
				String VMSStatus = ((results[20] != null) ? ((String) results[20]) : (""));
				String VMSModel = ((results[21] != null) ? ((String) results[21]) : (""));
				FishingVesselInfo fishingVesselInfo = new FishingVesselInfo(
						ShipCode, ShipNameTH, ShipNameEN, UseType, MDType, ShipOwnerName, ShipOwnerAddress,
						CaptanName, EngineerName, Width, Lenght, Depth, Tgross, Tgnet, DatePermit, DateExpire,
						AbortFlag, LocationRegister, VMSBoxID, VMSBrand, VMSStatus, VMSModel);
				fishingVesselInfo.setPaging(null);
				fishingvessel.add(fishingVesselInfo);
			}
		}
		return fishingvessel;
	}
	/* -----------------------------------------------------------------------------------------------------------------
	 * Fishing Vessel From FI2 Server
	 * @author Panicha Sriarj (GJ)
	 * -----------------------------------------------------------------------------------------------------------------
	 */
//	@SuppressWarnings("unchecked")
	public List<ShipOwnerHist> getShipOwnerHistByShipCode(String Ship_Code) {

		StringBuffer sb = new StringBuffer
				("select f.ship_code, f.tha_name as ShipNameTH, f.eng_name  as ShipNameEN, s.seq as Seq, s.Name as OwnerNameTH, \n"
				+ "s.ename as OwnerNameEN, s.Name as Address, s.date_transfer as DateTransfer, s.active as OwnerStatus \n"
				+ "from ship_owner s \n"
				+ "inner join Fishing_Vessel f on f.id=s.ship_serial_id \n"
				+ "where s.active='t' \n"
				+ "and f.ship_code = '"+Ship_Code+"' \n");
		Query query = entiryManagerFI2.createNativeQuery(sb.toString());
		//query.setParameter("ship_code", Ship_Code);
		List<Object[]> obj = query.getResultList();
		int result_size = obj.size();
		List<ShipOwnerHist> shipownerhist = new ArrayList<ShipOwnerHist>();
		if (obj != null && result_size > 0) {
			for (int i = 0; i < result_size; i++) {
				Object[] results = obj.get(i);

				String ShipCode = ((results[0] != null) ? ((String) results[0]) : (""));
				String ShipNameTH = ((results[1] != null) ? ((String) results[1]) : (""));
				String ShipNameEN = ((results[2] != null) ? ((String) results[2]) : (""));
				String Seq = ((results[3] != null) ? (((Integer) results[3])).toString() : (""));
				String OwnerNameTH = ((results[4] != null) ? ((String) results[4]) : (""));
				String OwnerNameEN = ((results[5] != null) ? ((String) results[5]) : (""));
				String Address = ((results[6] != null) ? ((String) results[6]) : (""));
				String DateTransfer = ((results[7] != null) ? ((String) results[7]) : (""));
				
				ShipOwnerHist shipOwnerhist = new ShipOwnerHist(
						ShipCode, ShipNameTH, ShipNameEN, Seq, OwnerNameTH, OwnerNameEN, Address, DateTransfer);
				shipOwnerhist.setPaging(null);
				shipownerhist.add(shipOwnerhist);
			}
		}  
		return shipownerhist;
	}
}

