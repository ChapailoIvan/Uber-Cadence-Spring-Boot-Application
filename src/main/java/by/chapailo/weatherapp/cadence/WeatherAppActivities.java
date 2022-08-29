package by.chapailo.weatherapp.cadence;

import by.chapailo.weatherapp.utils.WeatherForecast;
import com.uber.cadence.activity.ActivityMethod;

public interface WeatherAppActivities {
    @ActivityMethod(scheduleToCloseTimeoutSeconds = 2)
    WeatherForecast getWeather(String city);

    @ActivityMethod(scheduleToCloseTimeoutSeconds = 2)
    void storeWeatherData(WeatherForecast weatherForecast);
}