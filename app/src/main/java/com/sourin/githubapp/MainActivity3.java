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

public class MainActivity3 extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent intent = getIntent();
        String username = intent.getStringExtra(MainActivity.EXTRA_NAME);

        String url = ("https://api.github.com/users/" + username + "/");

        tv = findViewById(R.id.tv);
        tv.setText("");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        myapitwo api = retrofit.create(myapitwo.class);

        Call<List<modelTwo>> call = api.getmodelTwos();
        call.enqueue(new Callback<List<modelTwo>>() {
            @Override
            public void onResponse(Call<List<modelTwo>> call, Response<List<modelTwo>> response) {
                List<modelTwo> data = response.body();

                for (int i = 0; i<data.size(); i++)
                    tv.append("ID: " + data.get(i).getId()+"\n Name: "+data.get(i).getName()+"\n Full Name: "+data.get(i).getFull_name()+"\n Repository URL: "+data.get(i).getRepos_url()+"\n\n\n");
            }

            @Override
            public void onFailure(Call<List<modelTwo>> call, Throwable t) {

            }
        });

    }


}