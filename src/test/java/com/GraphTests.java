package com;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.builder.GraphTypeBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.Workflow.State;
import com.Workflow.Task;
import com.Workflow.Workflow;
import com.Workflow.Definition.Definition;

public class GraphTests {

    @Test
    @DisplayName("Test Graph")
    public void testGraph() throws URISyntaxException {
        Graph<URI, DefaultEdge> g = GraphTypeBuilder.<URI, DefaultEdge>undirected().allowingMultipleEdges(true)
                .allowingSelfLoops(false)
                .edgeClass(DefaultEdge.class).weighted(false).buildGraph();

        URI google = new URI("http://www.google.com");
        URI wikipedia = new URI("http://www.wikipedia.org");
        URI jgrapht = new URI("http://www.jgrapht.org");

        // add the vertices
        g.addVertex(google);
        g.addVertex(wikipedia);
        g.addVertex(jgrapht);

        // add edges to create linking structure
        g.addEdge(jgrapht, wikipedia);
        g.addEdge(google, jgrapht);
        g.addEdge(google, wikipedia);
        g.addEdge(wikipedia, google);
        g.addEdge(wikipedia, jgrapht);
        g.addEdge(wikipedia, wikipedia);

        System.out.println(g);
    }
}