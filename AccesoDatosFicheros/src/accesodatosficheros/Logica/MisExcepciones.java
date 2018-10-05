/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatosficheros.Logica;

/**
 *
 * @author migue
 */
public class MisExcepciones {

    /**
     * Excepcion que se lanza si la ruta que se paso como parametro no es un directorio
     */
    public static class NoEsDirectorio extends Exception {

        public NoEsDirectorio() {
            super();
        }
    }

    /**
     * Excepcion que se lanza si el directorio no existe
     */
    public static class NoExisteDirectorio extends Exception {

        public NoExisteDirectorio() {
            super("El directorio introducido no existe");
        }
    }

    /**
     * Excepcion que se lanza si el directorio ya existe
     */
    public static class DirectorioYaExistente extends Exception {

        public DirectorioYaExistente() {
            super("El directorio introducido ya existe");
        }
    }

    /**
     * Excepcion que se lanza si el directorio no se puede leer
     */
    public static class NoPuedoLeer extends Exception {

        public NoPuedoLeer() {
            super("El directorio introducido no se puede leer");
        }
    }

    /**
     * Excepcion que se lanza si el directorio esta oculto
     */
    public static class EstaOculto extends Exception {

        public EstaOculto() {
            super("El directorio introducido esta oculto");
        }
    }
    
}
