package project.utility;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import project.Mediator.APITestData;
import project.Mediator.DriverRepository;
import project.Mediator.MobileTestData;
import project.Mediator.UITestData;

import static project.constants.ConstantDeclaration.*;
import static project.APIConfiguration.URL.*;
public class ConfigurationSetup
{
		private AndroidDriver Androiddriver;
		
		private WebDriver Webdriver;
		
		public static Logger log;
		
		URL url;
		
		@BeforeSuite
		@Parameters("Suite Type")
		public void preRequisite(String suitetype,ITestContext context) throws IOException, InterruptedException
		{
			configureLogger();
			
			loadTestData(suitetype);
		
			setup(suitetype,context);
		}
	
		private void configureLogger() 
		{
			PropertyConfigurator.configure(log4jPath);
			
			log = Logger.getLogger(ConfigurationSetup.class);
					
			log.info("Configured Logger File");
		}
		
		private void loadTestData(String suitetype) throws IOException 
		{
			ExcelUtility xls = new ExcelUtility();
			
			log.info("Loading Test Data Activity started...");
			
			if(suitetype.equalsIgnoreCase("Mobile"))
			{
				MobileTestData.SetConfigurationData(xls.fetchdata(suitetype,"Configuration"));
			
				EmailConfig.SendEmail = MobileTestData.GetConfigurationData().get("Send Mail");
			
				EmailConfig.SUBJECT = "Mobile Automation Report";
			}
			
			else if(suitetype.equalsIgnoreCase("API"))
			{
				APITestData.SetUserId(xls.fetchdata(suitetype,"User"));

				APITestData.SetMailDetails(xls.fetchdata(suitetype,"Mail"));
				
				APITestData.SetStageTestData(xls.fetchdata(suitetype,"stage"));

				APITestData.SetProdTestData(xls.fetchdata(suitetype,"prod"));
				
				EmailConfig.SendEmail = APITestData.GetMailDetails().get("Send Mail");
				
				EmailConfig.SUBJECT = "API Automation Report";
						
			}
			
			else if(suitetype.equalsIgnoreCase("UI"))
			{
				UITestData.SetLoginData(xls.fetchdata(suitetype,"Login"));
		
				UITestData.SetConfigurationData(xls.fetchdata(suitetype,"Configuration"));
				
				EmailConfig.SendEmail = UITestData.GetConfigurationData().get("Send Mail");
								
				EmailConfig.SUBJECT = "UI Automation Report";
			}
			
			log.info("Loading Test Data Activity Completed\n");
		}
		
		
		private void setup(String suitetype,ITestContext context) throws MalformedURLException, InterruptedException 
		{
			if(suitetype.equalsIgnoreCase("Mobile"))
			{
				MobileSetup(MobileTestData.GetConfigurationData().get("Platform"));
				context.setAttribute("Driver", Androiddriver);
			}
			else if(suitetype.equalsIgnoreCase("API"))
			{
				APIurl=ProdURL;   // ProdURL or stageURL or qaURL  basically URI and testing we can add end points
			}
			else if(suitetype.equalsIgnoreCase("UI"))
			{
				WebSetup(UITestData.GetConfigurationData().get("Browser"));
				context.setAttribute("Driver", Webdriver);
			}
		}

		public void WebSetup(String Browser) {
			
			switch(Browser)
			{
				case "FireFox" : WebDriverManager.firefoxdriver().setup();
								 FirefoxOptions options = new FirefoxOptions();
							  //   options.setHeadless(true);
							     Webdriver = new FirefoxDriver(options);
								 break;
								 		 
				case "Chrome"  : WebDriverManager.chromedriver().setup();
								 ChromeOptions chrome_options = new ChromeOptions();
								 chrome_options.addArguments("--no-sandbox");
							//	 chrome_options.addArguments("--headless");
							//	 chrome_options.addArguments("--disable-web-security");
								 chrome_options.addArguments("--ignore-ssl-errors=yes");
								 chrome_options.addArguments("--ignore-certificate-errors");
								 Webdriver = new ChromeDriver(chrome_options);
								
								 break;
								 
				case "IE"      : WebDriverManager.iedriver().setup();
								 Webdriver = new InternetExplorerDriver();
								 break;
								 
				case "Safari"  : WebDriverManager.safaridriver().setup();
								 Webdriver = new SafariDriver();			
								 break;
				default 	   : break; 
			}
			log.info(Browser+" setup completed successfully");
			Webdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Webdriver.manage().window().maximize();
			
			try
			{
			//	url="https://web.truckx.com/#/login";
				log.info(" Navigating to "+UITestData.GetConfigurationData().get("Environment"));
				Webdriver.get(UITestData.GetConfigurationData().get("Environment"));
			//	Webdriver.get("https://35.238.126.102/login");

				FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(Webdriver)
				.withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(Exception.class);
				
				fwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName")));
			
				DriverRepository.SetWebDriver(Webdriver);
			}
			catch(Exception e)
			{
				log.info("Site is down, unable to load page and caught and exception : "+e.getMessage());
				Assert.fail("Site is down, unable to load page and caught and exception : "+e.getMessage());
			}
			
		}

