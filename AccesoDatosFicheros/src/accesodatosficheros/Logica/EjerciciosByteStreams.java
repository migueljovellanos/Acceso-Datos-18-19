/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatosficheros.Logica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author migue
 */
public class EjerciciosByteStreams {

    public EjerciciosByteStreams() {
    }

    public String leerArchivoTxt(String ruta) {

        StringBuilder texto = new StringBuilder();
        File file = new File(ruta);
        if (file.isFile() && file.toString().endsWith(".txt")) {
            try {
                FileInputStream fis = new FileInputStream(file);
                int content;

                while ((content = fis.read()) != -1) {
                    texto.append((char) content);
                }
                fis.close();

            } catch (FileNotFoundException ex) {
                Logger.getLogger(EjerciciosByteStreams.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(EjerciciosByteStreams.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return texto.toString();
    }

    /**
     * Metodo que cifra o descifra un mensaje dependiendo del boolean
     *
     * @param textoACifrar texto que se desea cifrar o descifrar
     * @param codigoCifrado numero de caracteres que se desplaza cada caracter
     * @param descifrar boolean que indica si deseas cifrar o descifrar el texto
     * @return el mensaje cifrado o descifrado dependiendo del parametro
     * descifrar
     */
    public String cifradoCesar(String textoACifrar, int codigoCifrado, boolean descifrar) {
        StringBuilder cifrado = new StringBuilder();
        if (descifrar) {
            codigoCifrado = -codigoCifrado;
        }
        for (int i = 0; i < textoACifrar.length(); i++) {
            if ((textoACifrar.charAt(i) >= 'a' && textoACifrar.charAt(i) <= 'z') || (textoACifrar.charAt(i) >= 'A' && textoACifrar.charAt(i) <= 'Z')) {
                cifrado.append((char) (((textoACifrar.charAt(i) + 26 + codigoCifrado - 65) % 26) + 65));
            } else {
                cifrado.append((char) (textoACifrar.charAt(i)));
            }
        }
        return cifrado.toString();
    }

    public Map<Character, Integer> contarDensidadDeCadaLetra(File fichero, File ficheroGrafica) throws MisExcepciones.NoExisteDirectorio, FileNotFoundException, IOException {
        Map<Character, Integer> distribucionLetras = new HashMap<Character, Integer>();
        if (!fichero.exists()) {
            throw new MisExcepciones.NoExisteDirectorio();
        }
        FileReader fr = new FileReader(fichero);
        BufferedReader br = new BufferedReader(fr);
        String lineaLeida = br.readLine();
        while (lineaLeida != null) {
            for (int i = 0; i < lineaLeida.length(); i++) {

                char letraLeida = Character.toLowerCase(lineaLeida.charAt(i));

                Map<Character, Character> tablaReemplazos = new HashMap<>();
                tablaReemplazos.put('á', 'a');
                tablaReemplazos.put('é', 'e');
                tablaReemplazos.put('í', 'i');

                if (tablaReemplazos.get(letraLeida) != null) {
                    letraLeida = tablaReemplazos.get(letraLeida);
                }

                if (Character.isAlphabetic(letraLeida)) {
                    if (!distribucionLetras.containsKey(letraLeida)) {
                        distribucionLetras.put(letraLeida, 1);
                    } else {
                        distribucionLetras.put(letraLeida, distribucionLetras.get(letraLeida) + 1);

                    }
                }
            }
            lineaLeida = br.readLine();
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroGrafica));
        String labels = "";
        String datos = "";
        for (Map.Entry<Character, Integer> entry : distribucionLetras.entrySet()) {
            Character llave = entry.getKey();
            Integer valor = entry.getValue();
            labels = labels.concat("\"" + llave + "\",");
            datos = datos.concat(valor.toString().concat(", "));

        }

        bw.write("<!doctype html>\n"
                + "<html>\n"
                + "    <head>\n"
                + "        <title>Histograma Letras</title>\n"
                + "        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js\"></script>\n"
                + "        <style>\n"
                + "\n"
                + "        </style>\n"
                + "    </head>\n"
                + "    <body>\n"
                + "        <div id=\"container\" style=\"width: 100%;\">\n"
                + "            <canvas id=\"myChart\"></canvas>\n"
                + "        </div>    \n"
                + "        <script>\n"
                + "            var ctx = document.getElementById('myChart').getContext('2d');\n"
                + "            var chart = new Chart(ctx, {\n"
                + "                // The type of chart we want to create\n"
                + "                type: 'line',\n"
                + "\n"
                + "                // The data for our dataset\n"
                + "                data: {\n"
                + "                    labels: [" + labels + "],\n"
                + "                    datasets: [{\n"
                + "                            label: \"Histograma Letras\",\n"
                + "                            backgroundColor: 'rgb(255, 0, 132)',\n"
                + "                            borderColor: 'rgb(255, 99, 132)',\n"
                + "                            data: [" + datos + "],\n"
                + "                        }]\n"
                + "                },\n"
                + "\n"
                + "                // Configuration options go here\n"
                + "                options: {}\n"
                + "            });\n"
                + "        </script>\n"
                + "\n"
                + "    </body>\n"
                + "\n"
                + "</html>");

        bw.flush();
        bw.close();
        return distribucionLetras;
    }

}
