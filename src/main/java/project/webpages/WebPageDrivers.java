package project.webpages;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import project.mediator.TestData;

public class WebPageDrivers {

WebDriver driver;
	
	WebDriverWait wait;

	public static Logger log = Logger.getLogger(WebPageDrivers.class);
	
	HashMap<String,String> driversdata;
		
	public WebPageDrivers(WebDriver driverinstance)
	{
		driver=driverinstance;
			
		PageFactory.initElements(driver,this);
			
		wait=new WebDriverWait(driver,120);
		
		driversdata=TestData.GetDriversData();
	}
	
	@FindBy(xpath = "//input")
	WebElement search;
	
	@FindBy(xpath = "//span[@class=\"text-blue-primary bg-blue-100 font-semibold py-1 px-2 rounded text-sm\"]")
	List<WebElement> totalcount;
	
	@FindBy(xpath = "//div[@class=\" css-1hwfws3\"]")
	List<WebElement> license_state;
	
	@FindBy(xpath = "//button[text()=\"Next\"]")
	WebElement nextbutton;
	
	@FindBy(xpath = "//button[text()=\"Back\"]")
	WebElement backbutton;
	
	@FindBy(xpath = "//button[text()=\"Save\"]")
	WebElement savebutton;
	
	@FindBy(xpath = "//button[text()=\"+ Add Driver\"]")
	WebElement adddriverbutton;
	
	
	
	//div[@class="pl-3"]//*[name()="svg"]               delete button list of drivers
	
	//div[@class="text-blue-secondary text-sm font-medium py-4 px-2 flex items-center"]//*[name()="svg"]     list 0  to edit unit no and 1 is for edit driver
	
	//span[@class="text-blue-primary bg-blue-100 font-semibold py-1 px-2 rounded text-sm"]  active and inactive count list
	
	
	
	public Boolean searchDriver() throws InterruptedException
	{
		wait.until(ExpectedConditions.elementToBeClickable(search));
		
		search.sendKeys("Tapan");
		
		return verifyRecords();
		
	}
	
	public Boolean CreateDriver() throws InterruptedException
	{
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.elementToBeClickable(adddriverbutton));
		
		adddriverbutton.click();
		
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@label=\"First Name\"]")).sendKeys(driversdata.get("First Name"));
		
		driver.findElement(By.xpath("//input[@label=\"Last Name\"]")).sendKeys(driversdata.get("Last Name"));
	
		driver.findElement(By.xpath("//input[@type=\"tel\"]")).sendKeys("800-793-9513");
		
		driver.findElement(By.xpath("//input[@label=\"Email\"]")).sendKeys(driversdata.get("Email"));

		driver.findElement(By.xpath("//input[@label=\"License\"]")).sendKeys(driversdata.get("License"));

		license_state.get(2).click();
		
		Thread.sleep(1000);
		
		driver.findElements(By.xpath("//div[@class=\" css-1u0owcj-option\"]//span")).get(0).click();
		
		nextbutton.click();
		
		Thread.sleep(1000);
		
		nextbutton.click();
		
		Thread.sleep(1000);
		
		savebutton.click();
		
		return true;


		

		
	}
	public Boolean verifyRecords() throws InterruptedException
	{
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.elementToBeClickable(totalcount.get(0)));

		String active = totalcount.get(0).getText();
		String inactive = totalcount.get(1).getText();
		
		log.info("Captured active and inactive drivers count");
		int flag=0;
		
		totalcount.get(0).click();
		log.info("Clicked on Active Drivers");
		Thread.sleep(2000);
		List<WebElement> list = driver.findElements(By.xpath("//tr[@class=\"rc-table-row rc-table-row-level-0 text-base text-gray-400 bg-white border-b border-gray-100 h-12 w-full hover:bg-blue-tablerow focus:hover:bg-blue-tablerow rounded-md`\"]"));
		log.info("Captured active driver records");
		String searchText = search.getAttribute("value").toLowerCase();
		if(searchText.equalsIgnoreCase(""))
		{
			if(list.size() == Integer.valueOf(active))
			{
				flag++;
			}
			Thread.sleep(2000);
			totalcount.get(1).click();
			log.info("Clicked on InActive Drivers");
			Thread.sleep(2000);
			list = driver.findElements(By.xpath("//tr[@class=\"rc-table-row rc-table-row-level-0 text-base text-gray-400 bg-white border-b border-gray-100 h-12 w-full hover:bg-blue-tablerow focus:hover:bg-blue-tablerow rounded-md`\"]"));
			log.info("Captured inactive driver records");
			if(list.size() == Integer.valueOf(inactive))
			{
				flag++;
			}
			if(flag==2)
			{
				log.info("Verified total number of records");
				return true;
			}
			else
			{
				log.info("Number of drivers records not matching");
				return false;
			}
			
		}
		else
		{
			for(WebElement ele : list)
			{
				String str = ele.findElement(By.xpath("//div[@class=\"pl-2\"]")).getText().toLowerCase();
				if(str.contains(searchText))
				{
					continue;
				}
				else
				{
					log.info("Search records are not matching with search text");
					return false;
				}
			}
			log.info("Search records are as per search text");
			return true;

		}
	}
}
