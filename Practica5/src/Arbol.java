public class Arbol {
    Nodo raiz;

    public Arbol() {
        this.raiz = null;
    }

    public void mostrarEnOrden() {
        mostrarEnOrden(raiz);
    }

    private void mostrarEnOrden(Nodo nodo) {
        if (nodo != null) {
            mostrarEnOrden(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            mostrarEnOrden(nodo.derecho);
        }
    }

    public void insertar(int valor) {
        raiz = insertar(raiz, valor);
    }

    private Nodo insertar(Nodo nodo, int valor) {
        if (nodo == null) {
            return new Nodo(valor);
        }

        if (valor < nodo.valor) {
            nodo.izquierdo = insertar(nodo.izquierdo, valor);
        } else if (valor > nodo.valor) {
            nodo.derecho = insertar(nodo.derecho, valor);
        }

        return nodo;
    }

    public int contarNodos() {
        return contarNodos(raiz);
    }

    private int contarNodos(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }

        int contador = 1;
        contador += contarNodos(nodo.izquierdo);
        contador += contarNodos(nodo.derecho);

        return contador;
    }
}



