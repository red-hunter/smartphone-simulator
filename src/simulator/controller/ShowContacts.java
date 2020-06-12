package simulator.controller;

import simulator.views.ContactsFrame;
import simulator.views.HomeScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowContacts extends ContactsFrame implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        CardLayout cl = (CardLayout) (getContactComponents().getLayout());
        cl.show(getContactComponents(), "contactCard");

        if(getLogButtonClicked() == 1){
            getDownButtonsPanel().removeAll();
            getDownButtonsPanel().setLayout(new FlowLayout(FlowLayout.CENTER));
            getDownButtonsPanel().add(getSearchButton());
            getDownButtonsPanel().add(getAddContactsButton());
            getDownButtonsPanel().add(getMoreButton());
            getDownButtonsPanel().repaint();
            getDownButtonsPanel().revalidate();
        }

    }
}
