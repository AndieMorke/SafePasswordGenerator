package controller;
import gui.PasswordFrame;
import model.Password;
import view.PasswordView;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new PasswordFrame();
        });

//        Password pwd = new Password();
//        PasswordView view = new PasswordView();
//        boolean exit = false;
//
//        do {
//            if (view.menu() == 1) {
//                pwd.setUserPassword(view.askLength());
//                pwd.createUserPassword();
//                view.showPassword(pwd);
//
//            } else exit = true;
//
//        }while (!exit);







    }
}


