package project.testscenarios;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import project.mediator.ObjectRepository;
import project.utility.WebPageObjectCreation;

public class DashCameraScript {
	
	WebPageObjectCreation repo;
		
	HashMap<String,String> devicemap;
	
	public static Logger log = Logger.getLogger(DashCameraScript.class);
	
	@Test(priority = 34,groups = {"Dash Cameras"})
	public void NavigatingDashCamerasPage() throws InterruptedException 
	{
		repo=ObjectRepository.GetInstance();
		
		repo.dashboardPageObject().clickOnDevices();
		
		repo.dashboardPageObject().clickOnTrackingDevices();
		
		repo.trackingDevicesPageObject().getDashCamCount();
		
		
		repo.dashboardPageObject().clickOnDevices();
				
		repo.dashboardPageObject().clickOnDashCameras();
		
		Thread.sleep(7000);
		
	}
	@Test(priority = 35, dependsOnMethods = "NavigatingDashCamerasPage",groups = {"Dash Cameras"})
	public void DashCameraCount() throws InterruptedException 
	{
		Assert.assertTrue(repo.dashCameraPageObject().verifyDashCameraCount(),"Incorrect Dash Camera count showing on Dash Camera Page");
		
	}
	@Test(priority = 36, dependsOnMethods = "NavigatingDashCamerasPage",groups = {"Dash Cameras"})
	public void SearchDashCamera() throws InterruptedException 
	{
		Assert.assertTrue(repo.dashCameraPageObject().Search(),"Search Result not as per Search Criteria");		
	}
	@Test(priority = 37, dependsOnMethods = "NavigatingDashCamerasPage",groups = {"Dash Cameras"})
	public void DashCameraData() throws InterruptedException 
	{
		repo.dashCameraPageObject().ClickonDashcam();
		
		Assert.assertTrue(repo.dashCameraPageObject().VerifyDashCamData(),"Data is not loading");		
	}
}
