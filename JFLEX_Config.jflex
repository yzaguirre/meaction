/**
 * UNIVERSIDAD DE SAN CARLOS DE GUATEMALA
 * FACULTAD DE INGENIERIA
 * ESCUELA DE CIENCIAS Y SISTEMAS
 * COMPILADORES 1
 * PROYECTO 1
 * Creado el 04 de septiembre 2011, 11:01AM
 */
package analisis;
import java_cup.runtime.Symbol;
import java.util.*;
%%
%{
	private final String tipo = "Configuracion:Lexico";
	public LinkedList<XError> lista = new LinkedList<>();
	/* Metodo que es llamado al encontrar un error lexico */
	private void reportError(Integer linea, Integer columna, String descripcion, String token){
		lista.add(new XError(linea, columna, descripcion, token, tipo) );
	}
%}
%public
%class ScannerConfig
%cupsym symConfig
%cup
%char
%line
%column 
%ignorecase
//%state 
L=[:letter:]
D=[:digit:]
entero={D}*
literal=\"[^\"\n]*\"
ID={L}({L}|{D}|_)*
%%
<YYINITIAL>{
	"<configuration>" {
		return new Symbol(symConfig.eti_abre_configuration, yychar, yyline, yytext());
	}
	"<background>" {
		return new Symbol(symConfig.eti_abre_background, yychar, yyline, yytext());
	}
	"</background>" {
		return new Symbol(symConfig.eti_cierre_background, yychar, yyline, yytext());
	}
	"<figure>" {
		return new Symbol(symConfig.eti_abre_figure, yychar, yyline, yytext());
	}
	"</figure>" {
		return new Symbol(symConfig.eti_cierre_figure, yychar, yyline, yytext());
	}
	"<design>" {
		return new Symbol(symConfig.eti_abre_design, yychar, yyline, yytext());
	}
	"</design>" {
		return new Symbol(symConfig.eti_cierre_design, yychar, yyline, yytext());
	}
	"</configuration>" {
		return new Symbol(symConfig.eti_cierre_configuration, yychar, yyline, yytext());
	}
	"x-nombre" {
		return new Symbol(symConfig.x_nombre, yychar, yyline, yytext());
	}
	"x-imagen" {
		return new Symbol(symConfig.x_imagen, yychar, yyline, yytext());
	}
	"x-vida" {
		return new Symbol(symConfig.x_vida, yychar, yyline, yytext());
	}
	"x-tipo" {
		return new Symbol(symConfig.x_tipo, yychar, yyline, yytext());
	}
	"x-heroe" {
		return new Symbol(symConfig.x_heroe, yychar, yyline, yytext());
	}
	"x-villano" {
		return new Symbol(symConfig.x_villano, yychar, yyline, yytext());
	}
	"x-destruir" {
		return new Symbol(symConfig.x_destruir, yychar, yyline, yytext());
	}
	"x-meta" {
		return new Symbol(symConfig.x_meta, yychar, yyline, yytext());
	}
	"x-bloque" {
		return new Symbol(symConfig.x_bloque, yychar, yyline, yytext());
	}
	"x-bonus" {
		return new Symbol(symConfig.x_bonus, yychar, yyline, yytext());
	}
	"x-bomba" {
		return new Symbol(symConfig.x_bomba, yychar, yyline, yytext());
	}
	"x-arma" {
		return new Symbol(symConfig.x_arma, yychar, yyline, yytext());
	}
	"x-destruir" {
		return new Symbol(symConfig.x_destruir, yychar, yyline, yytext());
	}
	"x-descripcion" {
		return new Symbol(symConfig.x_descripcion, yychar, yyline, yytext());
	}
	"x-uso" {
		return new Symbol(symConfig.x_uso, yychar, yyline, yytext());
	}
	"x-alcance" {
		return new Symbol(symConfig.x_alcance, yychar, yyline, yytext());
	}
	"x-creditos" {
		return new Symbol(symConfig.x_creditos, yychar, yyline, yytext());
	}
	"x-color" {
		return new Symbol(symConfig.x_color, yychar, yyline, yytext());
	}
	"x-azul" {
		return new Symbol(symConfig.x_azul, yychar, yyline, yytext());
	}
	"x-verde" {
		return new Symbol(symConfig.x_verde, yychar, yyline, yytext());
	}
	"x-celeste" {
		return new Symbol(symConfig.x_celeste, yychar, yyline, yytext());
	}
	"x-morado" {
		return new Symbol(symConfig.x_morado, yychar, yyline, yytext());
	}
	"x-negro" {
		return new Symbol(symConfig.x_negro, yychar, yyline, yytext());
	}
	"x-gris" {
		return new Symbol(symConfig.x_gris, yychar, yyline, yytext());
	}
	"x-cafe" {
		return new Symbol(symConfig.x_cafe, yychar, yyline, yytext());
	}
	"x-azul_oscuro" {
		return new Symbol(symConfig.x_azul_oscuro, yychar, yyline, yytext());
	}
	"x-verde_oscuro" {
		return new Symbol(symConfig.x_verde_oscuro, yychar, yyline, yytext());
	}
	"x-blanco" {
		return new Symbol(symConfig.x_blanco, yychar, yyline, yytext());
	}
	
	{literal} {
		return new Symbol(symConfig.literal, yychar, yyline, yytext());
	}
	{entero} {
		return new Symbol(symConfig.entero, yychar, yyline, yytext());
	}
	"=" {
		return new Symbol(symConfig.igual, yychar, yyline, yytext());
	}
	";" {
		return new Symbol(symConfig.punto_comma, yychar, yyline, yytext());
	}
	"," {
		return new Symbol(symConfig.comma, yychar, yyline, yytext());
	}
	"{" {
		return new Symbol(symConfig.llave_abre, yychar, yyline, yytext());
	}
	"}" {
		return new Symbol(symConfig.llave_cierre, yychar, yyline, yytext());
	}
	"/*"~"*/" {
		System.out.println("Encontro Comentario Multiple: "+yytext());
	}
	"//"~([\r\n]) {
		System.out.println("Encontro comentario uni-linea: "+yytext());
	}

	{ID} {
		return new Symbol(symConfig.identificador, yychar, yyline, yytext());
	}
	[\r\f\t\n ]+ { //omitir los caracteres espacios, retorno de carro y salto de linea
	}
	. { //error, patron no establecido para el token
		reportError(yyline, yychar, "Error Lexico", yytext());
	}
}
