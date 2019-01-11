package com.kaha.dragon.framework.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


/**
 * recycleView 的base 适配器
 *
 * @author Darcy
 * @Date 2019/1/5
 * @package com.kaha.dragon.framework.ui.adapter
 * @Desciption
 */
public abstract class BaseRecyclerAdapter<T,V extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<V> {

    protected Context context;
    protected List<T> datas;

    public BaseRecyclerAdapter(Context context, List<T> datas) {
        this.context = context;
        if (null==datas|| datas.size()==0){
            this.datas = new ArrayList<>();
        }else {
            this.datas = new ArrayList<>(datas.size());
        }

    }

    public void updateData( List<T> list){
        this.datas.clear();
        if (list!=null&&list.size()>0){
            this.datas.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(V holder, int position) {
        T data=datas.get(position);
        onBindViewHolder(holder,data,position);
    }

    protected abstract void onBindViewHolder(V holder,T data,int position);

    @Override
    public int getItemCount() {
        return this.datas.size();
    }
}
