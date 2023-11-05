package Act12.Programas.Iterativa;
/**
 * Clase que contiene un método para buscar un elemento en un arreglo usando búsqueda binaria
 */
public class BinariaIte {
    /**
     * Busca un elemento en un arreglo ordenado de enteros utilizando búsqueda binaria de manera iterativa
     *
     * @param num El arreglo ordenado
     * @param x   El elemento que se busca
     * @return El índice del elemento buscado si se encuentra, o -1 si no se encuentra
     */
    public static int xBinariaItera(int[] num, int x)
    {
        int izqu = 0, derec = num.length - 1;
        while (izqu <= derec)
        {
            int mid = (izqu + derec) / 2;
            if (x == num[mid]) {
                return mid;
            }
            else if (x < num[mid]) {
                derec = mid - 1;
            }
            else {
                izqu = mid + 1;
            }
        } return -1;
    }
    /**
     * Método que demuestra la búsqueda binaria iterativa en un arreglo de ejemplo
     *
     * @param args argumentos de la línea de comando
     */
    public static void main(String[] args)
    {
        int[] num = { 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int x = 8;

        int index = xBinariaItera(num, x);

        if (index != -1) {
            System.out.println("Elemento encontrado " + index);
        }
        else {
            System.out.println("Elemento invalido");
        }
    }

}

