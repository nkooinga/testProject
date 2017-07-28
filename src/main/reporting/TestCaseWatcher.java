package reporting;

import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TestCaseWatcher extends TestListenerAdapter {

    private final static String getDateTime() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd_HHmm");
        df.setTimeZone(TimeZone.getTimeZone("US/Arizona"));
        return df.format(new Date());
    }

    @Override
    public void onTestSuccess(ITestResult testResult) {
        ExtentUtil.fetchTest().pass("Passed");
    }

    @Override
    public void onTestFailure(ITestResult testResult) {
        ExtentUtil.fetchTest().fail("Failed");
    }

    @Override
    public void onTestSkipped(ITestResult testResult) {
        ExtentUtil.fetchTest().skip("Skipped");
    }

    @Override
    public void onStart(ITestContext testContext) {
        ExtentUtil.createReporter(  getDateTime() + "_testReport.html");
    }

    @Override
    public void onFinish(ITestContext testContext) {
        ExtentUtil.saveReporter();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentUtil.createTest(result.getMethod().getMethodName());
        String[] categories = result.getMethod().getGroups();
        ExtentUtil.fetchTest().log(Status.INFO, result.getMethod().getMethodName() + " is starting");
        for (String category:categories) {
            ExtentUtil.fetchTest().assignCategory(category);
        }
    }
}
