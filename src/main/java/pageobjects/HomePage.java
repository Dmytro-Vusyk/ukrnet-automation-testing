package pageobjects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Homepage implementation of {@link = "https://mail.ukr.net"}
 */
public class HomePage extends AbstractPage {
    private static final Logger logger = LoggerFactory.getLogger(HomePage.class);

    @FindBy(xpath = "//button[@class=\"default compose\"]")
    private WebElement btnCompose;

    @FindBy(xpath = "//section[@class=\"sidebar__list inbox\"]/div[@class=\"sidebar__list-item\"]")
    private WebElement btnInbox;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickButtonCompose() {
        try {
            wait.until(ExpectedConditions.visibilityOf(btnCompose));
            Assertions.assertTrue(btnCompose.isDisplayed());
        } catch (ElementNotInteractableException e) {
            logger.info("Button compose isn't visible");
        }
        btnCompose.click();
        logger.info("Button compose is clicked");
    }

    public void clickInboxButton() {
        wait.until(ExpectedConditions.elementToBeClickable(btnInbox));
        btnInbox.click();
        logger.info("Button Inbox is clicked");
    }

}
