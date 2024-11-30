package com.example.dualdice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView1;
    private ImageView imageView2;
    private Random dice1Random = new Random();
    private Random dice2Random = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = findViewById(R.id.dice1Image);
        imageView2 = findViewById(R.id.dice2Image);

    }

    public void btnPressed(View view){
        Toast.makeText(this , "Dices Rolled" , Toast.LENGTH_SHORT).show();
        int random1 = dice1Random.nextInt(6)+1;
        int random2 = dice2Random.nextInt(6)+1;

        switch(random1){
            case 1:
                imageView1.setImageResource(R.drawable.dice1);
                break;
            case 2:
                imageView1.setImageResource(R.drawable.dice2);
                break;
            case 3:
                imageView1.setImageResource(R.drawable.dice3);
                break;
            case 4:
                imageView1.setImageResource(R.drawable.dice4);
                break;
            case 5:
                imageView1.setImageResource(R.drawable.dice5);
                break;
            case 6:
                imageView1.setImageResource(R.drawable.dice6);
                break;
            default:
                System.out.println("Something is Wrong");
        }

        switch(random2){
            case 1:
                imageView2.setImageResource(R.drawable.dice1);
                break;
            case 2:
                imageView2.setImageResource(R.drawable.dice2);
                break;
            case 3:
                imageView2.setImageResource(R.drawable.dice3);
                break;
            case 4:
                imageView2.setImageResource(R.drawable.dice4);
                break;
            case 5:
                imageView2.setImageResource(R.drawable.dice5);
                break;
            case 6:
                imageView2.setImageResource(R.drawable.dice6);
                break;
            default:
                System.out.println("Something is Wrong");
        }

    }

}

