package methods;

import dataProviders.ConfigReader;
import drivers.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pom.homePage.AnnouncementEmailPage;
import pom.homePage.AnnouncementPage;
import pom.homePage.HomePage;
import pom.loginPage.LoginPage;

import java.util.ArrayList;
import java.util.List;

public class Test{

    public static void main(String[] args) throws InterruptedException {
//        JavaScriptExecutor javaScriptExecutor = new JavaScriptExecutor();
//        ListMethods listMethods = new ListMethods();
//        LoginPage loginPage = new LoginPage();
//        HomePage homePage = new HomePage();
//        AnnouncementPage announcementPage = new AnnouncementPage();
//        AnnouncementEmailPage announcementEmailPage = new AnnouncementEmailPage();
//        Driver.getDriver().get("http://10.30.14.55/webportal.test/login");
//        loginPage.enterUserName(ConfigReader.getProperty("userName"));
//        loginPage.enterPassword(ConfigReader.getProperty("password"));
//        loginPage.clickOnSignInButton();
//        WebElement ann = Driver.getDriver().findElement(By.xpath("//a[@href='/webportal.test/contactCenter/contactCenter']"));
//        ann.click();
//        WebElement ca = Driver.getDriver().findElement(By.xpath("//input[@id='cusNo']"));
//        ca.sendKeys("71051");
//        WebElement search = Driver.getDriver().findElement(By.xpath("(//div/button[@class='btn btn-primary btn-outline waves-effect waves-light'])[1]"));
//        search.click();
//        WebElement phone = Driver.getDriver().findElement(By.xpath("//td[@class=\"col-sm-8 customerPhones\"]"));
//        Assert.assertNotNull(phone.getText());
//        System.out.println(phone.getText()+"phone");
//        System.out.println(javaScriptExecutor.getAllElementsJS());
        String name = "Some";
//        Удаляю созданные детали анонса из БД
        String deleteAnnounceDetail = "delete from WEBPORTAL.CUSTOMER_ANNOUNCE_DETAIL where ANNOUNCE_ID = (select ID from WEBPORTAL.CUSTOMER_ANNOUNCE  where ANNOUNCE_SUBJECT = '"+name+"')";
        System.out.println(deleteAnnounceDetail);


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
