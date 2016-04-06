package com.univer.slownews.service;

import org.json.JSONObject;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class WeatherProvider {

    public String getWeather() {
        String weather;
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("https://api.forecast.io").path("forecast/ccc9e70f9fbe7b36c2ceea0201205811/50.450100,30.523400");
        String jsonAnswer = target.request(MediaType.APPLICATION_JSON_TYPE).get(String.class);
        JSONObject currentWeather = new JSONObject(jsonAnswer).getJSONObject("currently");
        weather = "Weather in Kiev: " + currentWeather.getString("summary") + ", " + currentWeather.getDouble("temperature") + " \u00b0F";
        return weather;
    }
}
