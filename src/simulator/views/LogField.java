package simulator.views;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class LogField extends JPanel {
    JLabel name = new JLabel();
    JLabel phone = new JLabel();
    JLabel time = new JLabel();
    public LogField(){
        setLayout(new BorderLayout());
        setBackground(Color.gray.brighter());
        add(name,BorderLayout.NORTH);
        add(phone,BorderLayout.SOUTH);
        add(time,BorderLayout.EAST);
    }

    public LogField(String newName, String newPhone, int hour, int minute, int second){
        setLayout(new BorderLayout());
        setBackground(Color.white.brighter().brighter());
        setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.gray.brighter()));
        name.setText(newName);
        add(name,BorderLayout.NORTH);
        phone.setText("0" + newPhone);
        add(phone,BorderLayout.SOUTH);
        time.setText(hour + ":" + minute);
        add(time,BorderLayout.EAST);
    }
}
