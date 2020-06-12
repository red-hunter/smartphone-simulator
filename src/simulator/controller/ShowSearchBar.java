package simulator.controller;

import simulator.views.Contacts;
import simulator.views.ContactsFrame;
import simulator.views.FontsAndColors;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static simulator.controller.SearchController.getSearchValue;
import static simulator.views.Contacts.getAllContacts;
import static simulator.views.Contacts.reloadContacts;


public class ShowSearchBar extends ContactsFrame implements ActionListener {
    static String backLocation = "assets/back.png";
    static String goLocation = "assets/go.png";
    static JTextField searchField = new JTextField(12);
    static JButton back = new JButton(getIcon(backLocation));
    static JButton searchButton = new JButton(getIcon(goLocation));
    public static int searchButtonClickedAlready = 0;
    public static int searchValueChanged = 0;

    public static JTextField getSearchField() {
        return searchField;
    }

    public static void setSearchField(JTextField searchField) {
        ShowSearchBar.searchField = searchField;
    }

    public static JButton getBack() {
        return back;
    }

    public static void setBack(JButton back) {
        ShowSearchBar.back = back;
    }

    public static JButton getSearch() {
        return searchButton;
    }

    public static void setSearch(JButton search) {
        ShowSearchBar.searchButton = search;
    }


    /**
     * Designing the bottom buttons
     */
    public static void designButtons(){
        searchButton.setBackground(FontsAndColors.getBottomPanelColor());
        searchButton.setFocusPainted(false);
        searchButton.setBorderPainted(false);
        searchButton.setBorder(BorderFactory.createEmptyBorder());

        back.setBackground(FontsAndColors.getBottomPanelColor());
        back.setFocusPainted(false);
        back.setBorderPainted(false);
        back.setBorder(BorderFactory.createEmptyBorder());
    }

    public ShowSearchBar(){
        designButtons();
        back.addActionListener(this);
        searchButton.addActionListener(this);
        searchField.addKeyListener(new TextFieldChanged());
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == getSearchButton()){
            getDownButtonsPanel().removeAll();
            getDownButtonsPanel().add(back);
            getDownButtonsPanel().add(searchField);
            getDownButtonsPanel().add(searchButton);
            getDownButtonsPanel().repaint();
            getDownButtonsPanel().revalidate();
        }

        else if(e.getSource() == back){
            getDownButtonsPanel().removeAll();
            getDownButtonsPanel().add(getSearchButton());
            getDownButtonsPanel().add(getAddContactsButton());
            getDownButtonsPanel().add(getMoreButton());
            getDownButtonsPanel().repaint();
            getDownButtonsPanel().revalidate();
            if(searchButtonClickedAlready == 1){
                getAllContacts().removeAll();
                getAllContacts().add(reloadContacts());
                getAllContacts().repaint();
                getAllContacts().revalidate();
                searchButtonClickedAlready = 0;
            }
        }

        else if(e.getSource() == searchButton){
          //  if(searchButtonClickedAlready != 1) {
                SearchController searchContact = new SearchController();
                searchContact.showSearchResults();
                getAllContacts().removeAll();
                getAllContacts().add(searchContact.getResultPanel());
                getAllContacts().repaint();
                getAllContacts().revalidate();
                searchButtonClickedAlready = 1;

          //  }

        }

    }
}
