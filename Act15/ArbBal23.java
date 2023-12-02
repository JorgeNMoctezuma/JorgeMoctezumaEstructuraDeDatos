package Act15;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Iniciamos un arbol balanceado 2-3
 */
public class ArbBal23 {
    private Nodo raiz;

    /**
     * Inicia una raíz como nula.
     */
    public ArbBal23() {
        raiz = null;
    }

    /**
     * Inserta un nuevo valor
     * @param valor Valor a insertar.
     * @param index Índice asociado al valor.
     */
    public void insertar(int valor, int index) {
        if (raiz == null) {
            raiz = new Nodo(valor, index);
        } else {
            insertar(raiz, valor, index);
        }
    }

    private void insertar(Nodo nodo, int valor, int index) {
        if (nodo.buscaHijos().isEmpty()) {
            insertarNodo(nodo, valor, index);
        } else {
            int indexHijo = busqindexHijo(nodo, valor);
            insertar(nodo.buscaHijos().get(indexHijo), valor, index);
        }

        if (nodo.buscaValor().size() == 3) {
            partirNodo(nodo);
        }
    }

    private void insertarNodo(Nodo nodo, int valor, int index) {
        int i = 0;
        while (i < nodo.buscaValor().size() && valor > nodo.buscaValor().get(i)) {
            i++;
        }

        nodo.buscaValor().add(i, valor);
        nodo.buscapuntos().add(i, index);
    }

    private void partirNodo(Nodo nodo) {
        Nodo padre = nodo.obtenerPadre();

        if (padre == null) {
            padre = new Nodo();
            raiz = padre;
            nodo.declararPadre(padre);
            padre.buscaHijos().add(nodo);
        }

        Nodo dernodo = new Nodo();
        dernodo.declararPadre(padre);

        dernodo.buscaValor().add(nodo.buscaValor().remove(2));
        dernodo.buscapuntos().add(nodo.buscapuntos().remove(2));

        int cenvalor = nodo.buscaValor().remove(1);
        int cenIndex = nodo.buscapuntos().remove(1);
        insertarNodo(padre, cenvalor, cenIndex);

        if (!nodo.buscaHijos().isEmpty()) {
            dernodo.buscaHijos().add(nodo.buscaHijos().remove(2));
            dernodo.buscaHijos().get(0).declararPadre(dernodo);
            dernodo.buscaHijos().add(nodo.buscaHijos().remove(2));
            dernodo.buscaHijos().get(1).declararPadre(dernodo);
        }

        padre.buscaHijos().add(padre.buscaHijos().indexOf(nodo) + 1, dernodo);
    }

    private int busqindexHijo(Nodo nodo, int valor) {
        int i = 0;
        while (i < nodo.buscaValor().size() && valor > nodo.buscaValor().get(i)) {
            i++;
        }
        return i;
    }

    /**
     * Imprime el árbol en orden
     */
    public void orden() {
        if (raiz == null) {
            System.out.println("Arbol invalido");
            return;
        }

        Queue<Nodo> queue = new LinkedList<>();
        queue.add(raiz);

        while (!queue.isEmpty()) {
            int altura = queue.size();

            for (int i = 0; i < altura; i++) {
                Nodo currentnodo = queue.poll();
                System.out.print("(");
                for (int j = 0; j < currentnodo.buscapuntos().size(); j++) {
                    System.out.print(currentnodo.buscaValor().get(j));
                    if (j < currentnodo.buscapuntos().size() - 1) {
                        System.out.print(" - ");
                    }
                }
                System.out.print(") ");

                if (!currentnodo.buscaHijos().isEmpty()) {
                    queue.addAll(currentnodo.buscaHijos());
                }
            }

            System.out.println();
        }
    }
}
