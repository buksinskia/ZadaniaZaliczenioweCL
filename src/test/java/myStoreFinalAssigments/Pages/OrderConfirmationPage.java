package myStoreFinalAssigments.Pages;

import io.netty.handler.codec.http.multipart.FileUpload;
import org.codehaus.plexus.util.FileUtils;
import org.junit.platform.commons.util.ClassNamePatternFilterUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.File;
import java.io.IOException;

public class OrderConfirmationPage {
    private WebDriver driver;
   public OrderConfirmationPage (WebDriver driver){
        this.driver=driver;
       PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//*[@id=\"content\"]")
    WebElement orderOverview;
   @FindBy(xpath = "//*[@id=\"order-details\"]/h3")
   WebElement orderConfirmed;
   public  void orderScreenShot() throws IOException{
       String fileDestitation="src/Screenshots/screenshot.png";
       File srcFile=orderOverview.getScreenshotAs(OutputType.FILE);
       FileUtils.copyFile(srcFile,new File(fileDestitation));
   }
public String getOrderConfirmation(){
       return orderConfirmed.getText();
}
}

