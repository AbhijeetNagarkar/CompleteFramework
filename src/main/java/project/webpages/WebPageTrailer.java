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
import org.testng.Assert;

import project.mediator.PageLoadTime;
import project.mediator.TestData;

public class WebPageTrailer {
	
	WebDriver driver;
	
	WebDriverWait wait;

	public static Logger log = Logger.getLogger(WebPageTrailer.class);
	
	long starttime=0;
	
	long totaltime=0;
	
	HashMap<String,String> trailermap,truckmap;
	
	public WebPageTrailer(WebDriver driverinstance)
	{
		driver=driverinstance;
			
		PageFactory.initElements(driver,this);
			
		wait=new WebDriverWait(driver,10);
		
		trailermap = TestData.GetTrailerData();
		
		truckmap = TestData.GetVehicleData();
	}
	
	@FindBy(xpath = "//button[text() =\"+ Add Trailer\"]")
	WebElement addTrailerButtonDashboard;
	
	@FindBy(xpath = "//input[@label=\"Trailer Identifier\"]") 
	WebElement trailerIdentifier;
	
	@FindBy(xpath = "//button[text()=\"Save\"]")
	WebElement saveButton;
	
	@FindBy(xpath = "//button[@label=\"No\"]")
	WebElement nomore;
	
	@FindBy(xpath = "//button[text()=\"Assign\"]")
	WebElement assignButton;
	
	@FindBy(xpath = "//div[@class=\" css-1wy0on6\"]//*[name()=\"svg\"]")
	WebElement truckDropdown;
	
	@FindBy(xpath = "//input[@placeholder=\"Search Vehicle\"]")
	WebElement searchTrailer;
	
	@FindBy(xpath = "//ul//li[@role=\"option\"]")
	List<WebElement> options;
	
	@FindBy(xpath = "//button[text()=\"Unassign\"]")
	WebElement unassignButton;
	
	@FindBy(xpath = "//button[text()=\"Yes\"]")
	WebElement yesButton;
	
	@FindBy(xpath = "//button[text()=\"No\"]")
	WebElement noButton;
	
	@FindBy(xpath = "//td[@class=\"rc-table-cell\"]//div")
	List<WebElement> dashtable;
		
	@FindBy(xpath = "//div[@class=\"relative w-full h-full\"]//input")
	WebElement deleteInput;
	
	@FindBy(xpath = "//button[text()=\"Edit\"]")
	WebElement editButton;
	
	@FindBy(xpath = "//button[text()=\"Delete\"]")
	WebElement deleteButtonOnDashboard;
		
	@FindBy(xpath = "//div[@class=\"relative w-full h-full\"]//button[text()=\"Delete\"]")
	WebElement deleteButton;
	
	@FindBy(xpath = "//button[text()=\"Update\"]")
	WebElement updateButton;
	
	@FindBy(xpath = "//input[@label=\"Trailer Identifier\"]")
	WebElement edittraileridentifier;
	
	@FindBy(xpath = "//div[@class=\"relative w-full h-full\"]//input")
	WebElement activateInput;
	
	@FindBy(xpath = "//div[@class=\"relative w-full h-full\"]//button")
	WebElement activateButton;
	
	@FindBy(xpath = "//div[text()=\"Action\"]")
	WebElement action;
	
