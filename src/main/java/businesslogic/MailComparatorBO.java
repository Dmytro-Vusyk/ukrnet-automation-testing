package businesslogic;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageobjects.HomePage;
import pageobjects.InboxPage;
import pageobjects.MailPage;

import java.io.*;

/**
 * Implements logic of two files Comparator
 */
public class MailComparatorBO {
    private static final Logger logger = LoggerFactory.getLogger(MailComparatorBO.class);
    private HomePage homePage;
    private InboxPage inboxPage;
    private MailPage mailPage;

    public MailComparatorBO(WebDriver driver) {
        this.homePage = new HomePage(driver);
        this.inboxPage = new InboxPage(driver);
        this.mailPage = new MailPage(driver);
    }

    /** This method takes Path to first file and path to second file and compare it
     * @param originalPath
     * @param downloadedPath
     * @return
     * @throws IOException
     */
    public boolean compareToFiles(String originalPath, String downloadedPath)
            throws IOException {
        boolean equality;
        BufferedInputStream fis1 = null;
        BufferedInputStream fis2 = null;
        try {
            fis1 = new BufferedInputStream(new FileInputStream(originalPath));
            fis2 = new BufferedInputStream(new FileInputStream(downloadedPath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int b1 = 0;
        int b2 = 0;
        int pos = 1;
        while (b1 != -1 && b2 != -1) {
            if (b1 != b2) {
                logger.info(String.format("Files differ at position: %s", pos));
            }
            pos++;
            b1 = fis1.read();
            b2 = fis2.read();
        }
        if (b1 != b2) {
            equality = false;
            logger.info("Files have different length");
        } else {
            logger.info("Files are identical");
            equality = true;
        }
        fis1.close();
        fis2.close();
        deleteFile(downloadedPath);
        return equality;
    }

    public void findMail(String searchedText) {
        homePage.clickInboxButton();
        inboxPage.putSearchText(searchedText);
    }

    public void openMail() {
        inboxPage.openMail();
        Assertions.assertTrue(mailPage.isAttachedFileExists());
    }

    public void downloadAttachedFile() {
        mailPage.downloadAttachment();
    }

    /**
     * Check if File is downloaded
     *
     * @param pathToFile path to file
     */
    public void checkIfFileDownloaded(String pathToFile) {
        Assertions.assertTrue(mailPage.isFileDownloaded(pathToFile));
    }

    private void deleteFile(String pathToFile) {
        boolean isDeleted;
        File file = new File(pathToFile);
        isDeleted = file.delete();
        logger.info(String.format("File at path: %2$2s is deleted: %1$2s", pathToFile, isDeleted));
    }
}
