package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * This class is used for design the interface, with their respective listeners and orders that arise from these.
 * @autor Paola-J Rodriguez-C paola.rodriguez@correounivalle.edu.co
 * @version v.1.0.0 date:08/02/2022
 */
public class GUI extends JFrame {

    public static final String MENSAJE_AYUDA=
            "Cuando pulses el botón Jugar se te presentará una secuencia de\n palabras, una detrás de otra. " +
            "¡Memorizalas todas!\n\n" +
            "Después de la serie de las palabras a memorizar, el juego\n" +
            "te presentará un listado con el doble de palabras.\n" +
            "Si la palabra hace parte del listado que has memorizado, pulsa\n" +
            "el botón 'Sí', de lo contrario pulsa el botón 'No'.\n\n";

    private Header headerProject;
    private JTextArea areaTexto;
    private FileManager fileManager;
    private Escucha escucha;
    private JButton opcionNo, opcionSi, jugar, ayuda, salir, mostrarNiveles;
    private JLabel nivelUsuario;
    private JPanel panelPalabras, panelPuntajeUsuario, panelNivelUsuario;

    JugadoresGuardados jugadoresGuardados = new JugadoresGuardados();
    ControlThatWord controlThatWord = new ControlThatWord();

    /**
     * Listas receptoras
     */
    ArrayList<String>palabrasAdivinar;
    ArrayList<String>palabrasTotal;

    /**
     * Panel principal
     */
    static GUI miProjectGUI;

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
        this.nivelUsuario = new JLabel();

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

        mostrarNiveles = new JButton("Ver niveles");
        mostrarNiveles.setFont(new Font("Monospaced",Font.BOLD,13));
        mostrarNiveles.addActionListener(escucha);
        constraints.gridx = 1;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(mostrarNiveles, constraints);

        jugar = new JButton("  Jugar  ");
        jugar.setFont(new Font("Monospaced",Font.BOLD,13));
        jugar.addActionListener(escucha);
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
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

        panelPalabras.setFocusable(true);
        panelPalabras.requestFocusInWindow();

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

    //Getters and Setters -> solo utilizo getters
    public JPanel getPanelPalabras() {
        return panelPalabras;
    }

    public JPanel getPanelPuntajeUsuario() {
        return panelPuntajeUsuario;
    }


