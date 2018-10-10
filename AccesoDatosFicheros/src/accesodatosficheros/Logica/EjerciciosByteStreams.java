/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatosficheros.Logica;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author migue
 */
public class EjerciciosByteStreams {

    public EjerciciosByteStreams() {
    }

    
    public String leerArchivoTxt(String ruta) {
   
        StringBuilder texto = new StringBuilder();
        File file = new File(ruta);
        if (file.isFile() && file.toString().endsWith(".txt")) {
            try {
                FileInputStream fis = new FileInputStream(file);
                int content;

                while ((content = fis.read()) != -1) {
                    texto.append((char)content);
                }
                fis.close();

            } catch (FileNotFoundException ex) {
                Logger.getLogger(EjerciciosByteStreams.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(EjerciciosByteStreams.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return texto.toString();
    }
    
    public String cifradoCesar(String textoACifrar){
        StringBuilder cifrado = new StringBuilder();
        int codigo = 3 % 26;
        for (int i = 0; i < textoACifrar.length(); i++) {
            if (textoACifrar.charAt(i) >= 'a' && textoACifrar.charAt(i) <= 'z') {
                if ((textoACifrar.charAt(i) + codigo) > 'z') {
                    cifrado.append((char) (textoACifrar.charAt(i) + codigo - 26));
                } else {
                    cifrado.append((char) (textoACifrar.charAt(i) + codigo));
                }
            } else if (textoACifrar.charAt(i) >= 'A' && textoACifrar.charAt(i) <= 'Z') {
                if ((textoACifrar.charAt(i) + codigo) > 'Z') {
                    cifrado.append((char) (textoACifrar.charAt(i) + codigo - 26));
                } else {
                    cifrado.append((char) (textoACifrar.charAt(i) + codigo));
                }
            }
        }
        return cifrado.toString();
    }
    
    public static String descifradoCesar(String textoADescifrar) {
        StringBuilder cifrado = new StringBuilder();
        int codigo = 3 % 26;
        for (int i = 0; i < textoADescifrar.length(); i++) {
            if (textoADescifrar.charAt(i) >= 'a' && textoADescifrar.charAt(i) <= 'z') {
                if ((textoADescifrar.charAt(i) - codigo) < 'a') {
                    cifrado.append((char) (textoADescifrar.charAt(i) - codigo + 26));
                } else {
                    cifrado.append((char) (textoADescifrar.charAt(i) - codigo));
                }
            } else if (textoADescifrar.charAt(i) >= 'A' && textoADescifrar.charAt(i) <= 'Z') {
                if ((textoADescifrar.charAt(i) - codigo) < 'A') {
                    cifrado.append((char) (textoADescifrar.charAt(i) - codigo + 26));
                } else {
                    cifrado.append((char) (textoADescifrar.charAt(i) - codigo));
                }
            }
        }
        return cifrado.toString();
    }
}
