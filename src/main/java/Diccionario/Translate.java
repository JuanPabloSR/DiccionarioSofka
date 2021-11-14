package Diccionario;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Translate {

    private String traducccion = "";
    private Dictionary diccionario;
    public void leerDiccionario() throws FileNotFoundException {
        FileReader leerArchivo = new FileReader(Archivetxt.nombreArchivo);
        BufferedReader leer = new BufferedReader(leerArchivo);

        while (traducccion != null) {
            try {
                traducccion = leer.readLine();
                if (traducccion == null) {
                    break;
                }else{
                    if (!traducccion.isBlank()){
                        String[] words = traducccion.split("=");
                        diccionario = new Dictionary(words[0].trim(),words[1].trim());
                        Archivetxt.listWords.add(diccionario);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
