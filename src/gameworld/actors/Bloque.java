/**
 * UNIVERSIDAD DE SAN CARLOS DE GUATEMALA
 * FACULTAD DE INGENIERIA
 * ESCUELA DE CIENCIAS Y SISTEMAS
 * COMPILADORES 1
 * PROYECTO 1
 * Creado el 03 de septiembre 2011, 5:38PM
 */
package gameworld.actors;

import gameworld.*;
import java.awt.*;
/*
 * Es un muro o suelo para los demás elementos caminen sobre el.
 * 
 * Puede existir multiples instancias distintos, y varias instancias iguales en el tablero matriz.
 * el tablero matriz.
 * @(#)Bloque.java
 * Proyecto1_200819312 application
 * @author David Y. Gonzalez
 */

public class Bloque extends Box {

    private XColor x_color;

    public Bloque(Stage stage) {
        super(stage);
        x_imagen = "\"res/me28.png\"";
        x_descripcion = "Un muro o suelo.";
        x_color = XColor.XAzul;
        x_tipo = "x-bloque";
    }
    @Override
    public void paint(Graphics2D g){
        g.setColor(x_color.getColor());
        g.fillRect(pXY.x, pXY.y, 32, 32);
        super.paint(g);
    }

    @Override
    public void setX_alcance(int x_alcance) {
        System.err.println("Solo es valido para Arma");
    }

    public XColor getX_color() {
        return x_color;
    }

    @Override
    public void setX_color(XColor x_color) {
        this.x_color = x_color;
    }

    @Override
    public void setX_creditos(int x_creditos) {
        System.err.append("Solo es valido para Bonus");
    }

    @Override
    public void setX_uso(int x_uso) {
        System.err.append("Solo es valido para Arma");
    }

    @Override
    public void setX_vida(int x_vida) {
        System.err.append("Solo es valido para Heroe y Villano");
    }

    @Override
    public void setX_destruir(int x_destruir) {
        System.err.append("Solo es valido para Arma, Bomba, Villano y Heroe");
    }

    @Override
    public Box clone() {
        Box retornable = new Bloque(this.stage);
        if (x_nombre != null) {
            retornable.setX_nombre(x_nombre);
        }
        if (x_imagen != null) {
            retornable.setImage(x_imagen);
        }
        if (x_descripcion != null) {
            retornable.setX_descripcion(x_descripcion);
        }

        if (x_color != null) {
            retornable.setX_color(x_color);
        }
        return retornable;
    }
}
