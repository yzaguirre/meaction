/**
 * UNIVERSIDAD DE SAN CARLOS DE GUATEMALA
 * FACULTAD DE INGENIERIA
 * ESCUELA DE CIENCIAS Y SISTEMAS
 * COMPILADORES 1
 * PROYECTO 1
 * Creado el 03 de septiembre 2011, 5:35PM
 */
package gameworld.actors;

import gameworld.*;
/*
 * Es el bomba para herir el Heroe. Los villanos se dibujan encima y no tienen ningun efecto entre si. 
 * 
 * Puede existir multiples instancias distintos, y varias instancias iguales en el tablero matriz.
 * el tablero matriz.
 * @(#)Bomba.java
 * Proyecto1_200819312 application
 * @author David Y. Gonzalez
 */

public class Bomba extends Box {

    public int x_destruir;

    public Bomba(Stage stage) {
        super(stage);
        x_imagen = "\"res/me36.png\"";
        x_destruir = 2;
        x_descripcion = "Artefacto explosivo dañino para el Heroe";
        x_tipo = "x-bomba";
    }

    @Override
    public void setX_alcance(int x_alcance) {
        System.err.println("Solo es valido para Arma");
    }

    @Override
    public void setX_color(XColor x_color) {
        System.err.println("Solo es valido para Bloque");
    }

    @Override
    public void setX_creditos(int x_creditos) {
        System.err.append("Solo es valido para Bonus");
    }

    public int getX_destruir() {
        return x_destruir;
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
        this.x_destruir = x_destruir;
    }

    @Override
    public Box clone() {

        Box retornable = new Bomba(this.stage);
        if (x_nombre != null) {
            retornable.setX_nombre(x_nombre);
        }
        if (x_imagen != null) {
            retornable.setImage(x_imagen);
        }
        if (x_descripcion != null) {
            retornable.setX_descripcion(x_descripcion);
        }
        if (x_destruir >= 0) {
            retornable.setX_destruir(x_destruir);
        }
        return retornable;
    }
}
