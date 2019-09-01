package pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract class AbstractPage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public AbstractPage(WebDriver webDriver) {
        this.driver = webDriver;
        wait = new WebDriverWait(driver,10, 1000);
        PageFactory.initElements(driver, this);
    }
}
