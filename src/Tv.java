import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Tv extends JFrame implements Observer{
    private int condition;
    private JLabel lblTv;

    String startTime, endTime;

    int hourStart, minuteStart, hourEnd, minuteEnd;
    Tv(String title, int x, int y){
        setSize(300,150);
        setTitle(title);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocation(x,y);
        setLayout(null);
        setResizable(false);
        setVisible(true);

        lblTv = new JLabel();
        lblTv.setText("OFF");
        lblTv.setFont(new Font("",1,60));
        lblTv.setBounds(0,12,200,100);
        lblTv.setVerticalAlignment(JLabel.CENTER);
        lblTv.setVerticalAlignment(JLabel.CENTER);

        add(lblTv);

    }


    @Override
    public void setCondition(boolean condition) {
        if(condition){
            lblTv.setText("ON");
        }else{lblTv.setText("OFF");}
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
            lblTv.setText("ON");
        } else if (currentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")).equals(endTime)) {
            lblTv.setText("OFF");
        }

    }
}
