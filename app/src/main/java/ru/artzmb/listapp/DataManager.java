package ru.artzmb.listapp;

import java.util.ArrayList;
import java.util.List;

public class DataManager {

    public List<Article> getArticles() {

        List<Article> articles = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Article article = new Article();
            article.setTitle("Article #" + String.valueOf(i + 1));
            article.setBody("Article Body #" + String.valueOf(i + 1));
            articles.add(article);
        }

        return articles;
    }
}
