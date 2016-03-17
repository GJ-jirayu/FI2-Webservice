package th.ac.fi2.domain;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Embeddable class FishingVesselId { Integer emShipSerialId;}


@Entity
@Table(name="fishing_vessel", uniqueConstraints= 
@UniqueConstraint(columnNames = "SHIP_SERIAL"))
public class FishingVessel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@Column(name="SHIP_SERIAL") 
	@Id
	@Column(name = "SHIP_SERIAL", unique = true, nullable = false)	
	private	Integer shipSerial;
	
	@Column(name="ABORT_DATE") 
	private	Date abortDate;
	
	@Column(name="ABORT_FLAG")
	private	String abortFlag;
	
	@Column(name="BOOK_ALLOW_NO")
	private	String bookAllowNo;
	
	@Column(name="BOOK_ALLOW_SEQ")
	private	String bookAllowSeq;
	
	@Column(name="BOOK_NO")
	private	String bookNo;
	
	@Column(name="BOOK_SEQ")
	private	String bookSeq;
	
	@Column(name="BUILD_SHIP_YEAR")
	private	String buildShipYear;
	
	@Column(name="BUILD_SHIP_YEAR_BC")
	private	String buildShipYearBc;
	
	@Column(name="CALL_NAME")
	private	String calName;
	
	@Column(name="CALL_NAME_EN")
	private	String callNameEn;
	
	@Column(name="CAP_CER")
	private	Integer capCer;
	
	@Column(name="CAP_CERTIFICATE_LEVEL")
	private	String capCertificateLevel;
	
	@Column(name="CAP_ENAME")
	private	String capEname; 
	
	@Column(name="CAP_ESURNAME")
	private	String capEsurname;
	
	@Column(name="CAP_NAME")
	private	String capName; 
	
	@Column(name="CAP_SURNAME")
	private	String capSurname;
	
	@Column(name="CREATE_DATE")
	private Date createDate;
	
	@Column(name="DATE_ABORT")
	private	Date dateAbort;
	
	@Column(name="DATE_EXPIRE")
	private	Date dateExpire;
	
	@Column(name="DATE_PERMIT")
	private	Date datePermit; 
	
	@Column(name="DATE_REG")
	private	Date dateReg; 
	
	@Column(name="DATE_REGTH")
	private	Date dateRegth;
	
	@Column(name="DATE_SHIPMORTGAGE")
	private	Date dateShipmortgage;
	
	@Column(name="DATE_SHIPSTATUS")
	private	Date dateShipstatus;
	
	@Column(name="DATE_TL")
	private	Date dateTl;
	
	@Column(name="DATE_TL_EXP")
	private	Date dateTlExp;
	
	@Column(name="DATE_USESTATUS")
	private	Date dateUsestatus; 
	
	@Column(name="DEPTH")
	private Double depth;
	
	@Column(name="EDIT_REGISTRAR")
	private	String editRegistrar;
	
	@Column(name="EGN_CER")
	private	Integer egnCer;
	
	@Column(name="EGN_CERTIFICATE_LEVEL")
	private	String egnCertificateLevel;
	
	@Column(name="EGN_ENAME")
	private	String egnEname; 
	
	@Column(name="EGN_ESURNAME")
	private	String egnEsurname;
	
	@Column(name="EGN_NAME")
	private	String egnName;
	
	@Column(name="EGN_SURNAME")
	private	String egnSurname; 
	
	@Column(name="ENG_NAME")
	private	String engName;
	
	@Column(name="GARAGE")
	private	String garage;
	
	@Column(name="HEAD_PIC")
	private	String headPic;
	
	@Column(name="IMO_NO")
	private	String imoNo; 
	
	@Column(name="LOC_REG")
	private	String locReg; 
	
	@Column(name="LOC_REG_FKID")
	private	Integer locRegFkid; 
	
	@Column(name="LOC_SERIAL")
	private	String locSerial;
	
	@Column(name="MACHINE_COST")
	private Double machineCost;
	
	@Column(name="MACHINE_PRICE_UNIT")
	private	String machinePriceUnit;
	
	@Column(name="MATTER_TYPE")
	private	String matterType; 
	
	@Column(name="MATTER_TYPE_ENG")
	private	String matterTypeEng;
	
	@Column(name="NO_OF_DECK")
	private	Integer noOfDeck;
	
	@Column(name="NO_OF_FEAMAN")
	private	Integer noOfFeaman;
	
	@Column(name="NO_OF_MACHINE")
	private	Integer noOfMachine;
	
	@Column(name="NO_OF_MAST")
	private	Integer noOfMast;
	
	@Column(name="NO_OF_PERSON")
	private	Integer noOfPerson;
	
	@Column(name="NO_OF_SCREW")
	private	Integer noOfScrew;
	
	@Column(name="NO_OF_TUBE")
	private	Integer noOfTube;
	
	@Column(name="OWNER_NAME")
	private	String ownerName;
	
	@Column(name="OWNER_SURNAME")
	private	String ownerSurname;
	
	@Column(name="OWNER_TYPE")
	private	String ownerType;
	
	@Column(name="REGISTRAR")
    private	String registrar; 
	
	@Column(name="REGTH_LOC")
    private	String regthLoc;
	
	@Column(name="REGTH_REGISTRAR")
    private	String regthRegistrar;
	
	@Column(name="REMARK")
    private	String remark;
	
	@Column(name="REMARK_PRINT_EN")
    private	String remarkPrintEn;
    
	@Column(name="REMARK_PRINT_TH")
    private	String remarkPrintTh; 
    
	@Column(name="SHIP_ALLOW")
	private	String shipAllow;
	
	@Column(name="SHIP_BUILD_LOC")
    private	String shipBuildLoc;
	
	@Column(name="SHIP_BUILD_LOC_ENG") 
	private	String shipBuildLocEng;
	
	@Column(name="SHIP_CODE") 
	private	String shipCode; 
	
	@Column(name="SHIP_COST") 
	private Double shipCost;
 
	@Column(name="SHIP_ENG_TYPE") 
	private	String shipEngType;
	
	@Column(name="SHIP_FLAG") 
	private	String shipFlag;
	
	@Column(name="SHIP_LENGTH") 
	private Double shipLength; 
	
	@Column(name="SHIP_LENGTH1") 
	private Double shipLength1;
	
	@Column(name="SHIP_PRICE_UNIT") 
	private	String shipPriceUnit;
	
	@Column(name="SHIP_STATUS") 
	private	String shipStatus; 
	
	@Column(name="SHIP_TYPE") 
	private	String shipType; 
	
	@Column(name="TAIL_PIC") 
	private	String tailPic; 
	
	@Column(name="TGROSS") 
	private Double tgross; 
	
	@Column(name="THA_NAME") 
	private	String thaName; 
	
	@Column(name="TL_NO") 
	private	String tlNo; 
	
	@Column(name="TNET") 
	private Double tnet; 

	@Column(name="TON") 
	private Double ton; 

	@Column(name="TOTAL_COST") 
	private Double totalCost; 

	@Column(name="TOTAL_PRICE_UNIT") 
	private	String totalPriceUnit; 

	@Column(name="USE_BOUND") 
	private	Integer useBound; 

	@Column(name="USE_BOuND_STR") 
	private	String useBoundStr; 
	
	@Column(name="USE_DEPTH") 
	private Double useDepth; 

	@Column(name="USE_STATUS") 
	private	String useStatus; 
	
	@Column(name="USE_STATUS_PFK") 
	private	Integer useStatusPfk; 

	@Column(name="USE_TYPE") 
	private	String useType; 
	
	@Column(name="USE_TYPE_ENG") 
	private	String useTypeEng; 
	
	@Column(name="USE_TYPE_FKID") 
	private	Integer useTypeFkid; 

	@Column(name="USEBOUND_DESC") 
	private	String useboundDesc; 
	
	@Column(name="USEBOUND_DESC_EN") 
	private	String useboundDescEn; 
	
	@Column(name="WIDTH") 
	private Double width; 

	@Column(name="WRITE_DATE") 
	private Timestamp writeDate;
	
	@Column(name="ACTIVE")
	private Boolean active;
    
	@Column(name="OWNER_TYPE_FKID")
	private Integer ownerTypeFkid;
	
	@Column(name="SHIP_TYPE_FKID")
	private Integer shipTypeFkid;
	
	@Column(name="SHIP_STATUS_FKID")
	private Integer shipStatusFkid;
	
	
    public FishingVessel(){
    	
    }


	/*public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}*/


	/*public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}*/


	public Integer getShipSerial() {
		return shipSerial;
	}


	public void setShipSerial(Integer shipSerial) {
		this.shipSerial = shipSerial;
	}


	public Date getAbortDate() {
		return abortDate;
	}


	public void setAbortDate(Date abortDate) {
		this.abortDate = abortDate;
	}


	public String getAbortFlag() {
		return abortFlag;
	}


	public void setAbortFlag(String abortFlag) {
		this.abortFlag = abortFlag;
	}


	public String getBookAllowNo() {
		return bookAllowNo;
	}


	public void setBookAllowNo(String bookAllowNo) {
		this.bookAllowNo = bookAllowNo;
	}


	public String getBookAllowSeq() {
		return bookAllowSeq;
	}


	public void setBookAllowSeq(String bookAllowSeq) {
		this.bookAllowSeq = bookAllowSeq;
	}


	public String getBookNo() {
		return bookNo;
	}


	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}


	public String getBookSeq() {
		return bookSeq;
	}


	public void setBookSeq(String bookSeq) {
		this.bookSeq = bookSeq;
	}


	public String getBuildShipYear() {
		return buildShipYear;
	}


	public void setBuildShipYear(String buildShipYear) {
		this.buildShipYear = buildShipYear;
	}


	public String getBuildShipYearBc() {
		return buildShipYearBc;
	}


	public void setBuildShipYearBc(String buildShipYearBc) {
		this.buildShipYearBc = buildShipYearBc;
	}


	public String getCalName() {
		return calName;
	}


	public void setCalName(String calName) {
		this.calName = calName;
	}


	public String getCallNameEn() {
		return callNameEn;
	}


	public void setCallNameEn(String callNameEn) {
		this.callNameEn = callNameEn;
	}


	public Integer getCapCer() {
		return capCer;
	}


	public void setCapCer(Integer capCer) {
		this.capCer = capCer;
	}


	public String getCapCertificateLevel() {
		return capCertificateLevel;
	}


	public void setCapCertificateLevel(String capCertificateLevel) {
		this.capCertificateLevel = capCertificateLevel;
	}


	public String getCapEname() {
		return capEname;
	}


	public void setCapEname(String capEname) {
		this.capEname = capEname;
	}


	public String getCapEsurname() {
		return capEsurname;
	}


	public void setCapEsurname(String capEsurname) {
		this.capEsurname = capEsurname;
	}


	public String getCapName() {
		return capName;
	}


	public void setCapName(String capName) {
		this.capName = capName;
	}


	public String getCapSurname() {
		return capSurname;
	}


	public void setCapSurname(String capSurname) {
		this.capSurname = capSurname;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public Date getDateAbort() {
		return dateAbort;
	}


	public void setDateAbort(Date dateAbort) {
		this.dateAbort = dateAbort;
	}


	public Date getDateExpire() {
		return dateExpire;
	}


	public void setDateExpire(Date dateExpire) {
		this.dateExpire = dateExpire;
	}


	public Date getDatePermit() {
		return datePermit;
	}


	public void setDatePermit(Date datePermit) {
		this.datePermit = datePermit;
	}


	public Date getDateReg() {
		return dateReg;
	}


	public void setDateReg(Date dateReg) {
		this.dateReg = dateReg;
	}


	public Date getDateRegth() {
		return dateRegth;
	}


	public void setDateRegth(Date dateRegth) {
		this.dateRegth = dateRegth;
	}


	public Date getDateShipmortgage() {
		return dateShipmortgage;
	}


	public void setDateShipmortgage(Date dateShipmortgage) {
		this.dateShipmortgage = dateShipmortgage;
	}


	public Date getDateShipstatus() {
		return dateShipstatus;
	}


	public void setDateShipstatus(Date dateShipstatus) {
		this.dateShipstatus = dateShipstatus;
	}


	public Date getDateTl() {
		return dateTl;
	}


	public void setDateTl(Date dateTl) {
		this.dateTl = dateTl;
	}


	public Date getDateTlExp() {
		return dateTlExp;
	}


	public void setDateTlExp(Date dateTlExp) {
		this.dateTlExp = dateTlExp;
	}


	public Date getDateUsestatus() {
		return dateUsestatus;
	}


	public void setDateUsestatus(Date dateUsestatus) {
		this.dateUsestatus = dateUsestatus;
	}


	public Double getDepth() {
		return depth;
	}


	public void setDepth(Double depth) {
		this.depth = depth;
	}


	public String getEditRegistrar() {
		return editRegistrar;
	}


	public void setEditRegistrar(String editRegistrar) {
		this.editRegistrar = editRegistrar;
	}


	public Integer getEgnCer() {
		return egnCer;
	}


	public void setEgnCer(Integer egnCer) {
		this.egnCer = egnCer;
	}


	public String getEgnCertificateLevel() {
		return egnCertificateLevel;
	}


	public void setEgnCertificateLevel(String egnCertificateLevel) {
		this.egnCertificateLevel = egnCertificateLevel;
	}


	public String getEgnEname() {
		return egnEname;
	}


	public void setEgnEname(String egnEname) {
		this.egnEname = egnEname;
	}


	public String getEgnEsurname() {
		return egnEsurname;
	}


	public void setEgnEsurname(String egnEsurname) {
		this.egnEsurname = egnEsurname;
	}


	public String getEgnName() {
		return egnName;
	}


	public void setEgnName(String egnName) {
		this.egnName = egnName;
	}


	public String getEgnSurname() {
		return egnSurname;
	}


	public void setEgnSurname(String egnSurname) {
		this.egnSurname = egnSurname;
	}


	public String getEngName() {
		return engName;
	}


	public void setEngName(String engName) {
		this.engName = engName;
	}


	public String getGarage() {
		return garage;
	}


	public void setGarage(String garage) {
		this.garage = garage;
	}


	public String getHeadPic() {
		return headPic;
	}


	public void setHeadPic(String headPic) {
		this.headPic = headPic;
	}


	public String getImoNo() {
		return imoNo;
	}


	public void setImoNo(String imoNo) {
		this.imoNo = imoNo;
	}


	public String getLocReg() {
		return locReg;
	}


	public void setLocReg(String locReg) {
		this.locReg = locReg;
	}


	public Integer getLocRegFkid() {
		return locRegFkid;
	}


	public void setLocRegFkid(Integer locRegFkid) {
		this.locRegFkid = locRegFkid;
	}


	public String getLocSerial() {
		return locSerial;
	}


	public void setLocSerial(String locSerial) {
		this.locSerial = locSerial;
	}


	public Double getMachineCost() {
		return machineCost;
	}


	public void setMachineCost(Double machineCost) {
		this.machineCost = machineCost;
	}


	public String getMachinePriceUnit() {
		return machinePriceUnit;
	}


	public void setMachinePriceUnit(String machinePriceUnit) {
		this.machinePriceUnit = machinePriceUnit;
	}


	public String getMatterType() {
		return matterType;
	}


	public void setMatterType(String matterType) {
		this.matterType = matterType;
	}


	public String getMatterTypeEng() {
		return matterTypeEng;
	}


	public void setMatterTypeEng(String matterTypeEng) {
		this.matterTypeEng = matterTypeEng;
	}


	public Integer getNoOfDeck() {
		return noOfDeck;
	}


	public void setNoOfDeck(Integer noOfDeck) {
		this.noOfDeck = noOfDeck;
	}


	public Integer getNoOfFeaman() {
		return noOfFeaman;
	}


	public void setNoOfFeaman(Integer noOfFeaman) {
		this.noOfFeaman = noOfFeaman;
	}


	public Integer getNoOfMachine() {
		return noOfMachine;
	}


	public void setNoOfMachine(Integer noOfMachine) {
		this.noOfMachine = noOfMachine;
	}


	public Integer getNoOfMast() {
		return noOfMast;
	}


	public void setNoOfMast(Integer noOfMast) {
		this.noOfMast = noOfMast;
	}


	public Integer getNoOfPerson() {
		return noOfPerson;
	}


	public void setNoOfPerson(Integer noOfPerson) {
		this.noOfPerson = noOfPerson;
	}


	public Integer getNoOfScrew() {
		return noOfScrew;
	}


	public void setNoOfScrew(Integer noOfScrew) {
		this.noOfScrew = noOfScrew;
	}


	public Integer getNoOfTube() {
		return noOfTube;
	}


	public void setNoOfTube(Integer noOfTube) {
		this.noOfTube = noOfTube;
	}


	public String getOwnerName() {
		return ownerName;
	}


	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}


	public String getOwnerSurname() {
		return ownerSurname;
	}


	public void setOwnerSurname(String ownerSurname) {
		this.ownerSurname = ownerSurname;
	}


	public String getOwnerType() {
		return ownerType;
	}


	public void setOwnerType(String ownerType) {
		this.ownerType = ownerType;
	}


	public String getRegistrar() {
		return registrar;
	}


	public void setRegistrar(String registrar) {
		this.registrar = registrar;
	}


	public String getRegthLoc() {
		return regthLoc;
	}


	public void setRegthLoc(String regthLoc) {
		this.regthLoc = regthLoc;
	}


	public String getRegthRegistrar() {
		return regthRegistrar;
	}


	public void setRegthRegistrar(String regthRegistrar) {
		this.regthRegistrar = regthRegistrar;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	public String getRemarkPrintEn() {
		return remarkPrintEn;
	}


	public void setRemarkPrintEn(String remarkPrintEn) {
		this.remarkPrintEn = remarkPrintEn;
	}


	public String getRemarkPrintTh() {
		return remarkPrintTh;
	}


	public void setRemarkPrintTh(String remarkPrintTh) {
		this.remarkPrintTh = remarkPrintTh;
	}


	public String getShipAllow() {
		return shipAllow;
	}


	public void setShipAllow(String shipAllow) {
		this.shipAllow = shipAllow;
	}


	public String getShipBuildLoc() {
		return shipBuildLoc;
	}


	public void setShipBuildLoc(String shipBuildLoc) {
		this.shipBuildLoc = shipBuildLoc;
	}


	public String getShipBuildLocEng() {
		return shipBuildLocEng;
	}


	public void setShipBuildLocEng(String shipBuildLocEng) {
		this.shipBuildLocEng = shipBuildLocEng;
	}


	public String getShipCode() {
		return shipCode;
	}


	public void setShipCode(String shipCode) {
		this.shipCode = shipCode;
	}


	public Double getShipCost() {
		return shipCost;
	}


	public void setShipCost(Double shipCost) {
		this.shipCost = shipCost;
	}


	public String getShipEngType() {
		return shipEngType;
	}


	public void setShipEngType(String shipEngType) {
		this.shipEngType = shipEngType;
	}


	public String getShipFlag() {
		return shipFlag;
	}


	public void setShipFlag(String shipFlag) {
		this.shipFlag = shipFlag;
	}


	public Double getShipLength() {
		return shipLength;
	}


	public void setShipLength(Double shipLength) {
		this.shipLength = shipLength;
	}


	public Double getShipLength1() {
		return shipLength1;
	}


	public void setShipLength1(Double shipLength1) {
		this.shipLength1 = shipLength1;
	}


	public String getShipPriceUnit() {
		return shipPriceUnit;
	}


	public void setShipPriceUnit(String shipPriceUnit) {
		this.shipPriceUnit = shipPriceUnit;
	}


	public String getShipStatus() {
		return shipStatus;
	}


	public void setShipStatus(String shipStatus) {
		this.shipStatus = shipStatus;
	}


	public String getShipType() {
		return shipType;
	}


	public void setShipType(String shipType) {
		this.shipType = shipType;
	}


	public String getTailPic() {
		return tailPic;
	}


	public void setTailPic(String tailPic) {
		this.tailPic = tailPic;
	}


	public Double getTgross() {
		return tgross;
	}


	public void setTgross(Double tgross) {
		this.tgross = tgross;
	}


	public String getThaName() {
		return thaName;
	}


	public void setThaName(String thaName) {
		this.thaName = thaName;
	}


	public String getTlNo() {
		return tlNo;
	}


	public void setTlNo(String tlNo) {
		this.tlNo = tlNo;
	}


	public Double getTnet() {
		return tnet;
	}


	public void setTnet(Double tnet) {
		this.tnet = tnet;
	}


	public Double getTon() {
		return ton;
	}


	public void setTon(Double ton) {
		this.ton = ton;
	}


	public Double getTotalCost() {
		return totalCost;
	}


	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}


	public String getTotalPriceUnit() {
		return totalPriceUnit;
	}


	public void setTotalPriceUnit(String totalPriceUnit) {
		this.totalPriceUnit = totalPriceUnit;
	}


	public Integer getUseBound() {
		return useBound;
	}


	public void setUseBound(Integer useBound) {
		this.useBound = useBound;
	}


	public String getUseBoundStr() {
		return useBoundStr;
	}


	public void setUseBoundStr(String useBoundStr) {
		this.useBoundStr = useBoundStr;
	}


	public Double getUseDepth() {
		return useDepth;
	}


	public void setUseDepth(Double useDepth) {
		this.useDepth = useDepth;
	}


	public String getUseStatus() {
		return useStatus;
	}


	public void setUseStatus(String useStatus) {
		this.useStatus = useStatus;
	}


	public Integer getUseStatusPfk() {
		return useStatusPfk;
	}


	public void setUseStatusPfk(Integer useStatusPfk) {
		this.useStatusPfk = useStatusPfk;
	}


	public String getUseType() {
		return useType;
	}


	public void setUseType(String useType) {
		this.useType = useType;
	}


	public String getUseTypeEng() {
		return useTypeEng;
	}


	public void setUseTypeEng(String useTypeEng) {
		this.useTypeEng = useTypeEng;
	}


	public Integer getUseTypeFkid() {
		return useTypeFkid;
	}


	public void setUseTypeFkid(Integer useTypeFkid) {
		this.useTypeFkid = useTypeFkid;
	}


	public String getUseboundDesc() {
		return useboundDesc;
	}


	public void setUseboundDesc(String useboundDesc) {
		this.useboundDesc = useboundDesc;
	}


	public String getUseboundDescEn() {
		return useboundDescEn;
	}


	public void setUseboundDescEn(String useboundDescEn) {
		this.useboundDescEn = useboundDescEn;
	}


	public Double getWidth() {
		return width;
	}


	public void setWidth(Double width) {
		this.width = width;
	}


	public Timestamp getWriteDate() {
		return writeDate;
	}


	public void setWriteDate(Timestamp writeDate) {
		this.writeDate = writeDate;
	}


	public Boolean getActive() {
		return active;
	}


	public void setActive(Boolean active) {
		this.active = active;
	}


	public Integer getOwnerTypeFkid() {
		return ownerTypeFkid;
	}


	public void setOwnerTypeFkid(Integer ownerTypeFkid) {
		this.ownerTypeFkid = ownerTypeFkid;
	}


	public Integer getShipTypeFkid() {
		return shipTypeFkid;
	}


	public void setShipTypeFkid(Integer shipTypeFkid) {
		this.shipTypeFkid = shipTypeFkid;
	}


	public Integer getShipStatusFkid() {
		return shipStatusFkid;
	}


	public void setShipStatusFkid(Integer shipStatusFkid) {
		this.shipStatusFkid = shipStatusFkid;
	}
    
    
}
