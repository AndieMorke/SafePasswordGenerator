package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PasswordPanel extends JPanel {

    private JLabel length;
    private JTextField number;
    private JButton genPassword;
    private JTextField showPassword;
    private JPanel lengthPanel,menu,generate;

    public PasswordPanel (){

       setLayout(new BorderLayout(5,5));
       setBorder(new EmptyBorder(20, 20, 20, 20)); // top, left, bottom, right

       menu = new JPanel(new GridLayout(2,1));
        lengthPanel = new JPanel(new FlowLayout());
            length = new JLabel("Longitud deseada: ");
            number = new JTextField(5);
        lengthPanel.add(length);
        lengthPanel.add(number);
       menu.add(lengthPanel);
        generate = new JPanel(new FlowLayout(FlowLayout.CENTER));
            genPassword = new JButton("GENERAR");
        generate.add(genPassword);
       menu.add(generate);
       add(menu,BorderLayout.NORTH);
            showPassword = new JTextField();
            showPassword.setEditable(false);
            showPassword.setFont(new Font("Arial", Font.BOLD, 16));
            showPassword.setHorizontalAlignment(JTextField.CENTER);
       add(showPassword,BorderLayout.CENTER);

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

