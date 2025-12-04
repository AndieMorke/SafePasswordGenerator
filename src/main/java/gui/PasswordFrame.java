package gui;

import model.Password;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordFrame extends JFrame {

    private PasswordPanel panel;

    public PasswordFrame() {

        super("PASSWORD GEN");

        panel = new PasswordPanel();
        add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300,200);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        panel.getGenPassword().addActionListener(new ManagerPasswordFrame());

    }



    private class ManagerPasswordFrame implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == panel.getGenPassword()) {
                Password pwd = new Password();
                try {
                    int length = Integer.parseInt(panel.getNumber().getText());
                    pwd.setUserPassword(length);
                    pwd.createUserPassword();
                    panel.getShowPassword().setText(new String(pwd.getUserPassword()));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Introduce un número válido");
                }
            }
        }
    }


}
