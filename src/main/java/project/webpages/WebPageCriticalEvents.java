package project.webpages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WebPageCriticalEvents {
    WebDriver driver;

    WebDriverWait wait;

    public static Logger log = Logger.getLogger(WebPageCriticalEvents.class);

    public WebPageCriticalEvents(WebDriver driverInstance)
    {
        driver = driverInstance;

        PageFactory.initElements(driver,this);

        wait = new WebDriverWait(driver,10);
    }


    // Quick Selection webelement
    @FindBy(xpath = "//div[@class=\"flex items-center\"]//span[text()=\"Quick Selection\"]")
    WebElement filter;

    // select first option from Quick Selection
    @FindBy(xpath = "//div[@class=\"cursor-pointer\"]//span")
    List<WebElement> filterOption;

    /* *
    * Reset button of Date Range
    * Precondition: Pop-up should be opened / Must click on date range.
    *  */
    @FindBy(xpath = "//div[@id=\"popup-root\"]//div[@class=\"pb-4 flex flex-row items-center justify-center\"]//button")
    WebElement resetFilter;

    @FindBy(xpath = "//div[@class=\"flex items-center\"]//span[text()=\"Reset All\"]")
    WebElement resetAllFilter;

    @FindBy(xpath = "//div[@class=\"ml-10 mt-2\"]//span")
    WebElement changefocus;

    public Boolean filterAndVerification()
    {
        try
        {
            String quickSelectXpath = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[2]/div/div[1]/div/div[1]/span";
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(quickSelectXpath)));
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
            log.info("Clicked on Filter");

            filterOption.get(1).click();
            log.info("Clicked on last week report");

            String dataItemsXpath = "//tbody[@class=\"rc-table-tbody\"]//tr[contains(@class, \"rc-table-row\")]";
            List<WebElement> ele = wait.until(ExpectedConditions.visibilityOfAllElements(
                    driver.findElements(By.xpath(dataItemsXpath))));

            if(ele.size() > 0)
                log.info("Records available for last week."); // + filterOption.get(1).getText());
            else
                log.info("Records not available for last week"); // + filterOption.get(1).getText());

            resetAllFilter.click();
            log.info("Clicked on Reset Filter Button");

            return true;
        }
        catch (Exception e) {
            log.info("Filter and verification functionality not working ");
            System.out.println(e.getMessage());
            return false;
        }

    }

}
