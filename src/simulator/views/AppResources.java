package simulator.views;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class AppResources extends JPanel{
    private static Image imageIcon;

    static String root = "assets/appIcons/";
    static String contacts = root + "contacts.png";
    static String phone = root + "phone.png";
    static String calendar = root + "calendar.png";
    static String calculator = root + "calculator.png";
    static String clock = root + "clock.png";
    static String camera = root + "camera.png";
    static String email = root + "email.png";
    static String phoneLog = root + "phone_log.png";
    static String account = root + "account.png";
    static String internet = root + "internet.png";
    static String music = root + "music.png";
    static String myFiles = root + "my_files.png";
    static String notes = root + "notes.png";
    static String messaging = root + "messaging.png";
    static String voice = root + "voice.png";
    static String weather = root + "weather.png";
    static String settings = root + "settings.png";
    static String gallery = root + "gallery.png";
    static String appDrawer = root + "app_drawer.png";






    static JButton contactsButton = new JButton("Contacts", getIcon(contacts));
    static JButton phoneButton = new JButton("Phone", getIcon(phone));
    static JButton calendarButton = new JButton("Calendar", getIcon(calendar));
    static JButton calculatorButton = new JButton("Calculator", getIcon(calculator));
    static JButton clockButton = new JButton("Clock",getIcon(clock));
    static JButton cameraButton = new JButton("Camera",getIcon(camera));
    static JButton emailButton = new JButton("Email", getIcon(email));
    static JButton phoneLogButton = new JButton("Call Log", getIcon(phoneLog));
    static JButton accountButton = new JButton("Account", getIcon(account));
    static JButton internetButton = new JButton("Internet", getIcon(internet));
    static JButton musicButton = new JButton("Music", getIcon(music));
    static JButton myFilesButton = new JButton("My Files", getIcon(myFiles));
    static JButton notesButton = new JButton("Notes", getIcon(notes));
    static JButton messagingButton = new JButton("Messaging", getIcon(messaging));
    static JButton voiceButton = new JButton("Voice", getIcon(voice));
    static JButton weatherButton = new JButton("Weather", getIcon(weather));
    static JButton settingsButton = new JButton("Settings", getIcon(settings));
    static JButton galleryButton = new JButton("Gallery", getIcon(gallery));



    public static JButton getPhoneLogButton() {
        return phoneLogButton;
    }

    public static JButton getAccountButton() {
        return accountButton;
    }

    public static JButton getInternetButton() {
        return internetButton;
    }

    public static JButton getMusicButton() {
        return musicButton;
    }

    public static JButton getMyFilesButton() {
        return myFilesButton;
    }

    public static JButton getNotesButton() {
        return notesButton;
    }

    public static JButton getMessagingButton() {
        return messagingButton;
    }

    public static JButton getVoiceButton() {
        return voiceButton;
    }

    public static JButton getWeatherButton() {
        return weatherButton;
    }

    public static JButton getSettingsButton() {
        return settingsButton;
    }

    public static JButton getGalleryButton() {
        return galleryButton;
    }



    public static JButton getClockButton() {
        return clockButton;
    }

    public static JButton getCameraButton() {
        return cameraButton;
    }

    public static JButton getEmailButton() {
        return emailButton;
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

    public static JButton getCalculatorButton() {
        return calculatorButton;
    }

    public static ImageIcon getIcon(String location){
        try{
            //imageIcon = ImageIO.read(new File(location));
            imageIcon = new ImageIcon(HomeFrame.class.getResource(location)).getImage();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        Image newImage = imageIcon.getScaledInstance(54,54,Image.SCALE_SMOOTH);
        ImageIcon finalIcon = new ImageIcon(newImage);
        return finalIcon;
    }

    public static void designIcon(JButton theIcon){
        theIcon.setBorderPainted(false);
        theIcon.setFocusPainted(false);
        theIcon.setBackground(FontsAndColors.transparent);
        theIcon.setVerticalTextPosition(SwingConstants.BOTTOM);
        theIcon.setHorizontalTextPosition(SwingConstants.CENTER);
        theIcon.setForeground(Color.white);
        theIcon.setBorder(BorderFactory.createEmptyBorder());
    }

}
