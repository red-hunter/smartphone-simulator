package simulator.controller;

import simulator.views.ContactsFrame;
import simulator.views.HomeScreen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowContactsFrame implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        ContactsFrame newContactFrame = new ContactsFrame();
        HomeScreen.setButtonClicked(1);
        HomeScreen.getAppsHome().removeAll();
        HomeScreen.getAppsHome().setLayout(new BorderLayout());
        newContactFrame.addComponentToPane(HomeScreen.getAppsHome());
        HomeScreen.getAppsHome().repaint();
        HomeScreen.getAppsHome().revalidate();
        ContactsFrame.buttonEvent();
    }
}
