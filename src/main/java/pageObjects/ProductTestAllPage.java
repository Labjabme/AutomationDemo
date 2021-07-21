package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductTestAllPage {
    public WebDriver driver;

    By sauceLabsTestAllLabel = By.className("inventory_details_price");



    public ProductTestAllPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement assertTestAll() {

        return driver.findElement(sauceLabsTestAllLabel);

    }
}
