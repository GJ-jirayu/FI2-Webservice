package th.ac.fi2.model;

import java.io.Serializable;
//import java.math.BigDecimal;
//import java.sql.Date;
import java.sql.Timestamp;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import th.ac.fi2.xstream.common.ImakeXML;

/**
 * Created by imake on 20/12/2015.
 */
@XStreamAlias("DOFWarFishingVesselMD")
public class FishingVesselMD extends ImakeXML implements Serializable {
    private static final long serialVersionUID = 1L;
    private	String	abort_date;
    private	String	abort_flag;
    private	String	book_allow_no;
    private	String	book_allow_seq; //private	BigDecimal	book_allow_seq;
    private	String	book_no;
    private	String	book_seq; //private	BigDecimal	book_seq;
    private	String	build_ship_year; 
    private	String	build_ship_year_bc; //private	BigDecimal	build_ship_year_bc;
    private	String	call_name;
    private	String	call_name_en; 
    private	String	cap_cer; 
    private	String	cap_certificate_level; //private	String	cap_certificate_level; 
    private	String	cap_ename; 
    private	String	cap_esurname;
    private	String	cap_name; 
    private	String	cap_surname; 
    private String create_date;
    private	String	date_abort; 
    private	String	date_expire; 
    private	String	date_permit; 
    private	String	date_reg; 
    private	String	date_regth; 
    private	String	date_shipmortgage; 
    private	String	date_shipstatus;
    private	String	date_tl; 
    private	String	date_tl_exp; 
    private	String	date_usestatus; 
    private String 	depth; //private BigDecimal 	depth; 
    private	String	edit_registrar; 
    private	String	egn_cer; //private	BigDecimal	egn_cer; 
    private	String	egn_certificate_level; 
    private	String	egn_ename; 
    private	String	egn_esurname; 
    private	String	egn_name; 
    private	String	egn_surname; 
    private	String	eng_name; 
    private	String	garage; 
    private	String	head_pic; 
    private	String	id; //private	BigDecimal	id; 
    private	String	imo_no; 
    private	String	loc_reg; 
    private	String	loc_reg_fkid; 
    private	String	loc_serial; 
    private String 	machine_cost; //private BigDecimal 	machine_cost; 
    private	String	machine_price_unit; //private	BigDecimal	machine_price_unit; 
    private	String	matter_type; 
    private	String	matter_type_eng; 
    private	String	no_of_deck; //private	BigDecimal	no_of_deck;
    private	String	no_of_feaman; //private	BigDecimal	no_of_feaman;
    private	String	no_of_machine; //private	BigDecimal	no_of_machine;
    private	String	no_of_mast; //private	BigDecimal	no_of_mast;
    private	String	no_of_person; //private	BigDecimal	no_of_person;
    private	String	no_of_screw; //private	BigDecimal	no_of_screw;
    private	String	no_of_tube; //private	BigDecimal	no_of_tube;
    private	String	owner_name; 
    private	String	owner_surname; 
    private	String	owner_type; //private	BigDecimal	owner_type;
    private	String	registrar; 
    private	String	regth_loc; 
    private	String	regth_registrar; 
    private	String	remark; 
    private	String	remark_print_en; 
    private	String	remark_print_th; 
    private	String	ship_allow; 
    private	String	ship_build_loc; 
    private	String	ship_build_loc_eng; 
    private	String	ship_code; 
    private String 	ship_cost; //private BigDecimal 	ship_cost; 
    private	String	ship_eng_type; 
    private	String	ship_flag; 
    private String 	ship_length; //private BigDecimal 	ship_length;
    private String	ship_length1; // private BigDecimal	ship_length1;
    private	String	ship_price_unit; //private	BigDecimal	ship_price_unit; 
    private	String	ship_serial; //private	BigDecimal	ship_serial;
    private	String	ship_status; 
    private	String	ship_type; 
    private	String	tail_pic; 
    private String 	tgross; //private BigDecimal 	tgross;
    private	String	tha_name; 
    private	String	tl_no; 
    private String 	tnet; //private BigDecimal 	tnet;
    private String 	ton; //private BigDecimal 	ton;
    private String 	total_cost; //private BigDecimal 	total_cost;
    private	String	total_price_unit; //private	BigDecimal	total_price_unit;
    private	String	use_bound; //private	BigDecimal	use_bound;
    private	String	use_bound_str; 
    private String 	use_depth; //private BigDecimal 	use_depth;
    private	String	use_status; 
    private	String	use_status_pfk; //private	BigDecimal	use_status_pfk;
    private	String	use_type; 
    private	String	use_type_eng; 
    private	String	use_type_fkid; //private	BigDecimal	use_type_fkid;
    private	String	usebound_desc; 
    private	String	usebound_desc_en; 
    private String 	width; //private BigDecimal 	width; 
    private Timestamp	write_date; 
    
