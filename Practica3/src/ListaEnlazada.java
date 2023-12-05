import java.util.ArrayList;
import java.util.Collections;

public class ListaEnlazada {
    Nodo cabeza;

    // Constructor
    public ListaEnlazada() {
        this.cabeza = null;
    }

    // Método para agregar un nodo a la lista
    public void agregarNodo(int elemento) {
        Nodo nuevoNodo = new Nodo(elemento);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo temp = cabeza;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevoNodo;
        }
    }

    // Método para ordenar la lista
    public void ordenarLista() {
        ArrayList<Integer> elementos = new ArrayList<>();
        Nodo temp = cabeza;

        // Almacena los elementos en un ArrayList
        while (temp != null) {
            elementos.add(temp.elemento);
            temp = temp.siguiente;
        }

        // Ordena el ArrayList
        Collections.sort(elementos);

        // Reconstruye la lista enlazada con los elementos ordenados
        cabeza = null;
        for (int elemento : elementos) {
            agregarNodo(elemento);
        }
    }

    // Método para imprimir la lista en consola
    public void imprimirLista(String mensaje) {
        System.out.print(mensaje + ": ");
        Nodo temp = cabeza;
        while (temp != null) {
            System.out.print("Nodo" + temp.elemento + " ");
            temp = temp.siguiente;
        }
        System.out.println();
    }
}
