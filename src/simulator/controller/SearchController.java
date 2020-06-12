package simulator.controller;

import simulator.models.Connect;
import simulator.models.Contacts;
import simulator.views.PersonField;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static simulator.controller.ContactOperation.convertRowToContact;

public class SearchController extends ShowSearchBar{
    private static Connect connector = new Connect();
    private static String searchValue;
    JPanel resultPanel = new JPanel();
    static List<Contacts> allResults;

    public JPanel getResultPanel() {
        return resultPanel;
    }

    public static String getSearchValue() {
        return searchValue;
    }

    public static void setSearchValue(String theSearchValue) {
        searchValue = theSearchValue;
    }


    public List<Contacts> getSearchResults(String searchValue){
        List<Contacts> list = new ArrayList<>();
        String sql = "SELECT name, phoneNumber, profilePicture "
                + "FROM contacts WHERE name like ? or phoneNumber like ?";

        try (Connection conn = connector.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)){

            // set the value
            pstmt.setString(1,"%" + searchValue + "%");
            pstmt.setString(2,"%" + searchValue + "%");
            //
            ResultSet rs  = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                Contacts temp = convertRowToContact(rs);
                list.add(temp);
               // System.out.println(rs.getString("name") +  "\t" +
                //        rs.getString("PhoneNumber") + "\t" +
                //        rs.getString("profilePicture"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void showSearchResults(){
         setSearchValue(getSearchField().getText());
           allResults = getSearchResults(getSearchValue());
           int number = allResults.size();
           resultPanel.setLayout(new GridLayout(number,1));
           for(int index = 0; index < number; index++){
               resultPanel.add(new PersonField(allResults.get(index).getName(),allResults.get(index).getPhoneNumber(),allResults.get(index).getProfilePicture()));
           }

    }


}
