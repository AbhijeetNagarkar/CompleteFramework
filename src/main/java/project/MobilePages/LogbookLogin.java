package project.MobilePages;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import io.appium.java_client.android.AndroidDriver;
import java.util.List;
import static project.Actions.GenericKeywords.*;
import static project.Actions.Waits.*;
import static project.constants.ConstantDeclaration.*;

public class LogbookLogin {
	
	AndroidDriver driver;
	
	public static Logger log = Logger.getLogger(LogbookLogin.class);
	
	String Mobile,Dot,Pin;
		
	public LogbookLogin(AndroidDriver remoteWebDriver)
	{
			driver=remoteWebDriver;
			PageFactory.initElements(driver,this);
		
			//test data to login into the app, getting values using system variables 
			if((System.getenv().get("LOGBOOKENVIRONMENT"))!=null)
			{
				if((System.getenv().get("LOGBOOKENVIRONMENT")).equalsIgnoreCase(LOCALENVIRONMENT))
				{
					Mobile = System.getenv().get("LOGBOOKMOBILE");
					Dot = System.getenv().get("LOGBOOKDOT");
					Pin = System.getenv().get("LOGBOOKPIN");
				}
				else
				{
					System.out.println("Incorrect LOGBOOKENVIRONMENT in Environment variable");
				}
			}
			else if((System.getProperty("LOGBOOKENVIRONMENT"))!=null)
			{
				if((System.getProperty("LOGBOOKENVIRONMENT")).equalsIgnoreCase(JENKINSENVIRONMENT))
				{
					Mobile = System.getProperty("LOGBOOKMOBILE");
					Dot = System.getProperty("LOGBOOKDOT");
					Pin = System.getProperty("LOGBOOKPIN");
				}
				else
				{
					System.out.println("Incorrect LOGBOOKENVIRONMENT in Environment variable");
				}
			}
			else
			{
				log.info("Please setup Mobile,Dot,Pin environment variable to execute test suite");
				Assert.fail("Please setup Mobile,Dot,Pin environment variable to execute test suite");
			}
	}

	@FindBy(className="android.widget.EditText")
	List<WebElement> LoginEditText;
	
	@FindBy(xpath="//div[@class=\"ant-form-explain\"]")
	List<WebElement> blankmsg;
	
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.TextView")
	WebElement ContinueButton;
	
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.TextView")
	WebElement LoginButton;
	
	
	public void EnterPhoneNumber() throws InterruptedException
	{
		try
		{
			Wait(6);
			
			Click(LoginEditText.get(0));

			EnterNumber(Mobile);
		
			log.info("Phone Number Added");
		}
		catch(Exception e)
		{
			log.info(e.getLocalizedMessage());
			Assert.fail("Unable to Add Phone Number Login Screen");
		}
		
	}
	public void EnterDOTNumber()
	{
		try
		{
			Click(LoginEditText.get(1));
			
			EnterNumber(Dot);
			
			log.info("DOT Number Added");
		}
		catch(Exception e)
		{
			log.info(e.getLocalizedMessage());
			Assert.fail("Unable to Add DOT Number in Login Screen");
		}
	}
	
	public void EnterPINNumber()
	{
		try
		{
			LongWaitForMobileElementVisibility(By.className("android.widget.EditText"));
			
			Click(By.className("android.widget.EditText"));
			
			EnterNumber(Pin);

			log.info("PIN Number Entered");
		}
		catch(Exception e)
		{
			log.info(e.getLocalizedMessage());
			Assert.fail("Unable to Add PIN Number Login Screen");
		}
	}
	public void ClickOnContinue()
	{
		try
		{
			Click(ContinueButton);
			log.info("Clicked On Continue Button");
		}
		catch(Exception e)
		{
			log.info(e.getLocalizedMessage());
			Assert.fail("Unable to Click on Continue Button in Login Screen");
		}
	}
	
	public void ClickOnLogin()
	{
		try
		{
			Click(LoginButton);
			log.info("Clicked On Login Button");

		}
		catch(Exception e)
		{
			log.info(e.getLocalizedMessage());
			Assert.fail("Unable to clicked on Login button of Login Screen");
		}
	}
	
	public boolean validate() throws InterruptedException
	{
		return false;
	}
	
}
