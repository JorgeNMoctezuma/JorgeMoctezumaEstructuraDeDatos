package Act12.Programas.Recursividad;

public class FactoRecu {
    public static void main(String[] args) {
        long num = 5L;
        long facto = FactoRec(num);
        System.out.println(facto);
    }


    public static long FactoRec(long n){
        if (n <= 1){
            return n;
        }return n + FactoRec(n - 1);
    }

}
