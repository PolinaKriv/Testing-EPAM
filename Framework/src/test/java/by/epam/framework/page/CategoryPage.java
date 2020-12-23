package by.epam.framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static by.epam.framework.wait.CustomWaits.waitForPageLoaded;

public class CategoryPage extends AbstractPage{

    private static final String SKINCARE_PAGE_URL = "https://www.cultbeauty.co.uk/skin-care.html";
    @FindBy(xpath = "//li[@class='js-product-total']")
    private WebElement totalItemsQuantity;

    @FindBy (xpath = "//select[@class='applySort js-apply-sort']/option[text() = 'Top rated']")
    private WebElement topRatedSortOption;

    @FindBy(xpath = "//a[text='Cleansers']")
    private WebElement subCategory;

    public CategoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getTotalItemsQuantity(){
        return totalItemsQuantity.getText();
    }

    public CategoryPage sortByTopRated(){
        topRatedSortOption.click();
    return this;
    }

    @Override
    public CategoryPage openPage() {
        driver.get(SKINCARE_PAGE_URL);
        waitForPageLoaded(driver);
        return this;
    }


}
