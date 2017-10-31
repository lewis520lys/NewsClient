package com.example.maohl.newsclient.contract;

import com.example.maohl.newsclient.bean.LastNews;
import com.example.maohl.newsclient.interfac.CallBackLastNews;

import java.util.List;

/**
 * Created by maohl on 2017/10/31.
 */

public interface NewsContract {
    interface View{
        void refreshRecyView(List<LastNews.StoriesBean> storiesBeans);
    }
    interface Model{
        void getBeforeNews(CallBackLastNews callBack, String data);
        void getLastNews(CallBackLastNews callBack);
    }
    interface Presenter{
        void getBeforeNews(String data);
        void getLastNews();
    }
}
