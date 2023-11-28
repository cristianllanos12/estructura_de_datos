import java.util.Arrays;

public class MaxHeap {

    private int length = 10;
    private int size = 0;
    private int [] items = new int[length];


    public MaxHeap(int [] A) {
        // Build heap
        items = A;
        size = A.length;
        length = A.length;
        buildHeap();

        duplicateCapacity();
    }

    public MaxHeap() {

    }

    public void printHeap() {
        for(int i = 0; i< size; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    public int top() {
        // get items[0]
        if(size > 0)	return items[0];
        else return -1;
    }

    public int delete() {
        // get items[0] and delete it
        if(size > 0) {
            int item = items[0];
            items[0] = items[size-1];
            size--;
            heapify(0);
            return item;
        }
        return -1;
    }

    private void duplicateCapacity(){
        // duplicate the capacity of the array
        if(size == length) {
            items = Arrays.copyOf(items, length*2);
            length *= 2;
        }
    }
    public void ingresarNum(int num){
        items[size]=num;
        if(size==length-1){
            duplicateCapacity();
        }
        size+=1;
        buildHeap();
    }
    private void heapify(int i) {
        int parent=i;
        int hijoIzquierdo=leftChild(i);
        int hijoDerecho= rightChild(i);

        if(hijoDerecho<=items.length-1){

            if(items[hijoDerecho]>items[i]&&items[hijoDerecho]>items[hijoIzquierdo]){
                parent=hijoDerecho;

                if(items[i]>items[hijoIzquierdo]){

                    swap(hijoIzquierdo, parent);

                }
            }else if(items[hijoIzquierdo]>items[i]&&items[hijoIzquierdo]>items[hijoDerecho]){

                parent=hijoIzquierdo;
            }
        }else if(hijoIzquierdo<=items.length-1&&items[hijoIzquierdo]>items[i]){

            parent = hijoIzquierdo;
        }
        if (parent!=i){
            swap(i,parent);
            heapify(parent);
        }


    }
    public int extractMax() {
        if (size == 0) {
            throw new IllegalStateException("El heap está vacío");
        }

        int max = items[0]; // El nodo superior (el más grande).
        items[0] = items[size - 1]; // Reemplaza el nodo superior con el último nodo.
        size--;

        heapify(0); // Llama a heapify para restaurar la propiedad del MaxHeap.

        return max;
    }

    public int[] heapSort() {
        int[] sortedArray = new int[size];
        int originalSize = size;

        for (int i = 0; i < originalSize; i++) {
            int max = extractMax();
            sortedArray[i] = max;
        }

        return sortedArray;
    }

    private void buildHeap() {
        // Given an array, get the heap
        for(int i = size/2; i >= 0; i--) {
            heapify(i);
        }
    }

    private int parent(int i) {
        return (i-1)/2;
    }
    private int leftChild(int i) {
        return 2*i+1;
    }
    private int rightChild(int i) {
        return 2*i+2;
    }
    private void swap(int i, int j) {
        int temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

}

