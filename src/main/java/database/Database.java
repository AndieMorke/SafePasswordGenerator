package database;
import java.sql.*;

public class Database {

    public Connection connection;

    public Connection setConnection() throws SQLException {
        String connectionPath = "jdbc:sqlite:C:\\Users\\Andie\\Desktop\\PWD\\src\\main\\resources\\db\\DB_Password.db";
        connection = DriverManager.getConnection(connectionPath);
        return connection;
    }
}
