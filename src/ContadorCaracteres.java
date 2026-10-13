import java.util.*;
import java.io.*;


public class ContadorCaracteres {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Character[] consonantes = new Character[5];

        System.out.print("Ingrese un texto: ");
        String texto = scanner.nextLine();

        for (int i = 0; i < consonantes.length; i++){
            System.out.print("Ingresa consonante (" + (consonantes.length - i) + " restantes): ");
            Character respuesta = scanner.next().charAt(0);

            if (!Arrays.asList('a','e','i','o','u').contains(respuesta)){
                consonantes[i] = respuesta;
            } else {
                System.out.println("Error: Debe ingresar una consonante.");
                i--;
            }
        }

        for (Character consonante : consonantes){
            System.out.print(consonante);
        }

    }

    public static int contarCaracteres(String texto) {
        return texto.length();
    }

    public int caracterHilo(Character c, String texto) {
        Thread hilo = new Thread(() -> {
            int contador = 0;
            for (int i = 0; i < texto.length(); i++) {
                if (texto.charAt(i) == c) {
                    contador++;
                }
            }
        });
        hilo.start();
        return 0;
    }
}
