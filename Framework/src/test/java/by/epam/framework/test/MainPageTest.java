package by.epam.framework.test;

import by.epam.framework.page.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainPageTest extends CommonConditions {
    @Test
    public void changeShippingCountryTest(){
        MainPage mainPage=new MainPage(driver).openPage();
        String currentShippingCountry=mainPage.getCurrentShippingCountry();
        String newShippingCountry=mainPage
                .changeShippingCountry()
                .getCurrentShippingCountry();
        Assert.assertNotEquals(currentShippingCountry, newShippingCountry);
    }
}
