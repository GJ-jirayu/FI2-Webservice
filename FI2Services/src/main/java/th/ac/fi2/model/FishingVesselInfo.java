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
 * Created by jib on 11/04/2016.
 */
@XStreamAlias("wsGetFishingVesselInfo")
public class FishingVesselInfo extends ImakeXML implements Serializable {
	private static final long serialVersionUID = 1L;
    private	String	ShipCode;
    private	String	ShipNameTH;
    private	String	ShipNameEN;
    private	String	UseType;
    private	String	MDType;
    private String  ShipOwnerName;
    private String  ShipOwnerAddress;
    private String  CaptanName;
    private String  EngineerName;
    private String  Width;
    private String  Lenght;
    private String  Depth;
    private String  Tgross;
    private String  Tgnet;
    private String  DatePermit;
    private String  DateExpire;
    private String  AbortFlag;
    private String  LocationRegister;
    private String  VMSBoxID;
    private String  VMSBrand;
    private String  VMSStatus;
    private String  VMSModel;
    
    public FishingVesselInfo(){

    }
    public FishingVesselInfo(
    		String	ShipCode,
    		String	ShipNameTH,
    		String	ShipNameEN,
    		String	UseType,
    		String	MDType,
    		String	ShipOwnerName,
    		String	ShipOwnerAddress, 
    		String	CaptanName,
    		String	EngineerName,
    		String	Width, 
    		String	Lenght, 
    		String	Depth, 
    		String	Tgross, 
    		String	Tgnet,
    		String	DatePermit, 
    		String	DateExpire, 
    		String  AbortFlag,
    		String	LocationRegister, 
    		String	VMSBoxID, 
    		String	VMSBrand,
    		String  VMSStatus,
    		String  VMSModel
    		) {
    	this.ShipCode = ShipCode;
    	this.ShipNameTH = ShipNameTH;
    	this.ShipNameEN = ShipNameEN;
    	this.UseType = UseType;
    	this.MDType = MDType;
    	this.ShipOwnerName = ShipOwnerName;
    	this.ShipOwnerAddress = ShipOwnerAddress;
    	this.CaptanName = CaptanName;
    	this.EngineerName = EngineerName;
    	this.Width = Width;
    	this.Lenght = Lenght;
    	this.Depth = Depth;
    	this.Tgross = Tgross;
    	this.Tgnet = Tgnet;
    	this.DatePermit = DatePermit;
    	this.DateExpire = DateExpire;
    	this.AbortFlag = AbortFlag;
    	this.LocationRegister = LocationRegister;
    	this.VMSBoxID = VMSBoxID;
    	this.VMSBrand = VMSBrand;
    	this.VMSStatus = VMSStatus;
    	this.VMSModel = VMSModel;
    	
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
	public String getUseType() {
		return UseType;
	}
	public void setUseType(String UseType) {
		this.UseType = UseType;
	}
	public String getMDType() {
		return MDType;
	}
	public void setMDType(String MDType) {
		this.MDType = MDType;
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
	public String getCaptanName() {
		return CaptanName;
	}
	public void setCaptanName(String CaptanName) {
		this.CaptanName = CaptanName;
	}
	public String getEngineerName() {
		return EngineerName;
	}
	public void setEngineerName(String EngineerName) {
		this.EngineerName = EngineerName;
	}
	public String getWidth() {
		return Width;
	}
	public void setWidth(String Width) {
		this.Width = Width;
	}
	public String getLenght() {
		return Lenght;
	}
	public void setLenght(String Lenght) {
		this.Lenght = Lenght;
	}
	public String getDepth() {
		return Depth;
	}
	public void setDepth(String Depth) {
		this.Depth = Depth;
	}
	public String getTgross() {
		return Tgross;
	}
	public void setTgross(String Tgross) {
		this.Tgross = Tgross;
	}
	public String getTgnet() {
		return Tgnet;
	}
	public void setTgnet(String Tgnet) {
		this.Tgnet = Tgnet;
	}
	public String getDatePermit() {
		return DatePermit;
	}
	public void setDatePermit(String DatePermit) {
		this.DatePermit = DatePermit;
	}
	public String getDateExpire() {
		return DateExpire;
	}
	public void setDateExpire(String DateExpire){
		this.DateExpire = DateExpire;
	}
	public String getAbortFlag() {
		return AbortFlag;
	}
	public void setAbortFlag(String AbortFlag) {
		this.AbortFlag = AbortFlag;
	}
	public String getLocationRegister() {
		return LocationRegister;
	}
	public void setLocationRegister(String LocationRegister) {
		this.LocationRegister = LocationRegister;
	}
	public String getVMSBoxID() {
		return VMSBoxID;
	}
	public void setVMSBoxID(String VMSBoxID) {
		this.VMSBoxID = VMSBoxID;
	}
	public String getVMSBrand() {
		return VMSBrand;
	}
	public void setVMSBrand(String VMSBrand) {
		this.VMSBrand = VMSBrand; 
	}
	public String getVMSStatus() {
		return VMSStatus;
	}
	public void setVMSStatus(String VMSStatus) {
		this.VMSStatus = VMSStatus;
	}
	public String getVMSModel() {
		return VMSModel;
	}
	public void setVMSModel(String VMSModel) {
		this.VMSModel = VMSModel;
	}
	
}

