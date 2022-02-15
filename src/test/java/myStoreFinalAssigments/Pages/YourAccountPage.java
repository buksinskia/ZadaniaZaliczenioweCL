package myStoreFinalAssigments.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAccountPage {
    private WebDriver driver;
   public YourAccountPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//*[@id=\"footer_account_list\"]/li[4]/a")
    private WebElement adressesButton;
   @FindBy(xpath = "//*[@id=\"_desktop_logo\"]/a")
   private WebElement myStoreLogo;
    public void navigateToAdresses(){
        adressesButton.click();
    }

    public void navigateToMainPage(){
    myStoreLogo.click();
}}
