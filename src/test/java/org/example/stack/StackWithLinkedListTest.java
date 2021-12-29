package org.example.stack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StackWithLinkedListTest {

    @Test
    public void stackWithLinkedList() {
        StackWithLinkedList<Integer> stack = new StackWithLinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);

        assertThat(stack.pop()).isEqualTo(3);
        assertThat(stack.pop()).isEqualTo(2);
        assertThat(stack.pop()).isEqualTo(1);
    }

    @Test
    public void stackWithArray() {
        StackWithArray stack = new StackWithArray();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);

        assertThat(stack.pop()).isEqualTo(5);
        assertThat(stack.pop()).isEqualTo(4);
        assertThat(stack.pop()).isEqualTo(3);
        assertThat(stack.pop()).isEqualTo(2);
        assertThat(stack.pop()).isEqualTo(1);
    }

}