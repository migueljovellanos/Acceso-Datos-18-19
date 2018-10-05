/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatosficheros.Logica;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author migue
 */
public class OperacionesFicheros {

    public OperacionesFicheros() {
    }

    // EJERCICIO 1
    /**
     * Metodo que lista los ficheros que se encuentran en la ruta que le pasas
     * por parametro. Si no hay ruta busca en la raiz del SO.
     *
     * @param ruta String en el que se pasa la ruta a la que deseas acceder
     * @param ordenadosPorTamano boolean que indica si deseas ordenar los
     * ficheros por tamaño
     * @param soloDirectorios boolean que indica si solo deseas mostrar los
     * directorios directorios
     *
     * @return retorna una lista de Strings en la que se encuentra las rutas
     * absolutas de los directorios o ficheros ademas del tamaño si se marca la
     * opcion de ordenadosPorTamaño
     *
     * @throws MisExcepciones.NoEsDirectorio Excepcion que se lanza si la ruta
     * que se paso como parametro no es un directorio
     *
     */
    public static ArrayList<String> ListarFicheros(String ruta, boolean ordenadosPorTamano, boolean soloDirectorios) throws MisExcepciones.NoEsDirectorio {
        File[] listaFicherosTemporal;
        ArrayList<File> listaFicheros = new ArrayList<>();
        File dir = new File(ruta);
        ArrayList<String> listaString = new ArrayList<>();

        if (ruta.isEmpty()) {
            if (File.listRoots()[0].equals("/")) {
                OperacionesFicheros.ListarFicheros("/", false, true);
            } else {
                OperacionesFicheros.ListarFicheros("C:\\", false, true);
            }
        }

        if (!dir.isDirectory()) {
            throw new MisExcepciones.NoEsDirectorio();
        }

        listaFicherosTemporal = dir.listFiles();
        for (File fichero : listaFicherosTemporal) {
            listaFicheros.add(fichero);
        }

        if (ordenadosPorTamano) {
            Collections.sort(listaFicheros, new Comparator<File>() {
                @Override
                public int compare(File file1, File file2) {
                    return Long.valueOf(file1.length()).compareTo(Long.valueOf(file2.length()));
                }
            }
            );

            for (File fichero : listaFicheros) {
                listaString.add(fichero.getAbsolutePath() + " -- Size : " + fichero.length());
            }

            return listaString;

        } else if (soloDirectorios) {
            for (File fichero : listaFicheros) {
                if (fichero.isDirectory()) {
                    listaString.add(fichero.getAbsolutePath());
                }
            }
            return listaString;
        }
        return null;
    }

    /**
     * Metodo que crea directorios en una ruta que se le pasa por parametro con
     * los nombres que se pasan en un lista
     *
     * @param rutaOrigen ruta en la que quieres que se creen los directorios
     * @param listaDirectorios lista de nombres de directorios que deseas crear
     * @return numero de directorios que se han creado
     * @throws accesodatosficheros.Logica.MisExcepciones.NoExisteDirectorio
     * @throws accesodatosficheros.Logica.MisExcepciones.DirectorioYaExistente
     */
    public static int crearDirectorios(File rutaOrigen, ArrayList<String> listaDirectorios) throws MisExcepciones.NoExisteDirectorio, MisExcepciones.DirectorioYaExistente {
        File dir = rutaOrigen;
        File[] ficherosEnRutaOrigen;
        int contadorDirectoriosCreados = 0;
        if (!dir.exists()) {
            throw new MisExcepciones.NoExisteDirectorio();
        }
        ficherosEnRutaOrigen = dir.listFiles();
        for (String directorioACrear : listaDirectorios) {
            for (File file : ficherosEnRutaOrigen) {
                if (file.getName().equals(directorioACrear)) {
                    throw new MisExcepciones.DirectorioYaExistente();
                }

            }
            File file = new File(directorioACrear);
            file.mkdir();
            contadorDirectoriosCreados++;
        }
        return contadorDirectoriosCreados;
    }

