/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatosficheros;

import accesodatosficheros.Logica.EjerciciosByteStreams;
import accesodatosficheros.Logica.MisExcepciones;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author migue
 */
public class AccesoDatosFicheros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        EjerciciosByteStreams ejer = new EjerciciosByteStreams();
        try {
            ejer.contarDensidadDeCadaLetra(new File("C:\\Users\\migue\\Downloads\\LaRegentaUTF8.txt"), new File("C:\\Users\\migue\\Downloads\\Laregentautf8.html"));
        } catch (MisExcepciones.NoExisteDirectorio | IOException ex) {
            Logger.getLogger(AccesoDatosFicheros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
