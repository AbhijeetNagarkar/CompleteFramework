package project.webpages;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import project.mediator.TestData;

public class WebPageDashCamera {

	
	WebDriver driver;
	
	WebDriverWait wait;

	public static Logger log = Logger.getLogger(WebPageDashCamera.class);
	
	long starttime=0;
	
	long totaltime=0;
	
	HashMap<String, String> devicemap,truckmap;
	
	public WebPageDashCamera(WebDriver driverinstance)
	{
		driver=driverinstance;
			
		PageFactory.initElements(driver,this);
			
		wait=new WebDriverWait(driver,10);
		
		devicemap=TestData.GetDeviceData();
		
	}
	
	@FindBy(xpath = "//div[@class=\"w-1/3 xl:w-1/4 h-full\"]//div[@class=\"text-xl font-black text-blue-secondary\"]")
	WebElement countDevices;

	@FindBy(xpath = "//div[@class=\"w-1/3 xl:w-1/4 h-full\"]//input")
	WebElement searchBox;
	
	@FindBy(xpath = "//div[@class=\"ml-10 mt-2\"]//span")
	WebElement changefocus;
	
	public Boolean verifyDashCameraCount() throws InterruptedException
	{
		try
		{
			Thread.sleep(3000);
			changefocus.click();
			Thread.sleep(3000);
			if(countDevices.getText().contains(devicemap.get("Device Count")))
			{
				log.info("Showing correct Dash Camera Count");
				return true;
			}
			
			log.info("Incorrect Dash Camera Count");
			countDevices.click();
			return false;
		}
		catch(Exception e)
		{
			log.info("Caught Exception while verifying Dash camera count");
			return false;
		}
	}
	public Boolean Search() throws InterruptedException
	{
		try
		{
		Thread.sleep(3000);
		changefocus.click();
		Thread.sleep(3000);
		searchBox.clear();
		searchBox.sendKeys("Device");
		
		List<WebElement> li=driver.findElements(By.xpath("//div[@class=\"w-1/3 xl:w-1/4 h-full\"]//td[@class=\"rc-table-cell\"]//div[@class=\"font-semibold\"]"));
		
		for(WebElement ele : li)
		{
			if(ele.getText().contains("Device"))
			{
				
			}
			else
			{
				log.info("Result not as per Search Criteria of Dash Camera Page");
				return false;
			}
		}
		log.info("Search functionality working correctly");
		return true;
		}
		catch(Exception e)
		{
			log.info("Caught Exception while search Dash camera");
			return false;
		}
	}
	public Boolean VerifyDashCamData() throws InterruptedException
	{
		Thread.sleep(10000);
		try
		{
			int size =driver.findElements(By.xpath("//div[@class=\"rc-table w-full  bg-gray-dullbg p-4 rc-table-fixed-header\"]//tr")).size();
			if(size==3)
			{
				if(driver.findElement(By.xpath("//div[@class=\"rc-table w-full  bg-gray-dullbg p-4 rc-table-fixed-header\"]//td[@class=\"rc-table-cell\"]//div")).getText().equalsIgnoreCase("No alerts."))
				{
					return true;
				}
			}
			else if(size>3)
			{
				return true;
			}
			else
				return false;
		}
		catch(NoSuchElementException e)
		{
			log.info("Caught Exception as No Such Element while Verify Dash Camera Data");
			return false;
		}
		return false;
	}
	public void ClickonDashcam() throws InterruptedException
	{
		try
		{
			Thread.sleep(6000);
			
			wait.until(ExpectedConditions.elementToBeClickable(countDevices));
			Thread.sleep(3000);
			countDevices.click();
			log.info("Clicked on Count Devices");
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class=\"w-1/3 xl:w-1/4 h-full\"]//td[@class=\"rc-table-cell\"]//div[@class=\"font-semibold\"]")));
			List<WebElement> li=driver.findElements(By.xpath("//div[@class=\"w-1/3 xl:w-1/4 h-full\"]//td[@class=\"rc-table-cell\"]//div[@class=\"font-semibold\"]"));
			Thread.sleep(3000);
			li.get(2).click();
			log.info("Clicked on 3rd Dash Camera to check records");
		}
		catch(Exception e)
		{
			log.info("Caught Exception");
			Assert.fail("Unable to click on Dash Camera");
		}
	}
	
}
