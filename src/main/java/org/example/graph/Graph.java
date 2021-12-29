package org.example.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private Map<Vertex, List<Vertex>> vertices;

    public Graph() {
        this.vertices = new HashMap<>();
    }

    public void addVertex(Vertex vertex) {
        vertices.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(Vertex v1, Vertex v2) {
        vertices.get(v1).add(v2);
        vertices.get(v2).add(v1);
    }

    public List<Vertex> getNeighbors(Vertex vertex) {
        return vertices.get(vertex);
    }

}
