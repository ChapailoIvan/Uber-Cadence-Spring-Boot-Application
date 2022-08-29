package by.chapailo.weatherapp.cadence;

import com.uber.cadence.workflow.WorkflowMethod;

public interface AppWorkflow {
    @WorkflowMethod(executionStartToCloseTimeoutSeconds = 10, taskList = AppWorkflowImpl.TASK_LIST)
    void start(String city);
}
