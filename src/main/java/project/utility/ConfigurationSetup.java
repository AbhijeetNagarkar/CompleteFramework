package project.utility;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;
import project.mediator.Driver;
import project.mediator.ObjectRepository;
import project.mediator.TestData;

import static project.constants.FilePathDeclaration.*;

public class ConfigurationSetup
{
		private WebDriver driver;
		
		public static Logger log;
		
		public WebPageObjectCreation repo;
		
		@BeforeSuite
		public void preRequisite(ITestContext context) throws IOException
		{
			configureLogger();
			
			loadTestData();
						
			browserSetup(TestData.GetConfigurationData().get("Browser"));
			
			navigateToUrl(TestData.GetConfigurationData().get("Environment"));
			
			context.setAttribute("WebDriver", driver);
		}
				
		
				
		private void configureLogger() 
		{
			PropertyConfigurator.configure(log4jPath);
			
			log = Logger.getLogger(ConfigurationSetup.class);
					
			log.info("Configured Logger File");
		}
		
		private void loadTestData() throws IOException 
		{
			ExcelUtility xls = new ExcelUtility();
			
			TestData.SetVehicleData(xls.fetchdata("Truck"));
			TestData.SetTrailerData(xls.fetchdata("Trailer"));
			TestData.SetDeviceData(xls.fetchdata("Device"));
			TestData.SetLoginData(xls.fetchdata("Login"));
			TestData.SetConfigurationData(xls.fetchdata("Configuration"));
			TestData.SetCompanyProfileData(xls.fetchdata("Company_Profile"));
			TestData.SetForgotPasswordData(xls.fetchdata("ForgotPassword"));
			TestData.SetAdminRegistrationData(xls.fetchdata("AdminRegistration"));
			TestData.SetDriversData(xls.fetchdata("Drivers"));

			log.info("Test Data Loaded for Test Script");
		}

		public void browserSetup(String browser)
		{
			switch(browser)
			{
				case "FireFox" : WebDriverManager.firefoxdriver().setup();
								 FirefoxOptions options = new FirefoxOptions();
							     options.setHeadless(true);
							     driver = new FirefoxDriver(options);
								 break;
								 		 
				case "Chrome"  : WebDriverManager.chromedriver().setup();
								 ChromeOptions chrome_options = new ChromeOptions();
								 chrome_options.addArguments("--no-sandbox");
								 chrome_options.addArguments("--headless");
								 chrome_options.addArguments("--ignore-ssl-errors=yes");
								 chrome_options.addArguments("--ignore-certificate-errors");
						//		 chrome_options.addArguments("start-maximized"); 
						//		 chrome_options.addArguments("enable-automation"); 
						//		 chrome_options.add_experimental_option("excludeSwitches", ["enable-automation"])
						//		 chrome_options.add_experimental_option("useAutomationExtension",);
							//	 chrome_options.setExperimentalOption(browser, chrome_options)
						//		 chrome_options.addArguments("--disable-dev-shm-usage");
						//		 chrome_options.addArguments("--disable-browser-side-navigation"); 
						//		 chrome_options.addArguments("--disable-gpu"); 
						//		 chrome_options.setPageLoadStrategy(PageLoadStrategy.NONE);
						//		 System.setProperty("webdriver.chrome.silentOutput","true");
								 driver = new ChromeDriver(chrome_options);
								
								 break;
								 
				case "IE"      : WebDriverManager.iedriver().setup();
								 driver = new InternetExplorerDriver();
								 break;
								 
				case "Safari"  : WebDriverManager.safaridriver().setup();
								 driver = new SafariDriver();			
								 break;
				default 	   : break; 
			}
			log.info(browser+" setup completed successfully");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//	driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
		//	driver.manage().timeouts().setScriptTimeout(1, TimeUnit.MINUTES);
			driver.manage().window().maximize();
			
		}
	
		public void navigateToUrl(String url)
		{
			try
			{
			//	url="https://web.truckx.com/#/login";
				url="https://35.238.126.102/#/login";
				log.info(" Navigating to "+url);
				driver.get(url);
	
				FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(Exception.class);
				
				fwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName")));
				
				ObjectRepository.SetInstance(new WebPageObjectCreation(driver));
				
				Driver.SetDriver(driver);
			}
			catch(Exception e)
			{
				log.info("Site is down, unable to load page and caught and exception : "+e.getMessage());
				Assert.fail("Site is down, unable to load page and caught and exception : "+e.getMessage());
			}
		}
	
		@AfterSuite
		public void closeBrowser() throws InterruptedException 
		{
			Thread.sleep(5000);
			driver.quit();
			log.info("Closing browser");
		}
}


