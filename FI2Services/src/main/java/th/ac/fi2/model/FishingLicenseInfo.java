package th.ac.fi2.model;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.Type;

//import java.math.BigDecimal;
//import java.sql.Date;
//import java.sql.Timestamp;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import th.ac.fi2.xstream.common.ImakeXML;

/**
 * Created by jib on 07/04/2016.
 */
@XStreamAlias("wsGetFishingLicenseInfo")
public class FishingLicenseInfo extends ImakeXML implements Serializable {
	private static final long serialVersionUID = 1L;
    private	String	ShipCode;
    private	String	ShipNameTH;
    private	String	ShipNameEN;
    private	String	ShipExpireDate; //private	BigDecimal	book_allow_seq;
    private	String	Tgross;
    private String  ShipOwnerName;
    private String  ShipOwnerAddress;
    private String  RegisterYear;
   // private Date  FishingLicenseDateReg;
    private String  FishingLicenseDateExpire;
    private String  FishingType;
    private String  FishingTool;
    private String  ShipPermit;
    private String  GroupTool;
    private String  DistrictName;
    private String  ProvinceName;
    private String  VesselCouple;
    private String  MarkingNo;
    private String  FishingArea;
    private String  FishingPeriod;
    
    public FishingLicenseInfo(){

    }
    public FishingLicenseInfo(
    		String	ShipCode,
    		String	ShipNameTH,
    		String	ShipNameEN,
    		String	ShipExpireDate,
    		String	Tgross,
    		String	ShipOwnerName,
    		String	ShipOwnerAddress, 
    		String	RegisterYear,
    		//Date	FishingLicenseDateReg,
    		String	FishingLicenseDateExpire, 
    		String	FishingType, 
    		String	FishingTool, 
    		String	ShipPermit, 
    		String	GroupTool,
    		String	DistrictName, 
    		String	ProvinceName, 
    		String  VesselCouple,
    		String	MarkingNo, 
    		String	FishingArea, 
    		String	FishingPeriod
    		) {
    	this.ShipCode = ShipCode;
    	this.ShipNameTH = ShipNameTH;
    	this.ShipNameEN = ShipNameEN;
    	this.ShipExpireDate = ShipExpireDate;
    	this.Tgross = Tgross;
    	this.ShipOwnerName = ShipOwnerName;
    	this.ShipOwnerAddress = ShipOwnerAddress;
    	this.RegisterYear = RegisterYear;
    	//this.FishingLicenseDateReg = FishingLicenseDateReg;
    	this.FishingLicenseDateExpire = FishingLicenseDateExpire;
    	this.FishingType = FishingType;
    	this.FishingTool = FishingTool;
    	this.ShipPermit = ShipPermit;
    	this.GroupTool = GroupTool;
    	this.DistrictName = DistrictName;
    	this.ProvinceName = VesselCouple;
    	this.VesselCouple = VesselCouple;
    	this.MarkingNo = MarkingNo;
    	this.FishingArea = FishingArea;
    	this.FishingPeriod = FishingPeriod;
    	
	}
	public String getShipCode() {
		return ShipCode;
	}
	public void setShipCode(String ShipCode) {
		this.ShipCode = ShipCode;
	}
	public String getShipNameTH() {
		return ShipNameTH;
	}
	public void setShipNameTH(String ShipNameTH) {
		this.ShipNameTH = ShipNameTH;
	}
	public String getShipNameEN() {
		return ShipNameEN;
	}
	public void setShipNameEN(String ShipNameEN) {
		this.ShipNameEN = ShipNameEN;
	}
	public String getShipExpireDate() {
		return ShipExpireDate;
	}
	public void setShipExpireDate(String ShipExpireDate) {
		this.ShipExpireDate = ShipExpireDate;
	}
	public String getTgross() {
		return Tgross;
	}
	public void setTgross(String Tgross) {
		this.Tgross = Tgross;
	}
	public String getShipOwnerName() {
		return ShipOwnerName;
	}
	public void setShipOwnerName(String ShipOwnerName) {
		this.ShipOwnerName = ShipOwnerName;
	}
	public String getShipOwnerAddress() {
		return ShipOwnerAddress;
	}
	public void setShipOwnerAddress(String ShipOwnerAddress) {
		this.ShipOwnerAddress = ShipOwnerAddress;
	}
	public String getRegisterYear() {
		return RegisterYear;
	}
	public void setRegisterYear(String RegisterYear) {
		this.RegisterYear = RegisterYear;
	}
	//public Date getFishingLicenseDateReg() {
	//	return FishingLicenseDateReg;
	//}
	//public void setFishingLicenseDateReg(Date FishingLicenseDateReg) {
	//	this.FishingLicenseDateReg = FishingLicenseDateReg;
	//}
	public String getFishingLicenseDateExpire() {
		return FishingLicenseDateExpire;
	}
	public void setFishingLicenseDateExpire(String FishingLicenseDateExpire) {
		this.FishingLicenseDateExpire = FishingLicenseDateExpire;
	}
	public String getFishingType() {
		return FishingType;
	}
	public void setFishingType(String FishingType) {
		this.FishingType = FishingType;
	}
	public String getFishingTool() {
		return FishingTool;
	}
	public void setFishingTool(String FishingTool) {
		this.FishingTool = FishingTool;
	}
	public String getShipPermit() {
		return ShipPermit;
	}
	public void setShipPermit(String ShipPermit) {
		this.ShipPermit = ShipPermit;
	}
	public String getGroupTool() {
		return GroupTool;
	}
	public void setGroupTool(String GroupTool) {
		this.GroupTool = GroupTool;
	}
	public String getDistrictName() {
		return DistrictName;
	}
	public void setDistricName(String DistrictName) {
		this.DistrictName = DistrictName;
	}
	public String getProvinceName() {
		return ProvinceName;
	}
	public void setProvinceName(String ProvinceName) {
		this.ProvinceName = ProvinceName;
	}
	public String getVesselCouple() {
		return VesselCouple;
	}
	public void setVesselCouple(String VesselCouple) {
		this.VesselCouple = VesselCouple;
	}
	public String getMarkingNo() {
		return MarkingNo;
	}
	public void setMarkingNo(String MarkingNo) {
		this.MarkingNo = MarkingNo;
	}
	public String getFishingArea() {
		return FishingArea;
	}
	public void setFishingArea(String FishingArea) {
		this.FishingArea = FishingArea;
	}
	public String getFishingPeriod() {
		return FishingPeriod;
	}
	public void setFishingPeriod(String FishingPeriod) {
		this.FishingPeriod = FishingPeriod;
	}

}
