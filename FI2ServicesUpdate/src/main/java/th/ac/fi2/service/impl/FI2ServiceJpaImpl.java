package th.ac.fi2.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import th.ac.fi2.constant.ServiceConstant;
import th.ac.fi2.model.DOFWarRoomFishingToolM;
import th.ac.fi2.model.FishingVesselM;
import th.ac.fi2.model.FishingVesselMD;
import th.ac.fi2.model.UpdateFishingVesselMsg;
import th.ac.fi2.repository.FI2Repository;
import th.ac.fi2.service.FI2Service;

@Service("fi2ServiceJpaImpl")
public class FI2ServiceJpaImpl implements FI2Service {
	private static final Logger logger = Logger.getLogger(ServiceConstant.LOG_APPENDER);

    @Autowired
    @Qualifier("fi2Repository")
    private FI2Repository fi2Repository;
    
    @Override
    public Boolean getMdExistFishingVesselByShipSerial(String shipSerial){
    	return fi2Repository.getMdExistFishingVesselByShipSerial(shipSerial);
    }
    
    @Override
    public List<UpdateFishingVesselMsg> updateActiveFishingVessel(String shipSerial){
    	return fi2Repository.updateActiveFishingVessel(shipSerial);
    }
    
    @Override
    public List<UpdateFishingVesselMsg> updateAllFieldFishingVessel(String shipSerial) {
    	Integer updateStatus = null;
		String updateStatusDesc = null;
		
    	String fishingVesselResultMsg = fi2Repository.updateAllFieldFishingVessel(shipSerial);
    	logger.info("\n"+fishingVesselResultMsg+"\n");
    	if(fishingVesselResultMsg.equals("SUCCESS")){
    		updateStatus = 1; updateStatusDesc = "Updated Succesfully";
    		String shipOwnerResult = fi2Repository.updateShipOwner(shipSerial);

    		if(shipOwnerResult.equals("SUCCESS")){
    			updateStatus = 1; updateStatusDesc = "Updated Succesfully";
    			String shipmachineResult = fi2Repository.updateShipMachine(shipSerial);

    			if(shipmachineResult.equals("SUCCESS")){
    				updateStatus= 1; updateStatusDesc = "Updated Succesfully";
  
    			}else{
    				//logger.info("\n updateShipMachine Error: "+shipmachineResult+"\n");
    				updateStatus = 0;
    				updateStatusDesc = shipmachineResult;
    			}
    		}else{    			
    			logger.info("\n updateShipOwner Error: "+shipOwnerResult+"\n");
    			updateStatus = 0;
    			updateStatusDesc = shipOwnerResult;
    		}
    	}else{
    		logger.info("\n updateAllFieldFishingVessel Error: "+fishingVesselResultMsg+"\n");
    		updateStatus = 0;
    		updateStatusDesc = fishingVesselResultMsg;
    	}  	
    	
    	List<UpdateFishingVesselMsg> updateFishingVesselMsgs = new ArrayList<UpdateFishingVesselMsg>();
		String action = "Update/Insert";
		String actionDesc = "fishing_vessel, ship_owner, ship_machine : ship_serial = "+shipSerial;
		String status = updateStatus.toString();
		String statusDesc = updateStatusDesc;
		UpdateFishingVesselMsg	updateFishingVesselMsg = new UpdateFishingVesselMsg(action, actionDesc, status, statusDesc);
		updateFishingVesselMsgs.add(updateFishingVesselMsg);
		updateFishingVesselMsg.setPaging(null);
    	
    	return updateFishingVesselMsgs;
    }
    
}
