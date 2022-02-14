package myProject;

import java.io.*;
import java.io.BufferedReader;
import java.util.ArrayList;

/**
 * This class is used for reading and writing of the avalaible words that are inside the .txt file that
 * are saved in an ArrayList to take random words from this.
 * @autor
 * @version v.1.0.0 date:08/02/2022
 */
public class FileManager {
    public static final String PATHDICCIONARIO = "src/myProject/files/diccionario.txt";
    private FileReader fileReader;
    private BufferedReader input;
    private FileWriter fileWriter;
    private BufferedWriter output;

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

