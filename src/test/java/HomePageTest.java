import com.mailosaur.MailosaurException;
import dataBase.beans.CBS_MusteriBean;
import dataBase.dbUtils.JDBCOracle;
import dataProviders.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;


public class HomePageTest extends BaseTest {


    String fakeAnimalName = javaFakerData.getAnimalName();
    String randomCustomerNo = CBS_MusteriBean.cbs_musteriBean.getMUSTERI_NO();
    String randomCustomerPhone = ccCustomerPage.getRandomCustPhone();
    String randomCustomerInn = CBS_MusteriBean.cbs_musteriBean.getVERGI_NO();
    String randomCustomerLastName = CBS_MusteriBean.cbs_musteriBean.getIKINCI_ISIM();
    String randomCustomerName = CBS_MusteriBean.cbs_musteriBean.getISIM();
    String randomCustomerPatronymic = CBS_MusteriBean.cbs_musteriBean.getSOYADI();
    String randomCustomerBirthDate = CBS_MusteriBean.cbs_musteriBean.getDOGUM_TARIHI();


    public HomePageTest() throws SQLException {
    }

    @Test(priority = 1)
    void loginOnWebPortal() {
        loginPage.enterUserName(ConfigReader.getProperty("userName"));
        loginPage.enterPassword(ConfigReader.getProperty("password"));
        loginPage.clickOnSignInButton();
        Assert.assertEquals(homePage.getPageTitle(), "Welcome to DKIB Web Portal");
    }

    @Test(priority = 2)
    void announceEmailCheck() {
        announcementEmail.clickAnnouncementEmileButton();
    }

    @Test(priority = 3)
    void customerAnnounceEmailCheck() {
        announcementEmail.clickCustomerAnnounceEmailButton();
        Assert.assertEquals(announcementEmail.getTextCAEErrorMessage(), "Error Occured.");
    }

    @Test(priority = 4)
    void listEmailGroupCheck() {
        announcementEmail.clickListEmailGroupButton();
        Assert.assertEquals(announcementEmail.getTextLEGErrorMessage(), "Error Occured.");
    }

    @Test(priority = 5)
    void announcementButtonCheck() {
        announcementPage.clickAnnouncementButton();
    }


    @Test(priority = 6)
    void testCustomerAnnounce() throws InterruptedException, SQLException {
        announcementPage.clickCustomerAnnounceButton();
        announcementPage.clickCheckAllBoxButton();
//        Assert.assertEquals(announcementPage.numberOfUsersWithMail(), numberOfUsersWithMail);
        softAssert.assertEquals(announcementPage.numberOfUsersWithMail(), announcementPage.countOfUsersWithMailDB());
        announcementPage.clickCustomerAnnounceButton();
        announcementPage.findCustomerForAnnounce(ConfigReader.getProperty("customerNo"));
        announcementPage.clickCheckboxCustomerAnnounce();
        announcementPage.clickSendCustomerAnnounceButton();
        announcementPage.fillAnnouncementSubjectField(fakeAnimalName);
        announcementPage.fillAnnouncementTextField(fakeAnimalName);
        System.out.println(fakeAnimalName);
        announcementPage.clickSendTextCustomerAnnounceButton();
        Thread.sleep(3000);
    }


    @Test(priority = 7)
    void testEmailMessage() throws MailosaurException, IOException {
//        mailosaurMethods.mailosaurTest(ConfigReader.getProperty("apiKey"),ConfigReader.getProperty("serverId"),ConfigReader.getProperty("serverDomain"));
    }


    @Test(priority = 8)
    void testAnnouncementHistory() {
        announcementPage.clickAnnouncementHistory();
        announcementPage.checkListOfAnnouncementHistory();
        announcementPage.searchHistory(fakeAnimalName);
        Assert.assertEquals(announcementPage.getSubjectOfMail(), fakeAnimalName);
        announcementPage.clickViewButton();
        Assert.assertEquals(announcementPage.getAnnouncementContent(), fakeAnimalName);
        announcementPage.clickCloseAnnouncementContent();
        announcementPage.clickDetailsAnnouncementButton();
        announcementPage.checkListOfDetails();
        announcementPage.closeHistoryDetails();
    }

    @Test(priority = 9)
    void testCustomerBlackLit() {
        //        announcementPage.clickCustomerBlackList();
    }

    @Test(priority = 10)
    void testScheduledNotification() {
        announcementPage.clickScheduledNotification();
        Assert.assertEquals(announcementPage.getScheduledNotificationError(), "Error Occured.");
    }

