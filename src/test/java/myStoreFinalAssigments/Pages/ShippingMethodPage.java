package myStoreFinalAssigments.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingMethodPage {
    private WebDriver driver;
   public ShippingMethodPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//*[@id=\"delivery_option_1\"]")
    private WebElement prestaShopButton;
   @FindBy(xpath = "//*[@id=\"js-delivery\"]/button")
  private WebElement continiueButton;
    public void selectDeliveryMethod(){
        if(!prestaShopButton.isSelected()){
            prestaShopButton.click();
        }
    }
    public void shippingPressContiniue(){
        continiueButton.click();
    }
}
