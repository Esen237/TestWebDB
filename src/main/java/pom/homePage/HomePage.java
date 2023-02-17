package pom.homePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pom.BasePom;

public class HomePage extends BasePom {
    @FindBy(xpath = "//h1[@class='page-title']")
    private WebElement pageTitle;




    public String getPageTitle() {
        return baseMethods.getText(pageTitle);
    }





}
