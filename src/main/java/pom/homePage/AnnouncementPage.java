package pom.homePage;

import dataProviders.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pom.BasePom;

import java.sql.Connection;
import java.sql.SQLException;

public class AnnouncementPage extends BasePom {



    @FindBy(xpath = "//input[@class='form-control input-sm']")
    private WebElement searchHistoryField;
    @FindBy(xpath = "(//div[@class='checkbox-custom checkbox-primary'])[1]")
    private WebElement checkAllBox;
    @FindBy(xpath = "//a[@href='/webportal.test/announcement/history']")
    private WebElement announcementHistory;
    @FindBy(xpath = "(//a[@class=' waves-effect waves-classic'])[2]")
    private WebElement announcementButton;

    @FindBy(xpath = "//a[@href='/webportal.test/announcement']")
    private WebElement customerAnnounceButton;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchCustomerAnnounce;

    @FindBy(xpath = "(//div[@class='checkbox-custom checkbox-primary'])[2]")
    private WebElement checkboxCustomerAnnounce;

    @FindBy(xpath = "//button[@id='send']")
    private WebElement sendCustomerAnnounceButton;

    @FindBy(xpath = "//input[@id='subject']")
    private WebElement announcementSubjectField;

    @FindBy(xpath = "//div[@class='note-editable']")
    private WebElement announcementTextField;

    @FindBy(xpath = "//button[@class='btn btn-success btn-add-email pull-right']")
    private WebElement sendTextCustomerAnnounceButton;

    @FindBy(xpath = "//span[@id='checkedNumber']")
    private WebElement checkAllUsersNumber;

    @FindBy(xpath = "(//tr//td)[4]")
    private WebElement subjectOfMailHistory;

    @FindBy(xpath = "//button[@class='btn btn-success pull-right bttn-announce-body waves-effect waves-light']")
    private WebElement viewButton;

    @FindBy(xpath = "//span[@id='span-announcement-body']")
    private WebElement announcementContent;

    @FindBy(xpath = "(//button[@class='btn btn-default float-right margin-0'])[1]")
    private WebElement closeAnnouncementContentButton;

    @FindBy(xpath = "//button[@class='btn btn-info pull-right bttn-history-details waves-effect waves-light']")
    private WebElement detailsAnnouncementButton;

    @FindBy(xpath = "(//button[@class='btn btn-default float-right margin-0'])[2]")
    private WebElement closeHistoryDetailButton;

    @FindBy(xpath = "//a[@href='/webportal.test/announcement/blacklist']")
    private WebElement customerBlackListButton;

    @FindBy(xpath = "//a[@href='/webportal.test/announcement/schedule']")
    private WebElement scheduledNotificationButton;

    @FindBy(xpath = "//div/h2")
    private WebElement scheduledNotificationError;

    By listOfHistoryDetail = By.xpath("//*[@id='table-history-details']/tbody/tr");
    By listOfHistory = By.xpath("//*[@id='DataTables_Table_0']/tbody/tr");

    public AnnouncementPage clickCheckAllBoxButton() {
        baseMethods.click(checkAllBox);
        return this;
    }

    public AnnouncementPage clickAnnouncementButton() {
        baseMethods.click(announcementButton);
        return this;
    }

    public AnnouncementPage clickCustomerAnnounceButton() {
        baseMethods.click(customerAnnounceButton);
        return this;
    }

    public AnnouncementPage findCustomerForAnnounce(String str) {
        baseMethods.sendKeys(searchCustomerAnnounce, str);
        return this;
    }

    public AnnouncementPage clickCheckboxCustomerAnnounce() {
        checkboxCustomerAnnounce.click();
        return this;
    }

    public AnnouncementPage clickSendCustomerAnnounceButton() {
        baseMethods.click(sendCustomerAnnounceButton);
        return this;
    }

    public AnnouncementPage fillAnnouncementSubjectField(String str) {
        baseMethods.sendKeys(announcementSubjectField, str);
        return this;
    }

    public AnnouncementPage fillAnnouncementTextField(String str) {
        baseMethods.sendKeys(announcementTextField, str);
        return this;
    }

    public AnnouncementPage clickSendTextCustomerAnnounceButton() {
        baseMethods.click(sendTextCustomerAnnounceButton);
        return this;
    }

    public int countOfUsersWithMailDB(Connection connection) throws SQLException {
        return selectMethods.countOfSQLQuery(connection, ConfigReader.getProperty("selectOfUsersWithMail"), 1);
    }

    public int numberOfUsersWithMail() {
        return Integer.parseInt(baseMethods.getText(checkAllUsersNumber));
    }

    public AnnouncementPage clickAnnouncementHistory() {
        baseMethods.click(announcementHistory);
        return this;
    }

    public AnnouncementPage checkListOfAnnouncementHistory() {
        Assert.assertTrue(listMethods.getAllElements(listOfHistory).size() > 0);
        return this;
    }

    public AnnouncementPage searchHistory(String str) {
        baseMethods.sendKeys(searchHistoryField, str);
        return this;
    }

    public String getSubjectOfMail() {
        return baseMethods.getText(subjectOfMailHistory);
    }

    public AnnouncementPage clickViewButton() {
        baseMethods.click(viewButton);
        return this;
    }

    public String getAnnouncementContent() {
        return baseMethods.getText(announcementContent);
    }

    public AnnouncementPage clickCloseAnnouncementContent() {
        baseMethods.click(closeAnnouncementContentButton);
        return this;
    }

    public AnnouncementPage clickDetailsAnnouncementButton() {
        baseMethods.click(detailsAnnouncementButton);
        return this;
    }

    public AnnouncementPage checkListOfDetails() {
        Assert.assertTrue(listMethods.getAllElements(listOfHistoryDetail).size()>0);
        return this;
    }


    public AnnouncementPage closeHistoryDetails() {
        baseMethods.click(closeHistoryDetailButton);
        return this;
    }

    public AnnouncementPage clickCustomerBlackList() {
        baseMethods.click(customerBlackListButton);
        return this;
    }

    public AnnouncementPage clickScheduledNotification() {
        baseMethods.click(scheduledNotificationButton);
        return this;
    }

    public String getScheduledNotificationError() {
        return baseMethods.getText(scheduledNotificationError);
    }


}
