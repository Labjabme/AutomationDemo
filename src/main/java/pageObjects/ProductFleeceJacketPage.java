package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductFleeceJacketPage {
    public WebDriver driver;

    By sauceLabsFleeceJacketLabel = By.className("inventory_details_price");



    public ProductFleeceJacketPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement assertFleeceJacket() {

        return driver.findElement(sauceLabsFleeceJacketLabel);

    }
}
