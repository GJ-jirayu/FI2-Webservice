package th.ac.fi2.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import th.ac.fi2.xstream.common.ImakeXML;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by imake on 20/12/2015.
 */
@XStreamAlias("DOFWarRoomBoat")
public class FishingVesselM extends ImakeXML implements Serializable {
    private static final long serialVersionUID = 1L;
    private String boatName;
    private String boatRegNo;
    private String ownerName;
    private Double boatLong;
    private Double boatWide;
    private Double deep;
    private String boatTypeEngine;
    private Double tonGross;
    private Integer noofMachine;
    private Date date_permit;
    private Date date_expire;
    public FishingVesselM(){

    }
    public FishingVesselM(String boatName, String boatRegNo, String ownerName, Double boatLong, Double boatWide, Double deep, String boatTypeEngine, Double tonGross, Integer noofMachine, Date date_permit, Date date_expire) {
        this.boatName = boatName;
        this.boatRegNo = boatRegNo;
        this.ownerName = ownerName;
        this.boatLong = boatLong;
        this.boatWide = boatWide;
        this.deep = deep;
        this.boatTypeEngine = boatTypeEngine;
        this.tonGross = tonGross;
        this.noofMachine = noofMachine;
        this.date_permit = date_permit;
        this.date_expire = date_expire;
    }

    public String getBoatName() {
        return boatName;
    }

    public void setBoatName(String boatName) {
        this.boatName = boatName;
    }

    public String getBoatRegNo() {
        return boatRegNo;
    }

    public void setBoatRegNo(String boatRegNo) {
        this.boatRegNo = boatRegNo;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Double getBoatLong() {
        return boatLong;
    }

    public void setBoatLong(Double boatLong) {
        this.boatLong = boatLong;
    }

    public Double getBoatWide() {
        return boatWide;
    }

    public void setBoatWide(Double boatWide) {
        this.boatWide = boatWide;
    }

    public Double getDeep() {
        return deep;
    }

    public void setDeep(Double deep) {
        this.deep = deep;
    }

    public String getBoatTypeEngine() {
        return boatTypeEngine;
    }

    public void setBoatTypeEngine(String boatTypeEngine) {
        this.boatTypeEngine = boatTypeEngine;
    }

    public Double getTonGross() {
        return tonGross;
    }

    public void setTonGross(Double tonGross) {
        this.tonGross = tonGross;
    }

    public Integer getNoofMachine() {
        return noofMachine;
    }

    public void setNoofMachine(Integer noofMachine) {
        this.noofMachine = noofMachine;
    }

    public Date getDate_permit() {
        return date_permit;
    }

    public void setDate_permit(Date date_permit) {
        this.date_permit = date_permit;
    }

    public Date getDate_expire() {
        return date_expire;
    }

    public void setDate_expire(Date date_expire) {
        this.date_expire = date_expire;
    }
}
