package gui;
import model.Password;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PasswordFrame extends JFrame {

    private PasswordPanel panel;
    private char[] generatedPassword;

    public PasswordFrame() {

        super("PASSWORD GEN");


        panel = new PasswordPanel();
        add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,375);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        ManagerPasswordFrame manager = new ManagerPasswordFrame();
        panel.getGenPasswordButton().addActionListener(manager);
        panel.getShowHiddenPasswordButton().addActionListener(manager);
        panel.getCopyPasswordButton().addActionListener(manager);
    }




    private class ManagerPasswordFrame implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == panel.getGenPasswordButton()) {
                Password password = new Password();
                int length;
                try {
                    length = Integer.parseInt(panel.getLengthField().getText());
                    if (length < 6 || length > 30) {
                        String message = (length < 6) ?
                            "Introduce un número igual o mayor que 6" : 
                            "Introduce un número menor o igual que 30";
                        JOptionPane.showMessageDialog(null, message);
                        panel.getLengthField().setText("");
                        panel.getLengthField().requestFocusInWindow();
                        return;
                    }
                    password.generatePassword(length);
                    generatedPassword = password.getGeneratedPassword();

                    if(panel.getShowHiddenPasswordButton().getText().equals("MOSTRAR")) {
                        panel.getShowPasswordField().setText("*".repeat(generatedPassword.length));
                    }else panel.getShowPasswordField().setText(new String(generatedPassword));



                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Introduce un número válido");
                    panel.getLengthField().setText("");
                    panel.getLengthField().requestFocusInWindow();

                }
            }
            if (e.getSource() == panel.getShowHiddenPasswordButton()) {
                if (generatedPassword == null) return;

                if (panel.getShowHiddenPasswordButton().getText().equals("MOSTRAR")) {
                    panel.getShowPasswordField().setText(new String(generatedPassword));
                    panel.getShowHiddenPasswordButton().setText("OCULTAR");

                } else {
                    panel.getShowPasswordField().setText("*".repeat(generatedPassword.length));
                    panel.getShowHiddenPasswordButton().setText("MOSTRAR");
                }
            }

            if(e.getSource() == panel.getCopyPasswordButton()){
                if(generatedPassword == null) return;

                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new java.awt.datatransfer.StringSelection(new String(generatedPassword)), null);
                panel.getCopyPasswordButton().setFont(new Font("Arial", Font.ITALIC,16));
                panel.getCopyPasswordButton().setText("¡Copiado!");
                panel.getCopyPasswordButton().setBackground(new Color(137,137,137));
                new Timer(2500, ev -> {
                    panel.getCopyPasswordButton().setFont(new Font("Arial", Font.BOLD,16));
                    panel.getCopyPasswordButton().setText("COPIAR");
                    panel.getCopyPasswordButton().setBackground(new Color(102,0,51));
                }).start();
            }

        }

    }
}



