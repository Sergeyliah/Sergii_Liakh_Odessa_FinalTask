package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    @FindBy(xpath = "//span[@id='nav-cart-count']")
    private WebElement cartProductsCount;
    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement searchField;
    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    private WebElement searchButton;
    @FindBy(xpath = "//span[@class='hm-icon-label']")
    private WebElement allProductButton;
    @FindBy(xpath = "//a[@data-ref-tag='nav_em_1_1_1_8']")
    private WebElement smartHomeButton;
    @FindBy(xpath = "//a[@href='/gp/browse.html?node=6563140011&ref_=nav_em_amazon_smart_home_0_2_7_2']")
    private WebElement amazonSmartHomeButton;
    @FindBy(xpath = "//span[@class='nav-icon nav-arrow']")
    private WebElement flagButton;
    @FindBy(xpath = "//span[text()='Deutsch - DE']")
    private WebElement germanLanguageOnDropDownMenu;
    @FindBy(xpath = "//a[@id='icp-touch-link-language']")
    private WebElement languageOnTheBottomOfSite;
    @FindBy(xpath = "//div[@class='nav-line-1-container']")
    private WebElement signInButton;
    @FindBy(xpath = "//span[text()='Sign in']")
    private WebElement nextSignInButton;
    @FindBy(xpath = "//a[@href='https://blog.aboutamazon.com/?utm_source=gateway&utm_medium=footer']")
    private WebElement blogButton;
    @FindBy(xpath = "//span[@id='nav-cart-count']")
    private WebElement cartButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public void openHomePage(String url) {
        driver.get(url);
    }
    public void isSearchFieldVisible(){
        searchField.isDisplayed();
    }
    public void enterTextToSearchField(String text){
        searchField.sendKeys(text);
    }
    public void clickSearchButton(){
        searchButton.click();
    }
    public String getProductsCountAtCart(){
        return cartProductsCount.getText();
    }

    public WebElement getCartProductsCount() {
        return cartProductsCount;
    }
    public void clickButtonAll(){
        allProductButton.click();
    }
    public void clickSmartHomeButton(){
        smartHomeButton.click();
    }
    public void clickAmazonSmartHomeButton(){
        amazonSmartHomeButton.click();
    }
    public void flagDropDown(){
        Actions act = new Actions(driver);
        act.moveToElement(flagButton).perform();
    }
    public void selectGemanLanguage(){
        germanLanguageOnDropDownMenu.click();
    }
    public String languageGetText(){
        return languageOnTheBottomOfSite.getText();
    }

    public WebElement getFlagButton() {
        return flagButton;
    }

    public WebElement getGermanLanguageOnDropDownMenu() {
        return germanLanguageOnDropDownMenu;
    }
    public void selectSignInButton(){
        Actions act = new Actions(driver);
        act.moveToElement(signInButton).perform();
    }
    public void clickNextSignInButton(){
        nextSignInButton.click();
    }
    public void clickBlogButton(){
        blogButton.click();
    }
    public void clickCartButton(){
        cartButton.click();
    }

}
