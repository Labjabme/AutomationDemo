package demonstration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;

import java.io.IOException;

public class ProductsPages extends base {

    public WebDriver driver;


    /*    @BeforeTest
    public void initialise() throws IOException {

        driver = initializeDriver();
        driver.get("https://www.saucedemo.com/");
        // driver.get(prop.getProperty("url"));
    }*/
    @Test(dataProvider = "getData")

    public void selectBackPack(String Username, String Password) throws IOException {

        driver = initializeDriver();
        driver.get("https://www.saucedemo.com/");
        LoginPage login = new LoginPage(driver);
        login.getUserName().sendKeys(Username);

        switch (Username) {

            case "locked_out_user":
                login.getPassWord().sendKeys(Password);
                login.loginButton().click();
                LoginPage loginError = new LoginPage(driver);
                loginError.lockOutUser().isDisplayed();
                String errorUser = loginError.lockOutUser().getText();
                System.out.println(errorUser);
                Assert.assertEquals(errorUser, "Epic sadface: Sorry, this user has been locked out.");
                driver.close();
                break;

            case "standard_user":
            case "performance_glitch_user":

            case "problem_user":

                login.getPassWord().sendKeys(Password);
                login.loginButton().click();
                ProductsPage selectProduct = new ProductsPage(driver);
                selectProduct.clickBackPack().click();
                driver.close();

                break;

        }
    }


    @Test(dataProvider = "getData")
    public void selectBikeLight(String Username, String Password) throws IOException {
        driver = initializeDriver();
        driver.get("https://www.saucedemo.com/");
        LoginPage login = new LoginPage(driver);
        login.getUserName().sendKeys(Username);

        switch (Username) {

            case "locked_out_user":
                login.getPassWord().sendKeys(Password);
                login.loginButton().click();
                LoginPage loginError = new LoginPage(driver);
                loginError.lockOutUser().isDisplayed();
                String errorUser = loginError.lockOutUser().getText();
                System.out.println(errorUser);
                Assert.assertEquals(errorUser, "Epic sadface: Sorry, this user has been locked out.");
                driver.close();
                break;

            case "standard_user":
            case "performance_glitch_user":
            case "problem_user":

                login.getPassWord().sendKeys(Password);
                login.loginButton().click();
                ProductsPage selectProduct = new ProductsPage(driver);
                selectProduct.clickBikeLight().click();
                driver.close();
                break;

        }

    }

    @Test(dataProvider = "getData")

    public void selectBoltTshirt(String Username, String Password) throws IOException {
        driver = initializeDriver();
        driver.get("https://www.saucedemo.com/");
        LoginPage login = new LoginPage(driver);
        login.getUserName().sendKeys(Username);

        switch (Username) {

            case "locked_out_user":
                login.getPassWord().sendKeys(Password);
                login.loginButton().click();
                LoginPage loginError = new LoginPage(driver);
                loginError.lockOutUser().isDisplayed();
                String errorUser = loginError.lockOutUser().getText();
                System.out.println(errorUser);
                Assert.assertEquals(errorUser, "Epic sadface: Sorry, this user has been locked out.");
                driver.close();
                break;

            case "standard_user":
            case "performance_glitch_user":
            case "problem_user":

                login.getPassWord().sendKeys(Password);
                login.loginButton().click();
                ProductsPage selectProduct = new ProductsPage(driver);
                selectProduct.clickBoltTshirt().click();
                driver.close();
                break;

        }

    }

    @Test(dataProvider = "getData")

    public void selectFleeceJacket(String Username, String Password) throws IOException {
        driver = initializeDriver();
        driver.get("https://www.saucedemo.com/");
        LoginPage login = new LoginPage(driver);
        login.getUserName().sendKeys(Username);

        switch (Username) {

            case "locked_out_user":
                login.getPassWord().sendKeys(Password);
                login.loginButton().click();
                LoginPage loginError = new LoginPage(driver);
                loginError.lockOutUser().isDisplayed();
                String errorUser = loginError.lockOutUser().getText();
                System.out.println(errorUser);
                Assert.assertEquals(errorUser, "Epic sadface: Sorry, this user has been locked out.");
                driver.close();
                break;

            case "standard_user":
            case "performance_glitch_user":
            case "problem_user":

                login.getPassWord().sendKeys(Password);
                login.loginButton().click();
                ProductsPage selectProduct = new ProductsPage(driver);
                selectProduct.clickFleeceJacket().click();
                driver.close();
                break;

        }

    }

    @Test(dataProvider = "getData")

    public void selectOnsie(String Username, String Password) throws IOException {
        driver = initializeDriver();
        driver.get("https://www.saucedemo.com/");
        LoginPage login = new LoginPage(driver);
        login.getUserName().sendKeys(Username);
        switch (Username) {

            case "locked_out_user":
                login.getPassWord().sendKeys(Password);
                login.loginButton().click();
                LoginPage loginError = new LoginPage(driver);
                loginError.lockOutUser().isDisplayed();
                String errorUser = loginError.lockOutUser().getText();
                System.out.println(errorUser);
                Assert.assertEquals(errorUser, "Epic sadface: Sorry, this user has been locked out.");
                driver.close();
                break;

            case "standard_user":
            case "performance_glitch_user":
            case "problem_user":

                login.getPassWord().sendKeys(Password);
                login.loginButton().click();
                ProductsPage selectProduct = new ProductsPage(driver);
                selectProduct.clickOnsie().click();
                driver.close();
                break;

        }


    }

    @Test(dataProvider = "getData")

    public void selectTestAllTheThings(String Username, String Password) throws IOException {
        driver = initializeDriver();
        //  driver.get(prop.getProperty("URL"));;
        driver.get("https://www.saucedemo.com/");
        LoginPage login = new LoginPage(driver);
        login.getUserName().sendKeys(Username);
        switch (Username) {

            case "locked_out_user":
                login.getPassWord().sendKeys(Password);
                login.loginButton().click();
                LoginPage loginError = new LoginPage(driver);
                loginError.lockOutUser().isDisplayed();
                String errorUser = loginError.lockOutUser().getText();
                System.out.println(errorUser);
                Assert.assertEquals(errorUser, "Epic sadface: Sorry, this user has been locked out.");
                driver.close();
                break;

            case "standard_user":
            case "performance_glitch_user":
            case "problem_user":

                login.getPassWord().sendKeys(Password);
                login.loginButton().click();
                ProductsPage selectProduct = new ProductsPage(driver);
                selectProduct.clickTestAll().click();
                driver.close();
                break;

        }


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