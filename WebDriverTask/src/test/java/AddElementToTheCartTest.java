import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddElementToTheCartTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetUp() {
        driver = new ChromeDriver();
        driver.get("https://www.cultbeauty.co.uk/natasha-denona-mini-zendo-eyeshadow-palette.html");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void addToTheCartTest() {

        WebElement addToBagButton = driver.findElement(By.xpath("//button[@class='btn addCartButton js-add-to-cart']"));
        addToBagButton.click();

        WebElement buttonAddedToCart = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions
                .elementToBeClickable(By.xpath("//button[@class='btn arrow whiteOnBlack js-go-to-cart']")));
        buttonAddedToCart.click();

        WebElement quantityFromCart = driver.findElement(By.xpath("//span[@class='quantity-number']"));

        String expectedQuantity = "1";
        String actualQuantity=quantityFromCart.getText();
        Assert.assertEquals(actualQuantity, expectedQuantity);
    }

}


