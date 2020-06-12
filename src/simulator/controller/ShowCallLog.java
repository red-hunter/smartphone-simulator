package simulator.controller;



import simulator.models.CallLog;
import simulator.models.Connect;
import simulator.models.Contacts;
import simulator.views.ContactsFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ShowCallLog extends ContactsFrame implements ActionListener {
    private static Connect connector = new Connect();
    List<CallLog> manager = new ArrayList<>();

    static String dialDrawerLocation = "assets/dial.png";
    static JButton dialDrawerButton = new JButton(getIcon(dialDrawerLocation));
    public void actionPerformed(ActionEvent e) {
        CardLayout cl = (CardLayout) (getContactComponents().getLayout());
        cl.show(getContactComponents(), "callLogCard");

        addDialDrawer(dialDrawerButton);

    }

    public static String getDialDrawerLocation(){
        return dialDrawerLocation;
    }

    public static JButton getDialDrawerButton(){
        return dialDrawerButton;
    }

    public List<CallLog> getAllLogs(){

        //Connect newConnection = new Connect();
        String sql = "SELECT name, phoneNumber, hour, minute, second FROM callLog";

        try (Connection conn = connector.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                CallLog temp = convertRowToLogs(rs);
                manager.add(temp);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return manager;
    }

    public static CallLog convertRowToLogs(ResultSet myRs) throws SQLException
    {

        String name= myRs.getString("name");
        String phone = myRs.getString("PhoneNumber");
        int hour = myRs.getInt("hour");
        int minute = myRs.getInt("minute");
        int second = myRs.getInt("second");



        CallLog temp = new CallLog(name, phone, hour, minute, second);
        return temp;

    }

}