package com.kaha.dragon.dragon.ui.fragment.home;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.kaha.dragon.R;
import com.kaha.dragon.dragon.widget.dialog.SharedDialog;
import com.kaha.dragon.framework.ui.fragment.BaseFragment;

import butterknife.OnClick;

/**
 * 首页关注的fragment
 *
 * @author Darcy
 * @Date 2019/4/12
 * @package com.kaha.dragon.dragon.ui.fragment.home
 * @Desciption
 */
public class FollowFragment extends BaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_follow;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @OnClick({R.id.tv_follow})
    public void onClick(){
        new SharedDialog(activity) {
            @Override
            public void wxShared() {

            }

            @Override
            public void wxZoneShared() {

            }
        }.show();
    }
}
