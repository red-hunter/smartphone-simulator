package simulator.controller;

import simulator.models.Connect;
import simulator.models.Contacts;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactOperation{
    List<Contacts> manager = new ArrayList<>();
    private static Connect connector = new Connect();



    public List<Contacts> getAllContacts(){

        //Connect newConnection = new Connect();
        String sql = "SELECT name, phoneNumber, profilePicture FROM contacts\n ORDER BY name DESC";

        try (Connection conn = connector.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                Contacts temp = convertRowToContact(rs);
                manager.add(temp);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return manager;
    }

    public static Contacts convertRowToContact(ResultSet myRs) throws SQLException
    {

        String name= myRs.getString("name");
        String phone = myRs.getString("PhoneNumber");
        String picture = myRs.getString("ProfilePicture");



        Contacts temp = new Contacts(name, phone, picture);
        return temp;

    }


    public static void main(String[] args) {
        ContactOperation app = new ContactOperation();
        app.getAllContacts();
    }
}
