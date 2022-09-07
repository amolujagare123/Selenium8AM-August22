package TestNgDemos.RealDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MatrimonySites {

    WebDriver driver;

    @BeforeClass // method written below this annotation will run before first test method of the class
    public void openBrowser() {
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