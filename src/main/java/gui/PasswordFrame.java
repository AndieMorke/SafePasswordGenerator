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
        this.setSize(500,300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        panel.getGenPassword().addActionListener(new ManagerPasswordFrame());
    }


    private class ManagerPasswordFrame implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == panel.getGenPassword()) {
                Password pwd = new Password();
                int length;
                try {
                    length = Integer.parseInt(panel.getNumber().getText());
                    while (length < 6) {
                        JOptionPane.showMessageDialog(null, "Introduce un número mayor o igual que 6");
                        panel.getNumber().setText("");
                        panel.getNumber().requestFocusInWindow();
                        return;
                    }
                    pwd.setUserPassword(length);
                    pwd.createUserPassword();
                    panel.getShowPassword().setText(new String(pwd.getUserPassword()));
//                    panel.getNumber().setText("");
//                    panel.getNumber().requestFocusInWindow();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Introduce un número válido");
                    panel.getNumber().setText("");
                    panel.getNumber().requestFocusInWindow();

                }
            }
        }
    }


}
