package com.Graph.Node.Restriction;

import java.util.function.Predicate;

import com.Graph.Node.Node;

public class PredicateRestriction<T> extends Restriction<T> {

    private Predicate<Node<? extends T>> predicate;

    public PredicateRestriction(Predicate<Node<? extends T>> predicate) {
        super();
        this.predicate = predicate;
    }

    public boolean evaluate(Node<T> node) {
        return predicate.test(node);
    }

}
