package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.ArrayList;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;
    WebDriver driver;
    HomePage homePage;
    ShoppingCartPage shoppingCartPage;
    SearchResultsPage searchResultsPage;
    ProductPage productPage;
    BlogPage blogPage;
    PageFactoryManager pageFactoryManager;
    LoginPage loginPage;


    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }
    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }
    @When("User makes search by keyword {string}")
    public void enterTextToSearchField(final String keyword){
        homePage.enterTextToSearchField(keyword);
    }
    @And("User clicks search button")
    public void clickForSearching(){
        homePage.clickSearchButton();
    }
    @And("User clicks on Bluefin Cruise SUP")
    public void clickOnBluefinCruiseSUP(){
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.clickOnBluefinCruiseSUP();
    }
    @And("User clicks add to cart button")
    public void clickAddToCart(){
        productPage = pageFactoryManager.getProductPage();
        productPage.clickAddToCartButton();
    }
    @And("User clicks on Home page button")
    public void clickHomeButtonOnProductPage(){
        productPage.clickOnHomeButton();
    }
    @Then("User checks that amount of products in cart are {string}")
    public void checkAmountOfProductsInCart(final String expectedText){
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getCartProductsCount());
        assertEquals(homePage.getProductsCountAtCart(), expectedText);
    }
    @And("User clicks All button")
    public void clickAllProductButton(){
        homePage.clickButtonAll();
    }
    @And("User clicks Smart home button")
    public void clickSmartHomeButton(){
        homePage.clickSmartHomeButton();
    }
    @And("User clicks Amazon Smart home")
    public void clickAmazonSmartHome(){
        homePage.clickAmazonSmartHomeButton();
    }
    @And("User clicks on Lighting")
    public void clickOnLighting(){
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.clickToSelectLighting();
    }
    @And("User clicks on Light bulbs")
    public void clickLightBulbs(){
        searchResultsPage.clickToSelectSmartLightBulbs();
    }
    @And("User clicks seeAllResult button")
    public void clickSeeAllResultButton(){
        searchResultsPage.clickSeeAllResultButton();
    }
    @And("User clicks on Kasa Smart Light Bulbs")
    public void clickOnKasaSmartLightBulbs(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 3000)", "");
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultsPage.getKasaSmartLightBulbs());
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.clickKasaSmartLightBulbs();
    }
    @And("User clicks Add to list button")
    public void clickAddToListButton(){
        productPage = pageFactoryManager.getProductPage();
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getAddToListButton());
        productPage.clickAddToListButton();
    }
    @Then("User checks presence of {string}")
    public void checkPresenceOfText(final String text){
        assertTrue(driver.getCurrentUrl().contains(text));
    }
    @And("User clicks buy now button")
    public void clickBuyNowButton(){
        productPage = pageFactoryManager.getProductPage();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", productPage.getBuyNowButton());
    }
    @Then("User checks presence of text {string} on login page")
    public void checkPresenceOfTextOnLoginPage(final String text){
        loginPage = pageFactoryManager.getLoginPage();
        assertEquals(loginPage.getTextFromSignInPage(), text);
    }
    @And("User move over flag on the header of the home page")
    public void flagDropdownMenu(){
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getFlagButton());
        homePage.flagDropDown();
    }
    @And("User select german language")
    public void selectGermanLanguage(){
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getGermanLanguageOnDropDownMenu());
        homePage.selectGemanLanguage();
    }
    @Then("User checks language {string}")
    public void checkLanguage(final String text){
        assertEquals(homePage.languageGetText(), text);
    }
    @And("User select button for sign in")
    public void selectSignInButton(){
        homePage.selectSignInButton();
    }
    @And("User clicks next sign in button")
    public void clickNextSignInButton(){
        homePage.clickNextSignInButton();
    }
    @And("User enter login {string}")
    public void enterLogin(final String text){
        loginPage = pageFactoryManager.getLoginPage();
        loginPage.enterLogin(text);
    }
    @And("User clicks continue button")
    public void clickContinueButton(){
        loginPage.clickContinueButton();
    }
    @Then("User checks text after invalid login {string}")
    public void checkTextAfterInvalidLogin(final String text){
        loginPage = pageFactoryManager.getLoginPage();
        assertEquals(loginPage.getTextAfterInvalidLogin(), text);
    }
    @And("User clicks create account")
    public void clickCreateAccountButton(){
        loginPage = pageFactoryManager.getLoginPage();
        loginPage.clickCreateAccountButton();
    }
    @Then("User checks possibility to create new account by {string}")
    public void checkPossibilityToCreateAccount(final String text){
        assertEquals(loginPage.getTextAfterClickCreateAccountButton(), text);
    }
    @And("User clicks blog button")
    public void clickBlogButton(){
        homePage.clickBlogButton();
    }
    @And("User clicks subscribe button")
    public void clickSubscribeButton(){
        blogPage = pageFactoryManager.getBlogPage();
        blogPage.clickSubscribeButton();
        ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        driver.close();
        driver.switchTo().window(tabs.get(1));
    }

    @Then("User checks presence of element")
    public void checkPresenceOfElement(){
        blogPage = pageFactoryManager.getBlogPage();
        assertTrue(blogPage.getEnterEmailField().isDisplayed());
    }
    @And("User clicks sort button")
    public void clickSortButton(){
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.clickSortByButton();
    }
    @And("User clicks sort by price ascending")
    public void clickSortByPriceAscButton(){
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.clickSortByPriceAsc();
    }
    @And("User clicks cart button")
    public void clickCartButton(){
        homePage.clickCartButton();
    }
    @And("User clicks delete product from cart")
    public void clickDeleteProductFromCartButton(){
        shoppingCartPage = pageFactoryManager.getShoppingCartPage();
        shoppingCartPage.clickDeleteProductFromCart();
    }



    @After
    public void tearDown() {
        driver.close();
    }

}