package com.kaha.dragon.dragon.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kaha.dragon.R;
import com.kaha.dragon.dragon.entity.BannerData;
import com.kaha.dragon.dragon.entity.Community;
import com.kaha.dragon.dragon.utils.GlideImageLoader;
import com.kaha.dragon.framework.ui.adapter.BaseRecyclerViewHolder;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.List;

import butterknife.BindView;

/**
 * 首页的适配器
 *
 * @author Darcy
 * @Date 2019/1/11
 * @package com.kaha.dragon.dragon.ui.adapter
 * @Desciption
 */
public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int HEAD = 0;//头布局
    public static final int CONTENT = 1; //内容布局
    private List<Community> list;
    private Context context;
    //banner数据资源
    private BannerData bannerData;


    public HomeAdapter(List<Community> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        //头布局
        View headView = LayoutInflater.from(context).inflate(R.layout.layout_home_head_item, viewGroup, false);
        //内容布局
        View contentView = LayoutInflater.from(context).inflate(R.layout.layout_home_content_item, viewGroup, false);
        if (viewType == HEAD) {
            return new HeadViewHolder(headView);
        } else {
            return new ContentViewHolder(contentView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof ContentViewHolder) {
            ((ContentViewHolder) viewHolder).imageView.setImageResource(list.get(i - 1).getImageList().get(0));
            ((ContentViewHolder) viewHolder).tvTitle.setText(list.get(i - 1).getDes());
            ((ContentViewHolder) viewHolder).tvContent.setText(list.get(i - 1).getLongDes());
        } else if (viewHolder instanceof HeadViewHolder) {
            ((HeadViewHolder) viewHolder).binner.setImages(bannerData.getImageList());
            //设置banner样式
            ((HeadViewHolder) viewHolder).binner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
            ((HeadViewHolder) viewHolder).binner.setBannerTitles(bannerData.getTitleList());
            ((HeadViewHolder) viewHolder).binner.setImageLoader(new GlideImageLoader());
            ((HeadViewHolder) viewHolder).binner.start();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return HEAD;
        } else {
            return CONTENT;
        }
    }

    @Override
    public int getItemCount() {
        return list.size() + 1;
    }

    /**
     * 头布局的viewHolder
     *
     * @date 2019-01-11
     */
    static class HeadViewHolder extends BaseRecyclerViewHolder {

        @BindView(R.id.banner)
        Banner binner;

        public HeadViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    /**
     * 引入banner图片资源
     *
     * @param bannerData bannerData
     * @return void
     * @date 2019-01-11
     */
    public void setBannerData(BannerData bannerData) {
        this.bannerData = bannerData;
    }

    /**
     * 内容布局的viewHolder
     *
     * @date 2019-01-11
     */
    static class ContentViewHolder extends BaseRecyclerViewHolder {
        @BindView(R.id.iv_image)
        ImageView imageView;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_content)
        TextView tvContent;

        public ContentViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
