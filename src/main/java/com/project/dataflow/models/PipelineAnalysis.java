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

}
