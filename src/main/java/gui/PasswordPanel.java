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

       setLayout(new BorderLayout(20,10));
       setBorder(new EmptyBorder(10, 20, 10, 20)); // top, left, bottom, right
       setBackground(new Color(255,218,185));

        // PANEL PRINCIPAL NORTE - TÍTULO
        northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        label = new JLabel("CONTRASEÑA SEGURA");
        label.setFont(new Font("Arial", Font.BOLD,26));
        northPanel.add(label);
        northPanel.setBackground(new Color(255,218,185));
        add(northPanel,BorderLayout.NORTH);

        // PANEL PRINCIPAL CENTRO - MENÚ
        centerPanel = new JPanel(new BorderLayout());
            menuPanel = new JPanel(new GridLayout(2,1));
                    lengthPanel = new JPanel(new FlowLayout());
                        length = new JLabel("Longitud deseada: ");
                        length.setFont(new Font("Arial", Font.PLAIN,16));
                        number = new JTextField(3);
                        number.setFont(new Font("Arial", Font.PLAIN,20));
                        number.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
                    lengthPanel.add(length);
                    lengthPanel.add(number);
                    lengthPanel.setBackground(new Color(255,218,185));
                generatePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                    genPasswordButton = new JButton("GENERAR");
                    genPasswordButton.setFont(new Font("Arial", Font.BOLD,16));
                    genPasswordButton.setBackground(new Color(200,200,200));
                generatePanel.setBorder(new EmptyBorder(0, 0, 20, 0));
                generatePanel.setBackground(new Color(255,218,185));
                generatePanel.add(genPasswordButton);
            menuPanel.add(lengthPanel);
            menuPanel.add(generatePanel);


                showPassword = new JPasswordField();
                showPassword.setEditable(false);
                showPassword.setFont(new Font("Arial", Font.BOLD, 28));
                showPassword.setHorizontalAlignment(JTextField.CENTER);
                //showPassword.setBorder(new EmptyBorder(20,10,10,10));
                showPassword.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
                showPassword.setBackground(new Color(250,250,250));
            showPanel = new JPanel();
                showHiddenPasswordButton = new JButton("Mostrar");
                showHiddenPasswordButton.setFont(new Font("Arial", Font.BOLD,16));
                showHiddenPasswordButton.setBackground(new Color(200,200,200));
                showPanel.setBorder(new EmptyBorder(20,0,0,0));
            showPanel.setBackground(new Color(255,218,185));
            showPanel.add(showHiddenPasswordButton);

        centerPanel.setBorder(new EmptyBorder(10,0,10,0));
        centerPanel.add(menuPanel,BorderLayout.NORTH);
        centerPanel.add(showPassword,BorderLayout.CENTER);
        centerPanel.add(showPanel,BorderLayout.SOUTH);
        centerPanel.setBackground(new Color(255,218,185));

       add(centerPanel,BorderLayout.CENTER);



       // PANEL SUR - COPYRIGHT
       southPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
       copyright = new JLabel("© Andie Mørke");
       copyright.setFont(new Font("Serif", Font.PLAIN,14));
       southPanel.setBackground(new Color(255,218,185));
       southPanel.add(copyright);
       add(southPanel,BorderLayout.SOUTH);


    }

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

