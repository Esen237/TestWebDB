package pom.homePage;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pom.BasePom;

public class AnnouncementEmailPage extends BasePom {


    @FindBy(xpath = "(//a[@class=' waves-effect waves-classic'])[1]")
    private WebElement announceEmileButton;

    @FindBy(xpath = "//a[@href='/webportal.test/announcementEmail']")
    private WebElement customerAnnounceEmailButton;

    @FindBy(xpath = "//div[@class='page-content container-fluid']/h2")
    private WebElement errorMessageCAE;

    @FindBy(xpath = "//a[@href='/webportal.test/announcementEmail']")
    private WebElement listEmailGroupButton;

    @FindBy(xpath = "//div[@class='page-content container-fluid']/h2")
    private WebElement errorMessageLEG;



    public AnnouncementEmailPage clickAnnouncementEmileButton() {
        baseMethods.click(announceEmileButton);
        return this;
    }

    public AnnouncementEmailPage clickCustomerAnnounceEmailButton() {
        baseMethods.click(customerAnnounceEmailButton);
        return this;
    }

    public String getTextCAEErrorMessage() {
        return baseMethods.getText(errorMessageCAE);
    }

    public AnnouncementEmailPage clickListEmailGroupButton() {
        baseMethods.click(listEmailGroupButton);
        return this;
    }

    public String getTextLEGErrorMessage() {
        return baseMethods.getText(errorMessageLEG);
    }

}
