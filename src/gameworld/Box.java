/**
 * UNIVERSIDAD DE SAN CARLOS DE GUATEMALA
 * FACULTAD DE INGENIERIA
 * ESCUELA DE CIENCIAS Y SISTEMAS
 * COMPILADORES 1
 * PROYECTO 1
 * Creado el 02 de septiembre 2011, 07:27AM
 */
package gameworld;

import fileops.cache.*;
import java.awt.*;
import java.awt.image.*;
/*
 * Representa al espacio de un cuadro donde puede ser ocupado
 * por un Heroe, un villano, una bonificación, un arma, 
 * una bomba, etc.
 * @(#)Box.java
 * Proyecto1_200819312 application
 * @author David Y. Gonzalez
 */

public abstract class Box {

    /*protected String x_nombre, x_imagen, x_color ;
    protected int x_vida, x_destruir, x_creditos, x_alcances, x_uso;*/
    protected String x_nombre, x_imagen, x_descripcion;
    /**Variable especial para determinar cual es el tipo**/
    protected String x_tipo;
    /**
     * Coordenadas "x y i j" sobre el tablero matriz
     **/
    protected Point pXY, pIJ;
    /**
     * Ancho y altura de la IMAGEN y no del cuadro, que es constante de 32.
     * Recordad que la IMAGEN es escalada a 32x32
     **/
    protected int width, height;
    /**El largo l para x y y es constante, vale 32**/
    public final static int LENGTH = 32;
    protected ImageCache imageCache;
    
    protected Stage stage;

    /**Indicador si se debe elminar el objeto del escenario**/
    protected boolean markedForRemoval;

    /**
     * 
     * @return tipo de actor que representa
     **/
    public String getX_tipo() {
        return x_tipo;
    }
    
    public Box(Stage stage) {
        this.stage = stage;
        if (stage!=null)
        imageCache = stage.getImageCache();
        pXY = new Point();
        pIJ = new Point();
    }
    /**
     * Constructor para el analisis sintactico del fichero de Configuracion
     * Notar que no se le asigna un escenario. El escenario se va asigna a la copia
     * de este objeto usando el otro constructor, al compilar el fichero de Escenario.
     * 
     **/
    public Box(){
        this(null);
    }
    
    /**Solo es valido para Arma, los demas lanzan excepciones**/
    public abstract void setX_alcance(int x_alcance);
    /**Solo es valido para Bloque, los demas lanzan excepciones**/
    public abstract void setX_color(XColor x_color);
    /**Solo es valido para Bonus, los demas lanzan excepciones**/
    public abstract void setX_creditos(int x_creditos);
    /**Solo es valido para Arma, los demas lanzan excepciones**/
    public abstract void setX_uso(int x_uso);
    /**Solo es valido para Villano y Heroe, los demas lanzan excepciones**/
    public abstract void setX_vida(int x_vida);
    /**Solo es valido para Arma, Bomba, Villano y Heroe, los demas lanzan excepciones**/
    public abstract void setX_destruir(int x_destruir);
    public String getX_imagen() {
        return x_imagen;
    }
    public void setX_imagen(String x_imagen) {
        this.x_imagen = x_imagen;
    }
    public String getX_nombre() {
        return x_nombre;
    }
    public void setX_nombre(String x_nombre) {
        this.x_nombre = x_nombre;
    }
    public String getX_descripcion() {
        return x_descripcion;
    }
    public void setX_descripcion(String x_descripcion) {
        this.x_descripcion = x_descripcion;
    }

    /**Si el objeto es contiene solo 1 set de coordenas, estas seran
     * sobre escritas por los valores en el parametro. Si el objeto contiene
     * multiples coordenadas, se unen los nevos valores en el parametro.
     * Aca solo valida que la coordenada este dentro del tablero matriz.
     * @param i Coordenada i de la fila
     * @param j Coordenana j de la columna
     **/
    public final void setCoordenate(int i, int j) {
        if (i < 0 || i > 19 || j < 0 || j > 19) {
            System.err.println("La coordenada ("+i+","+j+") no es valida.");
        }
        pIJ.x = i;
        pIJ.y = j;
        
        pXY.x = j*LENGTH;
        pXY.y = i*LENGTH;
    }

    /**
     * Dibuja la imagen del objeto. Dibuja por cada set de coordenadas que exista.
     * Es sobreescrito por la clase Bloque
     * @param g Elemento a dibujar. Se supone que g pertenece a algun lienzo (BufferedImage) en memoria
     **/
    public void paint(Graphics2D g){
        Point p = pXY;
        g.drawImage(imageCache.getSprite(x_imagen), p.x, p.y, width, height, null);
    }

    /**
     * Carga la imagen al mapa de Imagenes unica por Tabla Matriz.
     * Es utilizado al momento de clonar un Actor Box que este alojado en la tabla de simbolos.
     * El objeto de la tabla de simbolos ya tiene una imagen (no verificada), pero el actor
     * cloneado tendra siempre una imagen default por si no resulta la imagen de la tabla de simbolos.
     * @param name Directorio completo o relativo de la imagen
     **/
    public void setImage(String name) {
        if (stage == null) {System.out.println("No hay escenario");return;}
        
        BufferedImage image = imageCache.getSprite(name);
        if (image == null) { // agarrar la imagen por default
            image = imageCache.getSprite(x_imagen); //intentar de nuevo
        } else{
            x_imagen = name;//guardar la llave de la nueva imagen
        }
        width = image.getWidth(null);
        height = image.getHeight(null);
        int lado = Math.max(width, width);
        double escala = LENGTH / (double) lado;
        width = (int) (escala*(double)width);
        height = (int) (escala*(double)height);
    }

    /**Devuelve los punto x  y del cuadro**/
    public final Point getPointsXY() {
        return this.pXY;
    }

    /**Devuelve las coordenadas i j del cuadro**/
    public final Point getPointsIJ() {
        return this.pIJ;
    }
    

    /**
     * Utilizado por los actores en la tabla de símbolos
     **/
    public final void setStage(Stage stage) {
        this.stage = stage;
    }

    /**Indica que el cuadro esta listo para eliminarse del tablero matriz**/
    public final void remove(){
        markedForRemoval = true;
    }
    /**
     * @return true si se debe eliminar el actor
     **/
    public boolean isMarkedForRemoval() {
        return markedForRemoval;
    }
    /**
     * Copia el tipo de objeto, para tener 2 diferentes instancias con los mismos datos, siendo del mismo tipo de objeto.
     * GenericBox.java lo hace de manera distinta (usando su String x_tipo) devuelve para un objeto Actor especifico.
     * No olvidar de Castear si es necesario.
     * La clase que no es GenericBox que implementa el metodo, son objetos que estan en la tabla de simbolos
     * Recordad ingresar un Stage para la copia de la tabla de simbolos, y luego igualarla a null
     **/
    @Override
    public abstract Box clone();
    
}