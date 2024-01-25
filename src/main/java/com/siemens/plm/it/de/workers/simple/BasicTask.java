package com.siemens.plm.it.de.workers.simple;

import com.netflix.conductor.common.metadata.tasks.Task;
import com.netflix.conductor.common.metadata.tasks.TaskResult;
import com.netflix.conductor.sdk.workflow.task.WorkerTask;

public class BasicTask {
    @WorkerTask("basic_task")
    public TaskResult basicTask(Task task) {
        var result = new TaskResult(task);
        result.log("basic task has been called.");
        result.setStatus(TaskResult.Status.COMPLETED);
        return result;
    }
}
