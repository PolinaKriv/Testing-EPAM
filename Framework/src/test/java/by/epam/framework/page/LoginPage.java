package by.epam.framework.page;
import by.epam.framework.model.User;
import by.epam.framework.wait.CustomConditions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static by.epam.framework.wait.CustomWaits.waitForPageLoaded;

public class LoginPage extends AbstractPage
{
    private final Logger logger = LogManager.getRootLogger();
    private final String PAGE_URL = "https://www.cultbeauty.co.uk/customer/account/login/";

    @FindBy(xpath = "//input[@name='username']")
    private WebElement inputLogin;

    @FindBy(xpath="//input[@name='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[@type='submit' and text()='Login']")
    private WebElement buttonSubmit;

    @FindBy(xpath = "//div[@class='js-action-msg actionError']")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public LoginPage openPage()
    {
        driver.navigate().to(PAGE_URL);
        logger.info("Login page opened");
        return this;
    }

    public MainPage login(User user)
    {
        inputLogin.sendKeys(user.getUserEmail());
        inputPassword.sendKeys(user.getPassword());
        buttonSubmit.click();
        logger.info("Login performed");
        return new MainPage(driver);
    }

    public String getErrorMessage() {
        waitForPageLoaded(driver);
        return errorMessage.getText();
    }

    private WebElement waitWebElement(WebElement element){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

}
