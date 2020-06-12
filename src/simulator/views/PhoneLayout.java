package simulator.views;

import java.awt.*;
import javax.swing.*;

public class PhoneLayout extends JPanel {


    private Image phoneFrame = new ImageIcon(HomeFrame.class.getResource("assets/mockup.png")).getImage();
    private Dimension size = new Dimension(phoneFrame.getWidth(null)  , phoneFrame.getHeight(null) + 50) ;
    static HomeScreen home = new HomeScreen();

    public PhoneLayout() {
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        add(home);

    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);

        g.drawImage(phoneFrame, 0, 0, this);

        setFont(new Font(Font.MONOSPACED,Font.BOLD,16));
        g.drawString("G-15",(int) (size.width * 0.45),(int) (size.height*0.89));

        home.setBounds(13, 38, (int)(size.width * 0.905), (int)(size.height*0.8));

    }



}