    public FishingVesselMD(){

    }
    public FishingVesselMD(
    		String	abort_date,
    		String	abort_flag,
    		String	book_allow_no,
    		String	book_allow_seq,
    		String	book_no,
    		String	book_seq,
    		String	build_ship_year, 
    		String	build_ship_year_bc,
    		String	call_name,
    		String	call_name_en, 
    		String	cap_cer, 
    		String	cap_certificate_level, 
    		String	cap_ename, 
    		String	cap_esurname,
    		String	cap_name, 
    		String	cap_surname, 
    		String create_date,
    		String	date_abort, 
    		String	date_expire, 
    		String	date_permit, 
    		String	date_reg, 
    		String	date_regth, 
    		String	date_shipmortgage, 
    		String	date_shipstatus,
    		String	date_tl, 
    		String	date_tl_exp, 
    		String	date_usestatus, 
    		String 	depth, 
    		String	edit_registrar, 
    		String	egn_cer, 
    		String	egn_certificate_level, 
    		String	egn_ename, 
    		String	egn_esurname, 
    		String	egn_name, 
    		String	egn_surname, 
    		String	eng_name, 
    		String	garage, 
    		String	head_pic, 
    		String	id, 
    		String	imo_no, 
    		String	loc_reg, 
    		String	loc_reg_fkid, 
    		String	loc_serial, 
    		String 	machine_cost, 
    		String	machine_price_unit, 
    		String	matter_type, 
    		String	matter_type_eng, 
    		String	no_of_deck, 
    		String	no_of_feaman, 
    		String	no_of_machine, 
    		String	no_of_mast, 
    		String	no_of_person, 
    		String	no_of_screw, 
    		String	no_of_tube, 
    		String	owner_name, 
    		String	owner_surname, 
    		String	owner_type, 
    		String	registrar, 
    		String	regth_loc, 
    		String	regth_registrar, 
    		String	remark, 
    		String	remark_print_en, 
    		String	remark_print_th, 
    		String	ship_allow, 
    		String	ship_build_loc, 
    		String	ship_build_loc_eng, 
    		String	ship_code, 
    		String 	ship_cost, 
    		String	ship_eng_type, 
    		String	ship_flag, 
    		String 	ship_length, 
    		String	ship_length1, 
    		String	ship_price_unit, 
    		String	ship_serial,
    		String	ship_status, 
    		String	ship_type, 
    		String	tail_pic, 
    		String 	tgross, 
    		String	tha_name, 
    		String	tl_no, 
    		String 	tnet, 
    		String 	ton, 
    		String 	total_cost, 
    		String	total_price_unit, 
    		String	use_bound, 
    		String	use_bound_str, 
    		String 	use_depth, 
    		String	use_status, 
    		String	use_status_pfk, 
    		String	use_type, 
    		String	use_type_eng, 
    		String	use_type_fkid, 
    		String	usebound_desc, 
    		String	usebound_desc_en, 
    		String 	width, 
    		Timestamp	write_date
    		) {
    	this.abort_date = abort_date;
    	this.abort_flag = abort_flag;
    	this.book_allow_no = book_allow_no;
    	this.book_allow_seq = book_allow_seq;
    	this.book_no = book_no;
    	this.book_seq = book_seq;
    	this.build_ship_year = build_ship_year;
    	this.build_ship_year_bc = build_ship_year_bc;
    	this.call_name = call_name;
    	this.call_name_en = call_name_en;
    	this.cap_cer = cap_cer;
    	this.cap_certificate_level = cap_certificate_level;
    	this.cap_ename = cap_ename;
    	this.cap_esurname = cap_esurname;
    	this.cap_name = cap_name;
    	this.cap_surname = cap_surname;
    	this.create_date = create_date	;
    	this.date_abort = date_abort;
    	this.date_expire = date_expire;
    	this.date_permit = date_permit;
    	this.date_reg = date_reg;
    	this.date_regth = date_regth;
    	this.date_shipmortgage = date_shipmortgage;
    	this.date_shipstatus = date_shipstatus	;
    	this.date_tl = date_tl;
    	this.date_tl_exp = date_tl_exp;
    	this.date_usestatus = date_usestatus;
    	this.depth = depth;
    	this.edit_registrar = edit_registrar;
    	this.egn_cer = egn_cer;
    	this.egn_certificate_level = egn_certificate_level;
    	this.egn_ename = egn_ename;
    	this.egn_esurname = egn_esurname;
    	this.egn_name = egn_name;
    	this.egn_surname = egn_surname;
    	this.eng_name = eng_name;
    	this.garage = garage;
    	this.head_pic = head_pic;
    	this.id = id;
    	this.imo_no = imo_no;
    	this.loc_reg = loc_reg;
    	this.loc_reg_fkid = loc_reg_fkid;
    	this.loc_serial = loc_serial;
    	this.machine_cost = machine_cost;
    	this.machine_price_unit = machine_price_unit;
    	this.matter_type = matter_type;
    	this.matter_type_eng = matter_type_eng;
    	this.no_of_deck = no_of_deck;
    	this.no_of_feaman = no_of_feaman;
    	this.no_of_machine = no_of_machine;
    	this.no_of_mast = no_of_mast;
    	this.no_of_person = no_of_person;
    	this.no_of_screw = no_of_screw;
    	this.no_of_tube = no_of_tube;
    	this.owner_name = owner_name;
    	this.owner_surname = owner_surname;
    	this.owner_type = owner_type;
    	this.registrar = registrar;
    	this.regth_loc = regth_loc;
    	this.regth_registrar = regth_registrar;
    	this.remark = remark;
    	this.remark_print_en = remark_print_en;
    	this.remark_print_th = remark_print_th;
    	this.ship_allow = ship_allow;
    	this.ship_build_loc = ship_build_loc;
    	this.ship_build_loc_eng = ship_build_loc_eng;
    	this.ship_code = ship_code;
    	this.ship_cost = ship_cost;
    	this.ship_eng_type = ship_eng_type;
    	this.ship_flag = ship_flag;
    	this.ship_length = ship_length;
    	this.ship_length1 = ship_length1;
    	this.ship_price_unit = ship_price_unit;
    	this.ship_serial = ship_serial;
    	this.ship_status = ship_status;
    	this.ship_type = ship_type;
    	this.tail_pic = tail_pic;
    	this.tgross = tgross;
    	this.tha_name = tha_name;
    	this.tl_no = tl_no;
    	this.tnet = tnet;
    	this.ton = ton;
    	this.total_cost = total_cost;
    	this.total_price_unit = total_price_unit;
    	this.use_bound = use_bound;
    	this.use_bound_str = use_bound_str;
    	this.use_depth = use_depth;
    	this.use_status = use_status;
    	this.use_status_pfk = use_status_pfk;
    	this.use_type = use_type;
    	this.use_type_eng = use_type_eng;
    	this.use_type_fkid = use_type_fkid;
    	this.usebound_desc = usebound_desc;
    	this.usebound_desc_en = usebound_desc_en;
    	this.width = width;
    	this.write_date = write_date;

	}
	public String getAbort_date() {
		return abort_date;
	}
	public void setAbort_date(String abort_date) {
		this.abort_date = abort_date;
	}
	public String getAbort_flag() {
		return abort_flag;
	}
	public void setAbort_flag(String abort_flag) {
		this.abort_flag = abort_flag;
	}
	public String getBook_allow_no() {
		return book_allow_no;
	}
	public void setBook_allow_no(String book_allow_no) {
		this.book_allow_no = book_allow_no;
	}
	public String getBook_allow_seq() {
		return book_allow_seq;
	}
	public void setBook_allow_seq(String book_allow_seq) {
		this.book_allow_seq = book_allow_seq;
	}
	public String getBook_no() {
		return book_no;
	}
	public void setBook_no(String book_no) {
		this.book_no = book_no;
	}
	public String getBook_seq() {
		return book_seq;
	}
	public void setBook_seq(String book_seq) {
		this.book_seq = book_seq;
	}
	public String getBuild_ship_year() {
		return build_ship_year;
	}
	public void setBuild_ship_year(String build_ship_year) {
		this.build_ship_year = build_ship_year;
	}
	public String getBuild_ship_year_bc() {
		return build_ship_year_bc;
	}
	public void setBuild_ship_year_bc(String build_ship_year_bc) {
		this.build_ship_year_bc = build_ship_year_bc;
	}
	public String getCall_name() {
		return call_name;
	}
	public void setCall_name(String call_name) {
		this.call_name = call_name;
	}
	public String getCall_name_en() {
		return call_name_en;
	}
	public void setCall_name_en(String call_name_en) {
		this.call_name_en = call_name_en;
	}
	public String getCap_cer() {
		return cap_cer;
	}
	public void setCap_cer(String cap_cer) {
		this.cap_cer = cap_cer;
	}
	public String getCap_certificate_level() {
		return cap_certificate_level;
	}
	public void setCap_certificate_level(String cap_certificate_level) {
		this.cap_certificate_level = cap_certificate_level;
	}
	public String getCap_ename() {
		return cap_ename;
	}
	public void setCap_ename(String cap_ename) {
		this.cap_ename = cap_ename;
	}
	public String getCap_esurname() {
		return cap_esurname;
	}
	public void setCap_esurname(String cap_esurname) {
		this.cap_esurname = cap_esurname;
	}
	public String getCap_name() {
		return cap_name;
	}
	public void setCap_name(String cap_name) {
		this.cap_name = cap_name;
	}
	public String getCap_surname() {
		return cap_surname;
	}
	public void setCap_surname(String cap_surname) {
		this.cap_surname = cap_surname;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getDate_abort() {
		return date_abort;
	}
	public void setDate_abort(String date_abort) {
		this.date_abort = date_abort;
	}
	public String getDate_expire() {
		return date_expire;
	}
	public void setDate_expire(String date_expire) {
		this.date_expire = date_expire;
	}
	public String getDate_permit() {
		return date_permit;
	}
	public void setDate_permit(String date_permit) {
		this.date_permit = date_permit;
	}
	public String getDate_reg() {
		return date_reg;
	}
	public void setDate_reg(String date_reg) {
		this.date_reg = date_reg;
	}
	public String getDate_regth() {
		return date_regth;
	}
	public void setDate_regth(String date_regth) {
		this.date_regth = date_regth;
	}
	public String getDate_shipmortgage() {
		return date_shipmortgage;
	}
	public void setDate_shipmortgage(String date_shipmortgage) {
		this.date_shipmortgage = date_shipmortgage;
	}
	public String getDate_shipstatus() {
		return date_shipstatus;
	}
	public void setDate_shipstatus(String date_shipstatus) {
		this.date_shipstatus = date_shipstatus;
	}
	public String getDate_tl() {
		return date_tl;
	}
	public void setDate_tl(String date_tl) {
		this.date_tl = date_tl;
	}
	public String getDate_tl_exp() {
		return date_tl_exp;
	}
	public void setDate_tl_exp(String date_tl_exp) {
		this.date_tl_exp = date_tl_exp;
	}
	public String getDate_usestatus() {
		return date_usestatus;
	}
	public void setDate_usestatus(String date_usestatus) {
		this.date_usestatus = date_usestatus;
	}
	public String getDepth() {
		return depth;
	}
	public void setDepth(String depth) {
		this.depth = depth;
	}
	public String getEdit_registrar() {
		return edit_registrar;
	}
	public void setEdit_registrar(String edit_registrar) {
		this.edit_registrar = edit_registrar;
	}
	public String getEgn_cer() {
		return egn_cer;
	}
	public void setEgn_cer(String egn_cer) {
		this.egn_cer = egn_cer;
	}
	public String getEgn_certificate_level() {
		return egn_certificate_level;
	}
	public void setEgn_certificate_level(String egn_certificate_level) {
		this.egn_certificate_level = egn_certificate_level;
	}
	public String getEgn_ename() {
		return egn_ename;
	}
	public void setEgn_ename(String egn_ename) {
		this.egn_ename = egn_ename;
	}
	public String getEgn_esurname() {
		return egn_esurname;
	}
	public void setEgn_esurname(String egn_esurname) {
		this.egn_esurname = egn_esurname;
	}
	public String getEgn_name() {
		return egn_name;
	}
	public void setEgn_name(String egn_name) {
		this.egn_name = egn_name;
	}
	public String getEgn_surname() {
		return egn_surname;
	}
	public void setEgn_surname(String egn_surname) {
		this.egn_surname = egn_surname;
	}
	public String getEng_name() {
		return eng_name;
	}
	public void setEng_name(String eng_name) {
		this.eng_name = eng_name;
	}
	public String getGarage() {
		return garage;
	}
	public void setGarage(String garage) {
		this.garage = garage;
	}
	public String getHead_pic() {
		return head_pic;
	}
	public void setHead_pic(String head_pic) {
		this.head_pic = head_pic;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getImo_no() {
		return imo_no;
	}
	public void setImo_no(String imo_no) {
		this.imo_no = imo_no;
	}
	public String getLoc_reg() {
		return loc_reg;
	}
	public void setLoc_reg(String loc_reg) {
		this.loc_reg = loc_reg;
	}
	public String getLoc_reg_fkid() {
		return loc_reg_fkid;
	}
	public void setLoc_reg_fkid(String loc_reg_fkid) {
		this.loc_reg_fkid = loc_reg_fkid;
	}
	public String getLoc_serial() {
		return loc_serial;
	}
	public void setLoc_serial(String loc_serial) {
		this.loc_serial = loc_serial;
	}
	public String getMachine_cost() {
		return machine_cost;
	}
	public void setMachine_cost(String machine_cost) {
		this.machine_cost = machine_cost;
	}
	public String getMachine_price_unit() {
		return machine_price_unit;
	}
	public void setMachine_price_unit(String machine_price_unit) {
		this.machine_price_unit = machine_price_unit;
	}
	public String getMatter_type() {
		return matter_type;
	}
	public void setMatter_type(String matter_type) {
		this.matter_type = matter_type;
	}
	public String getMatter_type_eng() {
		return matter_type_eng;
	}
	public void setMatter_type_eng(String matter_type_eng) {
		this.matter_type_eng = matter_type_eng;
	}
	public String getNo_of_deck() {
		return no_of_deck;
	}
	public void setNo_of_deck(String no_of_deck) {
		this.no_of_deck = no_of_deck;
	}
	public String getNo_of_feaman() {
		return no_of_feaman;
	}
	public void setNo_of_feaman(String no_of_feaman) {
		this.no_of_feaman = no_of_feaman;
	}
	public String getNo_of_machine() {
		return no_of_machine;
	}
	public void setNo_of_machine(String no_of_machine) {
		this.no_of_machine = no_of_machine;
	}
	public String getNo_of_mast() {
		return no_of_mast;
	}
	public void setNo_of_mast(String no_of_mast) {
		this.no_of_mast = no_of_mast;
	}
	public String getNo_of_person() {
		return no_of_person;
	}
	public void setNo_of_person(String no_of_person) {
		this.no_of_person = no_of_person;
	}
	public String getNo_of_screw() {
		return no_of_screw;
	}
	public void setNo_of_screw(String no_of_screw) {
		this.no_of_screw = no_of_screw;
	}
	public String getNo_of_tube() {
		return no_of_tube;
	}
	public void setNo_of_tube(String no_of_tube) {
		this.no_of_tube = no_of_tube;
	}
	public String getOwner_name() {
		return owner_name;
	}
	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}
	public String getOwner_surname() {
		return owner_surname;
	}
	public void setOwner_surname(String owner_surname) {
		this.owner_surname = owner_surname;
	}
	public String getOwner_type() {
		return owner_type;
	}
	public void setOwner_type(String owner_type) {
		this.owner_type = owner_type;
	}
	public String getRegistrar() {
		return registrar;
	}
	public void setRegistrar(String registrar) {
		this.registrar = registrar;
	}
	public String getRegth_loc() {
		return regth_loc;
	}
	public void setRegth_loc(String regth_loc) {
		this.regth_loc = regth_loc;
	}
	public String getRegth_registrar() {
		return regth_registrar;
	}
	public void setRegth_registrar(String regth_registrar) {
		this.regth_registrar = regth_registrar;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getRemark_print_en() {
		return remark_print_en;
	}
	public void setRemark_print_en(String remark_print_en) {
		this.remark_print_en = remark_print_en;
	}
	public String getRemark_print_th() {
		return remark_print_th;
	}
	public void setRemark_print_th(String remark_print_th) {
		this.remark_print_th = remark_print_th;
	}
	public String getShip_allow() {
		return ship_allow;
	}
	public void setShip_allow(String ship_allow) {
		this.ship_allow = ship_allow;
	}
	public String getShip_build_loc() {
		return ship_build_loc;
	}
	public void setShip_build_loc(String ship_build_loc) {
		this.ship_build_loc = ship_build_loc;
	}
	public String getShip_build_loc_eng() {
		return ship_build_loc_eng;
	}
	public void setShip_build_loc_eng(String ship_build_loc_eng) {
		this.ship_build_loc_eng = ship_build_loc_eng;
	}
	public String getShip_code() {
		return ship_code;
	}
	public void setShip_code(String ship_code) {
		this.ship_code = ship_code;
	}
	public String getShip_cost() {
		return ship_cost;
	}
	public void setShip_cost(String ship_cost) {
		this.ship_cost = ship_cost;
	}
	public String getShip_eng_type() {
		return ship_eng_type;
	}
	public void setShip_eng_type(String ship_eng_type) {
		this.ship_eng_type = ship_eng_type;
	}
	public String getShip_flag() {
		return ship_flag;
	}
	public void setShip_flag(String ship_flag) {
		this.ship_flag = ship_flag;
	}
	public String getShip_length() {
		return ship_length;
	}
	public void setShip_length(String ship_length) {
		this.ship_length = ship_length;
	}
	public String getShip_length1() {
		return ship_length1;
	}
	public void setShip_length1(String ship_length1) {
		this.ship_length1 = ship_length1;
	}
	public String getShip_price_unit() {
		return ship_price_unit;
	}
	public void setShip_price_unit(String ship_price_unit) {
		this.ship_price_unit = ship_price_unit;
	}
	public String getShip_serial() {
		return ship_serial;
	}
	public void setShip_serial(String ship_serial) {
		this.ship_serial = ship_serial;
	}
	public String getShip_status() {
		return ship_status;
	}
	public void setShip_status(String ship_status) {
		this.ship_status = ship_status;
	}
	public String getShip_type() {
		return ship_type;
	}
	public void setShip_type(String ship_type) {
		this.ship_type = ship_type;
	}
	public String getTail_pic() {
		return tail_pic;
	}
	public void setTail_pic(String tail_pic) {
		this.tail_pic = tail_pic;
	}
	public String getTgross() {
		return tgross;
	}
	public void setTgross(String tgross) {
		this.tgross = tgross;
	}
	public String getTha_name() {
		return tha_name;
	}
	public void setTha_name(String tha_name) {
		this.tha_name = tha_name;
	}
	public String getTl_no() {
		return tl_no;
	}
	public void setTl_no(String tl_no) {
		this.tl_no = tl_no;
	}
	public String getTnet() {
		return tnet;
	}
	public void setTnet(String tnet) {
		this.tnet = tnet;
	}
	public String getTon() {
		return ton;
	}
	public void setTon(String ton) {
		this.ton = ton;
	}
	public String getTotal_cost() {
		return total_cost;
	}
	public void setTotal_cost(String total_cost) {
		this.total_cost = total_cost;
	}
	public String getTotal_price_unit() {
		return total_price_unit;
	}
	public void setTotal_price_unit(String total_price_unit) {
		this.total_price_unit = total_price_unit;
	}
	public String getUse_bound() {
		return use_bound;
	}
	public void setUse_bound(String use_bound) {
		this.use_bound = use_bound;
	}
	public String getUse_bound_str() {
		return use_bound_str;
	}
	public void setUse_bound_str(String use_bound_str) {
		this.use_bound_str = use_bound_str;
	}
	public String getUse_depth() {
		return use_depth;
	}
	public void setUse_depth(String use_depth) {
		this.use_depth = use_depth;
	}
	public String getUse_status() {
		return use_status;
	}
	public void setUse_status(String use_status) {
		this.use_status = use_status;
	}
	public String getUse_status_pfk() {
		return use_status_pfk;
	}
	public void setUse_status_pfk(String use_status_pfk) {
		this.use_status_pfk = use_status_pfk;
	}
	public String getUse_type() {
		return use_type;
	}
	public void setUse_type(String use_type) {
		this.use_type = use_type;
	}
	public String getUse_type_eng() {
		return use_type_eng;
	}
	public void setUse_type_eng(String use_type_eng) {
		this.use_type_eng = use_type_eng;
	}
	public String getUse_type_fkid() {
		return use_type_fkid;
	}
	public void setUse_type_fkid(String use_type_fkid) {
		this.use_type_fkid = use_type_fkid;
	}
	public String getUsebound_desc() {
		return usebound_desc;
	}
	public void setUsebound_desc(String usebound_desc) {
		this.usebound_desc = usebound_desc;
	}
	public String getUsebound_desc_en() {
		return usebound_desc_en;
	}
	public void setUsebound_desc_en(String usebound_desc_en) {
		this.usebound_desc_en = usebound_desc_en;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public Timestamp getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Timestamp write_date) {
		this.write_date = write_date;
	}

}
