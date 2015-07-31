/**
 * UNIVERSIDAD DE SAN CARLOS DE GUATEMALA
 * FACULTAD DE INGENIERIA
 * ESCUELA DE CIENCIAS Y SISTEMAS
 * COMPILADORES 1
 * PROYECTO 1
 * Creado el 03 de septiembre 2011, 4:15PM
 */
package gameworld.actors;

import gameworld.*;

/*
 * Es el Villano del juego. Puede existir multiples instancias, y muchas del mismo
 * pueden ir sobre el tablero matriz
 * @(#)Villano.java
 * Proyecto1_200819312 application
 * @author David Y. Gonzalez
 */
public class Villano extends MovingBox {

    protected int x_destruir;
    protected int x_vida;
    
    public Villano(Stage stage) {
        super(stage);
        x_imagen = "\"res/me8.gif\"";
        x_destruir = 2;
        x_vida = 6;
        x_descripcion = "Un villano cuya mision es detener al heroe en su adventura.";
        x_tipo = "x-villano";
        
        left = !(right = (int) (Math.random() * 2) == 0?true:false);
    }

    @Override
    public void move() {
        int i = pIJ.x, j = pIJ.y;
        if (!stage.isBloque(i + 1, j)) {
            //caiga
            setCoordenate(++i, j);
            if (i >= 19) {
                //cayo al abismo
                remove();
            }
        } else if (left) {
            if (!stage.isBloque(i, j - 1) && stage.isBloque(i + 1, j - 1)) {
                setCoordenate(i, --j);
            } else {
                //cambiar rumbo a derecho
                right = true;
                left = false;
            }
        } else if (right) {
            if (!stage.isBloque(i, j + 1) && stage.isBloque(i + 1, j + 1)) {
                setCoordenate(i, ++j);
                //System.out.printf("Derecho %s: coordenada (%d,%d)\n", dir, i, j);
            } else {
                //cambiar rumbo a izquierdo
                right = false;
                left = true;
            }
        }
    }

    public void hitHeroe(Heroe h) {
        h.x_vida -= x_destruir;
        
        TableroMatriz tm = (TableroMatriz) stage;
        gui.TableroGame_GUI tgg = (gui.TableroGame_GUI)tm.getTopLevelAncestor();
        tgg.setXVida(x_vida);
        
        if (h.x_vida <= 0) {
            stage.gameOver();
            System.out.println("te mato villano");
        }
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

    public int getX_vida() {
        return x_vida;
    }

    @Override
    public void setX_vida(int x_vida) {
        this.x_vida = x_vida;
    }

    @Override
    public void setX_destruir(int x_destruir) {
        this.x_destruir = x_destruir;
    }

    @Override
    public Box clone() {
        Box retornable = new Villano(this.stage);

        if (x_nombre != null) {
            retornable.setX_nombre(x_nombre);
        }
        if (x_imagen != null) {
            retornable.setImage(x_imagen);
        }
        if (x_descripcion != null) {
            retornable.setX_descripcion(x_descripcion);
        }

        if (x_vida >= 0) {
            retornable.setX_vida(x_vida);
        }
        if (x_destruir >= 0) {
            retornable.setX_destruir(x_destruir);
        }
        return retornable;
    }
}
