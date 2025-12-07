package gui;
import model.Password;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class PasswordFrame extends JFrame {

    private PasswordPanel panel;
    private char[] generatedPassword;

    public PasswordFrame() {

        super("PASSWORD GEN");


        panel = new PasswordPanel();
        add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,410);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        ManagerPasswordFrame manager = new ManagerPasswordFrame();
        panel.getGenPassword().addActionListener(manager);
        panel.getShowHiddenPasswordButton().addActionListener(manager);
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
                    while (length > 30) {
                        JOptionPane.showMessageDialog(null, "Introduce un número menor o igual que 30");
                        panel.getNumber().setText("");
                        panel.getNumber().requestFocusInWindow();
                        return;
                    }

                    pwd.setUserPassword(length);
                    pwd.createUserPassword();
                    generatedPassword = pwd.getUserPassword();

                    if(panel.getShowHiddenPasswordButton().getText().equals("MOSTRAR")) {
                        panel.getShowPassword().setText("*".repeat(generatedPassword.length));
                    }else panel.getShowPassword().setText(new String(generatedPassword));



                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Introduce un número válido");
                    panel.getNumber().setText("");
                    panel.getNumber().requestFocusInWindow();

                }
            }
            if (e.getSource() == panel.getShowHiddenPasswordButton()) {
                if (generatedPassword == null) return;

                if (panel.getShowHiddenPasswordButton().getText().equals("MOSTRAR")) {
                    panel.getShowPassword().setText(new String(generatedPassword));
                    panel.getShowHiddenPasswordButton().setText("OCULTAR");

                } else {
                    panel.getShowPassword().setText("*".repeat(generatedPassword.length));
                    panel.getShowHiddenPasswordButton().setText("MOSTRAR");
                }
            }

        }
    }


}
