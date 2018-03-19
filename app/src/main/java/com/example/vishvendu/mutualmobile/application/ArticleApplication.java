package com.example.vishvendu.mutualmobile.application;

import android.app.Application;

import com.example.vishvendu.mutualmobile.dependencies.ArticleAPIComponent;
import com.example.vishvendu.mutualmobile.dependencies.ContextModule;
import com.example.vishvendu.mutualmobile.dependencies.DaggerArticleAPIComponent;

/**
 * Created by Vishvendu on 18-03-2018.
 */

public class ArticleApplication extends Application {

    ArticleAPIComponent mArticleAPIComponent;

    @Override
    public void onCreate() {
        resolveDependency();
        super.onCreate();
    }

    private void resolveDependency() {

         mArticleAPIComponent = DaggerArticleAPIComponent
                .builder().contextModule(new ContextModule(this)).build();


    }

    public ArticleAPIComponent getmArticleAPIComponent() {
        return mArticleAPIComponent;
    }
}
