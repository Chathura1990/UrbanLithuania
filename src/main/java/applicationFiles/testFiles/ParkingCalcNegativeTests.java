package applicationFiles.testFiles;

import applicationFiles.app_manager.modelData.CalculatorData;
import applicationFiles.app_manager.testBase.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static applicationFiles.app_manager.ApplicationManager.*;
import static applicationFiles.framework.globalParameters.GlobalParameters.*;
import static org.openqa.selenium.By.xpath;
import static org.testng.Assert.*;

public class ParkingCalcNegativeTests extends TestBase {

    //Span Fields
    private By costSpanField = xpath("//b[@id='cost']");

    private CalculatorData calcData = new CalculatorData();

    @Priority(1)
    @Test(priority = 1)
    public void shortTermParkingWhenTimeIsIncorrectTest() {
        log.info("");
        reportLog("***** Check short-term parking cost when time is incorrect *****");
        int dropdownOption = 0; //Dropdown option 0 is 'Short-Term Parking'
        int ResponseDelayedBy = 1;
        app.getParkingCalcPage().selectALotFromDropdown(dropdownOption);
        app.getParkingCalcPage().fillOutTheInputFieldsAndClickCalculateButton(calcData
                        .setEntryTime(TIME_ERROR)
                        .setEntryDate(DATE_BY_1_DAY)
                        .setLeavingTime(TIME_13)
                        .setLeavingDate(DATE_BY_1_DAY)
                ,ResponseDelayedBy);
        String cost = app.getSelectorService().getText(costSpanField);
        reportLog("Cost when time is incorrect: " + cost);
        assertEquals(cost, "$ NaN        (NaN Days, NaN Hours, NaN Minutes)");
    }

    @Priority(2)
    @Test(priority = 2)
    public void whenLeavingTimeIsBeforeThanEntryTimeTest() {
        log.info("");
        reportLog("***** Check the results when leaving time is before than entry time *****");
        int dropdownOption = 0; //Dropdown option 0 is 'Short-Term Parking'
        int ResponseDelayedBy = 1;
        app.getParkingCalcPage().selectALotFromDropdown(dropdownOption);
        app.getParkingCalcPage().fillOutTheInputFieldsAndClickCalculateButton(calcData
                        .setEntryTime(TIME_13)
                        .setEntryDate(DATE_BY_1_DAY)
                        .setLeavingTime(TIME_12)
                        .setLeavingDate(DATE_BY_1_DAY)
                ,ResponseDelayedBy);
        String cost = app.getSelectorService().getText(costSpanField);
        reportLog("Cost when leaving time is before than Entry: " + cost);
        assertEquals(cost, "$ 0.00        (-1 Days, 23 Hours, 0 Minutes)");
    }

}
