package simulator.controller;

import simulator.views.HomeScreen;
import simulator.views.MainHomeFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if(HomeScreen.getButtonClicked() == 1){
            HomeScreen.getAppsHome().removeAll();
            HomeScreen.getAppsHome().setLayout(new BorderLayout());
            HomeScreen.getAppsHome().add(new MainHomeFrame());
            HomeScreen.getAppsHome().repaint();
            HomeScreen.getAppsHome().revalidate();
            HomeScreen.setButtonClicked(0);
        }
    }
}
