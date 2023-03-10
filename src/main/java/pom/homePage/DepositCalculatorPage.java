package pom.homePage;

import io.cucumber.java.eo.Se;
import mockData.JavaFakerData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pom.BasePom;

import java.text.ParseException;

public class DepositCalculatorPage extends BasePom {

    @FindBy(xpath = "//a[@href='/webportal.test/deposit_calculator']")
    private WebElement depositCalculatorButton;

    @FindBy(xpath = "//h1[@class='page-title']")
    private WebElement pageTitle;

    @FindBy(xpath = "//input[@id='deposit-amount']")
    private WebElement depositAmountField;

    @FindBy(xpath = "//select[@id='deposit-currency']")
    private WebElement depositCurrencyField;

    @FindBy(xpath = "//input[@id='deposit-date']")
    private WebElement dateOfDeposit;

    @FindBy(xpath = "//input[@id='comission']")
    private WebElement amountOfCommission;

    @FindBy(xpath = "//input[@id='end-date']")
    private WebElement periodDate;

    @FindBy(xpath = "//input[@id='end-date-day']")
    private WebElement periodDay;

    @FindBy(xpath = "//input[@id='end-date-month']")
    private WebElement periodMonth;

    @FindBy(xpath = "//input[@id='interest-rate']")
    private WebElement interestRateField;

    @FindBy(xpath = "//select[@id='interest-payment']")
    private WebElement interestPaymentField;

    @FindBy(xpath = "//select[@id='interest-charge']")
    private WebElement accrualOfInterest;

    @FindBy(xpath = "//input[@id='with-capitalization']")
    private WebElement withCapitalization;

    @FindBy(xpath = "//div[@style='width: 98px;']")
    private WebElement depositReplenishment;

    @FindBy(xpath = "//input[@id='months-for-replenishment']")
    private WebElement minNumberOfMonth;

    @FindBy(xpath = "//input[@name='date-replenishment-1']")
    private WebElement dateOfReplenishment;

    @FindBy(xpath = "//input[@name='deposit-replenishment-amount-1']")
    private WebElement amountField;

    @FindBy(xpath = "//select[@name='deposit-replenishment-type-1']")
    private WebElement frequencyField;

    @FindBy(xpath = "//button[@class='btn btn-primary waves-effect waves-light']")
    private WebElement calculateButton;


    By resultTable = By.xpath("//tbody//tr");

    public DepositCalculatorPage resultTableCheck() {
        Assert.assertTrue(listMethods.getAllElements(resultTable).size() > 0);
        return this;
    }

    public DepositCalculatorPage clickCalculateButton() {
        baseMethods.click(calculateButton);
        return this;
    }

    public DepositCalculatorPage selectFrequencyField() {
        new Select(frequencyField).selectByIndex(JavaFakerData.getRandomNumber(1));
        return this;
    }

    public DepositCalculatorPage fillAmountField() {
        baseMethods.sendKeys(amountField, String.valueOf(JavaFakerData.getRandomNumber(10000)));
        return this;
    }

    public DepositCalculatorPage fillDateOfReplenishment() throws ParseException {
        baseMethods.sendKeys(dateOfReplenishment, JavaFakerData.getLocalDate());
        return this;
    }

    public DepositCalculatorPage fillMinNumberOfMonth() {
        baseMethods.sendKeys(minNumberOfMonth, String.valueOf(JavaFakerData.getRandomNumber(10)));
        return this;
    }

    public DepositCalculatorPage clickDepositReplenishment() {
        baseMethods.click(depositReplenishment);
        return this;
    }

    public DepositCalculatorPage clickWithCapitalization() {
        withCapitalization.click();
        return this;
    }

    public DepositCalculatorPage selectAccrualOfInterest() {
        new Select(accrualOfInterest).selectByIndex(JavaFakerData.getRandomNumber(1));
        return this;
    }

    public DepositCalculatorPage selectInterestPayment() {
        new Select(interestPaymentField).selectByIndex(JavaFakerData.getRandomNumber(1));
        ;
        return this;
    }

    public DepositCalculatorPage fillInterestRateField() {
        baseMethods.sendKeys(interestRateField, String.valueOf(JavaFakerData.getRandomNumber(99)));
        return this;
    }

    public DepositCalculatorPage fillThePeriodMonthField() {
        baseMethods.sendKeys(periodMonth, "13");
        return this;
    }

    public DepositCalculatorPage checkOfPeriodDay() {
        baseMethods.waitElementToBeClickable(periodDay);
        return this;
    }

    public DepositCalculatorPage checkOfPeriodDate() {
        baseMethods.waitElementToBeClickable(periodDate);
        return this;
    }

    public DepositCalculatorPage fillTheAmountOfCommissionField() {
        baseMethods.sendKeys(amountOfCommission, String.valueOf(JavaFakerData.getRandomNumber(1000)));
        return this;
    }

    public DepositCalculatorPage clickDateOfDepositField() {
        baseMethods.waitElementToBeClickable(dateOfDeposit);
        return this;
    }

    public DepositCalculatorPage selectValueDepositCurrency() {
        new Select(depositCurrencyField).selectByIndex(JavaFakerData.getRandomNumber(2));
        return this;
    }

    public DepositCalculatorPage fillDepositAmountField() {
        baseMethods.sendKeys(depositAmountField, "200000");
        return this;
    }

    public String getPageTitle() {
        return baseMethods.getText(pageTitle);
    }

    public DepositCalculatorPage clickDepCalcButton() {
        baseMethods.click(depositCalculatorButton);
        return this;
    }

}
