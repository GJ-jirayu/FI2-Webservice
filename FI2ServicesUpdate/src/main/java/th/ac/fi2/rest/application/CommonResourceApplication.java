package th.ac.fi2.rest.application;

import org.restlet.Application;
import org.restlet.Restlet;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Chatchai Pimtun (Admin)
 *
 */
public class CommonResourceApplication extends Application {


    /**
     * Creates a root Restlet that will receive all incoming calls.
     */
	
   @Override
    public synchronized Restlet createInboundRoot(){
	  
    //createRoot() {
        // Create a router Restlet that defines routes.
    	final   ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext(
                 new String[] {
                		 "config/applicationContext-common.xml",
                		 "config/applicationContext-hibernate.xml",
						 "config/applicationContext-fi2-common-resource.xml",
                		 "config/applicationContext-root-router.xml"});
        // Add a route for the MailRoot resource
    	org.restlet.ext.spring.SpringRouter router = (org.restlet.ext.spring.SpringRouter)springContext.getBean("root");
    	springContext.close();
        return router;
    } 
     
}
