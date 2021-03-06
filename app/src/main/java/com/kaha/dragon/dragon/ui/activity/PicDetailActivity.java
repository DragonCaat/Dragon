package com.kaha.dragon.dragon.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.kaha.dragon.R;
import com.kaha.dragon.dragon.base.AppConst;
import com.kaha.dragon.dragon.entity.Community;
import com.kaha.dragon.dragon.widget.ViewPagerBinner;
import com.kaha.dragon.dragon.widget.dialog.SharedDialog;
import com.kaha.dragon.framework.ui.activity.BaseActivity;
import com.kaha.dragon.framework.widget.TopView;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 美图的详情页面
 *
 * @author Darcy
 * @Date 2019/1/10
 * @package com.kaha.dragon.dragon.ui.activity
 * @Desciption
 */
public class PicDetailActivity extends BaseActivity {

    @BindView(R.id.topView)
    TopView topView;
    @BindView(R.id.viewPager_banner)
    ViewPagerBinner viewPagerBinner;

    @BindView(R.id.cv_head)
    CircleImageView cvHead;
    @BindView(R.id.tv_nickName)
    TextView tvNickName;

    //传递过来的美图数据
    private Community community;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_pic_detail;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        community = (Community) getIntent().getSerializableExtra(AppConst.KEY_2);
        setUiData();
    }


    @OnClick({R.id.ll_shared})
    public void onClick(View view) {
        switch (view.getId()) {
            //分享
            case R.id.ll_shared:
                new SharedDialog(activity) {
                    @Override
                    public void wxShared() {

                    }

                    @Override
                    public void wxZoneShared() {

                    }
                }.show();
                break;
        }
    }

    /**
     * 设置ui数据
     *
     * @param ,
     * @return void
     * @date 2019-01-10
     */
    private void setUiData() {
        if (community != null) {
            List<Integer> imageList = community.getImageList();
            if (imageList.size() == 2) {
                imageList.addAll(community.getImageList());
            } else if (imageList.size() == 1) {
                imageList.addAll(community.getImageList());
                imageList.addAll(community.getImageList());
            }
            viewPagerBinner.setImages(community.getImageList(), context);
            cvHead.setImageResource(community.getHead());
            tvNickName.setText(community.getNick());
            topView.setTitle(community.getNick());
        }
    }
}
