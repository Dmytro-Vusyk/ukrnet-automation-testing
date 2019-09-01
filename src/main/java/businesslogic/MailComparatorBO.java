package businesslogic;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pageobjects.HomePage;
import pageobjects.InboxPage;
import pageobjects.MailPage;

import java.io.*;

public class MailComparatorBO {
    private HomePage homePage;
    private InboxPage inboxPage;
    private MailPage mailPage;

    public MailComparatorBO(WebDriver driver) {
        this.homePage = new HomePage(driver);
        this.inboxPage = new InboxPage(driver);
        this.mailPage = new MailPage(driver);
    }

    public boolean compareToFiles(String originalPath, String downloadedPath) throws IOException {
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
                System.out.println("Files differ at position " + pos);
            }
            pos++;

            b1 = fis1.read();
            b2 = fis2.read();
        }
        if (b1 != b2) {
            equality = false;
            System.out.println("Files have different length");
        } else {
            System.out.println("Files are identical, you can delete one of them.");
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

    public void checkDownloadedFile(String pathToFile) {
        Assertions.assertTrue(mailPage.isFileDownloaded(pathToFile));
    }

    private void deleteFile(String pathToFile){
        boolean isDeleted;
        File file = new File(pathToFile);
        isDeleted = file.delete();
    }
}
