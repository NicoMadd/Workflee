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

public class DefinitionTests {

    @Test
    @DisplayName("Definition should create a workflow")
    public void definitionShouldCreateWorkflow() {
        Workflow createWorkflow = new Definition().createWorkflow();
        assertEquals(createWorkflow.getClass(), Workflow.class);
    }

    @Test
    @DisplayName("Definition should have a Start Event")
    public void definitionShouldHaveStartEvent() {
        Definition definition = new Definition();
        Element start = definition.getFlowStart();
        assertEquals(start.getClass(), Start.class);
    }

    @Test
    @DisplayName("Definition should have an End Event")
    public void definitionShouldHaveEndEvent() {
        Definition definition = new Definition();
        List<End> ends = definition.getFlowEnds();
        assertTrue(ends.size() > 0);
    }

}