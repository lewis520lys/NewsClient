package com.example.maohl.newsclient.contract;

import com.example.maohl.newsclient.bean.LastNews;
import com.example.maohl.newsclient.interfac.CallBackLastNews;
import com.example.maohl.newsclient.interfac.OnRequsetNetLisnter;

import java.util.List;

/**
 * Created by maohl on 2017/10/31.
 */

public interface NewsContract {
    interface View{
        void showDialog();
        void hideDialog();
        void refreshRecyView(List<LastNews.StoriesBean> storiesBeans);
    }
    interface Model{
        void getBeforeNews(CallBackLastNews callBack, String data,OnRequsetNetLisnter lisnter);
        void getLastNews(CallBackLastNews callBack,OnRequsetNetLisnter lisnter);
    }
    interface Presenter{
        void getBeforeNews(String data);
        void getLastNews();
    }
}
