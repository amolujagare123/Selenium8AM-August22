package TestNgDemos.RealDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JobSites extends Init{



    @Test
    public void naukri()
    {
        driver.get("http://naukri.com");
    }
    @Test
    public void monster()
    {
        driver.get("http://monster.com");
    }
    @Test
    public void shine()
    {
        driver.get("http://shine.com");
    }
   }
