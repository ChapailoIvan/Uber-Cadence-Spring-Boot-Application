package by.chapailo.weatherapp.controllers;

import by.chapailo.weatherapp.cadence.AppWorkflow;
import com.uber.cadence.client.WorkflowClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ApplicationController {
    private final WorkflowClient workflowClient;

    public ApplicationController(WorkflowClient workflowClient) {
        this.workflowClient = workflowClient;
    }

    @GetMapping("/weather")
    public String home(@RequestParam String location, Model model) {
        AppWorkflow workflow = workflowClient.newWorkflowStub(AppWorkflow.class);
        WorkflowClient.start(workflow::start, location);

        model.addAttribute( "title", location);

        return "home";
    }

}
