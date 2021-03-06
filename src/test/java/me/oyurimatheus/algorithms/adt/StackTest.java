package me.oyurimatheus.algorithms.adt;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StackTest {


    @Test
    void shouldCreateAnEmptyStack() {
        Stack<Integer> integers = new Stack<>();

        assertThat(integers.isEmpty()).isTrue();
        assertThat(integers.size()).isEqualTo(0);
    }

    @Test
    void shouldAddItemsInTopOfStack() {
        Stack<Integer> integers = new Stack<>();

        integers.push(1);
        integers.push(2);
        integers.push(3);

        Integer top = integers.peek();

        assertThat(integers.isEmpty()).isFalse();
        assertThat(integers.size()).isEqualTo(3);
        assertThat(top).isEqualTo(3);
    }

    @Test
    void shouldRemoveItemsFromTopOfStack() {
        Stack<Integer> integers = new Stack<>();

        integers.push(1);
        integers.push(2);
        integers.push(3);

        Integer first = integers.pop();
        Integer second = integers.pop();

        Integer remainedItem = integers.peek();

        assertThat(integers.isEmpty()).isFalse();
        assertThat(integers.size()).isEqualTo(1);
        assertThat(first).isEqualTo(3);
        assertThat(second).isEqualTo(2);
        assertThat(remainedItem).isEqualTo(1);
    }

    @Test
    void shouldIterateOverStackItems() {
        Stack<Integer> integers = new Stack<Integer>()
                                            .push(1)
                                            .push(2)
                                            .push(3);

        Iterator<Integer> iterator = integers.iterator();

        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(3);
        assertThat(iterator.next()).isEqualTo(2);
        assertThat(iterator.next()).isEqualTo(1);
        assertThat(iterator.hasNext()).isFalse();
    }

    @Test
    void shouldNotPermitAddANullInStack() {
        Stack<Integer> integers = new Stack<>();

        assertThatThrownBy(() -> integers.push(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Item cannot be null");
    }

    @Test
    void shouldNotPermitPeekFromAnEmptyStack() {
        Stack<Integer> integers = new Stack<>();

        assertThatThrownBy(integers::peek)
                .isInstanceOf(UnsupportedOperationException.class)
                .hasMessage("Cannot peek from an empty stack");

        assertThat(integers.isEmpty()).isTrue();
    }

    @Test
    void shouldNotPermitPopFromAnEmptyStack() {
        Stack<Integer> integers = new Stack<>();

        assertThatThrownBy(integers::pop)
                .isInstanceOf(UnsupportedOperationException.class)
                .hasMessage("Cannot pop from an empty stack");

        assertThat(integers.isEmpty()).isTrue();
    }
}