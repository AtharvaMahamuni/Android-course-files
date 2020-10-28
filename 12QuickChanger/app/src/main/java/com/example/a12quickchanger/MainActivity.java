package com.example.a12quickchanger;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RelativeLayout layout;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.layout);
        radioGroup = findViewById(R.id.rgroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId){
                    case R.id.rbtnBlue:
                        layout.setBackgroundColor(Color.parseColor("#4834DF"));
                        break;
                    case R.id.rbtnRed:
                        layout.setBackgroundColor(Color.parseColor("#FF3031"));
                        break;
                    case R.id.rbtnGreen:
                        layout.setBackgroundColor(Color.parseColor("#45CE30"));
                        break;

                }
            }
        });
    }
}
