package com.Graph.Node;

import java.util.LinkedList;
import java.util.List;

import com.Graph.Node.Restriction.Restriction;

public class RestrictableNode<T> extends Node<T> {

    private List<Restriction<T>> restrictions;

    public RestrictableNode() {
        restrictions = new LinkedList<>();
    }

    @Override
    public boolean canMoveTo(Node<T> node) {
        return restrictions.stream().allMatch(rest -> rest.evaluate(node));
    }

    public void addRestriction(Restriction<T> restriction) {
        restrictions.add(restriction);
    }

}
