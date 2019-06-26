package com.kaha.dragon.dragon.ui.adapter.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kaha.dragon.R;
import com.kaha.dragon.dragon.entity.Community;
import com.kaha.dragon.dragon.entity.HotPic;
import com.kaha.dragon.dragon.ui.activity.HotPicDetailActivity;
import com.kaha.dragon.dragon.widget.RoundImageView;
import com.kaha.dragon.framework.ui.adapter.BaseRecyclerAdapter;
import com.kaha.dragon.framework.ui.adapter.BaseRecyclerViewHolder;
import com.kaha.dragon.framework.utils.glide.GlideUtils;

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

    public static final String HOT_PIC = "hot_pic";

    public HotPicAdapter(Context context, List<HotPic> datas) {
        super(context, datas);
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onBindViewHolder(HotPicHolder holder, final HotPic data, int position) {
        holder.textView.setText(data.getNick());
        GlideUtils.show(context, data.getHead(), holder.circleImageView, R.mipmap.default_head, R.mipmap.default_head);
        GlideUtils.show(context, data.getImage(), holder.imageView, R.mipmap.loading_pic, R.mipmap.loading_pic);
        holder.tvLikeNumber.setText("" + data.getLikeCount());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, HotPicDetailActivity.class);
                intent.putExtra(HOT_PIC, data);
                context.startActivity(intent);
            }
        });

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
