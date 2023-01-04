package project.webpages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebPageDashboard {
	
	WebDriver driver;
	
	WebDriverWait wait;
	
	public static Logger log = Logger.getLogger(WebPageDashboard.class);
	
	public WebPageDashboard(WebDriver driverinstance)
	{
			driver=driverinstance;
			
			PageFactory.initElements(driver,this);
			
			wait = new WebDriverWait(driver,10);
			
	}

	//Geofences , Inspection, New Tabs click yet to be mentioned along its sub menu

	//main menu
	
	@FindBy(xpath = "//div[@class=\"flex flex-col\"]//span[text()=\"Logbook\"]")
	WebElement logbook;
	
	@FindBy(xpath = "//div[@class=\"flex flex-col\"]//span[text()=\"Vehicles\"]")
	WebElement vehicles;
	
	@FindBy(xpath = "//div[@class=\"flex flex-col\"]//span[text()=\"Location\"]")
	WebElement location;
	
	@FindBy(xpath = "//div[@class=\"flex flex-col\"]//span[text()=\"Messages\"]")
	WebElement messages;
	
	@FindBy(xpath = "//div[@class=\"flex flex-col\"]//span[text()=\"Devices\"]")
	WebElement devices;
	
	@FindBy(xpath = "//div[@class=\"flex flex-col\"]//span[text()=\"Drivers\"]")
	WebElement drivers;
	
	@FindBy(xpath = "//div[@class=\"flex flex-col\"]//span[text()=\"IFTA\"]")
	WebElement ifta;
	
	@FindBy(xpath = "//div[@class=\"flex flex-col\"]//span[text()=\"Profile\"]")
	WebElement profile;
	
	@FindBy(xpath = "//div[@class=\"flex flex-col\"]//span[text()=\"Reports\"]")
	WebElement reports;
	
	@FindBy(xpath = "//div[@class=\"flex flex-col\"]//span[text()=\"API Key\"]")
	WebElement apikey;
	
	@FindBy(xpath = "//div[@class=\"flex flex-col\"]//span[text()=\"Feature\"]")
	WebElement features;
	
	@FindBy(xpath = "//div[@class=\"flex flex-col\"]//span[text()=\"Alerts\"]")
	WebElement alerts;
	
	
	//Vehilces submenu
	
	@FindBy(xpath = "//div[@class=\"custom-drop-submenu\"]//*[text()=\"Logbook\"]")
	WebElement logbooksubmenu;
		
	@FindBy(xpath = "//div[@class=\"custom-drop-submenu\"]//div[text()=\"Unassigned Drive\"]")
	WebElement unassigneddrive;
	
	//Vehilces submenu
	
	@FindBy(xpath = "//div[@class=\"custom-drop-submenu\"]//*[text()=\"Trucks\"]")
	WebElement trucks;
	
	@FindBy(xpath = "//div[@class=\"custom-drop-submenu\"]//div[text()=\"Deleted Trucks\"]")
	WebElement deletedtruck;
	
	@FindBy(xpath = "//div[@class=\"custom-drop-submenu\"]//span[text()=\"Trailers\"]")
	WebElement trailers;
	
	@FindBy(xpath = "//div[@class=\"custom-drop-submenu\"]//div[text()=\"Deleted Trailers\"]")
	WebElement deletedtrailers;
	
	
	//Location submenus
	
	@FindBy(xpath = "//div[@class=\"custom-drop-submenu\"]//*[text()=\"Assets\"]")
	WebElement assets;
	
	@FindBy(xpath = "//div[@class=\"custom-drop-submenu\"]//*[text()=\"Tracking Links\"]")
	WebElement trackinglinks;
	
	
	//Messages submenus
	
	@FindBy(xpath = "//div[@class=\"custom-drop-submenu\"]//div[text()=\"Messages\"]")
	WebElement messagessubmenu;
	
	//Devices submenus
	
	@FindBy(xpath = "//div[@class=\"custom-drop-submenu\"]//div[text()=\"Tracking Devices\"]")
	WebElement trackingdevices;
	
	@FindBy(xpath = "//div[@class=\"custom-drop-submenu\"]//*[text()=\"Deleted Devices\"]")
	WebElement deleteddevices;
	
	@FindBy(xpath = "//div[@class=\"custom-drop-submenu\"]//div[text()=\"ELD Devices\"]")
	WebElement elddevices;
	
	@FindBy(xpath = "//div[@class=\"custom-drop-submenu\"]//*[text()=\"Dash Cameras\"]")
	WebElement dashcameras;
	
	
	//Drivers submenu
	
	@FindBy(xpath = "//div[@class=\"custom-drop-submenu\"]//*[text()=\"Drivers\"]")
	WebElement driverssubmenu;
	
	@FindBy(xpath = "//div[@class=\"custom-drop-submenu\"]//*[text()=\"Deleted\"]")
	WebElement deleteddrivers;
	
	//IFTA submenu
	
	@FindBy(xpath = "//div[@class=\"custom-drop-submenu\"]//*[text()=\"Trips\"]")
	WebElement iftatrips;
		
	@FindBy(xpath = "//div[@class=\"custom-drop-submenu\"]//*[text()=\"Reports\"]")
	WebElement iftareports;
	
	
	//Profile submenu
	
	@FindBy(xpath = "//div[@class=\"custom-drop-submenu\"]//*[text()=\"Company Profile\"]")
	WebElement companyprofile;
	
	@FindBy(xpath = "//div[@class=\"custom-drop-submenu\"]//*[text()=\"Billing Details\"]")
	WebElement billingdetails;
	
	//Reports submenu
	
	@FindBy(xpath = "//div[@class=\"custom-drop-submenu\"]//*[text()=\"Reports\"]")
	WebElement reportsubmenu;
	
	//API Key submenu
	
	@FindBy(xpath = "//div[@class=\"custom-drop-submenu\"]//*[text()=\"API Key Transfer\"]")
	WebElement apikeytransfer;
	

	//Feature submenu
	
	@FindBy(xpath = "//div[@class=\"custom-drop-submenu\"]//*[text()=\"New Updates\"]")
	WebElement newupdates;
	
	//Alerts submenu
	
	@FindBy(xpath = "//div[@class=\"custom-drop-submenu\"]//*[text()=\"Alerts\"]")
	WebElement alertsubmenu;
	
	//Geofences , Inspection, New Tabs click yet to be mentioned along its sub menu
	
	public void clickOnLogbook()
	{
		try
		{
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"flex flex-col\"]//span[text()=\"Logbook\"]")));
		
		logbook.click();
		}
		catch (Exception e) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"flex flex-col\"]//span[text()=\"Logbook\"]")));
			
			logbook.click();
		}
		log.info("Clicked on Logbook Menu");
	}
	
	public void clickOnVehicle()
	{
		try
		{
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"flex flex-col\"]//span[text()=\"Vehicles\"]")));
		
		vehicles.click();
		}
		catch (Exception e) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"flex flex-col\"]//span[text()=\"Vehicles\"]")));
			
			vehicles.click();
		}
		log.info("Clicked on Vehicles Menu");
	}
	
	public void clickOnLocation()
	{
		try
		{
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"flex flex-col\"]//span[text()=\"Location\"]")));
		
		location.click();
		}
		catch (Exception e) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"flex flex-col\"]//span[text()=\"Location\"]")));
			
			location.click();
		}
		log.info("Clicked on Location Menu");
	}
	
	public void clickOnMessages()
	{
		try
		{
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"flex flex-col\"]//span[text()=\"Messages\"]")));
		
		messages.click();
		}
		catch (Exception e) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"flex flex-col\"]//span[text()=\"Messages\"]")));
			
			messages.click();
		}
		log.info("Clicked on Messages Menu");
	}
	
	public void clickOnDevices() throws InterruptedException
	{
		driver.navigate().refresh();
		try
		{
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"flex flex-col\"]//span[text()=\"Devices\"]")));
		
		devices.click();
		}
		catch (Exception e) {
		//	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"flex flex-col\"]//span[text()=\"Devices\"]")));
			Thread.sleep(10000);
			devices.click();
		
		}
		log.info("Clicked on Devices from Menu");
		
		Thread.sleep(2000);
	}
	
	public void clickOnDrivers()
	{
		try
		{
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"flex flex-col\"]//span[text()=\"Drivers\"]")));
		
		drivers.click();
		}
		catch (Exception e) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"flex flex-col\"]//span[text()=\"Drivers\"]")));
			
			drivers.click();
		}
		log.info("Clicked on Drivers Menu");
	}
	
	public void clickOnIFTA()
	{
		try
		{
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"flex flex-col\"]//span[text()=\"IFTA\"]")));
		
		ifta.click();
		}
		catch (Exception e) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"flex flex-col\"]//span[text()=\"IFTA\"]")));
			
			ifta.click();
		}
		log.info("Clicked on IFTA Menu");
	}
	
	public void clickOnProfile()
	{
		try
		{
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"flex flex-col\"]//span[text()=\"Profile\"]")));
		
		profile.click();
		}
		catch (Exception e) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"flex flex-col\"]//span[text()=\"Profile\"]")));
			
			profile.click();
		}
		log.info("Clicked on Profile Menu");
	}
	
	
	public void clickOnReports()
	{
		try
		{
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"flex flex-col\"]//span[text()=\"Reports\"]")));
		
		reports.click();
		}
		catch (Exception e) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"flex flex-col\"]//span[text()=\"Reports\"]")));
			
			reports.click();
		}
		log.info("Clicked on Reports Menu");
	}
	
	
	public void clickOnAPIKey()
	{
		try
		{
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"flex flex-col\"]//span[text()=\"API Key\"]")));
		
		apikey.click();
		}
		catch (Exception e) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"flex flex-col\"]//span[text()=\"API Key\"]")));
			
			apikey.click();
		}
		log.info("Clicked on API Key Menu");
	}
	
	public void clickOnFeature()
	{
		try
		{
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"flex flex-col\"]//span[text()=\"Feature\"]")));
		
		features.click();
		}
		catch (Exception e) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"flex flex-col\"]//span[text()=\"Feature\"]")));
			
			features.click();
		}
		log.info("Clicked on Feature Menu");
	}
	
	public void clickOnAlerts()
	{
		try
		{
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"flex flex-col\"]//span[text()=\"Alerts\"]")));
		
		alerts.click();
		}
		catch (Exception e) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"flex flex-col\"]//span[text()=\"Alerts\"]")));
			
			alerts.click();
		}
		log.info("Clicked on Alerts Menu");
	}
	
	public void clickOnLogbookSubMenu() throws InterruptedException
	{
		try {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"custom-drop-submenu\"]//*[text()=\"Logbook\"]")));
		Thread.sleep(1000);
		logbooksubmenu.click();
		}
		catch (Exception e) {
			// TODO: handle exception
			logbook.click();
			Thread.sleep(1000);
			logbooksubmenu.click();
		}
		log.info("Clicked on Logbook from Sub Menu");
		
		Thread.sleep(2000);
	}
	
	public void clickOnUnassignedDrive() throws InterruptedException
	{
		try {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"custom-drop-submenu\"]//*[text()=\"Unassigned Drive\"]")));
		Thread.sleep(1000);
		unassigneddrive.click();
		}
		catch (Exception e) {
			// TODO: handle exception
			logbook.click();
			Thread.sleep(1000);
			unassigneddrive.click();
		}
		log.info("Clicked on UnAssigned Drive from Sub Menu");
		
		Thread.sleep(2000);
	}
	
	
	public void clickOnTrucks() throws InterruptedException
	{
		try {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"custom-drop-submenu\"]//*[text()=\"Trucks\"]")));
		Thread.sleep(1000);
		trucks.click();
		}
		catch (Exception e) {
			// TODO: handle exception
			vehicles.click();
			Thread.sleep(1000);
			trucks.click();
		}
		log.info("Clicked on Trucks from Sub Menu");
		
		Thread.sleep(2000);
	}
	
	public void clickOnDeletedTrucks() throws InterruptedException
	{
		try {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"custom-drop-submenu\"]//div[text()=\"Deleted Trucks\"]")));
		
		deletedtruck.click();
		}
		catch (Exception e) {
			// TODO: handle exception
			vehicles.click();
			Thread.sleep(1000);
			deletedtruck.click();
		}
		log.info("Clicked on Deleted Trucks from Sub Menu");
		
		Thread.sleep(2000);
	}
	
	public void clickOnTrailers() throws InterruptedException
	{
		try {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"custom-drop-submenu\"]//*[text()=\"Trailers\"]")));
		
		trailers.click();
		}
		catch (Exception e) {
			// TODO: handle exception
			vehicles.click();
			Thread.sleep(1000);
			trailers.click();
		}
		log.info("Clicked on Trailers from Sub Menu");
		
		Thread.sleep(2000);
	}
	
	public void clickOnDeletedTrailers() throws InterruptedException
	{
		try {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"custom-drop-submenu\"]//div[text()=\"Deleted Trailers\"]")));
		
		deletedtrailers.click();
		}
		catch (Exception e) {
			// TODO: handle exception
			vehicles.click();
			Thread.sleep(1000);
			deletedtrailers.click();
		}
		log.info("Clicked on Deleted Trailers from Sub Menu");
		
		Thread.sleep(2000);
	}
	
	public void clickOnMessagesSubMenu() throws InterruptedException
	{
		try {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"custom-drop-submenu\"]//div[text()=\"Messages\"]")));
		
		messagessubmenu.click();
		}
		catch (Exception e) {
			// TODO: handle exception
			messages.click();
			Thread.sleep(1000);
			messagessubmenu.click();
		}
		log.info("Clicked on Messages from Sub Menu");
		
		Thread.sleep(2000);
	}
	
	
	public void clickOnTrackingLinks() throws InterruptedException
	{
		try
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"custom-drop-submenu\"]//*[text()=\"Tracking Links\"]")));
		
			trackinglinks.click();
		}
		catch (Exception e) {
			// TODO: handle exception
			location.click();
			Thread.sleep(1000);
			trackinglinks.click();
		}
		log.info("Clicked on Tracking Links from Sub Menu");
		
		Thread.sleep(2000);
	}
	
	public void clickOnAssets() throws InterruptedException
	{
		try
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"custom-drop-submenu\"]//*[text()=\"Assets\"]")));
		
			assets.click();
		}
		catch (Exception e) {
			// TODO: handle exception
			location.click();
			Thread.sleep(1000);
			assets.click();
		}
		log.info("Clicked on Assets from Sub Menu");
		
		Thread.sleep(2000);
	}
	
	
	public void clickOnTrackingDevices() throws InterruptedException
	{
		try
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"custom-drop-submenu\"]//div[text()=\"Tracking Devices\"]")));
			
			trackingdevices.click();
		}
		catch (Exception e) {
			// TODO: handle exception
			devices.click();
			Thread.sleep(1000);
			trackingdevices.click();
		}
		log.info("Clicked on Tracking Devices from Sub Menu");
		
		Thread.sleep(2000);
	}
	public void clickOnDeletedDevices() throws InterruptedException
	{
		try
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"custom-drop-submenu\"]//*[text()=\"Deleted Devices\"]")));
		
			deleteddevices.click();
		}
		catch (Exception e) {
			// TODO: handle exception
			devices.click();
			Thread.sleep(1000);
			deleteddevices.click();
		}
		log.info("Clicked on Deleted Devices from Sub Menu");
		
		Thread.sleep(2000);
	}
	
	public void clickOnELDDevices() throws InterruptedException
	{
		try
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"custom-drop-submenu\"]//*[text()=\"ELD Devices\"]")));
		
			elddevices.click();
		}
		catch (Exception e) {
			// TODO: handle exception
			devices.click();
			Thread.sleep(1000);
			elddevices.click();
		}
		log.info("Clicked on ELD Devices from Sub Menu");
		
		Thread.sleep(2000);
	}
	public void clickOnDashCameras() throws InterruptedException
	{
		try
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"custom-drop-submenu\"]//*[text()=\"Dash Cameras\"]")));
		
			dashcameras.click();
		}
		catch (Exception e) {
			// TODO: handle exception
			devices.click();
			Thread.sleep(1000);
			dashcameras.click();
		}
		log.info("Clicked on Dash Cameras from Sub Menu");
		
		Thread.sleep(2000);
	}
	
	public void clickOnDriversSubMenu() throws InterruptedException
	{
		try
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"custom-drop-submenu\"]//*[text()=\"Drivers\"]")));
		
			driverssubmenu.click();
		}
		catch (Exception e) {
			// TODO: handle exception
			drivers.click();
			Thread.sleep(1000);
			driverssubmenu.click();
		}
		log.info("Clicked on Drivers from Sub Menu");
		
		Thread.sleep(2000);
	}
	
	public void clickOnDeletedDrivers() throws InterruptedException
	{
		try
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"custom-drop-submenu\"]//*[text()=\"Deleted\"]")));
		
			deleteddrivers.click();
		}
		catch (Exception e) {
			// TODO: handle exception
			Thread.sleep(1000);
			drivers.click();
			Thread.sleep(1000);
			deleteddrivers.click();
		}
		log.info("Clicked on Deleted Drivers from Sub Menu");
		
		Thread.sleep(2000);
	}
	
	public void clickOnIFTATrips() throws InterruptedException
	{
		try
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"custom-drop-submenu\"]//*[text()=\"Trips\"]")));
		
			iftatrips.click();
		}
		catch (Exception e) {
			// TODO: handle exception
			ifta.click();
			Thread.sleep(1000);
			iftatrips.click();
		}
		log.info("Clicked on IFTA Trips from Sub Menu");
		
		Thread.sleep(2000);
	}
	
	public void clickOnIFTAReports() throws InterruptedException
	{
		try
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"custom-drop-submenu\"]//*[text()=\"Reports\"]")));
		
			iftareports.click();
		}
		catch (Exception e) {
			// TODO: handle exception
			ifta.click();
			Thread.sleep(1000);
			iftareports.click();
		}
		log.info("Clicked on IFTA Reports from Sub Menu");
		
		Thread.sleep(2000);
	}
	
	
	public void clickOnCompanyProfile() throws InterruptedException
	{
		try {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"custom-drop-submenu\"]//*[text()=\"Company Profile\"]")));
		
		companyprofile.click();
		}
		catch (Exception e) {
			// TODO: handle exception
			profile.click();
			Thread.sleep(1000);
			companyprofile.click();
		}
		log.info("Clicked on Company Profile from Sub Menu");
		
		Thread.sleep(2000);
	}
	
	public void clickOnBillingDetails() throws InterruptedException
	{
		try {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"custom-drop-submenu\"]//*[text()=\"Billing Details\"]")));
		
		billingdetails.click();
		}
		catch (Exception e) {
			// TODO: handle exception
			profile.click();
			Thread.sleep(1000);
			billingdetails.click();
		}
		log.info("Clicked on Billing Details from Sub Menu");
		
		Thread.sleep(2000);
	}
	
	
	public void clickOnReportsSubMenu() throws InterruptedException
	{
		try {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"custom-drop-submenu\"]//*[text()=\"Reports\"]")));
		
		reportsubmenu.click();
		}
		catch (Exception e) {
			// TODO: handle exception
			reports.click();
			Thread.sleep(1000);
			reportsubmenu.click();
		}
		log.info("Clicked on Reports from Sub Menu");
		
		Thread.sleep(2000);
	}
	
	
	public void clickOnAPIKeyTransfer() throws InterruptedException
	{
		try {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"custom-drop-submenu\"]//*[text()=\"API Key Transfer\"]")));
		
		apikeytransfer.click();
		}
		catch (Exception e) {
			// TODO: handle exception
			apikey.click();
			Thread.sleep(1000);
			apikeytransfer.click();
		}
		log.info("Clicked on API Key Transfer from Sub Menu");
		
		Thread.sleep(2000);
	}
	
	public void clickOnNewUpdates() throws InterruptedException
	{
		try {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"custom-drop-submenu\"]//*[text()=\"New Updates\"]")));
		
		newupdates.click();
		}
		catch (Exception e) {
			// TODO: handle exception
			features.click();
			Thread.sleep(1000);
			newupdates.click();
		}
		log.info("Clicked on New Updates from Sub Menu");
		
		Thread.sleep(2000);
	}
	
	public void clickOnAlertsSubMenu() throws InterruptedException
	{
		try {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"custom-drop-submenu\"]//*[text()=\"Alerts\"]")));
		
		alertsubmenu.click();
		}
		catch (Exception e) {
			// TODO: handle exception
			alerts.click();
			Thread.sleep(1000);
			alertsubmenu.click();
		}
		log.info("Clicked on Alerts from Sub Menu");
		
		Thread.sleep(2000);
	}
	
	public void refresh() throws InterruptedException
	{
		driver.navigate().refresh();
		//Thread.sleep(3000);
	}
	
	
	


	
	

}
