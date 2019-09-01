package drivers;

import constants.Constants;
import constants.DriversEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {

    private static WebDriver instance;

    private Driver() {
    }

    public static synchronized WebDriver getInstance(DriversEnum browser) {
        switch (browser) {
            case MOZILLA:
                return instantiateDriver(new FirefoxDriver());
            case CHROME:
                System.setProperty(Constants.CHROME_WEBDRIVER_KEY, Constants.CHROME_WEBDRIVER_PATH);
                return instantiateDriver(new ChromeDriver());
            case OPERA:
                return instantiateDriver(new OperaDriver());
            case SAFARI:
                System.setProperty(Constants.SAFARI_WEBDRIVER_KEY, Constants.SAFARI_WEBDRIVER_PATH);
                return instantiateDriver(new SafariDriver());
            default:
                return null;
        }
    }

    private static WebDriver instantiateDriver(WebDriver driver) {
        if (instance == null) {
            instance = driver;
        }
        return instance;
    }
}
