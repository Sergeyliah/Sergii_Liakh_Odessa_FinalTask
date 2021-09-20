package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage{
    @FindBy(xpath = "//input[@value='Delete']")
    private WebElement deleteProductFromCartButton;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }
    public void clickDeleteProductFromCart(){
        deleteProductFromCartButton.click();
    }
}
