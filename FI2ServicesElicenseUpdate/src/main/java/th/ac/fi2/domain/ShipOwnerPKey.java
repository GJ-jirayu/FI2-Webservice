package th.ac.fi2.domain;

import java.io.Serializable;

public class ShipOwnerPKey implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer shipSerialId;
	private Integer seq;	
	
    public ShipOwnerPKey(){
    	
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof ShipOwnerPKey){
        	ShipOwnerPKey shipOwnerPKey = (ShipOwnerPKey) obj;
 
            if(!shipOwnerPKey.getShipSerialId().equals(shipSerialId)){
                return false;
            }
 
            if(!shipOwnerPKey.getSeq().equals(seq)){
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
