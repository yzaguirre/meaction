/**
 * UNIVERSIDAD DE SAN CARLOS DE GUATEMALA
 * FACULTAD DE INGENIERIA
 * ESCUELA DE CIENCIAS Y SISTEMAS
 * COMPILADORES 1
 * PROYECTO 1
 * Creado el 18 de septiembre 2011, 02:53PM
 */
package gameworld;

/*
 * Representa al espacio de un cuadro donde puede ser ocupado
 * por un Heroe, un villano o un arma.
 * @(#)MovingBox.java
 * Proyecto1_200819312 application
 * @author David Y. Gonzalez
 */
public abstract class MovingBox extends Box{
    /**
     * Cuando todos estan falsos, es porque esta inmovil el objeto.
     * "down" siempre sera manipulada por una "Gravedad"
     **/
    protected boolean left, right;
    
    /**Esta sera la magnitud velocidad del actor**/
    protected final static byte SPEED = LENGTH;
    
    public MovingBox(Stage stage){
        super(stage);
    }
    /**
     * 'Act' se usa en modo de juego y edicion.
     * Nota: Solo el arma del heroe se va mover, y no otra arma**/
    public abstract void move();
    
}
