package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewMailPage extends AbstractPage {

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
    }

    public void putSubject(String subject) {
        ifSubject.sendKeys(subject);
    }

    public void putMessage(String message) {
        Actions action = new Actions(driver);
        action.click(ifMassageInput)
                .sendKeys(ifMassageInput, message)
                .build()
                .perform();
    }

    public void clickSendButton() {
        btnSend.click();
    }

    public void clickAttachButton() {
        wait.until(ExpectedConditions.visibilityOf(btnAttachFile));
        btnAttachFile.click();
    }

    public boolean isFileAttached(){
        boolean isAttached;
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"sendmsg__attachment-foot\"]//a[2]")));
            isAttached = true;
        } catch (NoSuchElementException e) {
            isAttached = false;
        }
        return isAttached;
    }

    public boolean isMailSend(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"sendmsg__ads-ready\"]"))).isDisplayed();
    }
}
