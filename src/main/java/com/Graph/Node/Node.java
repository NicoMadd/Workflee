package com.Graph.Node;

import java.util.LinkedList;
import java.util.List;

public class Node<T> {

    private T data = null;

    private List<Node<?>> outgoings;
    private List<Node<?>> incomings;

    public Node() {
        this.outgoings = new LinkedList<>();
        this.incomings = new LinkedList<>();
    }

    public Node(T data) {
        this.data = data;
        this.outgoings = new LinkedList<>();
        this.incomings = new LinkedList<>();
    }

    public Node(List<Node<?>> outcoming, List<Node<?>> incomings) {
        this.outgoings = outcoming;
        this.incomings = incomings;
    }

    public Node(List<Node<?>> outgoings, List<Node<?>> incomings, T data) {
        this.data = data;
        this.outgoings = outgoings;
        this.incomings = incomings;
    }

    public List<Node<?>> getNeighbors() {
        LinkedList<Node<?>> linkedList = new LinkedList<>();
        linkedList.addAll(outgoings);
        linkedList.addAll(incomings);
        return linkedList;
    }

    public List<Node<?>> getOutgoings() {
        return outgoings;
    }

    public List<Node<?>> getIncomings() {
        return incomings;
    }

    public void addIncoming(Node<?> incoming) {
        this.incomings.add(incoming);
    }

    public void addOutgoing(Node<?> outgoing) {
        this.outgoings.add(outgoing);
    }

    public boolean isNeighbor(Node<?> neighbor) {
        return this.incomings.contains(neighbor) || this.outgoings.contains(neighbor);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean canMoveTo(Node<T> node) {
        return true;
    }

}
