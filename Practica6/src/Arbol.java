import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Arbol<T> {
    T data;
    List<Arbol<T>> children;

    Arbol(T data) {
        this.data = data;
        children = new ArrayList<>();
    }

    public static int countLeaves(Arbol<?> root) {
        if (root == null) {
            return 0;
        }

        if (root.children.isEmpty()) {
            return 1;
        }

        int leafCount = 0;
        for (Arbol<?> child : root.children) {
            leafCount += countLeaves(child);
        }

        return leafCount;
    }

    public static Arbol<String> insertNodeByInput(Scanner scanner) {

        System.out.print("Ingrese el valor del nodo (o 'A' para salir): ");
        String value = scanner.nextLine();
        String fin = "A";

        if (value.equals(fin)) {
            return null;
        }

        Arbol<String> node = new Arbol<>(value);

        while (true) {
            Arbol<String> child = insertNodeByInput(scanner);
            if (child == null) {
                break;
            }
            node.children.add(child);
        }

        return node;
    }


}




