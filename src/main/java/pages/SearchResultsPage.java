package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage{
    @FindBy(xpath = "//img[@alt='Sponsored Ad - Bluefin Cruise SUP Package | Stand Up Inflatable Paddle Board | 6” Thick | Fibreglass Paddle | Kayak Conver...']")
    private WebElement bluefinCruiseSUP;
    @FindBy(css = ".bxc-grid__row--light:nth-child(2) > .bxc-grid__column--1-of-5:nth-child(1)")
    private WebElement smartLighting;
    @FindBy(xpath = "//img[@alt='Smart Light Bulbs']")
    private WebElement smartLightBulbs;
    @FindBy(xpath = "//img[@src='https://m.media-amazon.com/images/I/61P4aXalzLL._AC_UY218_.jpg']")
    private WebElement KasaSmartLightBulbs;
    @FindBy(xpath = "//span[@class='a-dropdown-prompt']")
    private WebElement sortByButton;
    @FindBy(xpath = "//a[text()='Price: Low to High']")
    private WebElement sortByPriceAsc;
    @FindBy(xpath = "//span[text()='See all results']")
    private WebElement seeAllResultButton;


    public WebElement getSmartLighting() {
        return smartLighting;
    }

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }
    public void clickOnBluefinCruiseSUP(){
        bluefinCruiseSUP.click();
    }
    public void clickToSelectLighting(){
        smartLighting.click();
    }
    public void clickToSelectSmartLightBulbs(){
        smartLightBulbs.click();
    }
    public void clickKasaSmartLightBulbs(){
        KasaSmartLightBulbs.click();
    }
    public void clickSortByButton(){
        sortByButton.click();
    }
    public void clickSortByPriceAsc(){
        sortByPriceAsc.click();
    }

    public WebElement getKasaSmartLightBulbs() {
        return KasaSmartLightBulbs;
    }
    public void clickSeeAllResultButton(){
        seeAllResultButton.click();
    }
}
