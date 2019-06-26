package com.kaha.dragon.dragon.ui.adapter.home;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kaha.dragon.R;
import com.kaha.dragon.dragon.base.AppConst;
import com.kaha.dragon.dragon.entity.Cartoon;
import com.kaha.dragon.dragon.entity.Community;
import com.kaha.dragon.dragon.ui.activity.CartoonDetailActivity;
import com.kaha.dragon.dragon.ui.activity.CommunityDetailActivity;
import com.kaha.dragon.dragon.ui.adapter.CommunityAdapter;
import com.kaha.dragon.framework.ui.adapter.BaseRecyclerAdapter;
import com.kaha.dragon.framework.ui.adapter.BaseRecyclerViewHolder;
import com.kaha.dragon.framework.ui.adapter.OnConvertViewClickListener;
import com.kaha.dragon.framework.utils.glide.GlideUtils;

import java.util.List;

import butterknife.BindView;

/**
 * 卡通的适配器
 *
 * @author Darcy
 * @Date 2019/1/21
 * @package com.kaha.dragon.dragon.ui.adapter.home
 * @Desciption
 */
public class CartoonAdapter extends BaseRecyclerAdapter<Cartoon, CartoonAdapter.CartoonHolder> {

    public CartoonAdapter(Context context, List<Cartoon> datas) {
        super(context, datas);
    }

    @Override
    protected void onBindViewHolder(CartoonHolder holder, Cartoon data, int position) {
        holder.getItemView().setTag(holder.getItemView().getId(), position);

        GlideUtils.show(context,data.getImageId(),holder.ivCartoon,R.mipmap.loading_pic,R.mipmap.loading_pic);

        holder.tvCartoonName.setText(data.getName());
        holder.tvCartoonDes.setText(data.getDes());
    }

    @NonNull
    @Override
    public CartoonHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_cartoon_item, viewGroup, false);
        CartoonHolder holder = new CartoonHolder(view);
        OnConvertViewClickListener listener = new OnConvertViewClickListener(view, view.getId()) {
            @Override
            public void onClickCallBack(View clickView, int... positionIds) {
                int position = positionIds[0];
                Cartoon cartoon = datas.get(position);
                Intent intent = new Intent(context, CartoonDetailActivity.class);
                intent.putExtra(AppConst.KEY_2, cartoon.getName());
                intent.putExtra(AppConst.KEY_1, cartoon.getUrl());
                context.startActivity(intent);
            }
        };
        holder.llCartoonRoot.setOnClickListener(listener);
        return holder;
    }

    static class CartoonHolder extends BaseRecyclerViewHolder {

        @BindView(R.id.cartoon_image)
        ImageView ivCartoon;
        @BindView(R.id.tv_cartoon_name)
        TextView tvCartoonName;
        @BindView(R.id.tv_cartoon_des)
        TextView tvCartoonDes;
        @BindView(R.id.ll_cartoon_root)
        LinearLayout llCartoonRoot;

        public CartoonHolder(View itemView) {
            super(itemView);
        }
    }
}
