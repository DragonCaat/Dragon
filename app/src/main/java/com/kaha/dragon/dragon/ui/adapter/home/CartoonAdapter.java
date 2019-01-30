package com.kaha.dragon.dragon.ui.adapter.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kaha.dragon.R;
import com.kaha.dragon.dragon.entity.Cartoon;
import com.kaha.dragon.framework.ui.adapter.BaseRecyclerAdapter;
import com.kaha.dragon.framework.ui.adapter.BaseRecyclerViewHolder;

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
        holder.ivCartoon.setImageResource(data.getImageId());
        holder.tvCartoonName.setText(data.getName());
    }

    @NonNull
    @Override
    public CartoonHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_cartoon_item, viewGroup, false);
        return new CartoonHolder(view);
    }

    static class CartoonHolder extends BaseRecyclerViewHolder {

        @BindView(R.id.cartoon_image)
        ImageView ivCartoon;
        @BindView(R.id.tv_cartoon_name)
        TextView tvCartoonName;
        @BindView(R.id.tv_cartoon_des)
        TextView tvCartoonDes;

        public CartoonHolder(View itemView) {
            super(itemView);
        }
    }
}
