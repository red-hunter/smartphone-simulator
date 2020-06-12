package simulator.controller;

import simulator.views.Apps;
import simulator.views.HomeScreen;
import simulator.views.MainHomeFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowApps implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        HomeScreen.setButtonClicked(1);
        HomeScreen.getAppsHome().removeAll();
        HomeScreen.getAppsHome().setLayout(new FlowLayout());
        HomeScreen.getAppsHome().add(new Apps());
        HomeScreen.getAppsHome().repaint();
        HomeScreen.getAppsHome().revalidate();

    }
}
