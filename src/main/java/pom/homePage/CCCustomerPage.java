package pom.homePage;

import dataProviders.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pom.BasePom;

import java.sql.Connection;
import java.sql.SQLException;

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
    public WebElement iNNField;

    @FindBy(xpath = "(//button[@class='btn btn-primary btn-outline waves-effect waves-light'])[3]")
    public WebElement searchByINNButton;

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

    public String getRandomCustomerNo(Connection connection) throws SQLException {
        return selectMethods.getRandomFromList(connection, ConfigReader.getProperty("sqlQueryForAllCustomerNo"), 1);
    }

    public CCCustomerPage fillTheCustNoField(String customerNo) {
        baseMethods.sendKeys(customerNoField, customerNo);
        return this;
    }

    public CCCustomerPage clickSearchButtonCCC() {
        baseMethods.click(searchByCustNoButton);
        return this;
    }

    public String getRandomCustPhone(Connection connection) throws SQLException {
        return selectMethods.getRandomFromList(connection, ConfigReader.getProperty("sqlQueryForAllPhoneNumbers"), 2);
    }


    public CCCustomerPage fillThePhoneField(String customerPhone) {
        baseMethods.sendKeys(phoneField, customerPhone);
        return this;
    }

    public CCCustomerPage clickSearchByPhone() {
        baseMethods.click(searchByPhoneButton);
        return this;
    }

    public CCCustomerPage queryDB(Connection connection, String sqlQuery) throws SQLException {
        selectMethods.query(connection, sqlQuery);
        return this;
    }

    public CCCustomerPage checkListOfCustsByPhone() {
        Assert.assertTrue(listMethods.getAllElements(foundCustomersByPhone).size() > 0);
        return this;
    }

    public String getRandomCustINN(Connection connection) throws SQLException {
        return selectMethods.getRandomFromList(connection, ConfigReader.getProperty("selectOfInn"), 1);
    }

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

}
