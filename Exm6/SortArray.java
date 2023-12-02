package Exm6;
import java.util.Arrays;
public class SortArray {

    //We start here

    public static void main(String[] args) {

        //Give numbers
        int[] A = {1,7,9};
        int[] B = {2,4,8,0,0,0};
        int N = A.length;
        sortArray(A, B, N);
        System.out.println("Sorted Array: " + Arrays.toString(B));
    }
    public static void sortArray(int[] A, int[] B, int N) {

        //Math
        int i = N - 1;
        int j = N - 1;
        int k = 2 * N - 1;

        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                B[k--] = A[i--];

            } else {
                B[k--] = B[j--];
            }
        }

        while (i >= 0) {
            B[k--] = A[i--];
        }

        while (j >= 0) {
            B[k--] = B[j--];
        }


    }


}
