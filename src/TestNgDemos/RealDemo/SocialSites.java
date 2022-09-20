package TestNgDemos.RealDemo;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SocialSites  extends Init{


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
