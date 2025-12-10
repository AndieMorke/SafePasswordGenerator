package gui;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PasswordPanel extends JPanel {


    private JTextField lengthField;
    private JButton genPasswordButton,showHiddenPasswordButton,copyPasswordButton;
    private JTextField showPasswordField;

    public PasswordPanel (){

       setLayout(new BorderLayout(0,10));
       setBorder(new EmptyBorder(10, 20, 10, 20));
       //setBackground(new Color(255,218,185));



        /*
         * PANEL PRINCIPAL NORTE - TÍTULO
         * */
        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel title = new JLabel("CONTRASEÑA SEGURA\n");
        title.setFont(new Font("Arial", Font.BOLD,26));
        title.setForeground(new Color(102,0,51));
        northPanel.add(title);
        add(northPanel,BorderLayout.NORTH);


        /*
        * PANEL PRINCIPAL CENTRO - MENÚ
        * */
        JPanel centerPanel = new JPanel(new BorderLayout(0,20));
            JPanel menuPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,20,0));

            // Menú longitud
                    JPanel lengthPanel = new JPanel();
                        JLabel length = new JLabel("Introduzca la longitud deseada: ");
                        length.setFont(new Font("Arial", Font.PLAIN,16));
                        lengthField = new JTextField(2);
                        lengthField.setFont(new Font("Arial", Font.PLAIN,16));
                        lengthField.setPreferredSize(new Dimension(50,25));
                        lengthField.setBorder(BorderFactory.createCompoundBorder(
                            BorderFactory.createLineBorder(Color.LIGHT_GRAY),      // borde externo
                            BorderFactory.createEmptyBorder(0, 5, 0, 0)            // padding interno
                )
        );

        lengthPanel.add(length);
                    lengthPanel.add(lengthField);
                    lengthPanel.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));

            // Botón [GENERAR]
                JPanel generatePanel = new JPanel();
                    genPasswordButton = new JButton("GENERAR");
                    genPasswordButton.setFont(new Font("Arial", Font.BOLD,16));
                    genPasswordButton.setForeground(Color.WHITE);
                    genPasswordButton.setBackground(new Color(102,0,51));
                    genPasswordButton.setPreferredSize(new Dimension(120,50));
                generatePanel.add(genPasswordButton);

            menuPanel.add(lengthPanel);
            menuPanel.add(generatePanel);

            // Campo contraseña
                showPasswordField = new JTextField();
                showPasswordField.setEditable(false);
                showPasswordField.setFont(new Font("Monospaced", Font.PLAIN, 32));
                showPasswordField.setHorizontalAlignment(JTextField.CENTER);
                showPasswordField.setBorder(BorderFactory.createLineBorder(new Color(102,0,51),1,true));
                showPasswordField.setBackground(new Color(250,250,250));




            // Botones [MOSTRAR] y [COPIAR]
        JPanel showCopyPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,20,0));
            JPanel showPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                showHiddenPasswordButton = new JButton("MOSTRAR");
                showHiddenPasswordButton.setBackground(new Color(102,0,51));
                showHiddenPasswordButton.setForeground(Color.WHITE);
                showHiddenPasswordButton.setFont(new Font("Arial", Font.BOLD,16));
                showHiddenPasswordButton.setPreferredSize(new Dimension(125,50));
            showPanel.add(showHiddenPasswordButton);
        showCopyPanel.add(showPanel);

            // Botón [COPIAR]
            JPanel copyPasswordPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            copyPasswordButton = new JButton("COPIAR");
            copyPasswordButton.setBackground(new Color(102,0,51));
            copyPasswordButton.setForeground(Color.WHITE);
            copyPasswordButton.setFont(new Font("Arial", Font.BOLD,16));
            copyPasswordButton.setPreferredSize(new Dimension(125,50));
            copyPasswordPanel.add(copyPasswordButton);
            showCopyPanel.add(copyPasswordPanel);


        centerPanel.add(menuPanel,BorderLayout.NORTH);
        centerPanel.add(showPasswordField,BorderLayout.CENTER);
        centerPanel.add(showCopyPanel,BorderLayout.SOUTH);

       add(centerPanel,BorderLayout.CENTER);


       /**
       * PANEL PRINCIPAL SUR - COPYRIGHT
       */
       JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
       JLabel copyright = new JLabel("© Andie Mørke");
       copyright.setFont(new Font("Serif", Font.PLAIN,14));
       southPanel.add(copyright);
       add(southPanel,BorderLayout.SOUTH);
    }

    // GETTERS
    public JTextField getLengthField() {
        return this.lengthField;
    }
    public JButton getGenPasswordButton() {
        return this.genPasswordButton;
    }
    public JTextField getShowPasswordField() {
        return this.showPasswordField;
    }
    public JButton getShowHiddenPasswordButton() {
        return this.showHiddenPasswordButton;
    }
    public JButton getCopyPasswordButton() {
        return this.copyPasswordButton;
    }
}

