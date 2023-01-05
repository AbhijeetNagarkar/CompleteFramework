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

public class WebPageFuelEfficiency {
WebDriver driver;
	
	WebDriverWait wait;

	public static Logger log = Logger.getLogger(WebPageFuelEfficiency.class);
	
	public WebPageFuelEfficiency(WebDriver driverinstance)
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
	
	@FindBy(xpath="//h1[text()=\"No Data\"]")
	WebElement NoData;
	
	public boolean SearchandVerifyRecords() throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(5000);
		search.clear();
		search.sendKeys("demo");
		Thread.sleep(2000);
		
		List<WebElement> ele = driver.findElements(By.xpath("//tbody[@class=\"rc-table-tbody\"]//tr//td[@class=\"rc-table-cell\"][0]//div"));
		
		if(ele.size()==0)
		{
			log.info("Search records Not available for given search text");
			search.clear();
			return true;

		}
		else
		{
			for(WebElement element : ele)
			{
				if(element.getText().toLowerCase().contains("demo"))
				{
					continue;
				}
				else
				{	log.info("Search records not matched as per search text");
					search.clear();
					return false;
				}
					
			}
		}
		log.info("Search records matched for given search text");

		search.clear();
		return true;		
	}
	
	public Boolean filterandverification() throws InterruptedException
	{
		try
		{
			search.clear();			
				
			Thread.sleep(3000);
			filter.click();
			log.info("Clicked on Filter");

			Thread.sleep(2000);
					
			filteroption.get(1).click();
			log.info("Clicked on last 7 days report");

			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//tbody[@class=\"rc-table-tbody\"]//tr//td[@class=\"rc-table-cell\"][0]//div")));
			List<WebElement> ele = driver.findElements(By.xpath("//tbody[@class=\"rc-table-tbody\"]//tr//td[@class=\"rc-table-cell\"][0]//div"));
				
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
	public Boolean VerifyDownload() throws InterruptedException
	{
		try
		{
			Thread.sleep(2000);
			changefocus.click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//button//span[text()=\"Download\"]")).click();
			
			log.info("Clicked on Download Button");
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//div[text()=\"PDF\"]")).click();
			
			log.info("Clicked on PDF Button");
			
			int size1=driver.findElements(By.xpath("//button//span[text()=\"Download\"]")).size();
			Thread.sleep(1000);
			int size2=driver.findElements(By.xpath("//span[text()=\"Download started.\"]")).size();
			if(size1<1 || size2==1)
			{
				log.info("Downloading file");
				return true;
			}
			else
			{
				log.info("Unable to downlaod File");
				return false;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			log.info("Caught Exception while downlaod File");
			return false;
		}
			
	}
}
