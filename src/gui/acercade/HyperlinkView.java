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
import javax.swing.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.util.*;

/**
 * Hecho para darle "look & feel" a una etiqueta
 * ideado para simular un enlace tipo Hipervinculo
 * @(#)HyperlinkView.java
 * Proyecto1_200819312 application
 * @author David Y. Gonzalez
 */
public class HyperlinkView extends JLabel {

    Cursor cursor;
    private Font boldFont;
    private Font underlineBoldFont;

    /**
     * La etiqueta se crea con el nombre a mostrar y la url
     * que mostrara el ToolTip
     * @param nombre Es el nombre que muestra la etiqueta
     * @param url Es el nombre que muestra el ToolTip
     **/
    public HyperlinkView(String nombre, String url) {
        super(nombre);
        cursor = new Cursor(Cursor.HAND_CURSOR);

        Hashtable<TextAttribute, Object> atributos = new Hashtable<TextAttribute, Object>();
        atributos.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);

        boldFont = getFont();

        underlineBoldFont = boldFont.deriveFont(atributos);
        
        setForeground(Color.BLUE);
        
        setToolTipText("Ir a: " + url);

        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e){
                float[] purpura = Color.RGBtoHSB(128, 0, 128, null);
                HyperlinkView.this.setForeground(Color.getHSBColor(purpura[0], purpura[1], purpura[2]));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                HyperlinkView.this.setCursor(cursor);
                HyperlinkView.this.setFont(underlineBoldFont);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                HyperlinkView.this.setFont(boldFont);
            }
        });
    }

    /**
     * El nombre a desplegar y la direccion a abrir son las mismas
     * @param url Es la direccion deseada
     **/
    public HyperlinkView(String url){
        this(url,url);
    }
}
