package Utils;
import java.util.HashSet;
import java.util.Set;

//Me marea la nueva interfaz
public class Grafo {
    //Representar grafo por matriz de adyacencia
    private boolean [][]A;
    //Cantidad de vertices
    public Grafo (int vertices){
        A = new boolean[vertices][vertices];
    }
    //Agregar aristas
    public void agregarAristas(int i, int j){

        VerificarVertice(i);
        VerificarVertice(j);
        if (i == j){
            throw new IllegalArgumentException("No loops por favor");
        }
        A[i][j] = true;
        A[j][i] = true;
    }

    //Comprobar existencia
    public boolean aristaExistente(int i, int j){
        VerificarVertice(i);
        VerificarVertice(j);

        return A[i][j];
    }

    //Revisar a los vecinos del vertice
    public Set<Integer> vecinos(int i){
        VerificarVertice(i);

        Set<Integer> dato = new HashSet<Integer>();
        for (int j=0; j < A.length; ++j){
            if (this.aristaExistente(i, j)){
                dato.add(j);
            }
        }
        return dato;
    }

    //Verificar validez del vertice
    private void VerificarVertice(int i) {
        if (i < 0){
            throw new IllegalArgumentException("Los vertices no pueden ser negativos");
        }
        if (i >= A.length){
            throw new IllegalArgumentException("Los vertices deben estar entre 0 y " + (A.length - 1));
        }
    }


}

