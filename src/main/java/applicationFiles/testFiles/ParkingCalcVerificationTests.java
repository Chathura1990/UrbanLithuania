package applicationFiles.testFiles;

import applicationFiles.app_manager.testBase.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static applicationFiles.app_manager.ApplicationManager.*;
import static org.openqa.selenium.By.id;

public class ParkingCalcVerificationTests extends TestBase {

    private By chooseLotDropDownField = id("Lot");

    @Priority(1)
    @Test(priority = 1)
    public void checkNumberOfOptionsInDropdownTest() {
        log.info("");
        reportLog("***** Verify number of Lots in the dropdown menu *****");
        int numberOfLotsInTheDropdown = 5;
        app.getParkingCalcPage()
                .assertNumberOfOptionsInDropdown(chooseLotDropDownField, "Number of Lots"
                        ,numberOfLotsInTheDropdown);
    }
}
