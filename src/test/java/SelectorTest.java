import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectorTest {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.findElement(By.cssSelector("//*[@id=\"address-20512\"]/div[2]/a[2]/span/..")).click();

    }
}
