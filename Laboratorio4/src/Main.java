import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ListNode lista1 = new ListNode(0);
        ListNode lista2 = new ListNode(0);

        rellenarListasConNumerosAleatorios(lista1, lista2, 10);

        System.out.println("Lista Original 1:");
        printLinkedList(lista1);

        System.out.println("\nLista Original 2:");
        printLinkedList(lista2);

        ListNode listaOrdenada1 = ListaEnlazada.ordenarLista(lista1);
        ListNode listaOrdenada2 = ListaEnlazada.ordenarLista(lista2);

        System.out.println("\nLista Ordenada 1:");
        printLinkedList(listaOrdenada1);

        System.out.println("\nLista Ordenada 2:");
        printLinkedList(listaOrdenada2);

    }

    private static void printLinkedList(ListNode lista1) {

    }

    public static void rellenarListasConNumerosAleatorios(ListNode lista1, ListNode lista2, int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            int numeroAleatorio1 = (int) (Math.random() * 100) + 1; // Números aleatorios entre 1 y 100
            lista1 = InsertarAlFinal(lista1, numeroAleatorio1);

            int numeroAleatorio2 = (int) (Math.random() * 100) + 1; // Generar otro número aleatorio para la segunda lista
            lista2 = insertarAlFinal(lista2, numeroAleatorio2);
        }

        public static ListNode createLinkedList; boolean numbers = false;{
        (ArrayList < Integer > numbers) {
            if (numbers.isEmpty()) {
                return null;
            }
        }
    }


    public static ListNode createLinkedList(ArrayList<Integer> numbers) {
        if (numbers.isEmpty()) {
            return null;
        }

        ListNode head = new ListNode(numbers.get(0));
        ListNode current = head;

        for (int i = 1; i < numbers.size(); i++) {
            ListNode newNode = new ListNode(numbers.get(i));
            current.next = newNode;
            current = newNode;
        }

        return head;
    }

    public static ListNode ordenarLista(ListNode lista) {
        ArrayList<Integer> values = new ArrayList<>();
        ListNode current = lista;

        while (current != null) {
            values.add(current.val);
            current = current.next;
        }

        values.sort(null); // Ordenar la lista de valores

        current = lista;
        for (Integer val : values) {
            current.val = val;
            current = current.next;
        }

        return lista;
    }


}