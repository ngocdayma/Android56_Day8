package com.example.android56_day8;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android56_day8.adapters.NewsAdapter;
import com.example.android56_day8.interfaces.NewsViewImpl;
import com.example.android56_day8.models.Article;
import com.example.android56_day8.presenters.NewsPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements NewsViewImpl {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private NewsAdapter newsAdapter;
    private NewsPresenter newsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        newsPresenter = new NewsPresenter(this);
        newsPresenter.getNews();
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showArticles(List<Article> articles) {
        newsAdapter = new NewsAdapter(this, articles);
        recyclerView.setAdapter(newsAdapter);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, "Error: " + message, Toast.LENGTH_SHORT).show();
    }
}
