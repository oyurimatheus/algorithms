package me.oyurimatheus.algorithms.adt;

public class HashMap<K, V> implements Map<K, V>{

    private Array<Deque<V>> map;


    public HashMap() {
        this.map = new Array<>(75);
    }

    @Override
    public Deque<Tuple<K, V>> values() {
        return null;
    }
}
