package myProject;

import javax.swing.*;
import java.util.ArrayList;

/**
 * This class is used for create the methods that give logic to the game, how, for example, to keep track of
 * errors, also of successes.
 * @autor william velasco - 2042577 william.velasco@correounivalle.edu.co
 * @version v.1.0.0 date:08/02/2022
 */
public class ControlThatWord {
    private Diccionario diccionario;
    private String palabra;
    private int conteoAciertos, nivelActual, nivelPorJugar;
    private boolean existencia, evaluarExistencia;
    private ArrayList<String> palabrasMemorizar = new ArrayList<String>();
    private ArrayList<String> totalPalabras = new ArrayList<String>();

    public ControlThatWord(){
        diccionario = new Diccionario();
    }


    //mostrar las palabras desde palabrasNivelActual según el nivel CON TIMER
    String nuevaPalabra;

    public ArrayList<String> mostrarPalabras(int numeroPalabras){
        for(int i=0; i<numeroPalabras; i++){
            nuevaPalabra = diccionario.getPalabra();
            while(existePalabra(nuevaPalabra,this.palabrasMemorizar)){
                nuevaPalabra = diccionario.getPalabra();
            }
            palabrasMemorizar.add(nuevaPalabra); // agregar la nueva palabra al array indicado
            existencia = palabrasMemorizar.equals(nuevaPalabra);
        }
        return palabrasMemorizar;
    }

    /**
     * Evaluar palabras
     * @param doblePalabras
     */
    public ArrayList<String> mostrarEvaluacion(int doblePalabras){
        this.totalPalabras = new ArrayList<>();
        for(int i=0; i<palabrasMemorizar.size(); i++){ //agrefar palabras mostradas
            totalPalabras.add(palabrasMemorizar.get(i));
        }
        doblePalabras = doblePalabras - palabrasMemorizar.size();
        while(doblePalabras>0){
            nuevaPalabra = diccionario.getPalabra();
            while(existePalabra(nuevaPalabra,this.totalPalabras)){
                nuevaPalabra = diccionario.getPalabra();
            }
            totalPalabras.add(nuevaPalabra); //agregar palabras para mostrar en evalucaion
            doblePalabras--;
        }
        return totalPalabras;
    }

    /**
     * Decide si el usuario gana
     * @param reglaNivel
     */
    public Boolean calificarEvaluacion(int reglaNivel){
        if(conteoAciertos >= reglaNivel){
            JOptionPane.showMessageDialog(null,"Felicidades, pasaste al siguiente nivel!");
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "Tu puntaje no es suficiente para pasar al siguiente nivel\n" +
                                                                      "Revisa la tabla de puntajes e inténtalo de nuevo");
            return false;
        }
    }

    /**
     * Evaluar palabras
     * @param response,palabra
     */
    public boolean procesarRespuesta(String response, String palabra) {
        System.out.println("Palabra:" + palabra + "Response" + response);
        boolean flag = false;
        for (String s : palabrasMemorizar) {
            if (s.equals(palabra)) {
                flag = true;
            }
            if (s.equals(palabra) && response.equals("Si")) {
                return true;
            }
        }
        //La palabra no está
        if (flag == false && response.equals("No")) {
            return true;
        }
        return false;
    }

    /**
     * Evaluar palabras
     * @param palabra,ArrayList
     */
    public boolean existePalabra(String palabra, ArrayList<String> lstAnalizar) {
        for (int i = 0; i < lstAnalizar.size(); i++) {
            if (lstAnalizar.get(i).equals(palabra)) {
                return true;
            }
        }
        return false;
    }

    //actualizar el nivel del juego
    public void actualizarNivel(){

    }

}
