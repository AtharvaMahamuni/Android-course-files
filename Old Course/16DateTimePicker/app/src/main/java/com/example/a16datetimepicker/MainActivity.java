package com.example.a16datetimepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

   // TimePicker timePicker;

    DatePicker datePicker;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

 //       timePicker = findViewById(R.id.timePicker);
        datePicker = findViewById(R.id.datePicker);
        textView = findViewById(R.id.textView);

        Calendar calendar = Calendar.getInstance();
        datePicker.init(calendar.get(calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(calendar.DAY_OF_MONTH),
                new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        textView.setText("You Selected: "+dayOfMonth+"-"+(monthOfYear+1)+"-"+year);
                    }
                }
        );





//        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
//            @Override
//            public void onTimeChanged(TimePicker view, int hour, int minute) {
//                textView.setText("Hour: "+hour+" Minute: "+minute);
//            }
//        });
    }
}
