package me.oyurimatheus.algorithms.graphs;

public class UnionFind {

    private int[] elements;
    private int[] size;

    public UnionFind(int elements) {
        this.elements = new int[elements];
        this.size = new int[elements];

        for(int i = 0; i < elements; i++) {
            this.elements[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return elements[p] == elements[q];
    }

    public void union(int p, int q) {
        int pElement = root(p);
        int qElement = root(q);

        if(pElement == qElement) {
            return;
        }

        if(size[pElement] < size[qElement]) {
            elements[pElement] = qElement;
            size[qElement] += size[pElement];
        } else {
            elements[qElement] = pElement;
            size[pElement] += size[qElement];
        }
    }

    private int root(int i) {
        while(i != elements[i]) {
            elements[i] = elements[elements[i]];
            i = elements[i];
        }

        return i;
    }
}
