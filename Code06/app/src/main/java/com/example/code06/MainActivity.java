package com.example.code06;

import android.annotation.SuppressLint;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String[] titles = null;
    private String[] authors = null;
    private List<News> newsList = new ArrayList<>();

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        NewsAdapter newsAdapter = new NewsAdapter(MainActivity.this,
                R.layout.list_item, newsList);
        ListView lvNewsList = findViewById(R.id.lv_news_list);
        lvNewsList.setAdapter(newsAdapter);
    }

    private void initData() {
        int length;
        titles = getResources().getStringArray(R.array.titles);
        authors = getResources().getStringArray(R.array.authors);
        TypedArray images = getResources().obtainTypedArray(R.array.images);
        if (titles.length > authors.length) {
            length = authors.length;
        } else {
            length = titles.length;
        }
        for (int i = 0; i < length; i++) {
            News news = new News();
            news.setTitle(titles[i]);
            news.setAuthor(authors[i]);
            news.setImageId(images.getResourceId(i, 0));
            newsList.add(news);
        }
    }
}