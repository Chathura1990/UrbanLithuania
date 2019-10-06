package applicationFiles.app_manager.pageHelper;

import applicationFiles.app_manager.modelData.CalculatorData;
import applicationFiles.app_manager.selectorHelper.SelectorService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.*;

public class ParkingCalcPage extends SelectorService {

    public ParkingCalcPage(WebDriver driver) {
        super(driver);
    }

    //Page Header
    private By headerOfThePage = xpath("//p[@class='PageTitle']");
    //Dropdown Fields
    private By chooseLotDropDownField = id("Lot");
    //Input Fields
    private By entryTimeInputField = id("EntryTime");
    private By entryDateInputField = id("EntryDate");
    private By exitTimeInputField = id("ExitTime");
    private By exitDateInputField = id("ExitDate");
    //Buttons
    private By calculateButton = id("calculate");

    public String checkWebsiteHeader(){
        return getText(headerOfThePage);
    }

    public void selectALotFromDropdown(int opt){
        selectAnOptionFromDropdown(chooseLotDropDownField,opt);
    }

    private void enterDateAndTime(CalculatorData calc){
        type(entryTimeInputField,calc.getEntryTime());
        type(entryDateInputField,calc.getEntryDate());
        type(exitTimeInputField,calc.getLeavingTime());
        type(exitDateInputField,calc.getLeavingDate());
    }

    private void clickCalculateButtonWithRespDelayedBy(int milliseconds){
        click(xpath("//form[@class='BodyCopy']/input["+milliseconds+"]"),"radio button");
        click(calculateButton, "[Calculate] button");
    }

    public void fillOutTheInputFieldsAndClickCalculateButton(CalculatorData calc, int milliseconds){
        enterDateAndTime(calc);
        clickCalculateButtonWithRespDelayedBy(milliseconds);
    }










}
