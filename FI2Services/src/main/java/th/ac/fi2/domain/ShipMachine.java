package th.ac.fi2.domain;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat.Value;


@Entity
@Table(name="ship_machine")
@IdClass(value=ShipMachinePKey.class)
public class ShipMachine implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="SHIP_SERIAL_ID")
	private Integer shipSerialId;
	
	@Id
	@Column(name="SEQ")
	private Integer seq;
	
	@Column(name="USERNAME")
	private String userName;
	
	@Column(name="LASTUPDATE")
	private Date lastupdate;
	
	@Column(name="POWER2")
	private Double power2;

	@Column(name="CREATE_DATE")
	private Timestamp createDate;
	
	@Column(name="MACHINE_NO")
	private String machineNo;
	
	@Column(name="MACHINE_TYPE_FKID")
	private Integer machineTypeFkid;
	
	@Column(name="MACHINE_POWER1")
	private Double machinePower1;
	
	@Column(name="MACHINE_TYPE_STR")
	private String machineTypeStr;
	
	@Column(name="MACHINE_POWER2")
	private Double machinePower2;
	
	@Column(name="NO_OF_PISTON")
	private Integer noOfPiston;
	
	@Column(name="MACHINE_COST")
	private Double machineCost;
	
	@Column(name="WRITE_DATE")
	private Timestamp writeDate;
	
	@Column(name="MACHINE_BRAND_STR")
	private String machineBrandStr;
	
	@Column(name="MACHINE_BRAND_FKID")
	private Integer machineBrandFkid;
	
	@Column(name="POWER1")
	private Double power1;
	
	@Column(name="ACTIVE")
	private Boolean active;
	
	
	public ShipMachine(){
    	
    }

	
	public Integer getShipSerialId() {
		return shipSerialId;
	}

	public void setShipSerialId(Integer shipSerialId) {
		this.shipSerialId = shipSerialId;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getLastupdate() {
		return lastupdate;
	}

	public void setLastupdate(Date lastupdate) {
		this.lastupdate = lastupdate;
	}

	public Double getPower2() {
		return power2;
	}

	public void setPower2(Double power2) {
		this.power2 = power2;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getMachineNo() {
		return machineNo;
	}

	public void setMachineNo(String machineNo) {
		this.machineNo = machineNo;
	}

	public Integer getMachineTypeFkid() {
		return machineTypeFkid;
	}

	public void setMachineTypeFkid(Integer machineTypeFkid) {
		this.machineTypeFkid = machineTypeFkid;
	}

	public Double getMachinePower1() {
		return machinePower1;
	}

	public void setMachinePower1(Double machinePower1) {
		this.machinePower1 = machinePower1;
	}

	public String getMachineTypeStr() {
		return machineTypeStr;
	}

	public void setMachineTypeStr(String machineType_str) {
		this.machineTypeStr = machineType_str;
	}

	public Double getMachinePower2() {
		return machinePower2;
	}

	public void setMachinePower2(Double machinePower2) {
		this.machinePower2 = machinePower2;
	}

	public Integer getNoOfPiston() {
		return noOfPiston;
	}

	public void setNoOfPiston(Integer noOfPiston) {
		this.noOfPiston = noOfPiston;
	}

	public Double getMachineCost() {
		return machineCost;
	}

	public void setMachineCost(Double machineCost) {
		this.machineCost = machineCost;
	}

	public Timestamp getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Timestamp writeDate) {
		this.writeDate = writeDate;
	}

	public String getMachineBrandStr() {
		return machineBrandStr;
	}

	public void setMachineBrandStr(String machineBrandStr) {
		this.machineBrandStr = machineBrandStr;
	}

	public Integer getMachineBrandFkid() {
		return machineBrandFkid;
	}

	public void setMachineBrandFkid(Integer machineBrandFkid) {
		this.machineBrandFkid = machineBrandFkid;
	}

	public Double getPower1() {
		return power1;
	}

	public void setPower1(Double power1) {
		this.power1 = power1;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
