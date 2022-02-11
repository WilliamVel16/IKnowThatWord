package myProject;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is used for design the interface, with their respective listeners and orders that arise from these.
 * @autor Paola-J Rodriguez-C paola.rodriguez@correounivalle.edu.co
 * @version v.1.0.0 date:08/02/2022
 */
public class GUI extends JFrame {

    public static final String MENSAJE_AYUDA=
            "Se te presentará una secuencia de palabras, una detrás de otra.\n" +
            "¡Memorizalas todas!\n\n" +
            "Después de la serie de las palabras a memorizar, el juego\n" +
            "te presentará un listado con el doble de palabras.\n" +
            "Si la palabra hace parte del listado que has memorizado, pulsa\n" +
            "el botón 'Sí', de lo contrario pulsa el botón 'No'.\n\n" +
            "Juguemos!\n";

    private Header headerProject;
    private JTextArea areaTexto;
    private FileManager fileManager;
    private Escucha escucha;
    private JButton opcionNo, opcionSi, jugar, ayuda, salir;
    private JPanel panelPalabras, panelPuntajeUsuario, panelNivelUsuario;

    /**
     * Constructor of GUI class
     */
    public GUI(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("I Know that word");
        //this.setSize(600,600);
        this.setUndecorated(true);
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {
        //Set up JFrame Container's Layout
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        //Create Listener Object and Control Object
        escucha = new Escucha();


        //Set up JComponents
        headerProject = new Header("I know that word", Color.BLACK);
        headerProject.setFont(new Font("Monospaced",Font.BOLD,20));
        headerProject.setBackground(Color.YELLOW);
        headerProject.setForeground(Color.BLACK);
        headerProject.setBorder(BorderFactory.createEtchedBorder(Color.YELLOW,Color.BLACK));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(headerProject,constraints);

        opcionNo = new JButton("No");
        opcionNo.setFont(new Font("Monospaced",Font.BOLD,13));
        opcionNo.addActionListener(escucha);
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_END;
        this.add(opcionNo, constraints);
        opcionNo.setVisible(false);

        opcionSi = new JButton("Sí");
        opcionSi.setFont(new Font("Monospaced",Font.BOLD,13));
        opcionSi.addActionListener(escucha);
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_START;
        this.add(opcionSi, constraints);
        opcionSi.setVisible(false);

        ayuda = new JButton("Cómo jugar");
        ayuda.setFont(new Font("Monospaced",Font.BOLD,13));
        ayuda.addActionListener(escucha);
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(ayuda, constraints);

        jugar = new JButton("   Jugar   ");
        jugar.setFont(new Font("Monospaced",Font.BOLD,13));
        jugar.addActionListener(escucha);
        constraints.gridx = 1;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(jugar, constraints);

        salir = new JButton("Exit");
        salir.setFont(new Font("Monospaced",Font.BOLD,13));
        salir.addActionListener(escucha);
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_END;
        this.add(salir, constraints);


        panelPalabras = new JPanel();
        panelPalabras.setPreferredSize((new Dimension(400,150)));
        panelPalabras.setBorder(BorderFactory.createTitledBorder("Palabras"));
        panelPalabras.setBorder(BorderFactory.createEtchedBorder(Color.YELLOW,Color.BLACK));
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(panelPalabras, constraints);
        panelPalabras.setBackground(new Color(255,255,255,0));

        //panelPalabras.add(palabras que salen del .txt);

        panelPuntajeUsuario = new JPanel();
        panelPuntajeUsuario.setPreferredSize((new Dimension(200,50)));
        panelPuntajeUsuario.setBackground(new Color(255,255,255,0));
        panelPuntajeUsuario.setBorder(BorderFactory.createTitledBorder("Tu puntaje"));
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(panelPuntajeUsuario, constraints);

        panelNivelUsuario = new JPanel();
        panelNivelUsuario.setPreferredSize((new Dimension(200,50)));
        panelNivelUsuario.setBackground(new Color(255,255,255,0));
        panelNivelUsuario.setBorder(BorderFactory.createTitledBorder("Nivel"));
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(panelNivelUsuario, constraints);
    }

    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUI miProjectGUI = new GUI();
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha implements ActionListener{

        JugadoresGuardados jugadoresGuardados = new JugadoresGuardados();

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == ayuda){
                JOptionPane.showMessageDialog(null, MENSAJE_AYUDA);
            }else{
                if(e.getSource() == jugar){
                    ayuda.setVisible(false);
                    jugar.setVisible(false);
                    opcionNo.setVisible(true);
                    opcionSi.setVisible(true);

                    //pedir datos a usuario
                    String nombreJugador = JOptionPane.showInputDialog("Ingrese su nombre: ");

                    //Verificar usuario, si es nuevo -> nivel 1
                    //                   si ya jugó -> dar su nivel

                    //una vez verificado, tomar las palabras respectivas del nivel, de diccionario.txt

                    //llamar métodos según la demanda del programa

                }else {
                    if (e.getSource() == salir) {
                        System.exit(0);
                    }
                }
            }
        }
    }
}
