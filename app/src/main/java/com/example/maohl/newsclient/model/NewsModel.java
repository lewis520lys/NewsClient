package com.example.maohl.newsclient.model;


import android.util.Log;

import com.example.maohl.newsclient.bean.LastNews;
import com.example.maohl.newsclient.http.NewsHttpClient;
import com.example.maohl.newsclient.interfac.CallBackLastNews;


import rx.Subscriber;

import static android.content.ContentValues.TAG;

/**
 * Created by maohl on 2017/10/31.
 */

public class NewsModel implements com.example.maohl.newsclient.contract.NewsContract.Model {
    @Override
    public void getBeforeNews(final CallBackLastNews callBack, String data) {
        Subscriber subscriber=new Subscriber<LastNews>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, e.getMessage());
            }

            @Override
            public void onNext(LastNews lastNews) {
                callBack.result(lastNews.getStories());
            }
        };
        NewsHttpClient.getInstance().getBeforeNews(subscriber,data);

    }

    @Override
    public void getLastNews(final CallBackLastNews callBack) {
        Subscriber subscriber=new Subscriber<LastNews>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, e.getMessage());
            }

            @Override
            public void onNext(LastNews lastNews) {
                callBack.result(lastNews.getStories());
            }
        };
        NewsHttpClient.getInstance().getLastNews(subscriber);
    }
}
