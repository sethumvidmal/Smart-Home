// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Observable observable = new Observable();

        observable.setOb(new Tv("Tv Living room", 5,5));
        observable.setOb(new TvDiningRoom("Tv Dining room", 5, 150));
        observable.setOb(new Speaker("Speaker living room", 5,295));
        observable.setOb(new Window("Window Living room", 5,440));

        new MainSwitch(observable).setVisible(true);
    }
}