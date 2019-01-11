package com.kaha.dragon.framework.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * RecyclerView的base的holder.配合ButterKnife框架使用
 *
 * @author Darcy
 * @Date 2019/1/5
 * @package com.kaha.dragon.framework.ui.adapter
 * @Desciption
 */

public class BaseRecyclerViewHolder extends RecyclerView.ViewHolder {

    protected View itemView;

    public BaseRecyclerViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;

        ButterKnife.bind(this, itemView);
    }

    public View getItemView() {
        return itemView;
    }
}
