package com.example.maohl.newsclient.interfac;

import com.example.maohl.newsclient.bean.LastNews;

import java.util.List;

/**
 * Created by maohl on 2017/10/31.
 */

public interface CallBackLastNews {
    public void result(List<LastNews.StoriesBean> storiesBeans);
}
