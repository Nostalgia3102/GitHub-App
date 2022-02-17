package com.sourin.githubapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;


public interface myapi {
   @GET("users")
   Call<List<model>> getmodel();
}
