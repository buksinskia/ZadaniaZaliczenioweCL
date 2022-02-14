package myStoreFinalAssigments.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(name = "email")
   private WebElement emailInput;
    @FindBy(name = "password")
   private WebElement passwordInput;
    @FindBy(id = "submit-login")
   private WebElement submitButton;
    public void loginToAccount(String email,String password){
emailInput.sendKeys(email);
passwordInput.sendKeys(password);
submitButton.submit();
    }
}
