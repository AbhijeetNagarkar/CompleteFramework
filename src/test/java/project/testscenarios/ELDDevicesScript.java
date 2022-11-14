package project.testscenarios;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import project.mediator.ObjectRepository;
import project.utility.WebPageObjectCreation;

public class ELDDevicesScript {


	WebPageObjectCreation repo;
		
	HashMap<String,String> devicemap;
	
	public static Logger log = Logger.getLogger(DashCameraScript.class);
	
	@Test(priority = 32,groups = {"ELD Devices"})
	public void NavigatingELDDevicesPage() throws InterruptedException 
	{
		repo=ObjectRepository.GetInstance();
		
		repo.dashboardPageObject().clickOnDevices();
				
		repo.dashboardPageObject().clickOnELDDevices();
		
		Thread.sleep(7000);
		
	}
	@Test(priority = 33, dependsOnMethods = "NavigatingELDDevicesPage",groups = {"ELD Devices"})
	public void ELDCountandRecord() throws InterruptedException 
	{
		
		Assert.assertTrue(repo.eldDevicesPageObject().verifyELDDevicesCount(),"Incorrect count and records showing on ELD Devices Page");
		
	}
}
