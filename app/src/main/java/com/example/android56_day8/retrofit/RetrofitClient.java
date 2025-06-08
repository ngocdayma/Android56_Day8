package com.example.android56_day8.retrofit;

import com.example.android56_day8.api.NewsApi;
import com.example.android56_day8.constants.Constant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit;

    private static Retrofit getInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constant.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static NewsApi getNewsApi() {
        return getInstance().create(NewsApi.class);
    }
}
