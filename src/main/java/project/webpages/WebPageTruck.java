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
import project.mediator.TestData;

public class WebPageTruck {
	
		WebDriver driver;
		
		WebDriverWait wait,wait5;
	
		public static Logger log = Logger.getLogger(WebPageTruck.class);
		
		HashMap<String,String> truckmap;
	
	public WebPageTruck(WebDriver driverinstance)
	{
		driver=driverinstance;
			
		PageFactory.initElements(driver,this);
			
		wait=new WebDriverWait(driver,15);
		
		wait5=new WebDriverWait(driver,5);
		
		truckmap=TestData.GetVehicleData();
	}

	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement addTruckButtonDashboard;
	
	@FindBy(xpath = "//input[@label=\"Truck Number\"]")
	WebElement truckIdentifier;
	
	@FindBy(xpath = "//input[@label=\"VIN Number\"]")
	WebElement vinNo;
	
	@FindBy(xpath = "//button[text()=\"Next\"]")
	WebElement nextButton;
	
	@FindBy(xpath = "//button[text()=\"Add Truck\"]")
	WebElement addTruck;
	
	@FindBy(name = "regNo")
	WebElement regNo;
	
	@FindBy(className = "ant-calendar-input ")
	WebElement expiry;
	
	@FindBy(name = "liabilityInsuranceName")
	WebElement liabilityInsuranceName;
	
	@FindBy(name = "liabilityInsuranceNo")
	WebElement liabilityInsuranceNo;
	
	@FindBy(name = "cargoInsuranceName")
	WebElement cargoInsuranceName;
	
	@FindBy(name = "cargoInsuranceNo")
	WebElement cargoInsuranceNo;
	
	@FindBy(xpath = "//button[text()=\"Back\"]")
	WebElement backButton;
	
	@FindBy(xpath = "//*[name()=\"svg\" and @class=\"w-6 h-6 font-semibold absolute top-2 -right-2 cursor-pointer\"]")
	WebElement closepopup;
	
	@FindBy(xpath = "//input[@placeholder=\"Search Vehicle\"]")
	WebElement searchTruck;
	
	@FindBy(xpath="//tbody[@class=\"rc-table-tbody\"]//tr[@class=\"rc-table-row rc-table-row-level-0 text-base text-gray-400 bg-white border-b border-gray-100 h-12 w-full hover:bg-blue-tablerow focus:hover:bg-blue-tablerow rounded-md`\"]//td")
	List<WebElement> tabledata;
	
	@FindBy(xpath="//div[@class=\"ant-table-body\"]")
	WebElement table;
	
	@FindBy(xpath="//b//following::div[@class=\"text-blue-secondary font-black pl-1\"]")
	List<WebElement> elements;
	
	@FindBy(xpath = "//*[name()=\"svg\" and @class=\"w-5 h-5 cursor-pointer text-gray-400 hover:text-blue-primary\"]")
	WebElement deleteTruckButton;
	
	@FindBy(xpath = "//div[@class=\" pt-2\"]//input")
	WebElement deleteTruckInput;
	
	@FindBy(xpath = "//button[@type=\"submit\" and text()=\"Delete\"]")
	WebElement deleteTruckConfirm;
	
	@FindBy(xpath = "//div[@class=\"ml-10 mt-2\"]//span")
	WebElement action;
	
	@FindBy(xpath = "//div[@class=\"px-8 py-2 h-90%\"]//input")
	WebElement activateInput;
	
	@FindBy(xpath = "//div[@class=\"px-8 py-2 h-90%\"]//button")
	WebElement activateButton;
	
	@FindBy(xpath = "//span[text()=\"Driver\"]")
	WebElement tableheaderdriver;
	
	@FindBy(xpath = "//input[@placeholder=\"Search Vehicle\"]")
	WebElement searchDeletedTruck;
	
	@FindBy(xpath = "//button[text()=\"Activate\"]")
	WebElement activateDeletedTruck;
	
	public void clickOnAddTruckDashboard() throws InterruptedException
	{
		wait.until(ExpectedConditions.elementToBeClickable(action));
		
		driver.findElement(By.xpath("//div[@class=\"ml-10 mt-2\"]//span")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("rc-table-container")));
		
