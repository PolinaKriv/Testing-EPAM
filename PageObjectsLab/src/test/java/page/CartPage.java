package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends AbstractPage{

    public static final int WAIT_TIME_SECONDS = 10;

    @FindBy(xpath = "//div[@class='removeItem js-remove-checkout-item']")
    private WebElement removeItemButton;

    @FindBy(xpath = "//span[@class='quantity-number']")
    private WebElement quantityNumber;

    @FindBy(xpath ="//div[@class='checkoutHeader']")
    private WebElement cartContent;

    public CartPage(WebDriver driver){
        super(driver);
    }

    @Override
    public CartPage openPage() {
        return null;
    }

    public CartPage removeItem(){
        waitWebElement(removeItemButton).click();
        return this;
    }

    public String getCartContentText(){
        return new WebDriverWait(driver,WAIT_TIME_SECONDS)
                .until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//div[@class='checkoutHeader']")))
                .getText();
    }

    public String getItemsQuantity(){
        return waitWebElement(quantityNumber).getText();
    }

    private WebElement waitWebElement(WebElement element){
        return new WebDriverWait(driver, WAIT_TIME_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

}
