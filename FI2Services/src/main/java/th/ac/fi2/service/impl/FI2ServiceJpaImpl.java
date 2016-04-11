package th.ac.fi2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import th.ac.fi2.model.DOFWarRoomFishingToolM;
import th.ac.fi2.model.FishingLicenseInfo;
import th.ac.fi2.model.FishingVesselInfo;
import th.ac.fi2.model.FishingVesselM;
import th.ac.fi2.model.FishingVesselMD;
import th.ac.fi2.model.ShipOwnerHist;
import th.ac.fi2.repository.FI2Repository;
import th.ac.fi2.service.FI2Service;

@Service("fi2ServiceJpaImpl")
public class FI2ServiceJpaImpl implements FI2Service {
	@Autowired
    @Qualifier("fi2Repository")
    private FI2Repository fi2Repository;

    @Override
    public List<FishingVesselM> getFishingVesselByShipCode(String shipCode) {
        return fi2Repository.getFishingVesselByShipCode(shipCode);
    }

    @Override
    public List<DOFWarRoomFishingToolM> getDOFWarRoomFishingToolByFisheryYearAndShipLicense(String fishery_year, String number_tool) {
        return fi2Repository.getDOFWarRoomFishingToolByFisheryYearAndShipLicense(fishery_year,number_tool);
    }

    @Override
    public List<FishingVesselMD> getDOFWarFishingVesselByShipSerial(String shipSerial) {
        return fi2Repository.getFishingVesselMDByShipSerial(shipSerial);
    }
    
    @Override
    public List<FishingLicenseInfo> getFishingLicenseInfoByShipCode(String ShipCode) {
        return fi2Repository.getFishingLicenseInfoByShipCode(ShipCode);
    }
    
    @Override
    public List<FishingVesselInfo> getFishingVesselInfoByShipCode(String ShipCode) {
        return fi2Repository.getFishingVesselInfoByShipCode(ShipCode);
    }
    
    @Override
    public List<ShipOwnerHist> getShipOwnerHistByShipCode(String ShipCode) {
        return fi2Repository.getShipOwnerHistByShipCode(ShipCode);
    }
     
}
