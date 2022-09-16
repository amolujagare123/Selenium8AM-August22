package ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static ExtentReport.utility.ForExtentReport.getCurrentScreenshot;

public class ExtentReportDemo1 {

    ExtentReports extent;

    @BeforeClass
    public void initExtentReport()
    {
        ExtentSparkReporter reporter =new ExtentSparkReporter("Report/report.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);

        reporter.config().setDocumentTitle("Stock Management system");
        reporter.config().setReportName("Regression Report");

        extent.setSystemInfo("Developers Name","Ananta");
        extent.setSystemInfo("Testers Name","Madhavi");
        extent.setSystemInfo("Project Name","Stock Management");
        extent.setSystemInfo("Project deadline","2 months");

    }

    @AfterClass
    public void writeToRepeort()
    {
        extent.flush();
    }


    @Test
    public void myTest1() throws IOException {
        ExtentTest test = extent.createTest("valid Login");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        test.info("browser is opened");

        driver.manage().window().maximize();
        driver.get("https://stock.amolujagare.com/");

        test.info("url is opened");

        WebElement txtUsername = driver.findElement(By.id("login-username"));
        txtUsername.sendKeys("admin");

        test.info("username is entered");

        WebElement txtPassword = driver.findElement(By.id("login-password"));
        txtPassword.sendKeys("admin1");

        test.info("password is entered");

        WebElement btnLogin = driver.findElement(By.name("submit"));
        btnLogin.click();

        test.info("Login button is clicked");

        String expected = "https://stock.amolujagare.com/dashboard.php";
        String actual = driver.getCurrentUrl();

        try {
            Assert.assertEquals(actual, expected, "This is not a dashboard");
            test.pass("This test is passed");
        }
        catch (AssertionError e)
        {
            test.fail(e.getMessage());
            test.addScreenCaptureFromPath("./screenshots/"+getCurrentScreenshot(driver));
        }
    }

    @Test
    public void myTest2() throws IOException {
        ExtentTest test = extent.createTest("invalid Login");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        test.info("browser is opened");

        driver.manage().window().maximize();
        driver.get("https://stock.amolujagare.com/");

        test.info("url is opened");

        WebElement txtUsername = driver.findElement(By.id("login-username"));
        txtUsername.sendKeys("admin");

        test.info("username is entered");

        WebElement txtPassword = driver.findElement(By.id("login-password"));
        txtPassword.sendKeys("admin1");

        test.info("password is entered");

        WebElement btnLogin = driver.findElement(By.name("submit"));
        btnLogin.click();

        test.info("Login button is clicked");

        String expected = "Wrong Username or Password";
        String actual = "";

        try {
            actual = driver.findElement(By.xpath("//div[@class='error-box round']")).getText();

        }
        catch (Exception e)
        {
            test.addScreenCaptureFromPath("./screenshots/"+getCurrentScreenshot(driver));

        }


        try {
            Assert.assertEquals(actual, expected, "incorrect or no error message");
            test.pass("This test is passed");
        }
        catch (AssertionError e)
        {
            test.fail(e.getMessage());
            test.addScreenCaptureFromPath("./screenshots/"+getCurrentScreenshot(driver));

        }
    }

    @Test
    public void myTest3() throws IOException {
        ExtentTest test = extent.createTest("blank Login");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        test.info("browser is opened");

        driver.manage().window().maximize();
        driver.get("https://stock.amolujagare.com/");

        test.info("url is opened");

        WebElement txtUsername = driver.findElement(By.id("login-username"));
        txtUsername.sendKeys("");

        test.info("username is entered");

        WebElement txtPassword = driver.findElement(By.id("login-password"));
        txtPassword.sendKeys("");

        test.info("password is entered");

        WebElement btnLogin = driver.findElement(By.name("submit"));
        btnLogin.click();

        test.info("Login button is clicked");

        String expected = "https://stock.amolujagare.com/";
        String actual = driver.getCurrentUrl();

        try {
            Assert.assertEquals(actual, expected, "This is not a Login page");
            test.pass("This test is passed");
        }
        catch (AssertionError e)
        {
            test.fail(e.getMessage());
            test.addScreenCaptureFromPath("./screenshots/"+getCurrentScreenshot(driver));

        }
    }
}
