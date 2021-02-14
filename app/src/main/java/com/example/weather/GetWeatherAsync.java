package com.example.weather;

import android.os.Build;

import androidx.annotation.RequiresApi;

public class GetWeatherAsync implements Runnable{
    private final MainActivity mainActivity;
    private String city = "";

    public GetWeatherAsync(MainActivity mainActivity, String city) {
        this.mainActivity = mainActivity;
        this.city = city;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void run() {
        WeatherDataLoader loader = new WeatherDataLoader();
        WeatherConditions conditions = loader.getWeatherAndPostResults(city);
    }
}
