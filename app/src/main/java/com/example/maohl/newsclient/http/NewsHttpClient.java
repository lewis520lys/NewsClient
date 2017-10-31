package com.example.maohl.newsclient.http;

import com.example.maohl.newsclient.bean.LastNews;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by maohl on 2017/10/31.
 */

public class NewsHttpClient {
    private static final int DEFAULT_TIMEOUT = 5;
    private static NewsHttpClient newsHttpClient;
    private final ZhiHuService zhiHuService;

    private NewsHttpClient(){
        //设置超时时间
        OkHttpClient.Builder httpcientBuilder = new OkHttpClient.Builder();

        Retrofit retrofit = new Retrofit.Builder()
                .client(httpcientBuilder.build())//
                .baseUrl(HttpUrl.BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        zhiHuService = retrofit.create(ZhiHuService.class);
    }
    public static NewsHttpClient getInstance(){
        if (newsHttpClient == null) {
            synchronized (NewsHttpClient.class){
                if (newsHttpClient == null){
                    newsHttpClient = new NewsHttpClient();
                }
            }
        }
        return newsHttpClient;
    }
    public void getLastNews(Subscriber<LastNews> subscriber){
        zhiHuService.getLastNews()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
    public void getBeforeNews(Subscriber<LastNews> subscriber,String data){
        zhiHuService.getBeforeNews(data)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
