package com.incentro.camunda_spring_demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;

@Component
public class Worker {

    private static final Logger LOG = LoggerFactory.getLogger(Worker.class);

    @JobWorker(type = "maarten-foo")
    public void handleJobFoo(final ActivatedJob job) {
        LOG.info("Job handled");
    }

}
