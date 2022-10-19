package project.webpages;

import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import project.mediator.PageLoadTime;
import project.mediator.TestData;

public class WebPageTruck {
	
		WebDriver driver;
		
		WebDriverWait wait;
	
		public static Logger log = Logger.getLogger(WebPageTruck.class);
		
		long starttime=0;
		
		long totaltime=0;
		
		HashMap<String,String> truckmap;
	
	public WebPageTruck(WebDriver driverinstance)
	{
		driver=driverinstance;
			
		PageFactory.initElements(driver,this);
			
		wait=new WebDriverWait(driver,10);
		
		truckmap=TestData.GetVehicleData();
	}

	@FindBy(xpath = "//button[@label=\"+ Add Truck\"]")
	WebElement addTruckButtonDashboard;
	
	@FindBy(id = "truckIdentifier")
	WebElement truckIdentifier;
	
	@FindBy(id = "vinNo")
	WebElement vinNo;
	
	@FindBy(xpath = "//button[@label=\"Next\"]")
	WebElement nextButton;
	
	@FindBy(xpath = "//button[@label=\"Add Truck\"]")
	WebElement addTruck;
	
	@FindBy(id = "regNo")
	WebElement regNo;
	
	@FindBy(className = "ant-calendar-input ")
	WebElement expiry;
	
	@FindBy(id = "liabilityInsuranceName")
	WebElement liabilityInsuranceName;
	
	@FindBy(id = "liabilityInsuranceNo")
	WebElement liabilityInsuranceNo;
	
	@FindBy(id = "cargoInsuranceName")
	WebElement cargoInsuranceName;
	
	@FindBy(id = "cargoInsuranceNo")
	WebElement cargoInsuranceNo;
	
	@FindBy(xpath = "//button[@label=\"Back\"]")
	WebElement backButton;
	
	@FindBy(xpath = "//img[@class=\"closeModalIcon\"]")
	WebElement closepopup;
	
	@FindBy(xpath = "//input[@class=\"ant-input\"]")
	WebElement searchTruck;
	
	@FindBy(xpath="//tbody[@class=\"ant-table-tbody\"]//tr//td")
	List<WebElement> tabledata;
	
	@FindBy(xpath="//div[@class=\"ant-table-body\"]")
	WebElement table;
	
	@FindBy(xpath="//p//span")
	List<WebElement> elements;
	
	@FindBy(xpath = "//*[name()=\"svg\" and @data-icon=\"delete\"]")
	WebElement deleteTruckButton;
	
	@FindBy(xpath = "//div[@id=\"delete_confirm\"]//input")
	WebElement deleteTruckInput;
	
	@FindBy(xpath = "//div[@class=\"action-buttons\"]//button[@label=\"Delete\"]")
	WebElement deleteTruckConfirm;
	
	@FindBy(xpath = "//span[text()=\"Action\"]")
	WebElement action;
	
	@FindBy(xpath = "//div[@class=\"px-8 py-2\"]//input")
	WebElement activateInput;
	
	@FindBy(xpath = "//div[@class=\"px-8 py-2\"]//button")
	WebElement activateButton;
	
	@FindBy(xpath = "//span[text()=\"Driver\"]")
	WebElement tableheaderdriver;
	
	@FindBy(xpath = "//input[@placeholder=\"Search Vehicle\"]")
	WebElement searchDeletedTruck;
	
	@FindBy(xpath = "//button[text()=\"Activate\"]")
	WebElement activateDeletedTruck;
	
