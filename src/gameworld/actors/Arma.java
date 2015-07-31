/**
 * UNIVERSIDAD DE SAN CARLOS DE GUATEMALA
 * FACULTAD DE INGENIERIA
 * ESCUELA DE CIENCIAS Y SISTEMAS
 * COMPILADORES 1
 * PROYECTO 1
 * Creado el 03 de septiembre 2011, 5:14PM
 */
package gameworld.actors;
import gameworld.*;

/*
 * Es el arma para el Heroe. Los villanos se dibujan encima y no tienen ningun efecto entre si. 
 * 
 * Puede existir multiples instancias distintos, y varias instancias iguales en el tablero matriz.
 * el tablero matriz.
 * @(#)Arma.java
 * Proyecto1_200819312 application
 * @author David Y. Gonzalez
 */
public class Arma extends MovingBox{

    
    protected int x_destruir;
    /**Alcance que tiene el proyectil arma**/
    protected int x_alcance;
    protected int x_uso;
    /*lo que ha avanzado el arma*/
    private int paces;

    /**true para la derecha, false para la izquierda**/
    private boolean shotDirection;
    
    public Arma(Stage stage){
        super(stage);
        x_imagen = "\"res/me24.png\"";
        x_destruir = 3;
        x_alcance = 4;
        x_uso = 6;
        x_descripcion = "Arma defensiva del Heroe. Malo para los villanos.";
        x_tipo = "x-arma";
    }
    public void hitVillano(Villano v, int x_destruirH){
        v.x_vida -= x_destruir + x_destruirH;
        if (v.x_vida <= 0)
            v.remove();
        remove();
    }
    
    /**
     * Es llamado por el metodo fire() de heroe
     * @param shotDirection true para derecho, false para izquierdo
     **/
    public void shotDirection(boolean shotDireccion){
        this.shotDirection = shotDireccion;
        paces = 0;
    }
    @Override
    public void move() {
        int i = pIJ.x, j = pIJ.y;
        if (paces >= x_alcance){
            remove();
        }
        paces++;
        if (shotDirection){
            //disparo a la derecha
            if (stage.isBloque(i, j + 1)) {
                remove();
            } else {
                setCoordenate(i, j + 1);
            }
        } else {
            //disparo a la izquierda
            if (stage.isBloque(i, j - 1)) {
                remove();
            } else {
                setCoordenate(i, j - 1);
            }
        }
    }
    public void unMarkForRemoval(){
        markedForRemoval = false;
    }
    
    public int getX_alcance() {
        return x_alcance;
    }
    @Override
    public void setX_alcance(int x_alcance) {
        this.x_alcance = x_alcance;
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
    public int getX_uso() {
        return x_uso;
    }
    @Override
    public void setX_uso(int x_uso){
        this.x_uso = x_uso;
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
        Box retornable = new Arma(this.stage);
            if (x_nombre != null) {
                retornable.setX_nombre(x_nombre);
            }
            if (x_imagen != null) {
                retornable.setImage(x_imagen);
            }
            if (x_descripcion != null){
                retornable.setX_descripcion(x_descripcion);
            }
            if (x_alcance > 0) {
                retornable.setX_alcance(x_alcance);
            }
            if (x_destruir >= 0) {
                retornable.setX_destruir(x_destruir);
            }
            if (x_uso >= 0) {
                retornable.setX_uso(x_uso);
            }
        return retornable;
    }    
}
