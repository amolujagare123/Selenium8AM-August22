package CSSSelectors;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginDemoCssSelector {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://stock.amolujagare.com/");

        WebElement txtUsername = driver.findElement(By.cssSelector("input#login-username"));
        txtUsername.sendKeys("admin");

        WebElement txtPassword = driver.findElement(By.cssSelector("input#login-password"));
        txtPassword.sendKeys("admin");

        System.out.println(txtPassword);

        WebElement btnLogin = driver.findElement(By.cssSelector("input.blue"));
        btnLogin.click();

       //driver.findElement(By.linkText("Add Customer")).click();
        driver.findElement(By.cssSelector("a[href='add_customer.php']")).click();

        driver.findElement(By.cssSelector("#name")).sendKeys("Ananta");

        driver.findElement(By.cssSelector("textarea[placeholder='ENTER YOUR ADDRESS']")).sendKeys("xyz");

        driver.findElement(By.cssSelector("#buyingrate")).sendKeys("898989");

        driver.findElement(By.cssSelector("#sellingrate")).sendKeys("434343");

        driver.findElement(By.cssSelector("input[value='Add']")).click();

    }
}
