/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaad1._limpiezadediscos.Logica;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author migue
 */
public class Filtros {

    /**
     * Metodo que recibe una lista , filtra las que pesen mas de X mb y devuelve
     * una lista con los archivos que cumple el filtro
     *
     * @param ficheros lista con los ficheros que se deben filtrar
     * @param tamanoMinimo tamaño en mb a partir del cual se devolveran los
     * ficheros
     * @return lista con los ficheros que cumplen el filtro
     * @throws
     * practicaad1._limpiezadediscos.Logica.MisExcepciones.NoExisteDirectorio
     */
    public static List<File> filtrarFicherosTamanoMinimo(List<File> ficheros, int tamanoMinimo) throws MisExcepciones.NoExisteDirectorio {

        List<File> ficherosFiltrados = new ArrayList();
        for (File fichero : ficheros) {
            if (tamanoMinimo < ((int) (fichero.length() / 1024) / 1024)) {
                ficherosFiltrados.add(fichero);
            }
        }
        return ficherosFiltrados;

    }

    /**
     * Metodo que recibe una lista , filtra las imagenes y devuelve una lista
     * con los archivos que cumple el filtro
     *
     * @param ficheros lista con los ficheros que se deben filtrar
     * @return lista con los ficheros que cumplen el filtro
     * @throws
     * practicaad1._limpiezadediscos.Logica.MisExcepciones.NoExisteDirectorio
     */
    public static List<File> filtrarFicherosImagenes(List<File> ficheros) throws MisExcepciones.NoExisteDirectorio {
        List<File> ficherosFiltrados = new ArrayList();
        for (File fichero : ficheros) {
            String name = fichero.getName();
            if (name.endsWith("jpg") || name.endsWith("gif") || name.endsWith("tiff") || name.endsWith("jpeg") || name.endsWith("png")) {
                ficherosFiltrados.add(fichero);
            }
        }
        return ficherosFiltrados;
    }

    /**
     * Metodo que recibe una lista , filtra los videos y devuelve una lista con
     * los archivos que cumple el filtro
     *
     * @param ficheros lista con los ficheros que se deben filtrar
     * @return lista con los ficheros que cumplen el filtro
     * @throws
     * practicaad1._limpiezadediscos.Logica.MisExcepciones.NoExisteDirectorio
     */
    public static List<File> filtrarFicherosVideos(List<File> ficheros) throws MisExcepciones.NoExisteDirectorio {
        List<File> ficherosFiltrados = new ArrayList();
        for (File fichero : ficheros) {
            String name = fichero.getName();
            if (name.endsWith("avi") || name.endsWith("mpeg") || name.endsWith("mov") || name.endsWith("flv") || name.endsWith("mkv") || name.endsWith("mp4")) {
                ficherosFiltrados.add(fichero);
            }
        }
        return ficherosFiltrados;
    }

    /**
     * Metodo que recibe una lista , filtra los audios y devuelve una lista con
     * los archivos que cumple el filtro
     *
     * @param ficheros lista con los ficheros que se deben filtrar
     * @return lista con los ficheros que cumplen el filtro
     * @throws
     * practicaad1._limpiezadediscos.Logica.MisExcepciones.NoExisteDirectorio
     */
    public static List<File> filtrarFicherosAudio(List<File> ficheros) throws MisExcepciones.NoExisteDirectorio {
        List<File> ficherosFiltrados = new ArrayList();
        for (File fichero : ficheros) {
            String name = fichero.getName();
            if (name.endsWith("mp3") || name.endsWith("FLAC") || name.endsWith("raw") || name.endsWith("aac")) {
                ficherosFiltrados.add(fichero);
            }
        }
        return ficherosFiltrados;
    }

    /**
     * Metodo que recibe una lista , filtra los documentos y devuelve una lista
     * con los archivos que cumple el filtro
     *
     * @param ficheros lista con los ficheros que se deben filtrar
     * @return lista con los ficheros que cumplen el filtro
     * @throws
     * practicaad1._limpiezadediscos.Logica.MisExcepciones.NoExisteDirectorio
     */
    public static List<File> filtrarFicherosDocumentos(List<File> ficheros) throws MisExcepciones.NoExisteDirectorio {
        List<File> ficherosFiltrados = new ArrayList();
        for (File fichero : ficheros) {
            String name = fichero.getName();
            if (name.endsWith("pdf") || name.endsWith("doc") || name.endsWith("txt") || name.endsWith("rtf") || name.endsWith("odt")) {
                ficherosFiltrados.add(fichero);
            }
        }
        return ficherosFiltrados;
    }

    /**
     * Metodo que retorna los nombres de los directorios que hay en una ruta
     *
     * @param ruta String en el que se pasa la ruta en la que se buscan los
     * directorios
     * @return Array de Strings con el nombre de los directorios que cumplen el
     * filtro
     * @throws
     * practicaad1._limpiezadediscos.Logica.MisExcepciones.NoExisteDirectorio
     */
    public static String[] filtrarDirectorios(String ruta) throws MisExcepciones.NoExisteDirectorio {
        File dir = new File(ruta);

        if (!dir.exists()) {
            throw new MisExcepciones.NoExisteDirectorio();
        }
        File[] directorios;
        directorios = dir.listFiles(File::isDirectory);

        String paths[] = new String[directorios.length];
        for (int i = 0; i < paths.length; i++) {
            paths[i] = directorios[i].getPath();
        }

        return paths;
    }

    /**
     * Metodo que devuelve los nombres de los ficheros que fueron modificados en
     * las ultimas 24 horas
     *
     * @param ruta String en el que se pasa la ruta en la que se buscan los
     * ficheros
     * @param dias
     * @return Array de Strings con el nombre de los ficheros modificados en las
     * ultimas 24H
     * @throws
     * practicaad1._limpiezadediscos.Logica.MisExcepciones.NoExisteDirectorio
     */
    public static File[] filtrarFicherosModificadosUltimas24H(String ruta, int dias) throws MisExcepciones.NoExisteDirectorio {
        File dir = new File(ruta);

        if (!dir.exists()) {
            throw new MisExcepciones.NoExisteDirectorio();
        }

        File[] directorios;
        directorios = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                Date fechaActual = new Date();
                return (fechaActual.getTime() - pathname.lastModified() <= dias * 8640000);

            }
        });

        return directorios;
    }
}
