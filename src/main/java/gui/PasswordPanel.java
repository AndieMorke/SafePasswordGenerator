package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PasswordPanel extends JPanel {

    private JLabel length,copyright;
    private JTextField number;
    private JButton genPassword;
    private JTextField showPassword;
    private JPanel lengthPanel,menu,generate,copyrightPanel;

    public PasswordPanel (){

       setLayout(new BorderLayout(10,10));
       setBorder(new EmptyBorder(20, 20, 15, 20)); // top, left, bottom, right

       menu = new JPanel(new GridLayout(2,1));
        lengthPanel = new JPanel(new FlowLayout());
            length = new JLabel("Longitud deseada: ");
            length.setFont(new Font("Serif", Font.ITALIC,22));
            number = new JTextField(5);
            number.setFont(new Font("Serif", Font.PLAIN,22));
        lengthPanel.add(length);
        lengthPanel.add(number);
       menu.add(lengthPanel);
        generate = new JPanel(new FlowLayout(FlowLayout.CENTER));
            genPassword = new JButton("GENERAR");
            genPassword.setFont(new Font("Arial", Font.BOLD,16));
            genPassword.setBackground(new Color(200,200,200));
            generate.setBorder(new EmptyBorder(0, 0, 20, 0));

        generate.add(genPassword);
       menu.add(generate);
       add(menu,BorderLayout.NORTH);
            showPassword = new JTextField();
            showPassword.setEditable(false);
            showPassword.setFont(new Font("Arial", Font.BOLD, 28));
            showPassword.setHorizontalAlignment(JTextField.CENTER);
            showPassword.setBorder(new EmptyBorder(30,0,0,0));
            showPassword.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
       add(showPassword,BorderLayout.CENTER);

       copyrightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
       copyright = new JLabel("© Andie Mørke");
       copyright.setFont(new Font("Serif", Font.PLAIN,14));
       copyrightPanel.add(copyright);
       add(copyrightPanel,BorderLayout.SOUTH);


    }

    public JTextField getNumber() {
        return this.number;
    }

    public JButton getGenPassword() {
        return this.genPassword;
    }

    public JTextField getShowPassword() {
        return this.showPassword;
    }

}

