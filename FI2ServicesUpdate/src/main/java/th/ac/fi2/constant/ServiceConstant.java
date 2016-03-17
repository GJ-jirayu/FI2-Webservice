package th.ac.fi2.constant;

import java.util.ResourceBundle;

public class ServiceConstant {
    public static final String hostReference = "http://10.2.0.76:10000/BPSService/RestletServlet/";

    public static final String LOG_APPENDER = "CHARTServicesLog";

    public static final String INTERFACE_RETURN_TYPE = "java.util.List";
    public static final String VOID_RETURN_TYPE = "void";
    public static final String FLAG_INACTIVE = "0";
    public static final String FLAG_ACTIVE = "1";
    public static final String UPDATE_TYEP_FLAG = "flag";
    public static final String TAB_ALL = "all";
    public static final String TAB_MY_DATA = "myData";
    public static final int JOURNAL_PAPERS_TYPE_JOURNAL = 1;
    public static final int JOURNAL_PAPERS_TYPE_CONFERENCE = 2;
    public static final String[] FILTERS = {"0", "1", "2", "3"};
    public static final String[] DOCTYPES = {"PUBLISH", "DRAFT"};
    public static final String ERROR_MESSAGE_KEY = "errorMessage";
    public static final String SUCCESS_MESSAGE_KEY = "successMessage";
    public static final String WARNING_MESSAGE_KEY = "warningMessage";

    public static final String ERROR_CONSTRAINT_VIOLATION_MESSAGE_CODE = "error.constraintViolation";
    //public static final String SUCCESS_MESSAGE_CODE=".constraintViolation";
    /*public static  enum FILTER{
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
	    THURSDAY, FRIDAY, SATURDAY 
	}*/
    public static final ResourceBundle bundle;
    public static String SCHEMA = "";

    static {
        bundle = ResourceBundle.getBundle("jdbc");
        SCHEMA = bundle.getString("schema");
    }

    public static final String MESSAGE_CODE_OK = "ok";
    public static final String MESSAGE_CODE_ERROR = "error";

