package gui;
import model.Password;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PasswordFrame extends JFrame {

    private final PasswordPanel PANEL;
    private char[] generatedPassword;

    public PasswordFrame() {

        super("PASSWORD GEN");

        PANEL = new PasswordPanel();
        add(PANEL);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,425);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        ManagerPasswordFrame manager = new ManagerPasswordFrame();

        PANEL.getGenerateButton().addActionListener(manager);
        PANEL.getShowButton().addActionListener(manager);
        PANEL.getPasswordField().addActionListener(manager);
        PANEL.getCopyButton().addActionListener(manager);

        // Slider → TextField
        PANEL.getLengthSlider().addChangeListener(e -> {
            int value = PANEL.getLengthSlider().getValue();
            if (!PANEL.getLengthField().getText().equals(String.valueOf(value))) {
                PANEL.getLengthField().setText(String.valueOf(value));
            }
        });

        // TextField → Slider
        PANEL.getLengthField().getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            private void updateSlider() {
                try {
                    int value = Integer.parseInt(PANEL.getLengthField().getText());
                    if (value >= PANEL.getLengthSlider().getMinimum() && value <= PANEL.getLengthSlider().getMaximum()) {
                        if (PANEL.getLengthSlider().getValue() != value) {
                            PANEL.getLengthSlider().setValue(value);
                        }
                    }
                } catch (NumberFormatException ignored) {}
            }
            @Override public void insertUpdate(javax.swing.event.DocumentEvent e) { updateSlider(); }
            @Override public void removeUpdate(javax.swing.event.DocumentEvent e) { updateSlider(); }
            @Override public void changedUpdate(javax.swing.event.DocumentEvent e) { updateSlider(); }
        });
    }

    private class ManagerPasswordFrame implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == PANEL.getGenerateButton()) {
                Password password = new Password();
                int length = Integer.parseInt(PANEL.getLengthField().getText());
                    password.generatePassword(length);
                    generatedPassword = password.getGeneratedPassword();

                    if(PANEL.getShowButton().getText().equals("MOSTRAR")) {
                        PANEL.getPasswordField().setText("*".repeat(generatedPassword.length));
                    }else PANEL.getPasswordField().setText(new String(generatedPassword));
            }
            if (e.getSource() == PANEL.getShowButton()) {
                if (generatedPassword == null) return;

                if (PANEL.getShowButton().getText().equals("MOSTRAR")) {
                    PANEL.getPasswordField().setText(new String(generatedPassword));
                    PANEL.getShowButton().setText("OCULTAR");

                } else {
                    PANEL.getPasswordField().setText("*".repeat(generatedPassword.length));
                    PANEL.getShowButton().setText("MOSTRAR");
                }
            }
            if(e.getSource() == PANEL.getCopyButton()){
                if(generatedPassword == null) return;

                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(new String(generatedPassword)), null);
                PANEL.getCopyButton().setFont(new Font("Arial", Font.ITALIC,16));
                PANEL.getCopyButton().setText("¡Copiado!");
                PANEL.getCopyButton().setBackground(new Color(137,137,137));
                new Timer(2500, ev -> {
                    PANEL.getCopyButton().setFont(new Font("Arial", Font.BOLD,16));
                    PANEL.getCopyButton().setText("COPIAR");
                    PANEL.getCopyButton().setBackground(new Color(102,0,51));
                }).start();
            }

        }
    }
}



