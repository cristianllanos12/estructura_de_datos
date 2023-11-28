import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MaxHeap map= new MaxHeap();
        Scanner tec= new Scanner(System.in);
        int num;
        System.out.println("-1 para salir");
        do {
            System.out.print("Ingrese un numero: ");
            num= tec.nextInt();
            map.ingresarNum(num);
            map.printHeap();
        }while(num!=-1);


    }
}