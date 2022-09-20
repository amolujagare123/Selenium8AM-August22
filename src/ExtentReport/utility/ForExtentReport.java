package ExtentReport.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ForExtentReport {

    public static String getCurrentScreenshot(WebDriver driver) throws IOException {
        // 1. create the object reference of TakesScreenshot
        // assign driver to it, type cast driver with TakesScreenshot
        TakesScreenshot ts = (TakesScreenshot) driver;

        // 2. using ts (object reference of TakesScreenshot ) call the method
        // getScreenshotAs() and store the result into file object
        File scrFile = ts.getScreenshotAs(OutputType.FILE);

        String timeStamp = new SimpleDateFormat("_yyyyddMM_hhmmss").format(new Date());
        String fileName = "IMG"+timeStamp+".png";

        // 3. copy this file object into a real image file
        FileUtils.copyFile(scrFile,new File("Report/screenshots/"+fileName));

        return  fileName;
    }


    public static ExtentReports initExtentReportListeners()
    {

        ExtentSparkReporter reporter =new ExtentSparkReporter("Report/report.html");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);

        reporter.config().setDocumentTitle("HR Management system");
        reporter.config().setReportName("Web Testing Report");

        extent.setSystemInfo("Developers Name","Kavitha");
        extent.setSystemInfo("Testers Name","Samuel");
        extent.setSystemInfo("Project Name","HR Management");
        extent.setSystemInfo("Project deadline","20-10-2022");

        return extent;

    }
}
