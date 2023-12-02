package edu.equipo.evidencia1.process;
import edu.equipo.evidencia1.elementos.Elemento;
import java.util.PriorityQueue;
import java.util.Random;

public class SimulacionCola {
    public static void iniciarSimulacion(int tope, int minLlegada, int maxLlegada, int minServicio, int maxServicio){

        PriorityQueue<Elemento> pQueue = new PriorityQueue<>();

        Random random = new Random();

        int tiempoDeLlegadaRestante = 0;
        boolean esperandoLlegada = false;

        Elemento elementoEnServicio = null;
        int tiempoDeServicioRestante = 0;

        for (int i = 1; i < 181; i++) {
            System.out.println("Segundo " + i);

            if (tiempoDeLlegadaRestante <= 0 && !esperandoLlegada){
                tiempoDeLlegadaRestante = random.nextInt(minLlegada, maxLlegada+1);
                System.out.println("Tiempo de llegada del próximo elemento: " + tiempoDeLlegadaRestante + " segundos");
                esperandoLlegada = true;
            }

            if (elementoEnServicio == null && !pQueue.isEmpty()) {
                elementoEnServicio = pQueue.poll();
                tiempoDeServicioRestante = elementoEnServicio.getTiempoServicio();
                System.out.println("Iniciando servicio del elemento: " + elementoEnServicio);
            }

            if (tiempoDeLlegadaRestante == 0 && pQueue.size() <= tope){
                Elemento elemento = new Elemento(random.nextInt(1,6), random.nextInt(minServicio,maxServicio+1));
                pQueue.add(elemento);
                System.out.println("Elemento agregado: " + elemento);
                esperandoLlegada = false;
            } else if (tiempoDeLlegadaRestante == 0 && pQueue.size() > tope) {
                System.out.println("Elemento rechazado porque se alcanzó el tope");
                esperandoLlegada = false;
            }

            if (elementoEnServicio != null) {
                // Disminuye el tiempo de servicio restante
                tiempoDeServicioRestante--;

                if (tiempoDeServicioRestante <= 0) {
                    // Finaliza el servicio del elemento
                    System.out.println("Elemento finalizado: " + elementoEnServicio);
                    elementoEnServicio = null;
                }
            }

            tiempoDeLlegadaRestante--;
        }
    }
}