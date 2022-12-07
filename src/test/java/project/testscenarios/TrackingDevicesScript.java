package project.testscenarios;

import java.io.IOException;
import java.util.HashMap;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import project.mediator.ObjectRepository;
import project.utility.WebPageObjectCreation;

public class TrackingDevicesScript {
	
	WebPageObjectCreation repo;
	
	String vin;
	
	HashMap<String,String> devicemap;
	
	public static Logger log = Logger.getLogger(TruckScript.class);
	
	@BeforeClass
	public void Fetct_Repository_Object() throws InterruptedException, IOException
	{
		repo = ObjectRepository.GetInstance();
	}
	
	@Test(priority = 1,groups = {"Tracking Devices"})
	public void NavigatingDevicesPage() throws InterruptedException 
	{
		repo.dashboardPageObject().clickOnDevices();
				
		repo.dashboardPageObject().clickOnTrackingDevices();
		
		Thread.sleep(7000);
		
	}
	@Test(priority = 2, dependsOnMethods = "NavigatingDevicesPage",groups = {"Tracking Devices"})
	public void AddNewDevice() throws InterruptedException 
	{
		repo.trackingDevicesPageObject().clickOnAddDevices();
		
		repo.trackingDevicesPageObject().EnterDeviceName();
		
		repo.trackingDevicesPageObject().EnterDeviceId();
		
		repo.trackingDevicesPageObject().selectDeviceType();
		
		repo.trackingDevicesPageObject().clickOnConfirm();
		
		
	}
	@Test(priority = 3, dependsOnMethods = "NavigatingDevicesPage",groups = {"Tracking Devices"})
	public void SearchAndFilterDevice() throws InterruptedException 
	{
		
		repo.trackingDevicesPageObject().filter();
		
		Assert.assertTrue(repo.trackingDevicesPageObject().verifyFilteration(), "Device Filter functionality not working");
		
		repo.trackingDevicesPageObject().search();
		
		Assert.assertTrue(repo.trackingDevicesPageObject().verifyDevice(), "Result not showing as per Search text");
		
		
	}
	
	@Test(priority = 4,groups = {"Tracking Devices"}, dependsOnMethods = "NavigatingDevicesPage")
	public void EditDevice() throws InterruptedException 
	{
		Assert.assertTrue(repo.trackingDevicesPageObject().EditDevice(),"Incorrect data showing after Edit");
		
	}
	@Test(priority = 5,groups = {"Tracking Devices"}, dependsOnMethods = "NavigatingDevicesPage")
	public void DeleteDevice() throws InterruptedException 
	{
		Assert.assertTrue(repo.trackingDevicesPageObject().deleteDevice(), "Delete device functionality not working ");
		
		repo.dashboardPageObject().clickOnDevices();
		
		repo.dashboardPageObject().clickOnDeletedDevices();
		
		repo.trackingDevicesPageObject().search();
		
		Assert.assertTrue(repo.trackingDevicesPageObject().verifyDeviceonDeletedDevices(), "Deleted device not found on Deleted Devices Page");
		
		Thread.sleep(20000);
	}
}
