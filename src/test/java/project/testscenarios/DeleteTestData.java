package project.testscenarios;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import project.mediator.ObjectRepository;
import project.utility.WebPageObjectCreation;

public class DeleteTestData {

	WebPageObjectCreation repo;
	
	HashMap<String,String> devicemap;
	
	public static Logger log = Logger.getLogger(DashCameraScript.class);
	
	@Test(priority = 52,groups = {"Clean UP"})
	public void DeletingCreatedTestdata() throws InterruptedException 
	{
		repo=ObjectRepository.GetInstance();
		
		repo.dashboardPageObject().clickOnVehicle();
		
		repo.dashboardPageObject().clickOnTrucks();
				
		repo.truckPageObject().searchTruckonDashboard();

		repo.truckPageObject().DeleteTruck();

		Thread.sleep(5000);

		repo.dashboardPageObject().clickOnVehicle();
				
		repo.dashboardPageObject().clickOnTrailers();
				
		repo.trailerPageObject().changeFocus();
				
		repo.trailerPageObject().SearchTrailer();

		repo.trailerPageObject().DeleteTrailer();
	}
}
