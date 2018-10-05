/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatosficheros;

import accesodatosficheros.Logica.MisExcepciones;
import accesodatosficheros.Logica.OperacionesFicheros;
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
        
     
        try {
            OperacionesFicheros.listarContenidoDirectorio("D:\\");
        } catch (MisExcepciones.NoExisteDirectorio | MisExcepciones.NoEsDirectorio | IOException | MisExcepciones.NoPuedoLeer ex) {
            Logger.getLogger(AccesoDatosFicheros.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

}
