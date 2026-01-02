package listener;

import Utilities.FileUtility;
import Utilities.PropertiesUtility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class TestListener implements ITestListener
{
        ExtentSparkReporter htmlReportCreator;
        ExtentReports  reportManager;
    private static ThreadLocal<ExtentTest> testLogger = new ThreadLocal<>();

    String reportPath=System.getProperty("user.dir")+ "\\reports\\TestsResults_Report.html";

        File target = new File("target");

        @Override
        public  void onStart (ITestContext context)
        {
            htmlReportCreator=new ExtentSparkReporter("reports/TestsResults_Report.html");//Creating the html file that will display the report
            reportManager=new ExtentReports(); // initialize the report manager
            reportManager.attachReporter(htmlReportCreator); //integrate them so that the report manager can generate html file
            PropertiesUtility.propertiesLoading(); // loading all customized properties to system properties
        }

        @Override
        public void onTestStart (ITestResult testResult )
        {
            testLogger.set(
                    reportManager.createTest(testResult.getMethod().getMethodName())
            );

        }

        @Override
        public void onTestSuccess(ITestResult testResult)
        {
            testLogger.get().pass("Test Passed Successfully");
        }

        @Override
        public void onTestFailure(ITestResult testResult)
        {
            testLogger.get().fail(testResult.getThrowable());
        }

        @Override
        public void onFinish(ITestContext context)
        {
            reportManager.flush(); //all data stored in the reportManager are written as an HTML file then be generated
            try {
                FileUtility.openReport(reportPath);
            } catch (InterruptedException | IOException e) {
                throw new RuntimeException(e);
            }
            FileUtility.emptyDirectory(target); // removing the generated target files after executions to only prevent pushing them in commits
        }
}
