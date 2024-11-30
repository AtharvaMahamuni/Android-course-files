package com.example.firebaseloginsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    EditText email;
    EditText password;
    Button button;

    private FirebaseAuth mAuth;

    @Override
    protected void onStart() {
        super.onStart();
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        Toast.makeText(this,"Already in",Toast.LENGTH_SHORT).show();
        //updateUI(currentUser);
    }

    //Make sure to check that email and password (email & null)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        mAuth = FirebaseAuth.getInstance();
    }

    public void onRegister(View view){
        final String myEmail = email.getText().toString();
        final String myPass = password.getText().toString();

        mAuth.createUserWithEmailAndPassword(myEmail, myPass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.i("TAG", "createUserWithEmail:success");
                            Toast.makeText(MainActivity.this,"success",Toast.LENGTH_SHORT).show();
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(MainActivity.this, "Failure",Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }

    public void onLogin(View view){
        final String myEmail = email.getText().toString();
        final String myPass = password.getText().toString();

        mAuth.signInWithEmailAndPassword(myEmail, myPass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.i("TAG", "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            String userID = user.getUid().toString();
                            Toast.makeText(MainActivity.this,"Auth success",Toast.LENGTH_SHORT).show();
                            Log.i("USER","USER: "+user.toString());
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.i("TAG", "signInWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this,"Auth failed",Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }

    public void logout(View view){
        FirebaseAuth.getInstance().signOut();
        Toast.makeText(this,"SIGNOUT",Toast.LENGTH_SHORT).show();
    }

}
