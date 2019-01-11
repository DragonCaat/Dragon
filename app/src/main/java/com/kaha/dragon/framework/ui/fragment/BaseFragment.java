package com.kaha.dragon.framework.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.kaha.dragon.framework.utils.LogUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * fragment_local 基类
 *
 * @author Darcy
 * @Date 2018/12/10
 * @package com.darcy.pet.trunk.framework.ui
 * @Desciption
 */
public abstract class BaseFragment extends Fragment {

    protected String tag;

    protected Context context;
    protected Activity activity;

    private Unbinder unbinder;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        tag = this.getClass().getSimpleName();
        this.context = context;
        this.activity = getActivity();
        LogUtils.d(tag, "onAttach()");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.d(tag, "onCreate()");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        LogUtils.d(tag, "onCreateView()");
        View view = inflater.inflate(getLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, view);//绑定framgent
        return view;
    }

    protected abstract int getLayoutId();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LogUtils.d(tag, "onActivityCreated()");
    }

    @Override
    public void onStart() {
        super.onStart();
        LogUtils.d(tag, "onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtils.d(tag, "onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        LogUtils.d(tag, "onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        LogUtils.d(tag, "onStop()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtils.d(tag, "onDestroy()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        LogUtils.d(tag, "onDestroyView()");
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        LogUtils.d(tag, "onDetach()");
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (null == tag) {
            tag = this.getClass().getSimpleName();
        }
        LogUtils.d(tag, "setUserVisibleHint(" + isVisibleToUser + ")");
    }

    /**
     * 跳转界面
     *
     * @param cls 要跳转的activity
     * @return void
     * @date 2018-12-10
     */
    public void skipPage(Class<? extends Activity> cls) {
        Intent intent = new Intent(getActivity(), cls);
        startActivity(intent);
    }
}
