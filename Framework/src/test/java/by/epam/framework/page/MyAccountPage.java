package by.epam.framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage extends AbstractPage{
    private final String MY_ACCOUNT_PAGE_URL = "https://www.cultbeauty.co.uk/customer/account/";

    @FindBy(xpath ="//p[@class='accountEmail js-account-email']")
    private WebElement usersEmail;

    @FindBy(xpath ="//a[@href='/customer/account/logout']")
    private WebElement logoutButton;

    protected MyAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    protected MyAccountPage openPage() {
        driver.get(MY_ACCOUNT_PAGE_URL);
        return this;
    }

    public void logOut(){
        logoutButton.click();
    }

    public String getLoggedInUserEmail()
    {
        WebElement linkLoggedInUser = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(usersEmail));
        return usersEmail.getText();
    }

}
