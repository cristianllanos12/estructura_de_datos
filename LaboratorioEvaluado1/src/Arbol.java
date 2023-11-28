import java.util.LinkedList;
public class Arbol {

    Nodo raiz;

    public Arbol() {
        raiz = null;
    }

    public LinkedList<Nodo> nodosAltura(int h) {
        LinkedList<Nodo> nodos = new LinkedList<>();
        nodosAltura(raiz, h, nodos);
        return nodos;
    }

    private void nodosAltura(Nodo nodo, int h, LinkedList<Nodo> result) {
        if (nodo == null) {
            return;
        }
        int alturaActual=altura(nodo)-1;
        if (alturaActual == h) {
            result.add(nodo);
        } else {
            nodosAltura(nodo.izquierdo, h, result);
            nodosAltura(nodo.derecho, h, result);
        }
    }
    public int contarNodosEnAltura(int h) {
        LinkedList<Nodo> nodosEnAltura = nodosAltura(h);
        return nodosEnAltura.size();
    }
    public int altura(Nodo r){
        if(r==null)return 0;
        int left=altura(r.izquierdo);
        int right=altura(r.derecho);
        if(left>right)return (left+1);
        return (right+1);
    }

    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    private Nodo insertarRecursivo(Nodo nodo, int valor) {
        if (nodo == null) {
            return new Nodo(valor);
        }

        if (valor < nodo.valor) {
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, valor);
        } else if (valor > nodo.valor) {
            nodo.derecho = insertarRecursivo(nodo.derecho, valor);
        }

        return nodo;
    }
}



