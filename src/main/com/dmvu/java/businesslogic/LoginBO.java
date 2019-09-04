package businesslogic;

import org.openqa.selenium.WebDriver;
import pageobjects.LoginPage;

public class LoginBO {
    private LoginPage loginPage;

    public LoginBO(WebDriver driver) {
        this.loginPage = new LoginPage(driver);
    }

    public void login(String email, String password) {
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
        loginPage.clickLoginButton();
    }

}
