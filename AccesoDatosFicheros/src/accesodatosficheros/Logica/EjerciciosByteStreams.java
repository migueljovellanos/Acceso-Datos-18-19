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
                    texto.append((char) content);
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
    /**
     * Metodo que cifra o descifra un mensaje dependiendo del boolean 
     * @param textoACifrar texto que se desea cifrar o descifrar
     * @param codigoCifrado numero de caracteres que se desplaza cada caracter
     * @param descifrar boolean que indica si deseas cifrar o descifrar el texto
     * @return el mensaje cifrado o descifrado dependiendo del parametro descifrar
     */
    public String cifradoCesar(String textoACifrar, int codigoCifrado, boolean descifrar) {
        StringBuilder cifrado = new StringBuilder();
        if (descifrar) {
            codigoCifrado = -codigoCifrado;
        }
        for (int i = 0; i < textoACifrar.length(); i++) {
            if ((textoACifrar.charAt(i) >= 'a' && textoACifrar.charAt(i) <= 'z') || (textoACifrar.charAt(i) >= 'A' && textoACifrar.charAt(i) <= 'Z' )) {
                cifrado.append((char) (((textoACifrar.charAt(i) + 26 + codigoCifrado - 65) % 26) + 65));
            }else {
                cifrado.append((char) (textoACifrar.charAt(i)));
            }
        }
        return cifrado.toString();
    }
}
