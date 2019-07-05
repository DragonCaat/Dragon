package com.kaha.dragon.dragon.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kaha.dragon.R;
import com.kaha.dragon.dragon.entity.KingHero;
import com.kaha.dragon.dragon.widget.RoundImageView;
import com.kaha.dragon.framework.ui.adapter.BaseRecyclerAdapter;
import com.kaha.dragon.framework.ui.adapter.BaseRecyclerViewHolder;
import com.kaha.dragon.framework.utils.glide.GlideUtils;

import java.util.List;

import butterknife.BindView;

/**
 * 王者荣耀适配器
 *
 * @author Darcy
 * @Date 2019/7/4
 * @package com.kaha.dragon.dragon.ui.adapter
 * @Desciption
 */
public class KingHeroAdapter extends BaseRecyclerAdapter<KingHero, KingHeroAdapter.KingHeroHolder> {

    public KingHeroAdapter(Context context, List<KingHero> datas) {
        super(context, datas);
    }

    @Override
    protected void onBindViewHolder(KingHeroHolder holder, KingHero data, int position) {
        GlideUtils.show(context,data.getHeroHead(),holder.ivHeroHead);
        GlideUtils.show(context,data.getHeroBigPic(),holder.ivHeroBigPic);
        holder.tvHeroDes.setText(data.getHeroDes());
        holder.tvHeroName.setText(data.getHeroName());
        holder.tvHeroWord.setText(data.getHeroWord());
    }

    @NonNull
    @Override
    public KingHeroHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //头布局
        View view = LayoutInflater.from(context).inflate(R.layout.layout_king_hero_item, viewGroup, false);
        return new KingHeroHolder(view);
    }

    class KingHeroHolder extends BaseRecyclerViewHolder {

        @BindView(R.id.iv_hero_head)
        ImageView ivHeroHead;
        @BindView(R.id.tv_hero_des)
        TextView tvHeroDes;
        @BindView(R.id.tv_hero_name)
        TextView tvHeroName;
        @BindView(R.id.iv_hero_big_pic)
        RoundImageView ivHeroBigPic;
        @BindView(R.id.tv_hero_word)
        TextView tvHeroWord;
        public KingHeroHolder(View itemView) {
            super(itemView);
        }
    }
}
