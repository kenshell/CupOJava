import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

    public Model() {
        // Initialize database connection
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "username", "password");

            // Drop existing tables (for testing purposes)
            dropTables();

            // Create tables and insert test data
            createTables();
            insertTestData();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void dropTables() {
        try (Statement statement = connection.createStatement()) {
            statement.execute("DROP TABLE IF EXISTS Instruments, Locations, Inventory");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTables() {
        try (Statement statement = connection.createStatement()) {
            createInstruments(statement);
            createLocations(statement);
            createInventory(statement);
        } catch (SQLException | Exception e) {
            e.printStackTrace();
        }
    }

    private void insertTestData() {
        try (Statement statement = connection.createStatement()) {
            createInstruments(statement);
            createLocations(statement);
            createInventory(statement);
        } catch (SQLException | Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try (Statement statement = connection.createStatement()) {
            return statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Implement other methods as needed based on your requirements
    // e.g., additional database interaction methods
}
