/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaad1._limpiezadediscos.Logica;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author migue
 */
public class GestionLimpiezaDiscos {
    
    File unidad;

    public GestionLimpiezaDiscos(File unidad) {
        this.unidad = unidad;
    }

    public File getUnidad() {
        return unidad;
    }

    public void eliminarFicherosVacios(){
        File[] listaFicherosTemporal;
        ArrayList<File> listaFicheros = new ArrayList<>();
        
        
        listaFicherosTemporal = unidad.listFiles();
        for (File fichero : listaFicherosTemporal) {
            listaFicheros.add(fichero);
        }
        
        for (File fichero : listaFicheros) {
            if(fichero==null){
                fichero.delete();
            }
        }
    }

    
    
}
