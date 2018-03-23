package com.example.vishvendu.mutualmobile.dependencies;

import com.example.vishvendu.mutualmobile.Service.ArticleService;
import com.example.vishvendu.mutualmobile.application.ArticleApplication;
import com.example.vishvendu.mutualmobile.model.ArticleResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Vishvendu on 18-03-2018.
 */
@Module
public class ApiModule {


    // this will provide ArticleService Dependency
    @Provides
    @CustomScope
  public static ArticleService getArticle(Retrofit retrofit) {
        return retrofit.create(ArticleService.class);
    }







}
