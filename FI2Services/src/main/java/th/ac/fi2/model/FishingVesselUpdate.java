package th.ac.fi2.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import th.ac.fi2.xstream.common.ImakeXML;

/**
 * Created by imake on 20/12/2015.
 */
@XStreamAlias("DOFWarFishingVesselUpdate")
public class FishingVesselUpdate extends ImakeXML implements Serializable {
    private static final long serialVersionUID = 1L;
    private String ship_serial;
    private	String	abort_flag;
    private String ship_code;
    private String tha_name;
    private String tgross;
    private String use_bound_name;
    private String use_type_name;
    private String use_status_name;
    private String date_reg;
    private String date_expire;
    
    public FishingVesselUpdate(){

    }
    public FishingVesselUpdate(String ship_serial, String abort_flag, String ship_code, String tha_name,
    		String tgross, String use_bound_name, String use_type_name, String use_status_name, 
    		String date_reg, String date_expire) {
    	this.abort_flag = abort_flag;
    	this.ship_serial = ship_serial;
    	this.ship_code = ship_code;
    	this.tha_name = tha_name;
        this.tgross = tgross;
        this.use_bound_name = use_bound_name;
        this.use_type_name = use_type_name;
        this.use_status_name = use_status_name;
        this.date_reg = date_reg;
        this.date_expire = date_expire;
	}
    

	public String getShip_serial() {
		return ship_serial;
	}
	public void setShip_serial(String ship_serial) {
		this.ship_serial = ship_serial;
	}
	
	public String getAbort_flag() {
		return abort_flag;
	}

	public void setAbort_flag(String abort_flag) {
		this.abort_flag = abort_flag;
	}
	public String getShip_code() {
		return ship_code;
	}
	public void setShip_code(String ship_code) {
		this.ship_code = ship_code;
	}
	public String getTha_name() {
		return tha_name;
	}
	public void setTha_name(String tha_name) {
		this.tha_name = tha_name;
	}
	public String getTgross() {
		return tgross;
	}
	public void setTgross(String tgross) {
		this.tgross = tgross;
	}
	public String getUse_bound_name() {
		return use_bound_name;
	}
	public void setUse_bound_name(String use_bound_name) {
		this.use_bound_name = use_bound_name;
	}
	public String getUse_type_name() {
		return use_type_name;
	}
	public void setUse_type_name(String use_type_name) {
		this.use_type_name = use_type_name;
	}
	public String getUse_status_name() {
		return use_status_name;
	}
	public void setUse_status_name(String use_status_name) {
		this.use_status_name = use_status_name;
	}
	public String getDate_reg() {
		return date_reg;
	}
	public void setDate_reg(String date_reg) {
		this.date_reg = date_reg;
	}
	public String getDate_expire() {
		return date_expire;
	}
	public void setDate_expire(String date_expire) {
		this.date_expire = date_expire;
	}

}
