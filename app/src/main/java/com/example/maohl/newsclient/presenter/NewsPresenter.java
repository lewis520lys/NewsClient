package com.example.maohl.newsclient.presenter;

import com.example.maohl.newsclient.bean.LastNews;
import com.example.maohl.newsclient.contract.NewsContract;
import com.example.maohl.newsclient.interfac.CallBackLastNews;
import com.example.maohl.newsclient.interfac.OnRequsetNetLisnter;
import com.example.maohl.newsclient.model.NewsModel;

import java.util.List;

/**
 * Created by maohl on 2017/10/31.
 */

public class NewsPresenter implements NewsContract.Presenter {
    private final NewsContract.View view;
    private final NewsContract.Model model;

    public NewsPresenter(NewsContract.View view){
        this.view=view;
        model=new NewsModel();
    }
    @Override
    public void getBeforeNews(String data) {
        view.showDialog();
       model.getBeforeNews(new CallBackLastNews() {
           @Override
           public void result(List<LastNews.StoriesBean> storiesBeans) {
               view.refreshRecyView(storiesBeans);
           }
       }, data, new OnRequsetNetLisnter() {
           @Override
           public void requsetSucess() {
              view.hideDialog();
           }

           @Override
           public void requsetError() {
               view.hideDialog();
           }
       });
    }

    @Override
    public void getLastNews() {
        view.showDialog();
     model.getLastNews(new CallBackLastNews() {
         @Override
         public void result(List<LastNews.StoriesBean> storiesBeans) {
             view.refreshRecyView(storiesBeans);
         }
     }, new OnRequsetNetLisnter() {
         @Override
         public void requsetSucess() {
             view.hideDialog();
         }

         @Override
         public void requsetError() {
             view.hideDialog();
         }
     });
    }
}
