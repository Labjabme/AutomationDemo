package demonstration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;
import pageObjects.InvestecHome;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;
import static org.testng.AssertJUnit.assertEquals;

public class MultiBrowser extends base {

    public WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();



    @Parameters("browser")


    @BeforeClass

    // Passing Browser parameter from TestNG xml

    public void beforeTest(@Optional("chrome") String browser) {


        // If the browser is Firefox, then do this

        if (browser.equalsIgnoreCase("firefox")) {

//Initializing the firefox driver (Gecko)
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\rldis\\OneDrive\\Documents\\InvestecDemo\\src\\main\\resources\\geckodriver.exe");
            System.out.println(browser);
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("disable-notifications");
            options.setHeadless(true);
            driver = new FirefoxDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
            if (browser.equalsIgnoreCase("Edge")) {

//Initializing the edge driver (Edge)
                System.setProperty("webdriver.edge.driver","C:\\Users\\rldis\\OneDrive\\Documents\\InvestecDemo\\src\\main\\resources\\msedgedriver.exe");
                System.out.println(browser);
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setCapability("disable-notifications",true);
                edgeOptions.setCapability("headless",true);
                driver = new EdgeDriver(edgeOptions);
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            } else if (browser.equalsIgnoreCase("chrome")) {

                //Initialize the chrome driver
                System.setProperty("webdriver.chrome.driver","C:\\Users\\rldis\\OneDrive\\Documents\\InvestecDemo\\src\\main\\resources\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("disable-notifications");
                options.addArguments("--headless");
                driver = new ChromeDriver(options);
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);





            }

            // Enter the website address in the browser

            driver.get(" https://www.investec.com/");

        }

        // Once Before method is completed, Test method will start
        @Test(dataProvider = "getData")
        public void navigateToCashInvestment (String name, String surName) throws InterruptedException {


            InvestecHome investecHome = new InvestecHome(driver);
            investecHome.selectFocus().click();
            investecHome.selectMoney().click();
            investecHome.selectUnderstanding().click();
           //scrolling too element this gave me a tough time best option for now
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(1301,887)");
            investecHome.signUp().click();
            investecHome.name().click();
            investecHome.name().sendKeys(name);
            investecHome.surname().click();

            investecHome.surname().sendKeys(surName);
            investecHome.email().click();
            investecHome.email().sendKeys( "test@investec.co.za");
            investecHome.mySelf().click();
            investecHome.intermediariesBox().click();
            investecHome.myBusiness().click();
            investecHome.submitButton().click();
            Thread.sleep(2200);
            try {

                assertEquals(investecHome.thankYouMessage().getText(), "Thank you");

            } catch (Error e) {
                verificationErrors.append(e.toString());
            }


        }

        @AfterClass public void afterTest () {

            driver.quit();
            String verificationErrorString = verificationErrors.toString();
            if (!"".equals(verificationErrorString)) {
                fail(verificationErrorString);
            }
        }

    @DataProvider
    public Object[][] getData() {

        Object[][] data = new Object[4][2];

        data[0][0] = "Labius ";
        data[0][1] = "Disemelo";


        data[1][0] = "Ramono";
        data[1][1] = "Disemelo";


        data[2][0] = "Kelebogile";
        data[2][1] = "Disemelo";


        data[3][0] = "Tshiamo";
        data[3][1] = "Disemelo";


        data[3][0] = "Omphile";
        data[3][1] = "Disemelo";

        return data;
    }

    }

