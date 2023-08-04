import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Controller extends JFrame {
    private DefaultListModel model;
    private JList list;
    Observable observable;
    TimeComponent timeComponent;

    Controller(Observable observable) {
        this.observable = observable;
        setSize(250, 250);
        setTitle("Controller");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocation(1000, 200);
        setLayout(null);
        setResizable(false);


        model = new DefaultListModel();
        model.addElement("Tv Living room");
        model.addElement("Tv Dining room");
        model.addElement("Speaker living room");
        model.addElement("Window Living room");

        list = new JList();
        list.setModel(model);
        list.setBounds(0,0,500,300);
        add(list);

        list.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting() & !list.isSelectionEmpty()){
                    String name = ""+list.getSelectedValue();
                    int index = list.getSelectedIndex();
                    observable.setIndex(index);
                    if(timeComponent == null){
                        new TimeComponent(name,observable).setVisible(true);
                    }

                }
            }
        });

    }
}
