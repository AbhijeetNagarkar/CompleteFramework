package project.webpages;

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

public class WebPageIFTAReports {

	WebDriverWait wait;
	
	WebDriver driver;

	public static Logger log = Logger.getLogger(WebPageIFTAReports.class);
	
	public WebPageIFTAReports(WebDriver driverinstance)
	{
		driver=driverinstance;
			
		PageFactory.initElements(driver,this);
			
		wait=new WebDriverWait(driver,10);
		
	}
	
	@FindBy(xpath = "//div[@class=\"flex items-center\"]//span[text()=\"Quick Selection\"]")
	WebElement filter;

	@FindBy(xpath = "//div[@class=\"flex pt-4 pb-2\"]//input")
	WebElement search;
	
	@FindBy(xpath = "//div[@class=\"ml-10 mt-2\"]//span[text()=\"IFTA Report\"]")
	WebElement changefocus;
	
	@FindBy(xpath = "//div[text()=\"Active Trucks\"]")
	WebElement activetruck;
	
	@FindBy(xpath = "//div[text()=\"Deleted Trucks\"]")
	WebElement deletedtruck;
	
	public boolean SearchandVerifyRecords() throws InterruptedException {
		// TODO Auto-generated method stub
		try
		{
			Thread.sleep(3000);
			search.clear();
			search.sendKeys("demo");
			Thread.sleep(2000);
		}
		catch (Exception e) {
			log.info("Caught Exception while search functionality of IFTA Report page");
			return false;
		}
		List<WebElement> ele = driver.findElements(By.xpath("//tbody//tr[@class=\"rc-table-row rc-table-row-level-0 text-base text-gray-400 bg-white border-b border-gray-100 h-12 w-full hover:bg-blue-tablerow focus:hover:bg-blue-tablerow rounded-md`\"]//div[@class=\"font-bold pl-2 text-xs lg:text-sm xl:text-base\"]"));
		
		
		for(WebElement element : ele)
		{
			if(element.getText().toLowerCase().contains("demo") || element.getText().toLowerCase().contains("all unit") )
			{
				continue;
			}
			else
			{	log.info("Search records not matched as per search text");
				search.clear();
				return false;
			}
				
		}
		log.info("Search records matched as per search text");
		search.clear();
		return true;
	}
	
	public boolean ActiveandDeletedTrucks()
	{
		List<WebElement> element;
		try
		{
			Thread.sleep(2000);
			activetruck.click();
			log.info("Clicked on Active truck option on IFTA report");
			Thread.sleep(2000);
			element=driver.findElements(By.xpath("//tbody//tr[@class=\"rc-table-row rc-table-row-level-0 text-base text-gray-400 bg-white border-b border-gray-100 h-12 w-full hover:bg-blue-tablerow focus:hover:bg-blue-tablerow rounded-md`\"]//div[@class=\"font-bold pl-2 text-xs lg:text-sm xl:text-base\"]"));
			if(element.size()>0)
			{
				log.info("Active trucks found on IFTA Report");
			}
			Thread.sleep(2000);
			deletedtruck.click();
			log.info("Clicked on Deleted truck option in IFTA report");
			Thread.sleep(2000);
			element=driver.findElements(By.xpath("//tbody//tr[@class=\"rc-table-row rc-table-row-level-0 text-base text-gray-400 bg-white border-b border-gray-100 h-12 w-full hover:bg-blue-tablerow focus:hover:bg-blue-tablerow rounded-md`\"]//div[@class=\"font-bold pl-2 text-xs lg:text-sm xl:text-base\"]"));
			if(element.size()>0)
			{
				log.info("Deleted trucks found on IFTA Report");
			}
			activetruck.click();
			return true;
		}
		catch (Exception e) {
			// TODO: handle exception
			log.info("Unable to get list of Active and Deleted trucks on IFTA Report Page");
			return false;
		}
	}
	public boolean VerifyDownloadReport()
	{
		try
		{			Thread.sleep(2000);
			List<WebElement> element;
			element=driver.findElements(By.xpath("//tbody//tr[@class=\"rc-table-row rc-table-row-level-0 text-base text-gray-400 bg-white border-b border-gray-100 h-12 w-full hover:bg-blue-tablerow focus:hover:bg-blue-tablerow rounded-md`\"]//div[@class=\"font-bold pl-2 text-xs lg:text-sm xl:text-base\"]"));
			element.get(0).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[text()=\"Go\"]")).click();
			log.info("Clicked on Download button on IFTA report");
			
			try
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"ant-message-notice\"]//span")));
				if(driver.findElement(By.xpath("//div[@class=\"ant-message-notice\"]//span")).getText().equalsIgnoreCase("IFTA Report Download Started."))
				{	log.info("IFTA Report downloaded");
					return true;
				}
				else 
				{	log.info("unable to download report");
					return false;
				}
				
			}
			catch (NoSuchElementException e) {
				// TODO: handle exception
				log.info("Report is downloaded");
			}
			return true;
		}
		catch (Exception e) {
			// TODO: handle exception
			log.info("IFTA Report download functionality not working");
			return false;
		}
		
		
	}
	
}
