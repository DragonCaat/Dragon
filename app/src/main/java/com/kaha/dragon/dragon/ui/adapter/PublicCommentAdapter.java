package com.kaha.dragon.dragon.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.kaha.dragon.dragon.entity.Community;
import com.kaha.dragon.framework.ui.adapter.BaseRecyclerAdapter;
import com.kaha.dragon.framework.ui.adapter.BaseRecyclerViewHolder;

import java.util.List;

/**
 * 公共评论的适配器
 *
 * @author Darcy
 * @Date 2019/4/11
 * @package com.kaha.dragon.dragon.ui.adapter
 * @Desciption
 */
public class PublicCommentAdapter extends BaseRecyclerAdapter<Community, PublicCommentAdapter.PublicCommentHolder> {


    public PublicCommentAdapter(Context context, List<Community> datas) {
        super(context, datas);
    }

    @Override
    protected void onBindViewHolder(PublicCommentHolder holder, Community data, int position) {

    }

    @NonNull
    @Override
    public PublicCommentHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    static class PublicCommentHolder extends BaseRecyclerViewHolder {

        public PublicCommentHolder(View itemView) {
            super(itemView);
        }
    }
}
