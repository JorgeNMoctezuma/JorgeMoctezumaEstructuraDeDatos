package Reto8.Process;
import Reto8.Process.PerformanceTester;
import Reto8.Utils.Sorter;

public class SorterFactory {
    public static Sorter getSorter(Sorter.SorterMethods method){

        return switch (method) {
            case BUBBLE -> new Sorter() {
                @Override
                public void sort(int[] N) {
                    MOVIMIENTOS = 0;
                    COMPARACIONES = 0;

                    boolean swapped = true;
                    while (swapped) {
                        swapped = false;
                        for (int i = 0; i < N.length - 1; i++) {
                            COMPARACIONES++;
                            if (N[i] > N[i + 1]) {
                                MOVIMIENTOS++;
                                swapped = true;
                                swap(N, i, i + 1);
                            }
                        }
                    }
                }

            };
            case SELECTION -> new Sorter() {

                @Override
                public void sort(int[] N) {
                    MOVIMIENTOS = 0;
                    COMPARACIONES = 0;
                    for (int i = 0; i < N.length - 1; i++) {
                        int minIndex = i;
                        for (int j = i + 1; j < N.length; j++) {
                            COMPARACIONES++;
                            if (N[minIndex] > N[j]) {
                                minIndex = j;
                            }
                        }
                        if (minIndex != i) {
                            MOVIMIENTOS++;
                            swap(N, minIndex, i);
                        }
                    }
                }
            };
            case INSERTION -> new Sorter() {
                @Override
                public void sort(int[] N) {
                    MOVIMIENTOS = 0;
                    COMPARACIONES = 0;
                    for (int i = 1; i < N.length; i++) {
                        int current = N[i];
                        int j = i - 1;
                        while (j >= 0 && N[j] > current) {
                            N[j + 1] = N[j];
                            j--;
                            MOVIMIENTOS++;
                            COMPARACIONES++;
                        }
                        N[j + 1] = current;
                        MOVIMIENTOS++;
                    }
                }
            };
            case SHELL -> new Sorter() {
                @Override
                public void sort(int[] N) {
                    MOVIMIENTOS = 0;
                    COMPARACIONES = 0;

                    int n = N.length;
                    int h = 1;
                    while (h < n / 3) {
                        h = 3 * h + 1;
                    }
                    while (h >= 1) {
                        for (int i = h; i < n; i++) {
                            int j = i;
                            while (j >= h && N[j] < N[j - h]) {
                                int temp = N[j];
                                N[j] = N[j - h];
                                N[j - h] = temp;
                                MOVIMIENTOS++;
                                COMPARACIONES++;
                                j = j - h;
                            }
                        }
                        h = h / 3;
                    }
                }
            };
            case MERGE -> new Sorter() {
                @Override
                public void sort(int[] arr) {
                    COMPARACIONES = 0;
                    MOVIMIENTOS = 0;

                    int n = arr.length;
                    if (n < 2) {
                        return;
                    }

                    int mid = n / 2;
                    int[] left = new int[mid];
                    int[] right = new int[n - mid];

                    //Hace los arrays de izquierda y derecha
                    for (int i = 0; i < mid; i++) {
                        left[i] = arr[i];
                    }
                    for (int i = mid; i < n; i++) {
                        right[i - mid] = arr[i];
                    }

                    sort(left);
                    sort(right);
                    merge(arr, left, right);
                }

                public void merge(int[] arr, int[] left, int[] right) {
                    int n1 = left.length;
                    int n2 = right.length;
                    int i = 0, j = 0, k = 0;
                    int[] mergedArray = new int[n1 + n2];

                    while (i < n1 && j < n2) {
                        COMPARACIONES++;
                        if (left[i] <= right[j]) {
                            MOVIMIENTOS++;
                            mergedArray[k++] = left[i++];
                        } else {
                            MOVIMIENTOS++;
                            mergedArray[k++] = right[j++];
                        }
                    }

                    // Copia los elementos de izquierda y derecha
                    while (i < n1) {
                        MOVIMIENTOS++;
                        mergedArray[k++] = left[i++];
                    }
                    while (j < n2) {
                        MOVIMIENTOS++;
                        mergedArray[k++] = right[j++];
                    }

                    // Regresa el array de copia al orginal
                    System.arraycopy(mergedArray, 0, arr, 0, arr.length);
                }
            };
            case QUICK -> new Sorter() {
                @Override
                public void sort(int[] N) {
                    COMPARACIONES = 0;
                    MOVIMIENTOS = 0;

                    quickSort(N, 0, N.length - 1);
                }

                public void quickSort(int[] array, int left, int right) {
                    int partition; /* index of partition */

                    if ((right - left) > 0) {
                        partition = getPartition(array, left, right);
                        quickSort(array, left, partition - 1);
                        quickSort(array, partition + 1, right);
                    }
                }

                public int getPartition(int[] array, int left, int right) {
                    int pivot = right;
                    int firsthigh = left;

                    for (int i = left; i < right; i++) {
                        COMPARACIONES++;
                        if (array[i] < array[pivot]) {
                            MOVIMIENTOS++;
                            swap(array, i, firsthigh);
                            firsthigh++;
                        }
                    }

                    MOVIMIENTOS++;
                    swap(array, pivot, firsthigh);
                    return (firsthigh);
                }
            };
            case HEAP -> new Sorter() {
                @Override
                public void sort(int[] array) {
                    COMPARACIONES = 0;
                    MOVIMIENTOS = 0;

                    int n = array.length;

                    for (int i = 1; i < array.length; i++) {
                        int current = i;
                        int parent = getParent(current);

                        while (current > 0 && array[current] > array[parent]) {
                            COMPARACIONES++;
                            swap(array, current, parent);
                            MOVIMIENTOS++;
                            current = parent;
                            parent = getParent(current);
                        }
                    }

                    for (int arrayEnd = n - 1; arrayEnd > 0; arrayEnd--) {
                        int current = 0;
                        swap(array, current, arrayEnd);
                        int biggestChild = getBiggestChild(array, current, arrayEnd);

                        while (biggestChild < arrayEnd && array[current] < array[biggestChild]) {
                            COMPARACIONES++;
                            swap(array, current, biggestChild);
                            MOVIMIENTOS++;
                            current = biggestChild;
                            biggestChild = getBiggestChild(array, current, arrayEnd);
                        }
                    }
                }

                public static int getParent(int index) {
                    return (index + 1) / 2 - 1;
                }

                public static int getBiggestChild(int[] array, int current, int fP) {
                    int leftChild = 2 * current + 1;
                    int rightChild = 2 * current + 2;

                    if (leftChild < fP) {
                        if (rightChild < fP && array[rightChild] > array[leftChild]) {
                            return rightChild;
                        } else {
                            return leftChild;
                        }
                    }

                    return current;
                }
            };
            case SECUENCIAL -> new Sorter() {
                @Override
                public void sort(int[] N) {
                    MOVIMIENTOS = 0;
                    COMPARACIONES = 0;

                    int end = N.length;
                    for (int i = 0; i < end; i++) {
                        COMPARACIONES++;
                        if (N[i] == end) {
                            MOVIMIENTOS++;
                            return;
                        }
                    }
                }
            };


            case BINARIO -> new Sorter() {
                @Override
                public void sort(int[] N) {
                    MOVIMIENTOS = 0;
                    COMPARACIONES = 0;

                    int end = N.length;
                    int left = 0, right = end - 1;
                    while (left <= right) {
                        int m = left + (right - left) / 2;
                        COMPARACIONES++;
                        if (N[m] == end) {
                            MOVIMIENTOS++;
                            break;
                        }
                        if (N[m] < end)
                            left = m + 1;
                        else
                            right = m - 1;
                    }
                }
            };
            default -> throw new IllegalStateException("Unexpected value: " + method);
        };


    }
}
