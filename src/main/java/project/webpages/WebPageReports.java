package project.webpages;

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

public class WebPageReports {

	WebDriver driver;
	
	WebDriverWait wait;
	
	public static Logger log = Logger.getLogger(WebPageReports.class);
	
	public WebPageReports(WebDriver driverinstance)
	{
			driver=driverinstance;
			
			PageFactory.initElements(driver,this);
			
			wait = new WebDriverWait(driver,10);
			
	}

	@FindBy(xpath = "//input")
	WebElement search;
	
	@FindBy(xpath = "//div[@class=\"ml-10 mt-2\"]//span[text()=\"Reports\"]")
	WebElement changefocus;
	
	public void ClickOnDriverSafety()  throws InterruptedException
	{
		Goto("Driver Safety");
	}
	public void ClickOnDutyStatusSummary()  throws InterruptedException
	{
		Goto("Duty Status Summary");		
	}
	public void ClickOnELDLogbookEdits()   throws InterruptedException
	{
		Goto("ELD - Logbook Edits");
	}
	public void ClickOnFuelEfficiency()  throws InterruptedException
	{
		Goto("Fuel Efficiency");
	}
	public void ClickOnHOSCompliance()  throws InterruptedException
	{
		Goto("HOS Compliance");
	}
	public void ClickOnIdleTime()  throws InterruptedException
	{
		Goto("Idle Time");
	}
	public void ClickOnPostTripDVIR()  throws InterruptedException
	{
		Goto("Post-Trip DVIR");
	}
	public void ClickOnPreTripDVIR()  throws InterruptedException
	{
		Goto("Pre-Trip DVIR");
	}
	public void ClickOnTemperatureHumidity()  throws InterruptedException
	{
		Goto("Temperature & Humidity");
	}
	public void ClickOnTripHistory()  throws InterruptedException
	{
		Goto("Trip History");
	}
	public void ClickOnUtilization() throws InterruptedException
	{
		Goto("Utilization");
	}	
	
	private void Goto(String string) throws InterruptedException {
		// TODO Auto-generated method stub
		try
		{
			driver.findElement(By.xpath("//div[@class=\"ml-10 mt-2\"]//span")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a//span[text()='"+string+"']")));
			driver.findElement(By.xpath("//a//span[text()='"+string+"']")).click();
			log.info("Clicked on "+string+" report");
			Thread.sleep(5000);
		}
		catch (Exception e) {
			// TODO: handle exception
			try
			{
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a//span[text()='"+string+"']")));

				driver.findElement(By.xpath("//a//span[text()='"+string+"']")).click();
				log.info("Clicked on "+string+" report");
				Thread.sleep(5000);
			}
			catch (Exception e1) {
				log.info("Caught Exception - Unable to navigate "+string+" report page");
				Assert.fail("Caught Exception - Unable to navigate "+string+" report page");
				
			}
		}
	}
	
	public Boolean search() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class=\"ml-10 mt-2\"]//span")).click();
		Thread.sleep(1000);

		search.sendKeys("Driver Safety");
		
		Thread.sleep(4000);
		
		List<WebElement> ele = driver.findElements(By.xpath("//a//span"));
		
		for(WebElement element : ele)
		{
			if(element.getText().equalsIgnoreCase("Driver Safety"))
			{
				continue;
			}
			else
			{
				log.info("Search result not as per search criteria");
				return false;
			}
		}
		log.info("Search result as per search criteria");
		return true;
	}
}
