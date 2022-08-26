package com.Element;

import java.util.List;

import com.Element.FlowElement.Event.End;

public abstract class Element {

    protected Element next;

    public Element() {
    }

    public void setNext(Element next) {
        this.next = next;
    }

    public void addNext(Element newNext) {
        if (this.next != null) {
            newNext.addNext(this.next);
            this.next = newNext;
        } else {
            this.next = newNext;
        }
    }

    public abstract List<End> getEnds();

    public Integer countNexts() {
        return this.next != null ? this.next.countNexts() + 1 : 0;
    }

}
