package th.ac.fi2.rest.resource;

import org.apache.log4j.Logger;
import org.restlet.data.MediaType;
import org.restlet.ext.xml.DomRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.Variant;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import th.ac.fi2.constant.ServiceConstant;
import th.ac.fi2.xstream.common.ImakeResultMessage;

import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;


/**
 * @author Chatchai Pimtun
 */
public abstract class BaseResource extends ServerResource {
    protected static final Logger logger = Logger.getLogger(ServiceConstant.LOG_APPENDER);
    protected static final String DATE_FORMAT = "yyyy-MM-dd";
    protected String HOST = "";
    protected String PATH_REF = "";

    @Override
    protected void doInit() throws ResourceException {
        // TODO Auto-generated method stub
        super.doInit();
        /*getReference().getHostDomain();
		getReference().getHostPort();
		getReference().getSchemeProtocol().toString().toLowerCase();
		getReference().getPath();*/
        // get host
        HOST = getRequest().getProtocol().toString().toLowerCase() + "://"
                + getRequest().getResourceRef().getHostDomain() + ":"
                + getRequest().getResourceRef().getHostPort();
        // get ResourceRef
        PATH_REF = getRequest().getResourceRef().getPath();
    }

	/*@Override
	public void init(Context context, Request request, Response response) {
		// TODO Auto-generated method stub
		super.init(context, request, response);
		// get host
		HOST = getRequest().getProtocol().toString().toLowerCase() + "://"
				+ getRequest().getResourceRef().getHostDomain() + ":"
				+ getRequest().getResourceRef().getHostPort();
		// get ResourceRef
		PATH_REF = getRequest().getResourceRef().getPath();
	}
*/
    //@SuppressWarnings("deprecation")

    public BaseResource() {
        super();
        logger.debug("into constructor BaseResource");
        // Allow modifications of this resource via POST requests.
        //setModifiable(true);
        // Declare the kind of representations supported by this resource.
        //	 getVariants().add(new Variant(MediaType.TEXT_HTML));
        getVariants().add(new Variant(MediaType.TEXT_XML));
        getVariants().add(new Variant(MediaType.APPLICATION_ATOM));
        getVariants().add(new Variant(MediaType.APPLICATION_ALL_XML));
        // TODO Auto-generated constructor stub
    }

	/*public BaseResource(Context context, Request request, Response response) {
		super(context, request, response);
		logger
				.debug("into constructor  BaseResource context, request, response");
		// Allow modifications of this resource via POST requests.
		// setModifiable(true);
		// Declare the kind of representations supported by this resource.
		// getVariants().add(new Variant(MediaType.TEXT_XML));
	}
*/
	/*@SuppressWarnings("unchecked")
	public abstract List search(Pagging pagging);

	@SuppressWarnings("unchecked")
	protected List<FeedModel> getFeedMedels(
			List objectModel) {
		return null;
	}*/