    @Test(priority = 11)
    void testCCCustomer() throws InterruptedException, ParseException {
        ccCustomerPage.clickCCCustomerButton();
        ccCustomerPage.fillTheCustNoField(randomCustomerNo);
        ccCustomerPage.clickSearchButtonCCC();
        Assert.assertEquals(ccCustomerPage.getCustomerNoInfo(), randomCustomerNo);
        ccCustomerPage.clickPhoneButton();
        ccCustomerPage.fillThePhoneField(randomCustomerPhone);
        ccCustomerPage.clickSearchByPhone();
        ccCustomerPage.checkListOfCustsByPhone();
        ccCustomerPage.clickINNButton();
        ccCustomerPage.fillTheINNFiled(randomCustomerInn);
        System.out.println(randomCustomerNo);
        ccCustomerPage.clickSearchByINN();
        ccCustomerPage.checkListOfCustsByINN();
        ccCustomerPage.clickFullNameButton();
        ccCustomerPage.fillTheFullNameField(randomCustomerLastName + " " + randomCustomerName + " " + randomCustomerPatronymic);
        ccCustomerPage.fillTheBirthDateField(randomCustomerBirthDate);
        Thread.sleep(3000);
        ccCustomerPage.checkListOfCustByFullName();
        ccCustomerPage.clickAdminPanelButton();
        ccCustomerPage.checkInquiryReport();
        /**Need to add an autotest to the "Create inquiry" page (not added due to a service failure)*/
        Thread.sleep(3000);
    }

    @Test(priority = 12)
    void testDepositCalculator() throws InterruptedException, ParseException {
        depositCalculatorPage.clickDepCalcButton();
        Assert.assertEquals(depositCalculatorPage.getPageTitle(), "Депозитный калькулятор");
        depositCalculatorPage.fillDepositAmountField();
        depositCalculatorPage.selectValueDepositCurrency();
        depositCalculatorPage.clickDateOfDepositField();
        depositCalculatorPage.fillTheAmountOfCommissionField();
        depositCalculatorPage.checkOfPeriodDate();
        depositCalculatorPage.checkOfPeriodDay();
        depositCalculatorPage.fillThePeriodMonthField();
        depositCalculatorPage.fillInterestRateField();
        depositCalculatorPage.selectInterestPayment();
        depositCalculatorPage.selectAccrualOfInterest();
        depositCalculatorPage.clickWithCapitalization();
        depositCalculatorPage.clickDepositReplenishment();
        depositCalculatorPage.fillMinNumberOfMonth();
        depositCalculatorPage.fillDateOfReplenishment();
        depositCalculatorPage.fillAmountField();
        depositCalculatorPage.selectFrequencyField();
        depositCalculatorPage.clickCalculateButton();
        javaScriptExecutor.jsScrollToEnd();
        depositCalculatorPage.resultTableCheck();
        Thread.sleep(3000);
    }

    @Test(priority = 13)
    void testMapMarker() throws InterruptedException {
        mapMarkerPage.clickMapMarkerButton();
        mapMarkerPage.textCheck();
        mapMarkerPage.clickZoomButton();
        mapMarkerPage.clickZoomOutButton();
        mapMarkerPage.clickSputnikButton();
        mapMarkerPage.clickMapButton();
        mapMarkerPage.selectRegion();
        mapMarkerPage.selectObject();
        mapMarkerPage.clickListButton();
        mapMarkerPage.checkListOfMarkers();
        mapMarkerPage.fillSearchField();
        mapMarkerPage.checkTitleColumn();
        Thread.sleep(3000);
        mapMarkerPage.clickShowButton();

    }

    @AfterClass
    void deleteFromDB() {
/**        Select запрос что-бы удалить детали сделанного анонса*/
        String deleteAnnounceDetail = "delete from WEBPORTAL.CUSTOMER_ANNOUNCE_DETAIL where ANNOUNCE_ID = (select ID from WEBPORTAL.CUSTOMER_ANNOUNCE  where ANNOUNCE_SUBJECT = '" + fakeAnimalName + "')";
/**        Select запрос что-бы удалить сделанный анонс*/
        String deleteAnnounce = "delete from WEBPORTAL.CUSTOMER_ANNOUNCE  where ANNOUNCE_SUBJECT = '" + fakeAnimalName + "'";
/**         Сохранить изменения*/

        String commit = "commit";
        JDBCOracle.query(deleteAnnounceDetail);
        JDBCOracle.query(deleteAnnounce);
        JDBCOracle.query(commit);

    }


}
