package by.chapailo.weatherapp.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

public class JSONWeatherParser {
    public static WeatherForecast parse(String JSONFile) {
        WeatherForecast weatherForecast = null;

        try {
            JSONObject obj = (JSONObject) JSONValue.parseWithException(JSONFile);

            JSONArray weather = (JSONArray) obj.get("weather");
            JSONObject main = (JSONObject) obj.get("main");

            weatherForecast = new WeatherForecast(
                    ((JSONObject)weather.get(0)).get("description").toString(),
                    Float.parseFloat(main.get("temp").toString()),
                    Float.parseFloat(main.get("feels_like").toString())
            );
        } catch (ParseException e) {
            System.out.println(e);
        }

        return weatherForecast;
    }
}
