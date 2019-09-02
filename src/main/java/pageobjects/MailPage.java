package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * Implementation of Mail page
 */
public class MailPage extends AbstractPage {
    private static final Logger logger = LoggerFactory.getLogger(MailPage.class);

    @FindBy(xpath = "//a[@class=\"button download-attach\"]")
    private WebElement btnDownload;

    @FindBy(xpath = "//div[@class=\"attachment text\"]")
    private WebElement textAttachment;


    public MailPage(WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * THis method downloads file with JS executor
     */
    public void downloadAttachment() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", btnDownload);
        logger.info("Downloading attached file");
    }

    /**
     * This method waits util file is downloaded
     *
     * @param pathToFile path to the downloaded file
     * @return Whether or not the file is downloaded
     */
    public boolean isFileDownloaded(String pathToFile) {
        final File file = new File(pathToFile);
        boolean isExist;
        logger.info("Wait util file is downloaded");
        wait.until((WebDriver wd) -> file.exists());
        isExist = file.exists();
        logger.info(String.format("File exists: %s", isExist));
        return isExist;
    }

    /**
     * This method waits util attachment will be visible
     *
     * @return Whether or not the attachment is exists
     */
    public boolean isAttachedFileExists() {
        boolean isExist;
        logger.info("Waiting util attachment in file is displayed");
        isExist = wait.until(ExpectedConditions.visibilityOf(textAttachment))
                .isDisplayed();
        logger.info(String.format("Attachment is displayed: %s", isExist));
        return isExist;
    }
}
