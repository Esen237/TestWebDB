//import com.mailosaur.MailosaurException;
//import dataBase.beans.CBS_MusteriBean;
//import dataProviders.ConfigReader;
//import oracle.jdbc.driver.OracleConnection;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.Test;
//
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//
//
//public class HomePageTest extends BaseTest {
//
//    String fakeLOLChampion = javaFakerData.getLOLChampion();
//
//    String randomCustomerNo = CBS_MusteriBean.getRandomRow().getMUSTERI_NO();
//
////    String randomCustomerNo = ccCustomerPage.getRandomCustomerNo(connection);
//
////    String randomCustomerPhone = ccCustomerPage.getRandomCustPhone(connection);
//    String randomCustomerInn = ccCustomerPage.getRandomCustINN(connection);
//
//    public HomePageTest() throws SQLException {
//    }
//
//
//    @Test(priority = 1)
//    void loginOnWebPortal() {
//        loginPage.enterUserName(ConfigReader.getProperty("userName"));
//        loginPage.enterPassword(ConfigReader.getProperty("password"));
//        loginPage.clickOnSignInButton();
//        Assert.assertEquals(homePage.getPageTitle(), "Welcome to DKIB Web Portal");
//    }
//
//    @Test(priority = 2)
//    void announceEmailCheck() {
//        announcementEmail.clickAnnouncementEmileButton();
//    }
//
//    @Test(priority = 3)
//    void customerAnnounceEmailCheck() {
//        announcementEmail.clickCustomerAnnounceEmailButton();
//        Assert.assertEquals(announcementEmail.getTextCAEErrorMessage(), "Error Occured.");
//    }
//
//    @Test(priority = 4)
//    void listEmailGroupCheck() {
//        announcementEmail.clickListEmailGroupButton();
//        Assert.assertEquals(announcementEmail.getTextLEGErrorMessage(), "Error Occured.");
//    }
//
//    @Test(priority = 5)
//    void announcementButtonCheck() {
//        announcementPage.clickAnnouncementButton();
//    }
//
//
//    @Test(priority = 6)
//    void testCustomerAnnounce() throws InterruptedException, SQLException {
//        announcementPage.clickCustomerAnnounceButton();
//        announcementPage.clickCheckAllBoxButton();
////        Assert.assertEquals(announcementPage.numberOfUsersWithMail(), numberOfUsersWithMail);
//        softAssert.assertEquals(announcementPage.numberOfUsersWithMail(), announcementPage.countOfUsersWithMailDB(connection));
//        announcementPage.clickCustomerAnnounceButton();
//        announcementPage.findCustomerForAnnounce(ConfigReader.getProperty("customerNo"));
//        announcementPage.clickCheckboxCustomerAnnounce();
//        announcementPage.clickSendCustomerAnnounceButton();
//        announcementPage.fillAnnouncementSubjectField(fakeLOLChampion);
//        announcementPage.fillAnnouncementTextField(fakeLOLChampion);
//        System.out.println(fakeLOLChampion);
//        announcementPage.clickSendTextCustomerAnnounceButton();
//        Thread.sleep(3000);
//    }
//
//
//    @Test(priority = 7)
//    void testEmailMessage() throws MailosaurException, IOException {
////        mailosaurMethods.mailosaurTest(ConfigReader.getProperty("apiKey"),ConfigReader.getProperty("serverId"),ConfigReader.getProperty("serverDomain"));
//    }
//
//
//    @Test(priority = 8)
//    void testAnnouncementHistory() {
//        announcementPage.clickAnnouncementHistory();
//        announcementPage.checkListOfAnnouncementHistory();
//        announcementPage.searchHistory(fakeLOLChampion);
//        Assert.assertEquals(announcementPage.getSubjectOfMail(), fakeLOLChampion);
//        announcementPage.clickViewButton();
//        Assert.assertEquals(announcementPage.getAnnouncementContent(), fakeLOLChampion);
//        announcementPage.clickCloseAnnouncementContent();
//        announcementPage.clickDetailsAnnouncementButton();
//        announcementPage.checkListOfDetails();
//        announcementPage.closeHistoryDetails();
//    }
//
//    @Test(priority = 9)
//    void testCustomerBlackLit() {
//        //        announcementPage.clickCustomerBlackList();
//    }
//
//    @Test(priority = 10)
//    void testScheduledNotification() {
//        announcementPage.clickScheduledNotification();
//        Assert.assertEquals(announcementPage.getScheduledNotificationError(), "Error Occured.");
//    }
//
//    @Test(priority = 11)
//    void testCCCustomer() throws InterruptedException {
//        ccCustomerPage.clickCCCustomerButton();
//        ccCustomerPage.fillTheCustNoField(randomCustomerNo);
//        ccCustomerPage.clickSearchButtonCCC();
//        Assert.assertEquals(ccCustomerPage.getCustomerNoInfo(), randomCustomerNo);
//        ccCustomerPage.clickPhoneButton();
//        ccCustomerPage.fillThePhoneField(randomCustomerPhone);
//        ccCustomerPage.clickSearchByPhone();
//        ccCustomerPage.checkListOfCustsByPhone();
//        ccCustomerPage.clickINNButton();
//        ccCustomerPage.fillTheINNFiled(randomCustomerInn);
//        System.out.println(randomCustomerNo);
//        ccCustomerPage.clickSearchByINN();
//        ccCustomerPage.checkListOfCustsByINN();
////        Assert.assertTrue(ccCustomerPage.getCustomerNoInfo().length()>0);
////        Assert.assertTrue(ccCustomerPage.getCustomerFullNameInfo().length()>0);
////        Assert.assertTrue(ccCustomerPage.getCustomerBirthDateInfo().length()>0);
////        Assert.assertTrue(ccCustomerPage.getCustomerPassportInfo().length()>0);
//        Thread.sleep(3000);
//    }
//
//
//    @AfterClass
//    void deleteFromDB() throws SQLException {
////        Select запрос что-бы удалить детали сделанного анонса
//        String deleteAnnounceDetail = "delete from WEBPORTAL.CUSTOMER_ANNOUNCE_DETAIL where ANNOUNCE_ID = (select ID from WEBPORTAL.CUSTOMER_ANNOUNCE  where ANNOUNCE_SUBJECT = '" + fakeLOLChampion + "')";
////        Select запрос что-бы удалить сделанный анонс
//        String deleteAnnounce = "delete from WEBPORTAL.CUSTOMER_ANNOUNCE  where ANNOUNCE_SUBJECT = '" + fakeLOLChampion + "'";
////        Сохранить изменения
//        String commit = "commit";
//        Statement statement = connection.createStatement();
//        statement.executeQuery(deleteAnnounceDetail);
//        statement.executeQuery(deleteAnnounce);
//        statement.executeQuery(commit);
//    }
//
//
//}
