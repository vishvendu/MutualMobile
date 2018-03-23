package com.example.vishvendu.mutualmobile.interfaces;

import com.example.vishvendu.mutualmobile.model.ArticleResponse;

import java.util.List;

/**
 * Created by vishvendu on 19/3/18.
 */

public interface IMainActivityView {

    void showDialog();

    void hideDailog();

    void displayArticleResponse(List<ArticleResponse> articleResponse);

}
