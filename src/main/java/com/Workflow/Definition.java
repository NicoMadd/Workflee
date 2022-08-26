package com.Workflow;

import java.util.List;

import com.Element.FlowElement.Event.End;
import com.Element.FlowElement.Event.Start;

public class Definition {

    String id;
    String description;

    Start start;

    public Definition() {
        this.start = new Start();
        this.start.setNext(new End());
    }

    public Workflow createWorkflow() {
        return new Workflow(this);
    }

    public Start getFlowStart() {
        return this.start;
    }

    public List<End> getFlowEnds() {
        return this.start.getEnds();
    }

    public Integer getFlowLength() {
        return this.start.countNexts() + 1;
    }

}
