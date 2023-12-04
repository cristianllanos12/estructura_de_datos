import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Construyendo un árbol n-ario. Ingrese los nodos (Presione 'A' para finalizar).");

        Arbol<String> root = Arbol.insertNodeByInput(scanner);

        int numberOfLeaves = Arbol.countLeaves(root);
        System.out.println("Número de hojas en el árbol: " + numberOfLeaves);
    }
    }
