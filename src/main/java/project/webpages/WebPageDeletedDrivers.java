package project.webpages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import project.mediator.Driver;

public class WebPageDeletedDrivers {

WebDriver driver;
	
	WebDriverWait wait;
	
	public static Logger log = Logger.getLogger(WebPageDeletedDrivers.class);
	
	public WebPageDeletedDrivers(WebDriver driverinstance)
	{
			driver=driverinstance;
			
			PageFactory.initElements(driver,this);
			
			wait = new WebDriverWait(driver,10);
			
	}

	@FindBy(xpath = "//input")
	WebElement search;
	
	@FindBy(xpath = "//td[@class=\"rc-table-cell\"]//*[text()=\"View Logbook\"]")
	List<WebElement> viewlogbook;
	
	@FindBy(xpath = "//div[@class=\"ml-10 mt-2\"]//span")
	WebElement changefocus;
	
	
	public Boolean search() throws InterruptedException
	{
		try
		{
			
			Thread.sleep(5000);
			
			changefocus.click();
			
			Thread.sleep(1000);
			search.clear();
			
			search.sendKeys("test");
			
			log.info("Entered Driver name in search box");
			
			Thread.sleep(3000);
			
			return true;
		}
		catch (Exception e) {

			log.info("Caught Exception while Search Deleted Drivers");
			return false;
		}
	}
	public Boolean verifyResult() throws InterruptedException
	{
		Thread.sleep(2000);
		
		changefocus.click();
		
		List<WebElement> rows = driver.findElements(By.xpath("//tr[@class=\"ant-table-row ant-table-row-level-0\"]//td[@class=\"ant-table-column-has-actions ant-table-column-has-sorters ant-table-row-cell-break-word\"]"));
	
		log.info("Captured result into list");
		
		for(WebElement ele : rows)
		{
			String text = ele.getText().toLowerCase();
			
			if(text.contains("test"))
			{
				continue;
			}
			else
			{	log.info("Result is not as per search criteria");
				return false;
			}
		}
		log.info("Result is as per search criteria");
		return true;
	}
	public Boolean verifyLogbook() throws InterruptedException
	{
		try
		{
			Thread.sleep(2000);
			
			changefocus.click();
			
			Thread.sleep(4000);
			
			driver.findElements(By.xpath("//td[@class=\"rc-table-cell\"]//*[text()=\"View Logbook\"]")).get(0).click();
			
		//	viewlogbook.get(0).click();
			Thread.sleep(5000);
		}
		catch (Exception e) {
			log.info("Caught Exception while VerifyLogBok of Deleted Drivers");
			return false;
		}
		if(driver.getCurrentUrl().equalsIgnoreCase("https://web.truckx.com/#/app/log-book/timelog-details"))
		{
			log.info("Able to navigate view Logbook of Deleted Drivers Page");
			driver.navigate().back();
			log.info("Navigating back to Deleted Drivers page");
			Thread.sleep(2000);
			Driver.Refresh();
			return true;
		}
		else
		{
			driver.navigate().back();
			Thread.sleep(2000);
			Driver.Refresh();
			changefocus.click();
			
			Thread.sleep(4000);
			
			driver.findElements(By.xpath("//td[@class=\"rc-table-cell\"]//*[text()=\"View Logbook\"]")).get(0).click();
			
			if(driver.getCurrentUrl().equalsIgnoreCase("https://web.truckx.com/#/app/log-book/timelog-details"))
			{
				log.info("Able to navigate view Logbook of Deleted Drivers Page");
				driver.navigate().back();
				log.info("Navigating back to Deleted Drivers page");
				Thread.sleep(2000);
				Driver.Refresh();
				return true;
			}
			else
			log.info("Unable to navigate view Logbook of Deleted Drivers Page");
			return false;
		}
	}
	

	
	
	
	
}
