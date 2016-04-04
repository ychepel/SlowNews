package com.univer.slownews.service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.regex.Pattern;

public class WeatherProvider {

    public String getWeather() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("https://api.forecast.io").path("forecast/ccc9e70f9fbe7b36c2ceea0201205811/50.450100,30.523400");

        String jsonAnswer = target.request(MediaType.APPLICATION_JSON_TYPE).get(String.class);

        return jsonAnswer;
    }

    public static void main(String[] args) {
        WeatherProvider provider = new WeatherProvider();
        System.out.println(provider.getWeather());
    }

}
