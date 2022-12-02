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

import project.mediator.Driver;

public class WebPageAPIKeyTransfer {
	
	WebDriver driver;
	
	WebDriverWait wait;

	public static Logger log = Logger.getLogger(WebPageAPIKeyTransfer.class);
		
	public WebPageAPIKeyTransfer(WebDriver driverinstance)
	{
		driver=driverinstance;
			
		PageFactory.initElements(driver,this);
			
		wait=new WebDriverWait(driver,10);
	}
	
	@FindBy(xpath = "//span[@class=\"text-blue-primary bg-blue-100 font-semibold py-1 px-2 rounded text-sm\"]")
	List<WebElement> count;	
	
	@FindBy(xpath = "//tr[@class=\"ant-table-row ant-table-row-level-0\"]")
	List<WebElement> rowcount;
	
	@FindBy(xpath = "//li//span[text()=\"Active\"]")
	WebElement activecount;
	
	@FindBy(xpath = "//li//span[text()=\"Expired\"]")
	WebElement inactivecount;
	
	@FindBy(xpath = "//button[text()=\"+ Share API KEY\"]")
	WebElement shareAPI;
	
	@FindBy(xpath = "//input[@type=\"checkbox\"]")
	WebElement checkbox;
	
	@FindBy(xpath = "//button[text()=\"Send API Key\"]")
	WebElement sendapikey;
	
	
	public Boolean verifyCount() throws InterruptedException
	{
		
		String str = count.get(0).getText();
		
		String str2 = count.get(1).getText();
		
		Thread.sleep(2000);
		
		driver.findElements(By.xpath("//li")).get(0).click();
		
		List<WebElement> rows = driver.findElements(By.xpath("//tr[@class=\"rc-table-row rc-table-row-level-0 text-base text-gray-400 bg-white border-b border-gray-100 h-12 w-full hover:bg-blue-tablerow focus:hover:bg-blue-tablerow rounded-md`\"]"));
	
		int rowsize = rows.size();
		
		wait.until(ExpectedConditions.elementToBeClickable(inactivecount));
		
		driver.findElements(By.xpath("//li")).get(1).click();
			
		Thread.sleep(2000);
		
		List<WebElement> rows1 = driver.findElements(By.xpath("//tr[@class=\"rc-table-row rc-table-row-level-0 text-base text-gray-400 bg-white border-b border-gray-100 h-12 w-full hover:bg-blue-tablerow focus:hover:bg-blue-tablerow rounded-md`\"]"));

		int rowsize1 = rows1.size();
		
		log.info("Captured result into list");
	
		if(rowsize == Integer.valueOf(str) && rowsize1 == Integer.valueOf(str2))
		{
			log.info("correct Active/Expired Count showing on API Key Transfer Page");
			return true;
		}
		else
		{	
			log.info("Incorrect Active/Expired Count showing on API Key Transfer Page");
				return false;
		}
		
		
	}


	public boolean shareAPIKey() throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(3000);
		
		shareAPI.click();
		
		Thread.sleep(3000);
			
		List<WebElement> ele = driver.findElements(By.xpath("//div[@class=\" css-1jpdhzf-control\"]"));
		
		//div[@class=" css-1u0owcj-option"]
		Thread.sleep(1000);
		
		ele.get(0).click();
		
		Thread.sleep(1000);
	
		List<WebElement> ele1 = driver.findElements(By.xpath("//span[@class=\"text-blue-secondary\"]"));

		ele.get(0).click();
		
		
		Thread.sleep(1000);
		
		ele.get(1).click();
		
		Thread.sleep(1000);
	
		List<WebElement> ele2 = driver.findElements(By.xpath("//span[@class=\"text-blue-secondary\"]"));
		
		ele.get(1).click();
		

		Thread.sleep(1000);
		
		ele.get(2).click();
		
		Thread.sleep(1000);
		
		List<WebElement> ele3 = driver.findElements(By.xpath("//span[@class=\"text-blue-secondary\"]"));
		
		ele.get(2).click();
		

		Thread.sleep(1000);
		
		ele.get(3).click();
		
		Thread.sleep(1000);
		
		List<WebElement> ele4 = driver.findElements(By.xpath("//span[@class=\"text-blue-secondary\"]"));
		
		ele.get(3).click();
		
		
		if(ele1.isEmpty() || ele2.isEmpty() || ele3.isEmpty() || ele4.isEmpty())
		{
			log.info("drop down options not available in Share Link With API Partner Prompt");
			return false;
		}
		else
		{
			try
			{
				checkbox.click();
				Thread.sleep(2000);
				sendapikey.click();
				
				log.info("Able to click on Send API Key");
				
				return true;
			}
			catch (Exception e) {
				// TODO: handle exception
				log.info("Unable to click on Send API Key button on Share Link With API Partner Prompt");
				return false;
			}
			finally {
				Driver.Refresh();
			}
			
		}
	
	}

	

}
