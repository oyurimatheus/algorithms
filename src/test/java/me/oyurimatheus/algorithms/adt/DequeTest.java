package me.oyurimatheus.algorithms.adt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DequeTest {

    private Deque<Integer> deque;

    @BeforeEach
    void setup() {
        deque = new Deque<>();
    }

    @Test
    void shouldCreateAnEmptyDeque() {
        assertThat(deque.size()).isEqualTo(0);
        assertThat(deque.isEmpty()).isTrue();
    }

    @Test
    void shouldAddAtRightValuesInDeque() {
        deque.pushRight(1);

        assertThat(deque.size()).isEqualTo(1);
        assertThat(deque.isEmpty()).isFalse();
    }

    @Test
    void shouldRemoveTheLastValueInDeque() {
        deque.pushRight(1);

        assertThat(deque.size()).isEqualTo(1);
        assertThat(deque.isEmpty()).isFalse();

        Integer one = deque.popRight();

        assertThat(one).isEqualTo(1);
        assertThat(deque.size()).isEqualTo(0);
        assertThat(deque.isEmpty()).isTrue();

        deque.pushRight(1);
        deque.pushRight(2);

        Integer two = deque.popRight();

        assertThat(two).isEqualTo(2);
        assertThat(deque.size()).isEqualTo(1);
        assertThat(deque.isEmpty()).isFalse();

    }

    @Test
    void shouldAddElementsOnLeftOfDeque() {
        deque.pushLeft(1);

        assertThat(deque.size()).isEqualTo(1);
        assertThat(deque.isEmpty()).isFalse();
    }

    @Test
    void shouldRemoveTheFirstValueInDeque() {
        deque.pushLeft(1);
        deque.pushLeft(2);

        Integer two = deque.popLeft();

        assertThat(two).isEqualTo(2);
        assertThat(deque.size()).isEqualTo(1);
        assertThat(deque.isEmpty()).isFalse();
    }

    @Test
    void shouldAddTheRightValueInDequeAfterAddInLeft() {
        deque.pushLeft(1);
        deque.pushRight(2);

        assertThat(deque.size()).isEqualTo(2);
        assertThat(deque.isEmpty()).isFalse();
    }

    @Test
    void shouldPopTheRightValueInDequeAfterAddInLeft() {
        deque.pushLeft(1);
        deque.pushRight(2);

        Integer two = deque.popRight();

        assertThat(two).isEqualTo(2);
        assertThat(deque.size()).isEqualTo(1);
        assertThat(deque.isEmpty()).isFalse();
    }

    @Test
    void shouldPopTheLeftValueInDequeAfterAddInRight() {
        deque.pushLeft(1);

        Integer one = deque.popRight();

        assertThat(one).isEqualTo(1);
        assertThat(deque.size()).isEqualTo(0);
        assertThat(deque.isEmpty()).isTrue();
    }

    @Test
    void shouldIterateOverDequeItems() {
        deque.pushRight(1)
             .pushRight(2)
             .pushRight(3);

        Iterator<Integer> iterator = deque.iterator();

        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(1);
        assertThat(iterator.next()).isEqualTo(2);
        assertThat(iterator.next()).isEqualTo(3);
        assertThat(iterator.hasNext()).isFalse();
    }

    @Test
    void shouldThrowAnErrorWhenPopFromAnEmptyDeque() {
        assertThatThrownBy(deque::popLeft)
                .isInstanceOf(UnsupportedOperationException.class)
                .hasMessage("Cannot pop from an empty deque");

        assertThatThrownBy(deque::popRight)
                .isInstanceOf(UnsupportedOperationException.class)
                .hasMessage("Cannot pop from an empty deque");
    }
}