package applicationFiles.app_manager.modelData;

public class CalculatorData {

    private String entryTime;
    private String entryDate;
    private String leavingTime;
    private String leavingDate;

    public CalculatorData setEntryTime(String entryTime){
        this.entryTime = entryTime;
        return this;
    }

    public CalculatorData setEntryDate(String entryDate){
        this.entryDate = entryDate;
        return this;
    }

    public CalculatorData setLeavingTime(String leavingTime){
        this.leavingTime = leavingTime;
        return this;
    }

    public CalculatorData setLeavingDate(String leavingDate){
        this.leavingDate = leavingDate;
        return this;
    }

    public String getEntryTime(){
        return entryTime;
    }

    public String getEntryDate(){
        return entryDate;
    }

    public String getLeavingTime(){
        return leavingTime;
    }

    public String getLeavingDate(){
        return leavingDate;
    }
}
