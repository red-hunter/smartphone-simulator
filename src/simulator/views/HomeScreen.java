package simulator.views;

import simulator.controller.Home;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class HomeScreen extends JPanel {
    Image backgroundPicture = new ImageIcon(HomeFrame.class.getResource("assets/background.jpeg")).getImage();
    Image status = new ImageIcon(HomeFrame.class.getResource("assets/top.png")).getImage();
    static Image homeButtonIcon = new ImageIcon(HomeFrame.class.getResource("assets/home.png")).getImage();
    static JPanel statusBar = new JPanel();
    static JPanel control = new JPanel(new FlowLayout(FlowLayout.CENTER));
    static MainHomeFrame appsHome = new MainHomeFrame();
    static JLabel battery = new JLabel(" ");
    static JButton homeButton = new JButton(getControl(homeButtonIcon));

    static int buttonClicked = 0;
    static int controlChanged = 0;

    private Dimension size = new Dimension(265 , 485) ;

    public HomeScreen(){
        setLayout(new BorderLayout());

        statusBar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        statusBar.add(battery);
        statusBar.setBackground(FontsAndColors.transparent);
        add(statusBar,BorderLayout.PAGE_START);


       // appsHome.setBackground(Color.BLUE);
        appsHome.setSize(size);
        appsHome.setPreferredSize(size);
        appsHome.setMaximumSize(size);
        appsHome.setMinimumSize(size);
        add(appsHome,BorderLayout.CENTER);


        control.setBackground(Color.RED);
        homeButton.setBackground(Color.RED);

        designControlButton(homeButton);
        control.add(homeButton);
        homeButton.addActionListener(new Home());

        add(control,BorderLayout.SOUTH);

    }

    public static MainHomeFrame getAppsHome() {
        return appsHome;
    }

    public static int getButtonClicked() {
        return buttonClicked;
    }

    public static void setButtonClicked(int buttonClicked) {
        HomeScreen.buttonClicked = buttonClicked;
    }

    public static Image getImage(Image img){

        Image newImage = img.getScaledInstance(295,615,Image.SCALE_SMOOTH);
        Image finalImage = new ImageIcon(newImage).getImage();

        return finalImage;
    }

    public static ImageIcon getControl(Image img){

        Image newImage = img.getScaledInstance(18,18,Image.SCALE_SMOOTH);
        ImageIcon finalImage = new ImageIcon(newImage);

        return finalImage;
    }

    public static Image getStatus(Image img){

        Image newImage = img.getScaledInstance(30,12,Image.SCALE_SMOOTH);
        Image finalImage = new ImageIcon(newImage).getImage();

        return finalImage;
    }

    public static void designControlButton(JButton button){
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder());
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.drawImage(getImage(backgroundPicture),0,0,this);

        g.drawImage(getStatus(status),230,5,this);


    }



}
