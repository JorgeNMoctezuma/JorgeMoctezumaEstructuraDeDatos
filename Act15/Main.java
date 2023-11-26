package Act15;
import Act15.ArbBal23;

public class Main {
    public static void main(String[] args) {
        ArbBal23 argol = new ArbBal23();

        argol.insertar(5,0);
        argol.insertar(3,1);
        argol.insertar(15,2);
        argol.insertar(20,3);
        argol.insertar(1,4);
        argol.insertar(25,5);
        argol.insertar(13,6);
        argol.insertar(14,7);
        argol.insertar(24,8);
        argol.insertar(23,9);
        argol.insertar(22,10);

        System.out.println("Arbol: ");
        argol.orden();

    }
}
