package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.apache.logging.log4j.LogManager.getLogger;

public class ResultsPage extends BasePage{
    private final By sideBarFilters = By.className("facet-sidebar__contents");
    private final By minValuePrice = By.cssSelector("input[placeholder='Min']");
    private final By maxValuePrice = By.cssSelector("input[placeholder='Max']");
    private final By searchFilter = By.cssSelector("button[class='search-input-group__button']");
    private final By resulList = By.xpath("//li[contains(@class,'sortable-tile sortable-tile--4up-order')]");


    private static final Logger log = getLogger(LandingPage.class.getName());

    public ResultsPage (WebDriver driver){
        super(driver);
    }

    public By priceFilter(String minValue, String maxValue){
        WebDriverWait wait =new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(sideBarFilters));

        log.info("Setting Min price value");
        driver.findElements(minValuePrice).get(0).sendKeys(minValue);

        log.info("Setting Max price value");
        driver.findElements(maxValuePrice).get(0).sendKeys(maxValue);

        log.info("Clicking search");
        //wait.until(ExpectedConditions.elementToBeClickable(searchFilter));
        driver.findElements(searchFilter).get(1).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(resulList));

        return resulList;
    }


    public By orderPriceHighToLow() {

    }
}
