package com.example.vishvendu.mutualmobile.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.vishvendu.mutualmobile.R;
import com.example.vishvendu.mutualmobile.Service.ArticleService;
import com.example.vishvendu.mutualmobile.application.ArticleApplication;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {


    @Inject
    ArticleService articleService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((ArticleApplication)getApplication()).getmArticleAPIComponent().inject(this);
    }
}
