package com.example.vishvendu.mutualmobile.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.vishvendu.mutualmobile.Presenter.MainActivityPresenter;
import com.example.vishvendu.mutualmobile.R;
import com.example.vishvendu.mutualmobile.Service.ArticleService;
import com.example.vishvendu.mutualmobile.application.ArticleApplication;
import com.example.vishvendu.mutualmobile.interfaces.IMainActivityPresenter;
import com.example.vishvendu.mutualmobile.interfaces.IMainActivityView;
import com.example.vishvendu.mutualmobile.model.ArticleResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements IMainActivityView{


    @Inject
    ArticleService articleService;

    @Inject
    MainActivityPresenter mainActivityPresenter;

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;

    private String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArticleApplication.getmArticleAPIComponent().inject(this);
        ArticleApplication.getmArticleAPIComponent().injectPresenter(mainActivityPresenter);

        setupMVP();
        setUpViews();
        getArticleList();

    }

    private void getArticleList() {

        mainActivityPresenter.getArticles();
    }


    private void setupMVP() {

        mainActivityPresenter = new MainActivityPresenter(this,(ArticleApplication) getApplication()) ;
    }



    private void setUpViews() {

        recyclerView = findViewById(R.id.RVarticles);
        recyclerView .setLayoutManager(new LinearLayoutManager(this));

    }



    @Override
    public void showDialog() {

    }

    @Override
    public void hideDailog() {

    }



    @Override
    public void displayArticleResponse(List<ArticleResponse>  articleResponse) {


        if(articleResponse!=null) {

            adapter = new ArticleAdapter(articleResponse, MainActivity.this);
            recyclerView.setAdapter(adapter);
        }else{
            Log.d(TAG,"response null");
        }

    }
}
