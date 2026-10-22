import java.util.*;

public class ContadorCaracteres {
    public static java.util.concurrent.atomic.AtomicInteger contadorCompartido = new java.util.concurrent.atomic.AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Character[] consonantes = new Character[5];

        System.out.print("Ingrese un texto: ");
        String texto = scanner.nextLine();

        for (int i = 0; i < consonantes.length; i++){
            System.out.print("Ingresa consonante (" + (consonantes.length - i) + " restantes): ");
            Character respuesta = scanner.next().charAt(0);

            if (!Arrays.asList('a','e','i','o','u','1','2','3','4','5','6','7','8','9','0').contains(respuesta)){
                consonantes[i] = respuesta;
            } else {
                System.out.println("Error: Debe ingresar una consonante.");
                i--;
            }
        }

        List<Thread> hilos = new ArrayList<>();

        for (Character consonante : consonantes){
            Thread nuevoHilo = crearYIniciarHilo(consonante, texto);
            hilos.add(nuevoHilo);
        }

        for (Thread hilo : hilos) {
            hilo.join();
        }

        // Ahora este mensaje se imprimirá estrictamente al final
        System.out.println("Total de consonantes: " + contadorCompartido.get());
    }

    public static Thread crearYIniciarHilo(Character c, String texto) {
        Thread hilo = new Thread(() -> {
            int contador = 0;
            for (int i = 0; i < texto.length(); i++) {
                if (texto.charAt(i) == c) {
                    contador++;
                    contadorCompartido.incrementAndGet();
                }
            }
            System.out.println("La consonante '" + c + "' aparece " + contador + " veces en el texto.");
        });
        hilo.start();
        return hilo;
    }
}