	/*@SuppressWarnings("unchecked")
	public Representation exportFeed(Variant variant, String title) {
		logger.debug("into exportFeed");*/
//		org.restlet.data.Form form = getQuery();
//		String pageSizeParam = form.getValues(PaggingConstant.PAGE_SIZE_PARAM);
//		String startIndexParam = form
//				.getValues(PaggingConstant.START_INDEX_PARAM);
//		logger.debug("pageSize=" + pageSizeParam + ",startIndex="
//				+ startIndexParam);
//
//		Representation entity = getRequest().getEntity();
//		logger.debug(" aoe Test entity " + entity);
//		// get ResourceRef
//		org.restlet.data.Reference reference = getRequest().getResourceRef();
//		String pathRef = reference.getPath();
//		logger.debug("pathRef=" + pathRef);
//		// get Servlet context
//		com.noelios.restlet.ext.servlet.ServletContextAdapter context = (com.noelios.restlet.ext.servlet.ServletContextAdapter) getContext();
//		javax.servlet.ServletContext servlet = context.getServletContext();
//		logger.debug("servlet.getServerInfo()==>" + servlet.getServerInfo());
//
//		// get Servlet Request
//		com.noelios.restlet.http.HttpRequest httpRequest = (com.noelios.restlet.http.HttpRequest) getRequest();
//		// get Client
//		org.restlet.data.ClientInfo clientInfo = httpRequest.getClientInfo();
//		logger.debug("clientInfo.getAddress()=" + clientInfo.getAddress());
//		logger
//				.debug("httpRequest.getProtocol()==>"
//						+ httpRequest.getProtocol());
//		logger.debug("httpRequest.getHostRef()==>" + httpRequest.getHostRef());
//		// get hostRef
//		org.restlet.data.Reference hostRef = getRequest().getHostRef();
//		logger.debug("hostRef=" + hostRef.getPath()
//				+ "reference.getHostDomain()=" + reference.getHostDomain()
//				+ ",reference.getHostPort()=" + reference.getHostPort());
//		String host = httpRequest.getProtocol().toString().toLowerCase()
//				+ "://" + reference.getHostDomain() + ":"
//				+ reference.getHostPort();
//		logger.debug(" host == > " + host);
//
//		if (MediaType.TEXT_XML.equals(variant.getMediaType())) {
//			com.sun.syndication.io.WireFeedOutput output = new com.sun.syndication.io.WireFeedOutput();
//			// SyndFeedOutput output = new SyndFeedOutput();
//			DomRepresentation representation_aoe = null;
//			th.or.ntc.hibernate.bean.NtcFaq ntcfaq = new th.or.ntc.hibernate.bean.NtcFaq();
//			int pageSize = PaggingConstant.PAGE_SIZE;
//			int startIndex = PaggingConstant.START_INDEX;
//			if (pageSizeParam != null && !pageSizeParam.equals("")) {
//				pageSize = Integer.parseInt(pageSizeParam);
//			}
//			if (startIndexParam != null && !startIndexParam.equals("")) {
//				startIndex = Integer.parseInt(startIndexParam);
//			}
//			Pagging pagging = new Pagging();
//			pagging.setPageSize(pageSize);
//			pagging.setStartIndex(startIndex);
//			ntcfaq.setPagging(pagging);
//
//			List resultModel = search(pagging);
//			if (resultModel != null && resultModel.size() == 2) {
//				java.util.List beans = (List) resultModel.get(0);
//				String beans_size = (String) resultModel.get(1);
//				if (beans != null && beans.size() > 0 && beans_size != null
//						&& !beans_size.equals("")) {
//					List<th.or.ntc.xstream.common.FeedModel> feedModels = getFeedMedels(beans);
//					try {
//						int feedsTotal = Integer.parseInt(beans_size);
//						com.sun.syndication.feed.atom.Feed feed = getFeed(
//								feedModels, host, pathRef, feedsTotal,
//								pageSize, startIndex, title);
//						// com.sun.syndication.feed.synd.SyndFeed feed =
//						// getSynFeed(ntcfaqs,host,pathRef,ntcfaqsTotal,pageSize,startIndex);
//						Document doc = output.outputW3CDom(feed);
//						doc.normalizeDocument();
//						try {
//							representation_aoe = new DomRepresentation(
//							// MediaType.TEXT_XML);
//									MediaType.APPLICATION_ATOM_XML);
//						} catch (IOException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//
//						representation_aoe.setDocument(doc);
//						return representation_aoe;
//					} catch (FeedException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//				}
//			}
//
//		}

	/*	return null;

	}*/

