package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {

    public WebDriver driver;
  //  By sauceLabsBackpack = By.id("add-to-cart-sauce-labs-backpack");
   By sauceLabsBackpack = By.className("inventory_item_img");
    By sauceLabsBikeLight = By.id("item_0_title_link");
    By sauceLabsBoltTshirt = By.id("item_1_title_link");
    By sauceLabsFleeceJacket = By.id("item_5_title_link");
    By sauceLabsOnsie = By.id("item_2_title_link");
    By sauceLabsTestAll = By.id("item_3_title_link");


    public ProductsPage(WebDriver driver) {
        this.driver = driver;
   }
    public WebElement clickBackPack(){

        return driver.findElement(sauceLabsBackpack);

    }
    public WebElement clickBikeLight(){

        return driver.findElement(sauceLabsBikeLight);
    }

    public WebElement clickBoltTshirt(){

        return driver.findElement(sauceLabsBoltTshirt);
    }

    public WebElement clickFleeceJacket(){

        return driver.findElement(sauceLabsFleeceJacket);
    }

    public WebElement clickOnsie(){

        return driver.findElement(sauceLabsOnsie);
    }

    public WebElement clickTestAll(){

        return driver.findElement(sauceLabsTestAll);
    }




}
