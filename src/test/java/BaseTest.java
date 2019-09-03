import constants.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class BaseTest {
    protected static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        System.setProperty(Constants.CHROME_WEBDRIVER_KEY, Constants.CHROME_WEBDRIVER_PATH);
        WebDriverManager.chromedriver().setup();
        Map<String, Object> prefsMap = new HashMap<>();
        prefsMap.put("profile.default_content_settings.popups", 0);
        prefsMap.put("download.default_directory", Constants.PATH_TO_DOWNLOAD_FOLDER);

        ChromeOptions option = new ChromeOptions();
        option.setExperimentalOption("prefs", prefsMap);
        option.addArguments("--test-type");
        option.addArguments("--disable-extensions");
        driver = new ChromeDriver(option);
        if (driver != null) {
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
