package edu.equipo.evidencia1.elementos;

public class Elemento implements Comparable<Elemento>{
    private int prioridad;
    private int tiempoServicio;

    public Elemento(int prioridad, int tiempoServicio) {
        this.prioridad = prioridad;
        this.tiempoServicio = tiempoServicio;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public int getTiempoServicio() {
        return tiempoServicio;
    }

    public boolean equals(Elemento elemento) {
        return this.getPrioridad() == elemento.getPrioridad();
    }

    public boolean findElement(Elemento elemento){
        return this.getPrioridad() == elemento.getPrioridad() &&
                this.getTiempoServicio() == elemento.getTiempoServicio();
    }

    public int compareTo(Elemento elemento){
        if (this.equals(elemento))
            return 0;
        else if (getPrioridad() > elemento.getPrioridad())
            return 1;
        else
            return -1;
    }

    public String toString(){
        return "Prioridad " + prioridad + " Tiempo de Servicio " + tiempoServicio;
    }
}