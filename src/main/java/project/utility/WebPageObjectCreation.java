package project.utility;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import project.webpages.*;

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
	
	WebPageLogout logoutPage;
	
	WebPageForgotPassword forgotpasswordPage;
	
	WebPageAdminRegistration adminregistrationPage;
	
	WebPageBillingDetails billingdetailsPage;
	
	WebPageIFTATrips iftatripsPage;
	
	WebPageIFTAReports iftareportsPage;
	
	WebPageLogbook logbookPage;
	
	WebPageUnAssignedDrive unassigneddrivePage;
	
	WebPageMessages messagePage;
	
	WebPageReports reportsPage;
	
	WebPageDriverSafety driverSafetyPage;
	
	WebPageDutyStatusSummary dutyStatusSummaryPage;
	
	WebPageTripHistory tripHistoryPage;
	
	WebPageUtilization utilizationPage;
	
	WebPageTemperatureHumidity temperaturehumidityPage;
	
	WebPagePreTripDVIR preTripPage;
	
	WebPagePostTripDVIR postTripPage;
	
	WebPageFuelEfficiency fuelefficiencyPage;
	
	WebPageELDLogbookEdits eldlogbookeditsPage;
	
	WebPageIdleTime idletimePage;
	
	WebPageHOSCompliance hoscompliancePage;
	
	public WebPageIdleTime IdleTimePageObject()
	{
		if(idletimePage==null)
		{
			log.info("Idle Time page object created");
			idletimePage = new WebPageIdleTime(driver);
		}
		return idletimePage;
	}
	
	public WebPageHOSCompliance HOSCompliancePageObject()
	{
		if(hoscompliancePage==null)
		{
			log.info("HOS Compliance page object created");
			hoscompliancePage = new WebPageHOSCompliance(driver);
		}
		return hoscompliancePage;
	}
	
	public WebPagePostTripDVIR PostTripPageObject()
	{
		if(postTripPage==null)
		{
			log.info("Post Trip DVIR page object created");
			postTripPage = new WebPagePostTripDVIR(driver);
		}
		return postTripPage;
	}
	
	public WebPagePreTripDVIR PreTripPageObject()
	{
		if(preTripPage==null)
		{
			log.info("Pre Trip DVIR page object created");
			preTripPage = new WebPagePreTripDVIR(driver);
		}
		return preTripPage;
	}
	
	public WebPageTemperatureHumidity TemperatureHumidityPageObject()
	{
		if(temperaturehumidityPage==null)
		{
			log.info("Temperature and Humidity page object created");
			temperaturehumidityPage = new WebPageTemperatureHumidity(driver);
		}
		return temperaturehumidityPage;
	}
	
	public WebPageFuelEfficiency FuelEfficiencyPageObject()
	{
		if(fuelefficiencyPage==null)
		{
			log.info("Fuel Efficiency page object created");
			fuelefficiencyPage = new WebPageFuelEfficiency(driver);
		}
		return fuelefficiencyPage;
	}
	
	public WebPageELDLogbookEdits ELDLogbookEditsPageObject()
	{
		if(eldlogbookeditsPage==null)
		{
			log.info("ELD Logbook Edits page object created");
			eldlogbookeditsPage = new WebPageELDLogbookEdits(driver);
		}
		return eldlogbookeditsPage;
	}
	
		
	public WebPageTripHistory TripHistoryPageObject()
	{
		if(tripHistoryPage==null)
		{
			log.info("Trip History page object created");
			tripHistoryPage = new WebPageTripHistory(driver);
		}
		return tripHistoryPage;
	}
	public WebPageUtilization UtilizationPageObject()
	{
		if(utilizationPage==null)
		{
			log.info("Utilization page object created");
			utilizationPage = new WebPageUtilization(driver);
		}
		return utilizationPage;
	}
	public WebPageDriverSafety DriverSafetyPageObject()
	{
		if(driverSafetyPage==null)
		{
			log.info("Driver Safety page object created");
			driverSafetyPage = new WebPageDriverSafety(driver);
		}
		return driverSafetyPage;
	}
	
	public WebPageDutyStatusSummary DutyStatusSummaryPageObject()
	{
		if(dutyStatusSummaryPage==null)
		{
			log.info("Duty Status Summary page object created");
			dutyStatusSummaryPage = new WebPageDutyStatusSummary(driver);
		}
		return dutyStatusSummaryPage;
	}
	
	public WebPageReports ReportsPageObject()
	{
		if(reportsPage==null)
		{
			log.info("Reports page object created");
			reportsPage = new WebPageReports(driver);
		}
		return reportsPage;
	}
	
	
	public WebPageUnAssignedDrive UnAssignedDrivePageObject()
	{
		if(unassigneddrivePage==null)
		{
			log.info("UnAssigned Drive page object created");
			unassigneddrivePage = new WebPageUnAssignedDrive(driver);
		}
		return unassigneddrivePage;
	}
	
	public WebPageMessages MessagesPageObject()
	{
		if(messagePage==null)
		{
			log.info("Messages page object created");
			messagePage = new WebPageMessages(driver);
		}
		return messagePage;
	}
	
	public WebPageIFTAReports IFTAReportsPageObject()
	{
		if(iftareportsPage==null)
		{
			log.info("IFTA Reports page object created");
			iftareportsPage = new WebPageIFTAReports(driver);
		}
		return iftareportsPage;
	}
	
	public WebPageLogbook LogbookPageObject()
	{
		if(logbookPage==null)
		{
			log.info("Logbook page object created");
			logbookPage = new WebPageLogbook(driver);
		}
		return logbookPage;
	}
	
	
	
	
	public WebPageBillingDetails BillingDetailsPageObject()
	{
		if(billingdetailsPage==null)
		{
			log.info("Billing Details page object created");
			billingdetailsPage = new WebPageBillingDetails(driver);
		}
		return billingdetailsPage;
	}
	
	public WebPageIFTATrips IFTATripsPageObject()
	{
		if(iftatripsPage==null)
		{
			log.info("IFTA Trips page object created");
			iftatripsPage = new WebPageIFTATrips(driver);
		}
		return iftatripsPage;
	}
	
	
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
	public WebPageLogout logoutPageObject()
	{
		if(logoutPage==null)
		{
			log.info("Logout page object created");
			logoutPage = new WebPageLogout(driver);
		}
		return logoutPage;
	}
	public WebPageForgotPassword forgotPasswordObject()
	{
		if(forgotpasswordPage==null)
		{
			log.info("Forgot password page object created");
			forgotpasswordPage = new WebPageForgotPassword(driver);
		}
		return forgotpasswordPage;
	}
	public WebPageAdminRegistration adminRegistrationObject()
	{
		if(adminregistrationPage==null)
		{
			log.info("Admin Registration page object created");
			adminregistrationPage = new WebPageAdminRegistration(driver);
		}
		return adminregistrationPage;
	
	}
}
