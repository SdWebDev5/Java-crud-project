import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            // Agar connection null hai YA fir band (isClosed) ho chuka hai, to naya banayein
            if (connection == null || connection.isClosed()) {
                String url = ConfigLoader.getProperty("db.url");
                String user = ConfigLoader.getProperty("db.user");
                String password = ConfigLoader.getProperty("db.password");

                connection = DriverManager.getConnection(url, user, password);
                System.out.println("Database connected successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Database connection fail ho gaya!");
            e.printStackTrace();
        }
        return connection;
    }
}
