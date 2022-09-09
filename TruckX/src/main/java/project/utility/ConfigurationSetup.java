package project.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;
import static project.constants.GlobalDeclaration.*;

public class ConfigurationSetup
{
		private WebDriver driver;
		
		private String browser;
		
		private String url;
		
		public static Logger log;
		
		@BeforeSuite
		public void preRequisite(ITestContext context) throws IOException
		{
			configureLogger();
			
			configureSetup();
			
			browserSetup(browser);
			
			navigateToUrl(url);
			
			context.setAttribute("WebDriver", driver);
	
		}
		
		private void configureLogger() 
		{
			PropertyConfigurator.configure(log4jPath);
			
			log = Logger.getLogger(ConfigurationSetup.class);
					
			log.info("Configured Logger File");
			log.info("Before Suite Invoked");
		}
		
		private void configureSetup() throws IOException 
		{
			Properties prop = new Properties();
			FileInputStream stream = null;
			try 
			{
				log.info("Opening Run Config File to setup properties");
				stream = new FileInputStream(new File(RunConfigPath));
				prop.load(stream);
				log.info("Run Config File is loaded");
			}
			catch (FileNotFoundException e) 
			{
				System.out.println("File not available to create test configuration");
				log.error("Run Config File Not available");
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			finally
			{
				stream.close();
			}
			
			browser = prop.getProperty("BrowserName");
			log.info("Running on "+browser);
			url = prop.getProperty("URL");
			log.info("Targetting on "+url);
			
		}
		public void browserSetup(String browser)
		{
			switch(browser)
			{
				case "FireFox" : WebDriverManager.firefoxdriver().setup();
								 driver = new FirefoxDriver();
								 break;
								 
				case "Chrome"  : WebDriverManager.chromedriver().setup();
								 driver = new ChromeDriver();
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
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
	
		public void navigateToUrl(String url)
		{
			driver.get(url);
			log.info(" Navigating to "+url);
			
		}
		
		public WebDriver getDriverInstance()
		{
			return driver;
		}
		
		public void refreshPage()
		{
			driver.navigate().refresh();
		}
		
		@AfterSuite
		public void closeBrowser() 
		{
			driver.quit();
			log.info("Closing browser");
		}
}


