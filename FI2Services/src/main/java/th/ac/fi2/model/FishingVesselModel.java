package th.ac.fi2.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import th.ac.fi2.xstream.common.ImakeXML;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;

/**
 * Created by imake on 20/12/2015.
 */
@XStreamAlias("FishingVesselModel")
public class FishingVesselModel extends ImakeXML implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private	Integer id;
	private	Integer shipSerial;
	private	Date abortDate;
	private	String abortFlag;
	private	String bookAllowNo;
	private	String bookAllowSeq;
	private	String bookNo;
	private	String bookSeq;
	private	String buildShipYear;
	private	String buildShipYearBc;
	private	String calName;
	private	String callNameEn;
	private	Integer capCer;
	private	String capCertificateLevel;
	private	String capEname; 
	private	String capEsurname;
	private	String capName; 
	private	String capSurname;
	private Date createDate;
	private	Date dateAbort;
	private	Date dateExpire;
	private	Date datePermit; 
	private	Date dateReg; 
	private	Date dateRegth;
	private	Date dateShipmortgage;
	private	Date dateShipstatus;
	private	Date dateTl;
	private	Date dateTlExp;
	private	Date dateUsestatus; 
	private Double depth;
	private	String editRegistrar;
	private	Integer egnCer;
	private	String egnCertificateLevel;
	private	String egnEname; 
	private	String egnEsurname;
	private	String egnName;
	private	String egnSurname; 
	private	String engName;
	private	String garage;
	private	String headPic;
	private	String imoNo; 
	private	String locReg; 
	private	Integer locRegFkid; 
	private	String locSerial;
	private Double machineCost;
	private	String machinePriceUnit;
	private	String matterType; 
	private	String matterTypeEng;
	private	Integer noOfDeck;
	private	Integer noOfFeaman;
	private	Integer noOfMachine;
	private	Integer noOfMast;
	private	Integer noOfPerson;
	private	Integer noOfScrew;
	private	Integer noOfTube;
	private	String ownerName;
	private	String ownerSurname;
	private	String ownerType;
    private	String registrar; 
    private	String regthLoc;
    private	String regthRegistrar;
    private	String remark;
    private	String remarkPrintEn;
    private	String remarkPrintTh; 
	private	String shipAllow;
    private	String shipBuildLoc;
	private	String shipBuildLocEng;
	private	String shipCode; 
	private Double shipCost;
	private	String shipEngType;
	private	String shipFlag;
	private Double shipLength; 
	private Double shipLength1;
	private	String shipPriceUnit;
	private	String shipStatus; 
	private	String shipType; 
	private	String tailPic; 
	private Double tgross; 
	private	String thaName; 
	private	String tlNo; 
	private Double tnet; 
	private Double ton; 
	private Double totalCost; 
	private	String totalPriceUnit; 
	private	Integer useBound; 
	private	String useBoundStr; 
	private Double useDepth; 
	private	String useStatus; 
	private	Integer useStatusPfk; 
	private	String useType; 
	private	String useTypeEng; 
	private	Integer useTypeFkid; 
	private	String useboundDesc; 
	private	String useboundDescEn; 
	private Double width; 
	private Timestamp writeDate;
	private Boolean active;
	private Integer ownerTypeFkid;
	private Integer shipTypeFkid;
	private Integer shipStatusFkid;
	
    public FishingVesselModel(){

    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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
