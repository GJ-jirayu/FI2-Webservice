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
@XStreamAlias("WsGetShipOwnerHist")
public class ShipOwnerHist extends ImakeXML implements Serializable {
	private static final long serialVersionUID = 1L;
    private	String	ShipCode;
    private	String	ShipNameTH;
    private	String	ShipNameEN;
    private	String	Seq;
    private	String	OwnerNameTH;
    private String  OwnerNameEN;
    private String  Address;
    private String  DateTransfer;
    
    public ShipOwnerHist(){

    }
    public ShipOwnerHist(
    		String	ShipCode,
    		String	ShipNameTH,
    		String	ShipNameEN,
    		String	Seq,
    		String	OwnerNameTH,
    		String	OwnerNameEN,
    		String	Address, 
    		String	DateTransfer
    		) {
    	this.ShipCode = ShipCode;
    	this.ShipNameTH = ShipNameTH;
    	this.ShipNameEN = ShipNameEN;
    	this.Seq = Seq;
    	this.OwnerNameTH = OwnerNameTH;
    	this.OwnerNameEN = OwnerNameEN;
    	this.Address = Address;
    	this.DateTransfer = DateTransfer;
    	
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
	public String getSeq() {
		return Seq;
	}
	public void setSeq(String Seq) {
		this.Seq = Seq;
	}
	public String getOwnerNameTH() {
		return OwnerNameTH;
	}
	public void setOwnerNameTH(String OwnerNameTH) {
		this.OwnerNameTH = OwnerNameTH;
	}
	public String getOwnerNameEN() {
		return OwnerNameEN;
	}
	public void setOwnerNameEN(String OwnerNameEN) {
		this.OwnerNameEN = OwnerNameEN;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String Address) {
		this.Address = Address;
	}
	public String getDateTransfer() {
		return DateTransfer;
	}
	public void setDateTransfer(String DateTransfer) {
		this.DateTransfer = DateTransfer;
	}	
}

