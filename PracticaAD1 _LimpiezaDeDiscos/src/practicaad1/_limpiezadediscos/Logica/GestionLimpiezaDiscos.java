/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaad1._limpiezadediscos.Logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author migue
 */
public class GestionLimpiezaDiscos {

    private File unidadSeleccionada;
    private String log = "";

    public GestionLimpiezaDiscos(File unidad) {
        this.unidadSeleccionada = unidad;
    }

    /**
     * Metodo que devuelve la unidad seleccionada para trabajar en el programa.
     *
     * @return File con la unidad seleccionada.
     */
    public File getUnidadSeleccionada() {
        return unidadSeleccionada;
    }

    /**
     * Metodo que devuelve el log del programa.
     *
     * @return String con la informacion generada por el programa.
     */
    public String getLog() {
        return log;
    }

    /**
     * Metodo que elimina los directorios vacios de la carpeta seleccionada.
     *
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
                log += "Borrando " + directorio.getAbsolutePath() + "\n";
                directorio.delete();
                contadorBorrados++;
            }
        }
        return contadorBorrados;
    }

    /**
     * Metodo que borra todos los ficheros de una determinada categoria pasada
     * por parametro.
     *
     * @param categoria de la cual se desean borrar todos los archivos de la
     * carpeta seleccionada.
     * @return El numero de ficheros borrados.
     * @throws
     * practicaad1._limpiezadediscos.Logica.MisExcepciones.NoExisteDirectorio
     */
    public List<File> seleccionarFicherosPorCategoria(String categoria) throws MisExcepciones.NoExisteDirectorio {

        List<File> ficheros = listarArchivosRecursivo(unidadSeleccionada);
        List<File> ficherosFiltrados = new ArrayList<>();
        switch (categoria) {
            case "Imagenes":
                ficherosFiltrados = Filtros.filtrarFicherosImagenes(ficheros);
                break;
            case "Videos":
                ficherosFiltrados = Filtros.filtrarFicherosVideos(ficheros);
                break;
            case "Audios":
                ficherosFiltrados = Filtros.filtrarFicherosAudio(ficheros);
                break;
            case "Documentos":
                ficherosFiltrados = Filtros.filtrarFicherosDocumentos(ficheros);
                break;
            default:
                break;
        }
        
        return ficherosFiltrados;
    }

    /**
     * Metodo que borra todos los ficheros de un tamaño mayor al pasado por
     * parametro ( en MB).
     *
     * @param tamano tamaño en mb a partir del cual se borraran todos los
     * ficheros mayores.
     * @return El numero de ficheros borrados.
     * @throws
     * practicaad1._limpiezadediscos.Logica.MisExcepciones.NoExisteDirectorio
     */
    public int eliminarFicherosPorTamaño(int tamano) throws MisExcepciones.NoExisteDirectorio {
        int contadorBorrados = 0;
        File[] ficheros = Filtros.filtrarFicherosTamanoMinimo(getUnidadSeleccionada().getPath(), tamano * 1048576);

        if (ficheros.length > 0) {
            for (File fichero : ficheros) {
                log += "Borrando " + fichero.getAbsolutePath() + "\n";
                fichero.delete();
                contadorBorrados++;
            }
        }

        return contadorBorrados;
    }

    /**
     * Metodo que borra todos los ficheros cuya ultima modificacion hace tantos
     * dias o mas como el numero de dias que se le pasa por parametro.
     *
     * @param dias numero de dias a partir del cual se borraran los ficheros.
     * @return El numero de ficheros borrados.
     * @throws
     * practicaad1._limpiezadediscos.Logica.MisExcepciones.NoExisteDirectorio
     */
    public int eliminarFicherosAntiguos(int dias) throws MisExcepciones.NoExisteDirectorio {
        int contadorBorrados = 0;
        File[] ficheros = Filtros.filtrarFicherosModificadosUltimas24H(getUnidadSeleccionada().getPath(), dias);

        if (ficheros.length > 0) {
            for (File fichero : ficheros) {
                log += "Borrando " + fichero.getAbsolutePath() + "\n";
                fichero.delete();
                contadorBorrados++;
            }
        }

        return contadorBorrados;
    }

    /**
     * Metodo privado auxiliar cuya funcion es buscar todas las carpetas vacias
     * recursivamente añadiendolas a la lista de File resultado.
     *
     * @param carpetaRaiz directorio a partir del cual se buscaran los
     * directorios vacios.
     * @return Una lista de ficheros en la que se encuentran los directorios
     * vacios a partir de la carpetaRaiz.
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
     * Metodo que elimina todos los directorios vacios que recive del metodo
     * privado buscaCarpetasVacias al que se llama dentro de este metodo.
     *
     * @return Numero de directorios borrados por estar vacios.
     */
    public int eliminarDirectoriosVaciosRecursivo() {
        int contadorBorrados = 0;
        List<File> listaCarpetasVacias = buscaCarpetasVacias(unidadSeleccionada);
        //de la implementación anterior, sabemos que
        //el método por lo menos retornará una lista vacía
        //no necesitamos hacer una validaciób en caso de nulos
        for (File directorio : listaCarpetasVacias) {
            log += "Borrando " + directorio.getAbsolutePath() + "\n";
            directorio.delete();
            contadorBorrados++;
        }
        return contadorBorrados;
    }

    public List<File> getArchivosDuplicados() {
        List<File> duplicados = new ArrayList<>();

        List<File> listaArchivosDisco = listarArchivosRecursivo(getUnidadSeleccionada());

        Collections.sort(duplicados, new Comparator<File>() {
            @Override
            public int compare(File file1, File file2) {
                return file1.getName().compareTo(file2.getName());
            }
        });

        for (int pos = 0; pos < listaArchivosDisco.size() - 1; pos++) {
            if (CompareFiles(listaArchivosDisco.get(pos), listaArchivosDisco.get(pos + 1))) {
                duplicados.add(listaArchivosDisco.get(pos));
            }
        }

        return duplicados;

    }

    private List<File> listarArchivosRecursivo(File carpetaRaiz) {
        List<File> resultado = new ArrayList<>();

        File[] archivos = carpetaRaiz.listFiles();

        for (File archivo : archivos) {
            if (archivo.isDirectory()) {
                resultado.addAll(listarArchivosRecursivo(archivo));
            } else {
                resultado.add(archivo);
            }
        }

        return resultado;
    }

    private boolean CompareFiles(File archivoA, File archivoB) {

        try {
            byte[] f1 = Files.readAllBytes(archivoA.toPath());
            byte[] f2 = Files.readAllBytes(archivoB.toPath());

            return Arrays.equals(f1, f2);
        } catch (IOException ex) {
            Logger.getLogger(GestionLimpiezaDiscos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    public void deleteFiles(List<File> archivos){
         for (File file : archivos) {
                file.delete();
            }
    }
}
