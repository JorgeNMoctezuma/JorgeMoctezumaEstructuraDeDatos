package BST;

public class BinSer3 {
    //aquí inicia todo
    static class nodo {
        int key;
        nodo izq, der;

        public nodo(int dato){
            key = dato;
            izq = der = null;
        }
    }
    nodo raiz;

    BinSer3(){
        raiz = null;
    }
    /**
     * Elimina un nodo con un valor específico
     * @param key El valor a eliminar
     */
    void borrador(int key) {
        raiz = eliminar(raiz, key);
    }

    nodo eliminar(nodo raiz, int key)  {

        if (raiz == null)  return raiz;

        if (key < raiz.key)
            raiz.izq = eliminar(raiz.izq, key);
        else if (key > raiz.key)
            raiz.der = eliminar(raiz.der, key);
        else  {

            if (raiz.izq == null)
                return raiz.der;
            else if (raiz.der == null)
                return raiz.izq;


            raiz.key = valMin(raiz.der);
            raiz.der = eliminar(raiz.der, raiz.key);
        }
        return raiz;
    }
    /**
     * Encuentra el valor mínimo
     * @param raiz La raíz del árbol
     * @return El valor mínimo en el árbol
     */
    int valMin(nodo raiz)  {

        int valMin = raiz.key;

        while (raiz.izq != null)  {
            valMin = raiz.izq.key;
            raiz = raiz.izq;
        }
        return valMin;
    }

    /**
     * Inserta un nuevo nodo con un valor específico
     * @param key El valor a insertar
     */
    void poner(int key)  {
        raiz = agregar(raiz, key);
    }


    nodo agregar(nodo raiz, int key) {

        if (raiz == null) {
            raiz = new nodo(key);
            return raiz;
        }

        if (key < raiz.key)
            raiz.izq = agregar(raiz.izq, key);
        else if (key > raiz.key)
            raiz.der = agregar(raiz.der, key);

        return raiz;
    }


    void orden() {
        ordenar(raiz);
    }

    void ordenar(nodo raiz) {
        if (raiz != null) {
            ordenar(raiz.izq);
            System.out.print(raiz.key + " ");
            ordenar(raiz.der);
        }
    }
    /**
     * Busca un valor específico
     * @param key El valor a buscar
     * @return true si el valor existe en el árbol, false de lo contrario
     */

    boolean buscar(int key)  {
        raiz = localiza(raiz, key);
        if (raiz!= null)
            return true;
        else
            return false;
    }


    nodo localiza(nodo raiz, int key)  {

        if (raiz==null || raiz.key==key)
            return raiz;

        if (raiz.key > key)
            return localiza(raiz.izq, key);

        return localiza(raiz.der, key);
    }
}
/**
 * Clase principal que contiene el método
 */
class Main{
    public static void main(String[] args)  {
        BinSer3 bst = new BinSer3();

        bst.poner(1);
        bst.poner(3);
        bst.poner(5);
        bst.poner(7);
        bst.poner(9);
        bst.poner(8);
        bst.poner(6);
        bst.poner(4);
        bst.poner(2);
        System.out.println("Ordenado");
        bst.orden();

        System.out.println("\nBorrar un nodo");
        bst.borrador(9);
        bst.orden();
        System.out.println("\nBorrar nodo con hijos");
        bst.borrador(3);
        bst.orden();

        boolean ret_val = bst.buscar (6);
        System.out.println("\nExiste nodo 50?: " + ret_val );
        ret_val = bst.buscar (10);
        System.out.println("\nExiste nodo 13?: " + ret_val );
    }
}

