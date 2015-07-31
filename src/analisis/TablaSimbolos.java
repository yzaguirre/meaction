/**
 * UNIVERSIDAD DE SAN CARLOS DE GUATEMALA
 * FACULTAD DE INGENIERIA
 * ESCUELA DE CIENCIAS Y SISTEMAS
 * COMPILADORES 1
 * PROYECTO 1
 * Creado el 08 de septiembre 2011, 11:23AM
 */
package analisis;
import gameworld.*;
import java.util.*;
/**
 *
 * @author dyzag
 */
public class TablaSimbolos  {
    private HashMap<String, Box> tabla;

    /**
     * Tamaño del Hashmap sera de 30. Pero 20x20 da para 400 elementos distintos,
     * pues puede ser mayor. 
     **/
    public TablaSimbolos() {
        this.tabla = new HashMap<>(30);
    }
    /**
     * Agrega un actor a la tabla de simbolos
     * @param actor Actor a agregar a la lista
     * @return true si tuvo exito en insertar en la tabla de simbolos
     **/
    public boolean put(Box actor){
        if (actor == null){System.out.println("Actor mierda es falso");return false;}
        if (tabla.get(actor.getX_nombre())!=null){
            System.out.println("Ya esta ocupado el actor "+actor.getX_nombre());
            return false;
            
        }
        tabla.put(actor.getX_nombre(), actor);
        return true;
    }
    /**
     * Devuelve el actor
     * @param x_name Nombre del actor
     **/
    public Box get(String x_name){
        return tabla.get(x_name);
    }
    public int size(){
        return tabla.size();
    }

    /**
     * Utilizado para mostrar la tabla de simbolos
     **/
    public HashMap<String, Box> getTabla() {
        return tabla;
    }
    
    
}
