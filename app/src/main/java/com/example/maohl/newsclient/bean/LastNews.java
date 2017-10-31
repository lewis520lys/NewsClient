package com.example.maohl.newsclient.bean;

import java.util.List;

/**
 * Created by maohl on 2017/10/31.
 */

public class LastNews {

    /**
     * date : 20171031
     * stories : [{"images":["https://pic2.zhimg.com/v2-42f05827b902846c3d5b16aec0f5b245.jpg"],"type":0,"id":9654515,"ga_prefix":"103110","title":"说起这种防水又防油的衣服料子，原理并不复杂"},{"images":["https://pic2.zhimg.com/v2-d413a4f4bc5b5ac61df4867c1fbc8d25.jpg"],"type":0,"id":9654463,"ga_prefix":"103109","title":"一玩游戏就停不下来，你也这样对吧？"},{"images":["https://pic3.zhimg.com/v2-2522109a879ee47b2b817a8506daa7b2.jpg"],"type":0,"id":9654378,"ga_prefix":"103108","title":"珍珠、芋圆、奶盖\u2026\u2026庞大的奶茶家族，因它们而精彩"},{"images":["https://pic4.zhimg.com/v2-c96128bc12ba2f55b87f5fb8149f670f.jpg"],"type":0,"id":9654438,"ga_prefix":"103107","title":"一个普通的美国人，每年要交多少税？"},{"images":["https://pic1.zhimg.com/v2-3979593acb5797257e4258c2ab7b4310.jpg"],"type":0,"id":9654592,"ga_prefix":"103107","title":"刚体验了 iPhone X：Home 键是真多余、面容  ID 解锁要花点时间"},{"images":["https://pic3.zhimg.com/v2-e56bc65e3fb13e3160d0f8db87e6c536.jpg"],"type":0,"id":9654387,"ga_prefix":"103107","title":"荷尔蒙、90 后蓝领、危险金矿：为 1000 元高息借款的年轻人"},{"images":["https://pic3.zhimg.com/v2-7ef5e112007cef6489e652a80805d6d6.jpg"],"type":0,"id":9654258,"ga_prefix":"103106","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic2.zhimg.com/v2-1cc1a001baff74cac4d2618e81930f79.jpg","type":0,"id":9654387,"ga_prefix":"103107","title":"荷尔蒙、90 后蓝领、危险金矿：为 1000 元高息借款的年轻人"},{"image":"https://pic4.zhimg.com/v2-30fa660e7be301808a4ac05604386cd7.jpg","type":0,"id":9654592,"ga_prefix":"103107","title":"刚体验了 iPhone X：Home 键是真多余、面容  ID 解锁要花点时间"},{"image":"https://pic2.zhimg.com/v2-ae1841172efc27c4d4234f7d7603af61.jpg","type":0,"id":9654559,"ga_prefix":"103019","title":"天越来越冷了，广东妹子教你如何煲一锅靓汤"},{"image":"https://pic1.zhimg.com/v2-8db9e20b3350c3396947ec0dfba27abc.jpg","type":0,"id":9654536,"ga_prefix":"103017","title":"日本互联网，失去创新和反叛的 20 年"},{"image":"https://pic4.zhimg.com/v2-5da87d885e0773b1c67366ece81a2c8b.jpg","type":0,"id":9654498,"ga_prefix":"103018","title":"一个接一个的梗，这些直播上的弹幕我是快招架不住了\u2026\u2026"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * images : ["https://pic2.zhimg.com/v2-42f05827b902846c3d5b16aec0f5b245.jpg"]
         * type : 0
         * id : 9654515
         * ga_prefix : 103110
         * title : 说起这种防水又防油的衣服料子，原理并不复杂
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * image : https://pic2.zhimg.com/v2-1cc1a001baff74cac4d2618e81930f79.jpg
         * type : 0
         * id : 9654387
         * ga_prefix : 103107
         * title : 荷尔蒙、90 后蓝领、危险金矿：为 1000 元高息借款的年轻人
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
