/**
 * UNIVERSIDAD DE SAN CARLOS DE GUATEMALA
 * FACULTAD DE INGENIERIA
 * ESCUELA DE CIENCIAS Y SISTEMAS
 * COMPILADORES 1
 * PROYECTO 1
 * Creado el 04 de septiembre 2011, 10:56AM
 */
package analisis;

/*
 * Representa un error. Puede ser lexico o sintactico
 * @(#)X_Error.java
 * Proyecto1_200819312 application
 * @author David Y. Gonzalez
 */
public class XError {
    
    private Integer linea;
    private Integer columna;
    private String descripcion;
    private String tipo;
    private String token;
    public XError(Integer Linea, Integer Columna, String Descripcion, String Token, String tipo) {
        this.linea = Linea;
        this.columna = Columna;
        this.descripcion = Descripcion;
        this.tipo = tipo;
        this.token = Token;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    public Integer getColumna() {
        return columna;
    }

    public void setColumna(Integer Columna) {
        this.columna = Columna;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.descripcion = Descripcion;
    }

    public Integer getLinea() {
        return linea;
    }

    public void setLinea(Integer Linea) {
        this.linea = Linea;
    }
}
