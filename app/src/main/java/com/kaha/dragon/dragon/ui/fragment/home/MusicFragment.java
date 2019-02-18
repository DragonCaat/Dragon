package com.kaha.dragon.dragon.ui.fragment.home;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.kaha.dragon.R;
import com.kaha.dragon.framework.ui.fragment.BaseFragment;

import butterknife.BindView;
import co.mobiwise.library.MusicPlayerView;

/**
 * 音乐播放的fragment
 *
 * @author Darcy
 * @Date 2019/1/30
 * @package com.kaha.dragon.dragon.ui.fragment.home
 * @Desciption
 */
public class MusicFragment extends BaseFragment {
    @BindView(R.id.mpv)
    MusicPlayerView mpv;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_music;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mpv.setButtonColor(Color.DKGRAY);
        mpv.setCoverDrawable(R.mipmap.mycover);
        mpv.setProgressEmptyColor(Color.GRAY);
        mpv.setProgressLoadedColor(Color.BLUE);
        mpv.setTimeColor(Color.WHITE);

        mpv.setCoverURL("http://music.163.com/song/media/outer/url?id=476592630.mp3");
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            mpv.start();
        } else {
            mpv.stop();
        }
    }
}
