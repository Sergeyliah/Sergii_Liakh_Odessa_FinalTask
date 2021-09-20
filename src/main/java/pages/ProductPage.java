package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{
    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    private WebElement addToCartButton;
    @FindBy(xpath = "//a[@id='nav-logo-sprites']")
    private WebElement homePageButton;
    @FindBy(xpath = "//a[@title='Add to List']")
    private WebElement addToListButton;
    @FindBy(xpath = "//input[@id='buy-now-button']")
    private WebElement buyNowButton;



    public ProductPage(WebDriver driver) {
        super(driver);
    }
    public void clickAddToCartButton(){
        addToCartButton.click();
    }
    public void clickOnHomeButton(){
        homePageButton.click();
    }
    public void clickAddToListButton(){
        addToListButton.click();
    }
    public void clickBuyNowButton(){
        buyNowButton.click();
    }

    public WebElement getBuyNowButton() {
        return buyNowButton;
    }

    public WebElement getAddToListButton() {
        return addToListButton;
    }
}
