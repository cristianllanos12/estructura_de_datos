import java.util.Random;

public class Main {
        public static ListaEnlazada generarListaAleatoria(int n) {
            ListaEnlazada lista = new ListaEnlazada();
            Random rand = new Random();
            for (int i = 0; i < n; i++) {
                int valor = rand.nextInt(100) + 1;
                lista.agregarElemento(valor);
            }
            return lista;
        }

        public static void main(String[] args) {
            // Generar lista aleatoria
            ListaEnlazada listaAleatoria = generarListaAleatoria(10);

            System.out.println("Lista aleatoria:");
            listaAleatoria.imprimirLista();

            // Ordenar lista
            listaAleatoria.ordenarLista();

            System.out.println("\nLista ordenada:");
            listaAleatoria.imprimirLista();
    }
}