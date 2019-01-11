package com.kaha.dragon.dragon.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
import com.kaha.dragon.framework.ui.adapter.BaseRecyclerAdapter;
import com.kaha.dragon.framework.ui.adapter.BaseRecyclerViewHolder;
import com.kaha.dragon.framework.ui.adapter.OnConvertViewClickListener;

import java.util.List;

import butterknife.BindView;

/**
 * 社区的适配器
 *
 * @author Darcy
 * @Date 2019/1/5
 * @package com.kaha.dragon.dragon.ui.adapter
 * @Desciption
 */
public class CommunityAdapter extends BaseRecyclerAdapter<Community, CommunityAdapter.CommunityHolder> {

    //图片点击监听回调
    private OnItemPictureClickListener listener;

    public CommunityAdapter(Context context, List<Community> datas) {
        super(context, datas);
    }

    @Override
    protected void onBindViewHolder(CommunityHolder holder, final Community data, int position) {
        holder.getItemView().setTag(holder.getItemView().getId(), position);
        holder.tvDes.setText(data.getDes());
        holder.tvNick.setText(data.getNick());
        holder.roundImageHead.setImageResource(data.getHead());
        holder.nineGridTestLayout.setUrlList(data.getImageList());
        holder.nineGridTestLayout.setListener(listener);

        holder.roundImageHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ShowUserActivity.class);
                intent.putExtra(AppConst.KEY_1, data);
                context.startActivity(intent);
            }
        });

    }

    @NonNull
    @Override
    public CommunityHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
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

    static class CommunityHolder extends BaseRecyclerViewHolder {

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
