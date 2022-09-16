package project.webpages;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import project.utility.PageLoadTime;

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
			
		wait=new WebDriverWait(driver,60);
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
		
		addTruckButtonDashboard.click();
		
		log.info("Clicked on Add Truck on Dashboard");
	}
	public void EntertruckIdentifier(String identifier)
	{
		wait.until(ExpectedConditions.elementToBeClickable(truckIdentifier));
		
		truckIdentifier.sendKeys(identifier);
		
		log.info("Entered Truck Identifier : "+identifier);
	}
	public String EntervinNo(String vin) throws InterruptedException
	{
		wait.until(ExpectedConditions.elementToBeClickable(vinNo));
		
		vinNo.clear();
		
		vinNo.sendKeys(vin);
		
		Thread.sleep(2000);
		
		log.info("Entered VIN Number : "+vin);
		
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
		
		log.info("Entered Registration Number : "+reg);
		
	}
	public void EnterInsuranceName(String name)
	{
		wait.until(ExpectedConditions.elementToBeClickable(liabilityInsuranceName));
		
		liabilityInsuranceName.sendKeys(name);
		
		log.info("Entered Insurance Name : "+name);
		
	}
	public void EnterInsuranceNumber(String number)
	{
		wait.until(ExpectedConditions.elementToBeClickable(liabilityInsuranceNo));
		
		liabilityInsuranceNo.sendKeys(number);
		
		log.info("Entered Insurance Number : "+number);
		
	}
	public void EnterCargoInsuranceName(String name)
	{
		wait.until(ExpectedConditions.elementToBeClickable(cargoInsuranceName));
		
		cargoInsuranceName.sendKeys(name);
		
		log.info("Entered Cargo Name : "+name);
		
	}
	public void EnterCargoInsuranceNumber(String number)
	{
		wait.until(ExpectedConditions.elementToBeClickable(cargoInsuranceNo));
		
		cargoInsuranceNo.sendKeys(number);
		
		log.info("Entered Cargo Number : "+number);
		
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
	
	public void searchTruckonDashboard(String vin) throws InterruptedException
	{
		Thread.sleep(5000);
		searchTruck.sendKeys(vin);
		log.info("Searching for Truck with VIN : "+vin);
		
	}
	
	public boolean verifyTruckonDashboard(HashMap<String,String> map) throws InterruptedException {
		
		Thread.sleep(5000);
		String vno = tabledata.get(1).getText();
		String chsno=tabledata.get(3).getText();
		if(vno.equalsIgnoreCase(map.get("identifier")) && chsno.equalsIgnoreCase(map.get("vinnum")))
		{
			log.info("New Truck validated successfully on Dashboard");
			return true;
		}
		else 
		{
			log.info("New Truck details incorrect on Dashboard");
			return false;
		}
			
	}
	
	
	public boolean verifyTruckDetails(HashMap<String,String> map) throws InterruptedException {
				
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
		
		if(vno.equalsIgnoreCase(map.get("identifier")) && chsno.equalsIgnoreCase(map.get("vinnum")) &&
			regno.equalsIgnoreCase(map.get("regno")) && Iname.equalsIgnoreCase(map.get("Iname")) &&
			Inumber.equalsIgnoreCase(map.get("Inumber")) && Cname.equalsIgnoreCase(map.get("Cname")) &&
			Cnumber.equalsIgnoreCase(map.get("Cnumber")))
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
	

}
