package me.oyurimatheus.algorithms.adt;

import java.util.Iterator;
import java.util.NoSuchElementException;

public final class Deque<E> implements Iterable<E> {

    private Node first;
    private Node last;
    private int size;


    public Deque<E> pushRight(E item) {
        Node node = new Node(item);

        if (first == null) {
            first = node;
            last = first;
        } else {
            last.next = node;
            node.prev = last;
            last = node;
        }

        size++;

        return this;
    }

    public E popRight() {
        if(isEmpty()) {
            throw new UnsupportedOperationException("Cannot pop from an empty deque");
        }

        E value = last.value;
        last = last.prev;

        if(size == 1) {
            first = null;
            last = null;
        }

        size--;

        return value;
    }

    public Deque<E> pushLeft(E item) {
        Node node = new Node(item);

        if (first == null) {
            first = node;
            last = first;
        } else {
            first.prev = node;
            node.next = first;
            first = node;
        }

        size++;

        return this;
    }

    public E popLeft() {
        if(isEmpty()) {
            throw new UnsupportedOperationException("Cannot pop from an empty deque");
        }

        E value = first.value;
        first = first.next;

        if(size == 1) {
            first = null;
            last = null;
        }

        size--;

        return value;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public E peekLeft() {
        return first.value;
    }

    public E peekRight() {
        return last.value;
    }

    @Override
    public Iterator<E> iterator() {
        return new DefaultIterator(first);
    }

    public Iterator<E> reverseIterator() {
        return new ReverseIterator(last);
    }

    private class Node {
        E value;
        Node next;
        Node prev;

        public Node(E item) {
            this.value = item;
        }
    }

    private class DefaultIterator implements Iterator<E> {
        private Node current;

        public DefaultIterator(Node first) {
            current = first;

        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            E item = current.value;
            current = current.next;

            return item;
        }
    }

    private class ReverseIterator implements Iterator<E> {
        private Node current;

        public ReverseIterator(Node last) {
            current = last;

        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            E item = current.value;
            current = current.prev;

            return item;
        }
    }
}
