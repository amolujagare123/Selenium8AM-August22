package DataProviderDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataProviderDemo2 {

    WebDriver driver;

    @BeforeClass
    public void doLogin()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://stock.amolujagare.com/");

        WebElement txtUsername = driver.findElement(By.id("login-username"));
        txtUsername.sendKeys("admin");

        WebElement txtPassword = driver.findElement(By.id("login-password"));
        txtPassword.sendKeys("admin");

        WebElement btnLogin = driver.findElement(By.name("submit"));
        btnLogin.click();
    }

    @Test (dataProvider = "getData")
    public void addClientTest(String name,String address
            ,String contact1,String contact2)
    {
        driver.findElement(By.partialLinkText("Add Cu")).click();

        driver.findElement(By.name("name")).sendKeys(name);

        driver.findElement(By.name("address")).sendKeys(address);

        driver.findElement(By.name("contact1")).sendKeys(contact1);

        driver.findElement(By.name("contact2")).sendKeys(contact2);

       // driver.findElement(By.name("Submit")).click();
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        FileInputStream fis = new FileInputStream("Data/MyData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Add Client");
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount-1][colCount];

        for (int i=0;i<rowCount-1;i++)
        {
            XSSFRow row = sheet.getRow(i+1);

          /*  data[i][0] = row.getCell(0).toString(); // name
            data[i][1] = row.getCell(1).toString(); // address
            data[i][2] = row.getCell(2).toString(); // contact 1
            data[i][3] = row.getCell(3).toString(); // contact 2*/

            for (int j=0;j<colCount;j++) {

                try {
                    XSSFCell cell = row.getCell(j);
                    data[i][j] = cell.toString();
                }
                catch (Exception e)
                {
                    data[i][j] = "";
                }
            }
        }

        return data;

    }
}
