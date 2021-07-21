package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductBikeLightPage  {
    public WebDriver driver;

    By sauceLabsBackLightLabel = By.className("inventory_details_price");

    public ProductBikeLightPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement assertBikeLight(){

        return driver.findElement(sauceLabsBackLightLabel);

    }
}
