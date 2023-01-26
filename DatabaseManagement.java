import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

//This class is used to connect and execute queries to the database

public class DatabaseManagement {
    private Connection conn;

    public DatabaseManagement() {
        this.conn = connect();
    }

    public void insertItem(String itemType, int quantity, double price) {
        String sql = "INSERT INTO items (item_type, quantity, price) VALUES (?, ?, ?)";

        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, itemType);
            statement.setInt(2, quantity);
            statement.setDouble(3, price);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteItems(String itemType) {
        String sql = "DELETE FROM items WHERE item_type = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, itemType);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteEmployees(String employeeName) {
        String sql = "DELETE FROM employees WHERE name = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, employeeName);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void insertEmployees(String employeeName, double salary, String gender) {
        String sql = "INSERT INTO employees(name, salary, gender) VALUES (?, ?, ?)";

        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, employeeName);
            statement.setDouble(2, salary);
            statement.setString(3, gender);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection connect() {
        ResourceBundle reader = null;
        reader = ResourceBundle.getBundle("mySQL/dbconfig");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(reader.getString("db.url"), reader.getString("db.username"),
                    reader.getString("db.password"));
            System.out.println("Added Succesfully");
            return conn;
        } catch (ClassNotFoundException e) {
            System.out.println("Could not find the MySQL JDBC driver");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database");
            e.printStackTrace();
        }
        return null;
    }

}
