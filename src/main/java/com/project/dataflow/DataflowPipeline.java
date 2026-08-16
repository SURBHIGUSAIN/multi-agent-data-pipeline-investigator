package com.project.dataflow;

import java.util.Map;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.transforms.Create;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataflowPipeline {
    private static final Logger logger = LoggerFactory.getLogger(DataflowPipeline.class);

    public static void main(String[] args) {
        Pipeline pipeline = Pipeline.create();

        PCollection<Map<String, String>> input = pipeline.apply("Create Map Data", Create.of(
            Map.of("name", "Alice", "age", "25"),
            Map.of("name", "Bob", "age", "31"),
            Map.of("name", "Charlie", "age", "INVALID")
        ));

        PCollection<String> upperCaseOutput = input.apply("Uppercase", ParDo.of(new DoFn<Map<String, String>, String>() {
            @ProcessElement
            public void processElement(ProcessContext c) {
                Map<String, String> input = c.element();
                String name = input.get("name");
                String age = input.get("age");
                if ("CRASH".equals(name)) {
                    logger.error("Encountered CRASH input, throwing exception.");
                    throw new RuntimeException("Simulated crash for input: " + name);
                }
                String upperCaseOutput = name.toUpperCase();
                Integer ageInt = Integer.parseInt(age);
            logger.info("Name: " + name + ", Age: " + ageInt);
            c.output(upperCaseOutput);
        }
    }));

    upperCaseOutput.apply("Write to File", TextIO.write().to("output.txt").withoutSharding());

        pipeline.run().waitUntilFinish();
    }
}