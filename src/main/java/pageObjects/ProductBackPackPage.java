package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductBackPackPage {
    public WebDriver driver;

    By sauceLabsBackpackLabel = By.className("inventory_details_price");


    public WebElement assertBackPack(){

        return driver.findElement(sauceLabsBackpackLabel);

    }


    public ProductBackPackPage(WebDriver driver) {
        this.driver = driver;
    }
}
