package com.example.a04gradleproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

import static com.example.a04gradleproject.R.drawable.ic_cloud_done_black_24dp;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToast(View view){
        switch(view.getId()){
            case R.id.errorBtn:
                Toasty.error(this,"Error", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sucBtn:
                Toasty.success(this,"Success", Toast.LENGTH_SHORT).show();
                break;
            case R.id.infoBtn:
                Toasty.info(this,"Info", Toast.LENGTH_SHORT).show();
                break;
            case R.id.warBtn:
                Toasty.warning(this,"Ooops", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imgBtn:
                Toasty.normal(this,"Project Finish",Toast.LENGTH_SHORT,ContextCompat.getDrawable(this, ic_cloud_done_black_24dp)).show();
        }
    }
}
