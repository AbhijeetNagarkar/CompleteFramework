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
import org.testng.Assert;

import project.mediator.Driver;
import project.mediator.ObjectRepository;
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
	
	@FindBy(xpath = "//span[@class=\"text-blue-500 bg-blue-100 font-semibold py-1 px-2 rounded text-sm\"]")
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
	
	@FindBy(xpath = "//div[@class=\"ml-10 mt-2\"]//span")
	WebElement changefocus;
	
	
	//div[@class="pl-3"]//*[name()="svg"]               delete button list of drivers
	
	//div[@class="text-blue-secondary text-sm font-medium py-4 px-2 flex items-center"]//*[name()="svg"]     list 0  to edit unit no and 1 is for edit driver
	
	//span[@class="text-blue-primary bg-blue-100 font-semibold py-1 px-2 rounded text-sm"]  active and inactive count list
	
	
	
	public Boolean searchDriver() throws InterruptedException
	{
		Thread.sleep(2000);
		
		changefocus.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(search));
		
		search.sendKeys("Tapan");
		
		return verifyRecords();
		
	}
	
	public Boolean EditDriver() throws InterruptedException
	{
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(search));
			
			search.clear();
			
			search.sendKeys(driversdata.get("First Name"));
			
			Thread.sleep(2000);
			
			wait.until(ExpectedConditions.elementToBeClickable(totalcount.get(0)));
	
			String active = totalcount.get(0).getText();
			String inactive = totalcount.get(1).getText();
			
			if(Integer.valueOf(active)>0)
			{
				totalcount.get(0).click();
				Thread.sleep(2000);
				List<WebElement> list = driver.findElements(By.xpath("//div[text()='"+driversdata.get("License")+"']"));
				Thread.sleep(2000);

				if(list.size()>0)
				{
					driver.findElements(By.xpath("//div[text()='"+driversdata.get("License")+"']//following::div[@class=\"text-blue-secondary text-sm font-medium py-4 px-2 flex items-center\"]//*[name()=\"svg\"]")).get(0).click();
					Thread.sleep(1000);
					log.info("Clicked on Edit Button");
					driver.findElement(By.xpath("//input[@label=\"First Name\"]")).clear();
					driversdata.put("First Name","xyxyxyxyxyxyxyxyxyxyxy");
					driver.findElement(By.xpath("//input[@label=\"First Name\"]")).sendKeys(driversdata.get("First Name"));
					Thread.sleep(1000);
					driver.findElement(By.xpath("//button[text()=\"Save\"]")).click();
					log.info("Clicked on Save Button");
					Thread.sleep(1000);
					return true;
				}
				
			}
			if(Integer.valueOf(inactive)>0)
			{
				totalcount.get(1).click();
				Thread.sleep(2000);
				List<WebElement> list = driver.findElements(By.xpath("//div[text()='"+driversdata.get("License")+"']"));
				if(list.size()>0)
				{
					driver.findElements(By.xpath("//div[text()='"+driversdata.get("License")+"']//following::div[@class=\"text-blue-secondary text-sm font-medium py-4 px-2 flex items-center\"]//*[name()=\"svg\"]")).get(0).click();
					Thread.sleep(1000);
					log.info("Clicked on Edit Button");
					driver.findElement(By.xpath("//input[@label=\"First Name\"]")).clear();
					driversdata.put("First Name","xyxyxyxyxyxyxyxyxyxyxy");
					driver.findElement(By.xpath("//input[@label=\"First Name\"]")).sendKeys(driversdata.get("First Name"));
					Thread.sleep(1000);
					driver.findElement(By.xpath("//button[text()=\"Save\"]")).click();
					Thread.sleep(1000);
					log.info("Clicked on Save Button");
					return true;
				}
			}
			return false;
		}
		catch (Exception e) {
			log.info("Edit Driver Functionality not working");
			Assert.fail("Edit Driver Functionality not working");
		}
		return false;
		
	}
	public Boolean VerifyEditedDriver() throws InterruptedException
	{
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(search));
			
			search.clear();
			
			search.sendKeys(driversdata.get("First Name"));
			
			log.info("Searching for Driver");
			Thread.sleep(2000);
			
			wait.until(ExpectedConditions.elementToBeClickable(totalcount.get(0)));
	
			String active = totalcount.get(0).getText();
			String inactive = totalcount.get(1).getText();
			
			log.info("Captured Active/InActive Driver Data");
			
			if(Integer.valueOf(active)>0)
			{
				totalcount.get(0).click();
				Thread.sleep(2000);
				List<WebElement> list = driver.findElements(By.xpath("//tr//td//div[@class=\"pl-2\"]"));
				Thread.sleep(2000);
				log.info("Captured Drivers List");
				for(WebElement ele : list)
				{
					if(ele.getText().toLowerCase().contains(driversdata.get("First Name")))
						continue;
					else
						return false;
				}
				log.info("Verified Edited Driver Successfully");
				return true;
				
				
			}
			if(Integer.valueOf(inactive)>0)
			{
				totalcount.get(1).click();
				Thread.sleep(2000);
				List<WebElement> list = driver.findElements(By.xpath("//tr//td//div[@class=\"pl-2\"]"));
				Thread.sleep(2000);
				log.info("Captured Drivers List");
				for(WebElement ele : list)
				{
					if(ele.getText().toLowerCase().contains(driversdata.get("First Name")))
						continue;
					else
						return false;
				}
				log.info("Verified Edited Driver Successfully");
				return true;
			}
			return false;
		}
		catch (Exception e) {
			log.info("Edit Driver Functionality not working");
			Assert.fail("Edit Driver Functionality not working");
		}
		return false;
		
	}
	

	public Boolean DeleteDriver() throws InterruptedException
	{
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(search));
			
			changefocus.click();
			
			search.clear();
			
			search.sendKeys(driversdata.get("First Name"));
			
			Thread.sleep(2000);
			
			wait.until(ExpectedConditions.elementToBeClickable(totalcount.get(0)));
	
			String active = totalcount.get(0).getText();
			String inactive = totalcount.get(1).getText();
			
			Thread.sleep(2000);
			
			if(Integer.valueOf(active)>0)
			{
				totalcount.get(0).click();
				Thread.sleep(2000);
				List<WebElement> list = driver.findElements(By.xpath("//div[text()='"+driversdata.get("License")+"']"));
				Thread.sleep(2000);

				if(list.size()>0)
				{
					driver.findElements(By.xpath("//div[text()='"+driversdata.get("License")+"']//following::div[@class=\"text-blue-secondary text-sm font-medium py-4 px-2 flex items-center\"]//*[name()=\"svg\"]")).get(1).click();
					Thread.sleep(1000);
					log.info("Clicked on Delete Button");
					driver.findElement(By.xpath("//input[@label=\"[object Object]\"]")).sendKeys("DELETE");
					Thread.sleep(1000);
					driver.findElement(By.xpath("//button[text()=\"Remove Driver\"]")).click();
					Thread.sleep(1000);
					log.info("Clicked on Remove Driver Button");
					return true;
				}
				
			}
			if(Integer.valueOf(inactive)>0)
			{
				totalcount.get(1).click();
				Thread.sleep(2000);
				List<WebElement> list = driver.findElements(By.xpath("//div[text()='"+driversdata.get("License")+"']"));
				if(list.size()>0)
				{
					driver.findElements(By.xpath("//div[text()='"+driversdata.get("License")+"']//following::div[@class=\"text-blue-secondary text-sm font-medium py-4 px-2 flex items-center\"]//*[name()=\"svg\"]")).get(1).click();
					Thread.sleep(1000);
					log.info("Clicked on Delete Button");
					driver.findElement(By.xpath("//input[@label=\"[object Object]\"]")).sendKeys("DELETE");
					Thread.sleep(1000);
					driver.findElement(By.xpath("//button[text()=\"Remove Driver\"]")).click();
					Thread.sleep(1000);
					log.info("Clicked on Remove Driver Button");

					return true;
				}
			}
			return false;
		}
		catch (Exception e) {
			log.info("Delete Driver Functionality not working");
			Assert.fail("Delete Driver Functionality not working");
		}
		return false;
		
	}
	
	
	public Boolean CreateDriver() throws InterruptedException
	{
		try
		{
			Thread.sleep(2000);
			
			
			wait.until(ExpectedConditions.elementToBeClickable(adddriverbutton));
			changefocus.click();
			
			adddriverbutton.click();
			
			log.info("Clicked on Add Driver Button");
			
			Thread.sleep(2000);
	
			driver.findElement(By.xpath("//input[@label=\"First Name\"]")).sendKeys(driversdata.get("First Name"));
			
			driver.findElement(By.xpath("//input[@label=\"Last Name\"]")).sendKeys(driversdata.get("Last Name"));
		
			driver.findElement(By.xpath("//input[@type=\"tel\"]")).sendKeys(driversdata.get("Cell"));
			
			driver.findElement(By.xpath("//input[@label=\"Email\"]")).sendKeys(driversdata.get("Email"));
	
			driver.findElement(By.xpath("//input[@label=\"License\"]")).sendKeys(driversdata.get("License"));
	
			license_state.get(2).click();
			
			Thread.sleep(1000);
			
			driver.findElements(By.xpath("//div[@class=\" css-1u0owcj-option\"]//span")).get(0).click();
			
			nextbutton.click();
			
			log.info("Clicked on Next Button");
			
			Thread.sleep(1000);
			
			nextbutton.click();
			
			Thread.sleep(1000);
			
			savebutton.click();
			log.info("Clicked on Save Button");
			
			try
			{
				driver.findElement(By.xpath("//span[text()=\"Driver already exists\" or text()=\"Driver license already exists\"]"));
				log.info("Driver already exists");
				
				backbutton.click();
				
				Thread.sleep(1000);
				
				backbutton.click();
				
				driver.findElement(By.xpath("//input[@type=\"tel\"]")).sendKeys(driversdata.get("Cell"));
				
				driver.findElement(By.xpath("//input[@label=\"License\"]")).sendKeys(driversdata.get("License"));
				
				nextbutton.click();
				
				log.info("Clicked on Next Button");
				
				Thread.sleep(1000);
				
				nextbutton.click();
				
				Thread.sleep(1000);
				
				savebutton.click();
				log.info("Clicked on Save Button");
				
				driver.findElement(By.xpath("//span[text()=\"Driver already exists\" or text()=\"Driver license already exists\"]"));
				log.info("Driver already exists twice and closing the popup");
				
				driver.findElement(By.xpath("//*[name()=\"svg\" and @class=\"h-5 w-5 cursor-pointer text-blue-secondary hover:text-gray-500\"]")).click();
				
				Driver.Refresh();
				
				Assert.fail("Create New Driver functionality not working, caught exception");

				Thread.sleep(5000);
			}
			catch(org.openqa.selenium.NoSuchElementException e)
			{
				log.info("Driver Successfully Added");
			}

		}
		catch (Exception e) {
			log.info("Create New Driver functionality not working, caught exception");
			Assert.fail("Create New Driver functionality not working, caught exception");
			Driver.Refresh();

			return false;
		}
		
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(search));
			
			search.clear();
			
			search.sendKeys(driversdata.get("First Name"));
			
			Thread.sleep(2000);
			
			wait.until(ExpectedConditions.elementToBeClickable(totalcount.get(0)));
	
			String active = totalcount.get(0).getText();
			String inactive = totalcount.get(1).getText();
			
			if(Integer.valueOf(active)>0)
			{
				totalcount.get(0).click();
				Thread.sleep(2000);
				List<WebElement> list = driver.findElements(By.xpath("//div[text()='"+driversdata.get("License")+"']"));
				if(list.size()>0)
				{
					log.info("Created Driver verified on Dashboard");
					return true;
				}
				
			}
			if(Integer.valueOf(inactive)>0)
			{
				totalcount.get(1).click();
				Thread.sleep(2000);
				List<WebElement> list = driver.findElements(By.xpath("//div[text()='"+driversdata.get("License")+"']"));
				if(list.size()>0)
				{
					log.info("Created Driver verified on Dashboard");
					return true;
				}
			}
			return false;
		}
		catch (Exception e) {
			log.info("Verifying New Driver on Dashboard Functionality not working");
			Assert.fail("Verifying New Driver on Dashboard Functionality not working");
		}
		return false;

	}
	public Boolean verifyRecords() throws InterruptedException
	{
		Thread.sleep(2000);
		changefocus.click();
		wait.until(ExpectedConditions.elementToBeClickable(totalcount.get(0)));

		String active = totalcount.get(0).getText();
		String inactive = totalcount.get(1).getText();
		
		log.info("Captured active :"+active+" and inactive :"+inactive+" drivers count");
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


	public boolean verifyDeletedDriver() throws InterruptedException {
		// TODO Auto-generated method stub
		
		ObjectRepository.GetInstance().dashboardPageObject().clickOnDrivers();
		
		Thread.sleep(1000);
		
		ObjectRepository.GetInstance().dashboardPageObject().clickOnDeletedDrivers();
		
		try
		{
			driver.findElement(By.xpath("//div[text()='"+driversdata.get("License")+"']"));
			log.info("Deleted Driver found on Deleted Drivers Page");
		}
		catch (org.openqa.selenium.NoSuchElementException e) {

			log.info("Deleted Driver not showing in Deleted Drivers Page");
			return false;
		}
		
		ObjectRepository.GetInstance().dashboardPageObject().clickOnDrivers();
		
		ObjectRepository.GetInstance().dashboardPageObject().clickOnDriversSubMenu();
		
		return true;
	}
	
	
	
	
	
}
