package th.ac.fi2.service;

import java.util.List;

import th.ac.fi2.model.DOFWarRoomFishingToolM;
import th.ac.fi2.model.FishingVesselM;
import th.ac.fi2.model.FishingVesselMD;
import th.ac.fi2.model.FishingVesselUpdate;
import th.ac.fi2.model.UpdateFishingVesselMsg;

public interface FI2Service {
	
    public Boolean getMdExistFishingVesselByShipSerial(String shipSerial);
    public List<UpdateFishingVesselMsg> updateActiveFishingVessel(String shipSerial);
    public List<UpdateFishingVesselMsg> updateAllFieldFishingVessel(String shipSerial) ;
    
}
