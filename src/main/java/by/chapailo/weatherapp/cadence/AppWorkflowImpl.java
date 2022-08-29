package by.chapailo.weatherapp.cadence;

import com.uber.cadence.workflow.Workflow;

public class AppWorkflowImpl implements AppWorkflow {
    public static final String TASK_LIST = "WeatherActivity";
    private final WeatherAppActivities activity = Workflow.newActivityStub(WeatherAppActivities.class);
    @Override
    public void start(String city) {
        activity.storeWeatherData(activity.getWeather(city));
    }
}
