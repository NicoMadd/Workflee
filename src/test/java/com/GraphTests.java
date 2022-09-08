package com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;

import com.Graph.Graph;
import com.Graph.TrackingGraph;
import com.Graph.Node.Node;
import com.Graph.Node.RestrictableNode;
import com.Graph.Node.Restriction.Restriction;

public class GraphTests {

    public List<Node<Object>> getSequentialNodes() {
        // Create 3 nodes and relate sequentially to each
        Node<Object> node1 = new Node<>();
        Node<Object> node2 = new Node<>();
        Node<Object> node3 = new Node<>();

        node1.addOutgoing(node2);
        node2.addOutgoing(node3);
        node3.addOutgoing(node1);

        return Arrays.asList(node1, node2, node3);
    }

    public TrackingGraph<Object> getTrackingGraph(List<Node<Object>> nodes) {
        return new TrackingGraph<>(nodes);
    }

    @Test
    public void createAGraph() {
        Graph<Object> graph = new Graph<>();
        assertNotNull(graph);
    }

    @Test
    public void graphHasANumberOfNodes() {
        Graph<Object> graph = new Graph<>();
        List<Node<Object>> nodes = graph.getNodes();
        assertTrue(nodes != null && nodes.size() >= 0);
    }

    @Test
    public void nodesHaveARelationshipWithOtherNodes() {
        Node<Object> node = new Node<>();
        List<Node<Object>> neighbors = node.getNeighbors();
        assertTrue(neighbors != null && neighbors.size() >= 0);
    }

    @Test
    public void usersCanUseAGraphAndKnowWhereTheyAre() {

        TrackingGraph<Object> graph = getTrackingGraph(getSequentialNodes());

        Node<?> actualNode = graph.getActualNode();

        assertTrue(actualNode != null);
    }

    @Test
    public void usersCanMoveThroughNodes() {

        TrackingGraph<Object> graph = getTrackingGraph(getSequentialNodes());

        Node<Object> actualNode = graph.getActualNode();

        List<Node<Object>> neighbors = actualNode.getNeighbors();

        int nextInt = new Random().nextInt(neighbors.size());

        Node<Object> nextNode = neighbors.get(nextInt);
        graph.moveTo(nextNode);

        actualNode = graph.getActualNode();

        assertTrue(actualNode != null && nextNode.equals(actualNode));
    }

    @Test
    public void nodeCanBeOfASpecificType() {

        String storedData = "And now for something completely different";

        // Create a typed node
        Node<String> node = new Node<>();

        // At first the data inside is null

        String data = node.getData();

        assertTrue(data == null);

        // Once set, it should have that value

        node.setData(storedData);

        data = node.getData();

        assertEquals(storedData, data);
    }

    @Test
    public void aNodeDifferencesBetweenOutgoingsAndIncomings() {
        Node<Integer> node = new Node<>();

        // add two nodes, one incoming and one outgoing

        Node<Integer> nodeOut = new Node<>();
        Node<Integer> nodeIn = new Node<>();

        node.addOutgoing(nodeOut);
        node.addIncoming(nodeIn);

        assertNotEquals(nodeOut, nodeIn);
        assertEquals(node.getIncomings().size(), 1);
        assertEquals(node.getOutgoings().size(), 1);
        assertEquals(node.getNeighbors().size(), 2);
        assertNotEquals(node.getIncomings().get(0), node.getOutgoings().get(0));
    }

    @Test
    public void restrictableNodeWithRestriction() {
        RestrictableNode<Integer> restrictedNode = new RestrictableNode<>();

        // create an outgoing node
        Node<Integer> outgoing = new Node<>();

        // set data to 1
        outgoing.setData(1);

        // add the outgoing node to the restrictedNode
        restrictedNode.addOutgoing(outgoing);

        // create a restriction and add it to the restricted node
        Restriction<Integer> restriction = Restriction.predicate(n -> {
            return n.getData() > 0;
        });
        restrictedNode.addRestriction(restriction);

        // join node into a list
        List<Node<Integer>> nodes = Arrays.asList(restrictedNode, outgoing);

        // create a tracking graph
        TrackingGraph<Integer> trackingGraph = new TrackingGraph<>(nodes);
        trackingGraph.moveTo(outgoing);

        assertTrue(trackingGraph.getActualNode().equals(outgoing));

    }

    @Test
    public void restrictableNodeWithRestrictionTwoLeaps() {

        // Create two restriction nodes and one simple node

        RestrictableNode<Integer> firstRestrictedNode = new RestrictableNode<>();
        RestrictableNode<Integer> secondRestrictedNode = new RestrictableNode<>();
        Node<Integer> outgoing = new Node<>();

        // set datas to the nodes
        firstRestrictedNode.setData(0);
        secondRestrictedNode.setData(1);
        outgoing.setData(1);

        // add the secondRestrictedNode to the firstRestrictedNode
        firstRestrictedNode.addOutgoing(secondRestrictedNode);

        // add the outgoing node to the second restrictedNode
        secondRestrictedNode.addOutgoing(outgoing);

        // create a restriction and add it to the first restricted node
        Restriction<Integer> moreThanZeroRest = Restriction.predicate(n -> {
            return n.getData() > 0;
        });
        firstRestrictedNode.addRestriction(moreThanZeroRest);

        // create a restriction and add it to the second restricted node

        Restriction<Integer> moreThanHundredRest = Restriction.predicate(n -> {
            return n.getData() > 100;
        });
        secondRestrictedNode.addRestriction(moreThanHundredRest);

        // join nodes into a list
        List<Node<Integer>> nodes = Arrays.asList(firstRestrictedNode, secondRestrictedNode, outgoing);

        // create a tracking graph
        TrackingGraph<Integer> trackingGraph = new TrackingGraph<>(nodes);
        trackingGraph.moveTo(secondRestrictedNode);

        assertEquals(trackingGraph.getActualNode(), secondRestrictedNode);

        trackingGraph.moveTo(outgoing);

        assertNotEquals(trackingGraph.getActualNode(), outgoing);

    }

}
