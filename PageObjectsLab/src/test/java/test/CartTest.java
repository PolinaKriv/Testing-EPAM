package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.ItemPage;

public class CartTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path + "\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    public void addElementsToCartTest() {
        String actualCounterValue = new ItemPage(driver)
                .openPage()
                .buttonAddItemToCartClick()
                .viewShoppingBag()
                .getItemsQuantity();


        String expectedCounterValue = "1";

        Assert.assertEquals(expectedCounterValue, actualCounterValue);
    }


    @Test
    public void removeItemFromCartTest() {
        String actualCartContext = new ItemPage(driver)
                .openPage()
                .buttonAddItemToCartClick()
                .viewShoppingBag()
                .removeItem()
                .getCartContentText();

        String expectedCartContext = "Your bag is empty";

        Assert.assertEquals(actualCartContext, expectedCartContext);
    }
}
