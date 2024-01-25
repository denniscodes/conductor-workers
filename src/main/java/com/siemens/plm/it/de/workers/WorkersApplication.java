package com.siemens.plm.it.de.workers;

import com.netflix.conductor.sdk.workflow.executor.WorkflowExecutor;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class WorkersApplication {

	@Value("${conductor.client.rootUri}")
	private String conductorUri;
	private WorkflowExecutor executor = null;
	@PostConstruct
	public void initWorkers() {
		executor = new WorkflowExecutor(conductorUri);
		executor.initWorkers("com.siemens.plm.it.de.workers");
	}

	@PreDestroy
	public void stopWorkers() {
		executor.shutdown();
	}

	public static void main(String[] args) {
		SpringApplication.run(WorkersApplication.class, args);
	}

}
