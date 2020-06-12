package simulator.views;

import com.sun.jdi.connect.Connector;
import simulator.models.Connect;
import simulator.models.Contacts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static simulator.controller.ContactOperation.convertRowToContact;

public class DialPad extends JPanel {
    static String call = "assets/appIcons/phone.png";
    static String back = "assets/clear.png";

    private static Connect connector = new Connect();
    static List<Contacts> person;

    static JPanel possibleContact = new JPanel(new GridLayout(5,1));
    static JPanel pad = new JPanel(new GridLayout(6,3));

    static String input = "";

    static JTextField textField = new JTextField(20);
    static JButton button1 = new JButton("1");
    static JButton button2 = new JButton("2");
    static JButton button3 = new JButton("3");
    static JButton button4 = new JButton("4");
    static JButton button5 = new JButton("5");
    static JButton button6 = new JButton("6");
    static JButton button7 = new JButton("7");
    static JButton button8 = new JButton("8");
    static  JButton button9 = new JButton("9");
    static JButton button0 = new JButton("0");
    static JButton buttonEmpty1 = new JButton(" ");
    static JButton buttonEmpty2 = new JButton(" ");
    static JButton buttonStar = new JButton("*");
    static JButton buttonPound = new JButton("#");
    static JButton buttonCall = new JButton(ContactsFrame.getIcon(call));
    static JButton clearButton = new JButton(ContactsFrame.getIcon(back));
    static JButton emptyButton = new JButton(" ");

    static Dimension size = new Dimension(265,485);
    public DialPad(){
        setSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);
        setLayout(new GridLayout(2,1));
        addButtons();
        addListeners();
        add(possibleContact);
        add(pad);
    }

    public void addButtons(){
        pad.add(emptyButton);
        pad.add(textField);
        pad.add(clearButton);
        pad.add(button1);
        pad.add(button2);
        pad.add(button3);
        pad.add(button4);
        pad.add(button5);
        pad.add(button6);
        pad.add(button7);
        pad.add(button8);
        pad.add(button9);
        pad.add(buttonStar);
        pad.add(button0);
        pad.add(buttonPound);
        pad.add(buttonEmpty1);
        pad.add(buttonCall);
        pad.add(buttonEmpty2);
        designButtons(buttonCall);
        designButtons(buttonEmpty1);
        designButtons(buttonEmpty2);
        designButtons(emptyButton);
        designButtons(clearButton);
        textField.setLayout(new FlowLayout(FlowLayout.CENTER));
        textField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        textField.setBorder(BorderFactory.createEmptyBorder());
        textField.setBackground(FontsAndColors.transparent);

    }


    public void designButtons(JButton button){
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setBackground(FontsAndColors.transparent);

    }

    public void addListeners(){
        button1.addActionListener(new inputNumber_Action());
        button2.addActionListener(new inputNumber_Action());
        button3.addActionListener(new inputNumber_Action());
        button4.addActionListener(new inputNumber_Action());
        button5.addActionListener(new inputNumber_Action());
        button6.addActionListener(new inputNumber_Action());
        button7.addActionListener(new inputNumber_Action());
        button8.addActionListener(new inputNumber_Action());
        button9.addActionListener(new inputNumber_Action());
        button0.addActionListener(new inputNumber_Action());
        buttonStar.addActionListener(new inputNumber_Action());
        buttonPound.addActionListener(new inputNumber_Action());
        clearButton.addActionListener(new clearSpace_Action());
        buttonCall.addActionListener(new callButton_Action());
    }

    static class inputNumber_Action implements ActionListener {
        public void actionPerformed(ActionEvent e){
            input += e.getActionCommand();
            textField.setText(input);
            //getText=input;
            //System.out.println(e.getActionCommand());

        }
    }

    static class clearSpace_Action implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String str = textField.getText();
            if(str.length() != 0) {
                textField.setText(str.substring(0, str.length()-1));
                input = textField.getText();
            }
            //textField.setText("");
        }
    }

    static class callButton_Action implements ActionListener{
        public void  actionPerformed(ActionEvent e){
            //textField.setText(input.substring(1, input.length()));
            String userInput = input.substring(1, input.length());
            String newInput = userInput;
            person = DialPad.getSearchResults(newInput);

            Calendar clock = java.util.Calendar.getInstance();
            int hour = clock.get(Calendar.HOUR);
            int minute = clock.get(Calendar.MINUTE);

            if(person.size() != 0){
                insert(person.get(0).getName(),textField.getText(),hour,minute);
            }
            else {
                insert("unknown",textField.getText(),hour,minute);
            }


            HomeScreen.getAppsHome().removeAll();
            HomeScreen.getAppsHome().add(new CallInterface());
            HomeScreen.getAppsHome().repaint();
            HomeScreen.getAppsHome().revalidate();


        }
    }


    public static List<Contacts> getSearchResults(String searchValue){
        List<Contacts> list = new ArrayList<>();
        String sql = "SELECT name, phoneNumber, profilePicture "
                + "FROM contacts WHERE  phoneNumber like ?";

        try (Connection conn = connector.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)){

            // set the value
            pstmt.setString(1, searchValue );
            //
            ResultSet rs  = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                Contacts temp = convertRowToContact(rs);
                list.add(temp);
                // System.out.println(rs.getString("name") +  "\t" +
                  //      rs.getString("PhoneNumber") + "\t" +
                    //    rs.getString("profilePicture"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public static void insert(String name, String phone, int hour, int minute) {
        String sql = "INSERT INTO callLog(name,phoneNumber,hour,minute) VALUES(?,?,?,?)";

        try (Connection conn = connector.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, phone);
            pstmt.setInt(3, hour);
            pstmt.setInt(4, minute);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
