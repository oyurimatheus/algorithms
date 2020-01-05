package me.oyurimatheus.algorithms.adt;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

import static java.util.Objects.requireNonNull;

public class Stack<E> implements Iterable<E> {

    private  Node<E> top;
    private int size;

    public Stack<E> push(E item) {
        requireNonNull(item, "Item cannot be null");

        Node<E> oldTop = top;

        top = new Node<>(item);
        top.next = oldTop;

        size++;

        return this;
    }

    public E pop() {
        if(isEmpty()) {
            throw new UnsupportedOperationException("Could not peek from an empty stack");
        }

        E item = top.value;
        top = top.next;

        size--;
        return item;
    }

    public E peek() {
        if(isEmpty()) {
            throw new UnsupportedOperationException("Could not peek from an empty stack");
        }

        return top.value;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public Iterator<E> iterator()  {
        return new DefaultIterator<>(top);
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

        DefaultIterator(Node<E> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            E item = current.value;
            current = current.next;
            return item;
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", Stack.class.getSimpleName() + "[", "]");

        this.forEach(element -> joiner.add(element.toString()));

        return joiner.toString();
    }
}
