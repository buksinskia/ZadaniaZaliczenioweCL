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

import java.io.IOException;
import java.time.Duration;

public class Zadanie2PrestaShopBasket {
WebDriver driver;
    private String email="vyjzpgssapowsqoqyp@kvhrs.com";
    private String password="testpassword";
    MyStoreMainPage myStoreMainPage;
    LoginPage loginPage;
    YourAccountPage yourAccountPage;
    ProductPage productPage;
    OrderAdressesPage orderAdressesPage;
    ShippingMethodPage shippingMethodPage;
    PaymentPage paymentPage;
    OrderConfirmationPage orderConfirmationPage;

    @Before
    public void setup (){

        driver=WebdriverFactory.createChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        myStoreMainPage=new MyStoreMainPage(driver);
        loginPage=new LoginPage(driver);
        yourAccountPage=new YourAccountPage(driver);
        productPage=new ProductPage(driver);
        orderAdressesPage=new OrderAdressesPage(driver);
        shippingMethodPage=new ShippingMethodPage(driver);
        paymentPage=new PaymentPage(driver);
        orderConfirmationPage=new OrderConfirmationPage(driver);


    }
    @After
    public void teardown(){
        driver.quit();
    }
    @Given("user is registred on mystore site and loged in")
    public void userIsRegistredOnMystoreSiteAndLogedIn() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        myStoreMainPage.navigateToSignInOnAMainPage();
        loginPage.loginToAccount(email,password);



    }

    @When("navigates to main shop page")
    public void navigatesToMainShopPage() {
        yourAccountPage.navigateToMainPage();
    }

    @And("chooses  Hummingbird Printed Sweater")
    public void choosesHummingbirdPrintedSweater() {
        myStoreMainPage.clickOnChosenProduct();
    }

    @And("checks if discount for item is 20")
    public void checksIfDiscountForItemIs() {
        System.out.println("Discount for chosen product is 20%: "+productPage.checkDiscount());

    }

    @And("chooses {string} size")
    public void chooses(String size) {
        productPage.sizeChoice(size);
    }

    @And("orders {string} pieces of chosen item")
    public void ordersPiecesOfChosenItem(String quantity) {
        productPage.productQuantity(quantity);
    }

    @And("adds item to the card by clicking add to cart")
    public void addsItemToTheCardByClickingAddToCart() {
        productPage.addItemToBasket();
    }

    @And("clicks proceed to checkout")
    public void clicksProceedToCheckout() {
        productPage.proceedToCheckout();
        productPage.proceedToCheckoutFromOverview();
    }

    @And("clicks continiue on Adresses view")
    public void fillInAdressFieldsAndClicksContiniue() {
        orderAdressesPage.clickContiniue();
    }

    @And("choses pickup in store method and clicks continiue")
    public void chosesPickupInStoreMethodAndClicksContiniue() {
        shippingMethodPage.selectDeliveryMethod();
        shippingMethodPage.shippingPressContiniue();
    }

    @And("clicks Pay by check method clicks agree with terms of service")
    public void clicksPayByCheckMethodClicksAgreeWithTermsOfService() {
        paymentPage.chosePaymentMethod();
        paymentPage.clickOnAgreements();
    }

    @And("clicks order with an obligatory to pay")
    public void clicksOrderWithAnObligatoryToPay() {
        paymentPage.clickOrderButton();
    }

    @Then("order is confirmed and screenshoot is done")
    public void orderIsConfirmedAndScreenshootIsDone() throws IOException {
        orderConfirmationPage.orderScreenShot();
        Assertions.assertEquals("ORDER DETAILS:",orderConfirmationPage.getOrderConfirmation());
    }
}
