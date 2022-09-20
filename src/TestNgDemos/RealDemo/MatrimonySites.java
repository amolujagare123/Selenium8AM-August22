package TestNgDemos.RealDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MatrimonySites  extends Init {



    @Test //(enabled = false)
    public void shaadi() {
        driver.get("http://shaadi.com");
    }

    @Test
    public void jeevansathi() {
        driver.get("https://www.jeevansathi.com/");
    }

    @Test
    public void lifepartner() {
        driver.get("http://lifepartner.in");
    }

}