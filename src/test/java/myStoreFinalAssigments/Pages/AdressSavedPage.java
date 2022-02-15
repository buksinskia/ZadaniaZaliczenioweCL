package myStoreFinalAssigments.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

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
    @FindBy(xpath = "/html/body/main/section/div/div/section/section/div[1]/article[1]/div")
            List<WebElement> testAddedAdress;

    public String getAdditionStatusText(){
     return    updateSuccess.getText();
    }
    public void deleteAdress(){
        deleteButton.click();
    }


    public boolean adressIsCorrect(String alias,String adress,String postcode,String city,String phone){
        String unitedKingdom="United Kingdom";
        List<String> adressSections=new ArrayList<>();
        adressSections.add(alias);
        adressSections.add(adress);
        adressSections.add(postcode);
        adressSections.add(city);
        adressSections.add(unitedKingdom);
        adressSections.add(phone);

        String addedAdress=testAddedAdress.get(testAddedAdress.size()-1).getText();
        for (String item:adressSections){
            if(addedAdress.contains(item)){
                return true;
            }
        }
         return false;
    }}