	public void clickOnAddTruckDashboard()
	{
		starttime=System.currentTimeMillis();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("ant-table-content")));
		
		wait.until(ExpectedConditions.elementToBeClickable(addTruckButtonDashboard));
		
		totaltime=System.currentTimeMillis();
		
		totaltime=System.currentTimeMillis()-starttime;  //calcualting navingation time
		
		totaltime=totaltime/1000;   //for seconds conversion 
		
		PageLoadTime.GetMap().put("Trucks", String.valueOf(totaltime));
		
		log.info("Time taken to Load Vehicle Trucks Page : "+totaltime+" seconds");
		try
		{
		addTruckButtonDashboard.click();
		
		log.info("Clicked on Add Truck on Dashboard");
		}
		catch(Exception e)
		{
			Assert.fail("Unable to click on Add Truck Button on Truck Dashboard");
		}
	}
	public void EntertruckIdentifier()
	{
		try
		{
		wait.until(ExpectedConditions.visibilityOf(truckIdentifier));
		
		truckIdentifier.sendKeys(truckmap.get("Truck Identifier"));
		
		log.info("Entered Truck Identifier : "+truckmap.get("Truck Identifier"));
		}
		catch(Exception e)
		{
			Assert.fail("Unable to Enter Truck Identifier in New Truck Creation Prompt");
		}
	}
	public String EntervinNo() throws InterruptedException
	{
		try
		{
		wait.until(ExpectedConditions.elementToBeClickable(vinNo));
		
		vinNo.clear();
		
		vinNo.sendKeys(truckmap.get("VIN Number"));
		
		Thread.sleep(3000);
		
		log.info("Entered VIN Number : "+truckmap.get("VIN Number"));
		}
		catch(Exception e)
		{
			Assert.fail("Unable to Enter VIN Number in New Truck Creation Prompt");
		}
		try
		{
			String msg=driver.findElement(By.xpath("//div[@class=\"ant-form-explain\"]")).getText();
			if(msg.equalsIgnoreCase("Please enter complete and valid vin number"))
			{
				log.info("Received InValid VIN Number");
				return "Incorrect";
			}
		}
		catch (Exception e) {
			log.info("Received Valid VIN Number");
		}
		return "Correct";
	}
	public void EnterRegistrationNumber()
	{
		try
		{
		wait.until(ExpectedConditions.elementToBeClickable(regNo));
		
		regNo.sendKeys(truckmap.get("Registration No"));
		
		log.info("Entered Registration Number : "+truckmap.get("Registration No"));
		}
		catch(Exception e)
		{
			Assert.fail("Unable to Enter Registration Number in New Truck Creation Prompt");
		}
	}
	public void EnterInsuranceName()
	{
		try
		{
		wait.until(ExpectedConditions.elementToBeClickable(liabilityInsuranceName));
		
		liabilityInsuranceName.sendKeys(truckmap.get("Insurance Name"));
		
		log.info("Entered Insurance Name : "+truckmap.get("Insurance Name"));
		}
		catch(Exception e)
		{
			Assert.fail("Unable to Enter Insurance Name in New Truck Creation Prompt");
		}
	}
	public void EnterInsuranceNumber()
	{
		try
		{
		wait.until(ExpectedConditions.elementToBeClickable(liabilityInsuranceNo));
		
		liabilityInsuranceNo.sendKeys(truckmap.get("Insurance Number"));
		
		log.info("Entered Insurance Number : "+truckmap.get("Insurance Number"));
		}
		catch(Exception e)
		{
			Assert.fail("Unable to Enter Insurance Number in New Truck Creation Prompt");
		}
	}
	public void EnterCargoInsuranceName()
	{
		try
		{
		wait.until(ExpectedConditions.elementToBeClickable(cargoInsuranceName));
		
		cargoInsuranceName.sendKeys(truckmap.get("Cargo Insurance Name"));
		
		log.info("Entered Cargo Name : "+truckmap.get("Cargo Insurance Name"));
		}
		catch(Exception e)
		{
			Assert.fail("Unable to Enter Cargo Insurance Name in New Truck Creation Prompt");
		}
	}
	public void EnterCargoInsuranceNumber()
	{
		try
		{
		wait.until(ExpectedConditions.elementToBeClickable(cargoInsuranceNo));
		
		cargoInsuranceNo.sendKeys(truckmap.get("Cargo Insurance Number"));
		
		log.info("Entered Cargo Number : "+truckmap.get("Cargo Insurance Number"));
		}
		catch(Exception e)
		{
			Assert.fail("Unable to Enter Cargo Insurance Number in New Truck Creation Prompt");
		}
	}
	
	public void clickOnNextButton()
	{
		try
		{
		wait.until(ExpectedConditions.elementToBeClickable(nextButton));
		
		nextButton.click();
		
		log.info("Clicked On Next");
		}
		catch(Exception e)
		{
			Assert.fail("Unable to click on Next button of New Truck Creation Prompt");
		}
	}
	
	public void clickOnBackButton()
	{
		try
		{
		wait.until(ExpectedConditions.elementToBeClickable(backButton));
		
		backButton.click();
		
		log.info("Clicked On Back");
		}
		catch(Exception e)
		{
			Assert.fail("Unable to click on Back button of New Truck Creation Prompt");
		}
	}
	
	public void closePopUp() throws InterruptedException
	{
		try
		{
		wait.until(ExpectedConditions.elementToBeClickable(closepopup));
		
		closepopup.click();
		
		log.info("Clicked on Close button of Successfully Added Truck Pop Up");
		}
	
		catch(Exception e)
		{
			Assert.fail("Unable to click on close Pop up button of New Truck Creation Prompt");
		}
	}
	
	public String clickOnaddTruck() throws InterruptedException
	{
		try
		{
		wait.until(ExpectedConditions.elementToBeClickable(addTruck));
		
		addTruck.click();
		
		log.info("Clicked On Add Truck");
		}
		catch(Exception e)
		{
			Assert.fail("Unable to Click on Add Truck Button on Truck Dashboard");
		}
		
		Thread.sleep(2000);
		
		try
		{
			String msg=driver.findElement(By.xpath("//span[@class=\"ant-alert-description\"]")).getText();
			if(msg.equalsIgnoreCase("Asset number or vin number already exists"))
			{
				log.info("VIN Number already exists");
				return "duplicate";
				//Assert.assertFalse(true);
			}
		}
		catch (Exception e) {
			log.info("VIN Number added is Unique");
		}
		log.info("New Truck Added Successfully");
		return "unique";
	}
	
	public void searchTruckonDashboard() throws InterruptedException
	{
		try
		{
		Thread.sleep(5000);
		searchTruck.clear();
		searchTruck.sendKeys(truckmap.get("VIN Number"));
		log.info("Searching for Truck with VIN : "+truckmap.get("VIN Number"));
		Thread.sleep(2000);
		}
		catch(Exception e)
		{
			Assert.fail("Unable to Search Truck in Truck Dashboard");
		}
	}
	
	public boolean verifyTruckonDashboard() throws InterruptedException {
		
		Thread.sleep(5000);
		String vno = tabledata.get(1).getText();
		String chsno=tabledata.get(3).getText();
		//3TMJU62N86M017395  
		if(vno.equalsIgnoreCase(truckmap.get("Truck Identifier")) && chsno.equalsIgnoreCase(truckmap.get("VIN Number")))
		{
			log.info("New/Activated Truck validated successfully on Dashboard");
			return true;
		}
		else 
		{
			log.info("New/Activated Truck details incorrect on Dashboard");
			return false;
		}
			
	}
	public boolean verifyDeletedTruckonDashboard() throws InterruptedException {
		
		Thread.sleep(5000);
		try
		{
			String vno = tabledata.get(1).getText();
			String chsno=tabledata.get(3).getText();
			if(vno.equalsIgnoreCase(truckmap.get("Truck Identifier")) && chsno.equalsIgnoreCase(truckmap.get("VIN Number")))
			{
				log.info("New Truck validated successfully on Dashboard");
				return true;
			}
		}
		catch(Exception e)
		{
			log.info("Truck in not available on Dashboard");
			return false;
		}
		return false;
	}
	
	public boolean verifyTruckDetails() throws InterruptedException {
				
	//	Thread.sleep(5000);
		
		table.click();
		log.info("Clicked on result to get New Truck details");
		Thread.sleep(5000);
		
		String vno = (elements.get(1)).getText();
		String chsno=(elements.get(3)).getText();
		String regno=(elements.get(4)).getText();
		String Iname=(elements.get(6)).getText();
		String Inumber=(elements.get(7)).getText();
		String Cname=(elements.get(9)).getText();
		String Cnumber=(elements.get(10)).getText();
		
		if(vno.equalsIgnoreCase(truckmap.get("Truck Identifier")) && chsno.equalsIgnoreCase(truckmap.get("VIN Number")) &&
			regno.equalsIgnoreCase(truckmap.get("Registration No")) && Iname.equalsIgnoreCase(truckmap.get("Insurance Name")) &&
			Inumber.equalsIgnoreCase(truckmap.get("Insurance Number")) && Cname.equalsIgnoreCase(truckmap.get("Cargo Insurance Name")) &&
			Cnumber.equalsIgnoreCase(truckmap.get("Cargo Insurance Number")))
		{
			log.info("New Truck Validated Successfully on Vehicle Details");
			return true;
		}
		else 
		{
			log.info("New Truck details incorrect on Vehicle Details");
			return false;
		}
		
		
		
		
	}
