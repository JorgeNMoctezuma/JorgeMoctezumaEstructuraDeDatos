package Exam5;
public class Exam5 {
    private int[] perma;
    private boolean[] visitado;
    private int x;

    public static void main(String[] args) {
        Exam5 obj = new Exam5(8);
        obj.analiza();
    }

    public Exam5(int n) {

        perma = new int[n];
        visitado = new boolean[n];
        x = 0;

        for (int i=0; i<n; i++) {
            perma[i] = -1;
            visitado[i] = false;
        }
    }

    public void analiza() {
        revisa(0);
    }

    public void revisa(int location) {

        int i;
        if (location == perma.length) {
            solucion();
            x++;
        }

        for (i=0; i<perma.length; i++) {

            if (!visitado[i]) {

                if (!choque(location, i)) {

                    perma[location] = i;
                    visitado[i] = true;
                    revisa(location+1);
                    visitado[i] = false;
                }

            }
        }

    }

    private boolean choque(int location, int row) {

        int i;
        for (i=0; i<location; i++)
            if (Math.abs(location - i) == Math.abs(perma[i] - row))
                return true;
        return false;
    }

    public void solucion() {
        System.out.println("Hay "+x+" soluciones");
    }

}
