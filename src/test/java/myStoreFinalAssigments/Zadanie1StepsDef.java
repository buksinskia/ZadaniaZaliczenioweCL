package myStoreFinalAssigments;

import helpers.WebdriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myStoreFinalAssigments.Pages.*;
import org.junit.After;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class Zadanie1StepsDef {
   private WebDriver driver;
    MyStoreMainPage myStoreMainPage;
    LoginPage loginPage;
    YourAccountPage yourAccountPage;
    YourAdressesPageToCreateNewAdress yourAdressesPageToCreateNewAdress;
    NewAdressPage newAdressPage;
    AdressSavedPage adressSavedPage;
    private String email="vyjzpgssapowsqoqyp@kvhrs.com";
    private String password="testpassword";

    @Before
    public void setup(){
        driver= WebdriverFactory.createChromeDriver();
        myStoreMainPage=new MyStoreMainPage(driver);
        loginPage=new LoginPage(driver);
        yourAccountPage=new YourAccountPage(driver);
        yourAdressesPageToCreateNewAdress=new YourAdressesPageToCreateNewAdress(driver);
        newAdressPage=new NewAdressPage(driver);
        adressSavedPage=new AdressSavedPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


    }
    @Given("registered user is on mystore site")
    public void registeredUserIsOnMystoreSite() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php");

    }

    @When("user clicks sign in")
    public void userClicksSignIn() {
        myStoreMainPage.navigateToSignInOnAMainPage();
    }

    @And("user puts proper credentials into username and passwort input fields and clicks sign in")
    public void userPutsProperCredentialsIntoUsernameAndPasswortInputFieldsAndClicksSignIn() {
        loginPage.loginToAccount(email,password);
    }

    @And("clicks on adresses on a main shop site")
    public void clicksOnAdressesOnAMainShopSite() {
        yourAccountPage.navigateToAdresses();
    }

    @And("clicks create new adress")
    public void clicksCreateNewAdress() {
        yourAdressesPageToCreateNewAdress.navigateToCreateNewAdress();

    }

    @And("fill mandatory fields {string}, {string}, {string}, {string},{string}")
    public void fillMandatoryFields(String alias, String address, String city, String zip, String phone) {
        newAdressPage.fillMandatoryFields(alias,address,city,zip,phone);
    }


    @And("clicks save")
    public void clicksSaveAndChecksStatus() {
        newAdressPage.submitNewAdress();

    }



    @Then("user has succesfully added a new address")
    public void userHasSuccesfullyAddedANewAdress() {
        Assertions.assertEquals("Address successfully added!",adressSavedPage.getAdditionStatusText());

    }

    @And("new adress data was correctly added {string}, {string}, {string}, {string},{string}")
    public void newAdressDataWasCorrectlyAdded(String alias, String adress, String city, String postcode,  String phone) {
        adressSavedPage.adressIsCorrect(alias,adress,city,postcode,phone);
    }







    @And("user delete newly added adress")
    public void userDeleteNewlyAddedAdress() {
        adressSavedPage.deleteAdress();
        
    }

    @And("adress is deleted")
    public void adressIsDeleted() {
        Assertions.assertEquals("Address successfully deleted!",adressSavedPage.getAdditionStatusText());

    }


}
