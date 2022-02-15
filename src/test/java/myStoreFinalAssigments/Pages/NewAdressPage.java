package myStoreFinalAssigments.Pages;

import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

public class NewAdressPage {
    private WebDriver driver;
    public NewAdressPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(name = "alias")
    private WebElement aliasInput;
    @FindBy(name ="address1")
    private WebElement adressInput;
    @FindBy(name ="city" )
    private WebElement cityInput;
    @FindBy(name = "postcode")
    private WebElement postCodeInput;
    @FindBy(xpath ="//*[@id=\"content\"]/div/div/form/section/div[10]/div[1]/select" )
    private WebElement countryDropdown;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[10]/div[1]/select/option[2]")
    private WebElement choseUKbutton;
    @FindBy(name = "phone")
    WebElement phoneInput;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/footer/button")
    private WebElement saveFormButton;
    public void fillMandatoryFields(String alias, String address,String city,String zippostalcode,String phone){
        String country="UK";
        aliasInput.sendKeys(alias);
        adressInput.sendKeys(address);
        cityInput.sendKeys(city);
        postCodeInput.sendKeys(zippostalcode);
if(Objects.equals(country, "UK")){
        countryDropdown.click();
        choseUKbutton.click();}
else {
    throw new ElementNotSelectableException("There's no such  country on a list");
}


        postCodeInput.sendKeys(phone);
        postCodeInput.sendKeys(phone);
    }
    public void submitNewAdress(){
        saveFormButton.submit();
    }
}
