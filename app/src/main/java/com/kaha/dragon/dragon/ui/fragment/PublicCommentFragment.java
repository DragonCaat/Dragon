package com.kaha.dragon.dragon.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.BaseAdapter;

import com.kaha.dragon.R;
import com.kaha.dragon.dragon.entity.Mine;
import com.kaha.dragon.dragon.ui.adapter.MineAdapter;
import com.kaha.dragon.framework.ui.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 大众，公有的评论
 *
 * @author Darcy
 * @Date 2019/4/11
 * @package com.kaha.dragon.dragon.ui.fragment
 * @Desciption
 */
public class PublicCommentFragment extends BaseFragment {

    @BindView(R.id.rv_public_comment)
    RecyclerView rvPublicComment;

    private MineAdapter adapter;
    private List<Mine> list = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_public_comment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

    private void init(){
        for (int i = 0; i < 3; i++) {
            list.add(new Mine());
        }
        rvPublicComment.setLayoutManager(new GridLayoutManager(context, 1));
        adapter = new MineAdapter(context, null);
        rvPublicComment.setAdapter(adapter);
        adapter.updateData(list);
    }
}