    public void export(Representation entity, ImakeResultMessage vresultMessage,
                       com.thoughtworks.xstream.XStream xstream) {

        // TODO Auto-generated method stub
        logger.debug("into Post FAQs");
        // com.sun.syndication.io.WireFeedOutput output = new
        // com.sun.syndication.io.WireFeedOutput();
        DomRepresentation representation_aoe = null;

        javax.xml.parsers.DocumentBuilderFactory dbf = javax.xml.parsers.DocumentBuilderFactory
                .newInstance();
        dbf.setNamespaceAware(true);
        javax.xml.parsers.DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        xstream
                .processAnnotations(ImakeResultMessage.class);// or
        // xstream.autodetectAnnotations(true);
        // (Auto-detect
        // Annotations)
        xstream.autodetectAnnotations(true);
        String xml = xstream.toXML(vresultMessage);
        Document document = null;
        InputStream in = null;
        try {
            in = new ByteArrayInputStream(xml.getBytes("UTF-8"));
            document = db.parse(in);
        } catch (UnsupportedEncodingException e2) {
            // TODO Auto-generated catch block
            logger.error("error UnsupportedEncodingException xml=" + xml);
            e2.printStackTrace();
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            logger.error("error SAXException xml=" + xml);
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            logger.error("error IOException xml=" + xml);
            e.printStackTrace();
        } finally {
            if (in != null)
                try {
                    in.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    logger.error("xml=" + xml);
                    e.printStackTrace();
                }
        }

        document.normalizeDocument();
        try {
            representation_aoe = new DomRepresentation(
                    MediaType.TEXT_XML);
            //	MediaType.APPLICATION_ATOM_XML);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            logger.error("xml=" + xml);
            e.printStackTrace();

        }

        representation_aoe.setDocument(document);
        getResponse().setEntity(representation_aoe);
    }

    public Representation getRepresentation(Representation entity, ImakeResultMessage vresultMessage,
                                            com.thoughtworks.xstream.XStream xstream) {

        // TODO Auto-generated method stub
        logger.debug("into Post FAQs");
        // com.sun.syndication.io.WireFeedOutput output = new
        // com.sun.syndication.io.WireFeedOutput();
        DomRepresentation representation_aoe = null;

        javax.xml.parsers.DocumentBuilderFactory dbf = javax.xml.parsers.DocumentBuilderFactory
                .newInstance();
        dbf.setNamespaceAware(true);
        javax.xml.parsers.DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        xstream
                .processAnnotations(ImakeResultMessage.class);// or
        // xstream.autodetectAnnotations(true);
        // (Auto-detect
        // Annotations)
        xstream.autodetectAnnotations(true);
        String xml = xstream.toXML(vresultMessage);
        Document document = null;
        InputStream in = null;
        try {
            in = new ByteArrayInputStream(xml.getBytes("UTF-8"));
            document = db.parse(in);
        } catch (UnsupportedEncodingException e2) {
            // TODO Auto-generated catch block
            logger.error("error UnsupportedEncodingException xml=" + xml);
            e2.printStackTrace();
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            logger.error("error SAXException xml=" + xml);
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            logger.error("error IOException xml=" + xml);
            e.printStackTrace();
        } finally {
            if (in != null)
                try {
                    in.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    logger.error("xml=" + xml);
                    e.printStackTrace();
                }
        }
        document.normalizeDocument();
        try {
            representation_aoe = new DomRepresentation(
                    MediaType.TEXT_XML);
            //	MediaType.APPLICATION_ATOM_XML);
			/*
			Form responseHeaders = (Form) getResponse().getAttributes().get("org.restlet.http.headers");
			if (responseHeaders == null)
			{
			responseHeaders = new Form();
			getResponse().getAttributes().put("org.restlet.http.headers", responseHeaders);
			}
			responseHeaders.add("Access-Control-Allow-Origin", "*");
			*/
        } catch (IOException e) {
            // TODO Auto-generated catch block
            logger.error("xml=" + xml);
            e.printStackTrace();

        }

        representation_aoe.setDocument(document);
        return representation_aoe;
        //getResponse().setEntity(representation_aoe);
    }

