package TestNgDemos.RealDemo;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SocialSites {

    WebDriver driver;

    @BeforeClass // method written below this annotation will run before first test method of the class
    public void openBrowser()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass // method written below this annotation will run after last test method of the class
    public void closeBrowser() throws InterruptedException {

        Thread.sleep(2000);
        driver.close();
    }

    @Test (priority = 2)
    public void facebook()
    {
        driver.get("http://facebook.com");
    }

    @Test (priority = 1,enabled = false)
    public void linkedin()
    {
        driver.get("http://linkedin.com");
    }
    @Test (priority = 3)
    public void twitter()
    {
        driver.get("http://gmail.com");
        Assert.assertEquals(driver.getTitle(),
                "Twitter. It’s what’s happening / Twitter"
        ,"This is not a twitter page");
    }

    @Test (priority = 4)
    public void instagram()
    {
        driver.get("http://instagram.com");
    }
}
