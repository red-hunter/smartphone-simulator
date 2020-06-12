package simulator.views;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PersonField extends JPanel{
   // static BufferedImage img = null;
    static Image img = null;
    JLabel name = new JLabel("Name");
    JLabel phone = new JLabel("Phone");
    JLabel image = new JLabel();
    public PersonField(){

        setLayout(new BorderLayout());
        setBackground(Color.white.brighter().brighter());
        add(name,BorderLayout.NORTH);
        add(phone,BorderLayout.SOUTH);
        add(image,BorderLayout.EAST);
    }

    public PersonField(String userName, String userPhone, String userPicture){
        setLayout(new BorderLayout());
        setBackground(Color.white.brighter().brighter());
        setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.gray.brighter()));
        image.setText(userPicture);
        image.setSize(new Dimension(96,46));
        try{
            //img = ImageIO.read(new File(image.getText()));
            img = new ImageIcon(HomeFrame.class.getResource(image.getText())).getImage();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        //System.out.println(image.getText());
        Image newImage = img.getScaledInstance(image.getWidth(),image.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon newImageIcon = new ImageIcon(newImage);
        name.setText(userName);
        add(name,BorderLayout.NORTH);
        phone.setText( "0" + userPhone);
        add(phone,BorderLayout.SOUTH);
        image.setIcon(newImageIcon);
        image.setText("");
        add(image,BorderLayout.EAST);
        designText();
    }

    public void designText(){
        name.setBackground(Color.BLUE);
        name.setSize(60,50);
        name.setVerticalTextPosition(SwingConstants.BOTTOM);
        name.setHorizontalTextPosition(SwingConstants.CENTER);
        phone.setVerticalTextPosition(SwingConstants.TOP);
        phone.setHorizontalTextPosition(SwingConstants.CENTER);
        name.setFont(FontsAndColors.getNameFont());
    }
}
