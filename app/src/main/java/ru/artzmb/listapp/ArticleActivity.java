package ru.artzmb.listapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ArticleActivity extends AppCompatActivity {

    private static final String EXTRA_TITLE = "ru.artzmb.listapp.extras.EXTRA_TITLE";
    private static final String EXTRA_BODY = "ru.artzmb.listapp.extras.EXTRA_BODY";

    private String title;
    private String body;

    TextView textViewTitle;
    TextView textViewBody;

    public static Intent createStartIntent(Context context, Article article) {
        Intent intent = new Intent(context, ArticleActivity.class);
        intent.putExtra(EXTRA_TITLE, article.getTitle());
        intent.putExtra(EXTRA_BODY, article.getBody());
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        textViewTitle = (TextView) findViewById(R.id.textViewTitle);
        textViewBody = (TextView) findViewById(R.id.textViewBody);

        title = getIntent().getStringExtra(EXTRA_TITLE);
        body = getIntent().getStringExtra(EXTRA_BODY);
        if (title != null) {
            getSupportActionBar().setTitle(title);
            textViewTitle.setText(title);
        }
        if (body != null) {
            textViewBody.setText(body);
        }
    }
}
