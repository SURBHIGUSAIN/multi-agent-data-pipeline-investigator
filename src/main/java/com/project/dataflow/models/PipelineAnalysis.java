package com.project.dataflow.models;

import java.util.List;

public class PipelineAnalysis {

    public enum Confidence {
        HIGH,
        MEDIUM,
        LOW
    }

    private String failedComponent;
    private String failureType;
    private List<String> evidence;
    private Confidence confidence;

    public PipelineAnalysis(String failedComponent, String failureType, List<String> evidence, Confidence confidence) {
        this.failedComponent = failedComponent;
        this.failureType = failureType;
        this.evidence = evidence;
        this.confidence = confidence;
    }

}
