

import java.sql.*;
import java.util.ResourceBundle;

public class MySQL {
    
    //Connection to the server was hidden using a .properties file, and putting it to the .gitignore file.
    public static void main(String[] args) {
        ResourceBundle reader = null;
        reader = ResourceBundle.getBundle("mySQL/dbconfig");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(reader.getString("db.url"), reader.getString("db.username"),
                    reader.getString("db.password"));
            System.out.println("Connected to the database");
            testConnection(conn);
        } catch (ClassNotFoundException e) {
            System.out.println("Could not find the MySQL JDBC driver");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database");
            e.printStackTrace();
        }
    }

    //Test Connection to the DB..

    public static void testConnection(Connection conn) {
        String query = "SELECT DATABASE();";
        try {
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            if (result.next()) {
                System.out.println("You are connected to the database: " + result.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}