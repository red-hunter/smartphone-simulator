package simulator.views;

import simulator.models.Connect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MessageInterface extends JPanel {

    private static Connect connector = new Connect();

    static Dimension size = new Dimension(265,485);

    static String send = "assets/send.png";

    static JPanel heading = new JPanel(new FlowLayout(FlowLayout.CENTER));
    static JPanel body = new JPanel(new GridLayout(20,1));
    static JPanel messagePane = new JPanel();
    static JPanel sentMessagePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    static JPanel receivedMessagePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    static JLabel sentMessageLabel = new JLabel();
    static JLabel receivedMessageLabel = new JLabel();

    static JLabel messageHeader = new JLabel("Messages");
    static JTextField messageField = new JTextField(15);
    static JButton sendButton = new JButton(ContactsFrame.getIcon(send));

    static String sent;
    static String received;

    public MessageInterface(){
        setSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);
        setLayout(new BorderLayout());
        addComponents();
        add(heading, BorderLayout.PAGE_START);
        add(body, BorderLayout.CENTER);
        add(messagePane, BorderLayout.SOUTH);


        designButton(sendButton);
        sendButton.addActionListener(new message_Sent());
    }

    public void addComponents(){
        heading.add(messageHeader);

        messagePane.add(messageField);
        messagePane.add(sendButton);
    }

    static class message_Sent implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            sent = messageField.getText();

            switch (sent){
                case "Hi":
                    received = "Hello";
                    break;
                case "Hello":
                    received = "Hi";
                    break;
                default:
                    received = "dummy";
            }
            messageField.setText("");
            insert(sent, received);

            sentMessagePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            receivedMessagePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel sentMessageLabel = new JLabel();
            JLabel receivedMessageLabel = new JLabel();

            sentMessageLabel.setText(sent);
            sentMessagePanel.add(sentMessageLabel);
            body.add(sentMessagePanel);

            receivedMessageLabel.setText(received);
            receivedMessagePanel.add(receivedMessageLabel);
            body.add(receivedMessagePanel);
            sentMessageLabel = new JLabel();
            receivedMessageLabel = new JLabel();

        }
    }

    public static void designButton(JButton button){
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setBackground(FontsAndColors.transparent);
        button.setBorder(BorderFactory.createEmptyBorder());
    }

    public static void insert(String sent, String received) {
        String sql = "INSERT INTO Messages(messageSent, messageReceived) VALUES(?,?)";

        try (Connection conn = connector.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, sent);
            pstmt.setString(2, received);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

