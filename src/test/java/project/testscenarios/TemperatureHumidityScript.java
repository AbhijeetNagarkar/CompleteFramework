package project.testscenarios;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import project.mediator.ObjectRepository;
import project.utility.WebPageObjectCreation;

public class TemperatureHumidityScript {

WebPageObjectCreation repo;
	
	public static Logger log = Logger.getLogger(TemperatureHumidityScript.class);
	
	@BeforeClass
	public void Fetct_Repository_Object() throws InterruptedException, IOException
	{
		repo = ObjectRepository.GetInstance();
	}
	
	@Test(priority = 50,groups = {"Temperature and Humidity Report"})
	public void NavigatingTemperatureandHumidityReportPage() throws InterruptedException 
	{
				
		repo.dashboardPageObject().clickOnReports();
		
		repo.dashboardPageObject().clickOnReportsSubMenu();
		
		repo.ReportsPageObject().ClickOnTemperatureHumidity();
		
	}
	@Test(priority = 51,groups = {"Temperature and Humidity Report"},dependsOnMethods = "NavigatingTemperatureandHumidityReportPage" )
	public void SearchandVerification() throws InterruptedException 
	{
		Assert.assertTrue(repo.TemperatureHumidityPageObject().SearchandVerifyRecords(),"Search functionality not working as expected");
	}
	@Test(priority = 52,groups = {"Temperature and Humidity Report"},dependsOnMethods = "NavigatingTemperatureandHumidityReportPage" )
	public void FilterandVerification() throws InterruptedException 
	{
		Assert.assertTrue(repo.TemperatureHumidityPageObject().filterandverification(),"Records not showing as per filter criteria");
	}
	
	@Test(priority = 52,groups = {"Temperature and Humidity Report"},dependsOnMethods = "NavigatingTemperatureandHumidityReportPage" )
	public void DownloadFunctionality() throws InterruptedException 
	{
		Assert.assertTrue(repo.TemperatureHumidityPageObject().VerifyDownload(),"Download functionality Not working");
	}

}
