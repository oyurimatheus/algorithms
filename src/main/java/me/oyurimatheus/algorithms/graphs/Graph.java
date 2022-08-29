package me.oyurimatheus.algorithms.graphs;

/**
 *
 * @param <V> the object which will be the vertices. Need to implement a hash function
 */
public interface Graph<V> {

    V vertices();

    int size();

    int order();

    void connect(V from, V to);
}
