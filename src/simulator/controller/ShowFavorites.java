package simulator.controller;

import simulator.views.ContactsFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowFavorites extends ContactsFrame implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        CardLayout cl = (CardLayout) (getContactComponents().getLayout());
        cl.show(getContactComponents(), "favoritesCard");
    }
}
