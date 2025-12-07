package gui;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PasswordPanel extends JPanel {

    private JLabel length,copyright,label;
    private JTextField number;
    private JButton genPasswordButton,showHiddenPasswordButton,copyPasswordButton;
    private JTextField showPassword;
    private JPanel lengthPanel,menuPanel,generatePanel,showPanel,southPanel,northPanel,centerPanel,copyPasswordPanel,showCopyPanel;


    public PasswordPanel (){

       setLayout(new BorderLayout(0,10));
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
        //northPanel.setBorder(new EmptyBorder(10,0,0,0));
        add(northPanel,BorderLayout.NORTH);


        /*
        * PANEL PRINCIPAL CENTRO - MENÚ
        * */
        centerPanel = new JPanel(new BorderLayout(0,20));
            menuPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,20,0));

            // Menú longitud
                    lengthPanel = new JPanel();
                        length = new JLabel("Introduzca la longitud deseada: ");
                        length.setFont(new Font("Arial", Font.PLAIN,16));
                        number = new JTextField(3);
                        number.setFont(new Font("Arial", Font.PLAIN,16));
                        number.setPreferredSize(new Dimension(50,25));
                        number.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
                    lengthPanel.add(length);
                    lengthPanel.add(number);
                    lengthPanel.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));

            // Botón [GENERAR]
                generatePanel = new JPanel();
                    genPasswordButton = new JButton("GENERAR");
                    genPasswordButton.setFont(new Font("Arial", Font.BOLD,16));
                    genPasswordButton.setForeground(Color.WHITE);
                    genPasswordButton.setBackground(new Color(125,0,50));
                    genPasswordButton.setPreferredSize(new Dimension(120,50));
                generatePanel.add(genPasswordButton);

            menuPanel.add(lengthPanel);
            menuPanel.add(generatePanel);

            // Campo contraseña
                showPassword = new JTextField();
                showPassword.setEditable(false);
                showPassword.setFont(new Font("Arial", Font.BOLD, 28));
                showPassword.setHorizontalAlignment(JTextField.CENTER);
                showPassword.setBorder(BorderFactory.createLineBorder(new Color(125,0,50),1,true));
                showPassword.setBackground(new Color(250,250,250));
                showCopyPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,20,0));


            // Botón [MOSTRAR]
            showPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                showHiddenPasswordButton = new JButton("MOSTRAR");
                showHiddenPasswordButton.setBackground(new Color(125,0,50));
                showHiddenPasswordButton.setForeground(Color.WHITE);
                showHiddenPasswordButton.setFont(new Font("Arial", Font.BOLD,16));
                showHiddenPasswordButton.setPreferredSize(new Dimension(125,50));
                //showPanel.setBorder(new EmptyBorder(20,0,0,0));
            showPanel.add(showHiddenPasswordButton);

            // Botón [COPIAR]
            copyPasswordPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            copyPasswordButton = new JButton("COPIAR");
            copyPasswordButton.setBackground(new Color(125,0,50));
            copyPasswordButton.setForeground(Color.WHITE);
            copyPasswordButton.setFont(new Font("Arial", Font.BOLD,16));
            copyPasswordButton.setPreferredSize(new Dimension(125,50));
            copyPasswordPanel.add(copyPasswordButton);
            showCopyPanel.add(showPanel);
            showCopyPanel.add(copyPasswordPanel);


        centerPanel.add(menuPanel,BorderLayout.NORTH);
        centerPanel.add(showPassword,BorderLayout.CENTER);
        centerPanel.add(showCopyPanel,BorderLayout.SOUTH);

       add(centerPanel,BorderLayout.CENTER);


       /**
       * PANEL PRINCIPAL SUR - COPYRIGHT
       */
       southPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
       copyright = new JLabel("© Andie Mørke");
       copyright.setFont(new Font("Serif", Font.PLAIN,14));
       southPanel.add(copyright);
       add(southPanel,BorderLayout.SOUTH);
    }

    // GETTERS
    public JTextField getNumber() {
        return this.number;
    }
    public JButton getGenPassword() {
        return this.genPasswordButton;
    }
    public JTextField getShowPassword() {
        return this.showPassword;
    }
    public JButton getShowHiddenPasswordButton() {
        return this.showHiddenPasswordButton;
    }
}

