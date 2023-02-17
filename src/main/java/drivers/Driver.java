package drivers;

import dataProviders.ConfigReader;
import org.openqa.selenium.WebDriver;

public class Driver {

    private Driver(){

    }

    public static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver == null){
            switch (ConfigReader.getProperty("browser").toLowerCase()){
                case"edge":
                    driver = EdgeWebDriver.loadEdgeDriver();
                    break;
                default:
                    driver = ChromeDriver.loadChromeDriver();
            }
        }
        return driver;
    }

    public static void closeDriver(){
        try{
            if (driver != null){
                driver.quit();
                driver = null;
            }
        }catch (Exception e){
        e.printStackTrace();}
    }

}
