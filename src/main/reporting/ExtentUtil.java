package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentXReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class ExtentUtil {

    private final static String getDateTime() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd_HHmm");
        df.setTimeZone(TimeZone.getTimeZone("US/Arizona"));
        return df.format(new Date());
    }

    public static ExtentReports extentReports = null;
    static Map<Integer,ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();

    public static ExtentReports createReporter(String fileName) {
        //HTML Reporter
        ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(fileName);
        extentHtmlReporter.config().setTheme(Theme.DARK);
        extentHtmlReporter.config().setReportName("ExtentReports");
        extentHtmlReporter.config().setChartVisibilityOnOpen(true);

        // ExtentX Reporter
        ExtentXReporter extentXReporter = new ExtentXReporter("localhost");
        extentXReporter.config().setServerUrl("http://localhost:1337");
        extentXReporter.config().setReportName(getDateTime());
        extentXReporter.config().setProjectName("School Nurse");

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter, extentXReporter);



        //System Info
        try {
            extentReports.setSystemInfo("HostName", InetAddress.getLocalHost().getHostName());
            extentReports.setSystemInfo("IP Address",InetAddress.getLocalHost().getHostAddress());
            extentReports.setSystemInfo("OS",System.getProperty("os.name"));
//            extentReports.setSystemInfo("UserName",System.getProperty("user.name"));
            extentReports.setSystemInfo("Java Version",System.getProperty("java.version"));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return extentReports;
    }

    public static ExtentReports getExtentReports() {
        return extentReports;
    }

    public static void saveReporter() {
        if(extentReports !=null) {
            extentReports.flush();
        }
    }

    public static synchronized ExtentTest createTest(String testName) {
        ExtentTest extentTest = extentReports.createTest(testName);
        extentTestMap.put((int) (Thread.currentThread().getId()),extentTest);
        return extentTest;
    }

    public static synchronized ExtentTest createTest(String testName,String testDesc) {
        ExtentTest extentTest = extentReports.createTest(testName,testDesc);
        extentTestMap.put((int) (Thread.currentThread().getId()),extentTest);
        return extentTest;
    }

    public static synchronized ExtentTest fetchTest() {
        return extentTestMap.get((int) (Thread.currentThread().getId()));
    }

}
