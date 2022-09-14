package AssertsDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckAlertMessage {

    @Test
    public void addCustomer() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/v4/index.php");

        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

        String expected = "User or Password is not valid";
        String actual ="";
        try {
            Alert alert = driver.switchTo().alert();

            //  alert.accept();
            // alert.dismiss();


           actual = alert.getText();
            alert.accept();
        }
        catch (Exception e)
        {

        }

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        Assert.assertEquals(actual,expected,"wrong or no error message");
    }
}
