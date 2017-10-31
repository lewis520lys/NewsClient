package com.example.maohl.newsclient;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.maohl.newsclient.adapter.CommonAdapter;
import com.example.maohl.newsclient.bean.LastNews;
import com.example.maohl.newsclient.contract.NewsContract;
import com.example.maohl.newsclient.presenter.NewsPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements NewsContract.View {

    private RecyclerView recyView;
    private NewsPresenter newsPresenter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyView.setLayoutManager(layoutManager);
        newsPresenter=new NewsPresenter(this);
        newsPresenter.getLastNews();
    }

    private void initView() {
        recyView = (RecyclerView) findViewById(R.id.recyView);
        progressDialog = new ProgressDialog(this);
    }

    @Override
    public void showDialog() {
        progressDialog.show();
    }

    @Override
    public void hideDialog() {
        progressDialog.cancel();
    }

    @Override
    public void refreshRecyView(List<LastNews.StoriesBean> storiesBeans) {
       recyView.setAdapter(new CommonAdapter(storiesBeans, R.layout.ietm, new CommonAdapter.ConVert<LastNews.StoriesBean>() {
           @Override
           public void convert(CommonAdapter.ViewHolder holder, LastNews.StoriesBean o, int position) {
               ImageView head = (ImageView) holder.getView(R.id.image);
               Glide.with(MainActivity.this).load(o.getImages().get(0)).into(head);
               holder.setText(R.id.title,o.getTitle());
           }
       }));
    }

}
