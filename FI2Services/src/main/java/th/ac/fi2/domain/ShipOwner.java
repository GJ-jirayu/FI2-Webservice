package th.ac.fi2.domain;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


@Entity
@Table(name="ship_owner")
@IdClass(value=ShipOwnerPKey.class)
public class ShipOwner implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/*@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID") 
	private	Integer id;*/
	
	@Id
	@Column(name="SHIP_SERIAL_ID")
	private Integer shipSerialId;
	
	@Id
	@Column(name="SEQ")
	private Integer seq;
	
	@Column(name="ABORT_DATE") 
	private	Date abortDate;
	
	@Column(name="ABORT_FLAG")
	private String abortFlag;
	
	@Column(name="ACTIVE")
	private Boolean action;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="ADDRESS_EN")
	private String addressEn;
	
	@Column(name="CAREER")
	private String career;
	
	@Column(name="CITIZEN")
	private String citizen;

	@Column(name="CITIZEN_FKID")
	private Integer citizenFkid;
	
	@Column(name="CREATE_DATE")
	private Timestamp createDate;
	
	@Column(name="CREATE_UID")
	private Integer createUid;
	
	@Column(name="DATE_LASTUPDATE")
	private Date dateLastupdate;
	
	@Column(name="DATE_TRANSFER")
	private String dateTransfer;
	
	@Column(name="DOC_REFER")
	private String docRefer;
	
	@Column(name="ENAME")
	private String ename;
	
	@Column(name="ESURNAME")
	private String esurname;
	
	@Column(name="LOC_PROMISS")
	private String locPromiss;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="OWNER_AMP")
	private String ownerAmp;
	
	@Column(name="OWNER_NAME")
	private String ownerName;
	
	@Column(name="OWNER_PROV")
	private String ownerProv;
	
	@Column(name="OWNER_SEQ")
	private String ownerSeq;
	
	@Column(name="OWNER_SURNAME")
	private String ownerSurname;
	
	@Column(name="PIN_CHARACTER")
	private String pinCharacter;
	
	@Column(name="PROMISE_NO")
	private String promiseNo;
	
	@Column(name="PROMISE_YY")
	private String promiseYy;
	
	@Column(name="REMARK")
	private String remark;
	
	@Column(name="SIGNATURE_PATH")
	private String signaturePath;
	
	@Column(name="SURNAME")
	private String surname;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="TITLE_FKID")
	private String titleFkid;
	
	@Column(name="TRANSFERRED_DATE")
	private Date transferresDate;
	
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="WRITE_DATE")
	private Timestamp writeDate;
	
	@Column(name="WRITE_UID")
	private Integer writeUid;
	
    public ShipOwner(){
    	
    }

	/*public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}*/

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

	public Boolean getAction() {
		return action;
	}

	public void setAction(Boolean action) {
		this.action = action;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressEn() {
		return addressEn;
	}

	public void setAddressEn(String addressEn) {
		this.addressEn = addressEn;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public String getCitizen() {
		return citizen;
	}

	public void setCitizen(String citizen) {
		this.citizen = citizen;
	}

	public Integer getCitizenFkid() {
		return citizenFkid;
	}

	public void setCitizenFkid(Integer citizenFkid) {
		this.citizenFkid = citizenFkid;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Integer getCreateUid() {
		return createUid;
	}

	public void setCreateUid(Integer createUid) {
		this.createUid = createUid;
	}

	public Date getDateLastupdate() {
		return dateLastupdate;
	}

	public void setDateLastupdate(Date dateLastupdate) {
		this.dateLastupdate = dateLastupdate;
	}

	public String getDateTransfer() {
		return dateTransfer;
	}

	public void setDateTransfer(String dateTransfer) {
		this.dateTransfer = dateTransfer;
	}

	public String getDocRefer() {
		return docRefer;
	}

	public void setDocRefer(String docRefer) {
		this.docRefer = docRefer;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEsurname() {
		return esurname;
	}

	public void setEsurname(String esurname) {
		this.esurname = esurname;
	}

	public String getLocPromiss() {
		return locPromiss;
	}

	public void setLocPromiss(String locPromiss) {
		this.locPromiss = locPromiss;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwnerAmp() {
		return ownerAmp;
	}

	public void setOwnerAmp(String ownerAmp) {
		this.ownerAmp = ownerAmp;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerProv() {
		return ownerProv;
	}

	public void setOwnerProv(String ownerProv) {
		this.ownerProv = ownerProv;
	}

	public String getOwnerSeq() {
		return ownerSeq;
	}

	public void setOwnerSeq(String ownerSeq) {
		this.ownerSeq = ownerSeq;
	}

	public String getOwnerSurname() {
		return ownerSurname;
	}

	public void setOwnerSurname(String ownerSurname) {
		this.ownerSurname = ownerSurname;
	}

	public String getPinCharacter() {
		return pinCharacter;
	}

	public void setPinCharacter(String pinCharacter) {
		this.pinCharacter = pinCharacter;
	}

	public String getPromiseNo() {
		return promiseNo;
	}

	public void setPromiseNo(String promiseNo) {
		this.promiseNo = promiseNo;
	}

	public String getPromiseYy() {
		return promiseYy;
	}

	public void setPromiseYy(String promiseYy) {
		this.promiseYy = promiseYy;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSignaturePath() {
		return signaturePath;
	}

	public void setSignaturePath(String signaturePath) {
		this.signaturePath = signaturePath;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitleFkid() {
		return titleFkid;
	}

	public void setTitleFkid(String titleFkid) {
		this.titleFkid = titleFkid;
	}

	public Date getTransferresDate() {
		return transferresDate;
	}

	public void setTransferresDate(Date transferresDate) {
		this.transferresDate = transferresDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Timestamp getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Timestamp writeDate) {
		this.writeDate = writeDate;
	}

	public Integer getWriteUid() {
		return writeUid;
	}

	public void setWriteUid(Integer writeUid) {
		this.writeUid = writeUid;
	}
        
}
