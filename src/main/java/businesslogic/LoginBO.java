package businesslogic;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pageobjects.HomePage;
import pageobjects.LoginPage;

public class LoginBO {
    private LoginPage loginPage;
    private HomePage homePage;

    public LoginBO(WebDriver driver) {
        this.loginPage = new LoginPage(driver);
        this.homePage = new HomePage(driver);
    }

    public void login(String email, String password){
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
        loginPage.clickLoginButton();
        Assertions.assertTrue(homePage.isBtnComposeVisible(),"Button login is visible");
    }

}
