package demonstration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.ProductBackPackPage;
import pageObjects.ProductsPage;

import java.io.IOException;

public class ProductsBackPackPage extends base {

    public WebDriver driver;

/*    @BeforeTest
    public void initialise() throws IOException {

        driver = initializeDriver();
        driver.get("https://www.saucedemo.com/");
        // driver.get(prop.getProperty("url"));
    }*/

    @Test(dataProvider = "getData")

    public void assertBackPackLabel(String Username, String Password) throws IOException{

        driver = initializeDriver();
        driver.get("https://www.saucedemo.com/");
        LoginPage login = new LoginPage(driver);
        login.getUserName().sendKeys(Username);

        switch (Username){

            case "locked_out_user":
                //login.getUserName().sendKeys(Username);
                login.getPassWord().sendKeys(Password);
                login.loginButton().click();
                LoginPage loginError = new LoginPage(driver);
                loginError.lockOutUser().isDisplayed();
                String errorUser = loginError.lockOutUser().getText();
                System.out.println(errorUser);
                //wait();

                Assert.assertEquals(errorUser, "Epic sadface: Sorry, this user has been locked out.");
                driver.close();
                break;

            case "standard_user":
            case "performance_glitch_user":

                login.getPassWord().sendKeys(Password);
                login.loginButton().click();
                ProductsPage selectProduct = new ProductsPage(driver);
                selectProduct.clickBackPack().click();
                ProductBackPackPage backPageLabel = new ProductBackPackPage(driver);
                String getPrice = backPageLabel.assertBackPack().getText();
                System.out.println(getPrice);
                Assert.assertEquals(getPrice, "$29.99");
                driver.close();

                break;

            case "problem_user":
                login.getPassWord().sendKeys(Password);
                login.loginButton().click();
                ProductsPage selectProduct1 = new ProductsPage(driver);
                selectProduct1.clickBackPack().click();
                ProductBackPackPage backPageLabel1 = new ProductBackPackPage(driver);
                String getPrice1 = backPageLabel1.assertBackPack().getText();
                System.out.println(getPrice1);
                Assert.assertEquals(getPrice1, "$49.99");
                driver.close();
                break;

        }

       /* if (Username == "locked_out_user") {
            login.getUserName().sendKeys(Username);
            login.getPassWord().sendKeys(Password);
            login.loginButton().click();
            LoginPage loginError = new LoginPage(driver);
            loginError.lockOutUser().isDisplayed();
            String errorUser = login.lockOutUser().getText();
            System.out.println(errorUser);
            //wait();
            //Assert.assertEquals(errorUser, " ");

            Assert.assertEquals(errorUser, "Epic sadface: Sorry, this user has been locked out.");
            driver.close();

        }
        if (Username == "problem_user") {
            login.getUserName().sendKeys(Username);
            login.getPassWord().sendKeys(Password);
            login.loginButton().click();
            ProductsPage selectProduct = new ProductsPage(driver);
            selectProduct.clickBackPack().click();
            ProductBackPackPage backPageLabel = new ProductBackPackPage(driver);
            String getPrice = backPageLabel.assertBackPack().getText();
            System.out.println(getPrice);
            Assert.assertEquals(getPrice, "$49.99");
            driver.close();

        } else if (Username != "problem_user" || Username != "locked_out_user") {
            login.getUserName().sendKeys(Username);
            login.getPassWord().sendKeys(Password);
            login.loginButton().click();
            ProductsPage selectProduct = new ProductsPage(driver);
            selectProduct.clickBackPack().click();
            ProductBackPackPage backPageLabel = new ProductBackPackPage(driver);
            String getPrice = backPageLabel.assertBackPack().getText();
            System.out.println(getPrice);
            Assert.assertEquals(getPrice, "$29.99");
            driver.close();;


        }
*/
    }

    @AfterTest
    public void tearDown() {

        driver.quit();
    }
    @DataProvider
    public Object[][] getData() {

        Object[][] data = new Object[4][2];
        //Accepted usernames are:
        //standard_user
        data[0][0] = "standard_user";
        data[0][1] = "secret_sauce";

        //locked_out_user
        data[1][0] = "locked_out_user";
        data[1][1] = "secret_sauce";

        //problem_user
        data[2][0] = "problem_user";
        data[2][1] = "secret_sauce";

        //performance_glitch_user
        data[3][0] = "performance_glitch_user";
        data[3][1] = "secret_sauce";

        return data;


    }
}
