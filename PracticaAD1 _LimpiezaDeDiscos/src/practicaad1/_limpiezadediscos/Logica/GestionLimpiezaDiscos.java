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
    
    /**
     * Metodo que devuelve la unidad seleccionada para trabajar en el programa.
     * @return File con la unidad seleccionada.
     */
    public File getUnidadSeleccionada() {
        return unidadSeleccionada;
    }

    /**
     * Metodo que elimina los directorios vacios de la carpeta seleccionada.
     * @return El numero de directorios vacios.
     */
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

    /**
     * Metodo que borra todos los ficheros de una determinada categoria pasada por parametro.
     * @param categoria de la cual se desean borrar todos los archivos de la carpeta seleccionada.
     * @return El numero de ficheros borrados.
     * @throws practicaad1._limpiezadediscos.Logica.MisExcepciones.NoExisteDirectorio 
     */
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

    /**
     * Metodo que borra todos los ficheros de un tamaño mayor al pasado por parametro ( en MB).
     * @param tamano tamaño en mb a partir del cual se borraran todos los ficheros mayores.
     * @return El numero de ficheros borrados.
     * @throws practicaad1._limpiezadediscos.Logica.MisExcepciones.NoExisteDirectorio 
     */
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

    /**
     * Metodo que borra todos los ficheros cuya ultima modificacion hace tantos dias o mas como el numero de dias que se le pasa por parametro.
     * @param dias numero de dias a partir del cual se borraran los ficheros.
     * @return El numero de ficheros borrados.
     * @throws practicaad1._limpiezadediscos.Logica.MisExcepciones.NoExisteDirectorio 
     */
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

    /**
     * Metodo privado auxiliar cuya funcion es buscar todas las carpetas vacias recursivamente añadiendolas a la lista de File resultado.
     * @param carpetaRaiz directorio a partir del cual se buscaran los directorios vacios.
     * @return Una lista de ficheros en la que se encuentran los directorios vacios a partir de la carpetaRaiz.
     */
    private List<File> buscaCarpetasVacias(File carpetaRaiz) {
        //siempre retornamos al menos una lista vacía
        List<File> resultado = new ArrayList<>();
        if (carpetaRaiz.isDirectory()) {
            File[] carpetas = carpetaRaiz.listFiles(File::isDirectory);
            for (File carpeta : carpetas) {
                if (carpeta.isDirectory() && carpeta.listFiles().length == 0) {
                    resultado.add(carpeta);
                } else {
                    resultado.addAll(buscaCarpetasVacias(carpeta));
                }
            }
        }
        return resultado;
    }

    /**
     * Metodo que elimina todos los directorios vacios que recive del metodo privado buscaCarpetasVacias al que se llama dentro de este metodo.
     * @return Numero de directorios borrados por estar vacios.
     */
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
