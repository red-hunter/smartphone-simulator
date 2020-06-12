package simulator.views;

import simulator.controller.ShowCallLog;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class CallInterface extends JPanel {
    static Dimension size = new Dimension(265,485);
    static JPanel topPanel = new JPanel(null);
    static JPanel middlePanel = new JPanel( new GridLayout(2,3));
    static JPanel downPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));


    static JLabel nameField = new JLabel("");
    static JLabel contactField = new JLabel("");
    static JLabel profilePicture = new JLabel();
    static String picLoc;

    static Image addCallImage = new ImageIcon(HomeFrame.class.getResource("assets/appIcons/add.png")).getImage();
    static Image bluetoothImage = new ImageIcon(HomeFrame.class.getResource("assets/appIcons/bluetooth.png")).getImage();
    static Image holdImage = new ImageIcon(HomeFrame.class.getResource("assets/appIcons/hold.png")).getImage();
    static Image muteImage = new ImageIcon(HomeFrame.class.getResource("assets/appIcons/mute.png")).getImage();
    static Image speakerImage = new ImageIcon(HomeFrame.class.getResource("assets/appIcons/speaker.png")).getImage();
    static Image keypadImage = new ImageIcon(HomeFrame.class.getResource("assets/appIcons/dialpad.png")).getImage();
    static Image endCallImage = new ImageIcon(HomeFrame.class.getResource("assets/end.png")).getImage();

    static JButton addCall = new JButton(getImage(addCallImage));
    static JButton hold = new JButton(getImage(holdImage));
    static JButton bluetooth = new JButton(getImage(bluetoothImage));
    static JButton speaker = new JButton(getImage(speakerImage));
    static JButton mute = new JButton(getImage(muteImage));
    static JButton keypad = new JButton(getImage(keypadImage));
    static JButton endCall = new JButton(getImage(endCallImage));
    static Image imageIcon;


    public CallInterface(){
        setSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);

        setBackground(FontsAndColors.transparent);
        topPanel.setBackground(FontsAndColors.transparent);
        middlePanel.setBackground(Color.white);
        downPanel.setBackground(Color.white);

        if(DialPad.person.size() != 0){
            nameField.setText(DialPad.person.get(0).getName());
            contactField.setText( "0" + DialPad.person.get(0).getPhoneNumber());
            //profilePicture.setText(DialPad.person.get(0).getProfilePicture());
            picLoc = DialPad.person.get(0).getProfilePicture();
        }

        else if(DialPad.person.size() == 0){
            nameField.setText("Unknown");
            contactField.setText( DialPad.textField.getText());
            picLoc = "assets/p1.png";
        }

        setLayout(new GridLayout(3,1));
        addComponents();
        add(topPanel);
        add(middlePanel);
        add(downPanel);
        endCall.addActionListener(new call_Ended());
    }

    public static void designButtons(JButton button){
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setBackground(FontsAndColors.transparent);
    }

    public static ImageIcon getImage(Image image){
        Image newImage = image.getScaledInstance(30,30,Image.SCALE_SMOOTH);
        ImageIcon finalImage = new ImageIcon(newImage);

        return finalImage;
    }

    public void addComponents(){
        designTopPanel();
       // nameField.setBounds(75,60,115,40);
       // topPanel.add(nameField);
        topPanel.add(contactField);
        topPanel.add(profilePicture);

        middlePanel.add(addCall);
        middlePanel.add(hold);
        middlePanel.add(bluetooth);
        middlePanel.add(speaker);
        middlePanel.add(mute);
        middlePanel.add(keypad);

        downPanel.add(endCall);

        designButtons(addCall);
        designButtons(hold);
        designButtons(bluetooth);
        designButtons(speaker);
        designButtons(mute);
        designButtons(keypad);
        designButtons(endCall);
    }

    public static void designTopPanel(){
        nameField.setHorizontalTextPosition(SwingConstants.CENTER);
        nameField.setVerticalTextPosition(SwingConstants.TOP);
    }
    static class call_Ended implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            HomeScreen.getAppsHome().removeAll();
            //ContactsFrame.callLogCard = new CallLog();
            ContactsFrame logReturn = new ContactsFrame();
            HomeScreen.getAppsHome().setLayout(new BorderLayout());
            logReturn.addComponentToPane(HomeScreen.getAppsHome());
            ContactsFrame.buttonEvent();
            CardLayout cl = (CardLayout) (logReturn.getContactComponents().getLayout());
            cl.show(logReturn.getContactComponents(), "callLogCard");
            logReturn.addDialDrawer(ShowCallLog.getDialDrawerButton());
            HomeScreen.getAppsHome().repaint();
            HomeScreen.getAppsHome().revalidate();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        nameField.setForeground(Color.white);

        nameField.setBounds((int)((265-(nameField.getText().length()*10))/2),20,100,20);
        topPanel.add(nameField);

        contactField.setForeground(Color.white);
        contactField.setBounds((int)((265-(nameField.getText().length()*10))/2),40,100,20);
        topPanel.add(contactField);

        profilePicture.setBounds((int)((265-(nameField.getText().length()*10))/2),60,150,100);
        profilePicture.setIcon(getIcon(picLoc));

        topPanel.add(profilePicture);
    }

    public static ImageIcon getIcon(String location){
        try{
            imageIcon = ImageIO.read(new File(location));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        Image newImage = imageIcon.getScaledInstance(84,46,Image.SCALE_SMOOTH);
        ImageIcon finalIcon = new ImageIcon(newImage);
        return finalIcon;
    }
}
