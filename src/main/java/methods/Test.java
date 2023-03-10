package methods;

import com.github.javafaker.Faker;
import dataProviders.ConfigReader;
import drivers.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pom.homePage.AnnouncementEmailPage;
import pom.homePage.AnnouncementPage;
import pom.homePage.HomePage;
import pom.loginPage.LoginPage;

import javax.swing.*;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Test{
    @FindBy(xpath = "//select[@id='deposit-currency']")
    private static Select depositCurrencyField;
    public static void main(String[] args) throws InterruptedException, ParseException {
        JavaScriptExecutor javaScriptExecutor = new JavaScriptExecutor();
//        ListMethods listMethods = new ListMethods();
        Actions act = new Actions(Driver.getDriver());
        LoginPage loginPage = new LoginPage();
//        HomePage homePage = new HomePage();
//        AnnouncementPage announcementPage = new AnnouncementPage();
//        AnnouncementEmailPage announcementEmailPage = new AnnouncementEmailPage();

        Driver.getDriver().get("http://10.30.14.55/webportal.test/login");
        loginPage.enterUserName(ConfigReader.getProperty("userName"));
        loginPage.enterPassword(ConfigReader.getProperty("password"));
        loginPage.clickOnSignInButton();
        WebElement submitButton = Driver.getDriver().findElement(By.xpath("//a[@href='/webportal.test/contactCenter/contactCenter']"));
        submitButton.click();
        WebElement mapMarker = Driver.getDriver().findElement(By.xpath("//a[@href='/webportal.test/map_marker']"));
        mapMarker.click();
        WebElement mapList = Driver.getDriver().findElement(By.xpath("//a[@id='ui-id-2']"));
        mapList.click();
        WebElement branches = Driver.getDriver().findElement(By.xpath("//tr[@role='row']"));
        System.out.println(javaScriptExecutor.getAllElementsJS());


//        WebElement deposit = Driver.getDriver().findElement(By.xpath("//a[@href='/webportal.test/deposit_calculator']"));
//        deposit.click();
//        Select depositCurrency = new Select(Driver.getDriver().findElement(By.xpath("//select[@id='deposit-currency']")));
//        depositCurrency.selectByIndex(2);
//        WebElement capitalization = Driver.getDriver().findElement(By.xpath("//input[@id='with-capitalization']"));
//        capitalization.click();
//        WebElement depositCalculator = Driver.getDriver().findElement(By.xpath("//input[@id='with-capitalization']"));
//        act.moveToElement(depositCalculator).click().perform();
//        javaScriptExecutor.jsClick(depositCalculator);




//
//        String date1 = String.valueOf(LocalDate.now());
//        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = dt.parse(date1);
//        SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
//        System.out.println(dt1.format(date));


//                .nextLong(d1.getTime(), d2.getTime()));
//        int days = Days.daysBetween(d1, d2).toDays();
//        LocalDate randomDate = d1.addDays(
//                ThreadLocalRandom.current().nextInt(days+1));



//        WebElement ca = Driver.getDriver().findElement(By.xpath("//input[@id='cusNo']"));
//        ca.sendKeys("71051");
//        WebElement search = Driver.getDriver().findElement(By.xpath("(//div/button[@class='btn btn-primary btn-outline waves-effect waves-light'])[1]"));
//        search.click();
//        WebElement phone = Driver.getDriver().findElement(By.xpath("//td[@class=\"col-sm-8 customerPhones\"]"));
//        Assert.assertNotNull(phone.getText());
//        System.out.println(phone.getText()+"phone");
//        System.out.println(javaScriptExecutor.getAllElementsJS());
//        String name = "Some";
//        Удаляю созданные детали анонса из БД
//        String deleteAnnounceDetail = "delete from WEBPORTAL.CUSTOMER_ANNOUNCE_DETAIL where ANNOUNCE_ID = (select ID from WEBPORTAL.CUSTOMER_ANNOUNCE  where ANNOUNCE_SUBJECT = '"+name+"')";
//        System.out.println(deleteAnnounceDetail);


//        Assert.assertEquals(homePage.getPageTitle(),"Welcome to DKIB Web Portal");
//        announcementPage.clickAnnouncementButton();
//        announcementPage.clickCustomerAnnounceButton();
//        announcementPage.findCustomerForAnnounce(ConfigReader.getProperty("customerNo"));
//        WebElement checkbox = Driver.getDriver().findElement(By.xpath("(//div[@class='checkbox-custom checkbox-primary'])[2]"));
//        checkbox.click();
//        Thread.sleep(5000);
//
//
//        Driver.closeDriver();

    }

}
