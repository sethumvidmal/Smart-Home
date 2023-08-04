public class Observable implements Observer {
    Observer observerArray [] = new Observer[0];
    int nextIndex;
    private boolean condition;
    private int index;
    private String hourStart;
    private  String minuteStart;
    private String hourEnd;
    private String minuteEnd;
    public void setOb(Observer observer){
        extendArrays();
        observerArray [observerArray.length-1] = observer;
    }

    public void setCondition(boolean condition){
        if(this.condition != condition){
            this.condition = condition;
            notifyObserver();
        }
    }
    private void extendArrays(){
        Observer [] tempobserverArray = new Observer[observerArray.length+1];
        for(int i = 0; i < observerArray.length; i++){
            tempobserverArray[i] = observerArray[i];
        }
        observerArray = tempobserverArray;
    }
    public void notifyObserver(){
        for(int i = 0; i< observerArray.length; i++){
            observerArray[i].setCondition(condition);
        }

    }
    public void setIndex(int index){
        this.index = index;
    }
    public void setTime(String hourStart, String minuteStart, String hourEnd, String minuteEnd){
        this.hourStart = hourStart;
        this.minuteStart = minuteStart;
        this.hourEnd = hourEnd;
        this.minuteEnd = minuteEnd;
        notifyByTime();

    }
    public void notifyByTime(){
        observerArray[index].setTime(hourStart,minuteStart,hourEnd,minuteEnd);
    }
}
