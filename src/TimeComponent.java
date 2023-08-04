import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimeComponent extends JFrame {
    //labels
    private JLabel lblStartHour;
    private JLabel lblStartMinute;
    private JLabel startHour;
    private JLabel lblEndHour;
    private JLabel lblEndMinute;
    //button
    private JButton setButton;
    //values
    private String  hourStart;
    private String  minuteStart;
    private String  hourEnd;
    private String  minuteEnd;
    //spinners
    private JSpinner spinnerStartHour;
    private JSpinner spinnerStartMinute;
    private JSpinner spinnerEndHour;
    private JSpinner spinnerEndMinute;

    private Observable observable;
    private DefaultListModel<TimeModel>l1;
    private JList<TimeModel> list;


    TimeComponent(String title, Observable observable){

        this.observable = observable;
        setSize(800,300);
        setTitle(title);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(true);
        setVisible(true);

        JPanel bottomPannel = new JPanel();
        lblStartHour = new JLabel();
        lblStartHour.setFont(new Font("",1,15));
        lblStartHour.setText("Start: Hour:");


        lblStartMinute=new JLabel();
        lblStartMinute.setFont(new Font("",1,15));
        lblStartMinute.setText("Minute:");

        lblEndHour = new JLabel();
        lblEndHour.setFont(new Font("",1,15));
        lblEndHour.setText("End: Hour:");

        lblEndMinute = new JLabel();
        lblEndMinute.setFont(new Font("",1,15));
        lblEndMinute.setText("Minute:");

        setButton = new JButton();
        setButton.setText("Set");

        spinnerStartHour = new JSpinner(new SpinnerNumberModel(0,0,23,1));
        spinnerStartMinute = new JSpinner(new SpinnerNumberModel(0,0,59,1));
        spinnerEndHour = new JSpinner(new SpinnerNumberModel(0,0,23,1));
        spinnerEndMinute = new JSpinner(new SpinnerNumberModel(0,0,59,1));

        l1 = new DefaultListModel<>();
        list = new JList<>(l1);
        list.setFont(new Font("",1,15));


        setButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hourStart = ""+spinnerStartHour.getValue();
                minuteStart = ""+spinnerStartMinute.getValue();

                hourEnd = ""+spinnerEndHour.getValue();
                minuteEnd = ""+spinnerEndMinute.getValue();

                l1.addElement(new TimeModel(hourStart,minuteStart,hourEnd,minuteEnd));
                observable.setTime(hourStart,minuteStart,hourEnd,minuteEnd);
            }
        });
        bottomPannel.add(lblStartHour);
        bottomPannel.add(spinnerStartHour);

        bottomPannel.add(lblStartMinute);
        bottomPannel.add(spinnerStartMinute);

        bottomPannel.add(lblEndHour);
        bottomPannel.add(spinnerEndHour);

        bottomPannel.add(lblEndMinute);
        bottomPannel.add(spinnerEndMinute);

        bottomPannel.add(setButton);

        add("South",bottomPannel);
        add(list);
    }
}
