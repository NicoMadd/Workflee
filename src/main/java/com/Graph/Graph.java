package com.Graph;

import java.util.LinkedList;
import java.util.List;

import com.Graph.Node.Node;

public class Graph<T> {

    private List<Node<T>> nodes;

    public Graph() {
        this.nodes = new LinkedList<>();
    }

    public Graph(List<Node<T>> nodes) {
        this.nodes = nodes;
    }

    public List<Node<T>> getNodes() {
        return this.nodes;
    }

    protected boolean has(Node<T> node) {
        return this.nodes.contains(node);
    }

}
