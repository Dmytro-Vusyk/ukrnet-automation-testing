package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    @FindBy(id = "id-l")
    public WebElement ifEmail;
    @FindBy(id = "id-p")
    public WebElement ifPassword;
    @FindBy(css = ".button")
    private WebElement btnLogin;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void inputEmail(String email){
        ifEmail.sendKeys(email);
    }

    public  void inputPassword(String password){
        ifPassword.sendKeys(password);
    }

    public void clickLoginButton(){
        btnLogin.click();
    }


}
