import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static int[] fillArray(int n) {
        int[] array = new int[n];
        Random rnd = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(n * 10);
        }
        return array;
    }

    public static void bubbleSort(int array[]) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void merge(int array[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /* Copy data to temp arrays */
        for (int i = 0; i < n1; ++i)
            L[i] = array[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = array[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    public static void sort(int array[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sort(array, l, m);
            sort(array, m + 1, r);

            // Merge the sorted halves
            merge(array, l, m, r);
        }
    }

    public static void mergeSort(int array[]) {
        sort(array, 0, array.length - 1);
    }

    public static void print(int array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        ciclo();


    }

    public static void ciclo() {
        int i=0;
        int[] n = new int[]{1000,5000,10000,50000,100000,1000000,5000000,10000000,50000000};

        long[][] data = new long[9][3];


        for ( int n2 : n) {
            int arr1[] = fillArray(n2);
            int arr2[] = fillArray(n2);

            int arr1_1[] = arr1.clone();
            int arr2_1[] = arr2.clone();
            int arr1_2[] = arr1.clone();
            int arr2_2[] = arr2.clone();



            if(i < 5) {
                long startTime = System.nanoTime();
                bubbleSort(arr1);
                long finishTime = System.nanoTime() - startTime;
                data[i][0] = finishTime;
                startTime = System.nanoTime();
                bubbleSort(arr2);
                finishTime = System.nanoTime() - startTime;
                data[i][0] = ((data[i][0] + finishTime) / 2) / 1000;

            }else {
                data[i][0]=0;

            }
            long startTime = System.nanoTime();
            mergeSort(arr1_1);
            long finishTime = System.nanoTime() - startTime;
            data[i][1] = finishTime;

            startTime = System.nanoTime();
            mergeSort(arr2_1);
            finishTime = System.nanoTime() - startTime;
            data[i][1] = ((data[i][1] + finishTime) / 2) / 1000;

            startTime = System.nanoTime();
            Arrays.sort(arr1_2);
            finishTime = System.nanoTime() - startTime;
            data[i][2] = finishTime;

            startTime = System.nanoTime();
            Arrays.sort(arr2_2);
            finishTime = System.nanoTime() - startTime;
            data[i][2] = ((data[i][2] + finishTime) / 2) / 1000;

            
        }
        for (int z = 0; z < data.length; z++) {
            System.out.print("|");
            for (int a = 0; a < data[z].length; a++) {
                if ((z == 5 || z == 6 || z == 7 || z == 8) && a == 0) {
                    System.out.print("---");
                } else {
                    System.out.print(data[z][a]);
                }
                if (a != data[z].length - 1) System.out.print("\t");


            }
            System.out.println("|");
        }
        System.out.println("puedo que el bubble sort es poco eficiente con numeros grandes y al llegas los los ultimos 4 es tan poco eficiente que se pega el computador, mientras que los otros 2 son mas eficicientes en cuanto a velocidada");
    }

}
