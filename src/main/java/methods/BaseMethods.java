package methods;

import drivers.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseMethods {

    public BaseMethods waitElementToBeClickable(WebElement element){
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element));
        return this;
    }

    public BaseMethods waitElementToBeVisible(WebElement element){
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));
        return this;
    }

    public BaseMethods waitElementToBeClickableAndVisible(WebElement element){
        waitElementToBeClickable(element).waitElementToBeVisible(element);
        return this;
    }

    public BaseMethods click(WebElement element){
        waitElementToBeClickable(element);
        element.click();
        return this;
    }

    public BaseMethods sendKeys(WebElement element, String str){
        element.sendKeys(str);
        return this;
    }

    public String getText(WebElement element){
        waitElementToBeVisible(element);
        return element.getText();
    }


}
