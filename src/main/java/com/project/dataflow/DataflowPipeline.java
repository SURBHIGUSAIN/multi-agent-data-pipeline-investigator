package com.project.dataflow;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.transforms.Create;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;

public class DataflowPipeline {

    public static void main(String[] args) {
        Pipeline pipeline = Pipeline.create();

        PCollection<String> input = pipeline.apply("Create String Data", Create.of("Alice", "Bob", "Charlie", "David"));

        PCollection<String> upperCaseOutput = input.apply("Uppercase", ParDo.of(new DoFn<String, String> () {
        @ProcessElement
        public void processElement(ProcessContext c) {
            String input = c.element();
            String upperCaseOutput = input.toUpperCase();
            c.output(upperCaseOutput);
        }
    }));

        pipeline.run().waitUntilFinish();
    }
}