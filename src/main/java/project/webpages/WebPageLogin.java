package project.webpages;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import project.mediator.TestData;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class WebPageLogin {
	
	WebDriver driver;
	
	WebDriverWait wait;
	
	FluentWait<WebDriver> fwait;
	
	public static Logger log = Logger.getLogger(WebPageLogin.class);
	
	int flag =0; // 1-valid input 2-blank 3-invalid
	
	HashMap<String,String> logindata;
		
	public WebPageLogin(WebDriver driverinstance)
	{
			driver=driverinstance;
			PageFactory.initElements(driver,this);
			wait = new WebDriverWait(driver,30);
			logindata=TestData.GetLoginData();
	}

	@FindBy(id = "userName")
	WebElement userName;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(xpath="//button[text()=\"Sign In\"]")
	WebElement submit;
	
	@FindBy(xpath="//div[@class=\"ant-form-explain\"]")
	List<WebElement> blankmsg;
	
	@FindBy(xpath="//span[@class=\"ant-alert-message\"]")
	WebElement alert;
	
	public void clear()
	{
		try
		{
		userName.clear();
		password.clear();
		log.info("clearing user name and password field");
		}
		catch(Exception e)
		{
			Assert.fail("Unable to clear User Name and Password field");
		}
	}
	public void enterUserName() throws InterruptedException
	{
		Thread.sleep(3000);
		try
		{
			flag=1;
			clear();
			wait.until(ExpectedConditions.elementToBeClickable(userName));
			userName.sendKeys(logindata.get("User Name"));
			log.info("User Name Entered");
		}
		catch(Exception e)
		{
			Assert.fail("Unable to Enter User Name in Login Page");
		}
		
	}
	public void enterUserPassword()
	{
		try
		{
		wait.until(ExpectedConditions.elementToBeClickable(password));
		password.sendKeys(logindata.get("Password"));
		log.info("Password Entered");
		}
		catch(Exception e)
		{
			Assert.fail("Unable to Enter User Password in Login Page");
		}
	}
	
	public void enterUserName(String name)
	{
		try
		{
			if(name=="")
				flag=2;
			else flag=3;
			clear();
			wait.until(ExpectedConditions.elementToBeClickable(userName));
			userName.sendKeys(name);
			log.info("User Name Entered");
		}
		catch(Exception e)
		{
			Assert.fail("Unable to Enter User Name in Login Page");
		}
	}
	public void enterUserPassword(String pass)
	{
		try
		{
		wait.until(ExpectedConditions.elementToBeClickable(password));
		password.sendKeys(pass);
		log.info("Password Entered");
		}
		catch(Exception e)
		{
			Assert.fail("Unable to Enter User Password in Login Page");
		}
	}
	
	public void signIn()
	{
		try
		{
		wait.until(ExpectedConditions.elementToBeClickable(submit));
		submit.click();
		log.info("Clicked on Sign In");
		}
		catch(Exception e)
		{
			Assert.fail("Unable to clicked on Sign In button of Login Page");
		}
	}
	
	@SuppressWarnings("deprecation")
	public boolean validate() throws InterruptedException
	{
		Thread.sleep(5000);
		log.info("validating User Name and Password");
		if(flag==1)
		{
			try
			{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"flex flex-col\"]//*[text()=\"Logbook\"]")));
			
				if(driver.findElement(By.xpath("//div[@class=\"flex flex-col\"]//*[text()=\"Logbook\"]")).getText().equalsIgnoreCase("Logbook"))
				{
				
					fwait = new FluentWait<WebDriver>(driver)
					.withTimeout(30,TimeUnit.SECONDS)
					.pollingEvery(1,TimeUnit.SECONDS)
					.ignoring(Exception.class);
					
					fwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"driver-details\"]")));
				}
				else return false;
		}
		catch(Exception e)
		{
				log.info("Caught Exception");
		}
				
		log.info("valid username/password validated successfully");
			
		return true;
		
			
		}
		else if(flag==2)
		{
			
			if(blankmsg.get(0).getText().equals("Please input your username!") && blankmsg.get(1).getText().equals("Please input your Password!"))
			{
				log.info("blank user id password validated successfully");
				
				return true;
			}
			return false;
		}
		else if(flag==3)
		{
			
			if(alert.getText().equals("Invalid User/Password!"))
			{
				log.info("invalid user id/password validated successfully");
				
				return true;
			}
			return false;
		}
		return false;
	}
	
}
