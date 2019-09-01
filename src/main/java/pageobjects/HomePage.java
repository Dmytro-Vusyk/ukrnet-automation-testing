package pageobjects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends AbstractPage {
    @FindBy(xpath = "//button[@class=\"default compose\"]")
    private WebElement btnCompose;

    @FindBy(xpath = "//section[@class=\"sidebar__list inbox\"]/div[@class=\"sidebar__list-item\"]")
    private WebElement btnInbox;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isBtnComposeVisible(){
        wait.until(ExpectedConditions.visibilityOf(btnCompose));
        boolean isDisplayed = btnCompose.isDisplayed();
        return isDisplayed;
    }

    public void clickButtonCompose(){
        try {
            Assertions.assertTrue(btnCompose.isDisplayed());
        } catch (ElementNotInteractableException e){
           // log.info("training list button isn't visible");
        }
        btnCompose.click();
    }

    public void clickInboxButton(){
        wait.until(ExpectedConditions.elementToBeClickable(btnInbox));
        btnInbox.click();
    }

}
