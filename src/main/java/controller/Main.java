package controller;
import gui.PasswordFrame;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }


        SwingUtilities.invokeLater(PasswordFrame::new);


    }
}


