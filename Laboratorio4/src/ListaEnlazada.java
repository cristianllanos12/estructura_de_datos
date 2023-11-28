public class ListaEnlazada {

    private ListNode head;
    private ListNode back;
    private int size;

    public ListaEnlazada(){
        this.head = null;
        this.back = null;
        this.size = 0;
    }
    public static ListNode crearListaMayoresAlPromedio(ListNode lista1, ListNode lista2) {
        double promedio = calcularPromedio(lista1, lista2);
        ListNode result = null;

        // Recorremos la primera lista enlazada y agregamos los elementos mayores al promedio
        ListNode current1 = lista1;
        while (current1 != null) {
            if (current1.val > promedio) {
                result = insertarOrdenado(result, current1.val);
            }
            current1 = current1.next;
        }

        // Recorremos la segunda lista enlazada y agregamos los elementos mayores al promedio
        ListNode current2 = lista2;
        while (current2 != null) {
            if (current2.val > promedio) {
                result = insertarOrdenado(result, current2.val);
            }
            current2 = current2.next;
        }

        return result;
    }

    public static double calcularPromedio(ListNode lista1, ListNode lista2) {
        int total = 0;
        int count = 0;

        // Recorremos la primera lista enlazada
        ListNode current1 = lista1;
        while (current1 != null) {
            total += current1.val;
            count++;
            current1 = current1.next;
        }

        // Recorremos la segunda lista enlazada
        ListNode current2 = lista2;
        while (current2 != null) {
            total += current2.val;
            count++;
            current2 = current2.next;
        }

        if (count == 0) {
            return 0; // Evitar la división por cero
        } else {
            return (double) total / count;
        }
    }

    public static ListNode insertarOrdenado(ListNode lista, int valor) {
        ListNode nuevoNodo = new ListNode(valor);
        if (lista == null) {
            return nuevoNodo;
        }

        if (valor < lista.val) {
            nuevoNodo.next = lista;
            return nuevoNodo;
        }

        ListNode current = lista;
        while (current.next != null && current.next.val < valor) {
            current = current.next;
        }

        nuevoNodo.next = current.next;
        current.next = nuevoNodo;
        return lista;
    }

    public static ListNode ordenarLista(ListNode lista) {
        ListNode sortedList = null;
        ListNode current = lista;

        while (current != null) {
            sortedList = insertarOrdenado(sortedList, current.val);
            current = current.next;
        }

        return sortedList;
    }

    public static void mostrarListaOrdenada(ListNode lista, String nombre) {
        ListNode current = lista;

        System.out.print(nombre + " Ordenada: ");
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
    public void insertarNodo(int elemento){
        ListNode newNodo = new ListNode(elemento);
        newNodo.next = head;
        if(head != null){
            head.former = newNodo;
        }else{
            this.back = newNodo;
        }
        this.head = newNodo;
        this.head.pos = size;
        this.size++;
    }


}
