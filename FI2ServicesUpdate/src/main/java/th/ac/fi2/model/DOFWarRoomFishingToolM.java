package th.ac.fi2.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import th.ac.fi2.xstream.common.ImakeXML;

import java.io.Serializable;
import java.sql.Timestamp;
import java.sql.Date;

/**
 * Created by imake on 20/12/2015.
 */

@XStreamAlias("DOFWarRoomFishingTool")
public class DOFWarRoomFishingToolM extends ImakeXML implements Serializable {
    private static final long serialVersionUID = 1L;

    private java.lang.Integer yearReg;
    private String boatPermit;
    private String boatRegNo;
    private String fishingType;
    private String fishingTool;
    private Date date_permit;
    private Date date_expire;
    private Double fishing_tool_width;
    private Double fishing_tool_length;
    private Double fishing_tool_qty;
    private String fishing_tool_uom;
    private Timestamp write_date;
    public DOFWarRoomFishingToolM(){

    }
    public DOFWarRoomFishingToolM(Integer yearReg, String boatPermit, String boatRegNo, String fishingType, String fishingTool, Date date_permit, Date date_expire, Double fishing_tool_width, Double fishing_tool_length, Double fishing_tool_qty, String fishing_tool_uom, Timestamp write_date) {
        this.yearReg = yearReg;
        this.boatPermit = boatPermit;
        this.boatRegNo = boatRegNo;
        this.fishingType = fishingType;
        this.fishingTool = fishingTool;
        this.date_permit = date_permit;
        this.date_expire = date_expire;
        this.fishing_tool_width = fishing_tool_width;
        this.fishing_tool_length = fishing_tool_length;
        this.fishing_tool_qty = fishing_tool_qty;
        this.fishing_tool_uom = fishing_tool_uom;
        this.write_date = write_date;
    }

    public Integer getYearReg() {
        return yearReg;
    }

    public void setYearReg(Integer yearReg) {
        this.yearReg = yearReg;
    }

    public String getBoatPermit() {
        return boatPermit;
    }

    public void setBoatPermit(String boatPermit) {
        this.boatPermit = boatPermit;
    }

    public String getBoatRegNo() {
        return boatRegNo;
    }

    public void setBoatRegNo(String boatRegNo) {
        this.boatRegNo = boatRegNo;
    }

    public String getFishingType() {
        return fishingType;
    }

    public void setFishingType(String fishingType) {
        this.fishingType = fishingType;
    }

    public String getFishingTool() {
        return fishingTool;
    }

    public void setFishingTool(String fishingTool) {
        this.fishingTool = fishingTool;
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

    public Double getFishing_tool_width() {
        return fishing_tool_width;
    }

    public void setFishing_tool_width(Double fishing_tool_width) {
        this.fishing_tool_width = fishing_tool_width;
    }

    public Double getFishing_tool_length() {
        return fishing_tool_length;
    }

    public void setFishing_tool_length(Double fishing_tool_length) {
        this.fishing_tool_length = fishing_tool_length;
    }

    public Double getFishing_tool_qty() {
        return fishing_tool_qty;
    }

    public void setFishing_tool_qty(Double fishing_tool_qty) {
        this.fishing_tool_qty = fishing_tool_qty;
    }

    public String getFishing_tool_uom() {
        return fishing_tool_uom;
    }

    public void setFishing_tool_uom(String fishing_tool_uom) {
        this.fishing_tool_uom = fishing_tool_uom;
    }

    public Timestamp getWrite_date() {
        return write_date;
    }

    public void setWrite_date(Timestamp write_date) {
        this.write_date = write_date;
    }
}
