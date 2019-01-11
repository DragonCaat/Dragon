package com.kaha.dragon.dragon.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.kaha.dragon.R;
import com.kaha.dragon.framework.ui.fragment.BaseFragment;
import com.kaha.dragon.framework.widget.TopView;

import butterknife.BindView;

/**
 * 首页的fragment
 *
 * @author Darcy
 * @Date 2019/1/4
 * @package com.kaha.dragon.dragon.ui
 * @Desciption
 */
public class HomeFragment extends BaseFragment {

    @BindView(R.id.home_recycleView)
    RecyclerView homeRecycleView;
    @BindView(R.id.topView)
    TopView topView;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        topView.setTitle("首页");
        topView.setLeftVisb(false);
    }
}
