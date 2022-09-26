package project.webpages;

import java.time.Duration;
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
	
	@FindBy(xpath = "//button[@label=\"+ Add Trailer\"]")
	WebElement addTrailerButtonDashboard;
	
	@FindBy(id = "trailer_identifier") 
	WebElement trailerIdentifier;
	
	@FindBy(xpath = "//button[@label=\"Save\"]")
	WebElement saveButton;
	
	@FindBy(xpath = "//button[@label=\"No\"]")
	WebElement nomore;
	
	@FindBy(xpath = "//button[@label=\"Assign\"]")
	WebElement assignButton;
	
	@FindBy(id = "truck")
	WebElement truckDropdown;
	
	@FindBy(xpath = "//input[@type=\"text\"]")
	WebElement searchTrailer;
	
	@FindBy(xpath = "//ul//li[@role=\"option\"]")
	List<WebElement> options;
	
	@FindBy(xpath = "//button[@label=\"Unassign\"]")
	WebElement unassignButton;
	
	@FindBy(xpath = "//button[@label=\"Yes\"]")
	WebElement yesButton;
	
	@FindBy(xpath = "//button[@label=\"No\"]")
	WebElement noButton;
	
	@FindBy(xpath = "//tbody[@class=\"ant-table-tbody\"]//td")
	List<WebElement> dashtable;
		
	@FindBy(xpath = "//span[@class=\"ant-form-item-children\"]//input")
	WebElement deleteInput;
	
	@FindBy(xpath = "//a[@class=\"editTrailer\"]")
	WebElement editButton;
	
	@FindBy(xpath = "//a[@class=\"deleteTrailer\"]")
	WebElement deleteButtonOnDashboard;
		
	@FindBy(xpath = "//button[@label=\"Delete\"]")
	WebElement deleteButton;
	
	@FindBy(xpath = "//button[@label=\"Update\"]")
	WebElement updateButton;
	
	@FindBy(id = "trailer_identifier")
	WebElement edittraileridentifier;
	
	@FindBy(xpath = "//div[@id=\"activate_confirm\"]//input")
	WebElement activateInput;
	
	@FindBy(xpath = "//div[@class=\"action-buttons\"]//button[@label=\"Activate\"]")
	WebElement activateButton;
	
	@FindBy(xpath = "//span[text()=\"Action\"]")
	WebElement action;
	
	
	
	
	
	
	public void clickOnAddTrailerDashboard()
	{
		starttime=System.currentTimeMillis();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("ant-table-content")));
		
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
		wait.until(ExpectedConditions.elementToBeClickable(truckDropdown));
		
		truckDropdown.click();
		
		log.info("Clicked on Truck Dropdown in Assign Trailer");
	}
	public void SelectTruckFromDropDown(String identifier)
	{
		wait.until(ExpectedConditions.visibilityOfAllElements(options));
		
		for(WebElement ele : options)
		{
			if(identifier.equalsIgnoreCase(ele.getText()))
			{
				ele.click();
				log.info("Selected Truck "+identifier+" to assign tailer ");
			}
		}
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


	

	
	}
