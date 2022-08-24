package com.Workflow;

public enum State {
    INITIAL("Initial"),
    ACTIVE("Active"),
    INACTIVE("Inactive"),
    ERROR("Error"),
    FINISHED("Finished"),
    CANCELLED("Cancelled");

    private final String description;

    State(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
