package by.chapailo.weatherapp.config;

import by.chapailo.weatherapp.cadence.AppWorkflowImpl;
import by.chapailo.weatherapp.cadence.WeatherAppActivitiesImpl;
import com.uber.cadence.worker.Worker;
import com.uber.cadence.worker.WorkerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class CadenceWorkerStarter {
    private final WorkerFactory workerFactory;

    public CadenceWorkerStarter(WorkerFactory workerFactory) {
        this.workerFactory = workerFactory;
    }

    @PostConstruct
    public void startWorkerFactory() {
        Worker worker = workerFactory.newWorker(AppWorkflowImpl.TASK_LIST);

        worker.registerWorkflowImplementationTypes(AppWorkflowImpl.class);
        worker.registerActivitiesImplementations(new WeatherAppActivitiesImpl());
        workerFactory.start();
    }

    @PreDestroy
    public void shutdownWorkerFactory() {
        workerFactory.shutdown();
    }
}
