package pom.loginPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pom.BasePom;


public class LoginPage extends BasePom {

    @FindBy(xpath = "//div[@role='alert']/h4")
    WebElement attentionMessage;

    @FindBy(xpath = "//input[@name='username']")
    WebElement userNameField;

    @FindBy(xpath = "//input[@type='password']")
    WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement singInButton;


    public String getAttentionMessage() {
        return baseMethods.getText(attentionMessage);
    }

    public LoginPage getInputField() {
        baseMethods.waitElementToBeClickableAndVisible(userNameField);
        return this;
    }

    public LoginPage enterUserName(String str) {
        baseMethods.sendKeys(userNameField, str);
        return this;
    }

    public LoginPage enterPassword(String str) {
        baseMethods.sendKeys(passwordField, str);
        return this;
    }

    public LoginPage clickOnSignInButton() {
        baseMethods.click(singInButton);
        return this;
    }


}
