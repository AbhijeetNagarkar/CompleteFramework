package project.webpages;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import project.mediator.TestData;

public class WebPageTrackingDevices {
	
	WebDriver driver;
	
	WebDriverWait wait;

	public static Logger log = Logger.getLogger(WebPageTrackingDevices.class);
		
	HashMap<String, String> devicemap,truckmap;
	
	public WebPageTrackingDevices(WebDriver driverinstance)
	{
		driver=driverinstance;
			
		PageFactory.initElements(driver,this);
			
		wait=new WebDriverWait(driver,20);
		
		devicemap=TestData.GetDeviceData();
		
		truckmap = TestData.GetVehicleData();
	}
	
	@FindBy(xpath = "//button[text()=\"+ Add Devices\"]")
	WebElement addDevices;

	@FindBy(xpath = "//input[@name=\"deviceName\"]")
	WebElement deviceName;
	
	@FindBy(xpath = "//input[@name=\"deviceId\"]")
	WebElement deviceId;
	
	@FindBy(xpath = "//*[@class=\" css-113f9vn\"]//div/span")
	List<WebElement> deviceTypeOptions;
	
	@FindBy(xpath = "//button[text()=\"Confirm\"]")
	WebElement confirmButton;
	
	@FindBy(xpath = "//button[text()=\"Cancel\"]")
	WebElement cancelButton;
	
	@FindBy(xpath = "//input[@placeholder=\"Search Device\"]")
	WebElement search;
	
	@FindBy(xpath = "//button[text()=\"Yes\"]")
	WebElement deleteYesButton;
	
	@FindBy(xpath = "//div[@class=\" css-113f9vn\"]//div//div//span[text()=\"Cloud Dashcam\"]")
	WebElement filterDashcamoption;
	
	@FindBy(xpath = "//div[@class=\"single-select-dropdown css-2b097c-container\"]")
	WebElement filterDropDown;
	
	@FindBy(xpath = "//div[@class=\"ant-message-notice\"]//span[text()=\"Something went wrong!\"]")
	WebElement alertmsg;
	
	@FindBy(xpath = "//td[@class=\"rc-table-cell\"]//*[name()=\"svg\"]")
	WebElement editbutton;
	
	@FindBy(xpath = "//div[@class=\" css-1hwfws3\"]//*[text()=\"Select asset\"]")
	WebElement selectAssetdropdown;
	
	@FindBy(xpath = "//button[text()=\"Save\"]")
	WebElement editSave;
	
	@FindBy(xpath = "//div[@class=\"ml-10 mt-2\"]//span")
	WebElement changefocus;
	
	public void clickOnAddDevices()
	{
		try
		{
		wait.until(ExpectedConditions.visibilityOf(addDevices));
		changefocus.click();
		
		addDevices.click();
		
		log.info("Clicked on Add new Device button on Dashboard");
		}
		catch(Exception e)
		{
			driver.navigate().refresh();
			Assert.fail("Unable to click on Add New Device Button of Asset Tracking Page");
			
		}
	}
	
	public void EnterDeviceName()
	{
		try
		{
		deviceName.sendKeys(devicemap.get("Device Name"));
		
		log.info("Entered Deviced Name : "+devicemap.get("Device Name"));
		}
		catch(Exception e)
		{
			driver.navigate().refresh();
			Assert.fail("Unable to Enter Device Name in New Device Creation Prompt");
		}
		
	}
	
	public void EnterDeviceId()
	{
		try
		{
		deviceId.clear();
		
		devicemap.put("deviceId", randomNumber());
		
		deviceId.sendKeys(devicemap.get("deviceId"));
		
		log.info("Entered Device ID : "+devicemap.get("deviceId"));
		}
		catch(Exception e)
		{
			driver.navigate().refresh();
			Assert.fail("Unable to Enter Device Id in New Device Creation Prompt");
		}
	}
	
