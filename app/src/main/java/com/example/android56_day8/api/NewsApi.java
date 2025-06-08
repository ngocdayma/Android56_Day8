package com.example.android56_day8.api;

import com.example.android56_day8.models.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {
    @GET("v2/top-headlines")
    Call<NewsResponse> getTopHeadlines(
            @Query("country") String country,
            @Query("pageSize") int pageSize,
            @Query("apiKey") String apiKey
    );
}
