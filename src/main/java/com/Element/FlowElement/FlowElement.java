package com.Element.FlowElement;

import java.util.List;

import com.Element.Element;
import com.Element.FlowElement.Event.End;

public abstract class FlowElement extends Element {

    public List<End> getEnds() {
        return this.next.getEnds();
    }

}
