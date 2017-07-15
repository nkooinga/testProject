package reporting;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestCaseWatcher extends TestListenerAdapter {

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
        ExtentUtil.createReporter("extentreport.html");
    }

    @Override
    public void onFinish(ITestContext testContext) {
        ExtentUtil.saveReporter();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentUtil.createTest(result.getMethod().getMethodName());
        String[] categories = result.getMethod().getGroups();
        for (String category:categories) {
            ExtentUtil.fetchTest().assignCategory(category);
        }
    }
}
