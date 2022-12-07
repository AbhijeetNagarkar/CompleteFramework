package project.testscenarios;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import project.mediator.ObjectRepository;
import project.utility.WebPageObjectCreation;

public class AlertsScript {

	WebPageObjectCreation repo;
	
	public static Logger log = Logger.getLogger(AlertsScript.class);
	
	@BeforeClass
	public void Fetct_Repository_Object() throws InterruptedException, IOException
	{
		repo = ObjectRepository.GetInstance();
	}
	
	@Test(priority = 1,groups = {"Alerts"})
	public void NavigatingAlertsPage() throws InterruptedException 
	{
				
		repo.dashboardPageObject().clickOnAlerts();
		
		repo.dashboardPageObject().clickOnAlertsSubMenu();;
		
	}
	@Test(priority = 2,groups = {"Alerts"},dependsOnMethods = "NavigatingAlertsPage" )
	public void AlertCountsandVerification() throws InterruptedException 
	{
		repo.AlertPageObject().verifyAlertRecords();
		
	}
	@Test(priority = 3,groups = {"Alerts"},dependsOnMethods = "NavigatingAlertsPage" )
	public void DownloadAlerts() throws InterruptedException 
	{
		repo.AlertPageObject().VerifyDownloadAlerts();
	}


}
