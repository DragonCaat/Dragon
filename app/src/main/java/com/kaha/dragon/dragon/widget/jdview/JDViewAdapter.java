package com.kaha.dragon.dragon.widget.jdview;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.kaha.dragon.R;

import java.util.List;

/**
 * 京东广告适配器
 * <p>
 * 来自：https://www.jb51.net/article/81207.htm
 * </p>
 *
 * @author Darcy
 * @Date 2019/7/3
 * @package com.kaha.dragon.dragon.widget.jdview
 * @Desciption
 */
public class JDViewAdapter {
    private List<AdverNotice> mDatas;

    public JDViewAdapter(List<AdverNotice> mDatas) {
        this.mDatas = mDatas;
        if (mDatas == null || mDatas.isEmpty()) {
            throw new RuntimeException("nothing to show");
        }
    }

    /**
     * 获取数据的条数
     *
     * @return
     */
    public int getCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    /**
     * 获取摸个数据
     *
     * @param position
     * @return
     */
    public AdverNotice getItem(int position) {
        return mDatas.get(position);
    }

    /**
     * 获取条目布局
     *
     * @param parent
     * @return
     */
    public View getView(JDAdverView parent) {
        return LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_jd_view, null);
    }

    /**
     * 条目数据适配
     *
     * @param view
     * @param data
     */
    public void setItem(final View view, final AdverNotice data) {
        TextView tv = (TextView) view.findViewById(R.id.title);
        tv.setText(data.getTitle());
        TextView tag = (TextView) view.findViewById(R.id.tag);
        tag.setText(data.getUrl());
        //你可以增加点击事件
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //比如打开url
                Toast.makeText(view.getContext(), data.getUrl(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
