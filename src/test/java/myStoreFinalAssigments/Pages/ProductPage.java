package myStoreFinalAssigments.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Objects;

public class ProductPage {
    private WebDriver driver;
    public ProductPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath ="//*[@id=\"main\"]/div[1]/div[2]/div[1]/div[1]/span")
   private WebElement priceBeforeDiscount;
    @FindBy(xpath = "//*[@id=\"main\"]/div[1]/div[2]/div[1]/div[2]/div/span[1]")
   private WebElement priceAfterDiscount;
   @FindBy(id = "group_1")
   private WebElement sizeChoiceDropdown;


    @FindBy(xpath = "//*[@id=\"group_1\"]")
    private WebElement sizeChoiceButton;
    @FindBy(xpath = "//*[@id=\"quantity_wanted\"]")
 private    WebElement quantityInput;
    @FindBy(xpath = "//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button")
   private WebElement addToCartButton;
    @FindBy(xpath = "//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a")
  private   WebElement proceedToCheckoutButton;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a")
  private   WebElement proceedToCheckoutOverwievButton;


    public Boolean checkDiscount(){

        String priceBeforeDiscountWithEuroSign=priceBeforeDiscount.getText();
        String priceAfterDiscountWithEuroSign=priceAfterDiscount.getText();
        String priceBeforeDiscountWithEuroSignTrimmed=priceBeforeDiscountWithEuroSign.substring(1);
        String priceAfterDiscountWithEuroSignTrimmed=priceAfterDiscountWithEuroSign.substring(1);
        Double priceBef=Double.parseDouble(priceBeforeDiscountWithEuroSignTrimmed);
        Double priceAft=Double.parseDouble(priceAfterDiscountWithEuroSignTrimmed);
        return priceBef - (priceBef * 20.00 / 100.00) == priceAft;
    }
    public void sizeChoice(String size){
        sizeChoiceButton.click();
        Select select = new Select(sizeChoiceDropdown);


        if(Objects.equals(size, "S")){
            select.selectByValue(String.valueOf(1));
        }
        else if (Objects.equals(size,"M")){
            select.selectByValue(String.valueOf(2));
        }
        else if (Objects.equals(size,"L")){
            select.selectByValue(String.valueOf(3));
        }
        else if(Objects.equals(size,"XL")){
            select.selectByValue(String.valueOf(4));
        }
        else System.out.println("There's no such size!");
    }
    public void productQuantity(String quantity){
        quantityInput.clear();
        quantityInput.sendKeys(quantity);
    }
public void addItemToBasket(){
        addToCartButton.click();
}
public void proceedToCheckout(){
        proceedToCheckoutButton.click();
}
public void proceedToCheckoutFromOverview(){
        proceedToCheckoutOverwievButton.click();
}
}


