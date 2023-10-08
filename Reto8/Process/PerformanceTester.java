package Reto8.Process;

import Reto8.Utils.Sorter;
import java.util.Arrays;

/**
 * Aquí vemos que los sorters funcionen
 */
public class PerformanceTester {
    public static int COMPARACIONES = 0;
    public static int MOVIMIENTOS = 0;

    /**
     * Aquí calculamos el rendimiento de los sorters 
     * @param sorter
     */
    public static void testPerformance(Sorter sorter) {
        final int RANGO = 1_000;
        final int ITERACIONES = 500;
        final int INCREMENTOS = 100;

        double[][] performanceResults = new double[RANGO / INCREMENTOS][2];
        for (int N = 1, k = 0; N <= RANGO; N += INCREMENTOS, k++) {

            COMPARACIONES = 0;
            MOVIMIENTOS = 0;
            for (int i = 0; i < ITERACIONES; i++) {
                int[] array = Sorter.getRandomArray(N, Short.MIN_VALUE, Integer.MAX_VALUE);
                sorter.sort(array);

            }
            performanceResults[k][0] += sorter.getCOMPARACIONES();
            performanceResults[k][1] += sorter.getMOVIMIENTOS();
            performanceResults[k][0] = performanceResults[k][0] / ((double) ITERACIONES);
            performanceResults[k][1] = performanceResults[k][1] / ((double) ITERACIONES);
        }


        System.out.println("{algoritmo}: ");
        System.out.println(performanceResults.length);
        for(double[] results: performanceResults)
            System.out.println(Arrays.toString(results).replace("[","").replace("]","").replace(",",""));
    }
}
