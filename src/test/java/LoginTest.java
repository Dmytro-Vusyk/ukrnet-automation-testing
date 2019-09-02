import businesslogic.LoginBO;
import businesslogic.MailComparatorBO;
import businesslogic.MailCreationBO;
import constants.Constants;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

public class LoginTest extends BaseTest {

    LoginBO loginBO = new LoginBO(driver);
    MailCreationBO mailCreationBO = new MailCreationBO(driver);
    MailComparatorBO comparatorBO = new MailComparatorBO(driver);

    @Test
    public void test() {
        driver.get(Constants.WEBSITE_PATH);
        loginBO.login(Constants.EMAIL, Constants.PASSWORD);
        mailCreationBO.composeMail(Constants.PATH_TO_FILE);
        mailCreationBO.sendMail();
        comparatorBO.findMail(Constants.SUBJECT);
        comparatorBO.openMail();
        comparatorBO.downloadAttachedFile();
        comparatorBO.checkIfFileDownloaded(Constants.PATH_TO_DOWNLOADED_FILE);
        try {
            boolean isEquals =
                    comparatorBO.compareToFiles(Constants.PATH_TO_FILE, Constants.PATH_TO_DOWNLOADED_FILE);
           Assertions.assertTrue(isEquals);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
