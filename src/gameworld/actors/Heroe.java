/**
 * UNIVERSIDAD DE SAN CARLOS DE GUATEMALA
 * FACULTAD DE INGENIERIA
 * ESCUELA DE CIENCIAS Y SISTEMAS
 * COMPILADORES 1
 * PROYECTO 1
 * Creado el 03 de septiembre 2011, 3:49PM
 */
package gameworld.actors;

import gameworld.*;
import java.awt.event.*;

/*
 * Es el Heroe del juego. Puede existir multiples instancias, pero solo 1 va ir sobre
 * el tablero matriz.
 * @(#)Heroe.java
 * Proyecto1_200819312 application
 * @author David Y. Gonzalez
 */

public class Heroe extends MovingBox {
    private int MAXJUMP = 2;//2 cuadritos
    private int jumpCount;
    private boolean jump;
    protected int x_destruir;
    protected int x_vida;
    private boolean shoot;
    /**indica el sentido del disparo. true para derecho, false para izquierdo**/
    private boolean flagShootLeftRight;
    /**
     * Arma del heroe. Si es Null, no tiene arma. Null es default
     **/
    private Arma weapon;

    public Heroe(Stage stage) {
        super(stage);
        x_imagen = "\"res/me15.gif\"";
        x_nombre = "Tarma";
        x_destruir = 3;
        x_vida = 9;
        x_descripcion = "El heroe debe llegar a la meta para cumplir con su mision.";
        x_tipo = "x-heroe";
        jumpCount = MAXJUMP + 1;
        //jump = false;
    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP: jump = false; break;
            case KeyEvent.VK_LEFT: left = false; break;
            case KeyEvent.VK_RIGHT: right = false; break;
            case KeyEvent.VK_A: shoot = false; break;
        }
        //updateSpeed();
        //System.out.println("keyreleased :)");
    }

    /**
     * La tecla de abajo no se toma en cuenta, pues se encarga de manipularla la gravedad
     **/
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP: jump = true; break;
            case KeyEvent.VK_LEFT: left = true; break;
            case KeyEvent.VK_RIGHT: right = true; break;
            case KeyEvent.VK_A: shoot = true; break;
        }
        //updateSpeed();
        //System.out.println("keyPressed :)");
    }

    
    @Override
    public void move() {
        int i = pIJ.x, j = pIJ.y;
        
        if (left) {
            if (!stage.isBloque(i, j - 1)){
                setCoordenate(i, --j );
                flagShootLeftRight = false;
            }
        } else if (right) {
            if (!stage.isBloque(i, j + 1)){
                setCoordenate(i, ++j );
                flagShootLeftRight = true;
            }
        }

       /**Salto y gravedad**/
        if (jump) {
            if (stage.isBloque(i + 1, j)){
                //si esta en el suelo, brinca
                //inicia su salto
                jumpCount = 0;
            }
        }
        if (jumpCount < MAXJUMP) {
            //saltar siguiente cuadro
            if (!stage.isBloque(i - 1, j)) {
                setCoordenate(--i, j);
                jumpCount++;
            } else {
                //topo con algo
                jumpCount = MAXJUMP + 1;
            }
        } else if (!stage.isBloque(i + 1, j)) {
            //caiga
            setCoordenate(++i, j);
            if (i >= 19) {
                //cayo al abismo
                //remove();
                stage.gameOver();
                x_vida = 0;
            }
        }
        if (shoot){
            fire();
        }
    }
    public void hitMeta(Meta m){
        System.out.println("Llegaste a la meta");
        stage.gameOver();
    }
    public void hitBonus(Bonus b){
        x_vida += b.getX_creditos();
        TableroMatriz tm = (TableroMatriz) stage;
        gui.TableroGame_GUI tgg = (gui.TableroGame_GUI)tm.getTopLevelAncestor();
        tgg.setXVida(x_vida);
        b.remove();
        //System.out.println("se te abona creditos: " + b.x_creditos + ", para total "+x_vida);
    }
    public void hitArma(Arma a){
        if (setWeapon(a)){
            a.remove();
            
            TableroMatriz tm = (TableroMatriz) stage;
            gui.TableroGame_GUI tgg = (gui.TableroGame_GUI)tm.getTopLevelAncestor();
            tgg.displayArma(a);
        }
        java.awt.Point p = a.getPointsIJ();
        System.out.println("Se le entrega un arma, i=" + p.x + ",j=" + p.y);
    }
    public void hitBomba(Bomba b){
        System.out.println("Tenes de vida " + x_vida);
        
        x_vida -= b.x_destruir;
        
        TableroMatriz tm = (TableroMatriz) stage;
        gui.TableroGame_GUI tgg = (gui.TableroGame_GUI)tm.getTopLevelAncestor();
        tgg.setXVida(x_vida);
        
        b.remove();
        if (x_vida <= 0) {
            System.out.println("Te mato la bomba");
            stage.gameOver();
        }
        java.awt.Point p = b.getPointsIJ();
        System.out.println("Exploto la bomba, i=" + p.x + ",j=" + p.y);
        System.out.println("te dejo con vida " + x_vida);
    }
    public void hitVillano(Villano v) {
        v.x_vida -= x_destruir;
        if (v.x_vida <= 0)
            v.remove();
        /*x_vida -= v.x_destruir;
        if (x_vida <= 0) {
            stage.gameOver();
        }*/
        java.awt.Point p = v.getPointsIJ();
        System.out.println("Pegaste a Villano, i=" + p.x + ",j=" + p.y);
    }
    
    /**
     * Utilizado para obtener estadisticas del Arma del Heroe
     * @return Arma del heroe. Null 
     **/
    public Arma getWeapon() {
        return weapon;
    }
    /**
     * Este metodo es llamado unicamente en modo de juego cuando el heroe toque un arma.
     * Si devuelve true
     * @param weapon Arma a utilizar por el heroe. Enviar null al llegar x-uso a 0
     * @return true Si se agrega weapon. false si ya tiene un arma en posesion
     **/
    public boolean setWeapon(Arma weapon) {
        if (this.weapon != null) return false;
        this.weapon = weapon;
        return true;
    }

    /**
     * Agrega el arma al escenario para su ataque.
     * Se acorda que nunca evaluara un Arma con x-uso=0
     **/
    public void fire() {
        if (weapon == null) {
            System.out.println("No hay arma");
            return;
        }
        if (stage.hasWeapon()){
            System.out.println("Hay un proyectile activo");
            return;
        }
        System.out.println("Se ha disparado");
        weapon.unMarkForRemoval();
        weapon.setCoordenate(pIJ.x, pIJ.y);
        weapon.shotDirection(flagShootLeftRight);
        stage.setWeapon(weapon);
        
        TableroMatriz tm = (TableroMatriz) stage;
        gui.TableroGame_GUI tgg = (gui.TableroGame_GUI)tm.getTopLevelAncestor();
        tgg.setXUso(--weapon.x_uso);
        
        if (weapon.x_uso == 0){
            weapon = null;
            tgg.clearDisplayArma();
            //hacer lo mismo con el weapon de Stage
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
        System.err.println("Solo es valido para Bonus");
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
        Box retornable = new Heroe(this.stage);
        if (x_nombre != null) {
            retornable.setX_nombre(x_nombre);
        }
        if (x_imagen != null) {
            retornable.setImage(x_imagen);
        }
        retornable.setX_descripcion(x_descripcion);

        if (x_vida >= 0) {
            retornable.setX_vida(x_vida);
        }
        if (x_destruir >= 0) {
            retornable.setX_destruir(x_destruir);
        }


        return retornable;
    }

    
}
