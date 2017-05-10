package th.ac.fi2.rest.resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.restlet.representation.Representation;
import org.restlet.representation.Variant;
import org.restlet.resource.ResourceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import th.ac.fi2.constant.ServiceConstant;
import th.ac.fi2.model.DOFWarRoomFishingToolM;
import th.ac.fi2.model.FishingLicenseInfo;
import th.ac.fi2.model.FishingVesselInfo;
import th.ac.fi2.model.FishingVesselM;
import th.ac.fi2.model.FishingVesselMD;
import th.ac.fi2.model.FishingVesselUpdate;
import th.ac.fi2.model.ShipOwnerHist;
import th.ac.fi2.model.UpdateFishingVesselMsg;
import th.ac.fi2.service.FI2Service;
import th.ac.fi2.xstream.common.ImakeResultMessage;
import th.ac.fi2.xstream.common.Paging;

public class FishingVesselResource extends BaseResource {
    private static final Logger logger = Logger.getLogger(ServiceConstant.LOG_APPENDER);
    @Autowired
    @Qualifier("fi2ServiceJpaImpl")
    private FI2Service fi2Service;

    @Autowired
    private com.thoughtworks.xstream.XStream xstream;
    @Autowired
    private com.thoughtworks.xstream.XStream jsonXstream;
    public FishingVesselResource() {
        super();
        logger.debug("into constructor TitleResource");
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doInit() throws ResourceException {
        // TODO Auto-generated method stub
        super.doInit();
        logger.debug("into doInit");
    }

    @Override
    protected Representation post(Representation entity, Variant variant)
            throws ResourceException {
        // TODO Auto-generated method stub
        logger.debug("into Post ConsultantReportResource 2");
        InputStream in = null;
        try {
            in = entity.getStream();
            xstream.processAnnotations(th.ac.fi2.model.FishingVesselM.class);// or xstream.autodetectAnnotations(true); (Auto-detect  Annotations)
            th.ac.fi2.model.FishingVesselM xsource = new th.ac.fi2.model.FishingVesselM();
            Object xtarget = xstream.fromXML(in);
            if (xtarget != null) {
                xsource = (th.ac.fi2.model.FishingVesselM) xtarget;
                if (xsource != null) {
                    if (xsource.getServiceName() != null
                            && xsource.getServiceName().length() != 0) {
                        String serviceName = xsource.getServiceName();
                        ImakeResultMessage imakeMessage = new ImakeResultMessage();
                            Paging page = xsource.getPaging();
                            @SuppressWarnings("rawtypes")
                            List<FishingVesselM> fishingVesselList =fi2Service.getFishingVesselByShipCode(xsource.getBoatRegNo());

                        imakeMessage.setResultListObj(fishingVesselList);
                      /*
                        JsonRepresentation representation_aoe = null;


                        jsonXstream
                                .processAnnotations(th.ac.fi2.model.ChartM.class);// or
                        // xstream.autodetectAnnotations(true);
                        // (Auto-detect
                        // Annotations)
                        jsonXstream.autodetectAnnotations(true);
                         jsonXstream.setMode(XStream.NO_REFERENCES);
                       // jsonXstream.addImplicitCollection(models.getClass(), "TitleM");;
                        Gson gson = new Gson();
                        String jsonStr= gson.toJson(models);
                        logger.info("json->" + jsonStr);
                        String json = jsonXstream.toXML(models);
                        logger.info("json->"+json);

                            representation_aoe = new JsonRepresentation(jsonStr);

                        return representation_aoe;
                        */

                        return getRepresentation(entity, imakeMessage, xstream);
                    } else {
                    }
                }

            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            logger.debug(" into Finally Call");
            try {
                if (in != null)
                    in.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;

    }


    @Override
    protected Representation get(Variant variant) throws ResourceException {
        // TODO Auto-generated method stub
        ImakeResultMessage imakeMessage = new ImakeResultMessage();
        String service_name=getQuery().getValues("service_name");
        if(service_name.equals("DOFWarRoomBoat")){
            String ship_code=getQuery().getValues("ship_code");
            List<FishingVesselM> fishingVesselList =fi2Service.getFishingVesselByShipCode(ship_code);
            imakeMessage.setResultListObj(fishingVesselList);
        }
        
        else if(service_name.equals("DOFWarRoomFishingTool")){
            String fishery_year=getQuery().getValues("fishery_year");
            String number_tool=getQuery().getValues("number_tool");
            List<DOFWarRoomFishingToolM> dofWarRoomFishingToolList =
                    fi2Service.getDOFWarRoomFishingToolByFisheryYearAndShipLicense(fishery_year,number_tool);
            imakeMessage.setResultListObj(dofWarRoomFishingToolList);
        }  
        
        /*Return Value Only*/ 
        else if(service_name.equals("DOFWarFishingVesselMD")){
        	logger.info("\n DOFWarFishingVesselM \n");
            String ship_serial=getQuery().getValues("ship_serial");
            List<FishingVesselMD> dofWarRoomFishingToolList =
                    fi2Service.getDOFWarFishingVesselByShipSerial(ship_serial);
            imakeMessage.setResultListObj(dofWarRoomFishingToolList);
        }
        
        else if(service_name.equals("wsGetFishingLicenseInfo")){
            String ship_code=getQuery().getValues("ship_code");
            logger.info("\n wsGetFishingLicenseInfo --> "+ship_code+" \n");
            List<FishingLicenseInfo> wsFishingLicenseInfoList =
                    fi2Service.getFishingLicenseInfoByShipCode(ship_code);
            imakeMessage.setResultListObj(wsFishingLicenseInfoList);
        }
        
        else if(service_name.equals("wsGetFishingVesselInfo")){
            String ship_code=getQuery().getValues("ship_code");
            List<FishingVesselInfo> wsFishingVesselInfoList =
                    fi2Service.getFishingVesselInfoByShipCode(ship_code);
            imakeMessage.setResultListObj(wsFishingVesselInfoList);
        }
        
        else if(service_name.equals("WsGetShipOwnerHist")){
        	logger.info("\n WsGetShipOwnerHist \n");
            String ship_code=getQuery().getValues("ship_code");
            List<ShipOwnerHist> WsGetShipOwnerHistList =
                    fi2Service.getShipOwnerHistByShipCode(ship_code);
            imakeMessage.setResultListObj(WsGetShipOwnerHistList);
        }
        
        else{
        	List<String> msgElseLoop = new ArrayList<String>();
        	msgElseLoop.add("Not Service");
        	imakeMessage.setResultListObj(msgElseLoop);
        }
        
        return getRepresentation(null, imakeMessage, xstream);
        
    }

}
