package Act15;

import java.util.ArrayList;
import java.util.List;

public class Nodo {
    private List<Integer> valor;
    private List<Integer> indexes;
    private List<Nodo> hijo;
    private Nodo padre;

    public Nodo() {
        valor = new ArrayList<>();
        indexes = new ArrayList<>();
        hijo = new ArrayList<>();
        padre = null;
    }

    public Nodo(int value, int index) {
        this();
        valor.add(value);
        indexes.add(index);
    }

    public List<Integer> buscaValor() {
        return valor;
    }

    public void asignarValor(List<Integer> valor) {
        this.valor = valor;
    }

    public List<Integer> buscapuntos() {
        return indexes;
    }

    public void asignarPuntos(List<Integer> indexes) {
        this.indexes = indexes;
    }

    public List<Nodo> buscaHijos() {
        return hijo;
    }

    public void asignarHijo(List<Nodo> hijo) {
        this.hijo = hijo;
    }

    public Nodo obtenerPadre() {
        return padre;
    }

    public void declararPadre(Nodo padre) {
        this.padre = padre;
    }

}
