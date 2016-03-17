/**
 * Copyright 2005-2008 Noelios Technologies.
 * 
 * The contents of this file are subject to the terms of the following open
 * source licenses: LGPL 3.0 or LGPL 2.1 or CDDL 1.0 (the "Licenses"). You can
 * select the license that you prefer but you may not use this file except in
 * compliance with one of these Licenses.
 * 
 * You can obtain a copy of the LGPL 3.0 license at
 * http://www.gnu.org/licenses/lgpl-3.0.html
 * 
 * You can obtain a copy of the LGPL 2.1 license at
 * http://www.gnu.org/licenses/lgpl-2.1.html
 * 
 * You can obtain a copy of the CDDL 1.0 license at
 * http://www.sun.com/cddl/cddl.html
 * 
 * See the Licenses for the specific language governing permissions and
 * limitations under the Licenses.
 * 
 * Alternatively, you can obtain a royaltee free commercial license with less
 * limitations, transferable or non-transferable, directly at
 * http://www.noelios.com/products/restlet-engine
 * 
 * Restlet is a registered trademark of Noelios Technologies.
 */

package th.ac.fi2.rest.application;

import org.restlet.Component;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Simple demo application that can be run either as a standalone application
 * (http://localhost:3000/v1/) or inside a servlet container
 * (http://localhost:8080/v1/).
 * 
 * @author Chatchai Pimtun (Admin)
 */
public class Main {

//    public static void main(String... args) throws Exception {
	public static void main(String[] args) throws Exception {
        // Load the Spring application context
        final ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext(
                new String[] {
                		 "config/applicationContext-common.xml",
                		 "config/applicationContext-hibernate.xml",
						"config/applicationContext-fi2-common-resource.xml",
                		 "config/applicationContext-root-router.xml"  ,
                		 "config/applicationContext-server.xml"});

        // Obtain the Restlet component from the Spring context and start it
        ((Component) springContext.getBean("top")).start();
        springContext.close();
	/*	applicationContext-bps-resource.xml
        applicationContext-common.xml
        applicationContext-hibernate.xml
        applicationContext-root-router.xml
        applicationContext-server.xml*/
		//testXStream();
    }
	/*public static void testXStream(){
		XStream xstream = new XStream(new Dom4JDriver());
		
		//xstream.processAnnotations(RendezvousMessage.class); or xstream.autodetectAnnotations(true); (Auto-detect Annotations)
		 xstream.autodetectAnnotations(true);
		RendezvousMessage msg = new RendezvousMessage(15);
		RendezvousMessage msg2 = new RendezvousMessage(15,"firstPart","secondPart");  
		System.out.println(xstream.toXML(msg));
		System.out.println(xstream.toXML(msg2));
		   Pagging pagging  = new Pagging(1,10,"orderby");
		   VCriteria vcriteria = new VCriteria("key","value");
			 
//		 VForum vforum = new VForum();
		// vforum.setPagging(pagging);
		 //vforum.setVcriteria(vcriteria);
//		 vforum.setVfid("111");
//		 vforum.setVfdesc("desc");
//		 System.out.println(xstream.toXML(vforum));

	}*/

}
