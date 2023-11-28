public class Main {
    public static void main(String[] args) {


        Arbol arbol = new Arbol();
        arbol.insertar(4);
        arbol.insertar(2);
        arbol.insertar(25);
        arbol.insertar(6);
        arbol.insertar(1);
        arbol.insertar(3);
        arbol.insertar(5);
        arbol.insertar(37);
        arbol.insertar(7);
        arbol.insertar(8);
        arbol.insertar(9);
        arbol.insertar(15);

        // Mostrar el contenido de los nodos en orden ascendente
        System.out.print("Contenido de los nodos en orden ascendente: ");
        arbol.mostrarEnOrden();
        System.out.println();

        // Obtener el número de nodos en el árbol
        int numeroDeNodos = arbol.contarNodos();
        System.out.println("Número de nodos en el árbol: " + numeroDeNodos);
    }
}
