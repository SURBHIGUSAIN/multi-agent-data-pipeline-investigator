package com.project.dataflow.models;

import java.util.List;

public class IncidentState {

    private String stackTrace;
    private List<String> logs;
    private PipelineAnalysis pipelineAnalysis;

    public IncidentState(String stackTrace, List<String> logs, PipelineAnalysis pipelineAnalysis) {
        this.stackTrace = stackTrace;
        this.logs = logs;
        this.pipelineAnalysis = pipelineAnalysis;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public List<String> getLogs() {
        return logs;
    }
    public PipelineAnalysis getPipelineAnalysis() {
        return pipelineAnalysis;
    }

    public void setPipelineAnalysis(PipelineAnalysis pipelineAnalysis) {
        this.pipelineAnalysis = pipelineAnalysis;
    }

}
