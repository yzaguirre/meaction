/**
 * UNIVERSIDAD DE SAN CARLOS DE GUATEMALA
 * FACULTAD DE INGENIERIA
 * ESCUELA DE CIENCIAS Y SISTEMAS
 * COMPILADORES 1
 * PROYECTO 1
 * Creado el 23 de agosto 2011, 08:28PM
 */
package main;

import javax.swing.SwingUtilities;
import gui.*;

/**
 * Clase principal de la aplicacion
 * @(#)main.java
 * @author David Y. Gonzalez
 */
public class Main implements Runnable {

    @Override
    public void run() {
        new Main_GUI().setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Main());
    }
}
