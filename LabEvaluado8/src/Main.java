//Llanos Cristian

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ColaBinomial b = new ColaBinomial();
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        System.out.println("Ingrese los nodos uno por uno (ingrese -1 para terminar):");
           try {
               while (true) {
                   System.out.print("Ingrese un valor (-1 para terminar): ");
                   n = scanner.nextInt();

                   if (n == -1) {
                       break;
                   } else {
                       b.Insert(n);
                       b.print();
                   }
               }

           } catch (InputMismatchException e) {
               System.out.println("Solo se pueden ingresar numeros");
               n=0;
           }

        System.out.println("Cola Binomial resultante:");
        b.print();
        System.out.println("cantidad de nodos en la cola binomial = " + b.size());
    }

}


