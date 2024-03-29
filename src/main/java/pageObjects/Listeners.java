package pageObjects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import demonstration.ExtentReport;
import demonstration.base;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;


public class Listeners extends base implements ITestListener {


    ExtentTest test;
    ExtentReports extent=ExtentReport.getReportObject();
    ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
        test= extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);

    }

    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
        extentTest.get().log(Status.PASS, "Test Passed");
    }

    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub
        //Screenshot
        extentTest.get().fail(result.getThrowable());
        WebDriver driver =null;
        String testCaseName =result.getMethod().getMethodName();

        try {
            driver =(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch(Exception e)
        {

        }
        try {
            extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testCaseName,driver), result.getMethod().getMethodName());

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub

    }

    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub

    }

    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub
        extent.flush();
    }

}
