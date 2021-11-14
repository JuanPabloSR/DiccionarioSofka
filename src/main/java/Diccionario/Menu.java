package Diccionario;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
public class Menu {
    private int opcion = 0;
    private String spanish = "", english = "";

    public void iniciar() {
        Scanner sc;
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader leerTexto = new BufferedReader(inputStreamReader);
        Archivetxt utils = new Archivetxt();
        Translate archivo = new Translate();
        try {
            archivo.leerDiccionario();
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }
        boolean exit = true;
        try {
            do {
                System.out.println("traductor de Español a Ingles");

                System.out.println("\nElija una opcion:");
                System.out.println("\n1. Ingresar una palabra\n" + "2. Buscar por palabra\n" + "3. ver todo el diccionario\n" + "4. " + "Salir\n");
                sc = new Scanner(System.in);
                opcion = sc.nextInt();
                if (opcion == 1) {
                    System.out.println("Ingrese la palabra en español y luego su traducción en ingles");
                    spanish = leerTexto.readLine();
                    english = leerTexto.readLine();
                    utils.addWord(spanish.toLowerCase(), english.toLowerCase());
                } else if (opcion == 2) {
                    System.out.println("Ingrese la palabra a buscar: ");
                    spanish = leerTexto.readLine();
                    utils.searchWord(spanish.toLowerCase());
                } else if (opcion == 3) {
                    utils.showAllWords();
                } else if (opcion == 4) {
                    exit = false;
                } else {
                    System.out.println("seleccione una opcion correcta");
                }
            } while (exit);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
