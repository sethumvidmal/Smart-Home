public class TimeModel {
    private String hourStart;
    private  String minuteStart;
    private String hourEnd;
    private String minuteEnd;
    public TimeModel (String hourStart, String minuteStart, String hourEnd, String minuteEnd){
        this.hourStart = hourStart;
        this.minuteStart = minuteStart;
        this.hourEnd = hourEnd;
        this.minuteEnd = minuteEnd;
    }

    public String getHourStart() {
        return hourStart;
    }

    public void setHourStart(String hourStart) {
        this.hourStart = hourStart;
    }

    public String getMinuteStart() {
        return minuteStart;
    }

    public void setMinuteStart(String minuteStart) {
        this.minuteStart = minuteStart;
    }

    public String getHourEnd() {
        return hourEnd;
    }

    public void setHourEnd(String hourEnd) {
        this.hourEnd = hourEnd;
    }

    public String getMinuteEnd() {
        return minuteEnd;
    }

    public void setMinuteEnd(String minuteEnd) {
        this.minuteEnd = minuteEnd;
    }

    @Override
    public String toString() {
        return "Start at : "+hourStart+"."+minuteStart+"End at :"+hourEnd+"."+minuteEnd;
    }
}
