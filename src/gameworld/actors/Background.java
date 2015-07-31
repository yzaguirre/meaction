/**
 * UNIVERSIDAD DE SAN CARLOS DE GUATEMALA
 * FACULTAD DE INGENIERIA
 * ESCUELA DE CIENCIAS Y SISTEMAS
 * COMPILADORES 1
 * PROYECTO 1
 * Creado el 03 de septiembre 2011, 22:39PM
 */
package gameworld.actors;

import gameworld.*;
import java.awt.*;
import java.awt.image.*;

/*
 * Representa el fondo del tablero matriz.
 * Sobreescribe el metodo de carga de imagen.
 * Solo existe una instancia por tablero matriz
 * @(#)Background.java
 * Proyecto1_200819312 application
 * @author David Y. Gonzalez
 */
public class Background extends Box {

    public Background(Stage stage) {
        super(stage);
        x_imagen = "\"res/trollmarket.jpg\"";
        this.pIJ = new Point(0, 0);
        this.pXY = new Point(0, 0);
        width = Stage.WIDTH;
        height = Stage.HEIGHT;
        x_descripcion = "Escenario del juego";
        x_tipo = "x-background";
    }

    @Override
    public void setX_alcance(int x_alcance) {
        System.err.println("Solo aplica para Arma");
    }

    @Override
    public void setX_color(XColor x_color) {
        System.err.println("Solo aplica para Bloque");
    }

    @Override
    public void setX_creditos(int x_creditos) {
        System.err.println("Solo aplica para Bonus");
    }

    @Override
    public void setX_uso(int x_uso) {
        System.err.println("Solo aplica para Uso");
    }

    @Override
    public void setX_vida(int x_vida) {
        System.err.println("Solo aplica para Hero o Villano");
    }

    @Override
    public void setImage(String name) {

        BufferedImage image = imageCache.getSprite(name);
        if (image == null) { //agarrar la imagen por default
            image = imageCache.getSprite(x_imagen); //intentar de nuevo
        } else {
            x_imagen = name;//guardar la llave de la nueva imagen
        }
    }

    @Override
    public void setX_destruir(int x_destruir) {
        System.err.append("Solo es valido para Arma, Bomba, Villano y Heroe");
    }


    @Override
    public Box clone() {
        Box retornable = new Background(this.stage);
        if (x_nombre != null) {
            retornable.setX_nombre(x_nombre);
        }
        if (x_imagen != null) {
            retornable.setImage(x_imagen);
        }
        if (x_descripcion != null){
                retornable.setX_descripcion(x_descripcion);
            }
        return retornable;
    }
}
