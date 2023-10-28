package com.example.client;

import com.example.client.service.WeatherService;
import com.example.client.service.internal.AccuWeatherService;
import com.google.inject.AbstractModule;

public class AppModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(WeatherService.class).to(AccuWeatherService.class);
    }

}
