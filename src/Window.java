import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Window extends JFrame implements Observer {
    private int condition;
    private JLabel lblWindow;

    String startTime, endTime;

    int hourStart, minuteStart, hourEnd, minuteEnd;

    Window(String title,int x, int y) {
        setSize(300, 150);
        setTitle(title);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocation(x,y);
        setLayout(null);
        setResizable(false);

        lblWindow = new JLabel();
        lblWindow.setText("OFF");
        lblWindow.setFont(new Font("", 1, 60));
        lblWindow.setBounds(0, 12, 200, 100);
        lblWindow.setVerticalAlignment(JLabel.CENTER);
        lblWindow.setVerticalAlignment(JLabel.CENTER);

        add(lblWindow);
        setVisible(true);
    }

    @Override
    public void setCondition(boolean condition) {
        if(condition){
            lblWindow.setText("ON");
        }else{lblWindow.setText("OFF");}
    }

    @Override
    public void setTime(String hourStart, String minuteStart, String hourEnd, String minuteEnd) {

        this.hourStart = Integer.parseInt(hourStart);
        this.minuteStart = Integer.parseInt(minuteStart);
        this.hourEnd = Integer.parseInt(hourEnd);
        this.minuteEnd = Integer.parseInt(minuteEnd);

        this.startTime = String.format("%02d:%02d:00", this.hourStart, this.minuteStart);
        this.endTime = String.format("%02d:%02d:00", this.hourEnd, this.minuteEnd);

        Timer timer = new Timer(1000, e -> {
            checkTime();
        });
        timer.start();

    }
    public void checkTime() {
        LocalTime currentTime = LocalTime.now();
        if (currentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")).equals(startTime)) {
            lblWindow.setText("ON");
        } else if (currentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")).equals(endTime)) {
            lblWindow.setText("OFF");
        }

    }
}
