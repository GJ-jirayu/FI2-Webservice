package th.ac.fi2.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class ShipMachinePKey implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="SHIP_SERIAL_ID")
	private Integer shipSerialId;
	
	@Id
	@Column(name="SEQ")
	private Integer seq;
	
	
    public ShipMachinePKey(){
    	
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof ShipMachinePKey){
        	ShipMachinePKey shipMachinePKey = (ShipMachinePKey) obj;
 
            if(!shipMachinePKey.getShipSerialId().equals(shipSerialId)){
                return false;
            }
 
            if(!shipMachinePKey.getSeq().equals(seq)){
                return false;
            }
 
            return true;
        }
 
        return false;
    }
 
    @Override
    public int hashCode() {
        return shipSerialId.hashCode() + seq.hashCode();
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
    
    
        
}
