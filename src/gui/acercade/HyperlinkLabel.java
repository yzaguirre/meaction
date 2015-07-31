/**
 * UNIVERSIDAD DE SAN CARLOS DE GUATEMALA
 * FACULTAD DE INGENIERIA
 * ESCUELA DE CIENCIAS Y SISTEMAS
 * COMPILADORES 1
 * PROYECTO 1
 * Creado el 23 de septiembre 2011, 07:57AM
 */
package gui.acercade;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.*;

/**
 * Hecho para abrir una pagina web en el navegador
 * predeterminado independiente del Sistema Operativo
 * @(#)HyperlinkLabel.java
 * Proyecto1_200819312 application
 * @author David Y. Gonzalez
 */
public class HyperlinkLabel extends HyperlinkView {

    private String url;

    /**
     * Crea la etiqueta hipervinculo con el nombre a
     * a desplegar y la direccion que debe abrir
     * el navegador predeterminado
     * @param nombre Es el nombre a mostrar en el label
     * @param url Es la direccion que abre el navegador
     **/
    public HyperlinkLabel(String nombre, String url) {
        super(nombre, url);
        this.url = url;
        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                abrirEnlace();
            }
        });
    }
    
    /**
     * Realiza la operacion de abrir el enlace suministrado
     * en el constructor
     **/
    public void abrirEnlace() {
        try {
            Desktop.getDesktop().browse(URI.create(url));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
