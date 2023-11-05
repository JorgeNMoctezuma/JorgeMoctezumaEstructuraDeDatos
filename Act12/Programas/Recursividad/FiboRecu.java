package Act12.Programas.Recursividad;
import java.util.Scanner;

public class FiboRecu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num;

        System.out.println("Qué numero de elemetos tendrá el metodo?");
        num = scanner.nextInt();
        for (int i = 0; i < num; i++){
            System.out.println(fibonacciRec(i));
        }
    }

    public static int fibonacciRec (int num){
        if ((num == 0) || (num == 1)){
            return num;
        }else return fibonacciRec(num - 1 ) + fibonacciRec(num - 2);
    }
}
