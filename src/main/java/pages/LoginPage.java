package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy(xpath = "//h1[@class='a-spacing-small']")
    private WebElement textSignIn;
    @FindBy(xpath = "//input[@type='email']")
    private WebElement enterLoginField;
    @FindBy(xpath = "//input[@id='continue']")
    private WebElement clickContinueButton;
    @FindBy(xpath = "//h4[text()='Incorrect phone number']")
    private WebElement textAfterInvalidLogin;
    @FindBy(xpath = "//a[@id='createAccountSubmit']")
    private WebElement createAccountButton;
    @FindBy(xpath = "//h1[@class='a-spacing-small']")
    private WebElement textAfterClickCreateAccount;




    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public String getTextFromSignInPage(){
        return textSignIn.getText();
    }
    public void enterLogin(String text){
        enterLoginField.sendKeys(text);
    }
    public void clickContinueButton(){
        clickContinueButton.click();
    }
    public String getTextAfterInvalidLogin(){
        return textAfterInvalidLogin.getText();
    }
    public void clickCreateAccountButton(){
        createAccountButton.click();
    }
    public String getTextAfterClickCreateAccountButton(){
        return textAfterClickCreateAccount.getText();
    }

}
