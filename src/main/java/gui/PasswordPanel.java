package gui;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PasswordPanel extends JPanel {


    private final JTextField LENGTH_FIELD,PASSWORD_FIELD;
    private final JSlider LENGTH_SLIDER;
    private final JButton GENERATE_BUTTON,SHOW_BUTTON,COPY_BUTTON;

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
            JPanel menuPanel = new JPanel();
                menuPanel.setLayout(new BoxLayout(menuPanel,BoxLayout.Y_AXIS));

                    // PANEL LONGITUD
                    JPanel lengthPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,5,0));
                    lengthPanel.setBorder(new EmptyBorder(10,0,0,0));
                        // Label LONGITUD
                        JLabel length = new JLabel("Elija la longitud deseada: ");
                            length.setFont(new Font("Arial", Font.PLAIN,16));
                        // Field LONGITUD
                        LENGTH_FIELD = new JTextField(2);
                            LENGTH_FIELD.setText("12");
                            LENGTH_FIELD.setFont(new Font("Arial", Font.PLAIN,16));
                            LENGTH_FIELD.setEditable(false);
                            LENGTH_FIELD.setFocusable(false);
                            LENGTH_FIELD.setCursor(null);
                            LENGTH_FIELD.getCaret().setBlinkRate(0);
                            LENGTH_FIELD.getCaret().setVisible(false);
                            LENGTH_FIELD.setPreferredSize(new Dimension(50,25));
                            LENGTH_FIELD.setBorder(BorderFactory.createCompoundBorder(
                                            BorderFactory.createLineBorder(Color.LIGHT_GRAY), 
                                            BorderFactory.createEmptyBorder(0, 5, 0, 0)));
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
                    GENERATE_BUTTON = new JButton("GENERAR");
                    GENERATE_BUTTON.setFont(new Font("Arial", Font.BOLD,16));
                    GENERATE_BUTTON.setForeground(Color.WHITE);
                    GENERATE_BUTTON.setBackground(new Color(102,0,51));
                    GENERATE_BUTTON.setPreferredSize(new Dimension(120,50));
                generatePanel.setBorder(new EmptyBorder(20, 0, 0, 0)); // 10 píxeles arriba
                generatePanel.add(GENERATE_BUTTON);

            menuPanel.add(lengthPanel);
            menuPanel.add(generatePanel);

            // Campo contraseña
                PASSWORD_FIELD = new JTextField();
                PASSWORD_FIELD.setEditable(false);
                PASSWORD_FIELD.setFont(new Font("Monospaced", Font.PLAIN, 32));
                PASSWORD_FIELD.setHorizontalAlignment(JTextField.CENTER);
                PASSWORD_FIELD.setBorder(BorderFactory.createLineBorder(new Color(102,0,51),1,true));
                PASSWORD_FIELD.setBackground(new Color(250,250,250));




            // Botones [MOSTRAR] y [COPIAR]
        JPanel showCopyPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,20,0));
            JPanel showPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                SHOW_BUTTON = new JButton("MOSTRAR");
                SHOW_BUTTON.setBackground(new Color(102,0,51));
                SHOW_BUTTON.setForeground(Color.WHITE);
                SHOW_BUTTON.setFont(new Font("Arial", Font.BOLD,16));
                SHOW_BUTTON.setPreferredSize(new Dimension(125,50));
            showPanel.add(SHOW_BUTTON);
        showCopyPanel.add(showPanel);

            // Botón [COPIAR]
            JPanel copyPasswordPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            COPY_BUTTON = new JButton("COPIAR");
            COPY_BUTTON.setBackground(new Color(102,0,51));
            COPY_BUTTON.setForeground(Color.WHITE);
            COPY_BUTTON.setFont(new Font("Arial", Font.BOLD,16));
            COPY_BUTTON.setPreferredSize(new Dimension(125,50));
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
       JLabel copyright = new JLabel("© Andie Mørke");
       copyright.setFont(new Font("Serif", Font.PLAIN,14));
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

