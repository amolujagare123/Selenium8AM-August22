import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MultiSelectListDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://amolujagare.com/sample");

      /*  List<WebElement> optionList = driver.findElements(By.xpath("//select[@id='seltext']/option"));

        for (int i=0;i<optionList.size();i++)
            System.out.println(optionList.get(i).getText());*/


        // 1. find the web element
        WebElement mulitiList = driver.findElement(By.id("multiSel"));

        // 2. Create the object of Select class
        Select select = new Select(mulitiList);

        Thread.sleep(4000);

        // 3. select the element from the list
        //select.selectByVisibleText("text 2");
       // select.selectByIndex(4);

        select.selectByIndex(0);

        Thread.sleep(4000);
        select.selectByIndex(2);

        Thread.sleep(4000);
        select.selectByIndex(3);

        /*Thread.sleep(4000);
        select.deselectByIndex(3);

        Thread.sleep(4000);
        select.deselectByIndex(2);

        Thread.sleep(4000);
        select.deselectByIndex(0);*/

        Thread.sleep(4000);
        select.deselectAll();
    }
}
