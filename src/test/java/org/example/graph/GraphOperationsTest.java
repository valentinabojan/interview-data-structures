package org.example.graph;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GraphOperationsTest {

    @Test
    public void bfs() {
        Vertex<String> bob = new Vertex<>("Bob");
        Vertex<String> alice = new Vertex<>("Alice");
        Vertex<String> mark = new Vertex<>("Mark");
        Vertex<String> rob = new Vertex<>("Rob");
        Vertex<String> maria = new Vertex<>("Maria");

        Graph graph = new Graph();
        graph.addVertex(bob);
        graph.addVertex(alice);
        graph.addVertex(mark);
        graph.addVertex(rob);
        graph.addVertex(maria);
        graph.addEdge(bob, alice);
        graph.addEdge(bob, rob);
        graph.addEdge(alice, mark);
        graph.addEdge(rob, mark);
        graph.addEdge(alice, maria);
        graph.addEdge(rob, maria);

        List<Vertex> bfs = new GraphOperations().bfs(graph, bob);

        assertThat(bfs).containsExactly(bob, alice, rob, mark, maria);
    }

    @Test
    public void dfs() {
        Vertex<String> bob = new Vertex<>("Bob");
        Vertex<String> alice = new Vertex<>("Alice");
        Vertex<String> mark = new Vertex<>("Mark");
        Vertex<String> rob = new Vertex<>("Rob");
        Vertex<String> maria = new Vertex<>("Maria");

        Graph graph = new Graph();
        graph.addVertex(bob);
        graph.addVertex(alice);
        graph.addVertex(mark);
        graph.addVertex(rob);
        graph.addVertex(maria);
        graph.addEdge(bob, alice);
        graph.addEdge(bob, rob);
        graph.addEdge(alice, mark);
        graph.addEdge(rob, mark);
        graph.addEdge(alice, maria);
        graph.addEdge(rob, maria);

        List<Vertex> dfs = new GraphOperations().dfs(graph, bob);

        assertThat(dfs).containsExactly(bob, rob, maria, mark, alice);
    }

    @Test
    public void dfsRecursive() {
        Vertex<String> bob = new Vertex<>("Bob");
        Vertex<String> alice = new Vertex<>("Alice");
        Vertex<String> mark = new Vertex<>("Mark");
        Vertex<String> rob = new Vertex<>("Rob");
        Vertex<String> maria = new Vertex<>("Maria");

        Graph graph = new Graph();
        graph.addVertex(bob);
        graph.addVertex(alice);
        graph.addVertex(mark);
        graph.addVertex(rob);
        graph.addVertex(maria);
        graph.addEdge(bob, alice);
        graph.addEdge(bob, rob);
        graph.addEdge(alice, mark);
        graph.addEdge(rob, mark);
        graph.addEdge(alice, maria);
        graph.addEdge(rob, maria);

        List<Vertex> dfs = new GraphOperations().dfsRecursive(graph, bob);

        List<List<Vertex>> solutions = List.of(
                List.of(bob, rob, maria, mark, alice),
                List.of(bob, rob, mark, alice, maria),
                List.of(bob, alice, maria, rob, mark),
                List.of(bob, alice, mark, rob, maria)
        );
        assertThat(solutions).contains(dfs);
    }
}