package Utils;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GrafoTest {
    @Test
    public void testAristaExistente(){
        Grafo grafo = new Grafo(7);
        grafo.agregarAristas(1,2);
        assertTrue(grafo.aristaExistente(1,2));
    }
    @Test
    public void testAristaOpuesta(){
        Grafo grafo = new Grafo(7);
        grafo.agregarAristas(2,1);
        assertTrue(grafo.aristaExistente(2,1));
    }
    @Test
    public void testAristaInexistente(){
        Grafo grafo = new Grafo(7);
        grafo.agregarAristas(1,2);
        assertFalse(grafo.aristaExistente(3,4));
    }

}