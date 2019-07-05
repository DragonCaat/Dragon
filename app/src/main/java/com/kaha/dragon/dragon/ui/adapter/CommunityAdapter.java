package com.kaha.dragon.dragon.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kaha.dragon.R;
import com.kaha.dragon.dragon.base.AppConst;
import com.kaha.dragon.dragon.entity.Community;
import com.kaha.dragon.dragon.ui.activity.CommunityDetailActivity;
import com.kaha.dragon.dragon.ui.activity.ShowUserActivity;
import com.kaha.dragon.dragon.widget.RoundImageView;
import com.kaha.dragon.dragon.widget.ninelayout.NineGridTestLayout;
import com.kaha.dragon.dragon.widget.ninelayout.OnItemPictureClickListener;
import com.kaha.dragon.framework.ui.adapter.BaseRecyclerViewHolder;
import com.kaha.dragon.framework.ui.adapter.OnConvertViewClickListener;
import com.kaha.dragon.framework.utils.glide.GlideUtils;

import java.util.List;

import butterknife.BindView;

/**
 * 微信仿朋友圈的适配器
 *
 * @author Darcy
 * @Date 2019/1/5
 * @package com.kaha.dragon.dragon.ui.adapter
 * @Desciption
 */
public class CommunityAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    //图片点击监听回调
    private OnItemPictureClickListener listener;
    Context context;
    List<Community> datas;

    public CommunityAdapter(Context context, List<Community> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return datas.size() + 1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 0) {
            View view = LayoutInflater.from(context).inflate(R.layout.layout_mine_head_item, viewGroup, false);
            return new CommunityHeadHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.layout_community_item, viewGroup, false);
            CommunityHolder holder = new CommunityHolder(view);
            OnConvertViewClickListener listener = new OnConvertViewClickListener(view, view.getId()) {
                @Override
                public void onClickCallBack(View clickView, int... positionIds) {
                    int position = positionIds[0];
                    Community community = datas.get(position);
                    Intent intent = new Intent(context, CommunityDetailActivity.class);
                    intent.putExtra(AppConst.KEY_2, community);
                    context.startActivity(intent);
                }
            };
            holder.llRootCommunity.setOnClickListener(listener);
            return holder;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof CommunityHolder) {
            final Community data = datas.get(position - 1);
            ((CommunityHolder) holder).getItemView().setTag(((CommunityHolder) holder).getItemView().getId(), position);
            ((CommunityHolder) holder).tvDes.setText(data.getDes());
            ((CommunityHolder) holder).tvNick.setText(data.getNick());
            ((CommunityHolder) holder).roundImageHead.setImageResource(data.getHead());
            ((CommunityHolder) holder).nineGridTestLayout.setUrlList(data.getImageList());
            ((CommunityHolder) holder).nineGridTestLayout.setListener(listener);
            ((CommunityHolder) holder).roundImageHead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ShowUserActivity.class);
                    intent.putExtra(AppConst.KEY_1, data);
                    context.startActivity(intent);
                }
            });
        }
        if (holder instanceof CommunityHeadHolder) {
            GlideUtils.show(context, R.mipmap.girl8, ((CommunityHeadHolder) holder).ivHeadImage);
        }
    }

    class CommunityHeadHolder extends BaseRecyclerViewHolder {

        @BindView(R.id.imageView)
        ImageView ivHeadImage;

        public CommunityHeadHolder(View itemView) {
            super(itemView);
        }
    }

    class CommunityHolder extends BaseRecyclerViewHolder {

        @BindView(R.id.ll_root_community)
        LinearLayout llRootCommunity;
        @BindView(R.id.roundHead)
        RoundImageView roundImageHead;
        @BindView(R.id.tv_nick)
        TextView tvNick;
        @BindView(R.id.tv_des)
        TextView tvDes;
        @BindView(R.id.nine_images)
        NineGridTestLayout nineGridTestLayout;

        public CommunityHolder(View itemView) {
            super(itemView);
        }
    }

    /**
     * 设置图片回调
     *
     * @param listener 图片点击回调
     * @return void
     * @date 2019-01-07
     */
    public void setListener(OnItemPictureClickListener listener) {
        this.listener = listener;
    }
}