package demonstration;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport extends base {

    static ExtentReports extent;

    public static  ExtentReports getReportObject()
    {

        String path =System.getProperty("user.dir")+"\\reports\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Sauce Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        extent =new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Test Automation Engineer", "Ramono Labius Disemelo");
        return extent;

    }
}
