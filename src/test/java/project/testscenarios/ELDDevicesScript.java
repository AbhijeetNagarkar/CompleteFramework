package project.testscenarios;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import project.mediator.ObjectRepository;
import project.utility.WebPageObjectCreation;

public class ELDDevicesScript {


	WebPageObjectCreation repo;
		
	HashMap<String,String> devicemap;
	
	public static Logger log = Logger.getLogger(DashCameraScript.class);
	
	@BeforeClass
	public void Fetct_Repository_Object() throws InterruptedException, IOException
	{
		repo = ObjectRepository.GetInstance();
	}
	
	@Test(priority = 1,groups = {"ELD Devices"})
	public void NavigatingELDDevicesPage() throws InterruptedException 
	{
		repo.dashboardPageObject().clickOnDevices();
				
		repo.dashboardPageObject().clickOnELDDevices();
		
		Thread.sleep(7000);
		
	}
	@Test(priority = 2, dependsOnMethods = "NavigatingELDDevicesPage",groups = {"ELD Devices"})
	public void ELDCountandRecord() throws InterruptedException 
	{
		Assert.assertTrue(repo.eldDevicesPageObject().verifyELDDevicesCount(),"Incorrect count and records showing on ELD Devices Page");
		
	}
}
