package businesslogic;

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
    }

}
