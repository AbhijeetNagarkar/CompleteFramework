package project.webpages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebPageAssets {

	WebDriver driver;
	
	WebDriverWait wait;

	public static Logger log = Logger.getLogger(WebPageAssets.class);
		
	public WebPageAssets(WebDriver driverinstance)
	{
		driver=driverinstance;
			
		PageFactory.initElements(driver,this);
			
		wait=new WebDriverWait(driver,10);
	}
	
	@FindBy(xpath = "//input")
	WebElement search;
	
	@FindBy(xpath = "//div[@class=\"flex px-4 items-center\"]")
	List<WebElement> listmenu;
	
	@FindBy(xpath = "//div[@class=\"px-2 trx-asset-list truck\"]//a")
	List<WebElement> trucks;
	
	@FindBy(xpath = "//div[@class=\"px-2 trx-asset-list trailer\"]//a")
	List<WebElement> trailers;
	
	@FindBy(xpath = "//div[@class=\"ml-10 mt-2\"]//span[text()=\"Assets\"]")
	WebElement changefocus;
	
	
	public Boolean search() throws InterruptedException
	{
		try
		{
			
			Thread.sleep(5000);
			
			search.clear();
			
			search.sendKeys("MH12");
			
			log.info("Entered text in search box");
			
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
		List<WebElement> rows = driver.findElements(By.xpath("//div[@class=\"px-2 trx-asset-list truck\"]//a//h3"));
	
		int rowsize = rows.size();
		
		log.info("Captured result into list");
		
		for(WebElement ele : rows)
		{
			String text = ele.getText().toUpperCase();
			
			if(text.contains("MH12"))
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
	public Boolean verifyCollapse() throws InterruptedException
	{
		Thread.sleep(3000);
		changefocus.click();
		Thread.sleep(1000);
		listmenu.get(0).click();
		Thread.sleep(1000);
		listmenu.get(1).click();
		Thread.sleep(2000);
		
		List<WebElement> truckrows = driver.findElements(By.xpath("//div[@class=\"px-2 trx-asset-list truck\"]//a"));

		List<WebElement> trailerrows = driver.findElements(By.xpath("//div[@class=\"px-2 trx-asset-list trailer\"]//a"));

		if(truckrows.isEmpty() && trailerrows.isEmpty())
		{
			Thread.sleep(3000);
			listmenu.get(0).click();
			Thread.sleep(1000);
			listmenu.get(1).click();
			Thread.sleep(2000);
			return true;
		}
		else return false;
	}
	
	
	
	
	
}
