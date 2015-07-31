/**
 * UNIVERSIDAD DE SAN CARLOS DE GUATEMALA
 * FACULTAD DE INGENIERIA
 * ESCUELA DE CIENCIAS Y SISTEMAS
 * COMPILADORES 1
 * PROYECTO 1
 * Creado el 02 de septiembre 2011, 02:33AM
 */
package gameworld;

import fileops.cache.*;
import gameworld.actors.*;

/*
 * Representa al escenario con atributos especial para el juego
 * @(#)Stage.java
 * Proyecto1_200819312 application
 * @author David Y. Gonzalez
 */

public interface Stage {

    public static final int WIDTH = 640;
    public static final int HEIGHT = 640;
    //public static final int PLAY_HEIGHT = 500; 
    //public static final int SPEED=10;

    public ImageCache getImageCache();

    /**Estos metodos seran usados por el ParserScene.java y el creador de Escenarios**/
    public void addVillano(Villano v);
    public void addMuro(Bloque b);
    public void addArma(Arma a);
    public void addBomba(Bomba b);
    public void addBonus(Bonus b);
    public void setMeta(Meta m);
    public void setHeroe(Heroe heroe);
    
    /* Analiza la posicion dado respecto a la matriz
     * la existencia de un obstaculo Muro
     * @param i Punto i respecto a la matriz del tablero
     * @param j Punto j respecto a la matriz del tablero
     * @return true si existe un muro o fuera de limites, false si es un espacio vacante
     *
     **/
    public boolean isBloque(int i, int j);
    /**
     * Es llamado desde el metodo fire() de Heroe
     * @return true si el escenario tiene un arma disparado por el heroe
     **/
    public boolean hasWeapon();

    public Heroe getHeroe();

    public void setBackground(Background background);

    public Background getBground();
    
    /*
     * Este es llamado desde Heroe, en modo de juego. Es el arma en movimiento
     */
    public void setWeapon(Arma weapon);

    public void gameOver();

    public boolean isGameEnded();

    public void paint();

    
}