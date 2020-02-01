package me.oyurimatheus.algorithms.adt;

import java.util.Iterator;
import java.util.StringJoiner;

import static java.util.Objects.requireNonNull;

public final class Queue<E> implements Iterable<E> {

    private Deque<E> queue = new Deque<>();

    public final Queue<E> enqueue(E element) {
        requireNonNull(element, "Element cannot be null");

       queue.pushRight(element);

        return this;
    }

    public final E dequeue() {
        if(isEmpty()) {
            throw new UnsupportedOperationException("Cannot dequeue from an empty queue");
        }

        return queue.popLeft();
    }

    public E peek() {
        if(isEmpty()) {
            throw new UnsupportedOperationException("Cannot peek from an empty queue");
        }

        return queue.peekLeft();
    }

    public final long size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return queue.iterator();
    }


    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", Queue.class.getSimpleName() + "[", "]");

        this.forEach(element -> joiner.add(element.toString()));

        return joiner.toString();
    }
}
