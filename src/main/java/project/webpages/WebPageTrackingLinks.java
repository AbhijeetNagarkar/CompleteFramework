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

public class WebPageTrackingLinks {
	
	WebDriver driver;
	
	WebDriverWait wait;

	public static Logger log = Logger.getLogger(WebPageTrackingLinks.class);
		
	public WebPageTrackingLinks(WebDriver driverinstance)
	{
		driver=driverinstance;
			
		PageFactory.initElements(driver,this);
			
		wait=new WebDriverWait(driver,10);
	}
	
	@FindBy(xpath = "//tr[@class=\"rc-table-row rc-table-row-level-0 text-base text-gray-400 bg-white border-b border-gray-100 h-12 w-full rounded-md hover:bg-blue-tablerow\"]")
	WebElement rows;

	@FindBy(xpath = "//input")
	WebElement search;

	public Boolean search() throws InterruptedException
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(search));
			search.click();
			Thread.sleep(2000);
			
			search.clear();
			
			search.sendKeys("trailer");
			
			log.info("Entered trailer in search box");
			
			Thread.sleep(3000);
			
			return true;
		}
		catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	public Boolean verifyResult()
	{
		List<WebElement> rows = driver.findElements(By.xpath("//tr[@class=\"rc-table-row rc-table-row-level-0 text-base text-gray-400 bg-white border-b border-gray-100 h-12 w-full rounded-md hover:bg-blue-tablerow\"]//td[2]//div"));
	
		log.info("Captured result into list");
		
		for(WebElement ele : rows)
		{
			String text = ele.getText().toLowerCase();
			
			if(text.contains("trailer"))
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
}
