package com.example.vishvendu.mutualmobile.dependencies;

import com.example.vishvendu.mutualmobile.Service.ArticleService;
import com.example.vishvendu.mutualmobile.ui.MainActivity;

import dagger.Component;

/**
 * Created by Vishvendu on 18-03-2018.
 */
@CustomScope
@Component(modules = ApiModule.class)
public interface ArticleAPIComponent {

    public void inject(MainActivity mainActivity);

    ArticleService getArticleService();
}
