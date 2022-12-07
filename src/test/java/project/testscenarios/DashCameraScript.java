package project.testscenarios;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import project.mediator.ObjectRepository;
import project.utility.WebPageObjectCreation;

public class DashCameraScript {
	
	WebPageObjectCreation repo;
		
	HashMap<String,String> devicemap;
	
	public static Logger log = Logger.getLogger(DashCameraScript.class);
	
	@BeforeClass
	public void Fetct_Repository_Object() throws InterruptedException, IOException
	{
		repo = ObjectRepository.GetInstance();
	}
	
	@Test(priority = 1,groups = {"Dash Cameras"})
	public void NavigatingDashCamerasPage() throws InterruptedException 
	{
		repo.dashboardPageObject().clickOnDevices();
		
		repo.dashboardPageObject().clickOnTrackingDevices();
		
		repo.trackingDevicesPageObject().getDashCamCount();
		
		
		repo.dashboardPageObject().clickOnDevices();
				
		repo.dashboardPageObject().clickOnDashCameras();
		
		Thread.sleep(7000);
		
	}
	@Test(priority = 2, dependsOnMethods = "NavigatingDashCamerasPage",groups = {"Dash Cameras"})
	public void DashCameraCount() throws InterruptedException 
	{
		Assert.assertTrue(repo.dashCameraPageObject().verifyDashCameraCount(),"Incorrect Dash Camera count showing on Dash Camera Page");
		
	}
	@Test(priority = 3, dependsOnMethods = "NavigatingDashCamerasPage",groups = {"Dash Cameras"})
	public void SearchDashCamera() throws InterruptedException 
	{
		Assert.assertTrue(repo.dashCameraPageObject().Search(),"Search Result not as per Search Criteria");		
	}
	@Test(priority = 4, dependsOnMethods = "NavigatingDashCamerasPage",groups = {"Dash Cameras"})
	public void DashCameraData() throws InterruptedException 
	{
		repo.dashCameraPageObject().ClickonDashcam();
		
		Assert.assertTrue(repo.dashCameraPageObject().VerifyDashCamData(),"Data is not loading");		
	}
}
