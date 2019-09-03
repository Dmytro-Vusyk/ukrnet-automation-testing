package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementation of Login page
 */
public class LoginPage extends AbstractPage {
    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);

    @FindBy(id = "id-l")
    private WebElement ifEmail;

    @FindBy(id = "id-p")
    private WebElement ifPassword;

    @FindBy(css = ".button")
    private WebElement btnLogin;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void inputEmail(String email) {
        ifEmail.sendKeys(email);
        logger.info("Input {} into email field", email);
    }

    public void inputPassword(String password) {
        ifPassword.sendKeys(password);
        logger.info("Input {} into password field", password);
    }

    public void clickLoginButton() {
        btnLogin.click();
        logger.info("Button login is clicked");
    }


}