public boolean DeleteTruck() throws InterruptedException  {
		
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", deleteTruckButton);
		
		(new Actions(driver)).moveToElement(deleteTruckButton);
		
		try
		{
		deleteTruckButton.click();
			
		log.info("Clicking on Delete Truck button on Dashboard");
		}
		catch(Exception e)
		{
			Assert.fail("Unable to click on Delete Truck Button On Truck Dashboard");
		}
		
		try
		{
		deleteTruckInput.sendKeys("DELETE");
		
		wait.until(ExpectedConditions.elementToBeClickable(deleteTruckConfirm));
		
		deleteTruckConfirm.click();
		
		log.info("Inserted Delete Command and clicked on confirm Delete");
		}
		catch(Exception e)
		{
			Assert.fail("Unable to click on Delete Truck Button On Delete Truck Prompt");
		}
		return false;
			
	}
	public void ActivateTruck() throws InterruptedException
	{
		starttime=System.currentTimeMillis();
		
		action.click();
		
		try
		{
			searchDeletedTruck.clear();
			
			searchDeletedTruck.sendKeys(truckmap.get("VIN Number"));
		}
		catch(Exception e)
		{
			Assert.fail("Unable to search deleted Truck on Deleted Truck Page");
		}
			
		totaltime=System.currentTimeMillis();
		
		totaltime=System.currentTimeMillis()-starttime;  //calcualting navingation time
		
		totaltime=totaltime/1000;   //for seconds conversion 
		
		PageLoadTime.GetMap().put("Deleted Trucks", String.valueOf(totaltime));
		
		log.info("Found deleted truck "+truckmap.get("VIN Number"));
		
		try
		{
			activateDeletedTruck.click();
			
			log.info("Clicked on Activate Truck Button");
		}
		catch(Exception e)
		{
			Assert.fail("Unable to click on Activate button on Delete Truck Page");
		}
		try
		{
			activateInput.sendKeys("ACTIVATE");
			
			log.info("Inserted Activate text in text box");
			
			Thread.sleep(2000);
			
			wait.until(ExpectedConditions.elementToBeClickable(activateButton));
			
			activateButton.click();
			
			log.info("Clicked on Activate Truck to reactivate Truck");
		}
		catch(Exception e)
		{
			Assert.fail("Unable to click on Activate Button on Activate Deleted Truck Prompt");
		}
	}
}
