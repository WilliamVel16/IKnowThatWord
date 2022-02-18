package myProject;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;
import static java.lang.String.valueOf;

/**
 * This class is used for check inside a .txt file if the user has already played before or not, also
 * to add the new players to the .txt file.
 * @autor william velasco - 2042577 william.velasco@correounivalle.edu.co
 * @version v.1.0.0 date:08/02/2022
 */
public class JugadoresGuardados {
    public static final String PATHJUGADORES="src/myProject/files/jugadoresGuardados.txt";
    private ArrayList <String> jugadoresGuardados = new ArrayList<>();
    private String nombreJugador = "";
    private int nivel=1;
    String nombreIngresadoAlInicio = "";
    String verificarCaracteres = new String();

    public  JugadoresGuardados(){
    }

    public Boolean getSiJugo(String nombreJugador){
        FileManager MyManager = FileManager.getInstance();
        HashMap<String, Integer> Players = new HashMap<>();
        Players = MyManager.getPlayers();
        if (Players.get(nombreJugador) != null) {
            this.nivel = Players.get(nombreJugador);
            return true;
        } else {

            return false;
        }

    }

    /**
     * Pide datos al usuario para iniciar el juego
     */
    public void pedirDatos(){
        nombreIngresadoAlInicio = JOptionPane.showInputDialog("Ingrese su nombre: ");
    }

    /**
     * Retorna el nombre del jugador actual
     */
    public String getNombre(){
        nombreJugador = nombreIngresadoAlInicio;
        return nombreJugador;
    }

    /**
     * Actualiza el nivel del juego para la siguiente ronda
     */
    public void setNivel(int nivel){
        this.nivel = 1;
    }

    /**
     * Retorna un entero que simboliza el nivel actual del juego
     */
    public int getNivel(){
        return nivel;
    }


}
