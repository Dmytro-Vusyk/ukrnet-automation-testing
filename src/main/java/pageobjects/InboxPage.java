package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InboxPage extends AbstractPage {

    @FindBy(xpath = "//table[@class=\"noselect\"]/tbody//tr[1]")
    private WebElement mail;

    @FindBy(xpath = "//div[@class=\"header__search\"]//input")
    private WebElement ifSearch;

    public InboxPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void putSearchText(String searchText){
        wait.until(ExpectedConditions.elementToBeClickable(ifSearch));
        ifSearch.sendKeys(searchText);
    }

    public void openMail(){
        mail.click();
    }
}
