package simulator.controller;

import simulator.views.HomeScreen;
import simulator.views.MessageInterface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowMessages implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        HomeScreen.setButtonClicked(1);
        HomeScreen.getAppsHome().removeAll();
        HomeScreen.getAppsHome().setLayout(new BorderLayout());
        HomeScreen.getAppsHome().add(new MessageInterface());
        HomeScreen.getAppsHome().repaint();
        HomeScreen.getAppsHome().revalidate();
    }
}
