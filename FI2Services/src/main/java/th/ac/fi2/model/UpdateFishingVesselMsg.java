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
@XStreamAlias("WSFishingVessel")
public class UpdateFishingVesselMsg extends ImakeXML implements Serializable {
    private static final long serialVersionUID = 1L;
    private String action;
    private	String	actionDesc;
    private String status;
    private String statusDesc;
    
    public UpdateFishingVesselMsg(){

    }
    public UpdateFishingVesselMsg(String action, String actionDesc, String status, String statusDesc) {
    	this.action = action;
    	this.actionDesc = actionDesc;
    	this.status = status;
    	this.statusDesc = statusDesc;

	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getActionDesc() {
		return actionDesc;
	}
	public void setActionDesc(String actionDesc) {
		this.actionDesc = actionDesc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatusDesc() {
		return statusDesc;
	}
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}
    
}
