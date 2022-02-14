package myStoreFinalAssigments.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdressSavedPage {
    WebDriver driver;
    public AdressSavedPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//*[@id=\"notifications\"]/div/article")
    private WebElement updateSuccess;
    @FindBy(xpath = "/html/body/main/section/div/div/section/section/div[1]/article/div[2]/a[2]/span/..")
    private WebElement deleteButton;

    public String getAdditionStatusText(){
     return    updateSuccess.getText();
    }
    public void deleteAdress(){
        deleteButton.click();
    }
}
