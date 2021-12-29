package org.example.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

import static org.example.graph.Color.BLACK;
import static org.example.graph.Color.GREY;
import static org.example.graph.Color.WHITE;

public class GraphOperations {

    public List<Vertex> bfs(Graph graph, Vertex source) {
        List<Vertex> bfsResult = new ArrayList<>();

        Queue<Vertex> queue = new LinkedList<>();
        source.setColor(GREY);
        queue.add(source);

        while (!queue.isEmpty()) {
            Vertex vertex = queue.poll();

            List<Vertex> unvisitedNeighbors = graph.getNeighbors(vertex).stream()
                .filter(v -> v.getColor() == WHITE)
                .collect(Collectors.toList());

            unvisitedNeighbors.forEach(neighbor -> {
                neighbor.setColor(GREY);
                queue.add(neighbor);
            });

            bfsResult.add(vertex);
            vertex.setColor(BLACK);
        }

        return bfsResult;
    }

    public List<Vertex> dfs(Graph graph, Vertex source) {
        List<Vertex> dfsResult = new ArrayList<>();

        Stack<Vertex> stack = new Stack<>();
        source.setColor(GREY);
        stack.push(source);

        while (!stack.isEmpty()) {
            Vertex vertex = stack.pop();

            List<Vertex> unvisitedNeighbors = graph.getNeighbors(vertex).stream()
                .filter(v -> v.getColor() == WHITE)
                .collect(Collectors.toList());

            unvisitedNeighbors.forEach(neighbor -> {
                neighbor.setColor(GREY);
                stack.push(neighbor);
            });

            dfsResult.add(vertex);
            vertex.setColor(BLACK);
        }

        return dfsResult;
    }

    public void dfsRecursiveAux(Graph graph, Vertex source, List<Vertex> dfsResult) {
        dfsResult.add(source);
        source.setColor(GREY);

        for (Vertex vertex : graph.getNeighbors(source)) {
            if (vertex.getColor() == WHITE) {
                vertex.setColor(GREY);
                dfsRecursiveAux(graph, vertex, dfsResult);
            }
        }

        source.setColor(BLACK);
    }

    public List<Vertex> dfsRecursive(Graph graph, Vertex source) {
        List<Vertex> dfsResult = new ArrayList<>();
        dfsRecursiveAux(graph, source, dfsResult);

        return dfsResult;
    }
}
