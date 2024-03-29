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
import static project.constants.ConstantDeclaration.*;

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
		htmlreport.config().setDocumentTitle(suite.getName());
		htmlreport.config().setReportName(suite.getName());
	}
	
	@Override
	public void onTestStart(ITestResult result) 
	{
		count_totalTCs = count_totalTCs + 1;
		String category[]=result.getMethod().getGroups();
	
		if(category.length==0)
		{
			logger = report.createTest(result.getMethod().getMethodName()).assignCategory("Others");

		}
		else
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
		
		WebDriver driver = (WebDriver)result.getTestContext().getAttribute("Driver"); //use string from setAttribute from BasePage
		if(driver!=null)
		{
			String fileName = String.format("Screenshot-%s.jpg", Calendar.getInstance().getTimeInMillis());
			
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File destFile = new File(System.getProperty("user.dir")+File.separator+"Screenshots"+File.separator+ fileName);
			try {
				FileUtils.copyFile(srcFile, destFile);
				System.out.println("Screenshot taken, saved in screenshots folder");
				System.out.println(result.getThrowable().getMessage());
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
		}
	//	DriverRepository.Refresh();
		
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