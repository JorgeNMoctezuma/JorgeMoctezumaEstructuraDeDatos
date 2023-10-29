package Act11;
import java.util.ArrayList;

public class HashTable <K, V>{

    private ArrayList<Entry<K, V>>[] table;
    private int tamaño = 0;

    public HashTable(int capacity) {
        table = new ArrayList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new ArrayList<>();
        }
    }

    public boolean isEmpty() {
        return tamaño == 0;
    }

    public int tamaño() {
        return tamaño;
    }

    public HashTable<K, V> add(K key, V value) {
        int index = Math.abs(key.hashCode()) % table.length;
        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return this;
            }
        }
        table[index].add(new Entry<> (key, value));
        tamaño++;
        return this;
    }


    public ArrayList<V> getByKey(K key) {
        int index = Math.abs(key.hashCode()) % table.length;
        ArrayList<V> values = new ArrayList<V>();
        for (Entry<K, V> entry : table[index]){
            if (entry.getKey().equals(key)){
                values.add(entry.getValue());
            }
        }
        return values;
    }

    public ArrayList<V> getValues() {
        ArrayList<V> values = new ArrayList<>();
        for (ArrayList<Entry<K, V>> bucket : table) {
            for (Entry<K, V> entry : bucket){
                values.add(entry.getValue());
            }
        }
        return values;
    }

    private class Entry<K, V> {
        private K key;
        private V value;
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public K getKey() {
            return key;
        }
        public V getValue() {
            return value;
        }
        public void setValue(V value) {
            this.value = value;
        }
    }

}
