package core;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestResult;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentReportManager {

    private static ExtentReports extent;
    private static ExtentTest test;

    private static final String REPORT_PATH =
            "reports/mobile-automation-report.html";

    // ================= INIT =================

    public static void initReport() {

        if (extent != null) return;

        ExtentSparkReporter spark =
                new ExtentSparkReporter(REPORT_PATH);

        spark.config().setDocumentTitle("Mobile Automation Test Report");
        spark.config().setReportName("Android Appium Execution Summary");
        spark.config().setTheme(Theme.DARK);
        spark.config().setEncoding("UTF-8");
        spark.config().setTimeStampFormat(
                "dd MMM yyyy HH:mm:ss"
        );

        extent = new ExtentReports();
        extent.attachReporter(spark);

        extent.setSystemInfo("Tester", "Farichin");
        extent.setSystemInfo("Platform", "Android");
        extent.setSystemInfo("Automation Tool", "Appium");
        extent.setSystemInfo("Framework", "TestNG");
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        extent.setSystemInfo(
                "Execution Time",
                LocalDateTime.now().format(
                        DateTimeFormatter.ofPattern(
                                "dd MMM yyyy HH:mm:ss"
                        )
                )
        );
    }

    // ================= TEST HANDLING =================

    public static void createTest(String testName) {

        test = extent
                .createTest(testName)
                .assignAuthor("Farichin")
                .assignDevice("Android Emulator")
                .assignCategory(detectCategory(testName));
    }

    public static ExtentTest getTest() {
        return test;
    }

    // ================= RESULT LOGGING =================

    public static void logResult(ITestResult result) {
        if (test == null) return;

        if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test Passed");
            return;
        }

        if (result.getStatus() == ITestResult.FAILURE) {

            Throwable throwable = result.getThrowable();
            test.fail("Test Failed");

            if (throwable instanceof AssertionError) {

                String message = throwable.getMessage();

                String expected = extractExpected(message);
                String actual = extractActual(message);

                test.fail("Assertion Error");
                test.fail(
                        MarkupHelper.createTable(new String[][]{
                                {"Expected", expected},
                                {"Actual", actual}
                        })
                );

            } else {
                test.fail(throwable);
            }

            return;
        }

        test.skip("Test Skipped");
    }

    // ================= ASSERT PARSER =================

    private static String extractExpected(String message) {
        try {
            return message.split("expected \\[")[1].split("]")[0];
        } catch (Exception e) {
            return "N/A";
        }
    }

    private static String extractActual(String message) {
        try {
            return message.split("but found \\[")[1].split("]")[0];
        } catch (Exception e) {
            return "N/A";
        }
    }

    // ================= CATEGORY =================

    private static String detectCategory(String testName) {

        if (testName.toLowerCase().contains("login"))
            return "Smoke";

        if (testName.toLowerCase().contains("checkout"))
            return "Regression";

        return "General";
    }

    // ================= FLUSH =================

    public static void flush() {
        if (extent != null) {
            extent.flush();
        }
    }
}

