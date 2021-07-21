package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductOnsiePage {

    public WebDriver driver;

    By sauceLabsOnsieLabel = By.className("inventory_details_price");


    public ProductOnsiePage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement assertOnsie() {

        return driver.findElement(sauceLabsOnsieLabel);

    }
}
