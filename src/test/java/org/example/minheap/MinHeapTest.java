package org.example.minheap;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MinHeapTest {

    @Test
    public void minHeap() {
        MinHeap minHeap = new MinHeap();

        minHeap.push(4);
        minHeap.push(6);
        minHeap.push(2);
        minHeap.push(1);
        minHeap.push(7);
        minHeap.push(3);

        assertThat(minHeap.getHeap()).containsExactly(1, 2, 3, 6, 7, 4);

        int pop = minHeap.pop();
        assertThat(pop).isEqualTo(1);
        assertThat(minHeap.getHeap()).containsExactly(2, 4, 3, 6, 7);

        pop = minHeap.pop();
        assertThat(pop).isEqualTo(2);
        assertThat(minHeap.getHeap()).containsExactly(3, 4, 7, 6);

        pop = minHeap.pop();
        assertThat(pop).isEqualTo(3);
        assertThat(minHeap.getHeap()).containsExactly(4, 6, 7);

        pop = minHeap.pop();
        assertThat(pop).isEqualTo(4);
        assertThat(minHeap.getHeap()).containsExactly(6, 7);

        pop = minHeap.pop();
        assertThat(pop).isEqualTo(6);
        assertThat(minHeap.getHeap()).containsExactly(7);

        pop = minHeap.pop();
        assertThat(pop).isEqualTo(7);
        assertThat(minHeap.getHeap()).isEmpty();
    }

}