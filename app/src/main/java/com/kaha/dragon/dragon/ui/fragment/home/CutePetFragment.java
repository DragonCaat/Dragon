package com.kaha.dragon.dragon.ui.fragment.home;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.kaha.dragon.R;
import com.kaha.dragon.framework.ui.fragment.BaseFragment;

/**
 * 萌宠的fragment
 *
 * @author Darcy
 * @Date 2019/4/16
 * @package com.kaha.dragon.dragon.ui.fragment.home
 * @Desciption
 */
public class CutePetFragment extends BaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_cute_pet;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
