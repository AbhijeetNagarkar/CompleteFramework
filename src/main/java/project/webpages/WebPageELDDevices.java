package project.webpages;

import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebPageELDDevices {
	

	WebDriver driver;
	
	WebDriverWait wait;

	public static Logger log = Logger.getLogger(WebPageELDDevices.class);
	
	public WebPageELDDevices(WebDriver driverinstance)
	{
		driver=driverinstance;
			
		PageFactory.initElements(driver,this);
			
		wait=new WebDriverWait(driver,10);
		
	}
	
	@FindBy(xpath = "//div[@class=\"singleTab\"]//span")
	WebElement countDevices;

	@FindBy(xpath = "//tbody[@class=\"ant-table-tbody\"]//tr")
	List<WebElement> records;
	
	@FindBy(xpath = "//div[@class=\"ml-10 mt-2\"]//span[text()=\"ELD Devices\"]")
	WebElement changefocus;
	
	public boolean verifyELDDevicesCount() throws InterruptedException {
		// TODO Auto-generated method stub
		changefocus.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input")).click();
		Thread.sleep(2000);
		
		int size = driver.findElements(By.xpath("//div[@class=\"rc-table-container\"]//tr")).size();
	
		String str = driver.findElements(By.xpath("//span[text()=\"Active\"]//following::span")).get(0).getText().trim();
		size=size-2;
		if(str.equalsIgnoreCase(String.valueOf(size)))
		{
			log.info("ELD Devices count matched on ELD Devices Page");
			return true;
		}
		else
		{
			log.info("Incorrect Devices count showing on ELD Devices Page");
			return false;
		}
	}


}
