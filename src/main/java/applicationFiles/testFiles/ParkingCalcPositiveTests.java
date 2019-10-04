package applicationFiles.testFiles;

import applicationFiles.app_manager.modelData.CalculatorData;
import applicationFiles.app_manager.testBase.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static applicationFiles.app_manager.ApplicationManager.*;
import static applicationFiles.framework.globalParameters.GlobalParameters.*;
import static org.openqa.selenium.By.*;
import static org.testng.Assert.*;

public class ParkingCalcPositiveTests extends TestBase {

    //Span Fields
    private By costSpanField = xpath("//b[@id='cost']");

    private CalculatorData calcData = new CalculatorData();

    @Priority(1)
    @Test(priority = 1,description = "Check website title and availability of the fields")
    public void checkTitleAndHeader(){
        String websiteTitle = app.getSelectorService().getWebsiteTitle();
        if(!websiteTitle.isEmpty()) {
            reportLog("Website Title is: " + websiteTitle);
            assertEquals(websiteTitle,"ParkCalc Javascript Test Harness");
        }
        String websiteHeader = app.getParkingCalcPage().checkWebsiteHeader();
        reportLog("Website Header is: "+ websiteHeader);
        assertEquals(websiteHeader,"PARKING CALCULATOR");
    }

    /*
    ASSUMING THAT THE TEST YEARS ARE 2000 AND 2001
     */
    @Priority(2)
    @Test(priority = 2)
    public void shortTermParkingTest() {
        log.info("");
        reportLog("***** Check short-term parking cost for one day *****");
        int dropdownOption = 0; //Dropdown option 0 is 'Short-Term Parking'
        int ResponseDelayedBy = 1;
        app.getParkingCalcPage().selectALotFromDropdown(dropdownOption);
        app.getParkingCalcPage().fillOutTheInputFieldsAndClickCalculateButton(calcData
                .setEntryTime(SHORT_ECO_ENTRY_TIME)
                .setEntryDate(SHORT_ECO_ENTRY_DATE)
                .setLeavingTime(SHORT_ECO_EXIT_TIME)
                .setLeavingDate(SHORT_ECO_EXIT_DATE)
                ,ResponseDelayedBy);
        String cost = app.getSelectorService().getText(costSpanField);
        reportLog("Cost for one day: " + cost);
        assertEquals(cost, "$ 24.00        (1 Days, 0 Hours, 0 Minutes)");
    }

    @Priority(3)
    @Test(priority = 3)
    public void economyParkingTest() {
        log.info("");
        reportLog("***** Check economy parking cost for one day *****");
        int dropdownOption = 1; //Dropdown option 1 is 'Economy Parking'
        int ResponseDelayedBy = 1;
        app.getParkingCalcPage().selectALotFromDropdown(dropdownOption);
        app.getParkingCalcPage().fillOutTheInputFieldsAndClickCalculateButton(calcData
                        .setEntryTime(SHORT_ECO_ENTRY_TIME)
                        .setEntryDate(SHORT_ECO_ENTRY_DATE)
                        .setLeavingTime(SHORT_ECO_EXIT_TIME)
                        .setLeavingDate(SHORT_ECO_EXIT_DATE)
                ,ResponseDelayedBy);
        String cost = app.getSelectorService().getText(costSpanField);
        reportLog("Cost for one day: " + cost);
        assertEquals(cost, "$ 9.00        (1 Days, 0 Hours, 0 Minutes)");
    }

    @Priority(4)
    @Test(priority = 4)
    public void longTermSurfaceParkingTest() {
        log.info("");
        reportLog("***** Check long-term surface parking cost for one month *****");
        int dropdownOption = 2; //Dropdown option 2 is 'Long-term surface Parking'
        int ResponseDelayedBy = 1;
        app.getParkingCalcPage().selectALotFromDropdown(dropdownOption);
        app.getParkingCalcPage().fillOutTheInputFieldsAndClickCalculateButton(calcData
                        .setEntryTime(LONG_TERM_ENTRY_TIME)
                        .setEntryDate(LONG_TERM_ENTRY_DATE)
                        .setLeavingTime(LONG_TERM_EXIT_TIME)
                        .setLeavingDate(LONG_TERM_EXIT_DATE)
                ,ResponseDelayedBy);
        String cost = app.getSelectorService().getText(costSpanField);
        reportLog("Cost for one month: " + cost);
        assertEquals(cost, "$ 288.00        (31 Days, 0 Hours, 0 Minutes)");
    }

    @Priority(5)
    @Test(priority = 5)
    public void longTermGarageParkingTest() {
        log.info("");
        reportLog("***** Check long-term Garage parking cost for one month *****");
        int dropdownOption = 3; //Dropdown option 3 is 'Long-term garage Parking'
        int ResponseDelayedBy = 1;
        app.getParkingCalcPage().selectALotFromDropdown(dropdownOption);
        app.getParkingCalcPage().fillOutTheInputFieldsAndClickCalculateButton(calcData
                        .setEntryTime(LONG_TERM_ENTRY_TIME)
                        .setEntryDate(LONG_TERM_ENTRY_DATE)
                        .setLeavingTime(LONG_TERM_EXIT_TIME)
                        .setLeavingDate(LONG_TERM_EXIT_DATE)
                ,ResponseDelayedBy);
        String cost = app.getSelectorService().getText(costSpanField);
        reportLog("Cost for one month: " + cost);
        assertEquals(cost, "$ 324.00        (31 Days, 0 Hours, 0 Minutes)");
    }

    @Priority(6)
    @Test(priority = 6)
    public void valetParkingTest() {
        log.info("");
        reportLog("***** Check valet parking cost for five hours *****");
        int dropdownOption = 4; //Dropdown option 4 is 'valet Parking'
        int ResponseDelayedBy = 1;
        app.getParkingCalcPage().selectALotFromDropdown(dropdownOption);
        app.getParkingCalcPage().fillOutTheInputFieldsAndClickCalculateButton(calcData
                        .setEntryTime(VALET_ENTRY_TIME)
                        .setEntryDate(VALET_ENTRY_DATE)
                        .setLeavingTime(VALET_EXIT_TIME)
                        .setLeavingDate(VALET_EXIT_DATE)
                ,ResponseDelayedBy);
        String cost = app.getSelectorService().getText(costSpanField);
        reportLog("Cost for five hours: " + cost);
        assertEquals(cost, "$ 12.00        (0 Days, 5 Hours, 0 Minutes)");
    }

    @Priority(7)
    @Test(priority = 7)
    public void checkDaysHoursAndMinutesTest() {
        log.info("");
        reportLog("***** Check values of Days, Hours and Minutes *****");
        int dropdownOption = 0; //Dropdown option 0 is 'Short-Term Parking'
        int ResponseDelayedBy = 1;
        app.getParkingCalcPage().selectALotFromDropdown(dropdownOption);
        app.getParkingCalcPage().fillOutTheInputFieldsAndClickCalculateButton(calcData
                        .setEntryTime(ENTRY_TIME)
                        .setEntryDate(ENTRY_DATE)
                        .setLeavingTime(EXIT_TIME)
                        .setLeavingDate(EXIT_DATE)
                ,ResponseDelayedBy);
        String cost = app.getSelectorService().getText(costSpanField);
        reportLog("All the values in cost field: " + cost);
        assertEquals(cost, "$ 55.00        (2 Days, 3 Hours, 16 Minutes)");
    }


}

