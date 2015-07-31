/**
 * UNIVERSIDAD DE SAN CARLOS DE GUATEMALA
 * FACULTAD DE INGENIERIA
 * ESCUELA DE CIENCIAS Y SISTEMAS
 * COMPILADORES 1
 * PROYECTO 1
 * Creado el 03 de septiembre 2011, 4:54PM
 */
package gameworld.actors;

import gameworld.*;

/*
 * Es la salida del Heroe del juego. Puede existir multiples instancias, pero solo 1 va ir sobre
 * el tablero matriz.
 * @(#)Meta.java
 * Proyecto1_200819312 application
 * @author David Y. Gonzalez
 */
public class Meta extends Box {

    public Meta(Stage stage) {
        super(stage);
        x_imagen = "\"res/me17.png\"";
        x_descripcion = "Salida del juego";
        x_tipo = "x-meta";
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
        System.err.println("Solo es valido para Bonus");
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
        Box retornable = new Meta(this.stage);//stage puede ser null

        if (x_nombre != null) {
            retornable.setX_nombre(x_nombre);
        }
        if (x_imagen != null) {
            retornable.setImage(x_imagen);
        }
        if (x_descripcion != null) {
            retornable.setX_descripcion(x_descripcion);
        }
        return retornable;
    }
}
