package me.oyurimatheus.algorithms.adt;

import java.util.*;

import static java.lang.System.arraycopy;
import static java.util.Objects.requireNonNull;

public class Array<E> implements Iterable<E> {

    private Object[] elements;
    private int size = 0;


    public Array() {
        this(20);
    }

    public Array(int initialCapacity) {
        this.elements = new Object[initialCapacity];
    }

    public Array<E> add(E element) {
        requireNonNull(element, "Cannot add a null element in Vector");

        ensureCapacity();
        elements[size++] = element;

        return this;
    }

    private void ensureCapacity() {
        if(size == elements.length) {
            Object[] newContainer = new Object[size * 2];
            arraycopy(elements, 0, newContainer, 0, elements.length);
            elements = newContainer;
        }
    }

    @SuppressWarnings({ "UNCHECKED_", "unchecked" })
    public E get(int i) {
        if(i > size) {
            throw new UnsupportedOperationException("Cannot get from an index greater than array size");
        }

        return (E) elements[i];
    }

    @SuppressWarnings({ "UNCHECKED_", "unchecked" })
    public Optional<E> get(E element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return Optional.of((E) elements[i]);
            }
        }

        return Optional.empty();
    }

    @SuppressWarnings({ "UNCHECKED_", "unchecked" })
    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return true;
            }
        }

        return false;
    }

    public E remove(E element) {

        int position = -1;

        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                position = i;
                break;
            }
        }

        if (position == -1) {
            throw new IllegalStateException("Element not found in array");
        }

        arraycopy(elements, position + 1, elements, position, size - position);

        size--;
        return element;
    }

    @SuppressWarnings({ "UNCHECKED_", "unchecked" })
    public E remove(int position) {

        if (position < 0 || position >= size) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds");
        }

        E element = (E) elements[position];

        arraycopy(elements, position + 1, elements, position, size - position);

        size--;
        return element;
    }

    public int size() {
        return size;
    }

    @Override
    @SuppressWarnings({ "UNCHECKED_", "unchecked" })
    public Iterator<E> iterator() {
        return (Iterator<E>) Arrays.stream(elements).iterator();
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", Array.class.getSimpleName() + "[", "]");

        for (int i = 0; i < size; i++) {
            joiner.add(elements[i].toString());
        }

        return joiner.toString();
    }
}
