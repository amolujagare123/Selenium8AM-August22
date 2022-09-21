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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoginWithDataProviderEX {

    @Test (dataProvider = "getData")
    public void loginTest(String username,String password)
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://stock.amolujagare.com/");

        WebElement txtUsername = driver.findElement(By.id("login-username"));
        txtUsername.sendKeys(username);

        WebElement txtPassword = driver.findElement(By.id("login-password"));
        txtPassword.sendKeys(password);

        WebElement btnLogin = driver.findElement(By.name("submit"));
        btnLogin.click();
    }


    @DataProvider
    public Object[][] getData() throws IOException {
        // 1. read the excel file
        FileInputStream fis = new FileInputStream("Data/MyData.xlsx");

        // 2. convert this file object into workbook object
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        // 3. choose the sheet
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        // 4. count the active rows in the sheet
        int rowCount = sheet.getPhysicalNumberOfRows();

        Object[][] data = new Object[rowCount][2];

        for(int i=0;i<rowCount;i++)
        {
            XSSFRow row = sheet.getRow(i);

      /*      XSSFCell username = row.getCell(0);
            if (username==null)
                data[i][0] = "";
            else
               data[i][0] = username.toString();

            XSSFCell password = row.getCell(1);
            if(password==null)
                data[i][1] = "";
            else
                data[i][1] = password.toString();*/

            try {
                XSSFCell username = row.getCell(0);
                data[i][0] = username.toString();
            }
            catch (Exception e)
            {
                data[i][0] = "";
            }


            try {
                XSSFCell password = row.getCell(1);
                data[i][1] = password.toString();
            }
            catch (Exception e)
            {
                data[i][1] = "";
            }


        }

        return data;

    }
}
