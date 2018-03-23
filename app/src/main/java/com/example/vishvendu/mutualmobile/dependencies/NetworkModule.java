package com.example.vishvendu.mutualmobile.dependencies;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.vishvendu.mutualmobile.application.Constant.BASE_URL;


/**
 * Created by vishvendu on 19/3/18.
 */

@Module
public class NetworkModule {

    public String mBaseURL;

    public NetworkModule(String mBaseURL) {
        this.mBaseURL = mBaseURL;
    }




    // this will provide GsonConverterFactory dependency
    @Provides
    @Singleton
    public GsonConverterFactory gsonConverterFactory(){
        return GsonConverterFactory.create();
    }


    @Provides
    @Singleton
    public RxJava2CallAdapterFactory provideRxJava2CallAdapterFactory(){

        return RxJava2CallAdapterFactory.create();
    }


    // this will provide retrofit dependency

    @Provides
    @Singleton
    public Retrofit retrofit(
                             GsonConverterFactory gsonConverterFactory,
                             RxJava2CallAdapterFactory rxJava2CallAdapterFactory
                             ){
        return new Retrofit.Builder()

                .baseUrl(BASE_URL)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .build();
    }







}
