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

    public int eliminarDirectoriosVacios() {
        File[] listaFicherosTemporal;
        ArrayList<File> listaFicheros = new ArrayList<>();
        int contadorBorrados = 0;

        listaFicherosTemporal = unidad.listFiles();
        for (File fichero : listaFicherosTemporal) {
            listaFicheros.add(fichero);
        }

        for (File directorio : listaFicheros) {
            if (directorio.isDirectory() && directorio.list().length == 0) {
                directorio.delete();
                contadorBorrados++;
            }
        }
        return contadorBorrados;
    }

    public int eliminarFicherosPorCategoria(String categoria) throws MisExcepciones.NoExisteDirectorio {
        int contadorBorrados = 0;
        File[] ficheros = null;
        if (categoria.equals("Imagenes")) {
            ficheros = Filtros.filtrarFicherosImagenes(getUnidad().getPath());
        } else if (categoria.equals("Videos")) {
            ficheros = Filtros.filtrarFicherosVideo(getUnidad().getPath());
        } else if (categoria.equals("Audios")) {
            ficheros = Filtros.filtrarFicherosAudio(getUnidad().getPath());
        } else if (categoria.equals("Documentos")) {
            ficheros = Filtros.filtrarDocumentos(getUnidad().getPath());
        }

        if (ficheros.length > 0) {
            for (File fichero : ficheros) {
                fichero.delete();
                contadorBorrados++;
            }
        }
        return contadorBorrados;
    }

    public int eliminarFicherosPorTamaño(int tamano) throws MisExcepciones.NoExisteDirectorio {
        int contadorBorrados = 0;
        File[] ficheros = Filtros.filtrarFicherosTamanoMinimo(getUnidad().getPath(), tamano * 1048576);

        if (ficheros.length > 0) {
            for (File fichero : ficheros) {
                fichero.delete();
                contadorBorrados++;
            }
        }

        return contadorBorrados;
    }

}
