package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherApp {
    private static final String API_KEY = "ed6a250ad1e5621312ab5840d26c1b81";
    private static final String API_ENDPOINT = "http://api.openweathermap.org/data/2.5/weather";

    public static String getWeatherInfo(String cityName) throws IOException {
        URL url = new URL(API_ENDPOINT + "?q=" + cityName + "&appid=" + API_KEY);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        BufferedReader responseReader = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));

        StringBuilder result = new StringBuilder();
        String line;
        while ((line = responseReader.readLine()) != null) {
            result.append(line);
        }
        responseReader.close();

        String response = result.toString();

        String weatherDescription = getFieldValue(response, "\"description\":\"");
        double temperatureK = Double.parseDouble(getFieldValue(response, "\"temp\":"));

        double temperatureCelsius = temperatureK - 273.15;
        double temperatureFahrenheit = (temperatureCelsius * 9/5) + 32;

        String weatherInfo = "Today's weather in " + cityName + ": " + weatherDescription + "\n" +
                             "Temperature in Celsius: " + String.format("%.1f", temperatureCelsius) + "\n" +
                             "Temperature in Fahrenheit: " + String.format("%.1f", temperatureFahrenheit);

        connection.disconnect();

        return weatherInfo;
    }

    private static String getFieldValue(String response, String field) {
        int startIndex = response.indexOf(field) + field.length();
        int endIndex = response.indexOf("\"", startIndex);
        String fieldValue = response.substring(startIndex, endIndex);

        fieldValue = fieldValue.replace(",", "");

        return fieldValue;
    }
}
