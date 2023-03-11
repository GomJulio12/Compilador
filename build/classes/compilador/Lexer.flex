package compilador;
import static compilador.Token.*;
%%
%class Lexer
%type Token
L = [a-zA-Z_]+
D = [0-9]+
ESPACIO = [ ,\t,\r]+
%{
    public String lexeme;
%}
%%
{ESPACIO} {/*Ignore*/} /* Espacios en blanco */
"\n" {return LINEA;} /* Salto de línea */
"{" {lexeme=yytext(); return LLAVEAPERTURA;}
"}" {lexeme=yytext(); return LLAVECIERRE;}
"(" {lexeme=yytext(); return PARENTESISAPERTURA;}
")" {lexeme=yytext(); return PARENTESISCIERRE;}
"[" {lexeme=yytext(); return CORCHETEAPERTURA;}
"]" {lexeme=yytext(); return CORCHETECIERRE;}
"\"" {lexeme=yytext(); return COMILLAS;}
";" {lexeme=yytext(); return PUNTOYCOMA;}
":" {lexeme=yytext(); return DOSPUNTOS;}
"." {lexeme=yytext(); return PUNTO;}
"i" {lexeme=yytext(); return IDENTIFICADOR;}
"++" {lexeme=yytext(); return OPERADOR_INCREMENTO;}
"+" {lexeme=yytext(); return OPERADOR_POSITIVO;}
"=" {lexeme=yytext(); return OPERADOR_IGUAL;}
"<" {lexeme=yytext(); return OPERADOR_RELACIONAL;}
"int" {lexeme=yytext(); return TIPO_DATO;}
"for" | "system" | "System" | "out" | "println" {lexeme=yytext(); return RESERVADA;}
"Numero" {lexeme=yytext(); return VARIABLE;}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return NUMERO;}
. {return ERROR;}