/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaad1._limpiezadediscos.Logica;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author migue
 */
public class GestionLimpiezaDiscos {

    File unidadSeleccionada;

    public GestionLimpiezaDiscos(File unidad) {
        this.unidadSeleccionada = unidad;
    }

    public File getUnidadSeleccionada() {
        return unidadSeleccionada;
    }

    public int eliminarDirectoriosVacios() {
        File[] listaFicherosTemporal;
        ArrayList<File> listaFicheros = new ArrayList<>();
        int contadorBorrados = 0;

        listaFicherosTemporal = unidadSeleccionada.listFiles();
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
            ficheros = Filtros.filtrarFicherosImagenes(getUnidadSeleccionada().getPath());
        } else if (categoria.equals("Videos")) {
            ficheros = Filtros.filtrarFicherosVideo(getUnidadSeleccionada().getPath());
        } else if (categoria.equals("Audios")) {
            ficheros = Filtros.filtrarFicherosAudio(getUnidadSeleccionada().getPath());
        } else if (categoria.equals("Documentos")) {
            ficheros = Filtros.filtrarDocumentos(getUnidadSeleccionada().getPath());
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
        File[] ficheros = Filtros.filtrarFicherosTamanoMinimo(getUnidadSeleccionada().getPath(), tamano * 1048576);

        if (ficheros.length > 0) {
            for (File fichero : ficheros) {
                fichero.delete();
                contadorBorrados++;
            }
        }

        return contadorBorrados;
    }

    public int eliminarFicherosAntiguos(int dias) throws MisExcepciones.NoExisteDirectorio {
        int contadorBorrados = 0;
        File[] ficheros = Filtros.filtrarFicherosModificadosUltimas24H(getUnidadSeleccionada().getPath(), dias);

        if (ficheros.length > 0) {
            for (File fichero : ficheros) {
                fichero.delete();
                contadorBorrados++;
            }
        }

        return contadorBorrados;
    }

    public List<File> buscaCarpetasVacias(File carpetaRaiz) {
        //siempre retornamos al menos una lista vacía
        List<File> resultado = new ArrayList<>();
        if (carpetaRaiz.isDirectory()) {
            File[] carpetas = carpetaRaiz.listFiles(File::isDirectory);
            for (File carpeta : carpetas) {
                if (carpeta.listFiles().length == 0) {
                    resultado.add(carpeta);
                } else {
                    resultado.addAll(buscaCarpetasVacias(carpeta));
                }
            }
        }
        return resultado;
    }

    public int eliminarDirectoriosVaciosRecursivo() {
        int contadorBorrados = 0;
        List<File> listaCarpetasVacias = buscaCarpetasVacias(unidadSeleccionada);
        //de la implementación anterior, sabemos que
        //el método por lo menos retornará una lista vacía
        //no necesitamos hacer una validaciób en caso de nulos
        for (File carpeta : listaCarpetasVacias) {
            System.out.println(String.format("Borrando la carpeta %s", carpeta.getAbsolutePath()));
            carpeta.delete();
            contadorBorrados++;
        }
        return contadorBorrados;
    }
}
