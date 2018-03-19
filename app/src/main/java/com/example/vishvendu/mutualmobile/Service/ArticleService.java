package com.example.vishvendu.mutualmobile.Service;

import com.example.vishvendu.mutualmobile.model.ArticleResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Vishvendu on 18-03-2018.
 */

public interface ArticleService {

    @GET("bins/10ijyt")
    Observable<List<ArticleResponse>> getArticle();
}
