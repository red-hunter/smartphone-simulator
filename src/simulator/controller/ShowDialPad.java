package simulator.controller;

import simulator.views.DialPad;
import simulator.views.HomeScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowDialPad implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        HomeScreen.getAppsHome().removeAll();
        HomeScreen.getAppsHome().add(new DialPad());
        HomeScreen.getAppsHome().repaint();
        HomeScreen.getAppsHome().revalidate();
    }
}
