package com.example.android56_day8.presenters;

import android.util.Log;

import com.example.android56_day8.api.NewsApi;
import com.example.android56_day8.constants.ConstantApi;
import com.example.android56_day8.interfaces.NewsPresenterImpl;
import com.example.android56_day8.interfaces.NewsViewImpl;
import com.example.android56_day8.models.NewsResponse;
import com.example.android56_day8.retrofit.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NewsPresenter implements NewsPresenterImpl {
    private NewsViewImpl mNewsView;
    private NewsApi mNewsApi;

    public NewsPresenter(NewsViewImpl newsView) {
        this.mNewsView = newsView;
        this.mNewsApi = RetrofitClient.getNewsApi();
    }

    @Override
    public void getNews() {
        mNewsView.showLoading();
        mNewsApi.getTopHeadlines("us", 10, ConstantApi.API_KEY).enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                mNewsView.hideLoading();
                if (response.isSuccessful() && response.body() != null) {
                    mNewsView.showArticles(response.body().getArticles());
                    Log.d("NEWS_COUNT", "Số bài nhận được : " + response.body().getArticles().size());

                } else {
                    mNewsView.showError("Không có bài viết.");
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                mNewsView.hideLoading();
                mNewsView.showError("Lỗi: " + t.getMessage());
            }
        });
    }
}
