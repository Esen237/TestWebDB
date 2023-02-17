package methods;

import drivers.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ListMethods {

    public List<WebElement> getAllElements(By locator) {
        return Driver.getDriver().findElements(locator);
    }


}
