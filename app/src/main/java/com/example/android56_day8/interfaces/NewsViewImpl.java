package com.example.android56_day8.interfaces;

import com.example.android56_day8.models.Article;

import java.util.List;

public interface NewsViewImpl {
    void showLoading();

    void hideLoading();

    void showArticles(List<Article> articles);

    void showError(String message);
}
