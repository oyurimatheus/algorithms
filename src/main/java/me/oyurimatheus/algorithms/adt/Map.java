package me.oyurimatheus.algorithms.adt;

public interface Map<K, V> {


    Deque<Tuple<K, V>> values();
}
