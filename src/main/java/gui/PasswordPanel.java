package gui;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PasswordPanel extends JPanel {

    private JLabel length,copyright,label;
    private JTextField number;
    private JButton genPasswordButton,showHiddenPasswordButton;
    private JPasswordField showPassword;
    private JPanel lengthPanel,menuPanel,generatePanel,showPanel,southPanel,northPanel,centerPanel;


    public PasswordPanel (){

       setLayout(new BorderLayout());
       setBorder(new EmptyBorder(10, 20, 10, 20));
       //setBackground(new Color(255,218,185));



        /*
         * PANEL PRINCIPAL NORTE - TÍTULO
         * */
        northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        label = new JLabel("CONTRASEÑA SEGURA\n");
        label.setFont(new Font("Arial", Font.BOLD,26));
        label.setForeground(new Color(125,0,50));
        northPanel.add(label);
        //northPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        add(northPanel,BorderLayout.NORTH);


        /*
        * PANEL PRINCIPAL CENTRO - MENÚ
        * */
        centerPanel = new JPanel(new BorderLayout());
            menuPanel = new JPanel();

            // Menú longitud
                    lengthPanel = new JPanel(new FlowLayout());
                        length = new JLabel("Longitud deseada: ");
                        length.setFont(new Font("Arial", Font.PLAIN,16));
                        number = new JTextField(3);
                        number.setFont(new Font("Arial", Font.PLAIN,16));
                        number.setPreferredSize(new Dimension(50,25));
                        number.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
                    lengthPanel.add(length);
                    lengthPanel.add(number);

            // Botón [GENERAR]
                generatePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                    genPasswordButton = new JButton("GENERAR");
                    genPasswordButton.setFont(new Font("Arial", Font.BOLD,16));
                    genPasswordButton.setForeground(Color.WHITE);
                    genPasswordButton.setBackground(new Color(125,0,50));
                    genPasswordButton.setPreferredSize(new Dimension(125,50));
                generatePanel.setBorder(new EmptyBorder(0, 0, 20, 0));
                generatePanel.add(genPasswordButton);

            menuPanel.setLayout(new BoxLayout(menuPanel,BoxLayout.Y_AXIS));
            menuPanel.add(lengthPanel);
            menuPanel.add(Box.createRigidArea(new Dimension(0,10)));
            menuPanel.add(generatePanel);

            // Campo contraseña
                showPassword = new JPasswordField();
                showPassword.setEditable(false);
                showPassword.setFont(new Font("Arial", Font.BOLD, 28));
                showPassword.setHorizontalAlignment(JTextField.CENTER);
                showPassword.setBorder(BorderFactory.createLineBorder(new Color(125,0,50)));

        showPassword.setBackground(new Color(250,250,250));

                // Botón [MOSTRAR]
            showPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                showHiddenPasswordButton = new JButton("MOSTRAR");
                showHiddenPasswordButton.setBackground(new Color(125,0,50));
                showHiddenPasswordButton.setForeground(Color.WHITE);
                showHiddenPasswordButton.setFont(new Font("Arial", Font.BOLD,16));
                showHiddenPasswordButton.setPreferredSize(new Dimension(125,50));
                showPanel.setBorder(new EmptyBorder(20,0,0,0));
            showPanel.add(showHiddenPasswordButton);

        centerPanel.setBorder(new EmptyBorder(10,0,10,0));
        centerPanel.add(menuPanel,BorderLayout.NORTH);
        centerPanel.add(showPassword,BorderLayout.CENTER);
        centerPanel.add(showPanel,BorderLayout.SOUTH);

       add(centerPanel,BorderLayout.CENTER);



        /*
         * PANEL PRINCIPAL SUR - COPYRIGHT
         * */
       southPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
       copyright = new JLabel("© Andie Mørke");
       copyright.setFont(new Font("Serif", Font.PLAIN,14));
       //southPanel.setBackground(new Color(255,218,185));
       southPanel.add(copyright);
       //southPanel.setBorder(new EmptyBorder(0,0,5,10));
       add(southPanel,BorderLayout.SOUTH);
    }

    // GETTERS
    public JTextField getNumber() {
        return this.number;
    }
    public JButton getGenPassword() {
        return this.genPasswordButton;
    }
    public JPasswordField getShowPassword() {
        return this.showPassword;
    }
    public JButton getShowHiddenPasswordButton() {
        return this.showHiddenPasswordButton;
    }
}