    public JPanel getPanelNivelUsuario() {
        return panelNivelUsuario;
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
    private class Escucha implements ActionListener {
        String palabraActual = "";

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == ayuda) {
                JOptionPane.showMessageDialog(null, MENSAJE_AYUDA);
            } else {
                if (e.getSource() == jugar) {
                    ayuda.setVisible(false);
                    jugar.setVisible(false);
                    mostrarNiveles.setVisible(false);

                    jugadoresGuardados.pedirDatos(); //pedir datos
                    int nivel = 1; //nivel por defecto

                    //verificar usuario
                    if(jugadoresGuardados.getSiJugo(jugadoresGuardados.getNombre())){
                        nivel = jugadoresGuardados.getNivel();
                    }

                    nivelUsuario.setText(String.valueOf(nivel));
                    panelNivelUsuario.add(nivelUsuario);

                    if (jugadoresGuardados.getNivel() != 0) { //si ya jugó -> dar su nivel
                        JOptionPane.showMessageDialog(null, "Usuario encontrado: " + jugadoresGuardados.getNombre() + ", Nivel a jugar: " + jugadoresGuardados.getNivel());
                        switch (nivel) {
                            case 1:
                                palabrasAdivinar = controlThatWord.mostrarPalabras(10);
                                JOptionPane.showMessageDialog(null, "Demuestra qué palabras recuerdas");
                                opcionNo.setVisible(true);
                                opcionSi.setVisible(true);
                                palabrasTotal = controlThatWord.mostrarEvaluacion(20);
                                for (String s : palabrasTotal) {
                                    JLabel labelPalabra = new JLabel(s);
                                    panelPalabras.removeAll();
                                    panelPalabras.add(labelPalabra);
                                    System.out.println("GUI:" + s);
                                    //Espere 7 segundos Timer
                                    palabraActual = s;
                                }
                                //controlThatWord.calificarEvaluacion(14);
                                break;
                            case 2:
                                controlThatWord.mostrarPalabras(20);
                                JOptionPane.showMessageDialog(null, "Demuestra qué palabras recuerdas");
                                opcionNo.setVisible(true);
                                opcionSi.setVisible(true);
                                controlThatWord.mostrarEvaluacion(40);
                                controlThatWord.calificarEvaluacion(28);
                                break;
                            case 3:
                                controlThatWord.mostrarPalabras(25);
                                JOptionPane.showMessageDialog(null, "Demuestra qué palabras recuerdas");
                                opcionNo.setVisible(true);
                                opcionSi.setVisible(true);
                                controlThatWord.mostrarEvaluacion(50);
                                controlThatWord.calificarEvaluacion(35);
                                break;
                            case 4:
                                controlThatWord.mostrarPalabras(30);
                                JOptionPane.showMessageDialog(null, "Demuestra qué palabras recuerdas");
                                opcionNo.setVisible(true);
                                opcionSi.setVisible(true);
                                controlThatWord.mostrarEvaluacion(60);
                                controlThatWord.calificarEvaluacion(48);
                                break;
                            case 5:
                                controlThatWord.mostrarPalabras(35);
                                JOptionPane.showMessageDialog(null, "Demuestra qué palabras recuerdas");
                                opcionNo.setVisible(true);
                                opcionSi.setVisible(true);
                                controlThatWord.mostrarEvaluacion(70);
                                controlThatWord.calificarEvaluacion(56);
                                break;
                            case 6:
                                controlThatWord.mostrarPalabras(40);
                                JOptionPane.showMessageDialog(null, "Demuestra qué palabras recuerdas");
                                opcionNo.setVisible(true);
                                opcionSi.setVisible(true);
                                controlThatWord.mostrarEvaluacion(80);
                                controlThatWord.calificarEvaluacion(68);
                                break;
                            case 7:
                                controlThatWord.mostrarPalabras(50);
                                JOptionPane.showMessageDialog(null, "Demuestra qué palabras recuerdas");
                                opcionNo.setVisible(true);
                                opcionSi.setVisible(true);
                                controlThatWord.mostrarEvaluacion(100);
                                controlThatWord.calificarEvaluacion(90);
                                break;
                            case 8:
                                controlThatWord.mostrarPalabras(60);
                                JOptionPane.showMessageDialog(null, "Demuestra qué palabras recuerdas");
                                opcionNo.setVisible(true);
                                opcionSi.setVisible(true);
                                controlThatWord.mostrarEvaluacion(120);
                                controlThatWord.calificarEvaluacion(108);
                                break;
                            case 9:
                                controlThatWord.mostrarPalabras(70);
                                JOptionPane.showMessageDialog(null, "Demuestra qué palabras recuerdas");
                                opcionNo.setVisible(true);
                                opcionSi.setVisible(true);
                                controlThatWord.mostrarEvaluacion(140);
                                controlThatWord.calificarEvaluacion(133);
                                break;
                            case 10:
                                controlThatWord.mostrarPalabras(100);
                                JOptionPane.showMessageDialog(null, "Demuestra qué palabras recuerdas");
                                opcionNo.setVisible(true);
                                opcionSi.setVisible(true);
                                controlThatWord.mostrarEvaluacion(200);
                                controlThatWord.calificarEvaluacion(200);
                                break;
                            default:
                                controlThatWord.mostrarPalabras(100);
                                JOptionPane.showMessageDialog(null, "Demuestra qué palabras recuerdas");
                                opcionNo.setVisible(true);
                                opcionSi.setVisible(true);
                                controlThatWord.mostrarEvaluacion(200);
                                controlThatWord.calificarEvaluacion(200);
                                break;
                        }
                    }/*else{
                            JOptionPane.showMessageDialog(null,"Bienvenido a I know that word");
                            controlThatWord.mostrarPalabras(10);
                            JOptionPane.showMessageDialog(null, "Demuestra qué palabras recuerdas");
                            opcionNo.setVisible(true);
                            opcionSi.setVisible(true);
                            controlThatWord.mostrarEvaluacion(20);
                            controlThatWord.calificarEvaluacion(14);
                        }*/

                } else {
                    if (e.getSource() == salir) {
                        System.exit(0);
                        //guardar el nivel en su respectivo usuario
                    } else {
                        if (e.getSource() == mostrarNiveles) {
                            JOptionPane.showMessageDialog(null, "Nivel   Memorizar   Mostradas   %Aciertos\n" +
                                                                                       " 01             10                    20                  70\n" +
                                                                                       " 02             20                    40                  70\n" +
                                                                                       " 03             25                    50                  75\n" +
                                                                                       " 04             30                    60                  80\n" +
                                                                                       " 05             35                    70                  80\n" +
                                                                                       " 06             40                    80                  85\n" +
                                                                                       " 07             50                    100                90\n" +
                                                                                       " 08             60                    120                90\n" +
                                                                                       " 09             70                    140                95\n" +
                                                                                       " 10            100                   200               100\n");
                        } else {
                            if(e.getSource() == opcionNo){
                                System.out.println(controlThatWord.procesarRespuesta("No", palabraActual));

                            }else{
                                if(e.getSource() == opcionSi){
                                    System.out.println(controlThatWord.procesarRespuesta("Si", palabraActual));
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
