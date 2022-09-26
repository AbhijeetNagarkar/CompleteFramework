package project.testscenarios;

import project.utility.*;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import project.utility.WebPageObjectCreation;

public class DashboardScript extends ConfigurationSetup{
	
	WebPageObjectCreation repo;
	
	public static Logger log = Logger.getLogger(DashboardScript.class);
	
	@Test(priority = 4)
	public void navigatingTrucksPage() throws InterruptedException 
	{
		
		repo=ObjectRepository.GetInstance();
		
		repo.dashboardPageObject().clickOnVehicle();
				
		repo.dashboardPageObject().clickOnTrucks();
		
		Thread.sleep(5000);
		
		
	
	
		/*
		repo.dashboardPageObject().clickOnVehicle();
		
		repo.dashboardPageObject().clickOnDeletedTrucks();
		
		Thread.sleep(5000);
		
		repo.dashboardPageObject().clickOnVehicle();
		
		repo.dashboardPageObject().clickOnTrailers();
		
		Thread.sleep(5000);
		
		repo.dashboardPageObject().clickOnVehicle();
		
		repo.dashboardPageObject().clickOnDeletedTrailers();
		
		Thread.sleep(10000);
		
		*/
	}
	
}
