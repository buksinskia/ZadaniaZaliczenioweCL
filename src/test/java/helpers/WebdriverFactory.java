package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebdriverFactory {
        public static WebDriver createChromeDriver() {
            System.setProperty("webdriver.chrome.driver",
                    "src/main/resources/drivers/chromedriver.exe");

            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();

            return driver;
        }
    }


