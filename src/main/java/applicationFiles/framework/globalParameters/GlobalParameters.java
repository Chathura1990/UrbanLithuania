package applicationFiles.framework.globalParameters;

public class GlobalParameters {

    public static final String WEBSITE_URL = "https://storage.googleapis.com/urban-qa-testing/parkcalcTestHarness.html";

    //Page load waits
    public static int PAGE_LOAD_TIMEOUT = 20;
    public static int LONG_SLEEP_SEC = 2000;

    //For short-term and economy parking for one day
    public static String SHORT_ECO_ENTRY_TIME = "12.00";
    public static String SHORT_ECO_ENTRY_DATE = "2000-01-01";
    public static String SHORT_ECO_EXIT_TIME = "12.00";
    public static String SHORT_ECO_EXIT_DATE = "2000-01-02";

    //For long-term surface and garage parking for one month
    public static String LONG_TERM_ENTRY_TIME = "12.00";
    public static String LONG_TERM_ENTRY_DATE = "2000-01-01";
    public static String LONG_TERM_EXIT_TIME = "12.00";
    public static String LONG_TERM_EXIT_DATE = "2000-02-01";

    //For valet parking for five hours
    public static String VALET_ENTRY_TIME = "12.00";
    public static String VALET_ENTRY_DATE = "2000-01-01";
    public static String VALET_EXIT_TIME = "17.00";
    public static String VALET_EXIT_DATE = "2000-01-01";

    //For various tests
    public static String ENTRY_TIME = "12.26";
    public static String ENTRY_DATE = "2000-01-01";
    public static String EXIT_TIME = "15.42";
    public static String EXIT_DATE = "2000-01-03";

}
