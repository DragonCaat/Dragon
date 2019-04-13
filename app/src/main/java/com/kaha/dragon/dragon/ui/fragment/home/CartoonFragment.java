package com.kaha.dragon.dragon.ui.fragment.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kaha.dragon.R;
import com.kaha.dragon.data.CartoonData;
import com.kaha.dragon.dragon.entity.Cartoon;
import com.kaha.dragon.dragon.ui.adapter.home.CartoonAdapter;
import com.kaha.dragon.framework.ui.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * cartoon fragment
 * <b>
 * 生活不止眼前的苟且，还有诗和远方
 * <p>
 * beer，honeybee
 * </b>
 *
 * @author Darcy
 * @Date 2019/1/21
 * @package com.kaha.dragon.dragon.ui.fragment.home
 * @Desciption
 */
public class CartoonFragment extends BaseFragment {
    @BindView(R.id.recycleView)
    RecyclerView recyclerView;
    //卡通适配器
    private CartoonAdapter adapter;
    //卡通的数据源
    private List<Cartoon> list;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_cartoon;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        initRecycleView();
    }

    /**
     * 初始化recycleView
     *
     * @param ,
     * @return void
     * @date 2019-01-29
     */
    private void initRecycleView() {
        recyclerView.setLayoutManager(new GridLayoutManager(context, 1));
        adapter = new CartoonAdapter(context, null);
        recyclerView.setAdapter(adapter);
        adapter.updateData(list);
    }

    /**
     * 初始化数据
     *
     * @param ，
     * @return void
     * @date 2019-01-29
     */
    private void initData() {
        List<Integer> imageList = CartoonData.getCartoonImages();
        List<String> nameList = CartoonData.getNames();
        List<String> desList = CartoonData.getCartDesList();
        list = new ArrayList<>();
        for (int i = 0; i < imageList.size(); i++) {
            list.add(new Cartoon(imageList.get(i), nameList.get(i),desList.get(i)));
        }
    }
}
