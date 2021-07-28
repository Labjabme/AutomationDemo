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
   // public Properties externalProperties;

    public WebDriver initializeDriver() throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\LR Disemelo\\Documents\\JPMasterclass\\AutomationDemo\\src\\main\\resources\\data.properties");
        //  FileInputStream fis = new FileInputStream("src/main/java/resources/data.properties");

        prop.load(fis);

        String browserName = prop.getProperty("browser");


        switch (browserName) {
            case "chrome":
                //locally on my drive
               // System.setProperty("webdriver.chrome.driver", "C:\\Users\\LR Disemelo\\Desktop\\JavaPrograms\\WebDrivers\\chromedriver\\chromedriver.exe");
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver/chromedriver.exe");
                System.out.println(browserName);
                System.out.println(browserName);
                driver = new ChromeDriver();
                driver.manage().window().maximize();


                break;
            case "firefox":

                System.setProperty("webdriver.firefox.driver", "C:\\Users\\LR Disemelo\\Desktop\\JavaPrograms\\WebDrivers\\geckodriver.exe");
                System.out.println(browserName);
                driver = new FirefoxDriver();
                driver.manage().window().maximize();

                break;
            case "IE":
                System.setProperty("webdriver.edge.driver", "C:\\Users\\LR Disemelo\\Desktop\\JavaPrograms\\WebDrivers\\EdgeDriver\\msedgedriver.exe");
                System.out.println(browserName);
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                break;
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

    public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {

        TakesScreenshot screenGrab = (TakesScreenshot) this.driver;
       File source = screenGrab.getScreenshotAs(OutputType.FILE);
       String destinationFile = System.getProperty("user.dir")+"\\reports\\"+ testCaseName +".png";
        FileUtils.copyFile(source,new File(destinationFile));

        return destinationFile;
    }


  /*  public void getScreenshotPath(String testMethodName, WebDriver driver)


    {

        String screenName= System.currentTimeMillis()+ ".png";

        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try

        {

            FileHandler.copy(src, new File(System.getProperty("C:\\Users\\LR Disemelo\\Documents\\JPMasterclass\\AutomationDemo\\target")+"\\reports\\" +screenName+""));

        }

        catch(IOException e)

        {

            System.out.println(e.getMessage());

        }*/

    }

