package com.kaha.dragon.dragon.ui.adapter.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kaha.dragon.R;
import com.kaha.dragon.dragon.entity.Community;
import com.kaha.dragon.dragon.entity.HotPic;
import com.kaha.dragon.dragon.widget.RoundImageView;
import com.kaha.dragon.framework.ui.adapter.BaseRecyclerAdapter;
import com.kaha.dragon.framework.ui.adapter.BaseRecyclerViewHolder;

import java.util.List;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author Darcy
 * @Date 2019/4/12
 * @package com.kaha.dragon.dragon.ui.adapter.home
 * @Desciption
 */
public class HotPicAdapter extends BaseRecyclerAdapter<HotPic, HotPicAdapter.HotPicHolder> {

    public HotPicAdapter(Context context, List<HotPic> datas) {
        super(context, datas);
    }

    @Override
    protected void onBindViewHolder(HotPicHolder holder, HotPic data, int position) {
        holder.textView.setText(data.getNick());
        holder.circleImageView.setImageResource(data.getHead());
        holder.imageView.setImageResource(data.getImage());
        holder.tvLikeNumber.setText("" + data.getLikeCount());
    }

    @NonNull
    @Override
    public HotPicHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_hot_pic_item, viewGroup, false);
        return new HotPicHolder(view);
    }

    static class HotPicHolder extends BaseRecyclerViewHolder {

        @BindView(R.id.iv_image)
        RoundImageView imageView;
        @BindView(R.id.iv_head)
        CircleImageView circleImageView;
        @BindView(R.id.tv_nick)
        TextView textView;
        @BindView(R.id.like_number)
        TextView tvLikeNumber;

        public HotPicHolder(View itemView) {
            super(itemView);
        }
    }

}
