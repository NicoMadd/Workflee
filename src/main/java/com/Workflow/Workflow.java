package com.Workflow;

import java.util.LinkedList;
import java.util.List;

import com.Workflow.Definition.Definition;

public class Workflow {

    String id;
    State state = State.INITIAL;
    Definition definition;
    List<Task> tasksHistory = null;

    public Workflow(Definition definition) {
        tasksHistory = new LinkedList<Task>();
        this.definition = definition;
    }

    public State getState() {
        return state;
    }

    @Override
    public String toString() {
        return "Workflow [state=" + state + "]";
    }

    public void addTask(Task task) {
        this.tasksHistory.add(task);
    }

    public List<Task> getTasks() {
        return this.tasksHistory;
    }

}
