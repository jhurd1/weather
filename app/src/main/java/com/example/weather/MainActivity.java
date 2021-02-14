package com.example.weather;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getWeather(View getWeather) {
        EditText txtCity = findViewById(R.id.editCity);
        String city = txtCity.getText().toString();
        Log.i("MainActivity", "Getting weather for city: " + city);
        GetWeatherAsync getWeatherAsync = new GetWeatherAsync(this, city);
        Thread t = new Thread((Runnable) getWeatherAsync);
        t.start();
    }

    void handleWeatherConditionResult(WeatherConditions conditions)
    {
        Log.d("MainActivity", "Weather results returned via API on the UI thread!");
        if(conditions==null)
        {
            Log.d("MainActivity", "API returned null");
            Toast toast;
            Toast.makeText(this, "Error occurred while retrieving weather.",
                    LENGTH_LONG).show();
        } else 
        {
            Log.d("MainActivity", "Conditions: " + conditions.getMeasurements().toString());
            Float temp = (Float) conditions.getMeasurements();
            Toast.makeText(this, "It is currently " + temp + " degrees.",
                    LENGTH_LONG).show();
        }
    }
}