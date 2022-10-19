package project.webpages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import project.mediator.Driver;


public class WebPageDashboard {
	
	WebDriver driver;
	
	WebDriverWait wait;
	
	public static Logger log = Logger.getLogger(WebPageDashboard.class);
	
	long starttime=0;
	
	long totaltime=0;
	
		
	public WebPageDashboard(WebDriver driverinstance)
	{
			driver=driverinstance;
			
			PageFactory.initElements(driver,this);
			
			wait = new WebDriverWait(driver,10);
			
	}

	@FindBy(xpath = "//div[@class=\"flex flex-col\"]//span[text()=\"Vehicles\"]")
	WebElement vehicles;
	
	@FindBy(xpath = "//div[@class=\"custom-drop-submenu\"]//*[text()=\"Trucks\"]")
	WebElement trucks;
	
	@FindBy(xpath = "//div[@class=\"custom-drop-submenu\"]//div[text()=\"Deleted Trucks\"]")
	WebElement deletedtruck;
	
	@FindBy(xpath = "//div[@class=\"custom-drop-submenu\"]//span[text()=\"Trailers\"]")
	WebElement trailers;
	
	@FindBy(xpath = "//div[@class=\"custom-drop-submenu\"]//div[text()=\"Deleted Trailers\"]")
	WebElement deletedtrailers;
	
	@FindBy(xpath = "//div[@class=\"flex flex-col\"]//span[text()=\"Devices\"]")
	WebElement devices;
	
	@FindBy(xpath = "//div[@class=\"custom-drop-submenu\"]//div[text()=\"Tracking Devices\"]")
	WebElement trackingdevices;
	
	@FindBy(xpath = "//div[@class=\"custom-drop-submenu\"]//*[text()=\"Deleted Devices\"]")
	WebElement deleteddevices;
	
	
	public void clickOnVehicle()
	{
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"flex flex-col\"]//span[text()=\"Vehicles\"]")));
		
		vehicles.click();
		
		log.info("Clicked on Vehicles Menu");
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
	public void refresh() throws InterruptedException
	{
		driver.navigate().refresh();
		Thread.sleep(2000);
		}
	
	public void clickOnDevices() throws InterruptedException
	{
		driver.navigate().refresh();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"flex flex-col\"]//span[text()=\"Devices\"]")));
		
		devices.click();
		
		log.info("Clicked on Devices from Menu");
		
		Thread.sleep(000);
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


}
