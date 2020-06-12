package simulator.views;

import simulator.controller.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ContactsFrame extends JPanel{

    static JPanel contactComponents = new JPanel(new CardLayout());
    static JPanel topButtonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,20,5));
    static JPanel downButtonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,20,5));
    static Contacts contactCard = new Contacts();
    static CallLog callLogCard = new CallLog();;
    static Favorites favoritesCard = new Favorites();
    static String favoriteString = "The favorites are displayed here";

    static Image imageIcon;
    static String searchLoc = "assets/search.png";
    static String addLoc = "assets/add.png";
    static String moreLoc = "assets/more.png";
    static String favoritesLoc = "assets/favorites.png";
    static String contactsLoc = "assets/contacts.png";
    static String logLoc = "assets/history.png";


    static JButton searchButton = new JButton(getIcon(searchLoc));
    static JButton callLogButton = new JButton(getIcon(logLoc));
    static JButton contactsButton = new JButton(getIcon(contactsLoc));
    static JButton favoritesButton = new JButton(getIcon(favoritesLoc));
    static JButton addContactsButton = new JButton(getIcon(addLoc));
    static JButton moreButton = new JButton(getIcon(moreLoc));

    static int logButtonClicked = 0;
    static int contactButtonClicked = 0;
    static int favoriteButtonClicked = 0;

    public static int getLogButtonClicked() {
        return logButtonClicked;
    }

    public static void setLogButtonClicked(int logButtonClicked) {
        ContactsFrame.logButtonClicked = logButtonClicked;
    }

    public static int getContactButtonClicked() {
        return contactButtonClicked;
    }

    public static void setContactButtonClicked(int contactButtonClicked) {
        ContactsFrame.contactButtonClicked = contactButtonClicked;
    }

    public static int getFavoriteButtonClicked() {
        return favoriteButtonClicked;
    }

    public static void setFavoriteButtonClicked(int favoriteButtonClicked) {
        ContactsFrame.favoriteButtonClicked = favoriteButtonClicked;
    }

    public JPanel getContactComponents(){
        return contactComponents;
    }

    public static CallLog getCallLogCard(){
        return callLogCard;
    }
    public JPanel getContactCard(){
        return contactCard;
    }
    public JButton getSearchButton(){
        return searchButton;
    }

    public JPanel getDownButtonsPanel(){
        return downButtonsPanel;
    }

    public static JButton getAddContactsButton() {
        return addContactsButton;
    }

    public static JButton getMoreButton() {
        return moreButton;
    }

    public static void setCallLogCard(CallLog callLogCard) {
        ContactsFrame.callLogCard = callLogCard;
    }

    static Dimension size = new Dimension(265,485);

    public ContactsFrame(){

    }

    /**
     *
     * Designing top panel
     *
     */
    public void designTopPanel(){
        //Setting colors
        topButtonsPanel.setBackground(FontsAndColors.getTopPanelColor());
        callLogButton.setBackground(FontsAndColors.getTopPanelColor());
        contactsButton.setBackground(FontsAndColors.getTopPanelColor());
        favoritesButton.setBackground(FontsAndColors.getTopPanelColor());

        // Margins and padding
       // callLogButton.setMargin(new Insets(0,10,0,10));

        // Remove border focus
        callLogButton.setFocusPainted(false);
        contactsButton.setFocusPainted(false);
        favoritesButton.setFocusPainted(false);

        callLogButton.setBorderPainted(false);
        contactsButton.setBorderPainted(false);
        favoritesButton.setBorderPainted(false);


    }

    /**
     * Designing bottom panel
     *
     */
    public void designBottomPanel(){
        //setting colors
        downButtonsPanel.setBackground(FontsAndColors.bottomPanelColor);
        searchButton.setBackground(FontsAndColors.bottomPanelColor);
        addContactsButton.setBackground(FontsAndColors.bottomPanelColor);
        moreButton.setBackground(FontsAndColors.bottomPanelColor);

        searchButton.setFocusPainted(false);
        addContactsButton.setFocusPainted(false);
        moreButton.setFocusPainted(false);

        searchButton.setBorderPainted(false);
        addContactsButton.setBorderPainted(false);
        moreButton.setBorderPainted(false);
    }
    public void addComponentToPane(Container pane){
        /**
         * Adding designs
         */
        designTopPanel();
        designBottomPanel();

        /**
         * Adding top buttons to the Panel
         */
        topButtonsPanel.add(callLogButton);
        topButtonsPanel.add(contactsButton);
        topButtonsPanel.add(favoritesButton);

        /**
         * Adding bottom buttons to the panel
         */
        downButtonsPanel.add(searchButton);
        downButtonsPanel.add(addContactsButton);
        downButtonsPanel.add(moreButton);

        //add event listeners to the bottom buttons
        searchButton.addActionListener(new ShowSearchBar());
        addContactsButton.addActionListener(new ShowNewContact());

        // adding content to the panes
        //contactCard.add(new JLabel("The contacts are displayed here"));
        //callLogCard.add(new JLabel("The call logs are displayed here"));
        favoritesCard.add(new JLabel(favoriteString));

        // Create the components that contain the cards and add the cards to it
        contactComponents.add(contactCard, "contactCard");
        contactComponents.add(callLogCard, "callLogCard");
        contactComponents.add(favoritesCard, "favoritesCard");

        pane.add(topButtonsPanel, BorderLayout.PAGE_START);
        pane.add(contactComponents, BorderLayout.CENTER);
        pane.add(downButtonsPanel, BorderLayout.SOUTH);

    }

    public static void buttonEvent(){
        callLogButton.addActionListener(new ShowCallLog());
        contactsButton.addActionListener(new ShowContacts());
        favoritesButton.addActionListener(new ShowFavorites());
    }

    public void addDialDrawer(JButton drawer){
        drawer.setBorderPainted(false);
        drawer.setFocusPainted(false);
        drawer.setBackground(FontsAndColors.bottomPanelColor);

        getDownButtonsPanel().removeAll();
        getDownButtonsPanel().setLayout(new FlowLayout(FlowLayout.RIGHT));
        getDownButtonsPanel().add(drawer);
        getDownButtonsPanel().repaint();
        getDownButtonsPanel().revalidate();
        setLogButtonClicked(1);

        drawer.addActionListener(new ShowDialPad());
    }



    public static ImageIcon getIcon(String location){
        try{
           // imageIcon = ImageIO.read(new File(location));
            imageIcon = new ImageIcon(HomeFrame.class.getResource(location)).getImage();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        Image newImage = imageIcon.getScaledInstance(30,30,Image.SCALE_SMOOTH);
        ImageIcon finalIcon = new ImageIcon(newImage);
        return finalIcon;
    }




}
