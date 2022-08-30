package com.Graph;

import java.util.List;

import com.Graph.Node.Node;

public class TrackingGraph<T> extends Graph<T> {

    Node<T> actualNode = null;

    public TrackingGraph() {
        super();
    }

    public TrackingGraph(List<Node<T>> nodes) {
        super(nodes);
        this.actualNode = nodes.get(0);
    }

    public Node<T> getActualNode() {
        return actualNode;
    }

    public void moveTo(Node<T> node) {
        if (this.has(node) && this.getActualNode().canMoveTo(node))
            actualNode = node;
    }

}
