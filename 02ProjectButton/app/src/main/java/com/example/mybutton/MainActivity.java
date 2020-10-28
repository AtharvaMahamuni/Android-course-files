package com.example.mybutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;
    Button button1;
    //Button button2;
    //Button newButton;
    //Button italicBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // italicBtn = findViewById(R.id.ClickBtn2);
        button = findViewById(R.id.myBtn);
        button1 = findViewById(R.id.Button1);
      //  button2 = findViewById(R.id.Button2);
       // newButton = findViewById(R.id.NewBtn);

//        italicBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("TestItalic","Italic Button is clicked");
//            }
//        });

        //        newButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("TESTnew","NEW is Clicked");
//            }
//        });

//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("TEST2","Clicked Button 2");
//            }
//        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TEST1","Clicked Button 1");
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TEST","Clicked");
            }
        });
    }

    public void newBtn(View view) {
        Log.d("test","new is clicked");
    }

    public void button2(View view) {
        Log.d("test2","Button 2 is Clicked");
    }

    public void iBtn(View view){
        Log.d("testI","Itallic buttton is clicked.");
    }

    public void btn(View view){
        Log.d("btn","Btn is clicked");
    }
}
