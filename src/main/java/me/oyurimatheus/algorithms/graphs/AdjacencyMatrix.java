package me.oyurimatheus.algorithms.graphs;

import java.util.List;

public class AdjacencyMatrix<V> implements Graph<V> {

    private int[][] matrix;
    List<V> vertices;

    public AdjacencyMatrix(List<V> vertices) {
        this.vertices = vertices;
        this.matrix = new int[vertices.size()][vertices.size()];
    }

    @Override
    public V vertices() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int order() {
        return 0;
    }

    @Override
    public void connect(V from, V to) {

    }
}
