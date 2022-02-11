package myProject;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class is used for take the set of words that are used for the develompment of the game
 * @autor
 * @version v.1.0.0 date:08/02/2022
 */
public class Diccionario{

    private ArrayList<String> diccionario = new ArrayList<String>();

    public Diccionario() {
        FileManager fileManagerDic = new FileManager();
        diccionario = fileManagerDic.lecturaFileDiccionario();
    }

    public String getPalabra() {
        Random aleatorio = new Random();

        return diccionario.get(aleatorio.nextInt(diccionario.size()));
    }
}
