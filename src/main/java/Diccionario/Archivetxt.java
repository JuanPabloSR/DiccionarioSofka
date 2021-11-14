package Diccionario;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Archivetxt {
    public static String nombreArchivo = "document.txt";
    private Dictionary dictionary;
    public static ArrayList<Dictionary> listWords = new ArrayList<>();

    public void addWord (String spanish, String english){
        if (!existWord(spanish,english)){
            dictionary = new Dictionary(spanish,english);
            listWords.add(dictionary);
            try {
                FileWriter writer = new FileWriter(nombreArchivo,true);
                writer.write("\r\n" + spanish + " = "+ english);
                writer.close();
            } catch (IOException e) {
                System.out.println("Escriba 1texto");
            }
        }
    }

    public void searchWord(String word){
        for (Dictionary p : listWords){
            if (p.getSpanish().equals(word)) {
                System.out.println("Traduccion: "+p.getEnglish());
            }
        }
    }

    public void showAllWords(){
        System.out.println("LISTADO");
        listWords.forEach(System.out::println);

    }

    private boolean existWord(String spanish, String english){
        Boolean exist = false;
        for (Dictionary dictionary : listWords){
            if (dictionary.getSpanish().equals(spanish) && dictionary.getEnglish().equals(english)){
                exist = true;
            }
        }
        return exist;
    }

}
