import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginDemoForThree {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://stock.amolujagare.com/");

        WebElement txtUsername = driver.findElement(By.id("login-username"));
        txtUsername.sendKeys("admin");

        WebElement txtPassword = driver.findElement(By.id("login-password"));
        txtPassword.sendKeys("admin");

        WebElement btnLogin = driver.findElement(By.name("submit"));
        btnLogin.click();


        WebDriverManager.chromedriver().setup();
        WebDriver driver1 = new ChromeDriver();

        driver1.manage().window().maximize();
        driver1.get("https://stock.amolujagare.com/");

        WebElement txtUsername1 = driver1.findElement(By.id("login-username"));
        txtUsername1.sendKeys("sdsd");

        WebElement txtPassword1 = driver1.findElement(By.id("login-password"));
        txtPassword1.sendKeys("dsd");

        WebElement btnLogin1 = driver1.findElement(By.name("submit"));
        btnLogin1.click();

        WebDriverManager.chromedriver().setup();
        WebDriver driver2 = new ChromeDriver();

        driver2.manage().window().maximize();
        driver2.get("https://stock.amolujagare.com/");

        WebElement txtUsername2 = driver2.findElement(By.id("login-username"));
        txtUsername2.sendKeys("");

        WebElement txtPassword2 = driver2.findElement(By.id("login-password"));
        txtPassword2.sendKeys("");

        WebElement btnLogin2 = driver2.findElement(By.name("submit"));
        btnLogin2.click();

    }
}
