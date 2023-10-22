package Utils;
import java.util.Set;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VecinosTest {
    //En caso de negativos
    @Test(expected = IllegalArgumentException.class)
    public void verticeNegativoTest(){
        Grafo grafo = new Grafo(7);
        grafo.vecinos(-1);
    }
    //Se pasa de tamañp
    @Test(expected = IllegalArgumentException.class)
    public void verticeExcedidoTest(){
        Grafo grafo = new Grafo(7);
        grafo.vecinos(7);
    }
    //Vertices sin vecinos
    @Test
    public void verticesAisladosTest(){
        Grafo grafo = new Grafo(7);
        assertEquals(0, grafo.vecinos(2).size());
    }
    //Numero de vecinos
    @Test
    public void verticesVecinosTest(){
        Grafo grafo = new Grafo(7);
        grafo.agregarAristas(0,1);
        grafo.agregarAristas(2,3);
        grafo.agregarAristas(2,4);

        Set<Integer> set = grafo.vecinos(2);

        assertEquals(2,set.size());
        assertTrue(set.contains(3));
        assertTrue(set.contains(4));
    }
}
