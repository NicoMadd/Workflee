package com;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.Workflow.Definition;
import com.Workflow.State;
import com.Workflow.Task;
import com.Workflow.Workflow;

public class WorkflowTests {

    @Test
    @DisplayName("Workflow should have a definition")
    public void workflowShouldHaveDefinition() {
        new Workflow(new Definition());
    }

    @Test
    @DisplayName("Add a new task to the workflow history")
    public void addTaskToWorkflowHistory() {
        Definition definition = new Definition();
        Workflow workflow = definition.createWorkflow();
        workflow.addTask(new Task());

        List<Task> tasks = workflow.getTasks();
        assertEquals(1, tasks.size());
    }

    @Test
    @DisplayName("New Workflows should have initial state")
    public void newWorkflowShouldHaveInitialState() {
        Definition definition = new Definition();
        Workflow workflow = definition.createWorkflow();
        State state = workflow.getState();
        assertEquals(state, State.INITIAL);
    }

}