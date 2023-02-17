import dataProviders.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;



public class LoginPageTest extends BaseTest {

    @Test(priority = 0)
    void loginOnWebPortal(){
        loginPage.enterUserName(ConfigReader.getProperty("userName"));
        loginPage.enterPassword(ConfigReader.getProperty("password"));
        loginPage.clickOnSignInButton();
        Assert.assertEquals(homePage.getPageTitle(),"Welcome to DKIB Web Portal");
    }






}
