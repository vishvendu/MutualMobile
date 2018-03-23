package com.example.vishvendu.mutualmobile.dependencies;

import com.example.vishvendu.mutualmobile.Presenter.MainActivityPresenter;
import com.example.vishvendu.mutualmobile.Service.ArticleService;
import com.example.vishvendu.mutualmobile.ui.MainActivity;

import dagger.Component;

/**
 * Created by Vishvendu on 18-03-2018.
 */
@CustomScope
@Component(modules = ApiModule.class, dependencies = NetworkComponent.class)
public interface ArticleAPIComponent {

    void inject(MainActivity mainActivity);

    void injectPresenter(MainActivityPresenter mainActivity);

   // ArticleService getArticleService();
}
