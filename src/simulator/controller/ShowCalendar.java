package simulator.controller;

import simulator.views.Calendar;
import simulator.views.HomeScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowCalendar implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        Calendar appCalendar = new Calendar();
        HomeScreen.setButtonClicked(1);
        HomeScreen.getAppsHome().removeAll();
        HomeScreen.getAppsHome().setLayout(null);
        HomeScreen.getAppsHome().add(appCalendar.getPnlCalendar());
        HomeScreen.getAppsHome().repaint();
        HomeScreen.getAppsHome().revalidate();

    }
}
