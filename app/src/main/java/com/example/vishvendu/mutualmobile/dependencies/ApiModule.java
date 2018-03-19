package com.example.vishvendu.mutualmobile.dependencies;

import com.example.vishvendu.mutualmobile.Service.ArticleService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Vishvendu on 18-03-2018.
 */
@Module(includes = OkHttpClientModule.class)
public class ApiModule {


    // this will provide ArticleService Dependency
    @Provides
    ArticleService getArticle(Retrofit retrofit){

        return retrofit.create(ArticleService.class);
    }


    // this will provide retrofit dependency
    @CustomScope
    @Provides
    public Retrofit retrofit(OkHttpClient okHttpClient,
                             GsonConverterFactory gsonConverterFactory,
                             RxJava2CallAdapterFactory rxJava2CallAdapterFactory,
                             Gson gson){
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(" https://api.myjson.com/")
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .build();
    }


    // this will provide GSON dependency
    @Provides
    public Gson gson(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }


    // this will provide GsonConverterFactory dependency
    @Provides
    public GsonConverterFactory gsonConverterFactory(Gson gson){
        return GsonConverterFactory.create(gson);
    }


    @Provides

    public RxJava2CallAdapterFactory provideRxJava2CallAdapterFactory(){

        return RxJava2CallAdapterFactory.create();
    }

}
