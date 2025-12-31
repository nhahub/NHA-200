package listener;

import Utilities.PropertiesUtility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener
{
        ExtentSparkReporter htmlReportCreator;
        ExtentReports  reportManager;
        ExtentTest      testLogger;

        @Override
        public  void onStart (ITestContext context)
        {
            htmlReportCreator=new ExtentSparkReporter("target/Reports/TestsResults_Report.html");//Creating the html file that will display the report
            reportManager=new ExtentReports(); // initialize the report manager
            reportManager.attachReporter(htmlReportCreator); //integrate them so that the report manager can generate html file
            PropertiesUtility.propertiesLoading(); // loading all customized properties to system properties
        }

        @Override
        public void onTestStart (ITestResult testResult )
        {
            testLogger=reportManager.createTest(testResult.getMethod().getMethodName()); //when a test start a new page in the report is generated
        }

        @Override
        public void onTestSuccess(ITestResult testResult)
        {
            testLogger.pass("Test Passed Successfully");
        }

        @Override
        public void onTestFailure(ITestResult testResult)
        {
            testLogger.fail(testResult.getThrowable());
        }

        @Override
        public void onFinish(ITestContext context)
        {
            reportManager.flush(); //all data stored in the reportManager are written as an HTML file then be generated
        }
}
