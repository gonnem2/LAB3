class Entry<K, V>{
    K key;
    V value;

    public K getKey(){
        return key;
    }

    public void setValue(V v){
        value = v;
    }

    Entry(K k, V v){
        key = k;
        value = v;
    }

}