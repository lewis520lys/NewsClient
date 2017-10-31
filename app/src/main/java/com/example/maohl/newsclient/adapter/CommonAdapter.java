package com.example.maohl.newsclient.adapter;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/2/21 0021.
 */

public  class CommonAdapter<T> extends RecyclerView.Adapter<CommonAdapter.ViewHolder> {


    private List<T> data;
    private Boolean swipeEnable=false;
    private int layoutRes;

    private OnMenuClick mMenuClick;
    private ConVert convert;

    private OnitemClick mOnitemClick;
    public interface OnitemClick{
        void onitemClick(int position);
    }
    private OnitemLongClick mOnitemLongClick;
    public interface OnitemLongClick{
        void onitemLongClick(int position);
    }
    public interface ConVert<T>{
        void convert(ViewHolder holder, T t, int position);
    }
    public CommonAdapter(List<T> data,@LayoutRes int res,ConVert<T> conVert){
        this.data = data;
        layoutRes=res;
        convert=conVert;
    }




    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(layoutRes,parent,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnitemClick != null) {
                    mOnitemClick.onitemClick(position);
                }
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mOnitemLongClick != null) {
                    mOnitemLongClick.onitemLongClick(position);
                }
                return true;
            }
        });
        if (((int) holder.itemView.getTag())==position) {
            convert.convert(holder,data.get(position),position);
        }

    }

//    public void setItems(List<T> data){
//        this.data = data;
//        this.notifyDataSetChanged();
//    }

    public void addData(List<T> list){
        int curSize = data.size() - 1;
        if (list == null) {
            throw new IllegalArgumentException("列表为空");
        }else {
            data.addAll(list);
            notifyItemInserted(curSize);
        }
    }


    public void setSwipeEnable(boolean enable)
    {
        swipeEnable=enable;
    }
    public void clearData(){
        this.data.clear();
        notifyDataSetChanged();
    }
    public void setmOnitemLongClick(OnitemLongClick onitemLongClick){
        mOnitemLongClick=onitemLongClick;
    }
    public void setonItemClick(OnitemClick onitemClick){
        mOnitemClick=onitemClick;
    }

    public void addMenuClickListener(OnMenuClick onMenuClick){
        mMenuClick=onMenuClick;
    }

    public interface OnMenuClick{
        void onMenuClick(int index, int p);
    }
    @Override
    public int getItemCount() {
        return data == null ? 0:data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
      public void setText(int rId, CharSequence text){
            ((TextView) itemView.findViewById(rId)).setText( text);
        }

        public View getView(int rId)
        {
            return itemView.findViewById(rId);
        }
        public void setGone(int id)
        {
            itemView.findViewById(id).setVisibility(View.GONE);
        }
        public void setSee(int id)
        {
            itemView.findViewById(id).setVisibility(View.VISIBLE);
        }

        public ViewHolder(final View itemView) {
            super(itemView);
            }

        }
    }

