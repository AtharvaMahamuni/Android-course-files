package com.example.a13burgerrating;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RatingBar ratingBar;
    TextView textView;


    public void submit(View view){
        float ratingValue = ratingBar.getRating();

        if(ratingValue<2){
            textView.setText("Rating: "+ratingValue+"\nWe will try our best next time");
        }
        else if(ratingValue<=3&&ratingValue>=2){
            textView.setText("Rating: "+ratingValue+"\nWe are trying our best");
        }
        else if(ratingValue>3&&ratingValue<=4){
            textView.setText("Rating: "+ratingValue+"\nThanks!!!We will improve more.");
        }
        else if(ratingValue>4){
                textView.setText("Rating: "+ratingValue+"\nThanks!!!");
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ratingBar = findViewById(R.id.ratingBar);
        textView = findViewById(R.id.textView);



    }
}
