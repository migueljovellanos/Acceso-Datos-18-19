/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatosficheros.Logica;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Date;

/**
 *
 * @author migue
 */
public class Filtros {

    /**
     * Metodo que retorna los nombres de los archivos (Imagenes) que cumplen el filtro 
     * 
     * @param ruta String en el que se pasa la ruta en la que se buscan los ficheros
     * @return Array de Strings con el nombre de los ficheros que cumplen el filtro(Imagenes)
     * @throws accesodatosficheros.Logica.MisExcepciones.NoExisteDirectorio 
     */
    public static String[] filtrarFicherosImagenes(String ruta) throws MisExcepciones.NoExisteDirectorio {
        File dir = new File(ruta);
        if (!dir.exists()) {
            throw new MisExcepciones.NoExisteDirectorio();
        }
        String[] paths = dir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith("jpg") || name.endsWith("gif") || name.endsWith("tiff") || name.endsWith("jpeg") || name.endsWith("PNG");
            }
        });

        return paths;
    }

    /**
     * Metodo que retorna los nombres de los archivos (Videos) que cumplen el filtro 
     * 
     * @param ruta String en el que se pasa la ruta en la que se buscan los ficheros
     * @return Array de Strings con el nombre de los ficheros que cumplen el filtro(Videos)
     * @throws accesodatosficheros.Logica.MisExcepciones.NoExisteDirectorio 
     */
    public static String[] filtrarFicherosVideo(String ruta) throws MisExcepciones.NoExisteDirectorio {
        File dir = new File(ruta);
        if (!dir.exists()) {
            throw new MisExcepciones.NoExisteDirectorio();
        }
        String[] paths = dir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith("avi") || name.endsWith("mpeg") || name.endsWith("mov") || name.endsWith("flv") || name.endsWith("mkv");
            }
        });

        return paths;
    }

    /**
     * Metodo que retorna los nombres de los directorios que hay en una ruta 
     * 
     * @param ruta String en el que se pasa la ruta en la que se buscan los directorios
     * @return Array de Strings con el nombre de los directorios que cumplen el filtro
     * @throws accesodatosficheros.Logica.MisExcepciones.NoExisteDirectorio 
     */
    public static String[] filtrarDirectorios(String ruta) throws MisExcepciones.NoExisteDirectorio {
        File dir = new File(ruta);

        if (!dir.exists()) {
            throw new MisExcepciones.NoExisteDirectorio();
        }
        File[] directorios = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });

        String paths[] = new String[directorios.length];
        for (int i = 0; i < paths.length; i++) {
            paths[i] = directorios[i].getPath();
        }

        return paths;
    }
    
    /**
     * Metodo que devuelve los nombres de los ficheros que tienen un tamaño mayor al tamaño minimo pasado por parametro
     * 
     * @param ruta String en el que se pasa la ruta en la que se buscan los ficheros
     * @param tamanoMinimo tamaño minimo (en bytes) de los ficheros que se desea buscar
     * @return Array de Strings con el nombre de los ficheros mayores que el tamaño minimo
     * @throws accesodatosficheros.Logica.MisExcepciones.NoExisteDirectorio 
     */
    public static String[] filtrarFicherosTamanoMinimo(String ruta , int tamanoMinimo) throws MisExcepciones.NoExisteDirectorio {
        File dir = new File(ruta);

        if (!dir.exists()) {
            throw new MisExcepciones.NoExisteDirectorio();
        }
        File[] directorios = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return (tamanoMinimo<pathname.length());
            }
        });

        String paths[] = new String[directorios.length];
        for (int i = 0; i < paths.length; i++) {
            paths[i] = directorios[i].getPath();
        }

        return paths;
    }

    
    /**
     * Metodo que devuelve los nombres de los ficheros que fueron modificados en las ultimas 24 horas
     * 
     * @param ruta String en el que se pasa la ruta en la que se buscan los ficheros
     * @return Array de Strings con el nombre de los ficheros modificados en las ultimas 24H
     * @throws accesodatosficheros.Logica.MisExcepciones.NoExisteDirectorio 
     */
    public static String[] filtrarFicherosModificadosUltimas24H(String ruta) throws MisExcepciones.NoExisteDirectorio{
        File dir = new File(ruta);

        if (!dir.exists()) {
            throw new MisExcepciones.NoExisteDirectorio();
        }
        
        File[] directorios = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                Date fechaActual= new Date();
                return (fechaActual.getTime()-pathname.lastModified()<=8640000);
                
                
            }
        });
        String paths[] = new String[directorios.length];
        for (int i = 0; i < paths.length; i++) {
            paths[i] = directorios[i].getPath();
        }
        return paths;
    }
}
