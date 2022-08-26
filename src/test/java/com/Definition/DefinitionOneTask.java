package com.Definition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.Element.Element;
import com.Element.FlowElement.Activity.Task;
import com.Element.FlowElement.Event.End;
import com.Element.FlowElement.Event.Start;
import com.Element.Step.Step;
import com.Workflow.Definition;
import com.Workflow.State;
import com.Workflow.Workflow;

public class DefinitionOneTask {

    @Test
    @DisplayName("Add a Task to the Flow")
    public void addActivityToFlow() {
        Definition definition = new Definition();
        Task task = new Task();
        definition.getFlowStart().addNext(task);

        // flow length should be 3
        assertEquals(3, definition.getFlowLength());

    }

    @Test
    @DisplayName("Add a Task to the Flow, verify definition has a Start Event")
    public void addActivityToFlowWithStartEvent() {
        Definition definition = new Definition();
        Task task = new Task();
        definition.getFlowStart().addNext(task);
        assertEquals(definition.getFlowStart().getClass(), Start.class);
    }

    @Test
    @DisplayName("Add a Task to the Flow, verify definition has an End Event")
    public void addActivityToFlowWithEndEvent() {
        Definition definition = new Definition();
        Task task = new Task();
        definition.getFlowStart().addNext(task);

        assertTrue(definition.getFlowEnds().size() > 0);
    }

}