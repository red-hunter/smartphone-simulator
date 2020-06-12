package simulator.views;

import simulator.controller.ShowCallLogFrame;
import simulator.controller.ShowContactsFrame;
import simulator.controller.ShowMessages;

import javax.swing.*;
import java.awt.*;

public class Apps extends AppResources {
    static JPanel appsWrapper = new JPanel(new BorderLayout());
    static JPanel apps = new JPanel(new GridLayout(5,4,5,5));
    static JPanel pane = new JPanel();

    static Dimension size = new Dimension(265,485);

    public Apps(){
        setSize(size);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);

        //appsWrapper.add(new JScrollPane(apps,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER));

        appsWrapper.add(new JLabel(""),BorderLayout.NORTH);
        appsWrapper.add(apps,BorderLayout.CENTER);
        setBackground(FontsAndColors.transparent);
        appsWrapper.setBackground(FontsAndColors.transparent);
        apps.setBackground(FontsAndColors.transparent);
        designIcon(getContactsButton());
        apps.add(getContactsButton());
        designIcon(getPhoneButton());
        apps.add(getPhoneButton());
        designIcon(getCalculatorButton());
        apps.add(getCalculatorButton());
        designIcon(getCalendarButton());
        apps.add(getCalendarButton());
        designIcon(getClockButton());
        apps.add(getClockButton());
        designIcon(getCameraButton());
        apps.add(getCameraButton());
        designIcon(getEmailButton());
        apps.add(getEmailButton());
        designIcon(getPhoneLogButton());
        apps.add(getPhoneLogButton());
        designIcon(getAccountButton());
        apps.add(getAccountButton());
        designIcon(getInternetButton());
        apps.add(getInternetButton());
        designIcon(getMusicButton());
        apps.add(getMusicButton());
        designIcon(getMyFilesButton());
        apps.add(getMyFilesButton());
        designIcon(getNotesButton());
        apps.add(getNotesButton());
        designIcon(getMessagingButton());
        apps.add(getMessagingButton());
        designIcon(getVoiceButton());
        apps.add(getVoiceButton());
        designIcon(getWeatherButton());
        apps.add(getWeatherButton());
        designIcon(getSettingsButton());
        apps.add(getSettingsButton());
        designIcon(getGalleryButton());
        apps.add(getGalleryButton());

        getContactsButton().addActionListener(new ShowContactsFrame());
        getPhoneButton().addActionListener(new ShowCallLogFrame());
        getMessagingButton().addActionListener(new ShowMessages());

        add(appsWrapper);
    }

}
