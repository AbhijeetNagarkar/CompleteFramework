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
import static project.constants.GlobalDeclaration.*;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class WebPageLogin {
	
	WebDriver driver;
	
	WebDriverWait wait;
	
	FluentWait<WebDriver> fwait;
	
	public static Logger log = Logger.getLogger(WebPageLogin.class);
	
	int flag =0; // 1-valid input 2-blank 3-invalid
	
	long starttime=0;
	
	long totaltime=0;
	
		
	public WebPageLogin(WebDriver driverinstance)
	{
			driver=driverinstance;
			PageFactory.initElements(driver,this);
			wait = new WebDriverWait(driver,30);
			
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
		userName.clear();
		password.clear();
		log.info("clearing user name and password field");
	}
	public void enterUserName()
	{
		flag=1;
		clear();
		wait.until(ExpectedConditions.elementToBeClickable(userName));
		userName.sendKeys(USERNAME);
		log.info("User Name Entered");
	}
	public void enterUserPassword()
	{
		wait.until(ExpectedConditions.elementToBeClickable(password));
		password.sendKeys(lOGINPASSWORD);
		log.info("Password Entered");
	}
	
	public void enterUserName(String name)
	{
		if(name=="")
			flag=2;
		else flag=3;
		clear();
		wait.until(ExpectedConditions.elementToBeClickable(userName));
		userName.sendKeys(name);
		log.info("User Name Entered");
	}
	public void enterUserPassword(String pass)
	{
		wait.until(ExpectedConditions.elementToBeClickable(password));
		password.sendKeys(pass);
		log.info("Password Entered");
	}
	
	public void signIn()
	{
		wait.until(ExpectedConditions.elementToBeClickable(submit));
		submit.click();
		starttime=System.currentTimeMillis();
		log.info("Clicked on Sign In");
	}
	
	@SuppressWarnings("deprecation")
	public boolean validate() throws InterruptedException
	{
		Thread.sleep(4000);
		log.info("validating User Name and Password");
		if(flag==1)
		{
			
			if(driver.findElement(By.xpath("//div[@class=\"flex flex-col\"]//*[text()=\"Logbook\"]")).getText().equalsIgnoreCase("Logbook"))
			{
				fwait = new FluentWait<WebDriver>(driver)
				.withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS)
				.ignoring(Exception.class);
				
				fwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"driver-details\"]")));
				totaltime=System.currentTimeMillis()-starttime;  //calcualting navingation time
				
				totaltime=totaltime/1000;   //for seconds conversion 
				
				log.info("Time taken to Load Dashboard Page : "+totaltime+" seconds");
				
				log.info("valid username/password validated successfully");
				
				return true;
			}
			return false;
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
