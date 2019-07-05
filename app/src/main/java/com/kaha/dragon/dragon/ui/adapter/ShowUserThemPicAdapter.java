package com.kaha.dragon.dragon.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kaha.dragon.R;
import com.kaha.dragon.dragon.base.AppConst;
import com.kaha.dragon.dragon.entity.Community;
import com.kaha.dragon.dragon.ui.activity.PicDetailActivity;
import com.kaha.dragon.dragon.widget.RoundImageView;
import com.kaha.dragon.framework.ui.adapter.BaseRecyclerAdapter;
import com.kaha.dragon.framework.ui.adapter.BaseRecyclerViewHolder;
import com.kaha.dragon.framework.ui.adapter.OnConvertViewClickListener;
import com.kaha.dragon.framework.utils.glide.GlideUtils;

import java.util.List;

import butterknife.BindView;

/**
 * 用户资料显示主题图片的适配器
 *
 * @author Darcy
 * @Date 2019/1/5
 * @package com.kaha.dragon.dragon.ui.adapter
 * @Desciption
 */
public class ShowUserThemPicAdapter extends BaseRecyclerAdapter<Integer, ShowUserThemPicAdapter.PicViewHolder> {

    public ShowUserThemPicAdapter(Context context, List<Integer> imageList) {
        super(context, imageList);
    }

    @Override
    protected void onBindViewHolder(PicViewHolder holder, final Integer data, int position) {
        holder.getItemView().setTag(holder.getItemView().getId(), position);

        GlideUtils.show(context, data, holder.ivBg,
                R.mipmap.loading_pic, R.mipmap.loading_pic);
    }

    @NonNull
    @Override
    public PicViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_user_data_pic_item, viewGroup, false);
        PicViewHolder holder = new PicViewHolder(view);
        OnConvertViewClickListener listener = new OnConvertViewClickListener(view, view.getId()) {
            @Override
            public void onClickCallBack(View clickView, int... positionIds) {
                int position = positionIds[0];
//                Community community = datas.get(position);
//                Intent intent = new Intent(context, PicDetailActivity.class);
//                intent.putExtra(AppConst.KEY_2, community);
//                context.startActivity(intent);
            }
        };
        holder.rlPicRoot.setOnClickListener(listener);
        return holder;
    }

    static class PicViewHolder extends BaseRecyclerViewHolder {

        @BindView(R.id.rl_pic_root)
        RelativeLayout rlPicRoot;
        @BindView(R.id.iv_bg)
        ImageView ivBg;

        public PicViewHolder(View itemView) {
            super(itemView);
        }
    }

}
