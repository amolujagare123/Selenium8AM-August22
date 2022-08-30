import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LoginDemoFindElements {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://stock.amolujagare.com/");

        List<WebElement> elementList = driver.findElements(By.tagName("input"));

        System.out.println("Size="+elementList.size());

        elementList.get(0).sendKeys("admin");
        elementList.get(1).sendKeys("admin");
        elementList.get(2).click();
    }
}
