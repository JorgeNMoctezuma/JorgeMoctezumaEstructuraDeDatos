package Reto8.Utils;

import java.util.Arrays;
import java.util.Random;

public abstract class Sorter {

    protected int COMPARACIONES = 0;
    protected int MOVIMIENTOS = 0;

    public abstract void sort(int[]N);
    public static int [] getRandomArray(int n, int minVal, int maxVal) {
        Random random = new Random();
        return random.ints(n,minVal,maxVal).toArray();
    }

    public static void swap (int[] N, int i, int j){
        int tmp = N[i];
        N[i] = N[j];
        N[j] = tmp;
    }

    private static void printArray (int[] N){
        System.out.println(Arrays.toString(N));
    }
    public static boolean isSorted(int[] N){
        for (int i = 0; i < N.length - 1; i++){
            if (N[i] > N[i + 1]){
                return false;
            }
        }
        return true;
    }

    public int getCOMPARACIONES(){
        return COMPARACIONES;
    }
    public int getMOVIMIENTOS(){
        return MOVIMIENTOS;
    }
    public enum SorterMethods {
        BUBBLE,SELECTION,INSERTION,SHELL,MERGE,QUICK,HEAP,BINARIO,SECUENCIAL
    }
}
