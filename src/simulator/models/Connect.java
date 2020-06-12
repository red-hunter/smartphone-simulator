package simulator.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    public static Connection connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:C:/users/Red_hunter/desktop/phone simulator/src/simulator/models/phone.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            //System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void main(String[] args) {
        connect();
    }
}
