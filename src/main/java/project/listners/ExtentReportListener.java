package project.listners;


import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import project.utility.EmailSendUtils;
import project.utility.ExcelUtility;
import project.mediator.*;

import static project.constants.FilePathDeclaration.*;

public class ExtentReportListener implements ITestListener, ISuiteListener {

	
	public static ExtentTest logger;
	public static com.aventstack.extentreports.ExtentReports report;
	public static ExtentHtmlReporter htmlreport;
	private static int count_totalTCs;
	private static int count_passedTCs;
	private static int count_skippedTCs;
	private static int count_failedTCs;
   
	@Override
	public  void onStart(ISuite suite) 
	{
		htmlreport = new ExtentHtmlReporter(ExtendReportPath);
		//Create an html report for the suite that is executed
		report = new com.aventstack.extentreports.ExtentReports();
		report.attachReporter(htmlreport);
		
	
	}
	
	@Override
	public void onTestStart(ITestResult result) 
	{
		count_totalTCs = count_totalTCs + 1;
		String category[]=result.getMethod().getGroups();
	
		logger = report.createTest(result.getMethod().getMethodName()).assignCategory(category[0]);
		logger.info("Executing test: " + result.getMethod().getMethodName());
		
	
		}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		count_passedTCs = count_passedTCs + 1;
		
		logger.pass("Finished executing test");
		
	}


	@Override
	public void onTestFailure(ITestResult result) 
	{
		count_failedTCs = count_failedTCs + 1;
		String fileName = String.format("Screenshot-%s.jpg", Calendar.getInstance().getTimeInMillis());
		WebDriver driver = (WebDriver)result.getTestContext().getAttribute("WebDriver"); //use string from setAttribute from BasePage
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File(System.getProperty("user.dir")+File.separator+"Screenshots"+File.separator+ fileName);
		try {
			FileUtils.copyFile(srcFile, destFile);
			System.out.println("Screenshot taken, saved in screenshots folder");
		} catch(IOException e) {
			System.out.println("Failed to take screenshot");
		}
		logger.fail(result.getThrowable().getMessage());
		String str=System.getProperty("user.dir")+File.separator+"Screenshots"+File.separator+ fileName;
		try {
			logger.addScreenCaptureFromPath(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Driver.Refresh();
		
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		count_skippedTCs = count_skippedTCs + 1;
		logger.log(Status.SKIP, "Test skipped");
	}
	
	@Override
	public void onFinish(ISuite suite) 
	{
		report.flush();
		
		logger.info("End suite testing " + suite.getName());
		
	    EmailSendUtils.sendEmail(count_totalTCs, count_passedTCs, count_failedTCs, count_skippedTCs);
	}

}