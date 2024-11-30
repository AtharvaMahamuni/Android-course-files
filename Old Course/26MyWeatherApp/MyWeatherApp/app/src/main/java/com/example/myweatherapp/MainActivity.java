package com.example.myweatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText city;
    TextView result;

    //https://api.openweathermap.org/data/2.5/weather?q=London,uk&appid=6e193e8f6fa6b43bb24557a4514d20c7
    String baseURL = "https://api.openweathermap.org/data/2.5/weather?q=";
    String API = "&appid=6e193e8f6fa6b43bb24557a4514d20c7";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        city = findViewById(R.id.getCity);
        result = findViewById(R.id.result);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myURL = baseURL + city.getText().toString() + API;
                Log.i("URL", "URL: "+myURL);
                getWeather(myURL);
            }
        });

    }

    static public void getWeather(String url){

    }
}
