public class ListaEnlazada {
    Nodo head;

    public ListaEnlazada() {
        this.head = null;
    }

    public void agregarElemento(int valor) {
        Nodo nuevoNodo = new Nodo(valor);
        nuevoNodo.siguiente = head;
        head = nuevoNodo;
    }

    public void imprimirLista() {
        Nodo actual = head;
        while (actual != null) {
            System.out.print(actual.valor + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    public void ordenarLista() {
        Nodo actual = head;
        while (actual != null) {
            Nodo siguiente = actual.siguiente;
            while (siguiente != null) {
                if (actual.valor > siguiente.valor) {
                    int temp = actual.valor;
                    actual.valor = siguiente.valor;
                    siguiente.valor = temp;
                }
                siguiente = siguiente.siguiente;
            }
            actual = actual.siguiente;
        }
    }
}


