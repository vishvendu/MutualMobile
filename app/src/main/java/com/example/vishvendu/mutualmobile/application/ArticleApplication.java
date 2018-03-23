package com.example.vishvendu.mutualmobile.application;

import android.app.Application;

import com.example.vishvendu.mutualmobile.dependencies.ApiModule;
import com.example.vishvendu.mutualmobile.dependencies.ArticleAPIComponent;
import com.example.vishvendu.mutualmobile.dependencies.ContextModule;
import com.example.vishvendu.mutualmobile.dependencies.DaggerArticleAPIComponent;
import com.example.vishvendu.mutualmobile.dependencies.DaggerNetworkComponent;
import com.example.vishvendu.mutualmobile.dependencies.NetworkComponent;
import com.example.vishvendu.mutualmobile.dependencies.NetworkModule;

/**
 * Created by Vishvendu on 18-03-2018.
 */

public class ArticleApplication extends Application {

   static ArticleAPIComponent mArticleAPIComponent;


    @Override
    public void onCreate() {
        resolveDependency();
        super.onCreate();
    }

    private void resolveDependency() {


        mArticleAPIComponent = DaggerArticleAPIComponent.builder()
                .networkComponent(getNetworkComponent())
                .build();

    }


    public NetworkComponent getNetworkComponent() {
        return DaggerNetworkComponent.builder()
                .networkModule(new NetworkModule(Constant.BASE_URL))
                .build();
    }


    public static ArticleAPIComponent getmArticleAPIComponent() {
        return mArticleAPIComponent;
    }
}
