package gui;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.*;

public class PasswordPanel extends JPanel {


    private final JTextField LENGTH_FIELD,PASSWORD_FIELD;
    private final JSlider LENGTH_SLIDER;
    private final JButton GENERATE_BUTTON,SHOW_BUTTON,COPY_BUTTON;

    public JButton createButton(String text,Dimension size){
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD,16));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(102,0,51));
        button.setPreferredSize(new Dimension(size));
        return button;
    }

    public JTextField createTextField(String text, int columns, Font font, Dimension size, Color background, Border border) {
        JTextField field = new JTextField(columns);
        if (text != null) field.setText(text);

        field.setFont(font);
        field.setEditable(false);
        field.setFocusable(false);
        field.setCursor(null);
        field.getCaret().setBlinkRate(0);
        field.getCaret().setVisible(false);

        if (size != null) field.setPreferredSize(size);
        if (background != null) field.setBackground(background);
        if (border != null) field.setBorder(border);

        return field;
    }

    public JLabel createLabel(String text,Font font,Color foreground){
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setForeground(foreground);
        return label;
    }

    public PasswordPanel (){

       setLayout(new BorderLayout(0,10));
       setBorder(new EmptyBorder(10, 20, 10, 20));


        /*
         * PANEL PRINCIPAL NORTE - TÍTULO
         * */
            JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JLabel title = createLabel("CONTRASEÑA SEGURA",new Font("Arial", Font.BOLD,26),new Color(102,0,51));
            northPanel.add(title);
        add(northPanel,BorderLayout.NORTH);


        /*
        * PANEL PRINCIPAL CENTRO - MENÚ
        * */
        JPanel centerPanel = new JPanel(new BorderLayout(0,20));
            JPanel menuPanel = new JPanel();
                menuPanel.setLayout(new BoxLayout(menuPanel,BoxLayout.Y_AXIS));

                    // PANEL LONGITUD
                    JPanel lengthPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,5,0));
                    lengthPanel.setBorder(new EmptyBorder(10,0,0,0));
                        // Label LONGITUD
                        JLabel length = new JLabel("Elija la longitud deseada: ");
                            length.setFont(new Font("Arial", Font.PLAIN,16));
                            length.setForeground(Color.DARK_GRAY);
                        // Field LONGITUD
        LENGTH_FIELD = createTextField("12", 2, new Font("Arial", Font.PLAIN, 16), new Dimension(50,25), Color.WHITE, BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1,true), BorderFactory.createEmptyBorder(0,5,0,0)));
        LENGTH_FIELD.setForeground(Color.DARK_GRAY);
                        // Slider LONGITUD
                        LENGTH_SLIDER = new JSlider(6,30,12);
                            LENGTH_SLIDER.setBackground(new Color(102,0,51));
                            LENGTH_SLIDER.setForeground(new Color(102,0,51));
                            LENGTH_SLIDER.setPaintTrack(true);

                    // Añadir componentes al PANEL LONGITUD
                    lengthPanel.add(length);
                    lengthPanel.add(LENGTH_FIELD);
                    lengthPanel.add(LENGTH_SLIDER);

            // Botón [GENERAR]
                JPanel generatePanel = new JPanel();
                GENERATE_BUTTON = createButton("GENERAR",new Dimension(120,50));
                generatePanel.setBorder(new EmptyBorder(20, 0, 0, 0));
                generatePanel.add(GENERATE_BUTTON);

            menuPanel.add(lengthPanel);
            menuPanel.add(generatePanel);

            // Campo contraseña
        PASSWORD_FIELD = createTextField("", 0, new Font("Monospaced", Font.PLAIN, 28), new Dimension(400,50), new Color(250,250,250), BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true));
        PASSWORD_FIELD.setForeground(Color.DARK_GRAY);
        PASSWORD_FIELD.setHorizontalAlignment(JTextField.CENTER);





        // Botones [MOSTRAR] y [COPIAR]
        JPanel showCopyPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,20,0));
            JPanel showPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                SHOW_BUTTON = createButton("MOSTRAR",new Dimension(120,50));
            showPanel.add(SHOW_BUTTON);
        showCopyPanel.add(showPanel);

            // Botón [COPIAR]
            JPanel copyPasswordPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                COPY_BUTTON = createButton("COPIAR",new Dimension(120,50));
            copyPasswordPanel.add(COPY_BUTTON);
        showCopyPanel.add(copyPasswordPanel);


        centerPanel.add(menuPanel,BorderLayout.NORTH);
        centerPanel.add(PASSWORD_FIELD,BorderLayout.CENTER);
        centerPanel.add(showCopyPanel,BorderLayout.SOUTH);

       add(centerPanel,BorderLayout.CENTER);


       /**
       * PANEL PRINCIPAL SUR - COPYRIGHT
       */
       JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
       JLabel copyright = createLabel("© Andie Mørke",new Font("Serif", Font.PLAIN,14), Color.DARK_GRAY);
       southPanel.add(copyright);
       add(southPanel,BorderLayout.SOUTH);
    }

    // GETTERS
    public JTextField getLengthField() {
        return this.LENGTH_FIELD;
    }
    public JButton getGenerateButton() {
        return this.GENERATE_BUTTON;
    }
    public JTextField getPasswordField() {
        return this.PASSWORD_FIELD;
    }
    public JButton getShowButton() {
        return this.SHOW_BUTTON;
    }
    public JButton getCopyButton() {
        return this.COPY_BUTTON;
    }

    public JSlider getLengthSlider() {
        return this.LENGTH_SLIDER;
    }
}