	@FindBy(xpath = "//span[text()=\"Action\"]")
	WebElement spanaction;
	
	
	public void clickOnAddTrailerDashboard()
	{
		starttime=System.currentTimeMillis();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("rc-table-tbody")));
		
		wait.until(ExpectedConditions.elementToBeClickable(addTrailerButtonDashboard));
		
		totaltime=System.currentTimeMillis();
		
		totaltime=System.currentTimeMillis()-starttime; 
		
		totaltime=totaltime/1000;   //for seconds conversion 
		
		PageLoadTime.GetMap().put("Trailer", String.valueOf(totaltime));
		
		log.info("Time taken to Load Vehicle Trailer Page : "+totaltime+" seconds");
		try
		{
			addTrailerButtonDashboard.click();
			
			log.info("Clicked on Add Trailer on Dashboard");
		}
		catch(Exception e)
		{
			Assert.fail("Unable to Click on Add Trailer button on Dashboard");
		}
	}
	
	public void EntertrailerIdentifier()
	{
		try
		{
		wait.until(ExpectedConditions.elementToBeClickable(trailerIdentifier));
		
		trailerIdentifier.sendKeys(trailermap.get("Trailer Identifier"));
		
		log.info("Entered Trailer Identifier : "+trailermap.get("Trailer Identifier"));
		}
		catch(Exception e)
		{
			Assert.fail("Unable to Enter Trailer Identifier");
		}
	}
	
	public void ClickOnSave()
	{
		try 
		{
			
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		
		saveButton.click();
		
		log.info("Clicked on Save Trailer Button");
		
		Thread.sleep(3000);
		
		} 
		catch (InterruptedException e) {
			Assert.fail("Unable to click on Save Button of New Trailer creation");
		}
	}
	
	public void ClickOnUpdate()
	{
		try 
		{
		Thread.sleep(3000);
		
		updateButton.click();
		
		log.info("Clicked on Update Trailer Button");
		
		Thread.sleep(3000);
		} 
		catch (InterruptedException e) {
			Assert.fail("Unable to click on Update Button of Edit Trailer");
		}
	}
	
	public void SearchTrailer() throws InterruptedException
	{
		try
		{
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.elementToBeClickable(searchTrailer));
		
		searchTrailer.clear();
		
		searchTrailer.sendKeys(trailermap.get("Trailer Identifier"));
		
		log.info("Search Trailer : "+trailermap.get("Trailer Identifier") );
		}
		catch(Exception e)
		{
			Assert.fail("Unable to Search Trailer on Dashboard");
		}
	}

	public void ClickOnTruckDropdown()
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(truckDropdown));
			
			truckDropdown.click();
			
			Thread.sleep(2000);
			
			log.info("Clicked on Truck Dropdown in Assign Trailer");
		}
		catch(Exception e)
		{
			Assert.fail("Unable to click on Truck Dropdown of Assign Truck");
		}
	}
	
	public String SelectTruckFromDropDown() throws InterruptedException
	{
		try
		{
		Thread.sleep(2000);
		
		driver.findElements(By.xpath("//div[@class=\" css-1u0owcj-option\"]//div//span[text()='"+truckmap.get("Truck Identifier")+"']")).get(0).click();
		}
		catch(Exception e)
		{
			Assert.fail("Unable to select truck to Assign Trailer");
		}
		return truckmap.get("Truck Identifier");
	}

	public void ClickOnNoMore() throws InterruptedException
	{
		try
		{
		wait.until(ExpectedConditions.elementToBeClickable(nomore));
		
		nomore.click();
		
		log.info("Clicked on No More Additional Trailer Button");
		}
		catch(Exception e)
		{
			Assert.fail("Unable to click on No More Trailer Creation");
		}
		Thread.sleep(3000);
	}

	public void ClickOnYes() throws InterruptedException
	{
		try
		{
		wait.until(ExpectedConditions.elementToBeClickable(yesButton));
		
		yesButton.click();
		
		log.info("Clicked on Yes to confirm ");
		}
		catch(Exception e)
		{
			Assert.fail("Unable to click on Yes to Confirm");
		}
		Thread.sleep(3000);
	}
	
	public void ClickOnNo() throws InterruptedException
	{
		try
		{
		wait.until(ExpectedConditions.elementToBeClickable(noButton));
		
		noButton.click();
		
		log.info("Clicked on No to confirm ");
		}
		catch(Exception e)
		{
			Assert.fail("Unable to click on No to Confirm prompt");
		}
		Thread.sleep(3000);
	}
	
	public void ClickOnAssign()
	{
		try
		{
		action.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(assignButton));
		
		assignButton.click();
		
		log.info("Clicked on Assign Trailer Button");
		}
		catch(Exception e)
		{
			Assert.fail("Unable to click On Assign button of Trailer page");
		}
	}

	public void ClickOnUnAssign()
	{
		try
		{
		wait.until(ExpectedConditions.elementToBeClickable(unassignButton));
		
		unassignButton.click();
		
		log.info("Clicked on Un Assign Trailer Button");
		}
		catch(Exception e)
		{
			Assert.fail("Unable to click on UnAssign button of Trailer Page");
		}
	}

	public boolean VerifyUnAssignedTrailerOnDashboard() throws InterruptedException 
	{
			try
			{
				wait.until(ExpectedConditions.elementToBeClickable(assignButton));
			}
			catch(Exception e)
			{
				
			}
			return VerifyTrailer(trailermap.get("Trailer Identifier"),"");
	}
	
	public boolean VerifyAssignedTrailerOnDashboard() throws InterruptedException 
	{
			try
			{
			 wait.until(ExpectedConditions.elementToBeClickable(unassignButton)); // switch unassign
			}
			catch(Exception e)
			{
				
			}
			return VerifyTrailer(trailermap.get("Trailer Identifier"),truckmap.get("Truck Identifier"));
		
	}
	
	public boolean VerifyTrailer(String vin, String string) throws InterruptedException
	{	
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//span[text()=\"Attached Truck\"]")).click();
	
		if(vin.equalsIgnoreCase(dashtable.get(0).getText()))
		{
				if(string.equals(""))
				{
					return true;
				}
				else if(string.equalsIgnoreCase(dashtable.get(1).getText()))
				{
					return true;
				}
		}
		return false;
	}
	
	public void DeleteTrailer() throws InterruptedException
	{
		try
		{
		wait.until(ExpectedConditions.elementToBeClickable(deleteButtonOnDashboard));
		
		deleteButtonOnDashboard.click();
		
		log.info("Clicked on Delete Trailer Button");
		}
		catch(Exception e)
		{
			Assert.fail("Unable to click on Delete Trailer button on Trailer Page");
		}
		Thread.sleep(2000);
		try
		{
		deleteInput.sendKeys("DELETE");
		
		Thread.sleep(2000);
		
		deleteButton.click();
		
		log.info("Inserted Delete text and clicked on Delete button");
		}
		catch(Exception e)
		{
			Assert.fail("Unable to click on Delete Button of Delete Prompt");
		}
		Thread.sleep(3000);
	}
	
	public boolean VerifyDeletedTrailer()
	{
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(assignButton));
		}
		catch(Exception e)
		{
			return true;
		}
		return false;
	}
	
	public void EditTrailer() throws InterruptedException
	{
		try
		{
		action.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(editButton));
		
		editButton.click();
		
		log.info("Clicked on Edit Trailer button ");
		
		Thread.sleep(2000);
		}
		catch(Exception e)
		{
			Assert.fail("Unable to click on Edit Trailer Button");
		}
		
		trailermap.put("Trailer Identifier",(trailermap.get("Trailer Identifier"))+"123");
		
		try
		{
		edittraileridentifier.clear();
		
		edittraileridentifier.sendKeys(trailermap.get("Trailer Identifier"));
		
		Thread.sleep(3000);
		
		updateButton.click();
		
		log.info("Clicked on Update trailer button");
		
		Thread.sleep(3000);
		
		action.click();
		}
		catch(Exception e)
		{
			Assert.fail("Unable to click on Update trailer button on Edit prompt");
		}
	}

	public void ActivateTrailer() throws InterruptedException
	{
		spanaction.click();
		
		starttime=System.currentTimeMillis();
		try
		{
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tr//td//div[text()='"+trailermap.get("Trailer Identifier")+"']")));
		
		driver.findElement(By.xpath("//tr//td//div[text()='"+trailermap.get("Trailer Identifier")+"']")).click();
		}
		catch(Exception e)
		{
			Assert.fail("Unable to find deleted trailer on Deleted Trailer Page");
		}
		totaltime=System.currentTimeMillis();
		
		totaltime=System.currentTimeMillis()-starttime;  //calcualting navingation time
		
		totaltime=totaltime/1000;   //for seconds conversion 
		
		PageLoadTime.GetMap().put("Deleted Trailers", String.valueOf(totaltime));
		
		log.info("Found deleted trailer "+trailermap.get("Trailer Identifier"));
		
		Thread.sleep(2000);
		
		try
		{		
		driver.findElements(By.xpath("//tr//td//div[text()='"+trailermap.get("Trailer Identifier")+"']//following::button")).get(0).click();
		
		log.info("Clicked on Activate Trailer Button");
		}
		catch(Exception e)
		{
			Assert.fail("Unable to click on Activate Trailer button on Delete Trailer Page");
		}
		Thread.sleep(2000);
		
		try
		{
		activateInput.sendKeys("ACTIVATE");
		
		log.info("Inserted Activate text in text box");
		
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.elementToBeClickable(activateButton));
		
		activateButton.click();
		
		log.info("Clicked on Activate Trailer to reactivate trailer");
		}
		catch(Exception e)
		{
			Assert.fail("Unable to click on Activate button on Activate Trailer Prompt");
		}
	}
	public void changeFocus()
	{
		action.click();
	}
}
