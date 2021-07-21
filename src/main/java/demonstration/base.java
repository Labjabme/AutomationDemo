package demonstration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {

    public WebDriver driver;
    public Properties prop;
   // public Properties externalProperties;

    public WebDriver initializeDriver() throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\LR Disemelo\\Documents\\JPMasterclass\\AutomationDemo\\src\\main\\resources\\data.properties");
        //  FileInputStream fis = new FileInputStream("src/main/java/resources/data.properties");

        prop.load(fis);

        String browserName = prop.getProperty("browser");


        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\LR Disemelo\\Desktop\\JavaPrograms\\WebDrivers\\chromedriver\\chromedriver.exe");
            System.out.println(browserName);
            driver = new ChromeDriver();
            driver.manage().window().maximize();

        } else if (browserName.equals("firefox")) {

            System.setProperty("webdriver.firefox.driver", "C:\\Users\\LR Disemelo\\Desktop\\JavaPrograms\\WebDrivers\\geckodriver.exe");
            System.out.println(browserName);
            driver = new FirefoxDriver();
            driver.manage().window().maximize();

        } else if (browserName.equals("IE")) {
            System.setProperty("webdriver.edge.driver", "C:\\Users\\LR Disemelo\\Desktop\\JavaPrograms\\WebDrivers\\EdgeDriver\\msedgedriver.exe");
            System.out.println(browserName);
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        }

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver;
    }



    /*public String getTheURL() throws FileNotFoundException, IOException {

        String url = "https://www.saucedemo.com/";

        externalProperties = new Properties();

        externalProperties.load(new FileInputStream(

                "C:\\Users\\LR Disemelo\\Documents\\JPMasterclass\\AutomationDemo\\src\\main\\resources\\data.properties"));

        url = externalProperties.getProperty(url);

        return url;

    }*/
}
