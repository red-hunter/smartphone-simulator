package simulator.views;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class MainHomeFrame extends JPanel {
    Image backgroundPicture = new ImageIcon(HomeFrame.class.getResource("assets/background.jpeg")).getImage();
    static HomeResources addButtons = new HomeResources();

    static JPanel firstPanel = new JPanel();
    static JPanel secondPanel = new JPanel();
    static JPanel thirdPanel = new JPanel();
    static JPanel forthPanel = new JPanel();
    static JPanel homeAppsPanel1 = new JPanel();
    static JPanel homeAppsPanel2 = new JPanel();



    public MainHomeFrame(){
        setLayout(new GridLayout(6,1));
        firstPanel.setBackground(FontsAndColors.transparent);
        add(firstPanel);
        secondPanel.setBackground(FontsAndColors.transparent);
        add(secondPanel);
        thirdPanel.setBackground(FontsAndColors.transparent);
        add(thirdPanel);
        forthPanel.setBackground(FontsAndColors.transparent);
        add(forthPanel);

        homeAppsPanel1.setBackground(FontsAndColors.transparent);
        addButtons.designHomeIcon(addButtons.getPhoneLogButton());
        homeAppsPanel1.add(HomeResources.getPhoneLogButton());
        HomeResources.designHomeIcon(HomeResources.getContactsButton());
        homeAppsPanel1.add(HomeResources.getContactsButton());
        HomeResources.designHomeIcon(HomeResources.getCalendarButton());
        homeAppsPanel1.add(HomeResources.getCalendarButton());
        HomeResources.designHomeIcon(HomeResources.getMessagingButton());

        homeAppsPanel2.setBackground(FontsAndColors.transparent);
        homeAppsPanel2.add(HomeResources.getMessagingButton());
        HomeResources.designHomeIcon(HomeResources.getAppDrawerButton());
        homeAppsPanel2.add(HomeResources.getAppDrawerButton());
        HomeResources.designHomeIcon(HomeResources.getGalleryButton());
        homeAppsPanel2.add(HomeResources.getGalleryButton());


       // secondPanel.add(hourLabel);
        //thirdPanel.add(minuteLabel);
        Clock clock = new Clock();
        clock.start();
        secondPanel.add(clock.time);
        thirdPanel.add(clock.minuteLabel);
        add(homeAppsPanel1);
        add(homeAppsPanel2);

    }



    public static Image getImage(Image img){

        Image newImage = img.getScaledInstance(295,615,Image.SCALE_SMOOTH);
        Image finalImage = new ImageIcon(newImage).getImage();

        return finalImage;
    }


    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.drawImage(getImage(backgroundPicture),0,0,this);
    }
}


class Clock {
    static JLabel time = new JLabel();
    static DateFormat sdf  = DateFormat.getTimeInstance(DateFormat.SHORT);
    private int   currentSecond;
    private java.util.Calendar calendar;

    private int hour ;
    static int minute = Calendar.MINUTE;
    static int month = Calendar.MONTH;
    static int day = Calendar.DAY_OF_WEEK;
    static int dayMonth = Calendar.DAY_OF_MONTH;

    static JLabel hourLabel = new JLabel();
    static JLabel minuteLabel = new JLabel();
    static JLabel timeOfDayLabel = new JLabel();
    static JLabel monthLabel = new JLabel();
    static JLabel dayLabel = new JLabel();
    static JLabel dayMonthLabel = new JLabel();
    private void reset(){
        calendar = java.util.Calendar.getInstance();
        currentSecond = calendar.get(java.util.Calendar.SECOND);
        minute = calendar.get(Calendar.MINUTE);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_WEEK);
        dayMonth = calendar.get(Calendar.DAY_OF_MONTH);

    }
    public void start(){
        reset();
        java.util.Timer timer = new Timer();
        timer.scheduleAtFixedRate( new TimerTask(){
            public void run(){
                if( currentSecond == 60 ) {
                    reset();
                }
                time.setBounds(125,120,100,80);
                time.setForeground(Color.white);
                time.setFont(new Font("Algeria",Font.BOLD,25));
                //time.setText( String.format("%s:%02d", sdf.format(calendar.getTime()),currentSecond ));
                time.setText( String.format( sdf.format(calendar.getTime()) ));

                minuteLabel.setBounds(125,130,100,80);
                minuteLabel.setForeground(Color.white);
                minuteLabel.setFont(new Font("Algeria",Font.ITALIC,18));
                minuteLabel.setText(getDaysForInt(day)+ ", " + getMonthForInt(month) + " " + String.valueOf(dayMonth));
                currentSecond++;
            }
        }, 0, 1000 );
    }

    static String getMonthForInt(int num) {
        String month = "";
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getMonths();
        if (num >= 0 && num <= 11 ) {
            month = months[num];
        }
        return month;
    }

    static String getDaysForInt(int num) {
        String day = "";
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getShortWeekdays();
        if (num >= 0 && num <= 6 ) {
            day = months[num];
        }
        return day;
    }
}