		public void MobileSetup(String Platform) throws MalformedURLException, InterruptedException
		{
			if(MobileTestData.GetConfigurationData().get("Environment").equalsIgnoreCase("Local"))
			{
				url = new URL(MobileTestData.GetConfigurationData().get("Local URL"));
				log.info("Targetting to Local Environment");
				log.info("Executing Suite on Local Machine");
			
				switch(Platform)
				{
					case "Android": DesiredCapabilities cap = new DesiredCapabilities();
									cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"23");
									cap.setCapability("udid","c724aacf");
									cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"ANDROID");
									cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Redmi Note 5 Pro");
									cap.setCapability("appPackage","com.truckx.app");
									File f1=new File("C:\\Space\\Software\\Driver-App-Canada-Prod-v7.apk");
									cap.setCapability("app",f1.getAbsolutePath());
									Androiddriver = new AndroidDriver(url, cap);
									log.info("Working on Android Platform");
									break;
					case "IOS"    : log.info("Working on IOS Platform");
									break;
					 
					default 	  : break; 
				}
			}
			
			else
			{	 
				if((System.getenv().get("LOGBOOKENVIRONMENT"))!=null)
				{
					if((System.getenv().get("LOGBOOKENVIRONMENT")).equalsIgnoreCase(LOCALENVIRONMENT))
					{
						url = new URL(System.getenv().get("SAUCELABLINK"));
						log.info("Executing Suite on Local Machine");
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
						url= new URL(System.getProperty("SAUCELABLINK"));
						log.info("Executing Suite on Jenkins Machine");
					}
					else
					{
						System.out.println("Incorrect LOGBOOKENVIRONMENT in Environment variable");
					}
				}
				
				else
				{
					log.info("Please setup environment variable to execute test suite");
					Assert.fail("Please setup environment variable to execute test suite");
				}
				
				log.info("Targetting to Sauce Lab Environment");
			
				switch(Platform)
				{
					case "Android": MutableCapabilities caps = new MutableCapabilities();
									caps.setCapability("platformName", "Android");
									caps.setCapability("appium:app", "storage:filename=Driver-App-Canada-Prod-v7.apk"); // The filename of the mobile app
									caps.setCapability("appium:deviceName", "Android GoogleAPI Emulator");
									caps.setCapability("appium:platformVersion", "11.0");
									caps.setCapability("appium:automationName", "UiAutomator2");
									MutableCapabilities sauceOptions = new MutableCapabilities();
									sauceOptions.setCapability("appiumVersion", "1.22.1");
									sauceOptions.setCapability("build", "v1");
									sauceOptions.setCapability("name", "Logbook App Automation");
									caps.setCapability("sauce:options", sauceOptions);
									Androiddriver = new AndroidDriver(url, caps);
									log.info("Working on Android Platform");
									break;
									 
					case "IOS"    : log.info("Working on IOS Platform");
									break;
									 
					default 	  : break; 
				}
			
			}
			DriverRepository.SetAndroidDriver(Androiddriver);
		}
	
		@AfterSuite
		@Parameters("Suite Type")
		public void closeBrowser(String suitetype) throws InterruptedException 
		{
			try
			{
					Thread.sleep(7000);
					if(DriverRepository.GetAndroidDriver()!=null)
							DriverRepository.GetAndroidDriver().quit();
					else if(DriverRepository.GetWebDriver()!=null)
							DriverRepository.GetWebDriver().quit();
					log.info("Killing Instance");
			}
			catch(Exception e)
			{
				
			}
			
			
		}
}


