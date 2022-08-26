package com.Element.FlowElement.Event;

import java.util.Arrays;
import java.util.List;

import com.Element.FlowElement.FlowElement;

public class End extends FlowElement {

    @Override
    public List<End> getEnds() {
        return Arrays.asList(new End[] { this });

    }
}
