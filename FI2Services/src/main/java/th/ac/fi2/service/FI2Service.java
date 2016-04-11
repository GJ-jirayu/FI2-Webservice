package th.ac.fi2.service;

import java.util.List;

import th.ac.fi2.model.DOFWarRoomFishingToolM;
import th.ac.fi2.model.FishingLicenseInfo;
import th.ac.fi2.model.FishingVesselInfo;
import th.ac.fi2.model.FishingVesselM;
import th.ac.fi2.model.FishingVesselMD;
import th.ac.fi2.model.ShipOwnerHist;

public interface FI2Service {

    public List<FishingVesselM> getFishingVesselByShipCode(String shipCode);
    
    public List<DOFWarRoomFishingToolM> getDOFWarRoomFishingToolByFisheryYearAndShipLicense(String fishery_year, String number_tool);
    
    public List<FishingVesselMD> getDOFWarFishingVesselByShipSerial(String shipSerial);
    
    public List<FishingLicenseInfo> getFishingLicenseInfoByShipCode(String ShipCode);
    
    public List<FishingVesselInfo> getFishingVesselInfoByShipCode(String ShipCode);
    
    public List<ShipOwnerHist> getShipOwnerHistByShipCode(String ShipCode);
}
