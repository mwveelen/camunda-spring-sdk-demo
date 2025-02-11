package com.incentro.camunda_spring_demo;

import io.camunda.zeebe.client.ZeebeClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.incentro.camunda_spring_demo.model.MessageRequest;

import java.util.Map;

@RestController
@RequestMapping("/")
public class StartFormRestController {

    private static final Logger LOG = LoggerFactory.getLogger(StartFormRestController.class);

    @Autowired
    private ZeebeClient zeebe;

    @PostMapping("/start")
    public void startProcessInstance(@RequestBody Map<String, Object> variables) {

        LOG.info(
                "Starting process ` fiets` with variables: " + variables);

        zeebe
                .newCreateInstanceCommand()
                .bpmnProcessId("ReallySimpleProcess")
                .latestVersion()
                .variables(variables)
                .send();
    }

    @PostMapping("/send-message")
    public void sendMessage(@RequestBody MessageRequest messageRequest) {

        LOG.info("Sending message `" + messageRequest.getMessageName() + "` with variables: "
                + messageRequest.getVariables());

        zeebe
                .newPublishMessageCommand()
                .messageName(messageRequest.getMessageName())
                .correlationKey(messageRequest.getCorrelationKey())
                .variables(messageRequest.getVariables())
                .send();
    }

}
