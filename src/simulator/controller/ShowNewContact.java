package simulator.controller;

import simulator.views.HomeScreen;
import simulator.views.NewContact;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowNewContact implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        HomeScreen.getAppsHome().removeAll();
        HomeScreen.getAppsHome().add(new NewContact());
        HomeScreen.getAppsHome().repaint();
        HomeScreen.getAppsHome().revalidate();
    }
}