	/*private com.sun.syndication.feed.atom.Feed getFeed(
			List<FeedModel> feedModels,
			String hostRef, String pathRef, int ntcfaqsTotal, int pageSize,
			int startIndex, String title) {

		// DateFormat dateParser = new SimpleDateFormat(DATE_FORMAT);

		com.sun.syndication.feed.atom.Feed feed = new com.sun.syndication.feed.atom.Feed();
		feed.setFeedType(AtomConstant.ATOM_1_0);
		com.sun.syndication.feed.atom.Link link_self = new com.sun.syndication.feed.atom.Link();
		link_self.setRel(AtomConstant.ATOM_NAVI_SELF);
		// link_self.setHref("http://localhost:8080/VService/RestletServlet/forums");
		link_self.setHref(hostRef + pathRef);

		com.sun.syndication.feed.atom.Link link_next = new com.sun.syndication.feed.atom.Link();
		link_next.setRel(AtomConstant.ATOM_NAVI_NEXT);
		// link_next.setHref("http://localhost:8080/VService/RestletServlet/forums?pageSize=10&startIndex=10");
		link_next.setHref(hostRef + pathRef + "?"
				+ PaggingConstant.PAGE_SIZE_PARAM + "=" + pageSize + "&"
				+ PaggingConstant.START_INDEX_PARAM + "="
				+ (startIndex + pageSize) + "");
		link_next.setType(AtomConstant.ATOM_MIME_TYPE);

		com.sun.syndication.feed.atom.Link link_previous = new com.sun.syndication.feed.atom.Link();
		link_previous.setRel(AtomConstant.ATOM_NAVI_PREVIOUS);
		// link_previous.setHref("http://localhost:8080/VService/RestletServlet/forums?pageSize=10&startIndex=0");
		int previos = (startIndex - pageSize) > 0 ? (startIndex - pageSize) : 0;
		link_previous.setHref(hostRef + pathRef + "?"
				+ PaggingConstant.PAGE_SIZE_PARAM + "=" + pageSize + "&"
				+ PaggingConstant.START_INDEX_PARAM + "=" + previos + "");
		link_previous.setType(AtomConstant.ATOM_MIME_TYPE);

		List<com.sun.syndication.feed.atom.Link> links = new ArrayList<com.sun.syndication.feed.atom.Link>(
				3);
		links.add(link_self);
		int size_entry = feedModels.size();

		if ((size_entry + startIndex) < ntcfaqsTotal) {
			links.add(link_next);
		}
		if (startIndex != 0) {
			links.add(link_previous);
		}
		feed.setTitle(title);
		feed.setOtherLinks(links);

		List<com.sun.syndication.feed.atom.Entry> entries = new ArrayList<com.sun.syndication.feed.atom.Entry>(
				size_entry);
		for (int i = 0; i < size_entry; i++) {
			FeedModel feedModel = (FeedModel) feedModels
					.get(i);
			com.sun.syndication.feed.atom.Entry entry;

			entry = new com.sun.syndication.feed.atom.Entry();
			com.sun.syndication.feed.atom.Link link_entry = new com.sun.syndication.feed.atom.Link();
			link_entry.setRel(AtomConstant.ATOM_LINK_ALTERNATE);
			// link_next.setHref("http://localhost:8080/VService/RestletServlet/forums?pageSize=10&startIndex=10");
			link_entry.setHref(hostRef + pathRef);
			List<com.sun.syndication.feed.atom.Link> entryLinks = new ArrayList<com.sun.syndication.feed.atom.Link>(
					1);
			entryLinks.add(link_entry);
			entry.setAlternateLinks(entryLinks);
			entry.setId(feedModel.getId());
			entry.setTitle(feedModel.getTitle());
			com.sun.syndication.feed.atom.Person persion = new com.sun.syndication.feed.atom.Person();
			persion.setName("");
			List<com.sun.syndication.feed.atom.Person> persions = new ArrayList<com.sun.syndication.feed.atom.Person>(
					1);
			persions.add(persion);
			entry.setAuthors(persions);
			// entry.setPublishedDate(dateParser.parse("2004-06-08"));
			
			 * if(vforum.getVfcreateTime()!=null)
			 * entry.setCreated(vforum.getVfcreateTime());
			 * if(vforum.getVfupdateTime()!=null)
			 * entry.setUpdated(vforum.getVfupdateTime());
			 

			entries.add(entry);
		}

		feed.setEntries(entries);
		return feed;
	}*/
}
