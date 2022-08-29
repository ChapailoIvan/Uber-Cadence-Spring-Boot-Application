package by.chapailo.weatherapp.utils;

import java.sql.*;
import java.util.Date;

public class WeatherDBHelper {
    private static final String CON_STR = "jdbc:sqlite:WEATHER.db";
    private static final String TABLE_NAME = "FORECAST";
    private static final String _ID = "ID";
    private static final String CITY = "CITY";
    private static final String TIME = "TIME";
    private static final String TEMP = "TEMP";
    private static final String FEELS_LIKE = "FEELS_LIKE";
    private static final String DESCRIPTION = "DESCRIPTION";
    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
            _ID + " INTEGER primary key autoincrement, " + CITY + " TEXT, " + TIME +
            " TEXT, " + TEMP + " INTEGER, " + FEELS_LIKE + " INTEGER, " + DESCRIPTION + " TEXT);";

    private Connection connection;

    public WeatherDBHelper() {
        try {
            connection = DriverManager.getConnection(CON_STR);
            Statement statement = connection.createStatement();
            statement.execute(CREATE_TABLE);
        } catch (SQLException e) {
            System.out.println("Error in creating " + WeatherDBHelper.class.toString()
                    + ". Exception: " + e.getMessage());
        }
    }

    public void addWeatherForecast(WeatherForecast weatherForecast) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO " + TABLE_NAME + "(`TIME`, `CITY`, `TEMP`, `FEELS_LIKE`, `DESCRIPTION`)" +
                            "VALUES(?, ?, ?, ?, ?)");
            preparedStatement.setObject(1, String.format("%tT", new Date()));
            preparedStatement.setObject(2, weatherForecast.getCity());
            preparedStatement.setObject(3, weatherForecast.getTemp());
            preparedStatement.setObject(4, weatherForecast.getTempFeelsLike());
            preparedStatement.setObject(5, weatherForecast.getWeather());
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Error in adding weather forecast to database. Exception: " + e.getMessage());
        }
    }


}
