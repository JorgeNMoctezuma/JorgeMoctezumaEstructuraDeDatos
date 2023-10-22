import Utils.Grafo;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo(7);
        grafo.agregarAristas(1,2);
        grafo.agregarAristas(2,6);
        grafo.agregarAristas(1,3);
        grafo.agregarAristas(3,4);
        grafo.agregarAristas(4,6);

        System.out.println(grafo.vecinos(1));
        System.out.println(grafo.vecinos(3));
        System.out.println(grafo.aristaExistente(1,3));



    }
}