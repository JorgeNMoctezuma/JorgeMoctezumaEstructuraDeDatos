package Act11;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

//TDD = Test driven Development
public class HashTableTest {
    private HashTable<String, Integer> hashTable;
        @Test
        public void testIsEmpty () {
            HashTable<String, Integer> hashtable = new HashTable<>(10);
            assertTrue(hashtable.isEmpty());
            hashtable.add("Uno", 1);
            assertFalse(hashtable.isEmpty());
        }

        @Test
        public void testAddAndSize () {
            HashTable<String, Integer> hashtable = new HashTable<>(10);
            hashtable.add("Uno", 1);
            hashtable.add("Dos", 2);
            hashtable.add("Tres", 3);
            assertEquals(3, hashtable.tamaño());
        }

        @Test
        public void testGetByKey () {
            HashTable<String, Integer> hashtable = new HashTable<>(10);
            hashtable.add("Dos", 2);
            ArrayList<Integer> expectedValuesForKeyDos = new ArrayList<>();
            expectedValuesForKeyDos.add(2);
            assertEquals(expectedValuesForKeyDos, hashtable.getByKey("do"));
        }

        @Test
        public void testGetValues () {
            HashTable<String, Integer> hashtable = new HashTable<>(10);
            hashtable.add("Uno", 1);
            hashtable.add("Dos", 2);
            hashtable.add("Tres", 3);
            ArrayList<Integer> ExpectedValues = new ArrayList<>();
            ExpectedValues.add(1);
            ExpectedValues.add(2);
            ExpectedValues.add(3);
            assertTrue(hashtable.getValues().containsAll(ExpectedValues) && ExpectedValues.containsAll(hashtable.getValues()));
        }
}
