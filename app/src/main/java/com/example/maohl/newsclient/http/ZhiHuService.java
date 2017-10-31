package com.example.maohl.newsclient.http;

import com.example.maohl.newsclient.bean.LastNews;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by maohl on 2017/10/31.
 */

public interface ZhiHuService {
    @GET("api/4/news/latest")
    Observable<LastNews> getLastNews();

    @GET("api/4/news/before/{date}")
    Observable<LastNews> getBeforeNews(@Path("date") String dateString);



//    @GET("api/4/news/{id}")
//    Observable<News> getNews(@Path("id") int id);
//
//    @GET("api/4/story/{id}/long-comments")
//    Observable<Comment> getComments(@Path("id") int id);
//
//    @GET("api/4/story-extra/{id}")
//    Observable<StoryExtra> getStroyExtra(@Path("id") int id);
}
