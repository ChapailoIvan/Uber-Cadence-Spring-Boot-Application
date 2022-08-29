package by.chapailo.weatherapp.cadence;

import by.chapailo.weatherapp.utils.JSONWeatherParser;
import by.chapailo.weatherapp.utils.WeatherDBHelper;
import by.chapailo.weatherapp.utils.WeatherForecast;
import org.springframework.web.client.RestTemplate;

public class WeatherAppActivitiesImpl implements WeatherAppActivities {
    private String API_KEY = "YOUR_OPENWEATHER_API_KEY";

    @Override
    public WeatherForecast getWeather(String city) {
        WeatherForecast weatherForecast =  JSONWeatherParser.parse(new RestTemplate().getForObject("https://api.openweathermap.org/data/2.5/weather?q=" +
                city + "&appid=" + API_KEY + "&units=metric", String.class));
        weatherForecast.setCity(city);
        return weatherForecast;
    }

    @Override
    public void storeWeatherData(WeatherForecast weatherForecast) {
        WeatherDBHelper weatherDBHelper = new WeatherDBHelper();
        weatherDBHelper.addWeatherForecast(weatherForecast);
    }
}
