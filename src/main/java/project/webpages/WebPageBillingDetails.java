package project.webpages;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WebPageBillingDetails {

	WebDriver driver;
	
	WebDriverWait wait;

	public static Logger log = Logger.getLogger(WebPageBillingDetails.class);
		
	public WebPageBillingDetails(WebDriver driverinstance)
	{
		driver=driverinstance;
			
		PageFactory.initElements(driver,this);
			
		wait=new WebDriverWait(driver,10);
	}
	
	@FindBy(xpath = "//div[@class=\"ml-10 mt-2\"]//span")
	WebElement changefocus;
	
	@FindBy(xpath = "//button//a[text()=\"Upgrade\"]")
	WebElement upgradeButton;
	
	@FindBy(xpath = "//button//a[text()=\"Add more devices\"]")
	WebElement addmoredevicesButton;
	
	@FindBy(xpath = "//button//a[text()=\"Buy accessories\"]")
	WebElement buyaccessoriesButton;
	
	@FindBy(xpath = "//span[text()=\"No Overdues\"]")
	WebElement noOverduesTab;
	
	@FindBy(xpath = "//span[text()=\"Next Billing\"]")
	WebElement nextBillingTab;
	
	@FindBy(xpath = "//span[text()=\"History\"]")
	WebElement historyTab;
	
	
	

	public Boolean VerifyUpgradeFunctionality() throws InterruptedException
	{
		try
		{
			Thread.sleep(2000);
			
			changefocus.click();
		
			String windowid = driver.getWindowHandle();
		
			upgradeButton.click();
			log.info("Clicked on Upgrade Button");
			
			Thread.sleep(5000);
			
			switchNextWindow(windowid);
			
			if(driver.getCurrentUrl().equalsIgnoreCase("https://sales.truckx.com/store?order_by=nnenuHt0q&mode=fms_upgrade"))
			{
				try
				{
					driver.findElement(By.xpath("//span[text()=\"Bluetooth ELD\"]"));
					log.info("Showing Bluetooth ELD Device to Upgrade");
				}
				catch (NoSuchElementException e) {
					log.info("Not showing Bluetooth ELD Device to Upgrade");
				}
				switchBacktoMainPage(windowid);
				return true;

			}

			else return false;
			
			
		}
		catch (Exception e) {
			log.info("Upgrade Functionality not working, Caught Exception");
			Assert.fail("Upgrade Functionality not working, Caught Exception");
		}
		return false;
		
	}

	

	public Boolean VerifyAddMoreDevicesFunctionality() throws InterruptedException
	{
		try
		{
			Thread.sleep(2000);
			
			changefocus.click();
		
			String windowid = driver.getWindowHandle();
			
			addmoredevicesButton.click();
			log.info("Clicked on Add More Devices Button");
			
			Thread.sleep(3000);
			
			switchNextWindow(windowid);

					
			if(driver.getCurrentUrl().equalsIgnoreCase("https://sales.truckx.com/store?order_by=nnenuHt0q&mode=fms_add_new"))
			{
				try
				{
					driver.findElement(By.xpath("//span[text()=\"Bluetooth ELD\"]"));
					log.info("Showing Bluetooth ELD Device to Add More Devices");
				}
				catch (NoSuchElementException e) {
					log.info("Not showing Bluetooth ELD Device to Add More Devices\"");
				}
				switchBacktoMainPage(windowid);
				return true;

			}
			else return false;
			
		}
		catch (Exception e) {
			log.info("Add More Devices Functionality not working, Caught Exception");
			Assert.fail("Add More Devices Functionality not working, Caught Exception");
		}
		return false;
		
	}
	
	public Boolean VerifyBuyAccessoriesFunctionality() throws InterruptedException
	{
		try
		{
			Thread.sleep(2000);
			
			changefocus.click();
		
			String windowid = driver.getWindowHandle();
			
			buyaccessoriesButton.click();
			log.info("Clicked on Buy Accessories Button");
		
			Thread.sleep(3000);

			switchNextWindow(windowid);
			
			if(driver.getCurrentUrl().equalsIgnoreCase("https://sales.truckx.com/store/product/bluetooth/accessories?order_by=nnenuHt0q&mode=fms_add_accessories"))
			{
				try
				{
					driver.findElement(By.xpath("//h1[text()=\"Bluetooth ELD Accessories\"]"));
					log.info("Showing Bluetooth ELD Accessories to Buy Accessories Page");
				}
				catch (NoSuchElementException e) {
					log.info("Not showing Bluetooth ELD Accessories to Buy Accessories Page\"");
				}
				switchBacktoMainPage(windowid);
				return true;
			}
			else return false;
			

		}
		catch (Exception e) {
			log.info("Buy Accessories Functionality not working, Caught Exception");
			Assert.fail("Buy Accessories Functionality not working, Caught Exception");
		}
		
		return false;
		
		
	}
	public Boolean NoOverduesFunctionality() throws InterruptedException
	{
		try
		{
			Thread.sleep(2000);
			
			changefocus.click();
		
			Thread.sleep(2000);

			noOverduesTab.click();
			
			Thread.sleep(2000);

			int size = driver.findElements(By.xpath("//tr[@class=\"rc-table-row rc-table-row-level-0 text-base text-gray-400 bg-white border-b border-gray-100 h-12 w-full hover:bg-blue-tablerow focus:hover:bg-blue-tablerow rounded-md`\"]")).size();
			
			if(size>0)
				log.info("No Overdues Records available");
			else
				log.info("No Overdues Records not available");
			
			return true;
		}
		catch (Exception e) {
			log.info("No Overdues Functionality not working, Caught Exception");
			Assert.fail("No Overdues Functionality not working, Caught Exception");
		}
		return false;
	
	}
	
	public Boolean NextBillingFunctionality() throws InterruptedException
	{
		try
		{
			Thread.sleep(2000);
			
			changefocus.click();
		
			Thread.sleep(2000);

			nextBillingTab.click();
			
			Thread.sleep(2000);

			int size = driver.findElements(By.xpath("//tr[@class=\"rc-table-row rc-table-row-level-0 text-base text-gray-400 bg-white border-b border-gray-100 h-12 w-full hover:bg-blue-tablerow focus:hover:bg-blue-tablerow rounded-md`\"]")).size();
			
			if(size>0)
				log.info("Next Billing Records available");
			else
				log.info("Next Billing Records not available");
			
			return true;
		}
		catch (Exception e) {
			log.info("Next Billing Functionality not working, Caught Exception");
			Assert.fail("Next Billing Functionality not working, Caught Exception");
		}
		return false;
	
	}
	
	public Boolean HistoryFunctionality() throws InterruptedException
	{
		try
		{
			Thread.sleep(2000);
			
			changefocus.click();
		
			Thread.sleep(2000);

			historyTab.click();
			
			Thread.sleep(2000);

			int size = driver.findElements(By.xpath("//tr[@class=\"rc-table-row rc-table-row-level-0 text-base text-gray-400 bg-white border-b border-gray-100 h-12 w-full hover:bg-blue-tablerow focus:hover:bg-blue-tablerow rounded-md`\"]")).size();
			
			if(size>0)
				log.info("History Records available");
			else
				log.info("History Records not available");
			
			return true;
		}
		catch (Exception e) {
			log.info("History Functionality not working, Caught Exception");
			Assert.fail("History Functionality not working, Caught Exception");
		}
		return false;
	
	}
	
	private void switchBacktoMainPage(String window) {

		Set<String> windowids = driver.getWindowHandles();
		
		for(String id : windowids)
		{
			if(id.equalsIgnoreCase(window))
				driver.switchTo().window(id);
			else driver.getWindowHandles().remove(id);
		}
	}
	
	private void switchNextWindow(String windowid) {
		
		Set<String> windowids = driver.getWindowHandles();
		
		for(String id : windowids)
		{
			if(!id.equalsIgnoreCase(windowid))
				driver.switchTo().window(id);
		}
		
	}
	
	
	
}
