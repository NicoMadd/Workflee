package com.Workflow.Definition;

import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.GraphType;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.builder.GraphTypeBuilder;

import com.Element.FlowElement.Event.End;
import com.Element.FlowElement.Event.Start;
import com.Workflow.Task;
import com.Workflow.Workflow;

public class DefinitionBuilder {

    String id = null;
    String description = null;
    Graph<Task, DefaultEdge> graph = null;

    public DefinitionBuilder() {
        this.graph = GraphTypeBuilder.<Task, DefaultEdge>undirected().allowingMultipleEdges(true)
                .allowingSelfLoops(false)
                .edgeClass(DefaultEdge.class).weighted(false).buildGraph();
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
