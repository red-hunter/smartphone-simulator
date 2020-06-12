package simulator.views;

import simulator.controller.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class HomeResources extends AppResources{

    private static Image imageIcon;
    static JButton contactsButton = new JButton( getHomeIcon(contacts));
    static JButton phoneButton = new JButton( getHomeIcon(phone));
    static JButton calendarButton = new JButton( getHomeIcon(calendar));
    static JButton messagingButton = new JButton( getHomeIcon(messaging));
    static JButton galleryButton = new JButton(getHomeIcon(gallery));
    static JButton appDrawerButton = new JButton(getHomeIcon(appDrawer));
    static JButton internetButton = new JButton( getHomeIcon(internet));
    static JButton phoneLogButton = new JButton( getHomeIcon(phoneLog));

    public HomeResources(){
        appDrawerButton.addActionListener(new ShowApps());
        contactsButton.addActionListener(new ShowContactsFrame());
        phoneLogButton.addActionListener(new ShowCallLogFrame());
        calendarButton.addActionListener(new ShowCalendar());
        messagingButton.addActionListener(new ShowMessages());
    }

    public static JButton getContactsButton() {
        return contactsButton;
    }

    public static JButton getPhoneButton() {
        return phoneButton;
    }

    public static JButton getCalendarButton() {
        return calendarButton;
    }

    public static JButton getMessagingButton() {
        return messagingButton;
    }

    public static JButton getGalleryButton() {
        return galleryButton;
    }

    public static JButton getAppDrawerButton() {
        return appDrawerButton;
    }

    public static JButton getInternetButton() {
        return internetButton;
    }

    public static JButton getPhoneLogButton() {
        return phoneLogButton;
    }

    public static ImageIcon getHomeIcon(String location){
        try{
            //imageIcon = ImageIO.read(new File(location));
            imageIcon = new ImageIcon(HomeFrame.class.getResource(location)).getImage();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        Image newImage = imageIcon.getScaledInstance(42,42,Image.SCALE_SMOOTH);
        ImageIcon finalIcon = new ImageIcon(newImage);
        return finalIcon;
    }

    public static void designHomeIcon(JButton theIcon){
        theIcon.setBorderPainted(false);
        theIcon.setFocusPainted(false);
        theIcon.setBackground(FontsAndColors.transparent);

    }


}
