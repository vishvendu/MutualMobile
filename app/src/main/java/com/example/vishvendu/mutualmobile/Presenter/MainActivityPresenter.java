package com.example.vishvendu.mutualmobile.Presenter;

import android.util.Log;

import com.example.vishvendu.mutualmobile.Service.ArticleService;
import com.example.vishvendu.mutualmobile.application.ArticleApplication;
import com.example.vishvendu.mutualmobile.dependencies.ApiModule;
import com.example.vishvendu.mutualmobile.dependencies.ArticleAPIComponent;
import com.example.vishvendu.mutualmobile.dependencies.DaggerNetworkComponent;
import com.example.vishvendu.mutualmobile.dependencies.NetworkComponent;
import com.example.vishvendu.mutualmobile.interfaces.IMainActivityPresenter;
import com.example.vishvendu.mutualmobile.interfaces.IMainActivityView;
import com.example.vishvendu.mutualmobile.model.ArticleResponse;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by vishvendu on 19/3/18.
 */

public class MainActivityPresenter implements IMainActivityPresenter{

    IMainActivityView activityView;

    private String TAG = "MainActivityPresenter";


    @Inject
    Retrofit retrofit;






@Inject
    public MainActivityPresenter(IMainActivityView activityView, ArticleApplication articleApplication) {
        this.activityView = activityView;

        retrofit =articleApplication.getNetworkComponent().retrofit();

    }


    @Override
    public void getArticles() {

        getObservable().subscribeWith(getObserver());
    }


    public Observable<List<ArticleResponse>> getObservable(){
        return ApiModule.getArticle(retrofit).getArticle()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


    public DisposableObserver<List<ArticleResponse>> getObserver(){

        return new DisposableObserver<List<ArticleResponse>>(){


            @Override
            public void onNext(List<ArticleResponse> articleResponses) {
                activityView.displayArticleResponse(articleResponses);
            }

            @Override
            public void onError(Throwable e) {

                activityView.hideDailog();

            }

            @Override
            public void onComplete() {

                activityView.hideDailog();
                Log.d(TAG,"Completed");

            }
        };

    }


}
