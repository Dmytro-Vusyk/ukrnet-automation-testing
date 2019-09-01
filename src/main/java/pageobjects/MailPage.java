package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;

public class MailPage extends AbstractPage {

    @FindBy(xpath = "//a[@class=\"button download-attach\"]")
    private WebElement btnDownload;

    @FindBy(xpath = "//div[@class=\"attachment text\"]")
    private WebElement textAttachment;


    public MailPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void downloadAttachment() {
        // wait.until(ExpectedConditions.visibilityOf(btnDownload));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", btnDownload);
    }

    public boolean isFileDownloaded(String pathToFile) {
        final File file = new File(pathToFile);
        wait.until((WebDriver wd) -> file.exists());
        return file.exists();
    }

    public boolean isAttachedFileExists() {
        boolean isExist;
        isExist = wait.until(ExpectedConditions.visibilityOf(textAttachment))
                .isDisplayed();
        return isExist;
    }
}
