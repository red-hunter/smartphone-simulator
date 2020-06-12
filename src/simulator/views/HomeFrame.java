package simulator.views;

import javax.swing.*;
import java.awt.*;

public class HomeFrame extends JPanel {
    static PhoneLayout phonePanel;
    public static void main(String[] args) {
        JFrame phone = new JFrame("G-15 PHONE SIMULATOR");
        phonePanel = new PhoneLayout();
        Dimension frameSize = phonePanel.getSize();
        phone.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        phone.setSize(frameSize);
        phone.setAlwaysOnTop(true);
        phone.setResizable(false);
        JPanel background = new JPanel();
        background.add(phonePanel);

        phone.add(background);
        phone.setVisible(true);
    }

}
