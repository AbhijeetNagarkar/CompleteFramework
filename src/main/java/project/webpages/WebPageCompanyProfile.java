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

public class WebPageCompanyProfile {
	
WebDriver driver;
	
	WebDriverWait wait;

	public static Logger log = Logger.getLogger(WebPageCompanyProfile.class);
	
	HashMap<String,String> data;
		
	public WebPageCompanyProfile(WebDriver driverinstance)
	{
		driver=driverinstance;
			
		PageFactory.initElements(driver,this);
			
		wait=new WebDriverWait(driver,10);
		
		data=TestData.GetCompanyProfileData();
		
		
	}
	
	@FindBy(xpath = "//span[@class=\"cursor-pointer right\"]//*[name()=\"svg\"]")
	List<WebElement> editbutton;
	
	@FindBy(xpath = "/html/body/div[3]/div/span/div/div/div/span")
	WebElement msg;

	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement updateButton;
	
	
	public Boolean VerifyDashboard()
	{
		try
		{
			driver.findElement(By.xpath("//div[@class=\"ml-10 mt-2\"]//span")).click();
			
			Thread.sleep(2000);
			
			List<WebElement> ele = driver.findElements(By.xpath("//div[@class=\"pl-4 w-5/6\"]//span"));
			
			String s1= ele.get(1).getText().trim();
			String s2= ele.get(2).getText().trim();
			String s3 = ele.get(3).getText().trim();
			if(s1.equalsIgnoreCase(data.get("Name")) && s2.equalsIgnoreCase(data.get("DOT")) 
				&& s3.equalsIgnoreCase(data.get("Email")))
			{
				log.info("Company Details verified on Company Profile Page");
				return true;
			}
			else
			{
				log.info("Incorrect Company Details showing in Company Profile Page");
				return false;
			}
		}
		catch (Exception e) {
			log.info("Caught Exception While Verifying Company Profile information");
			return false;
		}
			
		
	}
	
	public Boolean EditAddress() throws InterruptedException
	{
		try
		{
			for(int i=0;i<=3;i++)
			{
				
					Thread.sleep(2000);
					
					editbutton.get(i).click();
				
					Thread.sleep(2000);
					
					updateButton.click();
					
					wait.until(ExpectedConditions.visibilityOf(msg));
					
					if(i==2 && msg.getText().equalsIgnoreCase("Carrier timezone updated successfully"))
					{
		//				driver.findElement(By.xpath("//*[@class=\"h-5 w-5 cursor-pointer text-blue-secondary hover:text-gray-500\"]")).click();
	
						continue;
					}
					else if(i==3 && msg.getText().equalsIgnoreCase("Shipping address updated successfully"))
					{
		//				driver.findElement(By.xpath("//*[@class=\"h-5 w-5 cursor-pointer text-blue-secondary hover:text-gray-500\"]")).click();
	
						continue;
					}	
					else if(msg.getText().equalsIgnoreCase("Carrier address updated successfully"))
					{
		//				driver.findElement(By.xpath("//*[@class=\"h-5 w-5 cursor-pointer text-blue-secondary hover:text-gray-500\"]")).click();
	
						continue;
					}
					else
					{
		//				driver.findElement(By.xpath("//*[@class=\"h-5 w-5 cursor-pointer text-blue-secondary hover:text-gray-500\"]")).click();
	
						log.info("Edit functionality not working on Company Profile Page");
						return false;
					}
				
			}
		}
		catch(Exception e)
		{
			return false;
		}
		log.info("Edit functionality working on Company Profile Page");
		return true;
	}
	

}
	