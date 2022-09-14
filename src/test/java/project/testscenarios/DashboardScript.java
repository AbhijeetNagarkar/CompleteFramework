package project.testscenarios;

import project.utility.*;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import project.utility.WebPageObjectCreation;

public class DashboardScript extends ConfigurationSetup{
	
	WebPageObjectCreation repo;
	
	public static Logger log = Logger.getLogger(DashboardScript.class);
	
	@Test(priority = 4)
	public void navigatingTrucksPage() 
	{
		
		repo=ObjectRepository.GetInstance();
			
		repo.dashboardPageObject().clickOnVehicle();
				
		repo.dashboardPageObject().clickOnTrucks();
	
	}
	
}
