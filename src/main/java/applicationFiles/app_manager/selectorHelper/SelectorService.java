package applicationFiles.app_manager.selectorHelper;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static applicationFiles.app_manager.ApplicationManager.reportLog;
import static applicationFiles.framework.globalParameters.GlobalParameters.*;
import static org.testng.Assert.*;

public class SelectorService {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public SelectorService(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * this method makes WebDriver poll the DOM for a certain amount of time when trying to locate an element.
     * @param units time in seconds
     */
    public void implicit_Wait(int units) {
        driver.manage().timeouts().implicitlyWait(units, TimeUnit.SECONDS);
    }

    /**
     * this method will wait until completely load the page
     * @param units time in seconds
     */
    public void pageLoad_Timeout(int units) {
        driver.manage().timeouts().pageLoadTimeout(units, TimeUnit.SECONDS);
    }

    /**
     * this method will wait until the element to be visible by the locator
     * @param units time in seconds
     */
    protected WebElement visibilityOfElementLocatedBylocator(By locator, int units) //Visibility Of Element Located By Xpath
    {
        wait = new WebDriverWait(driver, units);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * this method will wait until the element to be clickable
     * @param locator this could be an attribute of an element
     */
    protected void waitElementToBeClickable(By locator) {
        wait = new WebDriverWait(driver,LONG_SLEEP_SEC);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        reportLog("Wait element to be clickable: (" + locator + ")");
    }

    /**
     * this method will wait until the element to be visible by the locator
     * @param locator this could be an attribute of an element
     * @param text this field is for
     */
    protected void click(By locator, String text) {
        visibilityOfElementLocatedBylocator(locator, LONG_SLEEP_SEC);
        waitElementToBeClickable(locator);
        if (isELementPresent(locator)) {
            driver.findElement(locator).click();
        }
        reportLog("Clicked '" + text + "' using element: (" + locator + ")");
    }

    public void type(By locator, String text) {//Click on field,clear field and enter the text
        String inputFieldText =  visibilityOfElementLocatedBylocator(locator, LONG_SLEEP_SEC).getText();
        driver.findElement(locator).click();
        if(inputFieldText != null) {
            driver.findElement(locator).clear();
        }
        driver.findElement(locator).sendKeys(text);
        reportLog("Typed: '" + text + "' in the field: (" + locator + ")");
    }

    public String getText(By locator) {
        implicit_Wait(PAGE_LOAD_TIMEOUT);
        return visibilityOfElementLocatedBylocator(locator, PAGE_LOAD_TIMEOUT).getText();
    }

    public String getAttribute(By locator, String value) {
        return driver.findElement(locator).getAttribute(value);
    }

    protected void selectAnOptionFromDropdown(By locator, int option){
        Select select = new Select(driver.findElement(locator));
        List<WebElement> options = select.getOptions();
        options.get(option).click();
    }

    public String getWebsiteTitle() {
        return driver.getTitle();
    }

    protected boolean isELementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            fail(ex.getMessage());
            return false;
        }
    }

    protected void assertNumberOfOptionsInDropdown(By locator, String text, int realAmount){
        reportLog("**** Check "+text+" in dropdown *******");
        List<WebElement> optionList = driver.findElement(locator).findElements(By.tagName("option"));
        WebElement element1 = driver.findElement(locator);
        Select select = new Select(element1);
        int numberOfOptions = select.getOptions().size();
        reportLog("Number of "+text+" --> "+ numberOfOptions);
        int j=1;
        for(WebElement option : optionList){
            reportLog(text+" -->"+" "+ option.getText());
            j++;
        }
        Assert.assertEquals(numberOfOptions,realAmount);
    }
}
