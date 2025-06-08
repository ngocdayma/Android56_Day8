package com.example.android56_day8.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.android56_day8.DetailActivity;
import com.example.android56_day8.R;
import com.example.android56_day8.models.Article;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private final Context context;
    private final List<Article> articleList;

    public NewsAdapter(Context context, List<Article> articleList) {
        this.context = context;
        this.articleList = articleList;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_article, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        Article article = articleList.get(position);

        holder.tvTitle.setText(article.getTitle());
        holder.tvAuthor.setText(article.getAuthor() != null ? article.getAuthor() : "Unknown");
        holder.tvDate.setText(article.getPublishedAt());

        Glide.with(context)
                .load(article.getUrlToImage())
                .placeholder(R.drawable.bg_image) // bạn có thể thay thế ảnh mặc định
                .into(holder.imgThumbnail);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("title", article.getTitle());
            intent.putExtra("author", article.getAuthor());
            intent.putExtra("date", article.getPublishedAt());
            intent.putExtra("description", article.getDescription());
            intent.putExtra("imageUrl", article.getUrlToImage());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return articleList != null ? articleList.size() : 0;
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {
        ImageView imgThumbnail;
        TextView tvTitle, tvAuthor, tvDate;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            imgThumbnail = itemView.findViewById(R.id.imgThumbnail);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
            tvDate = itemView.findViewById(R.id.tvDate);
        }
    }
}
