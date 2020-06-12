package simulator.views;

import simulator.controller.ShowCallLog;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class CallLog extends JPanel {
    static JPanel allLog = new JPanel(new GridLayout(20,1));
    static List<simulator.models.CallLog> callLogs;
    static ShowCallLog displayCallLogs = new ShowCallLog();
    private static int rows;

    static Dimension size = new Dimension(265,485);

    public CallLog(){

        setSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);


        allLog.setBackground(Color.white.brighter().brighter());
        setLayout(new GridLayout(1,1));
        add(new JScrollPane(allLog,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER));

        callLogs = displayCallLogs.getAllLogs();
        rows = callLogs.size()-1;
        for(int index = rows; index >= 0; index--){
            allLog.add(new LogField(callLogs.get(index).getName(),callLogs.get(index).getPhoneNumber(),callLogs.get(index).getCallHour(),callLogs.get(index).getCallMinute(),callLogs.get(index).getCallSecond()));

        }
        //allLog.add(new LogField());

    }
}