    /**
     * Metodo que cambia la extension de todos los archivos en un ruta que
     * metemos por parametro
     *
     * @param ruta ruta en la que hay que buscar los ficheros a los que les hay
     * que cambiar la extension
     * @param extensionAntigua String que contiene la extension que queremos
     * sustituir
     * @param extensionNueva String que contiene la extension que queremos
     * añaadir
     * @return Contador de ficheros a los que se le ha cambiado la extension
     * @throws accesodatosficheros.Logica.MisExcepciones.NoExisteDirectorio
     */
    public static int cambiarExtensionFicheros(String ruta, String extensionAntigua, String extensionNueva) throws MisExcepciones.NoExisteDirectorio {
        File dir = new File(ruta);
        File[] ficherosEnRutaOrigen;
        int contadorFicherosModificados = 0;
        if (!dir.exists()) {
            throw new MisExcepciones.NoExisteDirectorio();
        }
        ficherosEnRutaOrigen = dir.listFiles();

        for (File file : ficherosEnRutaOrigen) {
            if (file.getAbsolutePath().endsWith(extensionAntigua)) {
                String cadena = file.getAbsolutePath();
                cadena = cadena.replace(extensionAntigua, extensionNueva);
                File fileAux = new File(cadena);
                file.renameTo(fileAux);
                contadorFicherosModificados++;
            }
        }
        return contadorFicherosModificados;
    }

    // EJERCICIO 2
    /**
     * Metodo que lista el contenido de un directorio y de sus subdirectorios
     *
     * @param ruta ruta desde la que quieres listar todo el contenido del
     * directorio y de subdirectorios
     * @throws accesodatosficheros.Logica.MisExcepciones.NoExisteDirectorio
     * @throws accesodatosficheros.Logica.MisExcepciones.NoEsDirectorio
     * @throws IOException
     * @throws accesodatosficheros.Logica.MisExcepciones.NoPuedoLeer
     */
    public static void listarContenidoDirectorio(String ruta) throws MisExcepciones.NoExisteDirectorio, MisExcepciones.NoEsDirectorio, IOException, MisExcepciones.NoPuedoLeer{
        System.out.println("LISTA DE SUBDIRECTORIOS :");
        listarContenidoDirectorioRecursivo(ruta, "");
    }

    /**
     * metodo privado necesario para que listarContenidoDirectorio funcione
     * correctamente
     *
     * @param ruta ruta en la que se buscan los directorios
     * @param separador separador necesario para organizar la vista
     * @throws accesodatosficheros.Logica.MisExcepciones.NoExisteDirectorio
     * @throws accesodatosficheros.Logica.MisExcepciones.NoEsDirectorio
     * @throws IOException
     * @throws accesodatosficheros.Logica.MisExcepciones.NoPuedoLeer
     */
    private static void listarContenidoDirectorioRecursivo(String ruta, String separador) throws MisExcepciones.NoExisteDirectorio, MisExcepciones.NoEsDirectorio, IOException, MisExcepciones.NoPuedoLeer {
        String cadena = separador;
        File dir = new File(ruta);
        File[] ficherosEnRutaOrigen;

        //compruebo si la ruta es un directorio existente
        if (!dir.exists()) {
            throw new MisExcepciones.NoExisteDirectorio();
        }
        if (!dir.isDirectory()) {
            throw new MisExcepciones.NoEsDirectorio();
        }
        if (!dir.canRead()) {
            throw new MisExcepciones.NoPuedoLeer();
        }

        ficherosEnRutaOrigen = dir.listFiles();
        if (ficherosEnRutaOrigen == null) {

        } else {
            for (File fichero : ficherosEnRutaOrigen) {
                System.out.println(cadena + fichero.getPath().replace(ruta, ""));
                if (fichero.isDirectory()) {
                    String nuevo_separador = cadena;
                    String nombreDirectorio = fichero.getName();
                    for (int i = 0; i < nombreDirectorio.length(); i++) {
                        nuevo_separador = nuevo_separador + "-";
                    }
                    listarContenidoDirectorioRecursivo(fichero.getAbsolutePath(), nuevo_separador);
                }

            }
        }
    }

}
