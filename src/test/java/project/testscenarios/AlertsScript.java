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
	
	@Test(priority = 50,groups = {"Alerts"})
	public void NavigatingAlertsPage() throws InterruptedException 
	{
				
		repo.dashboardPageObject().clickOnAlerts();
		
		repo.dashboardPageObject().clickOnAlertsSubMenu();;
		
	}
	@Test(priority = 51,groups = {"Alerts"},dependsOnMethods = "NavigatingAlertsPage" )
	public void NumberOfAlertsandVerification() throws InterruptedException 
	{
		repo.AlertPageObject().verifyAlertRecords();
		
		repo.AlertPageObject().VerifyDownloadAlerts();
	}

}
