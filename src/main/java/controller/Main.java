package controller;
import database.Database;
import gui.PasswordFrame;
import model.PasswordRecord;
import model.PasswordManager;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.sql.Array;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException{

        try {
            UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }

        SwingUtilities.invokeLater(PasswordFrame::new);

        ArrayList<PasswordRecord> recordsList = new ArrayList<>();

        Database db = new Database();
        try (Connection conn = db.setConnection()) {
            recordsList.add(new PasswordRecord("FacebOok","user1","example1@gmail.com","examplepass1"));
            PasswordManager passwordManager = new PasswordManager();
            passwordManager.insertPassword(recordsList.get(0));
            recordsList.add(new PasswordRecord("Instagram","example@gmail.com","examplepass5435"));
            passwordManager.insertPassword(recordsList.get(1));

        } catch (SQLException e) {
            e.printStackTrace();
            }
    }
}


