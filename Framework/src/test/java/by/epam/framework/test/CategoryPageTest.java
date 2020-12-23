package by.epam.framework.test;

import by.epam.framework.page.CategoryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class CategoryPageTest extends CommonConditions{

    @Test
    public void categorySortTest(){
        CategoryPage categoryPage=new CategoryPage(driver).openPage();
        String ItemsBeforeSort=categoryPage.getTotalItemsQuantity();
        String ItemsAfterSort=categoryPage.sortByTopRated().getTotalItemsQuantity();
        Assert.assertEquals(ItemsBeforeSort, ItemsAfterSort);
    }
}
