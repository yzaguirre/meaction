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
import java.awt.image.BufferedImage;
import java.net.*;
import java.io.*;
import javax.imageio.*;

/**
 * Dibuja el logo de la aplicacion
 * @(#)PanelLogo.java
 * Proyecto1_200819312 application
 * @author David Y. Gonzalez
 */
public class PanelLogo extends JPanel {

    BufferedImage bi;
    int x, y;

    public PanelLogo(String dir, int sqrSize) {
        super();
        this.setSize(sqrSize, sqrSize);
        URL url = null;
        try {
            url = getClass().getClassLoader().getResource(dir);
            System.out.println(url.toString());
            bi = ImageIO.read(url);
            x = bi.getWidth();
            y = bi.getHeight();
            int lado = Math.max(x, y);
            double escala = sqrSize / (double) lado;
            x = (int) (escala * (double) x);
            y = (int) (escala * (double) y);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("No se pudo cargar la imagen");
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (bi != null) {
            g.drawImage(bi, 0, 0, this.getWidth(), this.getHeight(), null);
        }
    }
}
