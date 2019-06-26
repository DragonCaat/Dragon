package com.kaha.dragon.dragon.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kaha.dragon.R;
import com.kaha.dragon.dragon.entity.Mine;
import com.kaha.dragon.dragon.ui.activity.ShowUserActivity;
import com.kaha.dragon.framework.ui.adapter.BaseRecyclerAdapter;
import com.kaha.dragon.framework.ui.adapter.BaseRecyclerViewHolder;
import com.kaha.dragon.framework.ui.adapter.OnConvertViewClickListener;
import com.kaha.dragon.framework.utils.glide.GlideUtils;

import java.util.List;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 我的适配器
 *
 * @author Darcy
 * @Date 2019/1/8
 * @package com.kaha.dragon.dragon.ui.adapter
 * @Desciption
 */
public class MineAdapter extends BaseRecyclerAdapter<Mine, MineAdapter.MineViewHolder> {


    public MineAdapter(Context context, List<Mine> datas) {
        super(context, datas);
    }

    @Override
    protected void onBindViewHolder(MineViewHolder holder, Mine data, int position) {

        GlideUtils.show(context,R.mipmap.default_head, holder.cvHead,R.mipmap.default_head,R.mipmap.default_head);

        holder.cvHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               context.startActivity(new Intent(context,ShowUserActivity.class));
            }
        });
    }

    @NonNull
    @Override
    public MineViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_mine_item, viewGroup, false);
        MineAdapter.MineViewHolder holder = new MineAdapter.MineViewHolder(view);

        OnConvertViewClickListener clickListener = new OnConvertViewClickListener(view, view.getId()) {
            @Override
            public void onClickCallBack(View clickView, int... positionIds) {

            }
        };
        return holder;
    }

    static class MineViewHolder extends BaseRecyclerViewHolder {

        @BindView(R.id.cv_head)
        CircleImageView cvHead;

        public MineViewHolder(View itemView) {
            super(itemView);
        }
    }
}
