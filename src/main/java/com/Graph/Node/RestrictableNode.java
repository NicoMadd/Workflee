package com.Graph.Node;

import java.util.LinkedList;
import java.util.List;

public class RestrictableNode<T> extends Node<T> {

    private List<Restriction<T>> restrictions;

    public RestrictableNode() {
        restrictions = new LinkedList<Restriction<T>>();
    }

    @Override
    public boolean canMoveTo(Node<T> node) {
        return restrictions.stream().allMatch(rest -> rest.evaluate(node));
    }

}
