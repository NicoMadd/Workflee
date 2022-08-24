package com;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.Workflow.State;
import com.Workflow.Task;
import com.Workflow.Workflow;

public class WorkflowTests {

    @Test
    public void testWorkflow() {
        System.out.println("testWorkflow");
        Workflow workflow = new Workflow();
        System.out.println(workflow);
    }

    @Test
    @DisplayName("Add a new task to the workflow history")

    public void addTaskToWorkflowHistory() {
        Workflow workflow = new Workflow();
        workflow.addTask(new Task());

        List<Task> tasks = workflow.getTasks();
        assertEquals(1, tasks.size());
    }

    @Test
    @DisplayName("New Workflows should have initial state")
    public void newWorkflowShouldHaveInitialState() {
        Workflow workflow = new Workflow();
        State state = workflow.getState();
        assertEquals(state, State.INITIAL);
    }

}
