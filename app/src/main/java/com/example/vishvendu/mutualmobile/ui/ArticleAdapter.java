package com.example.vishvendu.mutualmobile.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vishvendu.mutualmobile.R;
import com.example.vishvendu.mutualmobile.model.ArticleResponse;

import java.util.List;

/**
 * Created by vishvendu on 19/3/18.
 */

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.Holder> {

    List<ArticleResponse> articleList;
    Context context;

    public ArticleAdapter(List<ArticleResponse> articleList, Context context) {
        this.articleList = articleList;
        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.article_items,parent,false);
        Holder holder = new Holder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {


        holder.Title.setText(articleList.get(position).getTITLE());
        holder.Publisher.setText(articleList.get(position).getPUBLISHER());


    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        TextView Title,Publisher;


        public Holder(View itemView) {
            super(itemView);
            Title = (TextView) itemView.findViewById(R.id.Title);
            Publisher = (TextView) itemView.findViewById(R.id.Publisher);
        }
    }
}
