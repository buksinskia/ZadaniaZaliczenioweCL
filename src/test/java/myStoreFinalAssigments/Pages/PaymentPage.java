package myStoreFinalAssigments.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
    WebDriver driver;
   public PaymentPage(WebDriver driver){
       this.driver=driver;
       PageFactory.initElements(driver,this);
   }
   @FindBy(xpath ="//*[@id=\"payment-option-1\"]")
   private WebElement payByCheckRadioButton;
   @FindBy(xpath = "//*[@id=\"conditions_to_approve[terms-and-conditions]\"]")
   private WebElement agreementsButton;
   @FindBy(xpath = "//*[@id=\"payment-confirmation\"]/div[1]/button")
   private WebElement orderButton;
   public void chosePaymentMethod(){
       if(!payByCheckRadioButton.isSelected()){
           payByCheckRadioButton.click();
       }
   }
   public void clickOnAgreements(){
       agreementsButton.click();
   }
   public void clickOrderButton(){
       orderButton.click();
   }
}
