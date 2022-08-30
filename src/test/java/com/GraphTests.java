package com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;

import com.Graph.Graph;
import com.Graph.TrackingGraph;
import com.Graph.Node.Node;
import com.Graph.Node.RestrictableNode;

public class GraphTests {

    public List<Node<?>> getSequentialNodes() {
        // Create 3 nodes and relate sequentially to each
        Node<?> node1 = new Node<>();
        Node<?> node2 = new Node<>();
        Node<?> node3 = new Node<>();

        node1.addOutgoing(node2);
        node2.addOutgoing(node3);
        node3.addOutgoing(node1);

        return Arrays.asList(new Node[] { node1, node2, node3 });
    }

    public TrackingGraph getTrackingGraph(List<Node<?>> nodes) {
        return new TrackingGraph(nodes);
    }

    @Test
    public void createAGraph() {
        Graph graph = new Graph();
    }

    @Test
    public void graphHasANumberOfNodes() {
        Graph graph = new Graph();
        List<Node<?>> nodes = graph.getNodes();
        assertTrue(nodes != null && nodes.size() >= 0);
    }

    @Test
    public void nodesHaveARelationshipWithOtherNodes() {
        Node<?> node = new Node<>();
        List<Node<?>> neighbors = node.getNeighbors();
        assertTrue(neighbors != null && neighbors.size() >= 0);
    }

    @Test
    public void usersCanUseAGraphAndKnowWhereTheyAre() {

        TrackingGraph graph = getTrackingGraph(getSequentialNodes());

        Node<?> actualNode = graph.getActualNode();

        assertTrue(actualNode != null);
    }

    @Test
    public void usersCanMoveThroughNodes() {

        TrackingGraph graph = getTrackingGraph(getSequentialNodes());

        Node<?> actualNode = graph.getActualNode();

        List<Node<?>> neighbors = actualNode.getNeighbors();

        int nextInt = new Random().nextInt(neighbors.size());

        Node<?> nextNode = neighbors.get(nextInt);
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

    // @Test
    // public void restrictableNodeWithouteRestriction() {
    // RestrictableNode<Integer> node = new RestrictableNode<>();

    // // add an outgoing node

    // Node<Integer> outgoing = new Node<>();
    // node.addOutgoing(outgoing);

    // }

}
