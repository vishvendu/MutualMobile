package com.example.vishvendu.mutualmobile.dependencies;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Vishvendu on 18-03-2018.
 */
@Module
public class ContextModule {


    Context context;

    public ContextModule(Context context){
        this.context = context;
    }


    @ApplicationContex
    @CustomScope
    @Provides
    public Context context(){ return context.getApplicationContext(); }
}
