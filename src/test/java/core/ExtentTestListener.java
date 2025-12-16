package core;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.testng.*;
import utils.ScreenshotUtil;

public class ExtentTestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReportManager.createTest(
                result.getMethod().getMethodName()
        );
        ExtentReportManager.getTest()
                .info("Test started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReportManager.logResult(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {

        ExtentReportManager.logResult(result);

        String screenshotPath =
                ScreenshotUtil.takeScreenshot(
                        BaseTest.driver,
                        result.getMethod().getMethodName()
                );

        if (screenshotPath != null) {
            try {
                ExtentReportManager.getTest().fail(
                        MediaEntityBuilder
                                .createScreenCaptureFromPath(screenshotPath)
                                .build()
                );
            } catch (Exception e) {
                ExtentReportManager.getTest()
                        .warning("Screenshot could not be attached");
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReportManager.logResult(result);
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReportManager.flush();
    }
}
