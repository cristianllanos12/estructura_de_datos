import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        System.out.print("ingrese la altura a revisar:");
        int alturaDeseada= tec.nextInt();

        Arbol arbol = new Arbol();

        // Inserta nodos en el árbol
        arbol.insertar(15);
        arbol.insertar(6);
        arbol.insertar(20);
        arbol.insertar(3);
        arbol.insertar(9);
        arbol.insertar(1);
        arbol.insertar(4);
        arbol.insertar(7);
        arbol.insertar(12);
        arbol.insertar(18);
        arbol.insertar(24);
        arbol.insertar(17);



        LinkedList<Nodo> nodosEnAltura = arbol.nodosAltura(alturaDeseada);

        System.out.println("Nodos en altura " + alturaDeseada + ":");
        for (Nodo nodo : nodosEnAltura) {
            System.out.print(nodo.valor + " ");
        }
        System.out.println("");
        int cantidadNodosEnAltura = arbol.contarNodosEnAltura(alturaDeseada);

        System.out.println("Cantidad de nodos en la altura " + alturaDeseada + ": " + cantidadNodosEnAltura);
    }
}