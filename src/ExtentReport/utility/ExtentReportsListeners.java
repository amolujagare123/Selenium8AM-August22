package ExtentReport.utility;

import TestNgDemos.RealDemo.Init;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

import static ExtentReport.utility.ForExtentReport.getCurrentScreenshot;
import static ExtentReport.utility.ForExtentReport.initExtentReportListeners;

public class ExtentReportsListeners extends Init implements ITestListener {

    ExtentReports extent;
    ExtentTest test;
    public void onTestStart(ITestResult result) {
         test = extent.createTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {

        test.info(result.getMethod().getMethodName());
        test.pass("This test is passed");
    }

    public void onTestFailure(ITestResult result) {

        test.info(result.getMethod().getMethodName());
        test.fail(result.getThrowable());
        try {
            test.addScreenCaptureFromPath("./screenshots/"+getCurrentScreenshot(driver));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult result) {
        test.info(result.getMethod().getMethodName());
        test.skip(result.getThrowable());
    }

    public void onStart(ITestContext context) {

        if (extent==null)
            extent = initExtentReportListeners();
    }

    public void onFinish(ITestContext context) {

        extent.flush();
    }
}