	public void selectDeviceType() throws InterruptedException
	{
		try
		{
		Thread.sleep(5000);
		
		driver.findElements(By.xpath("//div[@class=\" pt-2\"]//*[name()=\"svg\"]")).get(0).click();
		
		log.info("Clicked on drop down to select option");
		
		Thread.sleep(5000);
		
		if(devicemap.get("Device Type").equalsIgnoreCase("Dash camera"))
			driver.findElements(By.xpath("//*[@class=\" css-113f9vn\"]//div/span[text()=\"Cloud Dashcam\"]")).get(0).click();
		else
		driver.findElements(By.xpath("//*[@class=\" css-113f9vn\"]//div/span[text()='"+devicemap.get("Device Type")+"']")).get(0).click();
		
		log.info("Clicked on drop down option and selected Dash Camera");
		}
		catch(Exception e)
		{
			driver.navigate().refresh();
			Assert.fail("Unable to Select Device Type while Creating new Device");
		}
	}

	public void clickOnConfirm() throws InterruptedException {
		
		try
		{
		confirmButton.click();
		
		log.info("Clicked on Confirm button");
		Thread.sleep(5000);
		}
		catch(Exception e)
		{
			driver.navigate().refresh();
			Assert.fail("Unable to click on Confirm Button of New Device Creation Prompt");
		}
		try
		{
			wait.until(ExpectedConditions.visibilityOf(alertmsg));
			EnterDeviceId();
			confirmButton.click();
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			log.info("New Device added successfully");
		}
		
		try
		{
		cancelButton.click();
		
		log.info("Clicked on Cancel After added new device");
		}
		catch(Exception e)
		{
			driver.navigate().refresh();
			Assert.fail("Unable to click on Cancel New Device Creation Prompt");
		}
	}
	
	public String randomNumber()
	{
		long number = 100000000000000L;
	    
	    Random r=new Random();
	    // return a long between smallest and biggest (+1 to include biggest as well with the upper bound)
	    long random = r.nextInt(999999999);
	    
	    number=number+random;
	 
		return String.valueOf(number);
	}
	
	public Boolean verifyDevice()
	{
		try
		{
			Thread.sleep(5000);
			driver.findElement(By.xpath("//tr//td[@class=\"rc-table-cell\"]//div[text()='"+devicemap.get("deviceId")+"']"));
			log.info("Created device "+devicemap.get("deviceId")+" found on Dashboard");
			return true;
		}
		catch(Exception e)
		{
			log.info("Created device "+devicemap.get("deviceId")+" not found on dashboard");
			driver.navigate().refresh();
			return false;
		}
	}
	
	public Boolean deleteDevice()
	{
		
		try
		{
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr//td[@class=\"rc-table-cell\"]//div[text()='"+devicemap.get("deviceId")+"']//following::button")));
			driver.findElements(By.xpath("//tr//td[@class=\"rc-table-cell\"]//div[text()='"+devicemap.get("deviceId")+"']//following::button")).get(0).click();
			log.info("Clicked on Delete device");
			Thread.sleep(2000);
			deleteYesButton.click();
			log.info("Clicked on Confirming delete device");
			return true;
		}
		catch(Exception e)
		{
			driver.navigate().refresh();
			log.info("Created device not found on dashboard to delete it");
			return false;
		}
	}
	
	public void search() throws InterruptedException
	{
		try
		{
		Thread.sleep(5000);
		
		changefocus.click();
		
		Thread.sleep(1000);

		
		search.sendKeys(devicemap.get("deviceId"));
		
		log.info("searching for : "+devicemap.get("deviceId"));
		
		Thread.sleep(2000);
		}
		catch(Exception e)
		{
			driver.navigate().refresh();
			Assert.fail("Unable to Search Device on Asset Tracking Page");
		}
	}
	
	public void filter() throws InterruptedException
	{
		try
		{
		wait.until(ExpectedConditions.visibilityOf(filterDropDown));
		filterDropDown.click();
		
		log.info("Clicked on filter drop down");
		
		Thread.sleep(2000);
		
		if(devicemap.get("Device Type").equalsIgnoreCase("Dash camera") || devicemap.get("Device Type").equalsIgnoreCase("Cloud Dashcam"))
		filterDashcamoption.click();
		else 
			driver.findElement(By.xpath("//div[@class=\" css-hjiaga-menu\"]//div//div//span[text()='"+devicemap.get("Device Type")+"']")).click();
		log.info("Clicked on "+devicemap.get("Device Type")+" drop down option");
		}
		catch(Exception e)
		{
			driver.navigate().refresh();
			Assert.fail("Unable to click on Filter and select option of Asset Tracking Page");
		}
	}
	
