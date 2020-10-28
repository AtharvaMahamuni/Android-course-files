package com.example.javamailapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    public EditText editTextEmail;
    public EditText editTextSubject;
    public EditText editTextMessage;
    
    public Button reachOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar toolbar = findViewById(R.id.toolbar);

        editTextEmail = findViewById(R.id.mailID);
        editTextSubject = findViewById(R.id.subjectID);
        editTextMessage = findViewById(R.id.messageID);

        reachOut = findViewById(R.id.reachOut);
        reachOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }

            private void sendMail() {
                String mail = editTextEmail.getText().toString().trim();
                String message = editTextMessage.getText().toString();
                String subject = editTextSubject.getText().toString().trim();

                //Send Mail
                JavaMailAPI javaMailAPI = new JavaMailAPI(MainActivity.this,mail,subject,message);

                javaMailAPI.execute();

            }
        });


    }
}