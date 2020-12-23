package by.epam.framework.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends AbstractPage{

    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//div[@class='removeItem js-remove-checkout-item']")
    private WebElement removeItemButton;

    @FindBy(xpath = "//span[@class='quantity-number']")
    private WebElement quantityNumber;

    @FindBy(xpath ="//div[@class='checkoutHeader']")
    private WebElement cartContent;

    @FindBy(xpath = "//td[@class='itemName']")
    private WebElement itemName;

    private final By cartContext=By.xpath("//div[@class='checkoutHeader']");

    public CartPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public CartPage openPage() {
        return null;
    }

    public String getItemName(){
        return waitWebElement(itemName).getText();
    }

    public CartPage removeItem(){
        waitWebElement(removeItemButton).click();
        logger.info("Item was removed from the cart");
        return this;
    }

    public String getCartContentText(){
       WebElement cartContextText=new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .presenceOfElementLocated(cartContext));
        return cartContextText.getText();
    }

    public String getItemsQuantity(){
        return waitWebElement(quantityNumber).getText();
    }

    private WebElement waitWebElement(WebElement element){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

}