	public Boolean verifyFilteration()
	{
		List<WebElement> ele = driver.findElements(By.xpath("//tr[@class=\"rc-table-row rc-table-row-level-0 text-base text-gray-400 bg-white border-b border-gray-100 h-12 w-full hover:bg-blue-tablerow focus:hover:bg-blue-tablerow rounded-md`\"]"));
		String count=String.valueOf((ele.size()-1));
		devicemap.put("Device Count",count);
		for(WebElement row : ele)
		{
			String str = row.findElements(By.tagName("div")).get(1).getText();
			if(devicemap.get("Device Type").equalsIgnoreCase("Dash camera") || devicemap.get("Device Type").equalsIgnoreCase("Cloud Dashcam"))
			{
				continue;
			}
			else if(str.equalsIgnoreCase(devicemap.get("Device Type")))
			{
				continue;
			}
			else
				return false;
		}
		log.info("Filteration verified");
		return true;
	}
	
	public void getDashCamCount()
	{
		try
		{
		Thread.sleep(2000);
			
		filterDropDown.click();
		
		log.info("Clicked on filter drop down");
		
		Thread.sleep(2000);
		
		filterDashcamoption.click();
		
		List<WebElement> ele = driver.findElements(By.xpath("//tr[@class=\"rc-table-row rc-table-row-level-0 text-base text-gray-400 bg-white border-b border-gray-100 h-12 w-full hover:bg-blue-tablerow focus:hover:bg-blue-tablerow rounded-md`\"]"));
		String count=String.valueOf((ele.size()));
		devicemap.put("Device Count",count);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public boolean verifyDeviceonDeletedDevices()
	{
		//td[@class="rc-table-cell"]//*[text()="860112047139268"]
		try
		{
			Thread.sleep(5000);
			driver.findElement(By.xpath("//td[@class=\"rc-table-cell\"]//*[text()='"+devicemap.get("deviceId")+"']"));
			log.info("Deleted device "+devicemap.get("deviceId")+" found on Deleted Device Page");
			return true;
		}
		catch(Exception e)
		{
			log.info("Deleted device "+devicemap.get("deviceId")+" not found on Deleted Device Page");
			return false;
		}
	}
	
	public boolean EditDevice() throws InterruptedException
	{
		try
		{
		wait.until(ExpectedConditions.visibilityOf(editbutton));
		editbutton.click();
		
		log.info("Clicked on Edit button ");
		
		Thread.sleep(5000);
		}
		catch(Exception e)
		{
			
			Assert.fail("Unable to click on Edit button of Tracking Device Dashboard");
			driver.navigate().refresh();
		}
		try
		{
		selectAssetdropdown.click();
		
		log.info("Clicked on Select Assets Drop down");
		
		Thread.sleep(2000);
		}
		catch(Exception e)
		{
			Assert.fail("Unable to click on Asset drop down tab on Edit Tracking Device prompt");
			driver.navigate().refresh();

		}
		try
		{
		driver.findElements(By.xpath("//div[@class=\" css-1u0owcj-option\"]//span[@class=\"text-blue-secondary\"]")).get(0).click();
		Thread.sleep(5000);
		
		}
		catch(Exception e)
		{
			Assert.fail("No Trucks available to Assign Tracking Devices");
			driver.navigate().refresh();

		}
		
		String str2 = driver.findElements(By.xpath("//div[@class=\" css-1hwfws3\"]//div//span")).get(3).getText();

		try
		{
		editSave.click();
		
		log.info("Clicked on Save button to update Device details");
		
		Thread.sleep(5000);
		}
		catch(Exception e)
		{
			
			Assert.fail("Unable to click on Update button of Edit Tracking Device Prompt");
			driver.navigate().refresh();
		}
		String str = driver.findElements(By.xpath("//td[@class=\"rc-table-cell\"]//div")).get(2).getText();
		
		if(str.contains(str2))
		{
			log.info("Device is verified after Edit");
			return true;
		}
		else 
		{
			log.info("Device details not matching after updation");
			return false;
		}
	}
	
}
