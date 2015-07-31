package analisis;
import java_cup.runtime.Symbol;
import java.util.*;
%%
%{
	public LinkedList<XError> lista = new LinkedList<>();
	private final String tipo = "Escenario:Lexico";
	/* Metodo que es llamado al encontrar un error lexico */
	private void reportError(Integer linea, Integer columna, String descripcion, String token){
		lista.add(new XError(linea, columna, descripcion, token, tipo) );
	}
	
%}
%public
%class ScannerScene
%cupsym symScene
%cup
%char
%line
%column 
%state ATRIBUTO
L=[:letter:]
D=[:digit:]
entero={D}*
ID={L}({L}|{D}|_)*
%%
<YYINITIAL>{
	"<escenarios" {
		yybegin(ATRIBUTO);
		return new Symbol(symScene.eti_abre_escenarios, yychar, yyline, yytext());
	}
	"<personajes>" {
		return new Symbol(symScene.eti_abre_personajes, yychar, yyline, yytext());
	}
	"<heroes>" {
		return new Symbol(symScene.eti_abre_heroes, yychar, yyline, yytext());
	}
	"<villanos>" {
		return new Symbol(symScene.eti_abre_villanos, yychar, yyline, yytext());
	}
	"<paredes>" {
		return new Symbol(symScene.eti_abre_paredes, yychar, yyline, yytext());
	}
	"<extras>" {
		return new Symbol(symScene.eti_abre_extras, yychar, yyline, yytext());
	}
	"<armas>" {
		return new Symbol(symScene.eti_abre_armas, yychar, yyline, yytext());
	}
	"<bonus>" {
		return new Symbol(symScene.eti_abre_bonus, yychar, yyline, yytext());
	}
	"<meta>" {
		return new Symbol(symScene.eti_abre_meta, yychar, yyline, yytext());
	}
	
	"</escenario>" {
		return new Symbol(symScene.eti_cierre_escenarios, yychar, yyline, yytext());
	}
	"</personajes>" {
		return new Symbol(symScene.eti_cierre_personajes, yychar, yyline, yytext());
	}
	"</heroes>" {
		return new Symbol(symScene.eti_cierre_heroes, yychar, yyline, yytext());
	}
	"</villanos>" {
		return new Symbol(symScene.eti_cierre_villanos, yychar, yyline, yytext());
	}
	"</paredes>" {
		return new Symbol(symScene.eti_cierre_paredes, yychar, yyline, yytext());
	}
	"</extras>" {
		return new Symbol(symScene.eti_cierre_extras, yychar, yyline, yytext());
	}
	"</armas>" {
		return new Symbol(symScene.eti_cierre_armas, yychar, yyline, yytext());
	}
	"</bonus>" {
		return new Symbol(symScene.eti_cierre_bonus, yychar, yyline, yytext());
	}
	"</meta>" {
		return new Symbol(symScene.eti_cierre_meta, yychar, yyline, yytext());
	}
	{ID} {
		return new Symbol(symScene.identificador, yychar, yyline, yytext());
	}
	{entero} {
		return new Symbol(symScene.entero, yychar, yyline, yytext());
	}
	".." {
		return new Symbol(symScene.dos_puntos, yychar, yyline, yytext());
	}
	"=" {
		return new Symbol(symScene.igual, yychar, yyline, yytext());
	}
	";" {
		return new Symbol(symScene.punto_comma, yychar, yyline, yytext());
	}
	"," {
		return new Symbol(symScene.comma, yychar, yyline, yytext());
	}
	"(" {
		return new Symbol(symScene.paren_abre, yychar, yyline, yytext());
	}
	")" {
		return new Symbol(symScene.paren_cierre, yychar, yyline, yytext());
	}
	"/*"~"*/" {
		System.out.println("Encontro Comentario Multiple: "+yytext());
	}
	"//"~([\r\n]) {
		System.out.println("Encontro comentario uni-linea: "+yytext());
	}
	[\r\f\t\n ]+ { //omitir los caracteres espacios, retorno de carro y salto de linea
	}
	. { //error, patron no establecido para el token
		reportError(yyline, yychar, "Error Lexico", yytext());
	}
}
<ATRIBUTO> {
	"background" {
		return new Symbol(symScene.background, yychar, yyline, yytext());
	}
	"=" {
		return new Symbol(symScene.igual, yychar, yyline, yytext());
	}
	{ID} {
		return new Symbol(symScene.identificador, yychar, yyline, yytext());
	}
	";" {
		return new Symbol(symScene.punto_comma, yychar, yyline, yytext());
	}
	">" {
		yybegin(YYINITIAL);
		return new Symbol(symScene.mayor_que, yychar, yyline, yytext());
	}
	[\r\f\t\n ]+ { //omitir los caracteres espacios, retorno de carro y salto de linea
	}
	. { //error, patron no establecido para el token
		reportError(yyline, yychar, "Error Lexico", yytext());
	}
}
