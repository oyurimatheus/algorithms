package me.oyurimatheus.algorithms.graphs;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UnionFindTest {

    @Test
    void shouldConnectTheElementsWhenRequired() {
        UnionFind uf = new UnionFind(10);

        uf.union(0, 1);
        uf.union(1, 2);
        uf.union(3, 4);
        uf.union(9, 8);

        assertThat(uf.connected(0, 1)).isTrue();
        assertThat(uf.connected(1, 2)).isTrue();
        assertThat(uf.connected(0, 2)).isTrue();
        assertThat(uf.connected(4, 3)).isTrue();
        assertThat(uf.connected(8, 9)).isTrue();

        assertThat(uf.connected(3, 1)).isFalse();
        assertThat(uf.connected(0, 9)).isFalse();
        assertThat(uf.connected(6, 7)).isFalse();
    }

}