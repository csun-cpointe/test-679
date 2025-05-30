package org.test;

/*-
 * #%L
 * Test Helmfile Deploy Pipeline Commands::Pipelines::Persist Pipeline
 * %%
 * Copyright (C) 2021 Booz Allen Hamilton Inc.
 * %%
 * All Rights Reserved. You may not copy, reproduce, distribute, publish, display,
 * execute, modify, create derivative works of, transmit, sell or offer for resale,
 * or in any way exploit any part of this solution without Booz Allen Hamilton's
 * express written permission.
 * #L%
 */

import static org.awaitility.Awaitility.await;
import static org.junit.Assert.assertTrue;

import java.util.List;

import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.spi.CDI;

import org.eclipse.microprofile.reactive.messaging.Message;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.smallrye.reactive.messaging.memory.InMemoryConnector;
import io.smallrye.reactive.messaging.memory.InMemorySink;

/**
 * Implementation steps for pipeline.feature.
 *
 * GENERATED STUB CODE - PLEASE ***DO*** MODIFY
 *
 * Originally generated from: templates/cucumber.pipeline.steps.java.vm 
 */
public class PipelineSteps {
	
    private InMemoryConnector connector;

    @Before("@pipeline")
    public void setUp() {
        // test objects to initialize before each scenario
        SparkTestHarness.getSparkSession();
        connector = CDI.current().select(InMemoryConnector.class, new Any.Literal()).get();
    }

    @After("@pipeline")
    public void tearDown() {
        // test objects to clear after each scenario
    }
    
    @Given("a precondition")
    public void a_precondition() {
        // code up the items you need before performing your action
    }
    
    @When("an action occurs")
    public void an_action_occurs() {
        // execute your action
        
    }
    @Then("a postcondition results")
    public void a_postcondition_results() {
        // check for expected postconditions - continue to use normal assert pattern within tests
        assertTrue(true);
    }    
    
    /**
     * Use this method, along with the configureMessagingChannels() method in {@link SparkTestHarness} to handle messaging in your
     * tests without having to stand up your messaging broker (e.g., Kafka) or use sleep commands.
     */
    @SuppressWarnings("unchecked")
    private List<Message<Object>> getPublishedMessages(String outgoingChannel) {
        // await the results as timing can vary - use this pattern and not sleep, which will add a lot of unnecessary
        // time to your builds:
        InMemorySink<Object> sink = connector.sink(outgoingChannel);
        
        await().<List<? extends Message<Object>>> until(sink::received, t -> t.size() >= 1);
        // return the messages that were published to the given outgoing channel
        return (List<Message<Object>>) sink.received();
    } 
}
