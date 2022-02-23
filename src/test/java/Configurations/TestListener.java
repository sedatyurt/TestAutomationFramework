package Configurations;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import javax.print.attribute.standard.Media;
import java.io.IOException;

public class TestListener implements ITestListener {

    public static ExtentReports extentReports = ExtentManager.createExtentReports();
    public static ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

        if (extentReports != null) {
            extentReports.flush();
        }
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {

        extentTestThreadLocal.set(extentReports.createTest(getTestMethodName(iTestResult)));
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

        try {
            extentTestThreadLocal.get().log(Status.FAIL, "Test step failed", MediaEntityBuilder.createScreenCaptureFromPath(GeneralMethods.takeSnapShot()).build());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

}
