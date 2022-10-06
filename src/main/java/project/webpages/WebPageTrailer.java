package project.webpages;

import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import project.utility.PageLoadTime;

public class WebPageTrailer {
	
	WebDriver driver;
	
	WebDriverWait wait;

	public static Logger log = Logger.getLogger(WebPageTrailer.class);
	
	long starttime=0;
	
	long totaltime=0;
	
	public WebPageTrailer(WebDriver driverinstance)
	{
		driver=driverinstance;
			
		PageFactory.initElements(driver,this);
			
		wait=new WebDriverWait(driver,20);
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
	
	@FindBy(xpath = "//tbody[@class=\"rc-table-tbody\"]//td[@class=\"rc-table-cell\"]//div")
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
		
		addTrailerButtonDashboard.click();
		
		log.info("Clicked on Add Trailer on Dashboard");
	}
	
	public void EntertrailerIdentifier(String identifier)
	{
		wait.until(ExpectedConditions.elementToBeClickable(trailerIdentifier));
		
		trailerIdentifier.sendKeys(identifier);
		
		log.info("Entered Trailer Identifier : "+identifier);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void SearchTrailer(String trailername) throws InterruptedException
	{
		
		
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.elementToBeClickable(searchTrailer));
		
		searchTrailer.clear();
		
		searchTrailer.sendKeys(trailername);
		
		log.info("Search Trailer : "+trailername);
	}
		

	
	public void ClickOnTruckDropdown()
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(truckDropdown));
			
			truckDropdown.click();
			
			log.info("Clicked on Truck Dropdown in Assign Trailer");
		}
		catch(Exception e)
		{
			
		}
		
	}
	public String SelectTruckFromDropDown()
	{
		List<WebElement> op=driver.findElements(By.xpath("//div[@class=\" css-1u0owcj-option\"]//div//span"));
		
	//	System.out.println(op.size());
		
	//	op.get(0).click();
		
		return op.get(0).getText();
		
		/*
		if(op.size() == 0)
		{	ClickOnTruckDropdown();
		}
		for(WebElement ele : op)
		{
			if(identifier.equalsIgnoreCase(ele.getText()))
			{
				try
				{
					ele.click();
					log.info("Selected Truck "+identifier+" to assign tailer ");
					break;
				}
				catch(Exception e)
				{
					ClickOnTruckDropdown();
					ele.click();
					log.info("Selected Truck "+identifier+" to assign tailer ");
					break;
				}
			}
			
		}*/
		
	}


	public void ClickOnNoMore() throws InterruptedException
	{
		wait.until(ExpectedConditions.elementToBeClickable(nomore));
		
		nomore.click();
		
		log.info("Clicked on No More Additional Trailer Button");
		
		Thread.sleep(3000);
	}


	public void ClickOnYes() throws InterruptedException
	{
		wait.until(ExpectedConditions.elementToBeClickable(yesButton));
		
		yesButton.click();
		
		log.info("Clicked on Yes to confirm ");
		
		Thread.sleep(3000);
	}
	
	public void ClickOnNo() throws InterruptedException
	{
		wait.until(ExpectedConditions.elementToBeClickable(noButton));
		
		noButton.click();
		
		log.info("Clicked on No to confirm ");
		
		Thread.sleep(3000);
		
	}
	public void ClickOnAssign()
	{
		action.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(assignButton));
		
		assignButton.click();
		
		log.info("Clicked on Assign Trailer Button");
	}

	public void ClickOnUnAssign()
	{
		wait.until(ExpectedConditions.elementToBeClickable(unassignButton));
		
		unassignButton.click();
		
		log.info("Clicked on Un Assign Trailer Button");
	}

	public boolean VerifyUnAssignedTrailerOnDashboard(String vin, String string) throws InterruptedException 
	{
			try
			{
				wait.until(ExpectedConditions.elementToBeClickable(assignButton));
			}
			catch(Exception e)
			{
				
			}
			return VerifyTrailer(vin,string);
	}
	public boolean VerifyAssignedTrailerOnDashboard(String vin, String string) throws InterruptedException 
	{
			try
			{
			 wait.until(ExpectedConditions.elementToBeClickable(unassignButton)); // switch unassign
			}
			catch(Exception e)
			{
				
			}
			return VerifyTrailer(vin,string);
		
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
				else if(string.equalsIgnoreCase(dashtable.get(0).getText()))
				{
					System.out.println();
					return true;
				}
		}
		return false;
		
	}
	
	public void DeleteTrailer() throws InterruptedException
	{
		wait.until(ExpectedConditions.elementToBeClickable(deleteButtonOnDashboard));
		
		deleteButtonOnDashboard.click();
		
		log.info("Clicked on Delete Trailer Button");
		
		Thread.sleep(2000);
		
		deleteInput.sendKeys("DELETE");
		
		Thread.sleep(2000);
		
		deleteButton.click();
		
		log.info("Inserted Delete text and clicked on Delete button");
		
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
	
	public void EditTrailer(String trailerno) throws InterruptedException
	{
		action.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(editButton));
		
		editButton.click();
		
		log.info("Clicked on Edit Trailer button ");
		
		Thread.sleep(2000);
		
		edittraileridentifier.clear();
		
		edittraileridentifier.sendKeys(trailerno);
		
		Thread.sleep(3000);
		
		updateButton.click();
		
		log.info("Clicked on Update trailer button ");
		
		Thread.sleep(3000);
		
		action.click();
		
	}

	public void ActivateTrailer(String trailerno) throws InterruptedException
	{
		
		spanaction.click();
		
		starttime=System.currentTimeMillis();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tr//td//div[text()='"+trailerno+"']")));
		
		driver.findElement(By.xpath("//tr//td//div[text()='"+trailerno+"']")).click();
		
		totaltime=System.currentTimeMillis();
		
		totaltime=System.currentTimeMillis()-starttime;  //calcualting navingation time
		
		totaltime=totaltime/1000;   //for seconds conversion 
		
		PageLoadTime.GetMap().put("Deleted Trailers", String.valueOf(totaltime));
		
		log.info("Found deleted trailer "+trailerno);
		
		Thread.sleep(2000);
		
		driver.findElements(By.xpath("//tr//td//div[text()='"+trailerno+"']//following::button")).get(0).click();
		
		log.info("Clicked on Activate Trailer Button");
		
		Thread.sleep(2000);
		
		activateInput.sendKeys("ACTIVATE");
		
		log.info("Inserted Activate text in text box");
		
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.elementToBeClickable(activateButton));
		
		activateButton.click();
		
		log.info("Clicked on Activate Trailer to reactivate trailer");
	}
	public void changeFocus()
	{
		action.click();
	}


	

	
	}