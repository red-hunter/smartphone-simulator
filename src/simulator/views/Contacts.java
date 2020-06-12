package simulator.views;

import simulator.controller.ContactOperation;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class Contacts extends JPanel {
    JLabel topMargin = new JLabel(" ");
    JLabel bottomMargin = new JLabel(" ");
    JLabel rightMargin = new JLabel(" ");
    JLabel leftMargin = new JLabel(" ");
    static JPanel allContacts = new JPanel(new GridLayout(10,1));
    static ContactOperation displayUser = new ContactOperation();
    static List<simulator.models.Contacts> userContacts;
    static JPanel reloadedContacts;
    private static int rows;

    static Dimension size = new Dimension(265,485);

    public static JPanel getAllContacts(){
        return allContacts;
    }

    public static JPanel reloadContacts(){
        reloadedContacts = new JPanel(new GridLayout(10,1,1,1));
        reloadedContacts.setBackground(Color.white.brighter().brighter());
        userContacts = displayUser.getAllContacts();


        for(int index = rows; index >= 0; index--){
            allContacts.add(new PersonField(userContacts.get(index).getName(),userContacts.get(index).getPhoneNumber(),userContacts.get(index).getProfilePicture()));
        }


        return reloadedContacts;
    }


    public Contacts(){

        setSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);

        allContacts.setBackground(Color.white.brighter().brighter());
        setLayout(new GridLayout(1,1));
        add(new JScrollPane(allContacts,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER));
        userContacts = displayUser.getAllContacts();

        rows = userContacts.size()-1;
        for(int index = rows; index >= 0; index--){
            allContacts.add(new PersonField(userContacts.get(index).getName(),userContacts.get(index).getPhoneNumber(),userContacts.get(index).getProfilePicture()));
        }


    }
}
