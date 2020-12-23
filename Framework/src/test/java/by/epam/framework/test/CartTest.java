package by.epam.framework.test;


import by.epam.framework.model.Item;
import by.epam.framework.page.ItemPage;
import by.epam.framework.service.ItemCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends CommonConditions {
    private Item item= ItemCreator.withUrlFromProperty();

    @Test
    public void addElementToCartTest() {
        String actualItem = new ItemPage(driver,item.getUrl())
                .openPage()
                .buttonAddItemToCartClick()
                .viewShoppingBag()
                .getItemName();

        Assert.assertEquals(actualItem,item.getName());
}

    @Test
    public void addOneElementToCartTest() {
        String actualCounterValue = new ItemPage(driver,item.getUrl())
                .openPage()
                .buttonAddItemToCartClick()
                .viewShoppingBag()
                .getItemsQuantity();

        String expectedCounterValue = "1";

        Assert.assertEquals(expectedCounterValue, actualCounterValue);
    }

    @Test
    public void removeItemFromCartTest() {
        String actualCartContext = new ItemPage(driver,item.getUrl())
                .openPage()
                .buttonAddItemToCartClick()
                .viewShoppingBag()
                .removeItem()
                .getCartContentText();

        String expectedCartContext = "Your bag is empty";

        Assert.assertEquals(actualCartContext, expectedCartContext);
    }
}
