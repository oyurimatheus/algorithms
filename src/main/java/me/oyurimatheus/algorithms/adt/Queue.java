package me.oyurimatheus.algorithms.adt;

import java.util.Iterator;

public final class Queue<E> implements Iterable<E> {

    private Node<E> first;
    private Node<E> last;
    private long size;

    public final Queue<E> enqueue(E element) {
        Node<E> node = new Node<>(element);

        if(first == null) {
            first = node;
            last = first;
        } else {
            last.next = node;
            last = node;
        }

        size++;

        return this;
    }

    public final E dequeue() {
        if(first == null) {
            throw new UnsupportedOperationException("Could not dequeue from an empty list");
        }

        E value = first.value;

        first = first.next;

        size--;

        return value;
    }

    public final long size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new DefaultIterator<>(first);
    }

    public boolean isEmpty() {
        return first == null;
    }

    private static class Node<E> {
        E value;
        Node<E> next;

        Node(E element) {
            this.value = element;
        }
    }

    private static class DefaultIterator<E> implements Iterator<E> {

        private Node<E> current;

        DefaultIterator(Node<E> current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if(!hasNext()) {
                throw new UnsupportedOperationException();
            }

            E item = current.value;

            current = current.next;

            return item;
        }
    }
}
