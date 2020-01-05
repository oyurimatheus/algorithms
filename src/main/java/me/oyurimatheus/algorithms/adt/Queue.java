package me.oyurimatheus.algorithms.adt;

import java.util.Iterator;
import java.util.StringJoiner;

import static java.util.Objects.requireNonNull;

public final class Queue<E> implements Iterable<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    public final Queue<E> enqueue(E element) {
        requireNonNull(element, "Element cannot be null");

        Node<E> node = new Node<>(element);

        if(isEmpty()) {
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
        if(isEmpty()) {
            throw new UnsupportedOperationException("Cannot dequeue from an empty queue");
        }

        E value = first.value;

        first = first.next;

        size--;

        if(isEmpty()) {
            last = null;
        }

        return value;
    }

    public E peek() {
        if(isEmpty()) {
            throw new UnsupportedOperationException("Cannot peek from an empty queue");
        }

        return first.value;
    }

    public final long size() {
        return size;
    }

    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public Iterator<E> iterator() {
        return new DefaultIterator<>(first);
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

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", Queue.class.getSimpleName() + "[", "]");

        this.forEach(element -> joiner.add(element.toString()));

        return joiner.toString();
    }
}
