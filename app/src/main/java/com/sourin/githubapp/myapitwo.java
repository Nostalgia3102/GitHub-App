package com.sourin.githubapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface myapitwo {
    @GET("repos")
    Call<List<modelTwo>> getmodelTwos();
}
