package com.Definition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.Element.FlowElement.Activity.Task;
import com.Element.FlowElement.Event.Start;
import com.Workflow.Definition.Definition;

public class DefinitionTwoTasks {

    // @Test
    // @DisplayName("Add a Task to the Flow")
    // public void addActivityToFlow() {
    // Definition definition = new Definition();
    // Task task = new Task();
    // definition.getFlowStart().addNext(task);

    // // flow length should be 3
    // assertEquals(3, definition.getFlowLength());

    // }

    // @Test
    // @DisplayName("Add a Task to the Flow, verify definition has a Start Event")
    // public void addActivityToFlowWithStartEvent() {
    // Definition definition = new Definition();
    // Task task = new Task();
    // definition.getFlowStart().addNext(task);
    // assertEquals(definition.getFlowStart().getClass(), Start.class);
    // }

    // @Test
    // @DisplayName("Add a Task to the Flow, verify definition has an End Event")
    // public void addActivityToFlowWithEndEvent() {
    // Definition definition = new Definition();
    // Task task = new Task();
    // definition.getFlowStart().addNext(task);

    // assertTrue(definition.getFlowEnds().size() > 0);
    // }

    // @Test
    // @DisplayName("Add two Tasks to the Flow")
    // public void addTwoTasksToFlow() {
    // Definition definition = new Definition();
    // Task task1 = new Task();
    // Task task2 = new Task();
    // definition.getFlowStart().addNext(task1);
    // definition.getFlowStart().addNext(task2);

    // // flow length should be 4
    // assertEquals(4, definition.getFlowLength());
    // }

    // @Test
    // @DisplayName("Add two Tasks to the Flow, verify definition has a Start
    // Event")
    // public void addTwoActivitiesToFlowWithStartEvent() {
    // Definition definition = new Definition();
    // Task task = new Task();
    // definition.getFlowStart().addNext(task);
    // assertEquals(definition.getFlowStart().getClass(), Start.class);
    // }

    // @Test
    // @DisplayName("Add two Tasks to the Flow, verify definition has an End Event")
    // public void addTwoActivitiesToFlowWithEndEvent() {
    // Definition definition = new Definition();
    // Task task = new Task();
    // definition.getFlowStart().addNext(task);

    // assertTrue(definition.getFlowEnds().size() > 0);
    // }

}