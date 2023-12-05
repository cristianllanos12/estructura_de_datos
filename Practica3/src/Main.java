import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();

        // Agrega 10 nodos con números aleatorios a la lista
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            lista.agregarNodo(random.nextInt(100));
        }

        // Muestra la lista original
        lista.imprimirLista("Lista Original");

        // Ordena la lista
        lista.ordenarLista();

        // Muestra la lista ordenada
        lista.imprimirLista("Lista Ordenada");
    }
}