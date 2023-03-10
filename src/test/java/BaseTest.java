import dataBase.beans.CBS_Erisim_RolBean;
import dataBase.beans.CBS_MusteriBean;
import dataBase.beans.EmailCustomersBean;
import dataBase.dbUtils.BeansClasses;
import lombok.Getter;
import methods.JavaScriptExecutor;
import methods.MailosaurMethods;
import mockData.JavaFakerData;
import org.testng.asserts.SoftAssert;
import pom.homePage.*;
import pom.loginPage.LoginPage;

public abstract class BaseTest extends BeforeAfterWebTest{

    DepositCalculatorPage depositCalculatorPage = new DepositCalculatorPage();
    CCCustomerPage ccCustomerPage = new CCCustomerPage();
    SoftAssert softAssert = new SoftAssert();
    JavaFakerData javaFakerData = new JavaFakerData();
    AnnouncementPage announcementPage = new AnnouncementPage();
    AnnouncementEmailPage announcementEmail = new AnnouncementEmailPage();
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    MailosaurMethods mailosaurMethods = new MailosaurMethods();
    JavaScriptExecutor javaScriptExecutor = new JavaScriptExecutor();
    MapMarkerPage mapMarkerPage = new MapMarkerPage();
    BeansClasses beansClasses = new BeansClasses();






}
