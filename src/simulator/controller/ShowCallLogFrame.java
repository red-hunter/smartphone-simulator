package simulator.controller;

import simulator.views.ContactsFrame;
import simulator.views.HomeScreen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowCallLogFrame extends ContactsFrame implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        HomeScreen.setButtonClicked(1);
        HomeScreen.getAppsHome().removeAll();
        HomeScreen.getAppsHome().setLayout(new BorderLayout());
        ContactsFrame logFrame = new ContactsFrame();
        logFrame.addComponentToPane(HomeScreen.getAppsHome());
        ContactsFrame.buttonEvent();
        CardLayout cl = (CardLayout) (getContactComponents().getLayout());
        cl.show(getContactComponents(), "callLogCard");
        addDialDrawer(ShowCallLog.getDialDrawerButton());
        HomeScreen.getAppsHome().repaint();
        HomeScreen.getAppsHome().revalidate();
    }
}
