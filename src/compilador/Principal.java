package compilador;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Julio M. Gomez Hernandez
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
                // TODO code application logic here
        String path1 = "C:/Users/ekt/Documentos/NetBeansProjects/Compilador/src/compilador/Lexer.flex";
        String path2 = "C:/Users/ekt/Documentos/NetBeansProjects/Compilador/src/compilador/LexerCup.flex";
        String[] pathS = {"-parser", "Sintax", "C:/Users/ekt/Documentos/NetBeansProjects/Compilador/src/compilador/Sintax.cup"};
        generar(path1, path2, pathS);
    }
    public static void generar(String path1, String path2, String[] pathS) throws IOException, Exception{
        File archivo;
        archivo = new File(path1);
        JFlex.Main.generate(archivo);
        archivo = new File(path2);
        JFlex.Main.generate(archivo);
        java_cup.Main.main(pathS);
        
        Path pathSym = Paths.get("C:/Users/ekt/Documentos/NetBeansProjects/Compilador/src/compilador/sym.java");
        if (Files.exists(pathSym)) {
            Files.delete(pathSym);
        }
        Files.move(
                Paths.get("C:/Users/ekt/Documentos/NetBeansProjects/Compilador/sym.java"), 
                Paths.get("C:/Users/ekt/Documentos/NetBeansProjects/Compilador/src/compilador/sym.java")
        );
        Path pathSin = Paths.get("C:/Users/ekt/Documentos/NetBeansProjects/Compilador/src/compilador/Sintax.java");
        if (Files.exists(pathSin)) {
            Files.delete(pathSin);
        }
        Files.move(
                Paths.get("C:/Users/ekt/Documentos/NetBeansProjects/Compilador/Sintax.java"), 
                Paths.get("C:/Users/ekt/Documentos/NetBeansProjects/Compilador/src/compilador/Sintax.java")
        );
    }
        
}
