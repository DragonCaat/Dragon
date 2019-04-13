package com.kaha.dragon.data;

import com.kaha.dragon.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 热门推荐数据
 *
 * @author Darcy
 * @Date 2019/4/12
 * @package com.kaha.dragon.data
 * @Desciption
 */
public class HotPicData {

    private static List<Integer> imageList = new ArrayList<>();

    private static List<Integer> headList = new ArrayList<>();

    private static List<String> nickList = new ArrayList<>();


    /**
     * 获取图片数组
     *
     * @param ,
     * @return List<Integer>
     * @date 2019-04-12
     */
    public static List<Integer> getImagList() {
        imageList.clear();

        imageList.add(R.mipmap.girl0);
        imageList.add(R.mipmap.girl2);
        imageList.add(R.mipmap.girl3);
        imageList.add(R.mipmap.girl4);
        imageList.add(R.mipmap.girl13);
        imageList.add(R.mipmap.girl5);
        imageList.add(R.mipmap.girl6);
        imageList.add(R.mipmap.girl7);
        imageList.add(R.mipmap.girl8);
        imageList.add(R.mipmap.girl9);
        imageList.add(R.mipmap.girl10);
        imageList.add(R.mipmap.girl11);
        imageList.add(R.mipmap.girl12);
        return imageList;
    }

    /**
     * 获取昵称数组
     *
     * @param ,
     * @return List<String>
     * @date 2019-04-12
     */
    public static List<String> getNickList() {
        nickList.clear();
        nickList.add("简书");
        nickList.add("知乎");
        nickList.add("贴吧");
        nickList.add("牛客");
        nickList.add("片刻");
        nickList.add("京东");
        nickList.add("美团");
        nickList.add("迅雷");
        nickList.add("微视");
        nickList.add("抖音");
        nickList.add("支付宝");
        nickList.add("优酷");
        nickList.add("美团");
        return nickList;
    }

    public static List<Integer> getHeadList() {
        headList.clear();

        headList.add(R.mipmap.jianshu);
        headList.add(R.mipmap.zhihu);
        headList.add(R.mipmap.tieba);
        headList.add(R.mipmap.niuke);
        headList.add(R.mipmap.pianke);
        headList.add(R.mipmap.jingdong);
        headList.add(R.mipmap.meituan);
        headList.add(R.mipmap.xunlei);
        headList.add(R.mipmap.weishi);
        headList.add(R.mipmap.douyin);
        headList.add(R.mipmap.zhifubao);
        headList.add(R.mipmap.youku);
        headList.add(R.mipmap.meituan);
        return headList;
    }
}
