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

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import com.relevantcodes.extentreports.LogStatus;
import project.utility.EmailSendUtils;
import project.utility.ExcelUtility;
import project.mediator.*;

import static project.constants.FilePathDeclaration.*;

public class ExtentReportListener implements ITestListener, ISuiteListener {

	
	private static ExtentTest logger;
	private static ExtentReports report;
	private static int count_totalTCs;
	private static int count_passedTCs;
	private static int count_skippedTCs;
	private static int count_failedTCs;
   
	@Override
	public  void onStart(ISuite suite) 
	{
		//Create an html report for the suite that is executed
		report = new ExtentReports(ExtendReportPath);
		//logger = report.startTest(suite.getName());
		
	}
	
	@Override
	public void onTestStart(ITestResult result) 
	{
		count_totalTCs = count_totalTCs + 1;
		logger = report.startTest(result.getMethod().getMethodName());
		logger.log(LogStatus.INFO, "Executing test: " + result.getMethod().getMethodName());
		logger.log(LogStatus.INFO, "Inprocess");
		
		}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		count_passedTCs = count_passedTCs + 1;
		
		logger.log(LogStatus.PASS, "Finished executing test");
		
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
		logger.log(LogStatus.FAIL,result.getThrowable().getMessage());
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		count_skippedTCs = count_skippedTCs + 1;
		logger.log(LogStatus.SKIP, "Test skipped");
	}
	
	@Override
	public void onFinish(ISuite suite) 
	{
		report.flush();
		
		logger.log(LogStatus.INFO,"End suite testing " + suite.getName());
		
		System.out.println(PageLoadTime.GetMap().toString());
		
		ExcelUtility ex = new ExcelUtility();
		
		try {
			
			ex.addloadingtimedata(PageLoadTime.GetMap());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	    EmailSendUtils.sendEmail(count_totalTCs, count_passedTCs, count_failedTCs, count_skippedTCs);
	}

}