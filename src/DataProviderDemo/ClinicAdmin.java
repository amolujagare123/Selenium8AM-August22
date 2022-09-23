package DataProviderDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static DataProviderDemo.DpUtil.ForDataProvider.getMyData;
import static DataProviderDemo.DpUtil.ForExcel.convertToNumberString;

public class ClinicAdmin {
    WebDriver driver;

    @BeforeClass
    public void openBrowser()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test (dataProvider = "getData")
    public void addAdminTest(String tin,String firstname,String surname1 ,String surname2,String address,String phoneContact,String login)
    {
        driver.get("https://openclinic.sourceforge.net/openclinic/admin/staff_new_form.php?type=A");

        driver.findElement(By.xpath("//input[@id='nif']")).sendKeys(convertToNumberString(tin));
        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys(firstname);
        driver.findElement(By.xpath("//input[@id='surname1']")).sendKeys(surname1);
        driver.findElement(By.xpath("//input[@id='surname2']")).sendKeys(surname2);
        driver.findElement(By.xpath("//textarea[@id='address']")).sendKeys(address);
        driver.findElement(By.xpath("//textarea[@id='phone_contact']")).sendKeys(convertToNumberString(phoneContact));
        driver.findElement(By.xpath("//input[@id='login']")).sendKeys(login);
    }

    @DataProvider
    public Object[][] getData() throws IOException {

        return getMyData("Data/MyData.xlsx","clinicAdmin");
    }
}
