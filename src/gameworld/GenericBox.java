/**
 * UNIVERSIDAD DE SAN CARLOS DE GUATEMALA
 * FACULTAD DE INGENIERIA
 * ESCUELA DE CIENCIAS Y SISTEMAS
 * COMPILADORES 1
 * PROYECTO 1
 * Creado el 10 de septiembre 2011, 12:29PM
 */
package gameworld;

import gameworld.actors.*;//acceso a los distintos actores
/*
 * Es la implementación de un actor, siendo capaz de guardar todo tipo de atributo
 * sin excepcion. Ideal para colectar informacion del analisis Sintactico
 * del fichero de Configuración. Instancias de este tipo jamas iran en
 * la tabla de simbolo ni en ningun escenario.
 * Las excepciones ocurren cuando se realiza copias a las instancias originales;
 * 
 * Se sabe que Background jamas sera un GenericBox.
 * Sera un GenericBox los demas actores.
 * @(#)GenericBox.java
 * Proyecto1_200819312 application
 * @author David Y. Gonzalez
 */

public final class GenericBox extends Box {

    /**Variable solo para almacenar**/
    public int x_alcance, x_creditos, x_uso, x_vida, x_destruir;
    public XColor x_color;
    
    
    public void setX_tipo(String x_tipo) {
        this.x_tipo = x_tipo;
    }

    @Override
    public void setX_alcance(int x_alcance) {
        this.x_alcance = x_alcance;
    }

    @Override
    public void setX_color(XColor x_color) {
        this.x_color = x_color;
    }

    @Override
    public void setX_creditos(int x_creditos) {
        this.x_creditos = x_creditos;
    }

    @Override
    public void setX_uso(int x_uso) {
        this.x_uso = x_uso;
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
        Box retornable = null;
        if (x_tipo != null) {
            switch (x_tipo) {
                case "x-heroe":
                    retornable = new Heroe(null);
                    break;
                case "x-villano":
                    retornable = new Villano(null);
                    break;
                case "x-arma":
                    retornable = new Arma(null);
                    break;
                case "x-bomba":
                    retornable = new Bomba(null);
                    break;
                case "x-bonus":
                    retornable = new Bonus(null);
                    break;
                case "x-meta":
                    retornable = new Meta(null);
                    break;
                case "x-bloque":
                    retornable = new Bloque(null);
                    break;
                case "x-background":
                    retornable = new Background(null);
                default:
                    break;
            }
        }
        if (retornable != null) {
            if (x_nombre != null) {
                retornable.setX_nombre(x_nombre);
            } else return null;
            if (x_imagen != null) {
                retornable.setX_imagen(x_imagen);
            }
            if (x_descripcion != null){
                retornable.setX_descripcion(x_descripcion);
            }
            if (x_alcance > 0) {
                retornable.setX_alcance(x_alcance);
            }
            if (x_color != null) {
                retornable.setX_color(x_color);
            }
            if (x_vida > 0) {
                retornable.setX_vida(x_vida);
            }
            if (x_destruir > 0) {
                retornable.setX_destruir(x_destruir);
            }
            if (x_creditos > 0) {
                retornable.setX_creditos(x_creditos);
            }
            if (x_uso > 0) {
                retornable.setX_uso(x_uso);
            }
        }
        return retornable;
    }
}