    public static final String DOC_TYPE_COPYRIGHT = "COPYRIGHT";
    public static final String DOC_TYPE_REWARD = "REWARD";
    public static final String DOC_TYPE_PATENT = "PATENT";
    public static final String DOC_TYPE_RESEARCH = "RESEARCH";
    public static final String DOC_TYPE_JOURNAL = "JOURNAL";
    public static final String DOC_TYPE_UTILIZATION = "UTILIZATION";



/*
    //CHART
    public static final String CHART_SEARCH = "searchChart";
    public static final String CHART_SAVE = "saveChart";
    public static final String CHART_UPDATE = "updateChart";
    public static final String CHART_ITEMS_DELETE = "deleteChartItems";
    public static final String CHART_DELETE = "deleteChart";
    public static final String CHART_FIND_BY_ID = "findByIdChart";

    //CHART_FEATURE
    public static final String CHART_FEATURE_SEARCH = "searchChartFeature";
    public static final String CHART_FEATURE_SAVE = "saveChartFeature";
    public static final String CHART_FEATURE_UPDATE = "updateChartFeature";
    public static final String CHART_FEATURE_ITEMS_DELETE = "deleteChartFeatureItems";
    public static final String CHART_FEATURE_DELETE = "deleteChartFeature";
    public static final String CHART_FEATURE_FIND_BY_ID = "findByIdChartFeature";

    //CHART_FEATURE_INSTANCE
    public static final String CHART_FEATURE_INSTANCE_SEARCH = "searchChartFeatureInstance";
    public static final String CHART_FEATURE_INSTANCE_SAVE = "saveChartFeatureInstance";
    public static final String CHART_FEATURE_INSTANCE_UPDATE = "updateChartFeatureInstance";
    public static final String CHART_FEATURE_INSTANCE_ITEMS_DELETE = "deleteChartFeatureInstanceItems";
    public static final String CHART_FEATURE_INSTANCE_DELETE = "deleteChartFeatureInstance";
    public static final String CHART_FEATURE_INSTANCE_FIND_BY_ID = "findByIdChartFeatureInstance";


    //CHART_FEATURE_MAPPING
    public static final String CHART_FEATURE_MAPPING_SEARCH = "searchChartFeatureMapping";
    public static final String CHART_FEATURE_MAPPING_SAVE = "saveChartFeatureMapping";
    public static final String CHART_FEATURE_MAPPING_UPDATE = "updateChartFeatureMapping";
    public static final String CHART_FEATURE_MAPPING_ITEMS_DELETE = "deleteChartFeatureMappingItems";
    public static final String CHART_FEATURE_MAPPING_DELETE = "deleteChartFeatureMapping";
    public static final String CHART_FEATURE_MAPPING_FIND_BY_ID = "findByIdChartFeatureMapping";


    //CHART_FILTER_INSTANCE
    public static final String CHART_FILTER_INSTANCE_SEARCH = "searchChartFilterInstance";
    public static final String CHART_FILTER_INSTANCE_SAVE = "saveChartFilterInstance";
    public static final String CHART_FILTER_INSTANCE_UPDATE = "updateChartFilterInstance";
    public static final String CHART_FILTER_INSTANCE_ITEMS_DELETE = "deleteChartFilterInstanceItems";
    public static final String CHART_FILTER_INSTANCE_DELETE = "deleteChartFilterInstance";
    public static final String CHART_FILTER_INSTANCE_FIND_BY_ID = "findByIdChartFilterInstance";


    //CHART_INSTANCE
    public static final String CHART_INSTANCE_SEARCH = "searchChartInstance";
    public static final String CHART_INSTANCE_SAVE = "saveChartInstance";
    public static final String CHART_INSTANCE_UPDATE = "updateChartInstance";
    public static final String CHART_INSTANCE_ITEMS_DELETE = "deleteChartInstanceItems";
    public static final String CHART_INSTANCE_DELETE = "deleteChartInstance";
    public static final String CHART_INSTANCE_FIND_BY_ID = "findByIdChartInstance";


    //COMMENT
    public static final String COMMENT_SEARCH = "searchComment";
    public static final String COMMENT_SAVE = "saveComment";
    public static final String COMMENT_UPDATE = "updateComment";
    public static final String COMMENT_ITEMS_DELETE = "deleteCommentItems";
    public static final String COMMENT_DELETE = "deleteComment";
    public static final String COMMENT_FIND_BY_ID = "findByIdComment";


    //COPYRIGHT_SERVICE
    public static final String COPYRIGHT_SERVICE_SEARCH = "searchCopyrightService";
    public static final String COPYRIGHT_SERVICE_SAVE = "saveCopyrightService";
    public static final String COPYRIGHT_SERVICE_UPDATE = "updateCopyrightService";
    public static final String COPYRIGHT_SERVICE_ITEMS_DELETE = "deleteCopyrightServiceItems";
    public static final String COPYRIGHT_SERVICE_DELETE = "deleteCopyrightService";
    public static final String COPYRIGHT_SERVICE_FIND_BY_ID = "findByIdCopyrightService";


    //FEATURE
    public static final String FEATURE_SEARCH = "searchFeature";
    public static final String FEATURE_SAVE = "saveFeature";
    public static final String FEATURE_UPDATE = "updateFeature";
    public static final String FEATURE_ITEMS_DELETE = "deleteFeatureItems";
    public static final String FEATURE_DELETE = "deleteFeature";
    public static final String FEATURE_FIND_BY_ID = "findByIdFeature";


    //FILTER
    public static final String FILTER_SEARCH = "searchFilter";
    public static final String FILTER_SAVE = "saveFilter";
    public static final String FILTER_UPDATE = "updateFilter";
    public static final String FILTER_ITEMS_DELETE = "deleteFilterItems";
    public static final String FILTER_DELETE = "deleteFilter";
    public static final String FILTER_FIND_BY_ID = "findByIdFilter";


    //FILTER_INSTANCE
    public static final String FILTER_INSTANCE_SEARCH = "searchFilterInstance";
    public static final String FILTER_INSTANCE_SAVE = "saveFilterInstance";
    public static final String FILTER_INSTANCE_UPDATE = "updateFilterInstance";
    public static final String FILTER_INSTANCE_ITEMS_DELETE = "deleteFilterInstanceItems";
    public static final String FILTER_INSTANCE_DELETE = "deleteFilterInstance";
    public static final String FILTER_INSTANCE_FIND_BY_ID = "findByIdFilterInstance";

    //FUNDING_SERVICE
    public static final String FUNDING_SERVICE_SEARCH = "searchFundingResourceService";
    public static final String FUNDING_SERVICE_SAVE = "saveFundingResourceService";
    public static final String FUNDING_SERVICE_UPDATE = "updateFundingResourceService";
    public static final String FUNDING_SERVICE_ITEMS_DELETE = "deleteFundingResourceServiceItems";
    public static final String FUNDING_SERVICE_DELETE = "deleteFundingResourceService";
    public static final String FUNDING_SERVICE_FIND_BY_ID = "findByIdFundingResourceService";


    //JOURNAL_SERVICE
    public static final String JOURNAL_SERVICE_SEARCH = "searchJournalPapersService";
    public static final String JOURNAL_SERVICE_SAVE = "saveJournalPapersService";
    public static final String JOURNAL_SERVICE_UPDATE = "updateJournalPapersService";
    public static final String JOURNAL_SERVICE_ITEMS_DELETE = "deleteJournalPapersServiceItems";
    public static final String JOURNAL_SERVICE_DELETE = "deleteJournalPapersService";
    public static final String JOURNAL_SERVICE_FIND_BY_ID = "findByIdJournalPapersService";


    //SERVICE_CHART_MAPPING
    public static final String SERVICE_CHART_MAPPING_SEARCH = "searchServiceChartMapping";
    public static final String SERVICE_CHART_MAPPING_SAVE = "saveServiceChartMapping";
    public static final String SERVICE_CHART_MAPPING_UPDATE = "updateServiceChartMapping";
    public static final String SERVICE_CHART_MAPPING_ITEMS_DELETE = "deleteServiceChartMappingItems";
    public static final String SERVICE_CHART_MAPPING_DELETE = "deleteServiceChartMapping";
    public static final String SERVICE_CHART_MAPPING_FIND_BY_ID = "findByIdServiceChartMapping";


    //SERVICE
    public static final String SERVICE_SEARCH = "searchService";
    public static final String SERVICE_SAVE = "saveService";
    public static final String SERVICE_UPDATE = "updateService";
    public static final String SERVICE_ITEMS_DELETE = "deleteServiceItems";
    public static final String SERVICE_DELETE = "deleteService";
    public static final String SERVICE_FIND_BY_ID = "findByIdService";


    //SERVICE_FILTER_MAPPING
    public static final String SERVICE_FILTER_MAPPING_SEARCH = "searchServiceFilterMapping";
    public static final String SERVICE_FILTER_MAPPING_SAVE = "saveServiceFilterMapping";
    public static final String SERVICE_FILTER_MAPPING_UPDATE = "updateServiceFilterMapping";
    public static final String SERVICE_FILTER_MAPPING_ITEMS_DELETE = "deleteServiceFilterMappingItems";
    public static final String SERVICE_FILTER_MAPPING_DELETE = "deleteServiceFilterMapping";
    public static final String SERVICE_FILTER_MAPPING_FIND_BY_ID = "findByIdServiceFilterMapping";
    */
}
