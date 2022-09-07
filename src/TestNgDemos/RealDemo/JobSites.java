package TestNgDemos.RealDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JobSites {

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
