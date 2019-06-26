package com.kaha.dragon.dragon.ui.fragment.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kaha.dragon.R;
import com.kaha.dragon.dragon.utils.EchelonLayoutManager;
import com.kaha.dragon.framework.ui.fragment.BaseFragment;

import butterknife.BindView;

/**
 * @author Darcy
 * @Date 2019/1/22
 * @package com.kaha.dragon.dragon.ui.fragment.home
 * @Desciption
 */
public class EchelonFragment extends BaseFragment {

    @BindView(R.id.recycler_view)
    RecyclerView  recyclerView;

    //EchelonLayoutManager mLayoutManager;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_echelon;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData() {
       GridLayoutManager mLayoutManager = new GridLayoutManager(context,1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(new MyAdapter());
    }


    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
        private int[] icons = {R.mipmap.huzhao,R.mipmap.ting,R.mipmap.yanzhu,R.mipmap.zhangcheng,R.mipmap.lila,R.mipmap.head};
        private int[] bgs = {R.mipmap.huzhao1,R.mipmap.ting1,R.mipmap.yanzhu1,R.mipmap.zhangcheng1,R.mipmap.lila1,R.mipmap.sea};
        private String[] nickNames = {"左耳近心","凉雨初夏","稚久九栀","半窗疏影","夏奈淡雅","月夜微风"};
        private String[] descs = {
                "回不去的地方叫故乡 没有根的迁徙叫流浪...",
                "人生就像迷宫，我们用上半生找寻入口，用下半生找寻出口",
                "原来地久天长，只是误会一场",
                "不是故事的结局不够好，而是我们对故事的要求过多",
                "只想优雅转身，不料华丽撞墙",
                "只有频率相同的人，才能看见彼此内心深处不为人知的优雅",
                "切忌苦苦哀求死缠烂打，否则败的不仅是处事方面，还有自身的格局与尊严"
        };
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_echelon_item,parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            holder.icon.setImageResource(icons[position]);
            holder.nickName.setText(nickNames[position]);
            holder.desc.setText(descs[position]);
            holder.bg.setImageResource(bgs[position]);
        }

        @Override
        public int getItemCount() {
            return icons.length;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            ImageView icon;
            ImageView bg;
            TextView nickName;
            TextView desc;
            public ViewHolder(View itemView) {
                super(itemView);
                icon = itemView.findViewById(R.id.img_icon);
                bg = itemView.findViewById(R.id.img_bg);
                nickName = itemView.findViewById(R.id.tv_nickname);
                desc = itemView.findViewById(R.id.tv_desc);
            }
        }
    }
}
