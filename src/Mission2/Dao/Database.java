package Mission2.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//import javax.swing.JOptionPane;

public class Database {
    //External jar for mysql
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    //Connection to database
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/city_drive";

    public static Connection connection = null;


    public static boolean connect() {

        try {
            //loading driver + login mysql
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(
                    CONNECTION_STRING,
                    "daklyan",
                    "D4rkn00bs"
            );

            return true;

        } catch (ClassNotFoundException err) {

            System.err.println("Error : " + err.getMessage());

            return false;

        } catch (SQLException err) {

            System.err.println("Error : " + err.getMessage());

            return false;
        }
    }

    public static Statement getStatement() {
        // Test if the connection is open
        if (connection == null) {
            connect();
        }
        try {
            return connection.createStatement();
        } catch (SQLException err) {
            System.err.println("Error check : " + err.getMessage());
            return null;
        }
    }

    public static void disconnect() {
        if (connection != null) {

            try {
                connection.close();
            } catch (SQLException err) {
                System.err.println("Database disconnecting error : " + err.getMessage());
            }
            connection = null;
        }
    }
}