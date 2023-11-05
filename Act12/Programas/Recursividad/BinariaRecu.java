package Act12.Programas.Recursividad;

public class BinariaRecu {
    public static void main(String[] args) {
        int A [] = {1,2,3,4,5,6,7,8,9};
        int j = BinariaRecu(A, 8, 0, A.length-1);
        if (j== -1){
            System.out.println("El valor no es valido");
        }else {
            System.out.println("El dato se encuentra en: " + j);
        }


    }

    public static int BinariaRecu (int [] A,int x, int ini, int fin){
        int mid = ((ini + fin)/2);

        if (A[mid] == x){
            return mid + 1;
        }
        if (ini > fin){
            return -1;
        }

        if (x < A[mid]){
            return BinariaRecu(A, x, ini, mid -1);
        }else {
            return BinariaRecu(A, x, mid + 1, fin);
        }
    }
}
