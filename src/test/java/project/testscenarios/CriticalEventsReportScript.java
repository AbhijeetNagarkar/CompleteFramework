package project.testscenarios;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import project.mediator.ObjectRepository;
import project.utility.WebPageObjectCreation;

import java.io.IOException;

public class CriticalEventsReportScript {
    WebPageObjectCreation repo;

    public static Logger log = Logger.getLogger(CriticalEventsReportScript.class);
    private static final String criticalEventsGroup = "Critical Events Reports";

    @BeforeClass
    public void Fetct_Repository_Object() throws InterruptedException, IOException
    {
        repo = ObjectRepository.GetInstance();
    }

    @Test(priority = 1,groups = {criticalEventsGroup})
    public void navigatingCriticalEventsPage() throws InterruptedException
    {
        repo.dashboardPageObject().clickOnReports();

        repo.dashboardPageObject().clickOnReportsSubMenu();

        repo.ReportsPageObject().ClickOnCriticalEvents();
    }

    @Test(priority = 2,groups = {criticalEventsGroup}, dependsOnMethods = "navigatingCriticalEventsPage" )
    public void filterAndVerification() throws InterruptedException
    {
        Assert.assertTrue(repo.CriticalEventsObject().filterAndVerification(),"Records not showing as per filter criteria");
    }

}
