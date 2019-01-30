package com.kaha.dragon.dragon.ui.adapter.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.DragAndDropPermissions;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kaha.dragon.R;
import com.kaha.dragon.dragon.entity.Community;
import com.kaha.dragon.framework.ui.adapter.BaseRecyclerAdapter;
import com.kaha.dragon.framework.ui.adapter.BaseRecyclerViewHolder;

import java.util.List;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 首页推荐的适配器
 *
 * @author Darcy
 * @Date 2019/1/18
 * @package com.kaha.dragon.dragon.ui.adapter
 * @Desciption
 */
public class RecommendAdapter extends BaseRecyclerAdapter<Community, RecommendAdapter.RecommendHolder> {

    public RecommendAdapter(Context context, List<Community> datas) {
        super(context, datas);
    }

    @Override
    protected void onBindViewHolder(RecommendHolder holder, Community data, int position) {
        holder.tvNick.setText(data.getNick());
//        GlideUtils.show(context,data.getHead(),holder.cvHead,
//                R.mipmap.loading_pic,R.mipmap.loading_pic);
        holder.cvHead.setImageResource(data.getHead());
        holder.imageView.setImageResource(data.getImageList().get(0));
    }

    @NonNull
    @Override
    public RecommendHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_recommend_item, viewGroup, false);
        return new RecommendHolder(view);
    }

    static class RecommendHolder extends BaseRecyclerViewHolder {
        @BindView(R.id.cv_head)
        CircleImageView cvHead;
        @BindView(R.id.tv_nickName)
        TextView tvNick;
        @BindView(R.id.image)
        ImageView imageView;
        public RecommendHolder(View itemView) {
            super(itemView);
        }
    }
}
