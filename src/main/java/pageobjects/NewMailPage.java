package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementation of new mail page view
 */
public class NewMailPage extends AbstractPage {
    private static final Logger logger = LoggerFactory.getLogger(NewMailPage.class);

    @FindBy(xpath = "//input[@class=\"input\" and @name=\"toFieldInput\"]")
    private WebElement ifEmail;

    @FindBy(xpath = "//input[@class=\"input\" and @name=\"subject\"]")
    private WebElement ifSubject;

    @FindBy(xpath = "//body[@id=\"tinymce\"]")
    private WebElement messageArea;

    @FindBy(xpath = "//div[@id=\"mceu_33\"]")
    private WebElement ifMassageInput;

    @FindBy(css = ".default.send")
    private WebElement btnSend;

    @FindBy(css = ".action.attachments-file-button")
    private WebElement btnAttachFile;

    @FindBy(xpath = "//div[@class=\"sendmsg__attachment-foot\"]//a[2]")
    private WebElement btnDeleteAttachment;

    public NewMailPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void putEmail(String email) {
        ifEmail.sendKeys(email);
        logger.info("Put {} into mail filed", email);
    }

    public void putSubject(String subject) {
        ifSubject.sendKeys(subject);
        logger.info("Put {} into subject filed", subject);

    }

    public void putMessage(String message) {
        Actions action = new Actions(driver);
        action.click(ifMassageInput)
                .sendKeys(ifMassageInput, message)
                .build()
                .perform();
        logger.info("Put {} into message filed", message);
    }

    public void clickSendButton() {
        btnSend.click();
        logger.info("Button send is clicked");
    }

    public void clickAttachButton() {
        logger.info("Wait util visibility of button attach file");
        wait.until(ExpectedConditions.visibilityOf(btnAttachFile));
        btnAttachFile.click();
        logger.info("Button attach file is clicked");
    }

    public boolean isFileAttached() {
        boolean isAttached;
        try {
            logger.info("Waiting util file will be attached ");
            wait.until(ExpectedConditions
                    .presenceOfElementLocated(By
                            .xpath("//div[@class=\"sendmsg__attachment-foot\"]//a[2]")));
            isAttached = true;
        } catch (NoSuchElementException e) {
            isAttached = false;
        }
        logger.info("File is attached: {}", isAttached);
        return isAttached;
    }

    public boolean isMailSend() {
        boolean isSent;
        isSent = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@class=\"sendmsg__ads-ready\"]")))
                .isDisplayed();
        logger.info("Mail is sent: {}", isSent);
        return isSent;
    }
}
