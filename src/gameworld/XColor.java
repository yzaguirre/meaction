/**
 * UNIVERSIDAD DE SAN CARLOS DE GUATEMALA
 * FACULTAD DE INGENIERIA
 * ESCUELA DE CIENCIAS Y SISTEMAS
 * COMPILADORES 1
 * PROYECTO 1
 * Creado el 18 de septiembre 2011, 11:11AM
 */
package gameworld;
import java.awt.*;
/*
 * Tiene atributos y metodos a implementar sobre los
 * actores que se moveran, como Heroe, Villano y Arma.
 * Colores Obtenidos en
 * http://www.helpcharts.com/html-web-color-table.html
 * @(#)XColor.java
 * Proyecto1_200819312 application
 * @author David Y. Gonzalez
 */
public enum XColor {
    XAzul("x-azul", new Color(0,0,255)),
    XVerde("x-verde", new Color(0,128,0)),
    XCeleste("x-celeste", new Color(135,206,235)),//skyblue
    XMorado("x-morado", new Color(128,0,128)),
    XNegro("x-negro", new Color(0,0,0)),
    XGris("x-gris", new Color(128,128,128)),
    XCafe("x-cafe", new Color(165,42,42)),
    XAzulOscuro("x-azul_oscuro", new Color(0,0,139)),
    XVerdeOscuro("x-verde_oscuro", new Color(0,100,0)),
    XBlanco("x-blanco", new Color(255,255,255))
    ;
    
    private final String descripcion;
    private final Color color;
    
    XColor(String descripcion, Color color){
        this.descripcion = descripcion;
        this.color = color;
    }

    /**
     * @return color RGB
     **/
    public Color getColor() {
        return color;
    }
    /**
     * @return cadena estilo "x-morado"
     **/
    public String getDescripcion() {
        return descripcion;
    }
    
}
