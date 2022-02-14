package myProject;

import javax.swing.*;
import java.util.ArrayList;

/**
 * This class is used for create the methods that give logic to the game, how, for example, to keep track of
 * errors, also of successes.
 * @autor
 * @version v.1.0.0 date:08/02/2022
 */
public class ControlThatWord {
    private Diccionario diccionario;
    private String nuevaPalabra, palabra;
    private int conteoErrores, conteoAciertos, nivelActual, nivelPorJugar;
    private boolean existencia, fallo, ganar, isGanador;
    private ArrayList<String> palabrasMemorizar = new ArrayList<String>();
    private ArrayList<String> totalPalabras = new ArrayList<String>();

    public ControlThatWord(){
        diccionario = new Diccionario();
    }

    //mostrar las palabras desde palabrasNivelActual según el nivel CON TIMER
    public void mostrarPalabras(int numeroPalabras){
        for(int i=0; i<numeroPalabras; i++){
            nuevaPalabra = diccionario.getPalabra();
            palabrasMemorizar.add(nuevaPalabra); // agregar la nueva palabra al array indicado
            existencia = palabrasMemorizar.equals(nuevaPalabra);
            if(existencia == true){
                nuevaPalabra = diccionario.getPalabra();
            }else{
                //mostrar palabra 5 segundos
            }
        }
    }

    //Mostrar palabras para que el usuario responda sí o no CON TIMER
    public void mostrarEvaluacion(int doblePalabras){
        int contador=0, puntaje=0;
        //String palabra;
        boolean evaluarExistencia;
        for(int i=0; i<palabrasMemorizar.size(); i++){
            String estaPalabra = palabrasMemorizar.get(i);
            totalPalabras.add(estaPalabra);
        }

        /*do{
            //sacarPalabra de totalPalabras y mostrarla 7 seg
            palabra = ""; // con random guardar la palabra sacada en esta variable
            evaluarExistencia = totalPalabras.equals(palabra);
            if(SI && evaluarExistencia){
                conteoAciertos++;
                totalPalabras.remove(palabra); //borrar la palabra del array totalPalabas
                //opcionNo.setEnable(false);
                //opcionSi.setEnable(false);
            }else{
                if(SI && !evaluarExistencia){
                    conteoErrores++;
                    totalPalabras.remove(palabra);
                    //opcionNo.setEnable(false);
                    //opcionSi.setEnable(false);
                }else{
                    if(NO && evaluarExistencia){
                        conteoErrores++;
                        totalPalabras.remove(palabra);
                        //opcionNo.setEnable(false);
                        //opcionSi.setEnable(false);
                    }else{
                        if(NO && !evaluarExistencia){
                            conteoAciertos++;
                            totalPalabras.remove(palabra);
                            //opcionNo.setEnable(false);
                            //opcionSi.setEnable(false);
                        }else{
                            conteoErrores++;
                            totalPalabras.remove(palabra);
                        }
                    }
                }
            }
        }while(contador<doblePalabras);*/
    }

    //verificar el puntaje para pasar o no al siguiente nivel o se repite el mismo nivel
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

    //actualizar el nivel del juego
    public void actualizarNivel(){

    }

}
