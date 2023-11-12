package Exam1;
import java.util.Scanner;
import java.util.LinkedList;
public class Exam1 {

    //aquí inicia
    public static void main(String[] args) {
        //Creamos todos los int, scanner, boolean y la linkedlist que vamos a usar
        Scanner scanner = new Scanner(System.in);
        LinkedList<jugador> list = new LinkedList<>();
        int accion;
        int sí;
        //Esto va a hacer que se repita hasta que imprimamos la lista o que el usuario diga adios
        boolean másjugadores = true;
        while (másjugadores = true) {
            System.out.printf("Bienvenido al programa de registro, por favor seleccione\n1.- Agregar jugador" +
                    "\n2.- Lista de jugadores\n3.- Cerrar programa\n");

            accion = scanner.nextInt();
            scanner.nextLine();

            //Registro de jugadores
            if (accion == 1) {

                System.out.println("Nombre del jugador:");
                String nombreJugador = scanner.nextLine();
                System.out.println("Ingresa la edad del jugador:");
                int edadJugador = scanner.nextByte();
                //Revision de edad del jugador
                if (edadJugador < 18) {
                    System.out.printf("El jugador no cumple con los requerimientos de edad");


                } else if (edadJugador >= 18) {
                    jugador jugador = new jugador(nombreJugador, (byte) edadJugador);
                    list.add(jugador);
                }
            }

            //imprimir lista de jugadores
            if (accion == 2) {
                System.out.println("Los jugadores registrados son:");
                for (jugador j : list) {
                    System.out.println(j);
                }
                break;

            }

            //cerrar programa
            if (accion == 3) {
                System.out.printf("Bye bye");
                break;

            }

        }
    }

    //Todo lo que tenemos que guardar de jugador
    static class jugador {

        private String nombre;
        private int edad;

        public jugador(String nombre, byte numero) {
            this.nombre = nombre;
            this.edad = numero;
        }

        public String getNombre() {
            return nombre;
        }

        public byte getEdad() {
            return (byte) edad;
        }

        @Override
        public String toString() {
            return nombre + " " + edad;
        }
    }

}