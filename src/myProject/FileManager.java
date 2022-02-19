package myProject;

import java.io.*;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import javax.sound.sampled.SourceDataLine;

/**
 * This class is used for reading and writing of the avalaible words that are inside the .txt file that
 * are saved in an ArrayList to take random words from this.
 * @autor william velasco - 2042577 william.velasco@correounivalle.edu.co
 * @version v.1.0.0 date:08/02/2022
 */
public class FileManager {
    public static final String PATHDICCIONARIO = "src/myProject/files/diccionario.txt";
    private FileReader fileReader;
    private BufferedReader input;
    private FileWriter fileWriter;
    private BufferedWriter output;

    //Singleton
    private static FileManager instance;
    private FileManager(){
    }

    public static FileManager getInstance(){
        if(instance == null){
            instance = new FileManager();
        }
        return instance;
    }

    public ArrayList<String> lecturaFile() {
        ArrayList<String> palabrasTomadas = new ArrayList<String>();

        try {
            fileReader = new FileReader(PATHDICCIONARIO);
            input = new BufferedReader(fileReader);
            String line = input.readLine();
            while (line != null) {
                palabrasTomadas.add(line);
                line = input.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return palabrasTomadas;
    }

    public HashMap<String, Integer> getPlayers() {
        HashMap<String, Integer> Players = new HashMap<>();
        try {
            fileReader = new FileReader(JugadoresGuardados.PATHJUGADORES);
            input = new BufferedReader(fileReader);
            String line = input.readLine();
            while (line != null) {
                String parts[] = line.split(" ");
                Players.put(parts[0], Integer.parseInt(parts[1]));
                line = input.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return Players;
    }

    public void escribirFile(String line) {
        try {
            fileWriter = new FileWriter(PATHDICCIONARIO, true);
            output = new BufferedWriter(fileWriter);
            output.write(line);
            output.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

