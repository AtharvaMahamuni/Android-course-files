package com.example.jsonproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gson gson = new Gson();

//        Student student = new Student("Hitesh",5,"me@email.com");
//        String json = gson.toJson(student);

//        String json = "{\n"+"\"course_count\":5,\n"+"\"email\":\"me@email.com\",\n"+"\"name\":\"Hitesh\"\n" +"}";
//        Student student = gson.fromJson(json,Student.class);
//
//        Log.d("TEST",json);
//

        List<Video> videos = new ArrayList<>();
        videos.add(new Video("Intro",4));
        videos.add(new Video("Exercise files",8));
        videos.add(new Video("Installation",12));


        Course course = new Course("java","BootCamp");
        Student student = new Student("hitesh",3,"me@email.com", course, videos);
        String json = gson.toJson(student);

//        String json ="{\"course_count\":3,\"email\":\"me@email.com\",\"course\":{\"description\":\"BootCamp\",\"name\":\"java\"},\"name\":\"hitesh\"}";
//        Student student = gson.fromJson(json, Student.class);
//
//        Log.d("TEST",student.toString());

        Log.d("TEST",json);
    }
}











