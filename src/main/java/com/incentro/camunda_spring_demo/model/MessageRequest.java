package com.incentro.camunda_spring_demo.model;

import java.util.Map;

public class MessageRequest {
    private String messageName;
    private String correlationKey;
    private Map<String, Object> variables;

    // Getters and setters
    public String getMessageName() {
        return messageName;
    }

    public void setMessageName(String messageName) {
        this.messageName = messageName;
    }

    public String getCorrelationKey() {
        return correlationKey;
    }

    public void setCorrelationKey(String correlationKey) {
        this.correlationKey = correlationKey;
    }

    public Map<String, Object> getVariables() {
        return variables;
    }

    public void setVariables(Map<String, Object> variables) {
        this.variables = variables;
    }
}
