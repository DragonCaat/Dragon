package com.kaha.dragon.dragon.ui.fragment.circle;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kaha.dragon.R;
import com.kaha.dragon.data.HotPicData;
import com.kaha.dragon.dragon.entity.Community;
import com.kaha.dragon.dragon.entity.RecPeople;
import com.kaha.dragon.dragon.ui.adapter.circle.RecPeopleAdapter;
import com.kaha.dragon.framework.ui.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;

/**
 * 圈子推荐朋友的fragment
 *
 * @author Darcy
 * @Date 2019/4/12
 * @package com.kaha.dragon.dragon.ui.fragment.circle
 * @Desciption
 */
public class RecPeopleFragment extends BaseFragment {

    @BindView(R.id.recycleView)
    RecyclerView recyclerView;

    //适配器
    private RecPeopleAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recommend_people;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initRecycleView();
    }

    private void initRecycleView() {
        recyclerView.setLayoutManager(new GridLayoutManager(context, 1));
        adapter = new RecPeopleAdapter(context, null);
        recyclerView.setAdapter(adapter);

        List<String> nickList = HotPicData.getNickList();
        List<Integer> headList = HotPicData.getImagList();
        Random random = new Random();
        List<RecPeople> list = new ArrayList<>();
        for (int i = 0; i < nickList.size(); i++) {
            //int j = random.nextInt(10);
            list.add(new RecPeople(headList.get(i), nickList.get(i), "" + random.nextInt(20) + 3000));
        }

        adapter.updateData(list);
    }
}
