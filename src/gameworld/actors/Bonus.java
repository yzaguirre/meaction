/**
 * UNIVERSIDAD DE SAN CARLOS DE GUATEMALA
 * FACULTAD DE INGENIERIA
 * ESCUELA DE CIENCIAS Y SISTEMAS
 * COMPILADORES 1
 * PROYECTO 1
 * Creado el 03 de septiembre 2011, 5:07PM
 */
package gameworld.actors;

import gameworld.*;
/*
 * Es la bonificacion para el Heroe. Los villanos se dibujan encima y no tienen ningun efecto entre si. 
 * 
 * Puede existir multiples instancias distintos, y varias instancias iguales en el tablero matriz.
 * el tablero matriz.
 * @(#)Bonus.java
 * Proyecto1_200819312 application
 * @author David Y. Gonzalez
 */
public class Bonus extends Box {

    private int x_creditos;

    public Bonus(Stage stage) {
        super(stage);
        x_imagen = "\"res/me22.png\"";
        x_creditos = 6;
        x_descripcion = "Ayuda para el heroe";
        x_tipo = "x-bonus";
    }
    
    @Override
    public void setX_alcance(int x_alcance) {
        System.err.println("Solo es valido para Arma");
    }

    @Override
    public void setX_color(XColor x_color) {
        System.err.println("Solo es valido para Bloque");
    }

    public int getX_creditos() {
        return x_creditos;
    }

    @Override
    public void setX_creditos(int x_creditos) {
        this.x_creditos = x_creditos;
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
        Box retornable = new Bonus(this.stage);

        if (x_nombre != null) {
            retornable.setX_nombre(x_nombre);
        }
        if (x_imagen != null) {
            retornable.setImage(x_imagen);
        }
        if (x_descripcion != null) {
            retornable.setX_descripcion(x_descripcion);
        }

        if (x_creditos >= 0) {
            retornable.setX_creditos(x_creditos);
        }
        return retornable;
    }
}
