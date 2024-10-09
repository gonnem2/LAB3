import java.util.LinkedList;

class Order{
    public String title;
    public String adress;
    public String  cost;

    Order(String t, String a, String c){
        title = t;
        adress = a;
        cost = c;
    }
    public String getAll(){
        return cost +" " + title + " " + adress;
    }

}
class HashTable<K, V> {
    private int size = 0;
    private int lenght;
    private LinkedList<Entry<K, V>>[] table = (LinkedList<Entry<K, V>>[]) new LinkedList[16];

    HashTable() {
        lenght = 1;
    }

    public int hash(K key) {
        int num = key.hashCode();
        return num % lenght;
    }


    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<Entry<K, V>>();
        }
        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        table[index].add(new Entry<K, V>(key, value));
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.getKey().equals(key)) {
                    return entry.value;
                }
            }
        }
        return null;
    }

    public int getSize() {
        return size;
    }

    public boolean isEpmpty() {
        return size == 0;
    }

    public void remove(K key) {
        int index = hash(key);
        if (table[index] != null) {
            for (Entry<K, V> i : table[index]) {
                if (i.getKey().equals(key)) {
                    table[index].remove(i);
                    size--;
                }
            }

        }

    }



    public static void main(String[] args) {
        Order car = new Order("Car", "Moscow", "123");
        Order knife = new Order("Knife", "Kiyev", "350");
        HashTable<Integer, Order> dict = new HashTable<>();
        dict.put(1, car);
        dict.put(2, knife);
        System.out.println(dict.get(2).getAll());
    }


}


