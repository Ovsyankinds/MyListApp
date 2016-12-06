package ru.artzmb.listapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements OnArticleClickListener {

    RecyclerView recyclerViewArticles;

    ArticlesAdapter articlesAdapter;
    DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(R.string.articles_title);

        recyclerViewArticles = (RecyclerView) findViewById(R.id.recyclerViewArticles);
        recyclerViewArticles.setLayoutManager(new LinearLayoutManager(this));

        articlesAdapter = new ArticlesAdapter();
        articlesAdapter.setOnArticleClickListener(this);
        recyclerViewArticles.setAdapter(articlesAdapter);

        dataManager = new DataManager();
    }

    @Override
    protected void onResume() {
        super.onResume();

        articlesAdapter.setArticles(dataManager.getArticles());
        articlesAdapter.notifyDataSetChanged();
    }

    @Override
    public void onArticleClick(Article article) {
        startActivity(ArticleActivity.createStartIntent(this, article));
    }
}
