package com.kaha.dragon.data;

import com.kaha.dragon.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Darcy
 * @Date 2019/1/21
 * @package com.kaha.dragon.data
 * @Desciption
 */
public class CartoonData {

    private static List<String> cartoonNames = new ArrayList<>();

    private static List<Integer> cartoonImages = new ArrayList<>();

    private List<String> cartoonDes = new ArrayList<>();

    /**
     * 获取卡通的名字实体类
     *
     * @param ，
     * @return List<String> 描述的集合
     * @date 2019-01-07
     */
    public static List<String> getNames() {
        cartoonNames.add("101忠狗");
        cartoonNames.add("狡猾飞天德");
        cartoonNames.add("阿拉丁");
        cartoonNames.add("彭彭丁满历险记");
        cartoonNames.add("波波安");
        cartoonNames.add("大力士海格力斯");
        cartoonNames.add("下课后");
        cartoonNames.add("水獭小宝贝");
        cartoonNames.add("泰山");
        return cartoonNames;
    }

    /**
     * 卡通图片
     *
     * @param ,
     * @return List<Integer>
     * @date 2019-01-21
     */
    public static List<Integer> getCartoonImages() {
        cartoonImages.add(R.mipmap.dog);
        cartoonImages.add(R.mipmap.feitiande);
        cartoonImages.add(R.mipmap.alading);
        cartoonImages.add(R.mipmap.pengpengdingman);
        cartoonImages.add(R.mipmap.boboan);
        cartoonImages.add(R.mipmap.dalishi);
        cartoonImages.add(R.mipmap.xiakehou);
        cartoonImages.add(R.mipmap.shuita);
        cartoonImages.add(R.mipmap.taishan);

        return cartoonImages;
    }

}
