package com.kaha.dragon.dragon.ui.adapter.circle;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kaha.dragon.R;
import com.kaha.dragon.dragon.entity.RecPeople;
import com.kaha.dragon.dragon.widget.RoundImageView;
import com.kaha.dragon.framework.ui.adapter.BaseRecyclerAdapter;
import com.kaha.dragon.framework.ui.adapter.BaseRecyclerViewHolder;
import com.kaha.dragon.framework.utils.glide.GlideUtils;

import java.util.List;

import butterknife.BindView;

/**
 * 圈子，推荐的适配器
 *
 * @author Darcy
 * @Date 2019/4/15
 * @package com.kaha.dragon.dragon.ui.adapter.circle
 * @Desciption
 */
public class RecPeopleAdapter extends BaseRecyclerAdapter<RecPeople, RecPeopleAdapter.RecPeopleHolder> {


    public RecPeopleAdapter(Context context, List<RecPeople> datas) {
        super(context, datas);
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onBindViewHolder(RecPeopleHolder holder, RecPeople data, int position) {

        GlideUtils.show(context, data.getHead(), holder.roundImageView,
                R.mipmap.default_head, R.mipmap.default_head);
        holder.tvTitle.setText("#" + data.getTitle());
        holder.tvContent.setText(data.getContent() + "人·" + data.getContent() + "件作品");
    }

    @NonNull
    @Override
    public RecPeopleHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_rec_people_item, viewGroup, false);
        return new RecPeopleHolder(view);
    }

    static class RecPeopleHolder extends BaseRecyclerViewHolder {

        @BindView(R.id.roundHead)
        RoundImageView roundImageView;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_content)
        TextView tvContent;

        public RecPeopleHolder(View itemView) {
            super(itemView);
        }
    }
}
