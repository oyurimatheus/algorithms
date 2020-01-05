package me.oyurimatheus.algorithms.adt;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;

class QueueTest {


    @Test
    void shouldAddNewElementsInQueue() {
        Queue<Integer> queue = new Queue<Integer>()
                                        .enqueue(1)
                                        .enqueue(2)
                                        .enqueue(3)
                                        .enqueue(4);

        assertThat(queue.isEmpty()).isFalse();
        assertThat(queue.size()).isEqualTo(4);
    }

    @Test
    void shouldReturnTrueIfQueueIsEmpty() {
        Queue<Integer> queue = new Queue<>();

        assertThat(queue.isEmpty()).isTrue();
        assertThat(queue.size()).isEqualTo(0);
    }

    @Test
    void shouldDequeueElementsFromQueue() {
        Queue<Integer> queue = new Queue<Integer>()
                                        .enqueue(1)
                                        .enqueue(2)
                                        .enqueue(3)
                                        .enqueue(4);

        Integer first = queue.dequeue();
        Integer second = queue.dequeue();

        assertThat(first).isEqualTo(1);
        assertThat(second).isEqualTo(2);

        assertThat(queue.size()).isEqualTo(2);
    }

    @Test
    void shouldIterateOverQueueElements() {
        Queue<Integer> queue = new Queue<Integer>()
                                        .enqueue(1)
                                        .enqueue(2)
                                        .enqueue(3)
                                        .enqueue(4);

        Iterator<Integer> iterator = queue.iterator();

        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(1);
        assertThat(iterator.next()).isEqualTo(2);
        assertThat(iterator.next()).isEqualTo(3);
        assertThat(iterator.next()).isEqualTo(4);
        assertThat(iterator.hasNext()).isFalse();
    }
}