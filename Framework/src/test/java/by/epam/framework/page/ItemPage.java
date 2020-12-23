package by.epam.framework.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemPage extends AbstractPage{

    private String itemURL;
    @FindBy(xpath = "//button[@class='btn addCartButton js-add-to-cart']")
    private WebElement buttonAddToCart;

    @FindBy(xpath = "//button[@class='btn arrow whiteOnBlack js-go-to-cart']")
    private WebElement viewShoppingBagButton;

    public ItemPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public ItemPage(WebDriver driver, String itemURL) {
        super(driver);
        this.itemURL = itemURL;
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public ItemPage openPage() {
        driver.navigate().to(itemURL);
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
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(element));
    }
}
