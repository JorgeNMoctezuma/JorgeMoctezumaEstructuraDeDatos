package Act12.Programas.Iterativa;
/**
 * Esta clase calcula el factorial de un número
 */
public class FactoIte {
    /**
     * Este método es el punto de entrada principal para el programa
     *
     * @param args Los argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        int n = 10;
        System.out.println("El factorial de " + n + " es "+ facorial(n));
    }
    /**
     * Calcula el factorial de un número dado
     *
     * @param n El número para el cual se calculará el factorial
     * @return El valor del factorial de n
     */
    public static int facorial(int n){
        int val = 1;
        for (int i = 1; i <= n; i++){
            val = val * i;
        }
        return val;
    }

}
