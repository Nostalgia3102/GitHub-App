package com.sourin.githubapp;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class MainActivity2 extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        String username = intent.getStringExtra(MainActivity.EXTRA_NAME);
        String url = "https://api.github.com/";

        textView = findViewById(R.id.textView);
        textView.setText("");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        myapi myapi = retrofit.create(myapi.class);

        Call<List<model>> call = myapi.getmodel();
        call.enqueue(new Callback<List<model>>() {
            @Override
            public void onResponse(Call<List<model>> call, Response<List<model>> response) {
                List<model> data = response.body();
                for (int i = 0; i<data.size(); i++)
                    textView.append("Username: " + data.get(i).getLogin()+"\n ID: "+data.get(i).getId()+"\n Avatar URL: "+data.get(i).getAvatar_url()+"\n\n\n");
            }

            @Override
            public void onFailure(Call<List<model>> call, Throwable t) {

            }
        });
    }
}