import dataProviders.ConfigReader;
import drivers.Driver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
public class BeforeAfterWebTest {




    @BeforeTest
    public void setUpTest() {
        Driver.getDriver().get(ConfigReader.getProperty("webPortalLoginPageURL"));
    }

    @AfterTest
    public void closeBrowser() {
        Driver.closeDriver();
    }
}
