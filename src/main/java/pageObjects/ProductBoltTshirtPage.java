package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductBoltTshirtPage {
    public WebDriver driver;

    By sauceLabsBoltTshirtLabel = By.className("inventory_details_price");


    public ProductBoltTshirtPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement assertBikeBoltTshirt() {

        return driver.findElement(sauceLabsBoltTshirtLabel);

    }
}
