package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BlogPage extends BasePage{
    @FindBy(xpath = "//span[text()='Subscribe']")
    private WebElement subscribeButton;
    @FindBy(xpath = "//input[@placeholder='Enter email *']")
    private WebElement enterEmailField;

    public BlogPage(WebDriver driver) {
        super(driver);
    }
    public void clickSubscribeButton(){
        subscribeButton.click();
    }

    public WebElement getEnterEmailField() {
        return enterEmailField;
    }
}
