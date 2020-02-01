package me.oyurimatheus.algorithms.adt;

import java.util.Iterator;
import java.util.StringJoiner;

import static java.util.Objects.requireNonNull;

public final class Stack<E> implements Iterable<E> {

    private Deque<E> stack = new Deque<>();

    public Stack<E> push(E item) {
        requireNonNull(item, "Item cannot be null");

        stack.pushRight(item);

        return this;
    }

    public E pop() {
        if(isEmpty()) {
            throw new UnsupportedOperationException("Cannot pop from an empty stack");
        }

        return stack.popRight();
    }

    public E peek() {
        if(isEmpty()) {
            throw new UnsupportedOperationException("Cannot peek from an empty stack");
        }

        return stack.peekRight();
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public Iterator<E> iterator()  {
        return stack.reverseIterator();
    }


    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", Stack.class.getSimpleName() + "[", "]");

        this.forEach(element -> joiner.add(element.toString()));

        return joiner.toString();
    }
}
