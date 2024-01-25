package com.siemens.plm.it.de.workers.simple;

import com.netflix.conductor.sdk.workflow.task.InputParam;
import com.netflix.conductor.sdk.workflow.task.OutputParam;
import com.netflix.conductor.sdk.workflow.task.WorkerTask;

public class SimpleTask {
    @WorkerTask(value = "spring_task", threadCount = 4, pollingInterval = 5)
    public @OutputParam("response") String springTask(@InputParam("request") String request) {
        return String.format("Received [%s]", request);
    }
}
