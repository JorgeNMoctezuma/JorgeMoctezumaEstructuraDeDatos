package Reto8;

import Reto8.Process.PerformanceTester;
import Reto8.Process.SorterFactory;
import Reto8.Utils.Sorter;
public class Main {

    /**
     *Llamamos al PerformanceTester
     */
    public static void main(String[] args) {
        PerformanceTester.testPerformance(SorterFactory.getSorter(Sorter.SorterMethods.MERGE));
        System.out.println();
        PerformanceTester.testPerformance(SorterFactory.getSorter(Sorter.SorterMethods.QUICK));
        System.out.println();
        PerformanceTester.testPerformance(SorterFactory.getSorter(Sorter.SorterMethods.HEAP));
        System.out.println();
        PerformanceTester.testPerformance(SorterFactory.getSorter(Sorter.SorterMethods.SECUENCIAL));
        System.out.println();
        PerformanceTester.testPerformance(SorterFactory.getSorter(Sorter.SorterMethods.BINARIO));

    }
}
