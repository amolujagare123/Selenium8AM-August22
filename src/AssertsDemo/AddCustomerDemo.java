package AssertsDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddCustomerDemo {

    @Test
    public void addCustomer()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://stock.amolujagare.com/");

        WebElement txtUsername = driver.findElement(By.xpath("//input[@type='text']"));
        txtUsername.sendKeys("admin");

        WebElement txtPassword = driver.findElement(By.xpath("//input[@name='password']"));
        txtPassword.sendKeys("admin");


        WebElement btnLogin = driver.findElement(By.xpath("//input[@type='submit']"));
        btnLogin.click();

        //driver.findElement(By.linkText("Add Customer")).click();
        driver.findElement(By.xpath("//a[@href='add_customer.php']")).click();

        String name = "Sheetal";

        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(name);

        driver.findElement(By.xpath("//*[@name='address']")).sendKeys("xyz");

        driver.findElement(By.xpath("//*[@name='contact1']")).sendKeys("898989");

        driver.findElement(By.xpath("//*[@name='contact2']")).sendKeys("434343");

        driver.findElement(By.xpath("//*[@name='Submit']")).click();

        String expected = "[ "+name+" ] Customer Details Added !";

        String actual = "";

        try {
            actual = driver.findElement(By.xpath("//div[@class='confirmation-box round']")).getText();
        }
        catch (Exception e)
        {

        }

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        Assert.assertEquals(actual,expected,"wrong or no error message");
    }
}
