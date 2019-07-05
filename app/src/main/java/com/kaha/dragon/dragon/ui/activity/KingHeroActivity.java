package com.kaha.dragon.dragon.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kaha.dragon.R;
import com.kaha.dragon.data.KingHeroData;
import com.kaha.dragon.dragon.entity.KingHero;
import com.kaha.dragon.dragon.ui.adapter.KingHeroAdapter;
import com.kaha.dragon.dragon.widget.CustomGridLayoutManager;
import com.kaha.dragon.framework.ui.activity.BaseActivity;
import com.kaha.dragon.framework.widget.TopView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 展示王者荣耀的界面
 *
 * @author Darcy
 * @Date 2019/7/4
 * @package com.kaha.dragon.dragon.ui.activity
 * @Desciption
 */
public class KingHeroActivity extends BaseActivity {


    @BindView(R.id.topView)
    TopView topView;
    @BindView(R.id.rvHero)
    RecyclerView rvHero;
    private KingHeroAdapter kingHeroAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_king_hero;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        topView.setTitle("王者荣耀");
        initHeroRecycleView();
    }

    List<KingHero> kingHeroes = new ArrayList<>();

    //初始化农药的recycleView
    private void initHeroRecycleView() {
        GridLayoutManager manager = new GridLayoutManager(context, 1);
        rvHero.setLayoutManager(manager);
        kingHeroAdapter = new KingHeroAdapter(context, null);
        rvHero.setAdapter(kingHeroAdapter);
        List<Integer> kingHeroBigPic = KingHeroData.getKingHeroBigPic();
        List<String> kingHeroDes = KingHeroData.getKingHeroDes();
        List<Integer> kingHeroHead = KingHeroData.getKingHeroHead();
        List<String> names = KingHeroData.getNames();
        List<String> kingHeroWord = KingHeroData.getKingHeroWord();
        kingHeroes.clear();
        for (int i = 0; i < kingHeroBigPic.size(); i++) {
            KingHero kingHero = new KingHero(kingHeroHead.get(i), names.get(i),
                    kingHeroDes.get(i), kingHeroBigPic.get(i),kingHeroWord.get(i));
            kingHeroes.add(kingHero);
        }

        kingHeroAdapter.updateData(kingHeroes);

    }
}
