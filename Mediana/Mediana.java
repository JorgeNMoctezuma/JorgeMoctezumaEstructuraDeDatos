package Mediana;
public class Mediana {
    /**
     * @param args Los argumentos de la línea de comandos
     */
    public static void main(String[] args) {

        // Lista de números enteros
        int lista[] = {1, 9, 2, 8, 3, 7, 4, 6, 5};

        // Variable para almacenar la suma de los elementos de la lista
        int media = 0;

        // Calcular la suma de los elementos de la lista
        for (int i = 0; i < lista.length; i++){
            media = media + lista[i];
        }

        // Calcular la media dividiendo la suma por la cantidad de elementos en la lista
        media = media / lista.length;

        // Imprimir la media
        System.out.println("La media es " + media);

    }
}
