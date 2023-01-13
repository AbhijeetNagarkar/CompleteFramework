package project.webpages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebPageHOSCompliance {

	WebDriver driver;
	
	WebDriverWait wait;

	public static Logger log = Logger.getLogger(WebPageHOSCompliance.class);
	
	public WebPageHOSCompliance(WebDriver driverinstance)
	{
		driver=driverinstance;
			
		PageFactory.initElements(driver,this);
			
		wait=new WebDriverWait(driver,10);
		
	}
	
	@FindBy(xpath = "//div[@class=\"flex items-center\"]//span[text()=\"Quick Selection\"]")
	WebElement filter;

	@FindBy(xpath = "//div[@class=\"cursor-pointer\"]//span")
	List<WebElement> filteroption;
	
	@FindBy(xpath = "//div[@class=\"flex items-center\"]//span[text()=\"Reset All\"]")
	WebElement resetfilter;
	
	@FindBy(xpath = "//div[@class=\"ml-10 mt-2\"]//span")
	WebElement changefocus;
	

	@FindBy(xpath = "//input")
	WebElement search;
	
	public boolean SearchandVerifyRecords() throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(3000);
		changefocus.click();
		search.clear();
		search.sendKeys("ta");
		Thread.sleep(2000);
		
		List<WebElement> ele = driver.findElements(By.xpath("//tbody[@class=\"rc-table-tbody\"]//tr//td[@class=\"rc-table-cell\"]//a//div"));
		
		if(ele.size()==0)
		{
			log.info("Records not available for search criteria");
			search.clear();
			return true;
		}
		else
		{
			for(WebElement element : ele)
			{
				if(element.getText().toLowerCase().contains("ta"))
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
	}
	
	public Boolean filterandverification() throws InterruptedException
	{
		try
		{
			changefocus.click();

			search.clear();

			Thread.sleep(3000);
			filter.click();
			log.info("Clicked on Filter");

			Thread.sleep(2000);
					
			filteroption.get(1).click();
			log.info("Clicked on last 7 days report");

			List<WebElement> ele = driver.findElements(By.xpath("//tbody[@class=\"rc-table-tbody\"]//tr//td[@class=\"rc-table-cell\"]//a//div"));
				
			if(ele.size()>0)
				log.info("Records available for last 7 days");
			else
				log.info("Records not available for last 7 days");
					
			driver.findElement(By.xpath("//button//span[text()=\"Reset All\"]")).click();
			
			return true;
		}
		catch (Exception e) {
			log.info("Filter and verification functionality not working");
			return false;
		}
		
	}
	
	

}
