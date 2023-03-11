package compilador;
import java_cup.runtime.Symbol;
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup /* Regresar el análisis */
%full /* Retornar toda la cadena */
%line /* Regresa la línea */
%char /* Regresa la columna en la que se encuentra */
L = [a-zA-Z_]+
D = [0-9]+
ESPACIO = [ ,\t,\r,\n]+
%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%
{ESPACIO} {/*Ignore*/} /* Espacios en blanco */
"{" {return new Symbol(sym.LLAVEAPERTURA, yychar, yyline, yytext());}
"}" {return new Symbol(sym.LLAVECIERRE, yychar, yyline, yytext());}
"(" {return new Symbol(sym.PARENTESISAPERTURA, yychar, yyline, yytext());}
")" {return new Symbol(sym.PARENTESISCIERRE, yychar, yyline, yytext());}
"[" {return new Symbol(sym.CORCHETEAPERTURA, yychar, yyline, yytext());}
"]" {return new Symbol(sym.CORCHETECIERRE, yychar, yyline, yytext());}
"\"" {return new Symbol(sym.COMILLAS, yychar, yyline, yytext());}
";" {return new Symbol(sym.PUNTOYCOMA, yychar, yyline, yytext());}
":" {return new Symbol(sym.DOSPUNTOS, yychar, yyline, yytext());}
"." {return new Symbol(sym.PUNTO, yychar, yyline, yytext());}
"i" {return new Symbol(sym.IDENTIFICADOR, yychar, yyline, yytext());}
"++" {return new Symbol(sym.OPERADOR_INCREMENTO, yychar, yyline, yytext());}
"+" {return new Symbol(sym.OPERADOR_POSITIVO, yychar, yyline, yytext());}
"=" {return new Symbol(sym.OPERADOR_IGUAL, yychar, yyline, yytext());}
"<" {return new Symbol(sym.OPERADOR_RELACIONAL, yychar, yyline, yytext());}
"int" {return new Symbol(sym.TIPO_DATO, yychar, yyline, yytext());}
"for" | "system" | "System" | "out" | "println" {return new Symbol(sym.RESERVADA, yychar, yyline, yytext());}
"Numero" {return new Symbol(sym.VARIABLE, yychar, yyline, yytext());}
("(-"{D}+")")|{D}+ {return new Symbol(sym.NUMERO, yychar, yyline, yytext());}
. {return new Symbol(sym.ERROR, yychar, yyline, yytext());}

