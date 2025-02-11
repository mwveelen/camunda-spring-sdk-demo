package com.incentro.camunda_spring_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.camunda.zeebe.spring.client.annotation.Deployment;

@SpringBootApplication
@Deployment(resources = "classpath:ReallySimpleProcess.bpmn")
public class CamundaSpringDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CamundaSpringDemoApplication.class, args);
	}

}
