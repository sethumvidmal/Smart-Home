import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TvDiningRoom extends JFrame implements Observer {
    private int condition;
    private JLabel lblLivingRoomTv;

    String startTime, endTime;

    int hourStart, minuteStart, hourEnd, minuteEnd;
    TvDiningRoom(String title, int x, int y){
        setSize(300,150);
        setTitle(title);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocation(x,y);
        setLayout(null);
        setResizable(false);
        setVisible(true);

        lblLivingRoomTv = new JLabel();
        lblLivingRoomTv.setText("OFF");
        lblLivingRoomTv.setFont(new Font("",1,60));
        lblLivingRoomTv.setBounds(0,12,200,100);
        lblLivingRoomTv.setVerticalAlignment(JLabel.CENTER);
        lblLivingRoomTv.setVerticalAlignment(JLabel.CENTER);

        add(lblLivingRoomTv);


    }
    @Override
    public void setCondition(boolean condition) {
        if(condition){
            lblLivingRoomTv.setText("ON");
        }else{lblLivingRoomTv.setText("OFF");}

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
            lblLivingRoomTv.setText("ON");
        } else if (currentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")).equals(endTime)) {
            lblLivingRoomTv.setText("OFF");
        }

    }
}
