/**
 * UNIVERSIDAD DE SAN CARLOS DE GUATEMALA
 * FACULTAD DE INGENIERIA
 * ESCUELA DE CIENCIAS Y SISTEMAS
 * COMPILADORES 1
 * PROYECTO 1
 * Creado el 16 de septiembre 2011, 2:53PM
 */
package fileops;

import java.io.*;
import javax.swing.*;

/*
 * Se ocupa de operaciones de escritura y lectura de ficheros
 * @(#)FileRW.java
 * Proyecto1_200819312 application
 * @author David Y. Gonzalez
 */
public class FileRW {
    /**
     * Carga el contenido del fichero al JTextPane indicado.
     *
     * @param fn Directorio y nombre completo del fichero a abrir
     * @param pane Instancia del JTextPane unico en el programa
     **/
    public static void read(String fn, JTextArea pane) {
        try (FileReader fr = new FileReader(fn)) {
            pane.read(fr, null);
        } catch (IOException e) {
            System.err.println(e);
        }
    }
    /**
     * Escribe el texto al fichero indicado
     * @param text Contenido del fichero
     * @param file Ubicacion y nombre del fichero
     **/
    public static boolean write(String text, File file) {
        boolean b = true;
        try (FileWriter fw = new FileWriter(file)){
            fw.write(text);
        } catch (IOException e) {
            System.err.println("Error al intentar Escribir");
            b = false;
        }
        return b;
    }
    /**
     * Abre un fichero de cualquir indole con la aplicacion asociada al fichero
     * @param f Es la ruta y nombre del fichero, puede ser relativo o absoluta
     **/
    public static void openGeneral(String f){
        try {
            //Estas dos lineas son lo que hacen el trabajo de abrir el fichero
            File archivo = new File(f);
            java.awt.Desktop.getDesktop().open(archivo);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "NO se pudo abrir el documento: \n\""+f+"\"", "Error", JOptionPane.ERROR_MESSAGE);
            //e.printStackTrace();
        } catch(Exception e){
            
        }
    }
}
