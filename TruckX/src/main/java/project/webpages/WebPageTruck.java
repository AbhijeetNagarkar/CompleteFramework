package project.webpages;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import project.utility.Driver;




public class WebPageTruck {
	
		WebDriver driver;
		
		WebDriverWait wait;
	
		public static Logger log = Logger.getLogger(WebPageTruck.class);
		
		long starttime=0;
		
		long totaltime=0;
	
	public WebPageTruck(WebDriver driverinstance)
	{
			driver=driverinstance;
			
			PageFactory.initElements(driver,this);
			
			wait=new WebDriverWait(driver,30);
			
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
	
	@FindBy(xpath = "//input[@type=\"text\"]")
	WebElement searchTruck;
	
	@FindBy(id = "cargoInsuranceName")
	WebElement cargoInsuranceName;
	
	@FindBy(id = "cargoInsuranceNo")
	WebElement cargoInsuranceNo;
	
	@FindBy(xpath = "//button[@label=\"Back\"]")
	WebElement backButton;
	
	@FindBy(xpath = "//img[@class=\"closeModalIcon\"]")
	WebElement closepopup;
	
	
	
	public void clickOnAddTruckDashboard()
	{
		wait.until(ExpectedConditions.elementToBeClickable(addTruckButtonDashboard));
		
		addTruckButtonDashboard.click();
		
		log.info("Clicked on Add Truck on Dashboard");
	}
	public void EntertruckIdentifier(String identifier)
	{
		wait.until(ExpectedConditions.elementToBeClickable(truckIdentifier));
		
		truckIdentifier.sendKeys(identifier);
		
		log.info("Entered Truck Identifier "+identifier);
	}
	public String EntervinNo(String vin) throws InterruptedException
	{
		wait.until(ExpectedConditions.elementToBeClickable(vinNo));
		
		vinNo.clear();
		
		vinNo.sendKeys(vin);
		
		Thread.sleep(2000);
		
		log.info("Entered VIN Number "+vin);
		
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
	public void EnterRegistrationNumber(String reg)
	{
		wait.until(ExpectedConditions.elementToBeClickable(regNo));
		
		regNo.sendKeys(reg);
		
		log.info("Entered Registration Number "+reg);
		
	}
	public void EnterInsuranceName(String name)
	{
		wait.until(ExpectedConditions.elementToBeClickable(liabilityInsuranceName));
		
		liabilityInsuranceName.sendKeys(name);
		
		log.info("Entered Insurance Name "+name);
		
	}
	public void EnterInsuranceNumber(String number)
	{
		wait.until(ExpectedConditions.elementToBeClickable(liabilityInsuranceNo));
		
		liabilityInsuranceNo.sendKeys(number);
		
		log.info("Entered Insurance Name "+number);
		
	}
	public void EnterCargoInsuranceName(String name)
	{
		wait.until(ExpectedConditions.elementToBeClickable(cargoInsuranceName));
		
		cargoInsuranceName.sendKeys(name);
		
		log.info("Entered Insurance Name "+name);
		
	}
	public void EnterCargoInsuranceNumber(String number)
	{
		wait.until(ExpectedConditions.elementToBeClickable(cargoInsuranceNo));
		
		cargoInsuranceNo.sendKeys(number);
		
		log.info("Entered Insurance Name "+number);
		
	}
	
	public void clickOnNextButton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(nextButton));
		
		nextButton.click();
		
		log.info("Clicked On Next");
	}
	
	public void clickOnBackButton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(backButton));
		
		backButton.click();
		
		log.info("Clicked On Back");
	}
	
	public void closePopUp() throws InterruptedException
	{
		wait.until(ExpectedConditions.elementToBeClickable(closepopup));
		
		closepopup.click();
		
		log.info("Clicked on Close button of Successfully Added Truck Pop Up");
	}
	
	public String clickOnaddTruck() throws InterruptedException
	{
		wait.until(ExpectedConditions.elementToBeClickable(addTruck));
		
		addTruck.click();
		
		log.info("Clicked On Add Truck");
		
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
	
	public void verifyTruckonDashboard(HashMap map) {
		// TODO Auto-generated method stub
		
	}
	public void verifyTruckDetails(HashMap map) {
		// TODO Auto-generated method stub
		
	}
	

}
