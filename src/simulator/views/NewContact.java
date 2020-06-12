package simulator.views;

import simulator.models.Connect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NewContact extends JPanel {

    private static String userName = "empty";
    private static String userPhone;
    private static String userPic;

    static String addImage = "assets/add-image.png";
    static String done = "assets/done.png";

    private static Connect connector = new Connect();
    static JPanel header = new JPanel(new FlowLayout(FlowLayout.CENTER));
    static JPanel body = new JPanel(new GridLayout(2,1));
    static JPanel add = new JPanel();
    static JLabel theHeader = new JLabel("Add Contact");
    static JLabel name = new JLabel("Name:");
    static JTextField nameField = new JTextField(18);
    static JLabel phone = new JLabel("Phone:");
    static JTextField phoneField = new JTextField(18);
    static JButton image = new JButton(ContactsFrame.getIcon(addImage));
    static JButton addButton = new JButton(ContactsFrame.getIcon(done));
    static JPanel emptyPanel = new JPanel();
    static JPanel contentPanel = new JPanel();

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

    public NewContact(){


        setLayout(new BorderLayout());
        addComponents();
        add(header,BorderLayout.PAGE_START);
        add(body,BorderLayout.CENTER);
        add(add,BorderLayout.SOUTH);
        image.addActionListener(new upload_Image());
        addButton.addActionListener(new insert_Image());
    }

    public static void addComponents(){
        header.add(theHeader);

        contentPanel.add(name);
        contentPanel.add(nameField);
        contentPanel.add(phone);
        contentPanel.add(phoneField);
        contentPanel.add(image);

        body.add(contentPanel);
        body.add(emptyPanel);
        add.add(addButton);

        designButtons(addButton);
        designButtons(image);
    }

    public static void designButtons(JButton button){
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setBackground(FontsAndColors.transparent);
    }

    static class upload_Image implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File picture = chooser.getSelectedFile();

            userPic = picture.getAbsolutePath();
            userName = nameField.getText();
            userPhone = phoneField.getText();





        }
    }

    static class insert_Image implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

          //  if(userName != null && userPhone != null){
                insert(userName, userPhone, userPic);
                ContactsFrame newContactFrame = new ContactsFrame();
                HomeScreen.setButtonClicked(1);
                HomeScreen.getAppsHome().removeAll();
                HomeScreen.getAppsHome().setLayout(new BorderLayout());
                newContactFrame.addComponentToPane(HomeScreen.getAppsHome());
                HomeScreen.getAppsHome().repaint();
                HomeScreen.getAppsHome().revalidate();
                ContactsFrame.buttonEvent();
          //  }
        }
    }

    public static void insert(String name, String phone, String pic) {
        String sql = "INSERT INTO Contacts(name,phoneNumber,profilePicture) VALUES(?,?,?)";

        try (Connection conn = connector.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, phone);
            pstmt.setString(3, pic);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
