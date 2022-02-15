package myStoreFinalAssigments.Pages;

import helpers.WebdriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyStoreMainPage {
   private WebDriver driver;
   public MyStoreMainPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath ="//*[@id=\"_desktop_user_info\"]/div/a")
   private WebElement signInButton;
   @FindBy(xpath = "//*[text()='Hummingbird printed sweater']")
   private WebElement chosenProduct;

    public void navigateToSignInOnAMainPage(){

        signInButton.click();
   }
    public void clickOnChosenProduct(){
        chosenProduct.click();}
}