		wait.until(ExpectedConditions.elementToBeClickable(addTruckButtonDashboard));
		
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
		
		log.info("Entered VIN Number : "+truckmap.get("VIN Number"));
		}
		catch(Exception e)
		{
			Assert.fail("Unable to Enter VIN Number in New Truck Creation Prompt");
		}
		try
		{
			Thread.sleep(1000);
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
		wait5.until(ExpectedConditions.elementToBeClickable(closepopup));
		
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
			Assert.fail("Unable to Click on Add Truck Button on Truck Add Page");
		}
		
		//Thread.sleep(2000);
		
		try
		{
			Thread.sleep(2000);
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
		wait.until(ExpectedConditions.elementToBeClickable(action));
		action.click();
		wait.until(ExpectedConditions.elementToBeClickable(searchTruck));
		searchTruck.clear();
		//Thread.sleep(5000);

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
		
		try
		{
			
			wait.until(ExpectedConditions.visibilityOf(tabledata.get(1)));
			wait.until(ExpectedConditions.visibilityOf(tabledata.get(2)));
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
		catch(Exception e)
		{
			log.info("Caught Exception while Verify truck on Dashboard");
			Assert.fail("Caught Exception while Verify truck on Dashboard");
			return false;
		}
		
			
	}
	public boolean verifyDeletedTruckonDashboard() throws InterruptedException {
		
		Thread.sleep(3000);
		try
		{
		//	wait5.until(ExpectedConditions.visibilityOfAllElements(tabledata));
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
		try
		{
			wait.until(ExpectedConditions.visibilityOfAllElements(tabledata));
			wait.until(ExpectedConditions.elementToBeClickable(tabledata.get(1)));
			tabledata.get(1).click();
			log.info("Clicked on result to get New Truck details");
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfAllElements(elements));
			String vno = (elements.get(0)).getText();
			vno=vno.replace(".","");
			String chsno=(elements.get(2)).getText();
			String regno=(elements.get(6)).getText();
			String Iname=(elements.get(8)).getText();
			String Inumber=(elements.get(9)).getText();
			String Cname=(elements.get(11)).getText();
			String Cnumber=(elements.get(12)).getText();
			
			if((truckmap.get("Truck Identifier")).contains(vno) && chsno.equalsIgnoreCase(truckmap.get("VIN Number")) &&
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
		catch (Exception e) {
			log.info("Caught Exception while Verify Truck Details");
			return false;
		}
		
		
		
	}
public boolean DeleteTruck() throws InterruptedException  {
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(deleteTruckButton));
		try
		{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", deleteTruckButton);
		
		(new Actions(driver)).moveToElement(deleteTruckButton);
		
		
		deleteTruckButton.click();
			
		log.info("Clicking on Delete Truck button on Dashboard");
		}
		catch(Exception e)
		{
			Assert.fail("Unable to click on Delete Truck Button On Truck Dashboard");
		}
		
		try
		{
		Thread.sleep(2000);
		deleteTruckInput.sendKeys("DELETE");
		
		wait.until(ExpectedConditions.elementToBeClickable(deleteTruckConfirm));
		
		Thread.sleep(2500);
		
		deleteTruckConfirm.click();
		
		Thread.sleep(2500);
		
		log.info("Inserted Delete Command and clicked on confirm Delete");
		}
		catch(Exception e)
		{
			driver.navigate().refresh();
			Assert.fail("Unable to click on Delete Truck Button On Delete Truck Prompt");
		}
		return false;
			
	}
	public void ActivateTruck() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(action));

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
		log.info("Found deleted truck "+truckmap.get("VIN Number"));
		Thread.sleep(2000);
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
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(activateInput));

			activateInput.sendKeys("ACTIVATE");
			
			log.info("Inserted Activate text in text box");
			
			Thread.sleep(1000);
			
			wait.until(ExpectedConditions.elementToBeClickable(activateButton));
			
			activateButton.click();
			
			log.info("Clicked on Activate Truck to reactivate Truck");
		}
		catch(Exception e)
		{
			Assert.fail("Unable to click on Activate Button on Activate Deleted Truck Prompt");
		}
		driver.navigate().refresh();
	}
}
