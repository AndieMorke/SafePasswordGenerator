package model;
import database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class PasswordManager {

    public void insertPassword(PasswordRecord passwordRecord) throws SQLException {
        Database db = new Database();
        String insert = "INSERT INTO passwords " +
                "(platform, username, email, password) " +
                "VALUES (?, ?, ?, ?)";
        try (Connection connection = db.setConnection();
             PreparedStatement insertStatement = connection.prepareStatement(insert)) {

            insertStatement.setString(1, passwordRecord.getPlatform());
            if (passwordRecord.getUsername() != null) {
                insertStatement.setString(2, passwordRecord.getUsername());
            } else {
                insertStatement.setNull(2, java.sql.Types.VARCHAR);
            }
            insertStatement.setString(3, passwordRecord.getEmail());
            insertStatement.setString(4, passwordRecord.getPassword());
            insertStatement.executeUpdate();
        }
    }

    public void updatePassword(PasswordRecord passwordRecord) throws SQLException{
        Database db = new Database();
        String update = "UPDATE passwords SET password = ? WHERE platform = ? AND email = ?";

        try (Connection connection = db.setConnection();
             PreparedStatement updateStatement = connection.prepareStatement(update)) {

            updateStatement.setString(1, passwordRecord.getPassword());
            updateStatement.setString(2, passwordRecord.getPlatform());
            updateStatement.setString(3, passwordRecord.getEmail());

            updateStatement.executeUpdate();
        }


    }

    public void deletePassword(PasswordRecord passwordRecord) throws SQLException{
        Database db = new Database();
        String delete = "DELETE FROM passwords " +
                "WHERE platform = ? " +
                "AND (email = ? OR username = ?)";

        try (Connection connection = db.setConnection();
             PreparedStatement deleteStatement = connection.prepareStatement(delete)) {

            deleteStatement.setString(1, passwordRecord.getPlatform());
            deleteStatement.setString(2, passwordRecord.getEmail());
            deleteStatement.setString(3, passwordRecord.getUsername());

            deleteStatement.executeUpdate();
        }

    }

    public void getPassword(PasswordRecord passwordRecord) throws SQLException{
        Database db = new Database();
        String select = "SELECT * FROM passwords " +
                "WHERE platform = ? " +
                "AND (email = ? OR username = ?)";

        try (Connection connection = db.setConnection();
             PreparedStatement selectStatement = connection.prepareStatement(select)) {

            selectStatement.setString(1, passwordRecord.getPlatform());
            selectStatement.setString(2, passwordRecord.getEmail());
            selectStatement.setString(3, passwordRecord.getUsername());

            selectStatement.executeQuery();
        }

    }
}
