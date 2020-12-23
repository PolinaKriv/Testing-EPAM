package by.epam.framework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage{
    private final String BASE_URL = "https://www.cultbeauty.co.uk/";

    @FindBy(xpath = "//input[@class='js-search-input']")
    private WebElement searchField;

    @FindBy(xpath = "//div[@class='searchIconContainer js-submit-search']")
    private WebElement searchButton;

    @FindBy(xpath = "//a[span='My account']")
    private WebElement myAccountButton;

    @FindBy(xpath = "//div[@class='cmk-cl-popup cb-close']")
    private WebElement popupCloseButton;

    @FindBy(xpath = "//li[@class='countryCode js-country-code']")
    private WebElement countryToShipTo;

    @FindBy (xpath = "//a[@data-country-id='AD']")
    private WebElement differentCountryOption;


    public MainPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public MainPage closePopup(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(popupCloseButton))
                .click();
        return this;
    }

    public MyAccountPage openMyAccount(){
       new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(myAccountButton))
        .click();
       return new MyAccountPage(driver);
    }

    @Override
    public MainPage openPage()
    {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public MainPage changeShippingCountry(){
       waitWebElement(countryToShipTo).click();
       waitWebElement(differentCountryOption).click();
        return this;
    }

    public String getCurrentShippingCountry(){
      return waitWebElement(countryToShipTo).getText();
    }

    private WebElement waitWebElement(WebElement element){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

}
