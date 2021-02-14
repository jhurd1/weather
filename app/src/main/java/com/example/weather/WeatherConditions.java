package com.example.weather;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class WeatherConditions {

    private String id;
    private Float measurement;
    private String name;
    @SerializedName("main")
    private Map<String, Float> measurements;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMeasurements(Map<String, Float> measurements) {
        this.measurements = measurements;
    }

    public String getId()
    {
        return id;
    }

    public Float getMeasurements() {
        return measurement;
    }

    public String getName() {
        return name;
    }
}
