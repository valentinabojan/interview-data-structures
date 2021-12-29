package org.example.graph;

import java.util.Objects;

public class Vertex<T> {

    private T data;
    private Color color;

    public Vertex(T data) {
        this.data = data;
        this.color = Color.WHITE;
    }

    public T getData() {
        return data;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vertex)) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return Objects.equals(data, vertex.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
