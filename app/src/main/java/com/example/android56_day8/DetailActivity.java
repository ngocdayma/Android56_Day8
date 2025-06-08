package com.example.android56_day8;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView tvTitle = findViewById(R.id.tvTitle);
        TextView tvAuthor = findViewById(R.id.tvAuthor);
        TextView tvDate = findViewById(R.id.tvDate);
        TextView tvDescription = findViewById(R.id.tvDescription);
        ImageView imgThumbnail = findViewById(R.id.imgThumbnail);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String author = intent.getStringExtra("author");
        String date = intent.getStringExtra("date");
        String description = intent.getStringExtra("description");
        String imageUrl = intent.getStringExtra("imageUrl");

        tvTitle.setText(title);
        tvAuthor.setText(author);
        tvDate.setText(date);
        tvDescription.setText(description);

        Glide.with(this).load(imageUrl).into(imgThumbnail);
    }
}
