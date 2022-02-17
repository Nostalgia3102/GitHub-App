package com.sourin.githubapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username;
    public static final String EXTRA_NAME = "com.sourin.githubapp.extra.NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openActivity(View view){
        Toast.makeText(this, "Opening All Users Info", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity2.class);
        username = findViewById(R.id.username);
        String usernameText = username.getText().toString();
        intent.putExtra(EXTRA_NAME, usernameText);
        startActivity(intent);
    }

    public void openActivityThree(View v){

        Toast.makeText(this, "Opening Typed User Info", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity3.class);
        username = findViewById(R.id.username);
        String usernameText = username.getText().toString();
        intent.putExtra(EXTRA_NAME, usernameText);
        startActivity(intent);
    }

}