import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginDemoXpath {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://stock.amolujagare.com/");

        WebElement txtUsername = driver.findElement(By.xpath("//input[@type='text']"));
        txtUsername.sendKeys("admin");

        WebElement txtPassword = driver.findElement(By.xpath("//input[@name='password']"));
        txtPassword.sendKeys("admin");

        System.out.println(txtPassword);

        WebElement btnLogin = driver.findElement(By.xpath("//input[@type='submit']"));
        btnLogin.click();

        //driver.findElement(By.linkText("Add Customer")).click();
        driver.findElement(By.xpath("//a[@href='add_customer.php']")).click();

        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Ananta");

        driver.findElement(By.xpath("//*[@name='address']")).sendKeys("xyz");

        driver.findElement(By.xpath("//*[@name='contact1']")).sendKeys("898989");

        driver.findElement(By.xpath("//*[@name='contact2']")).sendKeys("434343");

        driver.findElement(By.xpath("//*[@name='Submit']")).click();

    }
}
