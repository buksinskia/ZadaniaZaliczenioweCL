package myStoreFinalAssigments.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAdressesPageToCreateNewAdress {
    private WebDriver driver;
    public YourAdressesPageToCreateNewAdress(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/a")
    private WebElement createNewAdressButton;
    public void navigateToCreateNewAdress(){
        createNewAdressButton.click();
    }
}
