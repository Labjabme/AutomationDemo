package demonstration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {

    public WebDriver driver;
    public Properties prop;


    public WebDriver initializeDriver() throws IOException {

       Properties prop = new Properties();


         FileInputStream fis = new FileInputStream("C:\\Users\\rldis\\OneDrive\\Documents\\AutomationDemo\\src\\main\\resources\\data.properties");

        prop.load(fis);

      String browser = prop.getProperty("browser");


        switch (browser) {
            case "chrome":

                System.setProperty("webdriver.chrome.driver","C:/selenium-drivers/chromedriver.exe");
                System.out.println(browser);
                System.out.println(browser);
                driver = new ChromeDriver();
                driver.manage().window().maximize();


                break;
            case "firefox":

                System.setProperty("webdriver.gecko.driver","C:/selenium-drivers/geckodriver.exe");
                System.out.println(browser);
                driver = new FirefoxDriver();
                driver.manage().window().maximize();

                break;
            case "IE":
                System.setProperty("webdriver.edge.driver","C:/selenium-drivers/msedgedriver.exe");
                System.out.println(browser);
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                break;
        }

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver;
    }




    public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {

        TakesScreenshot screenGrab = (TakesScreenshot) this.driver;
       File source = screenGrab.getScreenshotAs(OutputType.FILE);
       String destinationFile = System.getProperty("user.dir")+"\\reports\\"+ testCaseName +".png";
        FileUtils.copyFile(source,new File(destinationFile));

        return destinationFile;
    }


    }

