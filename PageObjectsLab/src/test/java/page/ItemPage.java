package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemPage extends AbstractPage{

    private static final String ITEM_URL = "https://www.cultbeauty.co.uk/natasha-denona-mini-zendo-eyeshadow-palette.html";

    final int WAIT_TIME_SECONDS = 10;

    @FindBy(xpath = "//button[@class='btn addCartButton js-add-to-cart']")
    private WebElement buttonAddToCart;

    @FindBy(xpath = "//button[@class='btn arrow whiteOnBlack js-go-to-cart']")
    private WebElement viewShoppingBagButton;

    public ItemPage(WebDriver driver){
        super(driver);
    }

    @Override
    public ItemPage openPage() {
        driver.get(ITEM_URL);
        return this;
    }

    public CartPage viewShoppingBag(){
        waitWebElement(viewShoppingBagButton).click();
        return new CartPage(driver);
    }

    public ItemPage buttonAddItemToCartClick(){
        waitWebElement(buttonAddToCart).click();
        return this;
    }

    private WebElement waitWebElement(WebElement element){
        return new WebDriverWait(driver, WAIT_TIME_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(element));
    }
}
