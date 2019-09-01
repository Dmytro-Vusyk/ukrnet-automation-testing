package businesslogic;

import constants.Constants;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pageobjects.HomePage;
import pageobjects.NewMailPage;

public class MailCreationBO {
    private HomePage homePage;
    private NewMailPage mailPage;
    private UploadRobot robot;

    public MailCreationBO(WebDriver driver) {
        this.homePage = new HomePage(driver);
        this.mailPage = new NewMailPage(driver);
        this.robot = new UploadRobot();
    }

    public void composeMail(String path){
        homePage.clickButtonCompose();
        mailPage.putEmail(Constants.EMAIL);
        mailPage.putSubject(Constants.SUBJECT);
        mailPage.putMessage(Constants.EMAIL_TEXT);
        mailPage.clickAttachButton();
        robot.uploadFileWithRobot(path);
        Assertions.assertTrue(mailPage.isFileAttached());
    }

    public void sendMail(){
        mailPage.clickSendButton();
        Assertions.assertTrue(mailPage.isMailSend());
    }

}
