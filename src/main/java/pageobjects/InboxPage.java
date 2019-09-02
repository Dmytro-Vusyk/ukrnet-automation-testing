package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementation of Inbox page view
 */
public class InboxPage extends AbstractPage {
    private static final Logger logger = LoggerFactory.getLogger(InboxPage.class);

    /**
     * First mail between searched mails
     */
    @FindBy(xpath = "//table[@class=\"noselect\"]/tbody//tr[1]")
    private WebElement mail;

    @FindBy(xpath = "//div[@class=\"header__search\"]//input")
    private WebElement ifSearch;

    public InboxPage(WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * This method puts text into mail serach field
     *
     * @param searchText text which will be searched
     */
    public void putSearchText(String searchText) {
        logger.info("Wait util search input field is clickable");
        wait.until(ExpectedConditions.elementToBeClickable(ifSearch));
        ifSearch.sendKeys(searchText);
        logger.info(String.format("Put %s to search into search field", searchText));
    }

    public void openMail() {
        mail.click();
        logger.info("first mail in table is clicked");
    }
}
