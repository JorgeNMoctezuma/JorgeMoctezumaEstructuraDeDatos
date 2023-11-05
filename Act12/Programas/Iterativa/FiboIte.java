package Act12.Programas.Iterativa;
import java.util.Scanner;

public class FiboIte {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = 0;
        int b = 1;
        int c;
        int num;

        System.out.println("Qué numero de elemetos tendrá el metodo?");
        num = scanner.nextInt();

        for (int i = 0; i < num; i++){
            System.out.println(a);
            c = a + b;
            a = b;
            b = c;
        }
    }

}

