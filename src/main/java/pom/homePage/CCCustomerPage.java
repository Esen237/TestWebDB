package pom.homePage;

import dataProviders.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pom.BasePom;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CCCustomerPage extends BasePom {

    @FindBy(xpath = "//a[@href='/webportal.test/contactCenter/contactCenter']")
    private WebElement CCCustomerButton;

    @FindBy(xpath = "//input[@id='cusNo']")
    private WebElement customerNoField;

    @FindBy(xpath = "(//div/button[@class='btn btn-primary btn-outline waves-effect waves-light'])[1]")
    private WebElement searchByCustNoButton;

    @FindBy(xpath = "//td[@id='clientNo']")
    private WebElement customerNoInfo;

    @FindBy(xpath = "//td[@class='col-sm-8 customerFullname']")
    private WebElement customerFullNameInfo;

    @FindBy(xpath = "//td[@class='col-sm-8 customerBirthDate']")
    private WebElement customerBirthDateInfo;

    @FindBy(xpath = "//td[@class='col-sm-8 customerPassport']")
    private WebElement customerPassportInfo;

    @FindBy(xpath = "//td[@class='col-sm-8 customerAddress']")
    private WebElement customerAddressInfo;

    @FindBy(xpath = "//td[@class='col-sm-8 customerMobilePhones']")
    private WebElement customerPhoneInfo;

    @FindBy(xpath = "//td[@class='col-sm-8 customerEmail']")
    private WebElement customerEmailInfo;

    @FindBy(xpath = "//a[@href='#exampleTabsTwo']")
    private WebElement phoneButton;

    @FindBy(xpath = "//input[@id='phone']")
    private WebElement phoneField;

    @FindBy(xpath = "(//button[@class='btn btn-primary btn-outline waves-effect waves-light'])[2]")
    private WebElement searchByPhoneButton;

    @FindBy(xpath = "//a[@href='#exampleTabsThree']")
    private WebElement buttonINN;

    @FindBy(xpath = "//input[@id='inn']")
    private WebElement iNNField;

    @FindBy(xpath = "(//button[@class='btn btn-primary btn-outline waves-effect waves-light'])[3]")
    private WebElement searchByINNButton;

    @FindBy(xpath = "//a[@href='#exampleTabsFour']")
    private WebElement fullNameButton;

    @FindBy(xpath = "//input[@id='fullName']")
    private WebElement fullNameField;

    @FindBy(xpath = "//input[@id='birthDate']")
    private WebElement birthDateField;

    @FindBy(xpath = "//a[@id='adminPanel']")
    private WebElement adminPanelButton;

    @FindBy(xpath = "//input[@id='startDate']")
    private WebElement startDateAP;

    @FindBy(xpath = "//input[@id='endDate']")
    private WebElement endDateAP;

    @FindBy(xpath = "//button[@id='showInquiryReport']")
            private WebElement downloadReportButton;

    By foundCustomersByFullName = By.xpath("/html/body/div[7]/div[2]/div[2]/div[1]/div[1]/table/tbody[2]/tr");

    By foundCustomersByPhone = By.xpath("/html/body/div[7]/div[2]/div[2]/div[1]/div[1]/table/tbody[2]/tr");

    By foundCustomersByINN = By.xpath("/html/body/div[7]/div[2]/div[2]/div[1]/div[1]/table/tbody[2]/tr");


    public CCCustomerPage clickPhoneButton() {
        baseMethods.click(phoneButton);
        return this;
    }

    public String getCustomerEmail() {
        return baseMethods.getText(customerEmailInfo);
    }

    public String getCustomerPhoneInfo() {
        return baseMethods.getText(customerPhoneInfo);
    }

    public String getCustomerAddressInfo() {
        return baseMethods.getText(customerAddressInfo);
    }

    public String getCustomerPassportInfo() {
        return baseMethods.getText(customerPassportInfo);
    }

    public String getCustomerBirthDateInfo() {
        return baseMethods.getText(customerBirthDateInfo);
    }

    public String getCustomerFullNameInfo() {
        return baseMethods.getText(customerFullNameInfo);
    }

    public String getCustomerNoInfo() {
        return baseMethods.getText(customerNoInfo);
    }

    public CCCustomerPage clickCCCustomerButton() {
        baseMethods.click(CCCustomerButton);
        return this;
    }

//    public String getRandomCustomerNo() throws SQLException {
//        return selectMethods.getRandomFromList( ConfigReader.getProperty("sqlQueryForAllCustomerNo"), 1);
//    }

    public CCCustomerPage fillTheCustNoField(String customerNo) {
        baseMethods.sendKeys(customerNoField, customerNo);
        return this;
    }

    public CCCustomerPage clickSearchButtonCCC() {
        baseMethods.click(searchByCustNoButton);
        return this;
    }

    public String getRandomCustPhone() throws SQLException {
        return selectMethods.getRandomFromList(ConfigReader.getProperty("sqlQueryForAllPhoneNumbers"), 2);
    }


    public CCCustomerPage fillThePhoneField(String customerPhone) {
        baseMethods.sendKeys(phoneField, customerPhone);
        return this;
    }

    public CCCustomerPage clickSearchByPhone() {
        baseMethods.click(searchByPhoneButton);
        return this;
    }

    public CCCustomerPage checkListOfCustsByPhone() {
        Assert.assertTrue(listMethods.getAllElements(foundCustomersByPhone).size() > 0);
        return this;
    }

//    public String getRandomCustINN() throws SQLException {
//        return selectMethods.getRandomFromList( ConfigReader.getProperty("selectOfInn"), 1);
//    }

    public CCCustomerPage clickINNButton() {
        baseMethods.click(buttonINN);
        return this;
    }

    public CCCustomerPage fillTheINNFiled(String iNN) {
        baseMethods.sendKeys(iNNField, iNN);
        return this;
    }

    public CCCustomerPage clickSearchByINN() {
        baseMethods.click(searchByINNButton);
        return this;
    }

    public CCCustomerPage checkListOfCustsByINN() {
        Assert.assertTrue(listMethods.getAllElements(foundCustomersByINN).size() > 0);
        return this;
    }

    public CCCustomerPage clickFullNameButton() {
        baseMethods.click(fullNameButton);
        return this;
    }

    public CCCustomerPage fillTheFullNameField(String fullName) {
        baseMethods.sendKeys(fullNameField, fullName);
        return this;
    }

    public CCCustomerPage fillTheBirthDateField(String dateOfBirthDay) throws ParseException {
        SimpleDateFormat oldDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        SimpleDateFormat newDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date date = oldDateFormat.parse(dateOfBirthDay);
        String result = newDateFormat.format(date);
        baseMethods.sendKeys(birthDateField, result);
        return this;
    }

    public CCCustomerPage checkListOfCustByFullName() {
        Assert.assertTrue(listMethods.getAllElements(foundCustomersByFullName).size() > 0);
        return this;
    }

    public CCCustomerPage clickAdminPanelButton() {
        baseMethods.click(adminPanelButton);
        return this;
    }

    public CCCustomerPage checkInquiryReport(){
        Assert.assertTrue(startDateAP.isDisplayed());
        Assert.assertTrue(endDateAP.isDisplayed());
        Assert.assertTrue(downloadReportButton.isDisplayed());
        return this;
    }


}
