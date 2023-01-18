package project.webpages;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import project.mediator.TestData;

public class WebPageDOTInspection {

	WebDriver driver;

	WebDriverWait wait;
	
	HashMap<String,String> logindata;

	public static Logger log = Logger.getLogger(WebPageDOTInspection.class);
	
	public WebPageDOTInspection(WebDriver driverinstance)
	{
		driver=driverinstance;
			
		PageFactory.initElements(driver,this);
			
		wait=new WebDriverWait(driver,120);
		logindata=TestData.GetLoginData();
	}
	
	@FindBy(xpath = "//button[text()=\"Yes\"]")
	WebElement yesButton;
	
	@FindBy(xpath = "//button[text()=\"No\"]")
	WebElement noButton;
	
	@FindBy(xpath = "//span[@class=\"text-xl font-medium text-green-primary\"]")
	WebElement title;
	
	@FindBy(xpath = "//span[@class=\"text-blue-primary hover:text-blue-500 cursor-pointer\"]")
	WebElement offButton;
	
	@FindBy(xpath = "//input[@type=\"password\"]")
	WebElement passwordInput;
	
	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement exitAuditButton;
	
	@FindBy(xpath = "//span[text()=\"DOT inspection mode exited successfully\"]")
	WebElement switchoffmsg;
	
	public void SwitchOnDOTInspection()
	{
		try
		{
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(yesButton));
		yesButton.click();
		log.info("Clicked on DOT Inspection Yes Button");
		}
		catch(Exception e)
		{
			Assert.fail("Unable to Click on DOT Inspection switch on Yes Button");
		}
	}
	public void ValidateDOTInspection()
	{
		try
		{
			Thread.sleep(2000);
			if(title.getText().equalsIgnoreCase("DOT inspection mode is turned on."))
			{
				log.info("DOT Inspection is ON now");
			}
			else
			{
				log.info("DOT Inspection is OFF");
				Assert.fail("Unable to Validate DOT Inspection switch ON Mode as Message not showing as Switched ON");
			}
		
		}
		catch(Exception e)
		{
			Assert.fail("Unable to Validate DOT Inspection switch ON Mode, Caught Exception");
		}
		
	}

	public void SwitchOFFDOTInspection()
	{
		try
		{
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(offButton));
			offButton.click();
			log.info("Clicked on DOT Inspection OFF Button");
			Thread.sleep(2000);
			passwordInput.sendKeys(logindata.get("Password"));
			log.info("Entering password to OFF DOT Inspection");
			Thread.sleep(3000);
		//	wait.until(ExpectedConditions.elementToBeClickable(exitAuditButton));
			exitAuditButton.click();
			log.info("Clicked on Exit Audit Button");
			Thread.sleep(2000);
			if(switchoffmsg.isDisplayed())
			{
				log.info("DOT Inspection is OFF Now");
			}
			else
			{
				log.info("Unable to Switch Off DOT Inspection");
				Assert.fail("Unable to Switch Off DOT Inspection");
			}
			}
			catch(Exception e)
			{
				Assert.fail("Unable to Click on DOT Inspection OFF Button, Caught Exception");
			}
	}
	public void ValidateDOTInspectionDefault() {
		// TODO Auto-generated method stub
		try
		{
			Thread.sleep(5000);
			if(title.getText().equalsIgnoreCase("DOT inspection mode is turned on."))
			{
				log.info("DOT Inspection is ON now");
				SwitchOFFDOTInspection();
			}
			
		
		}
		catch(Exception e)
		{
			log.info("DOT Inspection is OFF");
		}
	}
	
	
	
}
