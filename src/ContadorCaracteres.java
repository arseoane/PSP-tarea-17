import java.util.*;


public class ContadorCaracteres {
    public static void main(String[] args) throws InterruptedException {
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
            caracterHilo(consonante, texto);
        }

        System.out.println("Total de consonantes: " + contadorCompartido);

    }

    public static int contadorCompartido = 0;

    public static void caracterHilo(Character c, String texto) throws InterruptedException {
        Thread hilo = new Thread(() -> {
            int contador = 0;
            for (int i = 0; i < texto.length(); i++) {
                if (texto.charAt(i) == c) {
                    contador++;
                    contadorCompartido++;
                }
            }
            System.out.println("La consonante '" + c + "' aparece " + contador + " veces en el texto.");
        });
        hilo.start();
        hilo.join();
    }
}
