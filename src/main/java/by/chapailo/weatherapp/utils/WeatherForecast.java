package by.chapailo.weatherapp.utils;

public class WeatherForecast {
    private String city;
    private String weather;
    private float temp;
    private float tempFeelsLike;

    public WeatherForecast(String weather, float temp, float tempFeelsLike) {
        this.weather = weather;
        this.temp = temp;
        this.tempFeelsLike = tempFeelsLike;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getTempFeelsLike() {
        return tempFeelsLike;
    }

    public void setTempFeelsLike(float tempFeelsLike) {
        this.tempFeelsLike = tempFeelsLike;
    }

    @Override
    public String toString() {
        return "WeatherForecast{" +
                "weather='" + weather + '\'' +
                ", temp=" + temp +
                ", temp_feels_like=" + tempFeelsLike +
                '}';
    }
}
