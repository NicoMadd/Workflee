package com.Workflow.Definition;

import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.GraphType;
import org.jgrapht.graph.DefaultEdge;

import com.Element.FlowElement.Event.End;
import com.Element.FlowElement.Event.Start;
import com.Workflow.Task;
import com.Workflow.Workflow;

public class Definition {

    String id;
    String description;

    Graph<Task, DefaultEdge> graph;

    public Definition(String id, String description, Graph<Task, DefaultEdge> graph) {
        this.id = id;
        this.description = description;
        GraphType type = graph.getType();
        if (type.isAllowingMultipleEdges() && !type.isWeighted() && type.isDirected() && type.isAllowingCycles()
                && !type.isAllowingSelfLoops())
            this.graph = graph;
        else
            throw new IllegalArgumentException("Graph type is not allowed for Definition");
    }

    public Workflow createWorkflow() {
        return new Workflow(this);
    }

}
