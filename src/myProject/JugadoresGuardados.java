package myProject;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.String.valueOf;

/**
 * This class is used for check inside a .txt file if the user has already played before or not, also
 * to add the new players to the .txt file.
 * @autor
 * @version v.1.0.0 date:08/02/2022
 */
public class JugadoresGuardados {

    private FileWriter guardarUsuario;
    private BufferedWriter guardarEnArchivo;
    public static final String PATHJUGADORES="src/myProject/files/jugadoresGuardados.txt";
    private String nombreJugador;
    private int nivel =1;
    private ArrayList <String> jugadoresGuardados = new ArrayList<>();
    String nombreIngresadoAlInicio = "";
    String verificarCaracteres = new String();

    public  JugadoresGuardados(){
        FileManager fileManagerJug = new FileManager();
        //jugadoresGuardados = fileManagerJug.lecturaFileJugadores();
    }

    public Boolean getSiJugo(String nombreJugador){
        //String auxiliar = valueOf(nombreJugador);
       // String auxiliarParaLeer = auxiliar.substring(0,auxiliar.length());
        boolean existenciaJugador = jugadoresGuardados.contains(nombreJugador);
        return existenciaJugador;
    }

    /*public Boolean getSiJugo(){
        for(int i=0; i<jugadoresGuardados.size(); i++) {
            for (int j = 0; j < jugadoresGuardados.get(i).length() - 1; j++) {
                verificarCaracteres += jugadoresGuardados.get(i).charAt(j);
            }
            if (Objects.equals(nombreIngresadoAlInicio, verificarCaracteres)) {
                nivel = Character.getNumericValue(jugadoresGuardados.get(i).charAt(jugadoresGuardados.get(i).length()-1));
                return true;
            }
        }
        return false;
    }*/

    public void pedirDatos(){
        try {
            nombreIngresadoAlInicio = JOptionPane.showInputDialog("Ingrese su nombre: ");
            guardarUsuario = new FileWriter(PATHJUGADORES, true);
            guardarEnArchivo = new BufferedWriter(guardarUsuario);
            guardarEnArchivo.write(nombreIngresadoAlInicio);
            guardarEnArchivo.newLine();
            JOptionPane.showMessageDialog(null,"Nombre guardado.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                guardarEnArchivo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getNombre(){
        nombreJugador = nombreIngresadoAlInicio;
        return nombreJugador;
    }

    public void setNivel(int nivel){
        this.nivel = 1;
    }

    public int getNivel(){
        return nivel;
    }


}
