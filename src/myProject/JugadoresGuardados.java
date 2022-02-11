package myProject;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is used for check inside a .txt file if the user has already played before or not, also
 * to add the new players to the .txt file.
 * @autor
 * @version v.1.0.0 date:08/02/2022
 */
public class JugadoresGuardados {

    private String nombreJugador;
    private ArrayList<String> jugadoresGuardados = new ArrayList<String>();

    public  JugadoresGuardados(){
        FileManager fileManagerJug = new FileManager();
        jugadoresGuardados = fileManagerJug.lecturaFileJugadores();
    }

    public Boolean getSiJugo(Object nombreJugador){
        boolean jugadorExiste = jugadoresGuardados.contains(nombreJugador);
        return jugadorExiste;
    }
}
