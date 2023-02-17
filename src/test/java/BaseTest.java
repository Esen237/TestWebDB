import dataBase.beans.CBS_Erisim_RolBean;
import dataBase.beans.CBS_MusteriBean;
import dataBase.beans.EmailCustomersBean;
import lombok.Getter;
import methods.MailosaurMethods;
import mockData.JavaFakerData;
import org.testng.asserts.SoftAssert;
import pom.homePage.AnnouncementEmailPage;
import pom.homePage.AnnouncementPage;
import pom.homePage.CCCustomerPage;
import pom.homePage.HomePage;
import pom.loginPage.LoginPage;

public abstract class BaseTest extends BeforeAfterWebTest{

    CCCustomerPage ccCustomerPage = new CCCustomerPage();
    SoftAssert softAssert = new SoftAssert();
    JavaFakerData javaFakerData = new JavaFakerData();
    AnnouncementPage announcementPage = new AnnouncementPage();
    AnnouncementEmailPage announcementEmail = new AnnouncementEmailPage();
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    MailosaurMethods mailosaurMethods = new MailosaurMethods();

    @Getter
    public EmailCustomersBean emailCustomersBean = new EmailCustomersBean();
    @Getter
    public CBS_Erisim_RolBean CBSErisimRolBean = new CBS_Erisim_RolBean();
    @Getter
    public CBS_MusteriBean cbs_musteriBean = new CBS_MusteriBean();






}
