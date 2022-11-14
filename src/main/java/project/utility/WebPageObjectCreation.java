package project.utility;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import project.webpages.WebPageAPIKeyTransfer;
import project.webpages.WebPageAlerts;
import project.webpages.WebPageAssets;
import project.webpages.WebPageCompanyProfile;
import project.webpages.WebPageDashCamera;
import project.webpages.WebPageDashboard;
import project.webpages.WebPageDeletedDrivers;
import project.webpages.WebPageDrivers;
import project.webpages.WebPageELDDevices;
import project.webpages.WebPageFeature;
import project.webpages.WebPageLogin;
import project.webpages.WebPageTrackingDevices;
import project.webpages.WebPageTrackingLinks;
import project.webpages.WebPageTrailer;
import project.webpages.WebPageTruck;

public class WebPageObjectCreation {

	private WebDriver driver;
	
	public static Logger log = Logger.getLogger(WebPageObjectCreation.class);
	
	public WebPageObjectCreation(WebDriver driverinstance)
	{
		this.driver=driverinstance;
		log.info("Repository object created to fetch Web Pages object");
	}
	
	
	WebPageLogin loginPage;
	
	WebPageDashboard dashboardPage;
	
	WebPageTruck truckPage;
	
	WebPageTrailer trailerPage;
	
	WebPageTrackingDevices trackingPage;
	
	WebPageDashCamera dashCameraPage;
	
	WebPageELDDevices eldDevicesPage;
	
	WebPageTrackingLinks trackingLinksPage;
	
	WebPageAssets assetsPage;
	
	WebPageCompanyProfile companyprofilepage;
	
	WebPageDeletedDrivers deleteddrivers;
	
	WebPageDrivers drivers;
	
	WebPageAPIKeyTransfer apikeypage;
	
	WebPageFeature featurepage;
	
	WebPageAlerts alertspage;
	
	public WebPageAlerts AlertPageObject()
	{
		if(alertspage==null)
		{
			log.info("Alerts page object created");
			alertspage = new WebPageAlerts(driver);
		}
		return alertspage;
	}
	
	public WebPageFeature FeaturePageObject()
	{
		if(featurepage==null)
		{
			log.info("Feature page object created");
			featurepage = new WebPageFeature(driver);
		}
		return featurepage;
	}
	
	public WebPageAPIKeyTransfer APIKeyTransferPageObject()
	{
		if(apikeypage==null)
		{
			log.info("API Key Transfer page object created");
			apikeypage = new WebPageAPIKeyTransfer(driver);
		}
		return apikeypage;
	}
	
	public WebPageDeletedDrivers deletedDriversPageObject()
	{
		if(deleteddrivers==null)
		{
			log.info("Deleted Drivers page object created");
			deleteddrivers = new WebPageDeletedDrivers(driver);
		}
		return deleteddrivers;
	}
	
	public WebPageDrivers DriversPageObject()
	{
		if(drivers==null)
		{
			log.info("Drivers page object created");
			drivers = new WebPageDrivers(driver);
		}
		return drivers;
	}
	
	public WebPageCompanyProfile companyProfilePageObject()
	{
		if(companyprofilepage==null)
		{
			log.info("Company Profile page object created");
			companyprofilepage = new WebPageCompanyProfile(driver);
		}
		return companyprofilepage;
	}

	public WebPageTrackingLinks trackinglinksPageObject()
	{
		if(trackingLinksPage==null)
		{
			log.info("Tracking Links page object created");
			trackingLinksPage = new WebPageTrackingLinks(driver);
		}
		return trackingLinksPage;
	}
	public WebPageAssets assetsPageObject()
	{
		if(assetsPage==null)
		{
			log.info("Assets page object created");
			assetsPage = new WebPageAssets(driver);
		}
		return assetsPage;
	}
	public WebPageLogin loginPageObject()
	{
		if(loginPage==null)
		{
			log.info("Login page object created");
			loginPage = new WebPageLogin(driver);
		}
		return loginPage;
	}
	public WebPageDashboard dashboardPageObject()
	{
		if(dashboardPage==null)
		{
			log.info("Dashboard page object created");
			dashboardPage = new WebPageDashboard(driver);
		}
		return dashboardPage;
	}
	public WebPageTruck truckPageObject()
	{
		if(truckPage==null)
		{
			log.info("Truck page object created");
			truckPage = new WebPageTruck(driver);
		}
		return truckPage;
	}
	
	public WebPageTrailer trailerPageObject()
	{
		if(trailerPage==null)
		{
			log.info("Trailer page object created");
			trailerPage = new WebPageTrailer(driver);
		}
		return trailerPage;
	}
	public WebPageTrackingDevices trackingDevicesPageObject()
	{
		if(trackingPage==null)
		{
			log.info("Tracking Devices page object created");
			trackingPage = new WebPageTrackingDevices(driver);
		}
		return trackingPage;
	}
	public WebPageDashCamera dashCameraPageObject()
	{
		if(dashCameraPage==null)
		{
			log.info("Dash Camera page object created");
			dashCameraPage = new WebPageDashCamera(driver);
		}
		return dashCameraPage;
	}
	public WebPageELDDevices eldDevicesPageObject()
	{
		if(eldDevicesPage==null)
		{
			log.info("ELD Devices page object created");
			eldDevicesPage = new WebPageELDDevices(driver);
		}
		return eldDevicesPage;
	}
	
	
}
