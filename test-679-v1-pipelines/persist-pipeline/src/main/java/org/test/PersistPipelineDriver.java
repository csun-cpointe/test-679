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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.spi.CDI;

import org.test.pipeline.PipelineBase;

/**
 * Configures the steps needed to run a Spark-based implementation for PersistPipeline.
 *
 * This pipeline serves the following purpose: ${pipeline.description}.
 *
 * Please **DO** modify with your customizations, as appropriate.
 *
 * Originally generated from: templates/pipeline.driver.impl.java.vm 
 */
public class PersistPipelineDriver extends PersistPipelineBaseDriver {

  private static final Logger logger = LoggerFactory.getLogger(PersistPipelineDriver.class);
  
  public static void main(String[] args) {
    logger.info("STARTED: {} driver --------------------- updated", "PersistPipeline");
    PersistPipelineBaseDriver.main(args);



    final DeltaLakeStep deltaLakeStep = CDI.current().select(DeltaLakeStep.class, new Any.Literal()).get();
    deltaLakeStep.executeStep();
  }
}
