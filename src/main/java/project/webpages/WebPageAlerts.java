package project.webpages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebPageAlerts {
	
	WebDriver driver;
	
	WebDriverWait wait;

	public static Logger log = Logger.getLogger(WebPageAlerts.class);
		
	public WebPageAlerts(WebDriver driverinstance)
	{
		driver=driverinstance;
			
		PageFactory.initElements(driver,this);
			
		wait=new WebDriverWait(driver,120);
	}
	
	@FindBy(xpath = "//div[@class=\"tab-single  active\"]//span")
	WebElement activecount;
	
	@FindBy(xpath = "//div[@class=\"w-6/12 mx-1\"]//span[@class=\"text-lg text-blue-secondary font-semibold\"]")
	List<WebElement> count;
	
	public Boolean verifyAlertRecords()
	{
		try
		{
			Thread.sleep(10000);
			driver.findElement(By.xpath("//div[@class=\"ml-10 mt-2\"]//span")).click();

		//	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@class=\"activity-table \"]//tr[@class=\"text-center\" or @class=\"text-center cursor-pointer\"]")));
			int count1 = driver.findElements(By.xpath("//table[@class=\"activity-table \"]//tr[@class=\"text-center\" or @class=\"text-center cursor-pointer\"]")).size();
			
			int count2 = driver.findElements(By.xpath("//table[@class=\"activity-table false\"]//tr[@class=\"text-center\" or @class=\"text-center cursor-pointer\"]")).size();
	
			if(count.get(0).getText().contains(String.valueOf(count1))
					&& count.get(1).getText().contains(String.valueOf(count2)))
			{
				log.info("Number of Alerts count matches with records");
				return true;
			}
			else
			{
				log.info("Number of Alerts count not matches with records");
	
				return false;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			log.info("Caught exception while verify Alerts Records");
			
			return false;
		}
	}
	public Boolean VerifyDownloadAlerts() throws InterruptedException
	{
		try
		{
			driver.findElement(By.xpath("//div[@class=\"ml-10 mt-2\"]//span")).click();

			Thread.sleep(2000);
			
			driver.findElements(By.xpath("//span[@class=\"order-last\"]//span[text()=\"Download\"]")).get(0).click();
			
			log.info("Clicked on Download Button");

			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//div[text()=\"PDF\"]")).click();
			
			log.info("Clicked on PDF Button");

			
			Thread.sleep(1000);
			
			int size=driver.findElements(By.xpath("//span[@class=\"order-last\"]//span[text()=\"Download\"]")).size();
			if(size<2)
			{
				log.info("Downloading Alerts file");
				return true;
			}
			else
			{
				log.info("Unable to downlaod Alerts File");
				return false;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			log.info("Caught Exception while downlaod Alerts File");
			return false;
		}
			
	}


	
	
	
	
	
	
	
	
}
